package com.algolia.client.dsl.live.testkit

import com.algolia.client.api.SearchClient
import com.algolia.client.dsl.cases.DeleteCase
import com.algolia.client.dsl.cases.Expect
import com.algolia.client.dsl.cases.LiveCase
import com.algolia.client.dsl.cases.json
import com.algolia.client.dsl.cases.wire
import com.algolia.client.exception.AlgoliaApiException
import com.algolia.client.extensions.saveObjects
import com.algolia.client.extensions.waitForTask
import com.algolia.client.model.search.OperationIndexParams
import com.algolia.client.model.search.OperationType
import io.github.cdimascio.dotenv.Dotenv
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

private const val APP_ID_ENV = "ALGOLIA_APPLICATION_ID"
private const val ADMIN_KEY_ENV = "ALGOLIA_ADMIN_KEY"
private const val LIVE_PROPERTY = "algolia.dsl.live"
private const val REPO_ROOT_PROPERTY = "algolia.repoRoot"
private const val INDEX_PREFIX = "kotlin_dsl_live_"
private const val LOG_PREFIX = "[kotlin-dsl-live]"
private const val JANITOR_HITS_PER_PAGE = 100
private const val JANITOR_MAX_PAGES = 1_000
private const val JANITOR_MAX_AGE_SECONDS: Long = 24 * 60 * 60

/** Matches every index this kit creates; group 1 is the creation epoch in seconds. */
private val INDEX_EPOCH = Regex("^kotlin_dsl_live_(\\d+)_")

private val WRITE_TIMEOUT: Duration = 60.seconds
private val SETUP_TIMEOUT: Duration = 180.seconds
private val CLOSE_TIMEOUT: Duration = 30.seconds

/**
 * Resolves the application id and admin key the live tests run with.
 * - With `CI=true`: from the process environment only, like the generated e2e tests.
 * - Otherwise: from the repo-root `.env` file (the root is passed by the live Gradle task as
 *   `algolia.repoRoot`). A key declared in the file wins over an exported environment variable of
 *   the same name; the environment is only read for keys the file does not declare (or when the
 *   file is missing).
 *
 * Values are never logged.
 */
internal object LiveCredentials {
  fun load(): Pair<String, String> {
    val repoRoot: String? = System.getProperty(REPO_ROOT_PROPERTY)
    val appId: String?
    val apiKey: String?
    if (System.getenv("CI") == "true") {
      appId = System.getenv(APP_ID_ENV)
      apiKey = System.getenv(ADMIN_KEY_ENV)
    } else {
      checkNotNull(repoRoot) {
        "Kotlin DSL live tests must run through the Gradle live task (jvmDslLiveTest): " +
          "system property `$REPO_ROOT_PROPERTY` is not set."
      }
      val fromFile =
        Dotenv.configure()
          .directory(repoRoot)
          .ignoreIfMissing()
          .load()
          .entries(Dotenv.Filter.DECLARED_IN_ENV_FILE)
          .associate { it.key to it.value }
      appId = fromFile[APP_ID_ENV] ?: System.getenv(APP_ID_ENV)
      apiKey = fromFile[ADMIN_KEY_ENV] ?: System.getenv(ADMIN_KEY_ENV)
    }
    if (appId.isNullOrBlank() || apiKey.isNullOrBlank()) {
      throw IllegalStateException(
        "Kotlin DSL live tests need $APP_ID_ENV and $ADMIN_KEY_ENV: export them with CI=true, " +
          "or put them in ${repoRoot ?: "<repoRoot>"}/.env. " +
          "Skip live tests with `yarn cli cts run kotlin --no-e2e`."
      )
    }
    return appId to apiKey
  }
}

/**
 * One uniquely named fixture index on the live application, filled with [FIXTURE_SETTINGS],
 * [FIXTURE_RECORDS] and [FIXTURE_RULE]. Test classes create it in `@BeforeClass` and [close] it in
 * `@AfterClass`. Delete-by cases run on a per-test copy ([withCopy]).
 */
internal class LiveIndex private constructor(val client: SearchClient, val name: String) :
  AutoCloseable {

  companion object {
    /**
     * Blocking. Refuses to start unless the live Gradle task set `algolia.dsl.live`, loads the
     * credentials, deletes stale `kotlin_dsl_live_*` indices, then creates and fills the index. If
     * any step fails the index is deleted before the error propagates.
     */
    fun create(purpose: String): LiveIndex {
      check(System.getProperty(LIVE_PROPERTY) == "true") {
        "Kotlin DSL live tests only run through the Gradle live task (jvmDslLiveTest): " +
          "system property `$LIVE_PROPERTY` is not \"true\"."
      }
      val (appId, apiKey) = LiveCredentials.load()
      val client = SearchClient(appId = appId, apiKey = apiKey)
      val index = LiveIndex(client, indexName(purpose))
      println("$LOG_PREFIX creating ${index.name}")
      try {
        runBlocking {
          withTimeout(SETUP_TIMEOUT) {
            janitor(client)
            index.populate()
          }
        }
      } catch (e: Throwable) {
        index.close()
        throw e
      }
      println("$LOG_PREFIX ready ${index.name}")
      return index
    }

    /** `kotlin_dsl_live_<epochSeconds>_<6 random hex>_<purpose>`: unique per run and per retry. */
    private fun indexName(purpose: String): String {
      val epoch = System.currentTimeMillis() / 1000
      val hex = Random.nextInt(0, 0x1000000).toString(16).padStart(6, '0')
      return "$INDEX_PREFIX${epoch}_${hex}_$purpose"
    }

    /**
     * Deletes indices of this kit older than 24 h (leaked by killed JVMs). Every page is listed
     * before the first deletion: deleting while paging shifts later indices onto pages already
     * read. Errors are logged.
     */
    private suspend fun janitor(client: SearchClient) {
      val cutoff = System.currentTimeMillis() / 1000 - JANITOR_MAX_AGE_SECONDS
      logged("janitor") {
        val stale = mutableListOf<String>()
        var page = 0
        while (true) {
          if (page >= JANITOR_MAX_PAGES) {
            println("$LOG_PREFIX janitor stopped listing after $JANITOR_MAX_PAGES pages")
            break
          }
          val listing = client.listIndices(page = page, hitsPerPage = JANITOR_HITS_PER_PAGE)
          for (index in listing.items) {
            val epoch =
              INDEX_EPOCH.find(index.name)?.groupValues?.get(1)?.toLongOrNull() ?: continue
            if (epoch < cutoff) stale += index.name
          }
          page++
          if (listing.items.size < JANITOR_HITS_PER_PAGE) break
          if (listing.nbPages?.let { page >= it } == true) break
        }
        for (name in stale) {
          logged("janitor delete of $name") {
            client.deleteIndex(name)
            println("$LOG_PREFIX janitor deleted stale $name")
          }
        }
      }
    }
  }

  private suspend fun populate() {
    val settings = client.setSettings(name, FIXTURE_SETTINGS)
    client.waitForTask(name, settings.taskID, timeout = WRITE_TIMEOUT)
    client.saveObjects(name, FIXTURE_RECORDS, waitForTasks = true)
    val rule = client.saveRule(name, FIXTURE_RULE.objectID, FIXTURE_RULE)
    client.waitForTask(name, rule.taskID, timeout = WRITE_TIMEOUT)
  }

  /** Raw query: the response keeps every field the engine returned. */
  suspend fun query(params: JsonObject): JsonObject =
    client.customPost("1/indexes/$name/query", body = params)

  /**
   * Copies this index (records, settings, rule) to a fresh `kotlin_dsl_live_*_<purpose>` index,
   * runs [block] on the copy and deletes the copy afterwards, whatever happened.
   */
  suspend fun <T> withCopy(purpose: String, block: suspend (LiveIndex) -> T): T {
    val copy = LiveIndex(client, indexName(purpose))
    println("$LOG_PREFIX copying $name to ${copy.name}")
    try {
      val task =
        client.operationIndex(
          name,
          OperationIndexParams(operation = OperationType.Copy, destination = copy.name),
        )
      client.waitForTask(copy.name, task.taskID, timeout = WRITE_TIMEOUT)
      return block(copy)
    } finally {
      withContext(NonCancellable) { copy.delete() }
    }
  }

  /** The objectIDs currently in the index, read with a raw `{"hitsPerPage":100}` query. */
  suspend fun remainingIds(): Set<String> =
    query(json("""{"hitsPerPage":100}""")).hits().map { it.objectID() }.toSet()

  /** Blocking. Deletes the index and waits for the deletion; errors are logged, never thrown. */
  override fun close() {
    runBlocking { delete() }
  }

  private suspend fun delete() {
    logged("delete of $name") {
      val task = client.deleteIndex(name)
      client.waitForTask(name, task.taskID, timeout = CLOSE_TIMEOUT)
      println("$LOG_PREFIX deleted $name")
    }
  }
}

/**
 * Runs a live test body: `runBlocking` + `withTimeout`, never `runTest`, because `runTest` skips
 * `delay` and would turn `waitForTask`'s backoff into a hot loop.
 */
internal fun live(timeout: Duration = 60.seconds, block: suspend CoroutineScope.() -> Unit): Unit =
  runBlocking {
    withTimeout(timeout) { block() }
  }

/**
 * Runs the live half of [case] against this index. A case with a DSL half first re-checks that the
 * DSL serializes to the expected body (the offline `DslWireTest` check), so the encoder and the
 * engine evidence are asserted on the same bytes; the expected body is then sent raw.
 */
internal suspend fun LiveIndex.assertCase(case: LiveCase) {
  val params = json(case.body)
  case.dsl?.let { dsl ->
    assertEquals(params, wire(dsl()), "DSL wire differs from the expected body")
  }
  val rejected = case.expect.filterIsInstance<Expect.Rejected>()
  if (rejected.isNotEmpty()) {
    val expected = rejected.single()
    val e = assertFailsWith<AlgoliaApiException>("the engine must reject $params") { query(params) }
    assertEquals(expected.status, e.httpErrorCode, "HTTP status of the rejection (${e.message})")
    assertTrue(
      e.message.orEmpty().contains(expected.phrase),
      "engine wording changed; update the phrase. Expected \"${expected.phrase}\" in: ${e.message}",
    )
    return
  }
  val response = query(params)
  case.expect.forEach { checkExpect(response, it) }
}

/**
 * Runs a delete-by [case] on a copy of this index: the DSL half must serialize to the expected
 * body, then [delete] performs the deletion on the copy and returns its task id; the objectIDs left
 * in the copy must equal the case's `remaining`.
 */
internal suspend fun LiveIndex.assertDelete(
  case: DeleteCase,
  delete: suspend (copy: LiveIndex) -> Long,
) {
  assertEquals(json(case.body), wire(case.dsl()), "DSL wire differs from the expected body")
  withCopy("delete") { copy ->
    val taskID = delete(copy)
    copy.client.waitForTask(copy.name, taskID, timeout = WRITE_TIMEOUT)
    assertEquals(case.remaining, copy.remainingIds(), "objectIDs remaining after deleteBy")
  }
}

private fun checkExpect(response: JsonObject, expect: Expect) {
  when (expect) {
    is Expect.Hits ->
      assertEquals(expect.ids, response.hits().map { it.objectID() }.toSet(), "hits")
    is Expect.FirstHits ->
      assertEquals(
        expect.ids,
        response.hits().take(expect.ids.size).map { it.objectID() }.toSet(),
        "first ${expect.ids.size} hits",
      )
    is Expect.Scores -> {
      val scores = response.hits().associate { it.objectID() to it.rankingFilters() }
      expect.byId.forEach { (objectID, score) ->
        assertEquals(
          score,
          scores[objectID],
          "_rankingInfo.filters of $objectID (hits: ${scores.keys})",
        )
      }
      expect.others?.let { others ->
        scores
          .filterKeys { it !in expect.byId }
          .forEach { (objectID, score) ->
            assertEquals(others, score, "_rankingInfo.filters of unlisted hit $objectID")
          }
      }
    }
    is Expect.NbHits -> assertEquals(expect.n, response["nbHits"]?.jsonPrimitive?.int, "nbHits")
    is Expect.HitCount -> assertEquals(expect.n, response.hits().size, "number of hits")
    is Expect.Keys -> assertEquals(expect.keys, response.keys, "top-level response keys")
    is Expect.HasKey ->
      assertTrue(expect.key in response, "response has no `${expect.key}` (keys: ${response.keys})")
    is Expect.Absent ->
      assertFalse(expect.key in response, "response must not contain `${expect.key}`")
    is Expect.EveryHitHasKey ->
      response.hits().forEach { hit ->
        assertTrue(expect.key in hit, "hit ${hit.objectID()} has no `${expect.key}`")
      }
    is Expect.HighlightKeys ->
      response.hits().forEach { hit ->
        assertEquals(
          expect.keys,
          hit["_highlightResult"]?.jsonObject?.keys,
          "_highlightResult keys of hit ${hit.objectID()}",
        )
      }
    is Expect.HitKeys ->
      response.hits().forEach { hit ->
        assertEquals(
          expect.keys,
          hit.keys.filterNot { it.startsWith("_") }.toSet(),
          "attributes of hit ${hit.objectID()}",
        )
      }
    is Expect.UserData -> assertEquals<JsonElement?>(expect.value, response["userData"], "userData")
    is Expect.Rejected -> fail("Rejected cases never reach a response")
  }
}

private fun JsonObject.hits(): List<JsonObject> =
  (this["hits"] ?: fail("response has no `hits` (keys: $keys)")).jsonArray.map { it.jsonObject }

private fun JsonObject.objectID(): String =
  this["objectID"]?.jsonPrimitive?.content ?: "<no objectID>"

private fun JsonObject.rankingFilters(): Int? =
  this["_rankingInfo"]?.jsonObject?.get("filters")?.jsonPrimitive?.int

/** Runs [block]; logs any failure instead of throwing it. Cancellation still propagates. */
private inline fun logged(what: String, block: () -> Unit) {
  try {
    block()
  } catch (e: CancellationException) {
    throw e
  } catch (e: Exception) {
    println("$LOG_PREFIX $what failed: ${e.message}")
  }
}

package com.algolia.client.dsl.testkit

import com.algolia.client.api.SearchClient
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
private const val JANITOR_MAX_PAGES = 10
private const val JANITOR_MAX_AGE_SECONDS: Long = 24 * 60 * 60

/** Matches every index this kit creates; group 1 is the creation epoch in seconds. */
private val INDEX_EPOCH = Regex("^kotlin_dsl_live_(\\d+)_")

private val WRITE_TIMEOUT: Duration = 60.seconds
private val SETUP_TIMEOUT: Duration = 180.seconds
private val CLOSE_TIMEOUT: Duration = 30.seconds

/**
 * Resolves the application id and admin key the live tests run with. Same convention as the
 * generated e2e tests: with `CI=true` the values come from the environment, otherwise from the
 * repo-root `.env` (the root is passed by the live Gradle tasks as `algolia.repoRoot`). Values are
 * never logged.
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
        "Kotlin DSL live tests must run through the Gradle live tasks (jvmDslP<n>LiveTest): " +
          "system property `$REPO_ROOT_PROPERTY` is not set."
      }
      val dotenv = Dotenv.configure().directory(repoRoot).ignoreIfMissing().load()
      appId = dotenv[APP_ID_ENV]
      apiKey = dotenv[ADMIN_KEY_ENV]
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
 * `@AfterClass`. Delete-by rows run on a per-test copy ([withCopy]).
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
        "Kotlin DSL live tests only run through the Gradle live tasks (jvmDslP<n>LiveTest): " +
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

    /** Deletes indices of this kit older than 24 h (leaked by killed JVMs). Errors are logged. */
    private suspend fun janitor(client: SearchClient) {
      val cutoff = System.currentTimeMillis() / 1000 - JANITOR_MAX_AGE_SECONDS
      logged("janitor") {
        for (page in 0 until JANITOR_MAX_PAGES) {
          val listing = client.listIndices(page = page, hitsPerPage = 100)
          for (index in listing.items) {
            val epoch =
              INDEX_EPOCH.find(index.name)?.groupValues?.get(1)?.toLongOrNull() ?: continue
            if (epoch >= cutoff) continue
            logged("janitor delete of ${index.name}") {
              client.deleteIndex(index.name)
              println("$LOG_PREFIX janitor deleted stale ${index.name}")
            }
          }
          if (page + 1 >= (listing.nbPages ?: 1)) break
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

  /** Raw query: the response keeps every field the engine returned (TD6). */
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
    query(json("""{"hitsPerPage":100}""")).hits("remainingIds").map { it.objectID() }.toSet()

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
 * `delay` and would turn `waitForTask`'s backoff into a hot loop (TD9).
 */
internal fun live(timeout: Duration = 60.seconds, block: suspend CoroutineScope.() -> Unit): Unit =
  runBlocking {
    withTimeout(timeout) { block() }
  }

/**
 * Runs the live half of a contract row against this index. [params] defaults to the row's own body;
 * DSL rows pass their serialized output instead, so the encoder and the engine evidence are checked
 * on the same bytes. Every assertion message starts with the row id.
 */
internal suspend fun LiveIndex.assertRow(row: ContractRow, params: JsonObject = row.params) {
  val rejected = row.expect.filterIsInstance<Expect.Rejected>()
  if (rejected.isNotEmpty()) {
    val expected = rejected.single()
    val e =
      assertFailsWith<AlgoliaApiException>("${row.id}: the engine must reject $params") {
        query(params)
      }
    assertEquals(
      expected.status,
      e.httpErrorCode,
      "${row.id}: HTTP status of the rejection (${e.message})",
    )
    assertTrue(
      e.message.orEmpty().contains(expected.phrase),
      "${row.id}: engine wording changed; update the phrase. " +
        "Expected \"${expected.phrase}\" in: ${e.message}",
    )
    return
  }
  val response = query(params)
  row.expect.forEach { checkExpect(row.id, response, it) }
}

/**
 * Runs a delete-by row on a copy of this index: [delete] performs the deletion on the copy and
 * returns its task id; the objectIDs left in the copy must equal the row's `remaining`.
 */
internal suspend fun LiveIndex.assertDelete(
  row: DeleteRow,
  delete: suspend (copy: LiveIndex) -> Long,
) {
  withCopy("del_${row.id}") { copy ->
    val taskID = delete(copy)
    copy.client.waitForTask(copy.name, taskID, timeout = WRITE_TIMEOUT)
    assertEquals(
      row.remaining,
      copy.remainingIds(),
      "${row.id}: objectIDs remaining after deleteBy",
    )
  }
}

private fun checkExpect(id: String, response: JsonObject, expect: Expect) {
  when (expect) {
    is Expect.Hits ->
      assertEquals(expect.ids, response.hits(id).map { it.objectID() }.toSet(), "$id: hits")
    is Expect.FirstHits ->
      assertEquals(
        expect.ids,
        response.hits(id).take(expect.ids.size).map { it.objectID() }.toSet(),
        "$id: first ${expect.ids.size} hits",
      )
    is Expect.Scores -> {
      val scores = response.hits(id).associate { it.objectID() to it.rankingFilters() }
      expect.byId.forEach { (objectID, score) ->
        assertEquals(
          score,
          scores[objectID],
          "$id: _rankingInfo.filters of $objectID (hits: ${scores.keys})",
        )
      }
      expect.others?.let { others ->
        scores
          .filterKeys { it !in expect.byId }
          .forEach { (objectID, score) ->
            assertEquals(others, score, "$id: _rankingInfo.filters of unlisted hit $objectID")
          }
      }
    }
    is Expect.NbHits ->
      assertEquals(expect.n, response["nbHits"]?.jsonPrimitive?.int, "$id: nbHits")
    is Expect.HitCount -> assertEquals(expect.n, response.hits(id).size, "$id: number of hits")
    is Expect.Keys -> assertEquals(expect.keys, response.keys, "$id: top-level response keys")
    is Expect.HasKey ->
      assertTrue(
        expect.key in response,
        "$id: response has no `${expect.key}` (keys: ${response.keys})",
      )
    is Expect.Absent ->
      assertFalse(expect.key in response, "$id: response must not contain `${expect.key}`")
    is Expect.EveryHitHasKey ->
      response.hits(id).forEach { hit ->
        assertTrue(expect.key in hit, "$id: hit ${hit.objectID()} has no `${expect.key}`")
      }
    is Expect.HighlightKeys ->
      response.hits(id).forEach { hit ->
        assertEquals(
          expect.keys,
          hit["_highlightResult"]?.jsonObject?.keys,
          "$id: _highlightResult keys of hit ${hit.objectID()}",
        )
      }
    is Expect.HitKeys ->
      response.hits(id).forEach { hit ->
        assertEquals(
          expect.keys,
          hit.keys.filterNot { it.startsWith("_") }.toSet(),
          "$id: attributes of hit ${hit.objectID()}",
        )
      }
    is Expect.UserData ->
      assertEquals<JsonElement?>(expect.value, response["userData"], "$id: userData")
    is Expect.Rejected -> fail("$id: Rejected rows never reach a response")
  }
}

private fun JsonObject.hits(id: String): List<JsonObject> =
  (this["hits"] ?: fail("$id: response has no `hits` (keys: $keys)")).jsonArray.map {
    it.jsonObject
  }

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

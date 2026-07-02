package com.algolia.client

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.ClientOptions
import com.algolia.client.extensions.browseSynonyms
import com.algolia.client.model.search.SearchSynonymsParams
import com.algolia.client.model.search.SynonymHit
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.headersOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * Regression guard for the `browseSynonyms` pagination contract (Jira CR-11727).
 *
 * The Java `browseSynonyms` helper once failed to write the incremented `page` back into the
 * request params, so it re-fetched page 0 forever (infinite loop / OOM). Kotlin's implementation is
 * correct; this test locks that behavior in by mocking the HTTP layer and asserting that
 * consecutive, distinct pages are requested until a partial page ends the iteration.
 *
 * Placed under `jvmTest` (not `commonTest`) on purpose: the client module's test classpath has no
 * coroutine runner in `commonTest` (`kotlinx-coroutines-test` is not a declared dependency, and
 * `runBlocking` is not part of the JS-less multiplatform common source set), so a self-contained
 * coroutine-driven test must live on the JVM target where `runBlocking` is available. `ktor-client-mock`
 * is a `commonTest` dependency and is inherited here.
 */
class TestBrowseSynonyms {

  private val hitsPerPage = 1000

  /** Builds a canned `SearchSynonymsResponse` body with [count] hits prefixed by [objectIdPrefix]. */
  private fun synonymsPageBody(objectIdPrefix: String, count: Int): String {
    val hits =
      (0 until count).joinToString(",") { i ->
        """{"objectID":"$objectIdPrefix-hit$i","type":"synonym"}"""
      }
    return """{"hits":[$hits],"nbHits":1003}"""
  }

  @Test
  fun browseSynonymsPaginatesUntilPartialPage() = runBlocking {
    val requestedPages = mutableListOf<Int>()
    val requestedPaths = mutableListOf<String>()

    val engine =
      MockEngine { request ->
        requestedPaths += request.url.encodedPath

        val bodyBytes =
          (request.body as? OutgoingContent.ByteArrayContent)?.bytes()
            ?: error("Unexpected request body type: ${request.body::class}")
        val page =
          Json.parseToJsonElement(bodyBytes.decodeToString())
            .jsonObject["page"]!!
            .jsonPrimitive
            .int
        requestedPages += page

        // page 0 -> a full page (1000 hits) so iteration continues.
        // page >= 1 -> a partial page (3 hits) so iteration stops.
        val content =
          if (page == 0) synonymsPageBody("page0", hitsPerPage)
          else synonymsPageBody("page$page", 3)

        respond(
          content = content,
          status = HttpStatusCode.OK,
          headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString()),
        )
      }

    val client =
      SearchClient(appId = "appId", apiKey = "apiKey", options = ClientOptions(engine = engine))

    val collected = mutableListOf<SynonymHit>()
    client.use {
      it.browseSynonyms(
        indexName = "my-index",
        searchSynonymsParams = SearchSynonymsParams(),
        aggregator = { response -> collected += response.hits },
      )
    }

    // The helper must request page 0 then page 1 (proving the incremented page is sent), and stop.
    assertEquals(listOf(0, 1), requestedPages, "browseSynonyms should request consecutive pages 0, 1")

    // Every request must target the synonyms search endpoint (page read from that POST body).
    assertTrue(
      requestedPaths.all { it.endsWith("/synonyms/search") },
      "all requests should hit /synonyms/search, got $requestedPaths",
    )

    // All hits across both pages are aggregated, with no page re-fetched (no duplicates).
    assertEquals(1003, collected.size, "aggregated hit count should be 1000 + 3")
    assertEquals(
      1003,
      collected.map { it.objectID }.toSet().size,
      "aggregated objectIDs should all be distinct (no page re-fetched)",
    )
  }
}

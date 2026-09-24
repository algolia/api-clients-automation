@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.ClientOptions
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpRequestData
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.headersOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

/**
 * HTTP-level coverage for the [SearchClient] DSL overloads: the three block overloads and the two
 * composer overloads. Browse stays on the generated method and is not covered here.
 */
internal class ClientDslTest {

  private val json = ClientOptions().json

  @Test
  fun searchSingleIndexOverload() = runTest {
    val engine =
      mockEngine("""{"hits":[]}""") { request ->
        assertEquals("/1/indexes/idx/query", request.url.encodedPath)
        assertEquals(
          Json.parseToJsonElement("""{"query":"shoes","filters":"brand:Apple"}"""),
          Json.parseToJsonElement(request.bodyText()),
        )
      }
    SearchClient("appId", "apiKey", ClientOptions(engine = engine)).use { client ->
      client.searchSingleIndex("idx") {
        query = "shoes"
        filters { facet("brand", "Apple") }
      }
    }
  }

  @Test
  fun searchSingleIndexComposerOverload() = runTest {
    val composer = DSLQueryComposer()
    composer.add { filters { facet("brand", "Apple") } }
    composer.override { hitsPerPage = 5 }
    val expected = json.encodeToJsonElement(composer.build())
    assertEquals(Json.parseToJsonElement("""{"filters":"brand:Apple","hitsPerPage":5}"""), expected)
    val engine =
      mockEngine("""{"hits":[]}""") { request ->
        assertEquals("/1/indexes/idx/query", request.url.encodedPath)
        assertEquals(expected, Json.parseToJsonElement(request.bodyText()))
      }
    SearchClient("appId", "apiKey", ClientOptions(engine = engine)).use { client ->
      client.searchSingleIndex("idx", composer)
    }
  }

  @Test
  fun deleteByOverload() = runTest {
    val engine =
      mockEngine("""{"taskID":1,"updatedAt":"2024-01-01T00:00:00Z"}""") { request ->
        assertEquals("/1/indexes/idx/deleteByQuery", request.url.encodedPath)
        assertEquals(
          Json.parseToJsonElement("""{"filters":"_tags:old"}"""),
          Json.parseToJsonElement(request.bodyText()),
        )
      }
    SearchClient("appId", "apiKey", ClientOptions(engine = engine)).use { client ->
      client.deleteBy("idx") { filters { tag("old") } }
    }
  }

  @Test
  fun deleteByComposerOverload() = runTest {
    val composer = DSLDeleteByComposer()
    composer.add { filters { tag("old") } }
    composer.override { aroundLatLng = "1,2" }
    val expected = json.encodeToJsonElement(composer.build())
    assertEquals(
      Json.parseToJsonElement("""{"filters":"_tags:old","aroundLatLng":"1,2"}"""),
      expected,
    )
    val engine =
      mockEngine("""{"taskID":1,"updatedAt":"2024-01-01T00:00:00Z"}""") { request ->
        assertEquals("/1/indexes/idx/deleteByQuery", request.url.encodedPath)
        assertEquals(expected, Json.parseToJsonElement(request.bodyText()))
      }
    SearchClient("appId", "apiKey", ClientOptions(engine = engine)).use { client ->
      client.deleteBy("idx", composer)
    }
  }

  @Test
  fun setSettingsOverload() = runTest {
    val engine =
      mockEngine("""{"taskID":1,"updatedAt":"2024-01-01T00:00:00Z"}""") { request ->
        assertEquals("/1/indexes/idx/settings", request.url.encodedPath)
        assertEquals("true", request.url.parameters["forwardToReplicas"])
        assertEquals(
          Json.parseToJsonElement("""{"customRanking":["desc(popularity)"]}"""),
          Json.parseToJsonElement(request.bodyText()),
        )
      }
    SearchClient("appId", "apiKey", ClientOptions(engine = engine)).use { client ->
      client.setSettings("idx", forwardToReplicas = true) { customRanking { desc("popularity") } }
    }
  }

  private fun mockEngine(
    responseBody: String,
    assertRequest: (HttpRequestData) -> Unit,
  ): MockEngine = MockEngine { request ->
    assertRequest(request)
    respond(
      content = responseBody,
      status = HttpStatusCode.OK,
      headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString()),
    )
  }

  private fun HttpRequestData.bodyText(): String {
    val bytes =
      (body as? OutgoingContent.ByteArrayContent)?.bytes()
        ?: error("Unexpected request body type: ${body::class}")
    return bytes.decodeToString()
  }
}

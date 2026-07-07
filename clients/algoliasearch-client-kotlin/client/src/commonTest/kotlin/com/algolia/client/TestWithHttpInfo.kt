package com.algolia.client

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.ClientOptions
import com.algolia.client.configuration.Host
import com.algolia.client.exception.AlgoliaApiException
import com.algolia.client.exception.AlgoliaRetryException
import com.algolia.client.transport.RequestConfig
import com.algolia.client.transport.RequestOptions
import com.algolia.client.transport.Requester
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.util.reflect.*
import kotlin.test.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class TestWithHttpInfo {

  private fun clientOf(engine: MockEngine, hosts: List<Host>? = null): SearchClient =
    SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      options = ClientOptions(engine = engine, hosts = hosts),
    )

  @Test
  fun returnsStatusCodeHeadersRawAndDeserializedBody() = runTest {
    val engine = MockEngine {
      respond(
        content = """{"foo":"bar"}""",
        status = HttpStatusCode.OK,
        headers =
          headersOf(
            HttpHeaders.ContentType to listOf("application/json"),
            "x-custom-header" to listOf("custom-value", "other-value"),
          ),
      )
    }
    clientOf(engine).use { client ->
      val response = client.customGetWithHTTPInfo(path = "1/test")
      assertEquals(200, response.statusCode)
      assertEquals(listOf("custom-value", "other-value"), response.headers["x-custom-header"])
      assertEquals(listOf("custom-value", "other-value"), response.headers["X-Custom-Header"])
      assertEquals("""{"foo":"bar"}""", response.body)
      assertEquals(buildJsonObject { put("foo", "bar") }, response.data)

      // The deserialized body matches what the plain method returns.
      assertEquals(client.customGet(path = "1/test"), response.data)
    }
  }

  @Test
  fun returnsNullBodyAndDataForEmptyResponses() = runTest {
    val engine = MockEngine {
      respond(content = "", status = HttpStatusCode.NoContent)
    }
    clientOf(engine).use { client ->
      val response = client.customDeleteWithHTTPInfo(path = "1/test")
      assertEquals(204, response.statusCode)
      assertNull(response.body)
      assertNull(response.data)
    }
  }

  @Test
  fun throwsApiExceptionOnClientError() = runTest {
    val engine = MockEngine {
      respond(
        content = """{"message":"Invalid Application-ID or API key","status":400}""",
        status = HttpStatusCode.BadRequest,
        headers = headersOf(HttpHeaders.ContentType, "application/json"),
      )
    }
    clientOf(engine).use { client ->
      // Both paths surface the same exception type on API errors.
      assertFailsWith<AlgoliaApiException> { client.customGet(path = "1/test") }
      assertFailsWith<AlgoliaApiException> { client.customGetWithHTTPInfo(path = "1/test") }
    }
  }

  @Test
  fun reflectsSuccessfulHostAfterRetry() = runTest {
    val engine = MockEngine { request ->
      if (request.url.host == "failing.host") {
        respondError(HttpStatusCode.InternalServerError)
      } else {
        respond(
          content = """{"host":"ok"}""",
          status = HttpStatusCode.OK,
          headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
      }
    }
    val hosts = listOf(Host("failing.host"), Host("healthy.host"))
    clientOf(engine, hosts = hosts).use { client ->
      val response = client.customGetWithHTTPInfo(path = "1/test")
      assertEquals(2, engine.requestHistory.size)
      assertEquals(200, response.statusCode)
      assertEquals(buildJsonObject { put("host", "ok") }, response.data)
    }
  }

  @Test
  fun throwsRetryExceptionWhenAllHostsFail() = runTest {
    val engine = MockEngine { respondError(HttpStatusCode.InternalServerError) }
    clientOf(engine).use { client ->
      assertFailsWith<AlgoliaRetryException> { client.customGetWithHTTPInfo(path = "1/test") }
    }
  }

  @Test
  fun customRequesterWithoutOverrideThrows() = runTest {
    val requester =
      object : Requester {
        override suspend fun <T> execute(
          requestConfig: RequestConfig,
          requestOptions: RequestOptions?,
          returnType: TypeInfo,
        ): T = error("not used in this test")

        override fun setClientApiKey(apiKey: String) {}
      }
    val client =
      SearchClient(
        appId = "appId",
        apiKey = "apiKey",
        options = ClientOptions(requester = requester),
      )
    assertFailsWith<UnsupportedOperationException> {
      client.customGetWithHTTPInfo(path = "1/test")
    }
  }
}

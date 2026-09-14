package com.algolia.client

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.ClientOptions
import com.algolia.client.configuration.Host
import com.algolia.client.configuration.TransformationOptions
import com.algolia.client.exception.AlgoliaApiException
import com.algolia.client.transport.internal.DEFAULT_RATE_LIMIT_WAIT
import com.algolia.client.transport.internal.retryAfterWait
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.test.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeSource
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class TestRateLimitRetry {

  private val hosts = listOf(Host("first.host"), Host("second.host"))

  private fun clientOf(engine: MockEngine, options: ClientOptions): SearchClient =
    SearchClient(appId = "appId", apiKey = "apiKey", options = options)

  private fun MockRequestHandleScope.rateLimited(
    retryAfter: String? = null,
    contentType: String = "application/json",
    body: String = """{"message":"Too many requests"}""",
  ) =
    respond(
      content = body,
      status = HttpStatusCode.TooManyRequests,
      headers =
        headersOf(
          HttpHeaders.ContentType to listOf(contentType),
          HttpHeaders.RetryAfter to listOfNotNull(retryAfter),
        ),
    )

  private fun MockRequestHandleScope.ok() =
    respond(
      content = """{"message":"ok"}""",
      status = HttpStatusCode.OK,
      headers = headersOf(HttpHeaders.ContentType, "application/json"),
    )

  private fun retryAfterOf(value: String?): Headers =
    if (value == null) Headers.Empty else headersOf(HttpHeaders.RetryAfter, value)

  @Test
  fun retryAfterWaitHonorsPositiveWholeSeconds() {
    assertEquals(2.seconds, retryAfterWait(retryAfterOf("2")))
    assertEquals(86400.seconds, retryAfterWait(retryAfterOf("86400")))
    assertEquals(5.seconds, retryAfterWait(retryAfterOf(" 5 ")))
  }

  @Test
  fun retryAfterWaitFallsBackToOneSecond() {
    assertEquals(1.seconds, DEFAULT_RATE_LIMIT_WAIT)
    for (value in
      listOf(null, "", " ", "0", "-5", "1.5", "120abc", "Wed, 21 Oct 2015 07:28:00 GMT")) {
      assertEquals(
        DEFAULT_RATE_LIMIT_WAIT,
        retryAfterWait(retryAfterOf(value)),
        "Retry-After: $value",
      )
    }
  }

  @Test
  fun retryAfterWaitSaturatesWhenTooLargeToRepresent() {
    assertEquals(Duration.INFINITE, retryAfterWait(retryAfterOf("99999999999999999999")))
    assertEquals(Duration.INFINITE, retryAfterWait(retryAfterOf(Long.MAX_VALUE.toString())))
  }

  @Test
  fun waitsThenRetriesTheSameHost() = runTest {
    var calls = 0
    val engine = MockEngine { if (++calls == 1) rateLimited(retryAfter = "2") else ok() }
    clientOf(engine, ClientOptions(engine = engine, hosts = hosts)).use { client ->
      val start = TimeSource.Monotonic.markNow()
      val response = client.customGet(path = "1/test")
      val elapsed = start.elapsedNow()

      assertEquals(buildJsonObject { put("message", "ok") }, response)
      assertEquals(2, engine.requestHistory.size)
      assertEquals(listOf("first.host", "first.host"), engine.requestHistory.map { it.url.host })
      assertTrue(elapsed >= 2.seconds, "waited $elapsed, expected at least 2s")

      client.customGet(path = "1/test")
      assertEquals("first.host", engine.requestHistory.last().url.host)
    }
  }

  @Test
  fun surfacesTheRateLimitOnceTheBudgetIsSpent() = runTest {
    val engine = MockEngine { rateLimited(retryAfter = "1") }
    clientOf(engine, ClientOptions(engine = engine, hosts = hosts)).use { client ->
      val exception = assertFailsWith<AlgoliaApiException> { client.customGet(path = "1/test") }

      assertEquals(429, exception.httpErrorCode)
      assertEquals(4, engine.requestHistory.size)
      assertTrue(engine.requestHistory.all { it.url.host == "first.host" })
    }
  }

  @Test
  fun surfacesAnHtmlRateLimitOnceTheBudgetIsSpent() = runTest {
    val html = "<html><body>429 Too Many Requests</body></html>"
    val engine = MockEngine { rateLimited(contentType = "text/html", body = html) }
    clientOf(engine, ClientOptions(engine = engine, hosts = hosts, maxRateLimitRetries = 1)).use {
      client ->
      val exception = assertFailsWith<AlgoliaApiException> { client.customGet(path = "1/test") }

      assertEquals(429, exception.httpErrorCode)
      assertTrue(exception.message!!.contains(html), exception.message!!)
      assertEquals(2, engine.requestHistory.size)
    }
  }

  @Test
  fun failsOnTheFirstRateLimitWhenRetriesAreDisabled() = runTest {
    val engine = MockEngine { rateLimited(retryAfter = "30") }
    clientOf(engine, ClientOptions(engine = engine, hosts = hosts, maxRateLimitRetries = 0)).use {
      client ->
      val start = TimeSource.Monotonic.markNow()
      val exception = assertFailsWith<AlgoliaApiException> { client.customGet(path = "1/test") }
      val elapsed = start.elapsedNow()

      assertEquals(429, exception.httpErrorCode)
      assertEquals(1, engine.requestHistory.size)
      assertTrue(elapsed < 5.seconds, "waited $elapsed, expected no wait")
    }
  }

  @Test
  fun defaultsToThreeRetries() {
    assertEquals(3, ClientOptions().maxRateLimitRetries)
    assertNull(TransformationOptions("us").clientOptions)
  }

  @Test
  fun transformationOptionsCarryTheBudgetToTheIngestionTransporter() = runTest {
    val engine = MockEngine { rateLimited(retryAfter = "30") }
    val transformationOptions =
      TransformationOptions(
        region = "us",
        clientOptions = ClientOptions(engine = engine, hosts = hosts, maxRateLimitRetries = 0),
      )
    SearchClient.withTransformation("appId", "apiKey", transformationOptions).use { client ->
      val ingestion = assertNotNull(client.ingestionTransporter)
      val exception = assertFailsWith<AlgoliaApiException> { ingestion.customGet(path = "1/test") }

      assertEquals(429, exception.httpErrorCode)
      assertEquals(1, engine.requestHistory.size)
    }
  }

  @Test
  fun ingestionTransporterKeepsTheDefaultBudget() = runTest {
    val engine = MockEngine { rateLimited(retryAfter = "1") }
    val transformationOptions =
      TransformationOptions(
        region = "us",
        clientOptions = ClientOptions(engine = engine, hosts = hosts),
      )
    SearchClient.withTransformation("appId", "apiKey", transformationOptions).use { client ->
      val ingestion = assertNotNull(client.ingestionTransporter)
      val exception = assertFailsWith<AlgoliaApiException> { ingestion.customGet(path = "1/test") }

      assertEquals(429, exception.httpErrorCode)
      assertEquals(4, engine.requestHistory.size)
    }
  }
}

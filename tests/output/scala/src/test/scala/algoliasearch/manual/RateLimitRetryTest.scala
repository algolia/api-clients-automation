package algoliasearch.manual

import algoliasearch.api.SearchClient
import algoliasearch.config.{CallType, ClientOptions, Host, TransformationOptions}
import algoliasearch.exception.{AlgoliaApiException, AlgoliaRetryException}
import algoliasearch.internal.interceptor.RetryStrategy

import okhttp3.Interceptor.Chain
import okhttp3.{Interceptor, MediaType, Protocol, Request, Response, ResponseBody}
import org.json4s.JObject
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicInteger
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}
import scala.jdk.CollectionConverters._

/** Fully offline HTTP stub for the HTTP 429 wait-and-retry round.
  *
  * It is installed as an OkHttp application interceptor after `RetryStrategy` (same mechanism as `WithHttpInfoTest`),
  * so it sees the host of every attempt and answers with canned responses without ever touching the network.
  */
private class RateLimitStubInterceptor(handler: (Int, Request) => Response) extends Interceptor {

  private val attempts = new AtomicInteger(0)
  private val hosts = new ConcurrentLinkedQueue[String]()

  def attemptCount: Int = attempts.get

  def attemptedHosts: List[String] = hosts.asScala.toList

  override def intercept(chain: Chain): Response = {
    val request = chain.request()
    hosts.add(request.url().host())
    handler(attempts.getAndIncrement(), request)
  }
}

class RateLimitRetryTest extends AnyFunSuite {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.global

  private val hostOne = "host-one.test"
  private val hostTwo = "host-two.test"
  private val tooManyRequestsJson = """{"message":"Too many requests"}"""
  private val tooManyRequestsHtml = "<html><body>429 Too Many Requests</body></html>"
  private val serverErrorJson = """{"message":"server error"}"""
  private val okJson = """{"message":"ok rate limit retry"}"""

  private def stubResponse(
      request: Request,
      code: Int,
      body: String,
      headers: Map[String, String] = Map.empty,
      mediaType: String = "application/json"
  ): Response = {
    val builder = new Response.Builder()
      .code(code)
      .request(request)
      .protocol(Protocol.HTTP_2)
      .message("")
      .body(ResponseBody.create(body, MediaType.parse(mediaType)))
    headers.foreach { case (name, value) => builder.header(name, value) }
    builder.build()
  }

  private def rateLimited(request: Request, headers: Map[String, String] = Map.empty): Response =
    stubResponse(request, 429, tooManyRequestsJson, headers)

  private def clientWith(stub: Interceptor, maxRateLimitRetries: Int = 3): SearchClient =
    SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      clientOptions = ClientOptions
        .builder()
        .withHosts(
          List(
            Host(hostOne, Set(CallType.Read, CallType.Write)),
            Host(hostTwo, Set(CallType.Read, CallType.Write))
          )
        )
        .withRequesterConfig(requester => requester.withInterceptor(stub))
        .withMaxRateLimitRetries(maxRateLimitRetries)
        .build()
    )

  private def elapsedMillis(start: Long): Long = (System.nanoTime() - start) / 1000000L

  private def rateLimitWaitMillis(headers: Map[String, String]): Long = {
    val request = new Request.Builder().url(s"https://$hostOne/1/test").build()
    val method = RetryStrategy.getClass.getDeclaredMethods
      .find(_.getName.endsWith("rateLimitWaitMillis"))
      .getOrElse(fail("RetryStrategy.rateLimitWaitMillis not found"))
    method.setAccessible(true)
    method.invoke(RetryStrategy, rateLimited(request, headers)).asInstanceOf[Long]
  }

  test("Retry-After is honored only as a positive whole number of seconds") {
    assert(rateLimitWaitMillis(Map("Retry-After" -> "2")) == 2000L)
    assert(rateLimitWaitMillis(Map("retry-after" -> "5")) == 5000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "86400")) == 86400000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> Long.MaxValue.toString)) == Long.MaxValue)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "99999999999999999999")) == Long.MaxValue)
    assert(rateLimitWaitMillis(Map.empty) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> " ")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "0")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "-5")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "1.5")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "120abc")) == 1000L)
    assert(rateLimitWaitMillis(Map("Retry-After" -> "Wed, 21 Oct 2015 07:28:00 GMT")) == 1000L)
  }

  test("waits then retries the same host without marking it down") {
    val stub = new RateLimitStubInterceptor((attempt, request) =>
      if (attempt == 0) rateLimited(request) else stubResponse(request, 200, okJson)
    )
    val client = clientWith(stub)

    try {
      val start = System.nanoTime()
      val res = Await.result(client.customGet[JObject]("1/test"), Duration.Inf)

      assert(elapsedMillis(start) >= 1000L)
      assert(res.values("message") == "ok rate limit retry")
      assert(stub.attemptCount == 2)
      assert(stub.attemptedHosts == List(hostOne, hostOne))

      Await.result(client.customGet[JObject]("1/test"), Duration.Inf)

      assert(stub.attemptedHosts == List(hostOne, hostOne, hostOne))
    } finally {
      client.close()
    }
  }

  test("waits Retry-After seconds before retrying") {
    val stub = new RateLimitStubInterceptor((attempt, request) =>
      if (attempt == 0) rateLimited(request, Map("Retry-After" -> "2")) else stubResponse(request, 200, okJson)
    )
    val client = clientWith(stub)

    try {
      val start = System.nanoTime()
      Await.result(client.customGet[JObject]("1/test"), Duration.Inf)

      assert(elapsedMillis(start) >= 2000L)
      assert(stub.attemptCount == 2)
      assert(stub.attemptedHosts == List(hostOne, hostOne))
    } finally {
      client.close()
    }
  }

  test("surfaces the 429 once maxRateLimitRetries is spent without failing over") {
    val stub = new RateLimitStubInterceptor((_, request) => rateLimited(request, Map("Retry-After" -> "1")))
    val client = clientWith(stub)

    try {
      val start = System.nanoTime()
      val error = intercept[AlgoliaApiException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(elapsedMillis(start) >= 3000L)
      assert(error.httpErrorCode == 429)
      assert(error.getMessage == "Too many requests")
      assert(stub.attemptCount == 4)
      assert(stub.attemptedHosts == List.fill(4)(hostOne))
    } finally {
      client.close()
    }
  }

  test("the maxRateLimitRetries budget is shared across hosts") {
    val stub = new RateLimitStubInterceptor((attempt, request) =>
      if (attempt == 1) stubResponse(request, 500, serverErrorJson)
      else rateLimited(request, Map("Retry-After" -> "1"))
    )
    val client = clientWith(stub)

    try {
      val error = intercept[AlgoliaApiException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(error.httpErrorCode == 429)
      assert(stub.attemptedHosts == List(hostOne, hostOne, hostTwo, hostTwo, hostTwo))
    } finally {
      client.close()
    }
  }

  test("a waited-out 429 stays visible when every host then fails") {
    val stub = new RateLimitStubInterceptor((attempt, request) =>
      if (attempt == 0) rateLimited(request, Map("Retry-After" -> "1", "Correlation-ID" -> "RateLimitCid"))
      else stubResponse(request, 500, serverErrorJson)
    )
    val client = clientWith(stub)

    try {
      val error = intercept[AlgoliaRetryException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(stub.attemptedHosts == List(hostOne, hostOne, hostTwo))
      assert(error.correlationId.contains("RateLimitCid"))
      val waitedOut = error.exceptions.head.asInstanceOf[AlgoliaApiException]
      assert(waitedOut.httpErrorCode == 429)
      assert(waitedOut.message == tooManyRequestsJson)
      assert(waitedOut.correlationId.contains("RateLimitCid"))
    } finally {
      client.close()
    }
  }

  test("an HTML 429 still surfaces once maxRateLimitRetries is spent") {
    val stub = new RateLimitStubInterceptor((_, request) =>
      stubResponse(request, 429, tooManyRequestsHtml, mediaType = "text/html")
    )
    val client = clientWith(stub)

    try {
      val error = intercept[AlgoliaApiException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(error.httpErrorCode == 429)
      assert(error.getMessage == tooManyRequestsHtml)
      assert(stub.attemptCount == 4)
      assert(stub.attemptedHosts == List.fill(4)(hostOne))
    } finally {
      client.close()
    }
  }

  test("maxRateLimitRetries 0 fails on the first 429 without waiting") {
    val stub = new RateLimitStubInterceptor((_, request) => rateLimited(request, Map("Retry-After" -> "30")))
    val client = clientWith(stub, maxRateLimitRetries = 0)

    try {
      val start = System.nanoTime()
      val error = intercept[AlgoliaApiException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(elapsedMillis(start) < 1000L)
      assert(error.httpErrorCode == 429)
      assert(error.getMessage == "Too many requests")
      assert(stub.attemptCount == 1)
      assert(stub.attemptedHosts == List(hostOne))
    } finally {
      client.close()
    }
  }

  test("maxRateLimitRetries defaults to 3") {
    assert(ClientOptions().maxRateLimitRetries == 3)
    assert(ClientOptions.builder().build().maxRateLimitRetries == 3)
    assert(ClientOptions.builder().withMaxRateLimitRetries(0).build().maxRateLimitRetries == 0)
  }

  test("TransformationOptions forward maxRateLimitRetries to the ingestion transporter") {
    val stub = new RateLimitStubInterceptor((_, request) => rateLimited(request, Map("Retry-After" -> "30")))
    val client = SearchClient.withTransformation(
      appId = "appId",
      apiKey = "apiKey",
      transformationOptions = TransformationOptions(
        region = "us",
        clientOptions = Some(
          ClientOptions
            .builder()
            .withRequesterConfig(requester => requester.withInterceptor(stub))
            .withMaxRateLimitRetries(0)
            .build()
        )
      )
    )

    try {
      val ingestion = client.ingestionTransporter.get
      val error = intercept[AlgoliaApiException] {
        Await.result(ingestion.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(error.httpErrorCode == 429)
      assert(stub.attemptCount == 1)
    } finally {
      client.close()
    }
  }

  test("the ingestion transporter keeps the default budget when TransformationOptions do not set it") {
    val stub = new RateLimitStubInterceptor((_, request) => rateLimited(request, Map("Retry-After" -> "1")))
    val client = SearchClient.withTransformation(
      appId = "appId",
      apiKey = "apiKey",
      transformationOptions = TransformationOptions(
        region = "us",
        clientOptions = Some(
          ClientOptions.builder().withRequesterConfig(requester => requester.withInterceptor(stub)).build()
        )
      )
    )

    try {
      val ingestion = client.ingestionTransporter.get
      val error = intercept[AlgoliaApiException] {
        Await.result(ingestion.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(error.httpErrorCode == 429)
      assert(stub.attemptCount == 4)
    } finally {
      client.close()
    }
  }
}

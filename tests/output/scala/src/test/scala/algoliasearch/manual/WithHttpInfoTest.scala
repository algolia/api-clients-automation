package algoliasearch.manual

import algoliasearch.api.SearchClient
import algoliasearch.config.{ClientOptions, HttpRequest, RequestOptions, Requester}
import algoliasearch.exception.AlgoliaApiException

import okhttp3.Interceptor.Chain
import okhttp3.{Interceptor, MediaType, Protocol, Request, Response, ResponseBody}
import org.json4s.JObject
import org.scalatest.funsuite.AnyFunSuite

import java.io.IOException
import java.util.concurrent.atomic.AtomicInteger
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

/** Fully offline HTTP stub for the `*WithHTTPInfo` method derivatives.
  *
  * It is installed as an OkHttp application interceptor (same mechanism as `BrowseSynonymsTest`), so the whole real
  * request path runs — including the `RetryStrategy` interceptor — and the canned response is handled by
  * `HttpRequester` without ever touching the network.
  */
private class WithHttpInfoStubInterceptor(handler: (Int, Request) => Response) extends Interceptor {

  private val attempts = new AtomicInteger(0)

  def attemptCount: Int = attempts.get

  override def intercept(chain: Chain): Response = handler(attempts.getAndIncrement(), chain.request())
}

class WithHttpInfoTest extends AnyFunSuite {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.global

  private def stubResponse(
      request: Request,
      code: Int,
      body: String,
      headers: Map[String, String] = Map.empty
  ): Response = {
    val builder = new Response.Builder()
      .code(code)
      .request(request)
      .protocol(Protocol.HTTP_2)
      .message("")
      .body(ResponseBody.create(body, MediaType.parse("application/json")))
    headers.foreach { case (name, value) => builder.header(name, value) }
    builder.build()
  }

  private def clientWith(interceptor: Interceptor): SearchClient =
    SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      clientOptions = ClientOptions
        .builder()
        .withRequesterConfig(requester => requester.withInterceptor(interceptor))
        .build()
    )

  test("withHTTPInfo exposes status code, headers, raw body and the same data as the plain method") {
    val responseJson = """{"message":"ok","count":42}"""
    val stub = new WithHttpInfoStubInterceptor((_, request) =>
      stubResponse(request, 200, responseJson, Map("X-Algolia-Test" -> "test-value"))
    )
    val client = clientWith(stub)

    try {
      val info = Await.result(client.customGetWithHTTPInfo[JObject]("1/test"), Duration.Inf)
      val plain = Await.result(client.customGet[JObject]("1/test"), Duration.Inf)

      assert(info.statusCode == 200)
      assert(info.body == responseJson)
      assert(info.headers.get("x-algolia-test").contains(Seq("test-value")))
      assert(info.data.contains(plain))
    } finally {
      client.close()
    }
  }

  test("withHTTPInfo returns empty body and no data on 204") {
    val stub = new WithHttpInfoStubInterceptor((_, request) => stubResponse(request, 204, ""))
    val client = clientWith(stub)

    try {
      val info = Await.result(client.customDeleteWithHTTPInfo[JObject]("1/test"), Duration.Inf)

      assert(info.statusCode == 204)
      assert(info.body == "")
      assert(info.data.isEmpty)
    } finally {
      client.close()
    }
  }

  test("withHTTPInfo maps non-2xx responses to the same AlgoliaApiException as the plain method") {
    val errorJson = """{"message":"Invalid Application-ID or API key","status":400}"""
    val stub = new WithHttpInfoStubInterceptor((_, request) => stubResponse(request, 400, errorJson))
    val client = clientWith(stub)

    try {
      val infoError = intercept[AlgoliaApiException] {
        Await.result(client.customGetWithHTTPInfo[JObject]("1/test"), Duration.Inf)
      }
      val plainError = intercept[AlgoliaApiException] {
        Await.result(client.customGet[JObject]("1/test"), Duration.Inf)
      }

      assert(infoError.httpErrorCode == 400)
      assert(infoError.message == "Invalid Application-ID or API key")
      assert(infoError.message == plainError.message)
      assert(infoError.httpErrorCode == plainError.httpErrorCode)
    } finally {
      client.close()
    }
  }

  test("withHTTPInfo reflects the successful response after a retry") {
    val responseJson = """{"message":"ok"}"""
    val stub = new WithHttpInfoStubInterceptor((attempt, request) =>
      if (attempt == 0) throw new IOException("connection reset")
      else stubResponse(request, 200, responseJson)
    )
    val client = clientWith(stub)

    try {
      val info = Await.result(client.customGetWithHTTPInfo[JObject]("1/test"), Duration.Inf)

      assert(stub.attemptCount == 2)
      assert(info.statusCode == 200)
      assert(info.body == responseJson)
      assert(info.data.isDefined)
    } finally {
      client.close()
    }
  }

  test("withHTTPInfo fails with UnsupportedOperationException on a custom requester without an override") {
    val customRequester = new Requester {
      override def execute[T: Manifest](httpRequest: HttpRequest, requestOptions: Option[RequestOptions]): T =
        null.asInstanceOf[T]

      override def close(): Unit = ()
    }
    val client = SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      clientOptions = ClientOptions.builder().withCustomRequester(customRequester).build()
    )

    try {
      intercept[UnsupportedOperationException] {
        Await.result(client.customGetWithHTTPInfo[JObject]("1/test"), Duration.Inf)
      }
    } finally {
      client.close()
    }
  }
}

package algoliasearch.manual

import algoliasearch.api.SearchClient
import algoliasearch.config.ClientOptions

import okhttp3.Interceptor.Chain
import okhttp3.{Interceptor, MediaType, Protocol, Response, ResponseBody}
import okio.Buffer
import org.json4s.JObject
import org.scalatest.funsuite.AnyFunSuite

import java.nio.charset.StandardCharsets
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

private class BodyCaptureInterceptor extends Interceptor {
  var contentLength: Option[Long] = None
  var bodyUtf8: Option[String] = None

  override def intercept(chain: Chain): Response = {
    val request = chain.request()
    Option(request.body).foreach { body =>
      contentLength = Some(body.contentLength())
      val buffer = new Buffer()
      body.writeTo(buffer)
      bodyUtf8 = Some(buffer.readUtf8())
    }
    new Response.Builder()
      .code(200)
      .request(request)
      .protocol(Protocol.HTTP_2)
      .message("")
      .body(ResponseBody.create("{}", MediaType.parse("application/json")))
      .build()
  }
}

/** Pins the wire contract from API-141: request bodies are pre-serialized to UTF-8 bytes and declare their exact
  * length, so requests carry `Content-Length` instead of `Transfer-Encoding: chunked`.
  */
class RequestBodyContentLengthTest extends AnyFunSuite {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.global

  private def clientWith(interceptor: Interceptor): SearchClient =
    SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      clientOptions = ClientOptions
        .builder()
        .withRequesterConfig(requester => requester.withInterceptor(interceptor))
        .build()
    )

  test("request bodies declare their exact UTF-8 byte length instead of chunked encoding") {
    val capture = new BodyCaptureInterceptor
    val client = clientWith(capture)
    try {
      Await.result(client.customPost[JObject]("1/test", body = Some(Map("message" -> "café"))), Duration.Inf)
      val expected = """{"message":"café"}"""
      assert(capture.bodyUtf8.contains(expected))
      assert(capture.contentLength.contains(expected.getBytes(StandardCharsets.UTF_8).length.toLong))
    } finally {
      client.close()
    }
  }

  test("bodyless POST sends a fixed-length empty JSON object") {
    val capture = new BodyCaptureInterceptor
    val client = clientWith(capture)
    try {
      Await.result(client.customPost[JObject]("1/test"), Duration.Inf)
      assert(capture.bodyUtf8.contains("{}"))
      assert(capture.contentLength.contains(2L))
    } finally {
      client.close()
    }
  }
}

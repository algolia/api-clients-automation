package algoliasearch.client

import algoliasearch.api.QuerySuggestionsClient
import algoliasearch.config.*
import algoliasearch.{EchoInterceptor, assertError}
import algoliasearch.querysuggestions.*
import algoliasearch.exception.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class QuerySuggestionsTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(
      appId: String = "appId",
      apiKey: String = "apiKey",
      region: String = "us"
  ): (QuerySuggestionsClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      QuerySuggestionsClient(
        appId = appId,
        apiKey = apiKey,
        region = region,
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("calls api with correct user agent") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[Any](
        path = "/test"
      ),
      Duration.Inf
    )

    val regexp =
      """^Algolia for scala \(\d+\.\d+\.\d+(-.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-.*)?\))?)*(; QuerySuggestions (\(\d+\.\d+\.\d+(-.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-.*)?\))?)*$""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("calls api with default read timeouts") {
    val (client, echo) = testClient()

    Await.ready(
      client.customGet[Any](
        path = "/test"
      ),
      Duration.Inf
    )

    assert(echo.lastResponse.get.connectTimeout == 2000)
    assert(echo.lastResponse.get.responseTimeout == 5000)
  }

  test("calls api with default write timeouts") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[Any](
        path = "/test"
      ),
      Duration.Inf
    )

    assert(echo.lastResponse.get.connectTimeout == 2000)
    assert(echo.lastResponse.get.responseTimeout == 30000)
  }

  test("throws when region is not given") {

    assertError("`region` is required and must be one of the following: eu, us") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "")

    }
  }

  test("throws when incorrect region is given") {

    assertError("`region` is required and must be one of the following: eu, us") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "not_a_region")

    }
  }

  test("does not throw when region is given") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "us")

  }
}

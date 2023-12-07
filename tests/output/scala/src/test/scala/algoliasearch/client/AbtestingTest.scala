package algoliasearch.client

import algoliasearch.api.AbtestingClient
import algoliasearch.config.*
import algoliasearch.{EchoInterceptor, assertError}
import algoliasearch.abtesting.*
import algoliasearch.exception.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AbtestingTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(
      appId: String = "appId",
      apiKey: String = "apiKey",
      region: String = null
  ): (AbtestingClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      AbtestingClient(
        appId = appId,
        apiKey = apiKey,
        region = Option(region),
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
      client.post[Any](
        path = "/test"
      ),
      Duration.Inf
    )

    val regexp =
      """^Algolia for scala \(\d+\.\d+\.\d+(-.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-.*)?\))?)*(; Abtesting (\(\d+\.\d+\.\d+(-.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-.*)?\))?)*$""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("calls api with default read timeouts") {
    val (client, echo) = testClient()

    Await.ready(
      client.get[Any](
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
      client.post[Any](
        path = "/test"
      ),
      Duration.Inf
    )

    assert(echo.lastResponse.get.connectTimeout == 2000)
    assert(echo.lastResponse.get.responseTimeout == 30000)
  }

  test("fallbacks to the alias when region is not given") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key")

    Await.ready(
      client.getABTest(
        id = 123
      ),
      Duration.Inf
    )

    assert(echo.lastResponse.get.host == "analytics.algolia.com")
  }

  test("uses the correct region") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "us")

    Await.ready(
      client.getABTest(
        id = 123
      ),
      Duration.Inf
    )

    assert(echo.lastResponse.get.host == "analytics.us.algolia.com")
  }

  test("throws when incorrect region is given") {

    assertError("`region` must be one of the following: de, us") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "not_a_region")

    }
  }
}

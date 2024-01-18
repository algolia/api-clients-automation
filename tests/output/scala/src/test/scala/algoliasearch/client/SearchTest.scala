package algoliasearch.client

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.{EchoInterceptor, assertError}
import algoliasearch.search.*
import algoliasearch.exception.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class SearchTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(appId: String = "appId", apiKey: String = "apiKey"): (SearchClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      SearchClient(
        appId = appId,
        apiKey = apiKey,
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("calls api with correct read host") {

    val (client, echo) = testClient(appId = "test-app-id", apiKey = "test-api-key")

    Await.ready(
      client.customGet[Any](
        path = "/test"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.host == "test-app-id-dsn.algolia.net")
  }

  test("calls api with correct write host") {

    val (client, echo) = testClient(appId = "test-app-id", apiKey = "test-api-key")

    Await.ready(
      client.customPost[Any](
        path = "/test"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.host == "test-app-id.algolia.net")
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
      """^Algolia for Scala \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$""".r
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

  test("client throws with invalid parameters") {

    assertError("`appId` is missing.") {
      val (client, echo) = testClient(appId = "", apiKey = "")
    }

    assertError("`appId` is missing.") {
      val (client, echo) = testClient(appId = "", apiKey = "my-api-key")
    }

    assertError("`apiKey` is missing.") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "")
    }
  }

  test("`addApiKey` throws with invalid parameters") {
    val (client, echo) = testClient()

    assertError("Parameter `apiKey` is required when calling `addApiKey`.") {
      Await.ready(
        client.addApiKey(
          apiKey = null
        ),
        Duration.Inf
      )
    }
  }

  test("`addOrUpdateObject` throws with invalid parameters") {
    val (client, echo) = testClient()

    assertError("Parameter `indexName` is required when calling `addOrUpdateObject`.") {
      Await.ready(
        client.addOrUpdateObject(
          indexName = null,
          objectID = "my-object-id",
          body = JObject(List())
        ),
        Duration.Inf
      )
    }

    assertError("Parameter `objectID` is required when calling `addOrUpdateObject`.") {
      Await.ready(
        client.addOrUpdateObject(
          indexName = "my-index-name",
          objectID = null,
          body = JObject(List())
        ),
        Duration.Inf
      )
    }

    assertError("Parameter `body` is required when calling `addOrUpdateObject`.") {
      Await.ready(
        client.addOrUpdateObject(
          indexName = "my-index-name",
          objectID = "my-object-id",
          body = null
        ),
        Duration.Inf
      )
    }
  }
}

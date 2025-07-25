// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.client

import algoliasearch.api.IngestionClient
import algoliasearch.config.*
import algoliasearch.{EchoInterceptor, assertError}
import algoliasearch.ingestion.*
import algoliasearch.exception.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class IngestionTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  def testClient(
      appId: String = "appId",
      apiKey: String = "apiKey",
      region: String = "us"
  ): (IngestionClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      IngestionClient(
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

  test("can handle HTML error") {

    val client = IngestionClient(
      appId = "test-app-id",
      apiKey = "test-api-key",
      region = "us",
      clientOptions = ClientOptions
        .builder()
        .withHosts(
          List(
            Host(
              if (System.getenv("CI") == "true") "localhost" else "host.docker.internal",
              Set(CallType.Read, CallType.Write),
              "http",
              Option(6676)
            )
          )
        )
        .build()
    )

    assertError("<html><body>429 Too Many Requests</body></html>") {
      var res = Await.result(
        client.customGet[JObject](
          path = "1/html-error"
        ),
        Duration.Inf
      )
    }
  }

  test("calls api with default read timeouts") {
    val (client, echo) = testClient()

    Await.ready(
      client.customGet[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.connectTimeout == 25000)
    assert(echo.lastResponse.get.responseTimeout == 25000)
  }

  test("calls api with default write timeouts") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.connectTimeout == 25000)
    assert(echo.lastResponse.get.responseTimeout == 25000)
  }

  test("can leave call opened for a long time") {

    val client = IngestionClient(
      appId = "test-app-id",
      apiKey = "test-api-key",
      region = "us",
      clientOptions = ClientOptions
        .builder()
        .withHosts(
          List(
            Host(
              if (System.getenv("CI") == "true") "localhost" else "host.docker.internal",
              Set(CallType.Read, CallType.Write),
              "http",
              Option(6676)
            )
          )
        )
        .build()
    )

    var res = Await.result(
      client.customGet[JObject](
        path = "1/long-wait"
      ),
      Duration.Inf
    )
    assert(parse(write(res)) == parse("{\"message\":\"OK\"}"))
  }

  test("endpoint level timeout") {
    val (client, echo) = testClient()

    Await.ready(
      client.validateSourceBeforeUpdate(
        sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        sourceUpdate = SourceUpdate(
          name = Some("newName")
        )
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.connectTimeout == 180000)
    assert(echo.lastResponse.get.responseTimeout == 180000)
  }

  test("can override endpoint level timeout") {
    val (client, echo) = testClient()

    Await.ready(
      client.validateSourceBeforeUpdate(
        sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        sourceUpdate = SourceUpdate(
          name = Some("newName")
        ),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withWriteTimeout(Some(Duration(3456, TimeUnit.MILLISECONDS)))
            .build()
        )
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.connectTimeout == 180000)
    assert(echo.lastResponse.get.responseTimeout == 3456)
  }

  test("calls api with correct user agent") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    val regexp =
      """^Algolia for Scala \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Ingestion (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("the user agent contains the latest version") {
    val (client, echo) = testClient()

    Await.ready(
      client.customPost[JObject](
        path = "1/test"
      ),
      Duration.Inf
    )
    val regexp = """^Algolia for Scala \(2.24.1\).*""".r
    val header = echo.lastResponse.get.headers("user-agent")
    assert(header.matches(regexp.regex), s"Expected $header to match the following regex: ${regexp.regex}")
  }

  test("uses the correct region") {

    val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "us")
    Await.ready(
      client.getSource(
        sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
      ),
      Duration.Inf
    )
    assert(echo.lastResponse.get.host == "data.us.algolia.com")
  }

  test("throws when incorrect region is given") {

    assertError("`region` is required and must be one of the following: eu, us") {
      val (client, echo) = testClient(appId = "my-app-id", apiKey = "my-api-key", region = "not_a_region")
    }
  }

  test("switch API key") {

    val client = IngestionClient(
      appId = "test-app-id",
      apiKey = "test-api-key",
      region = "us",
      clientOptions = ClientOptions
        .builder()
        .withHosts(
          List(
            Host(
              if (System.getenv("CI") == "true") "localhost" else "host.docker.internal",
              Set(CallType.Read, CallType.Write),
              "http",
              Option(6683)
            )
          )
        )
        .build()
    )

    {
      var res = Await.result(
        client.customGet[JObject](
          path = "check-api-key/1"
        ),
        Duration.Inf
      )
      assert(parse(write(res)) == parse("{\"headerAPIKeyValue\":\"test-api-key\"}"))
    }
    {

      client.setClientApiKey(
        apiKey = "updated-api-key"
      )
    }
    {
      var res = Await.result(
        client.customGet[JObject](
          path = "check-api-key/2"
        ),
        Duration.Inf
      )
      assert(parse(write(res)) == parse("{\"headerAPIKeyValue\":\"updated-api-key\"}"))
    }
  }

}

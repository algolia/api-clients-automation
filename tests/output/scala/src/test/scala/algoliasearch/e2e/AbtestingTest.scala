// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.e2e

import algoliasearch.api.AbtestingClient
import algoliasearch.config.*
import algoliasearch.abtesting.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AbtestingTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  def testClient(): AbtestingClient = {
    val region = Some("us")
    if (System.getenv("CI") == "true") {
      AbtestingClient(
        appId = System.getenv("ALGOLIA_APPLICATION_ID"),
        apiKey = System.getenv("ALGOLIA_ADMIN_KEY"),
        region = region
      )
    } else {
      val dotenv = Dotenv.configure.directory("../../").load
      AbtestingClient(
        appId = dotenv.get("ALGOLIA_APPLICATION_ID"),
        apiKey = dotenv.get("ALGOLIA_ADMIN_KEY"),
        region = region
      )
    }
  }

  test("listABTests with parameters1") {
    val client = testClient()
    val future = client.listABTests(
      offset = Some(0),
      limit = Some(21),
      indexPrefix = Some("cts_e2e ab"),
      indexSuffix = Some("t")
    )

    val response = Await.result(future, Duration.Inf)
    val expected = parse(
      """{"abtests":[{"abTestID":85635,"createdAt":"2024-05-13T10:12:27.739233Z","endAt":"2124-05-13T00:00:00Z","name":"cts_e2e_abtest","status":"active","variants":[{"addToCartCount":0,"clickCount":0,"conversionCount":0,"description":"this abtest is used for api client automation tests and will expire in 2124","index":"cts_e2e_search_facet","purchaseCount":0,"trafficPercentage":25},{"addToCartCount":0,"clickCount":0,"conversionCount":0,"description":"","index":"cts_e2e abtest","purchaseCount":0,"trafficPercentage":75}]}],"count":1,"total":1}"""
    )
    val extracted = Extraction.decompose(response)
    val diffRes = expected.diff(extracted)
    if (diffRes.deleted != JNothing) {
      println(s"This was expected and not found in the deserialized response: ${write(diffRes.deleted)}")
    }
    if (diffRes.changed != JNothing) {
      println(
        s"The expectation was different than what was found in the deserialized response: ${write(diffRes.changed)}"
      )
    }
    if (diffRes.deleted != JNothing || diffRes.changed != JNothing) {
      fail("there is a difference between received and expected")
    }
  }

}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.e2e

import algoliasearch.api.IngestionClient
import algoliasearch.config.*
import algoliasearch.ingestion.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite
import io.github.cdimascio.dotenv.Dotenv
import org.skyscreamer.jsonassert.JSONCompare.compareJSON
import org.skyscreamer.jsonassert.JSONCompareMode
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class IngestionTestE2E extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(): IngestionClient = {
    val region = "us"
    if (System.getenv("CI") == "true") {
      IngestionClient(
        appId = System.getenv("ALGOLIA_APPLICATION_ID"),
        apiKey = System.getenv("ALGOLIA_ADMIN_KEY"),
        region = region
      )
    } else {
      val dotenv = Dotenv.configure.directory("../../").load
      IngestionClient(
        appId = dotenv.get("ALGOLIA_APPLICATION_ID"),
        apiKey = dotenv.get("ALGOLIA_ADMIN_KEY"),
        region = region
      )
    }
  }

  test("enableTask") {
    val client = testClient()
    val future = client.enableTask(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON("""{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}""", write(response), JSONCompareMode.LENIENT)
  }

  test("enableTaskV1") {
    val client = testClient()
    val future = client.enableTaskV1(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON("""{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}""", write(response), JSONCompareMode.LENIENT)
  }

  test("getSource") {
    val client = testClient()
    val future = client.getSource(
      sourceID = "75eeb306-51d3-4e5e-a279-3c92bd8893ac"
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON(
      """{"sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","name":"cts_e2e_browse","type":"json","input":{"url":"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json"}}""",
      write(response),
      JSONCompareMode.LENIENT
    )
  }

  test("getAuthentications with query params1") {
    val client = testClient()
    val future = client.listAuthentications(
      itemsPerPage = Some(2),
      page = Some(1),
      `type` = Some(Seq(AuthenticationType.withName("basic"), AuthenticationType.withName("algolia"))),
      platform = Some(Seq(PlatformNone.withName("none"))),
      sort = Some(AuthenticationSortKeys.withName("createdAt")),
      order = Some(OrderKeys.withName("asc"))
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON(
      """{"pagination":{"page":1,"itemsPerPage":2},"authentications":[{"authenticationID":"474f050f-a771-464c-a016-323538029f5f","type":"algolia","name":"algolia-auth-1677060483885","input":{},"createdAt":"2023-02-22T10:08:04Z","updatedAt":"2023-10-25T08:41:56Z"},{}]}""",
      write(response),
      JSONCompareMode.LENIENT
    )
  }

  test("searchTasks") {
    val client = testClient()
    val future = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON(
      """[{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498","sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","destinationID":"506d79fa-e29d-4bcf-907c-6b6a41172153","enabled":true,"failureThreshold":0,"action":"replace","createdAt":"2024-01-08T16:47:41Z"}]""",
      write(response),
      JSONCompareMode.LENIENT
    )
  }

  test("searchTasksV1") {
    val client = testClient()
    val future = client.searchTasksV1(
      taskSearch = TaskSearch(
        taskIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    val response = Await.result(future, Duration.Inf)
    compareJSON(
      """[{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498","sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","destinationID":"506d79fa-e29d-4bcf-907c-6b6a41172153","trigger":{"type":"onDemand"},"enabled":true,"failureThreshold":0,"action":"replace","createdAt":"2024-01-08T16:47:41Z"}]""",
      write(response),
      JSONCompareMode.LENIENT
    )
  }

}

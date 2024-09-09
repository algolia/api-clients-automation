// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.AbtestingClient
// IMPORT<
import algoliasearch.abtesting.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetAbtestingClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the addABTests method.
    *
    * addABTests with minimal parameters
    */
  def snippetForAbtestingClientAddABTests(): Unit = {
    // >SEPARATOR addABTests default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.addABTests(
      addABTestsRequest = AddABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        name = "myABTest",
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.customDelete[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomGet(): Unit = {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.customGet[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomPost(): Unit = {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.customPost[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomPut(): Unit = {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.customPut[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteABTest method.
    *
    * deleteABTest
    */
  def snippetForAbtestingClientDeleteABTest(): Unit = {
    // >SEPARATOR deleteABTest default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.deleteABTest(
      id = 42
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getABTest method.
    *
    * getABTest
    */
  def snippetForAbtestingClientGetABTest(): Unit = {
    // >SEPARATOR getABTest default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.getABTest(
      id = 42
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listABTests method.
    *
    * listABTests with minimal parameters
    */
  def snippetForAbtestingClientListABTests(): Unit = {
    // >SEPARATOR listABTests default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.listABTests(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the scheduleABTest method.
    *
    * scheduleABTest with minimal parameters
    */
  def snippetForAbtestingClientScheduleABTest(): Unit = {
    // >SEPARATOR scheduleABTest default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.scheduleABTest(
      scheduleABTestsRequest = ScheduleABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        scheduledAt = "2022-11-31T00:00:00.000Z",
        name = "myABTest",
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the stopABTest method.
    *
    * stopABTest
    */
  def snippetForAbtestingClientStopABTest(): Unit = {
    // >SEPARATOR stopABTest default
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val response = client.stopABTest(
      id = 42
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

}

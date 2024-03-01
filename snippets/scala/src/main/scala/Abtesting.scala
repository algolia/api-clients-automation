package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.AbtestingClient
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
    // >SEPARATOR addABTests
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.addABTests(
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

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomGet(): Unit = {
    // >SEPARATOR customGet
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomPost(): Unit = {
    // >SEPARATOR customPost
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForAbtestingClientCustomPut(): Unit = {
    // >SEPARATOR customPut
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteABTest method.
    *
    * deleteABTest
    */
  def snippetForAbtestingClientDeleteABTest(): Unit = {
    // >SEPARATOR deleteABTest
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.deleteABTest(
      id = 42
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getABTest method.
    *
    * getABTest
    */
  def snippetForAbtestingClientGetABTest(): Unit = {
    // >SEPARATOR getABTest
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getABTest(
      id = 42
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listABTests method.
    *
    * listABTests with minimal parameters
    */
  def snippetForAbtestingClientListABTests(): Unit = {
    // >SEPARATOR listABTests
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.listABTests(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the stopABTest method.
    *
    * stopABTest
    */
  def snippetForAbtestingClientStopABTest(): Unit = {
    // >SEPARATOR stopABTest
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.stopABTest(
      id = 42
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

}

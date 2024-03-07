package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.InsightsClient
import algoliasearch.insights.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetInsightsClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForInsightsClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

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
  def snippetForInsightsClientCustomGet(): Unit = {
    // >SEPARATOR customGet
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

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
  def snippetForInsightsClientCustomPost(): Unit = {
    // >SEPARATOR customPost
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

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
  def snippetForInsightsClientCustomPut(): Unit = {
    // >SEPARATOR customPut
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteUserToken method.
    *
    * deleteUserToken0
    */
  def snippetForInsightsClientDeleteUserToken(): Unit = {
    // >SEPARATOR deleteUserToken
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.deleteUserToken(
      userToken = "test-user-1"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * pushEvents0
    */
  def snippetForInsightsClientPushEvents(): Unit = {
    // >SEPARATOR pushEvents
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.pushEvents(
      insightsEvents = InsightsEvents(
        events = Seq(
          ClickedObjectIDsAfterSearch(
            eventType = ClickEvent.withName("click"),
            eventName = "Product Clicked",
            index = "products",
            userToken = "user-123456",
            authenticatedUserToken = Some("user-123456"),
            timestamp = Some(1641290601962L),
            objectIDs = Seq("9780545139700", "9780439784542"),
            queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
            positions = Seq(7, 6)
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

}

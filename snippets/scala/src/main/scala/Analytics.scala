package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.AnalyticsClient
import algoliasearch.analytics.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetAnalyticsClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForAnalyticsClientCustomDelete(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForAnalyticsClientCustomGet(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForAnalyticsClientCustomPost(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForAnalyticsClientCustomPut(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getAverageClickPosition method.
    *
    * get getAverageClickPosition with minimal parameters
    */
  def snippetForAnalyticsClientGetAverageClickPosition(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getAverageClickPosition(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getClickPositions method.
    *
    * get getClickPositions with minimal parameters
    */
  def snippetForAnalyticsClientGetClickPositions(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getClickPositions(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getClickThroughRate method.
    *
    * get getClickThroughRate with minimal parameters
    */
  def snippetForAnalyticsClientGetClickThroughRate(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getClickThroughRate(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getConversationRate method.
    *
    * get getConversationRate with minimal parameters
    */
  def snippetForAnalyticsClientGetConversationRate(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getConversationRate(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getNoClickRate method.
    *
    * get getNoClickRate with minimal parameters
    */
  def snippetForAnalyticsClientGetNoClickRate(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getNoClickRate(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getNoResultsRate method.
    *
    * get getNoResultsRate with minimal parameters
    */
  def snippetForAnalyticsClientGetNoResultsRate(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getNoResultsRate(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSearchesCount method.
    *
    * get getSearchesCount with minimal parameters
    */
  def snippetForAnalyticsClientGetSearchesCount(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getSearchesCount(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSearchesNoClicks method.
    *
    * get getSearchesNoClicks with minimal parameters
    */
  def snippetForAnalyticsClientGetSearchesNoClicks(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getSearchesNoClicks(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSearchesNoResults method.
    *
    * get getSearchesNoResults with minimal parameters
    */
  def snippetForAnalyticsClientGetSearchesNoResults(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getSearchesNoResults(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getStatus method.
    *
    * get getStatus with minimal parameters
    */
  def snippetForAnalyticsClientGetStatus(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getStatus(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopCountries method.
    *
    * get getTopCountries with minimal parameters
    */
  def snippetForAnalyticsClientGetTopCountries(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopCountries(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopFilterAttributes method.
    *
    * get getTopFilterAttributes with minimal parameters
    */
  def snippetForAnalyticsClientGetTopFilterAttributes(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopFilterAttributes(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopFilterForAttribute method.
    *
    * get getTopFilterForAttribute with minimal parameters
    */
  def snippetForAnalyticsClientGetTopFilterForAttribute(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopFiltersNoResults method.
    *
    * get getTopFiltersNoResults with minimal parameters
    */
  def snippetForAnalyticsClientGetTopFiltersNoResults(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopFiltersNoResults(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopHits method.
    *
    * get getTopHits with minimal parameters
    */
  def snippetForAnalyticsClientGetTopHits(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopHits(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopSearches method.
    *
    * get getTopSearches with minimal parameters
    */
  def snippetForAnalyticsClientGetTopSearches(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getTopSearches(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getUsersCount method.
    *
    * get getUsersCount with minimal parameters
    */
  def snippetForAnalyticsClientGetUsersCount(): Unit = {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = Option("YOUR_APP_ID_REGION"))

    // Call the API
    val res = client.getUsersCount(
      index = "index"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

}

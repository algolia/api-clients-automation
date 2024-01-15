package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.RecommendClient
import algoliasearch.recommend.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetRecommendClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForRecommendClientCustomDelete(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForRecommendClientCustomGet(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForRecommendClientCustomPost(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForRecommendClientCustomPut(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteRecommendRule method.
    *
    * deleteRecommendRule0
    */
  def snippetForRecommendClientDeleteRecommendRule(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRecommendRule method.
    *
    * getRecommendRule0
    */
  def snippetForRecommendClientGetRecommendRule(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRecommendStatus method.
    *
    * getRecommendStatus0
    */
  def snippetForRecommendClientGetRecommendStatus(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getRecommendStatus(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      taskID = 12345L
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRecommendations method.
    *
    * get recommendations for recommend model with minimal parameters
    */
  def snippetForRecommendClientGetRecommendations(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RecommendationsQuery(
            indexName = "indexName",
            objectID = "objectID",
            model = RecommendationModels.withName("related-products"),
            threshold = Some(42)
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchRecommendRules method.
    *
    * searchRecommendRules0
    */
  def snippetForRecommendClientSearchRecommendRules(): Unit = {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchRecommendRules(
      indexName = "indexName",
      model = RecommendModels.withName("related-products")
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

}

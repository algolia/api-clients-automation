// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.RecommendClient
// IMPORT<
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
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.customDelete[JObject](
      path = "test/minimal"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForRecommendClientCustomGet(): Unit = {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.customGet[JObject](
      path = "test/minimal"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForRecommendClientCustomPost(): Unit = {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.customPost[JObject](
      path = "test/minimal"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForRecommendClientCustomPut(): Unit = {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.customPut[JObject](
      path = "test/minimal"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteRecommendRule method.
    *
    * deleteRecommendRule
    */
  def snippetForRecommendClientDeleteRecommendRule(): Unit = {
    // >SEPARATOR deleteRecommendRule default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.deleteRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRecommendRule method.
    *
    * getRecommendRule
    */
  def snippetForRecommendClientGetRecommendRule(): Unit = {
    // >SEPARATOR getRecommendRule default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.getRecommendRule(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      objectID = "objectID"
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRecommendStatus method.
    *
    * getRecommendStatus
    */
  def snippetForRecommendClientGetRecommendStatus(): Unit = {
    // >SEPARATOR getRecommendStatus default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.getRecommendStatus(
      indexName = "indexName",
      model = RecommendModels.withName("related-products"),
      taskID = 12345L
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRecommendations method.
    *
    * get recommendations for recommend model with minimal parameters
    */
  def snippetForRecommendClientGetRecommendations(): Unit = {
    // >SEPARATOR getRecommendations default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = Seq(
          RelatedQuery(
            indexName = "indexName",
            objectID = "objectID",
            model = RelatedModel.withName("related-products"),
            threshold = 42.1
          )
        )
      )
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchRecommendRules method.
    *
    * searchRecommendRules
    */
  def snippetForRecommendClientSearchRecommendRules(): Unit = {
    // >SEPARATOR searchRecommendRules default
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val response = client.searchRecommendRules(
      indexName = "indexName",
      model = RecommendModels.withName("related-products")
    )

    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

}

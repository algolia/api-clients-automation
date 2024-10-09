// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.snippets

// >IMPORT
import com.algolia.client.api.RecommendClient

// IMPORT<
import com.algolia.client.model.recommend.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetRecommendClient {
  suspend fun snippetForBatchRecommendRules() {
    // >SEPARATOR batchRecommendRules default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.batchRecommendRules(
      indexName = "<YOUR_INDEX_NAME>",
      model = RecommendModels.entries.first { it.value == "related-products" },
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.customDelete(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.customGet(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.customPost(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.customPut(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteRecommendRule() {
    // >SEPARATOR deleteRecommendRule default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.deleteRecommendRule(
      indexName = "<YOUR_INDEX_NAME>",
      model = RecommendModels.entries.first { it.value == "related-products" },
      objectID = "objectID",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendRule() {
    // >SEPARATOR getRecommendRule default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.getRecommendRule(
      indexName = "<YOUR_INDEX_NAME>",
      model = RecommendModels.entries.first { it.value == "related-products" },
      objectID = "objectID",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendStatus() {
    // >SEPARATOR getRecommendStatus default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.getRecommendStatus(
      indexName = "<YOUR_INDEX_NAME>",
      model = RecommendModels.entries.first { it.value == "related-products" },
      taskID = 12345L,
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendations() {
    // >SEPARATOR getRecommendations default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = listOf(
          RelatedQuery(
            indexName = "<YOUR_INDEX_NAME>",
            objectID = "objectID",
            model = RelatedModel.entries.first { it.value == "related-products" },
            threshold = 42.1,
          ),
        ),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchRecommendRules() {
    // >SEPARATOR searchRecommendRules default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    var response = client.searchRecommendRules(
      indexName = "<YOUR_INDEX_NAME>",
      model = RecommendModels.entries.first { it.value == "related-products" },
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    val client = RecommendClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key",
    )

    // >LOG
    // SEPARATOR<

    exitProcess(0)
  }
}

package com.algolia.snippets

import com.algolia.client.api.RecommendClient
import com.algolia.client.model.recommend.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetRecommendClient {
  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customDelete(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customGet(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPost(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteRecommendRule() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteRecommendRule(
      indexName = "indexName",
      model = RecommendModels.entries.first { it.value == "related-products" },
      objectID = "objectID",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendRule() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getRecommendRule(
      indexName = "indexName",
      model = RecommendModels.entries.first { it.value == "related-products" },
      objectID = "objectID",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendStatus() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getRecommendStatus(
      indexName = "indexName",
      model = RecommendModels.entries.first { it.value == "related-products" },
      taskID = 12345L,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRecommendations() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getRecommendations(
      getRecommendationsParams = GetRecommendationsParams(
        requests = listOf(
          RecommendationsQuery(
            indexName = "indexName",
            objectID = "objectID",
            model = RecommendationModels.entries.first { it.value == "related-products" },
            threshold = 42,
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchRecommendRules() {
    // Initialize the client
    val client = RecommendClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchRecommendRules(
      indexName = "indexName",
      model = RecommendModels.entries.first { it.value == "related-products" },
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

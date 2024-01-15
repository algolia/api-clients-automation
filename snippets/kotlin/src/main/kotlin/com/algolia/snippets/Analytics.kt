package com.algolia.snippets

import com.algolia.client.api.AnalyticsClient
import com.algolia.client.model.analytics.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetAnalyticsClient {
  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetAverageClickPosition() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAverageClickPosition(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetClickPositions() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getClickPositions(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetClickThroughRate() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getClickThroughRate(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetConversationRate() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConversationRate(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetNoClickRate() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getNoClickRate(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetNoResultsRate() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getNoResultsRate(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesCount() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesCount(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoClicks() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesNoClicks(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoResults() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesNoResults(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetStatus() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getStatus(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopCountries() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopCountries(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterAttributes() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFilterAttributes(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterForAttribute() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopFiltersNoResults() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFiltersNoResults(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopHits() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopHits(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopSearches() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopSearches(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetUsersCount() {
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getUsersCount(
      index = "index",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

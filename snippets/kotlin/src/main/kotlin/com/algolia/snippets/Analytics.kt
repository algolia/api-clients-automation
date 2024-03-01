package com.algolia.snippets

import com.algolia.client.api.AnalyticsClient
import com.algolia.client.model.analytics.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetAnalyticsClient {
  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customDelete(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customGet(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPost(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetAverageClickPosition() {
    // >SEPARATOR getAverageClickPosition
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAverageClickPosition(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClickPositions() {
    // >SEPARATOR getClickPositions
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getClickPositions(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClickThroughRate() {
    // >SEPARATOR getClickThroughRate
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getClickThroughRate(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConversationRate() {
    // >SEPARATOR getConversationRate
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConversationRate(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetNoClickRate() {
    // >SEPARATOR getNoClickRate
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getNoClickRate(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetNoResultsRate() {
    // >SEPARATOR getNoResultsRate
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getNoResultsRate(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesCount() {
    // >SEPARATOR getSearchesCount
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesCount(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoClicks() {
    // >SEPARATOR getSearchesNoClicks
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesNoClicks(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoResults() {
    // >SEPARATOR getSearchesNoResults
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSearchesNoResults(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetStatus() {
    // >SEPARATOR getStatus
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getStatus(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopCountries() {
    // >SEPARATOR getTopCountries
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopCountries(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterAttributes() {
    // >SEPARATOR getTopFilterAttributes
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFilterAttributes(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterForAttribute() {
    // >SEPARATOR getTopFilterForAttribute
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFiltersNoResults() {
    // >SEPARATOR getTopFiltersNoResults
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopFiltersNoResults(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopHits() {
    // >SEPARATOR getTopHits
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopHits(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopSearches() {
    // >SEPARATOR getTopSearches
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTopSearches(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetUsersCount() {
    // >SEPARATOR getUsersCount
    // Initialize the client
    val client = AnalyticsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getUsersCount(
      index = "index",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }
}

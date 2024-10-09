// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.snippets

// >IMPORT
import com.algolia.client.api.AnalyticsClient

// IMPORT<
import com.algolia.client.model.analytics.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetAnalyticsClient {
  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

  suspend fun snippetForGetAddToCartRate() {
    // >SEPARATOR getAddToCartRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getAddToCartRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetAverageClickPosition() {
    // >SEPARATOR getAverageClickPosition default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getAverageClickPosition(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClickPositions() {
    // >SEPARATOR getClickPositions default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getClickPositions(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClickThroughRate() {
    // >SEPARATOR getClickThroughRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getClickThroughRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConversionRate() {
    // >SEPARATOR getConversionRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getConversionRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetNoClickRate() {
    // >SEPARATOR getNoClickRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getNoClickRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetNoResultsRate() {
    // >SEPARATOR getNoResultsRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getNoResultsRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetPurchaseRate() {
    // >SEPARATOR getPurchaseRate default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getPurchaseRate(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetRevenue() {
    // >SEPARATOR getRevenue default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getRevenue(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesCount() {
    // >SEPARATOR getSearchesCount default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getSearchesCount(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoClicks() {
    // >SEPARATOR getSearchesNoClicks default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getSearchesNoClicks(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSearchesNoResults() {
    // >SEPARATOR getSearchesNoResults default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getSearchesNoResults(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetStatus() {
    // >SEPARATOR getStatus default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getStatus(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopCountries() {
    // >SEPARATOR getTopCountries default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopCountries(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterAttributes() {
    // >SEPARATOR getTopFilterAttributes default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopFilterAttributes(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFilterForAttribute() {
    // >SEPARATOR getTopFilterForAttribute default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopFiltersNoResults() {
    // >SEPARATOR getTopFiltersNoResults default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopFiltersNoResults(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopHits() {
    // >SEPARATOR getTopHits default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopHits(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTopSearches() {
    // >SEPARATOR getTopSearches default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTopSearches(
      index = "index",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetUsersCount() {
    // >SEPARATOR getUsersCount default
    // Initialize the client
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getUsersCount(
      index = "index",
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
    val client = AnalyticsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key",
    )

    // >LOG
    // SEPARATOR<

    exitProcess(0)
  }
}

package com.algolia.snippets

import com.algolia.client.api.InsightsClient
import com.algolia.client.model.insights.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetInsightsClient {
  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForPushEvents() {
    // Initialize the client
    val client = InsightsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.pushEvents(
      insightsEvents = InsightsEvents(
        events = listOf(
          ClickedObjectIDsAfterSearch(
            eventType = ClickEvent.entries.first { it.value == "click" },
            eventName = "Product Clicked",
            index = "products",
            userToken = "user-123456",
            authenticatedUserToken = "user-123456",
            timestamp = 1641290601962L,
            objectIDs = listOf("9780545139700", "9780439784542"),
            queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
            positions = listOf(7, 6),
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

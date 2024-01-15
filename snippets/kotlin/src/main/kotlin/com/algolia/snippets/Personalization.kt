package com.algolia.snippets

import com.algolia.client.api.PersonalizationClient
import com.algolia.client.model.personalization.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetPersonalizationClient {
  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteUserProfile() {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteUserProfile(
      userToken = "UserToken",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetPersonalizationStrategy() {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getPersonalizationStrategy()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetUserTokenProfile() {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getUserTokenProfile(
      userToken = "UserToken",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSetPersonalizationStrategy() {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.setPersonalizationStrategy(
      personalizationStrategyParams = PersonalizationStrategyParams(
        eventScoring = listOf(
          EventScoring(
            score = 42,
            eventName = "Algolia",
            eventType = "Event",
          ),
        ),
        facetScoring = listOf(
          FacetScoring(
            score = 42,
            facetName = "Event",
          ),
        ),
        personalizationImpact = 42,
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

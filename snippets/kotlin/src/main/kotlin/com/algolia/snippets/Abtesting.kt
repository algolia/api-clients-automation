package com.algolia.snippets

import com.algolia.client.api.AbtestingClient
import com.algolia.client.model.abtesting.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetAbtestingClient {
  suspend fun snippetForAddABTests() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.addABTests(
      addABTestsRequest = AddABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        name = "myABTest",
        variants = listOf(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30,
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50,
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteABTest() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteABTest(
      id = 42,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetABTest() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getABTest(
      id = 42,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForListABTests() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.listABTests()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForStopABTest() {
    // Initialize the client
    val client = AbtestingClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.stopABTest(
      id = 42,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

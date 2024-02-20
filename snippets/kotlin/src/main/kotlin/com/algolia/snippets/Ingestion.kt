package com.algolia.snippets

import com.algolia.client.api.IngestionClient
import com.algolia.client.model.ingestion.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetIngestionClient {
  suspend fun snippetForCreateAuthentication() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createAuthentication(
      authenticationCreate = AuthenticationCreate(
        type = AuthenticationType.entries.first { it.value == "oauth" },
        name = "authName",
        input = AuthOAuth(
          url = "http://test.oauth",
          clientId = "myID",
          clientSecret = "mySecret",
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCreateDestination() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createDestination(
      destinationCreate = DestinationCreate(
        type = DestinationType.entries.first { it.value == "search" },
        name = "destinationName",
        input = DestinationIndexPrefix(
          indexPrefix = "prefix_",
        ),
        authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCreateSource() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createSource(
      sourceCreate = SourceCreate(
        type = SourceType.entries.first { it.value == "commercetools" },
        name = "sourceName",
        input = SourceCommercetools(
          storeKeys = listOf("myStore"),
          locales = listOf("de"),
          url = "http://commercetools.com",
          projectKey = "keyID",
        ),
        authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCreateTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createTask(
      taskCreate = TaskCreate(
        sourceID = "search",
        destinationID = "destinationName",
        trigger = OnDemandTriggerInput(
          type = OnDemandTriggerType.entries.first { it.value == "onDemand" },
        ),
        action = ActionType.entries.first { it.value == "replace" },
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

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
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteAuthentication() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteDestination() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteSource() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDisableTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.disableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForEnableTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.enableTask(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetAuthentication() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetAuthentications() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAuthentications()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetDestination() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetDestinations() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getDestinations()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetDockerSourceStreams() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getDockerSourceStreams(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetEvent() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getEvent(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      eventID = "6c02aeb1-775e-418e-870b-1faccd4b2c0c",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetEvents() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getEvents(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRun() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getRun(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRuns() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getRuns()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSource() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSource(
      sourceID = "75eeb306-51d3-4e5e-a279-3c92bd8893ac",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSources() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getSources()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTasks() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getTasks()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForRunTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.runTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchAuthentications() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.searchAuthentications(
      authenticationSearch = AuthenticationSearch(
        authenticationIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchDestinations() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.searchDestinations(
      destinationSearch = DestinationSearch(
        destinationIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchSources() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.searchSources(
      sourceSearch = SourceSearch(
        sourceIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchTasks() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForTriggerDockerSourceDiscover() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.triggerDockerSourceDiscover(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateAuthentication() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      authenticationUpdate = AuthenticationUpdate(
        name = "newName",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateDestination() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      destinationUpdate = DestinationUpdate(
        name = "newName",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateSource() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = "newName",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateTask() {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdate(
        enabled = false,
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

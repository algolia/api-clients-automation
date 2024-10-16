// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.snippets

// >IMPORT
import com.algolia.client.api.IngestionClient

// IMPORT<
import com.algolia.client.model.ingestion.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetIngestionClient {
  suspend fun snippetForCreateAuthentication() {
    // >SEPARATOR createAuthentication default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCreateDestination() {
    // >SEPARATOR createDestination default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.createDestination(
      destinationCreate = DestinationCreate(
        type = DestinationType.entries.first { it.value == "search" },
        name = "destinationName",
        input = DestinationIndexName(
          indexName = "<YOUR_INDEX_NAME>",
        ),
        authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCreateSource() {
    // >SEPARATOR createSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCreateTask() {
    // >SEPARATOR createTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.createTask(
      taskCreate = TaskCreate(
        sourceID = "search",
        destinationID = "destinationName",
        action = ActionType.entries.first { it.value == "replace" },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCreateTaskV1() {
    // >SEPARATOR createTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.createTaskV1(
      taskCreate = TaskCreateV1(
        sourceID = "search",
        destinationID = "destinationName",
        trigger = OnDemandTriggerInput(
          type = OnDemandTriggerType.entries.first { it.value == "onDemand" },
        ),
        action = ActionType.entries.first { it.value == "replace" },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCreateTransformation() {
    // >SEPARATOR createTransformation default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.createTransformation(
      transformationCreate = TransformationCreate(
        code = "foo",
        name = "bar",
        description = "baz",
      ),
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
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

  suspend fun snippetForDeleteAuthentication() {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteDestination() {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteSource() {
    // >SEPARATOR deleteSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteTask() {
    // >SEPARATOR deleteTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteTaskV1() {
    // >SEPARATOR deleteTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteTransformation() {
    // >SEPARATOR deleteTransformation default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDisableTask() {
    // >SEPARATOR disableTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.disableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDisableTaskV1() {
    // >SEPARATOR disableTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.disableTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForEnableTask() {
    // >SEPARATOR enableTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.enableTask(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForEnableTaskV1() {
    // >SEPARATOR enableTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.enableTaskV1(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetAuthentication() {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetDestination() {
    // >SEPARATOR getDestination default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetEvent() {
    // >SEPARATOR getEvent default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getEvent(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      eventID = "6c02aeb1-775e-418e-870b-1faccd4b2c0c",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetRun() {
    // >SEPARATOR getRun default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getRun(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetSource() {
    // >SEPARATOR getSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getSource(
      sourceID = "75eeb306-51d3-4e5e-a279-3c92bd8893ac",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTask() {
    // >SEPARATOR getTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTaskV1() {
    // >SEPARATOR getTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetTransformation() {
    // >SEPARATOR getTransformation default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListAuthentications() {
    // >SEPARATOR listAuthentications default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listAuthentications()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListDestinations() {
    // >SEPARATOR listDestinations default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listDestinations()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListEvents() {
    // >SEPARATOR listEvents default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listEvents(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListRuns() {
    // >SEPARATOR listRuns default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listRuns()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListSources() {
    // >SEPARATOR listSources default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listSources()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListTasks() {
    // >SEPARATOR listTasks default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listTasks()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListTasksV1() {
    // >SEPARATOR listTasksV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listTasksV1()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForListTransformations() {
    // >SEPARATOR listTransformations default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.listTransformations()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForPushTask() {
    // >SEPARATOR pushTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.pushTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      pushTaskPayload = PushTaskPayload(
        action = Action.entries.first { it.value == "addObject" },
        records = listOf(
          PushTaskRecords(
            objectID = "o",
            additionalProperties = mapOf(
              "key" to JsonPrimitive("bar"),
              "foo" to JsonPrimitive("1"),
            ),
          ),
          PushTaskRecords(
            objectID = "k",
            additionalProperties = mapOf(
              "key" to JsonPrimitive("baz"),
              "foo" to JsonPrimitive("2"),
            ),
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

  suspend fun snippetForRunSource() {
    // >SEPARATOR runSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.runSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      runSourcePayload = RunSourcePayload(
        indexToInclude = listOf("products_us", "products eu"),
        entityIDs = listOf("1234", "5678"),
        entityType = EntityType.entries.first { it.value == "product" },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForRunTask() {
    // >SEPARATOR runTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.runTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForRunTaskV1() {
    // >SEPARATOR runTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.runTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchAuthentications() {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchAuthentications(
      authenticationSearch = AuthenticationSearch(
        authenticationIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchDestinations() {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchDestinations(
      destinationSearch = DestinationSearch(
        destinationIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchSources() {
    // >SEPARATOR searchSources default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchSources(
      sourceSearch = SourceSearch(
        sourceIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchTasks() {
    // >SEPARATOR searchTasks default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchTasksV1() {
    // >SEPARATOR searchTasksV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchTasksV1(
      taskSearch = TaskSearch(
        taskIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"),
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSearchTransformations() {
    // >SEPARATOR searchTransformations default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.searchTransformations(
      transformationSearch = TransformationSearch(
        transformationIDs = listOf("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"),
      ),
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
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key",
    )

    // >LOG
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForTriggerDockerSourceDiscover() {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.triggerDockerSourceDiscover(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForTryTransformation() {
    // >SEPARATOR tryTransformation default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.tryTransformation(
      transformationTry = TransformationTry(
        code = "foo",
        sampleRecord = buildJsonObject {
          put(
            "bar",
            JsonPrimitive("baz"),
          )
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForTryTransformationBeforeUpdate() {
    // >SEPARATOR tryTransformationBeforeUpdate default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.tryTransformationBeforeUpdate(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      transformationTry = TransformationTry(
        code = "foo",
        sampleRecord = buildJsonObject {
          put(
            "bar",
            JsonPrimitive("baz"),
          )
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateAuthentication() {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      authenticationUpdate = AuthenticationUpdate(
        name = "newName",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateDestination() {
    // >SEPARATOR updateDestination default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      destinationUpdate = DestinationUpdate(
        name = "newName",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateSource() {
    // >SEPARATOR updateSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = "newName",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateTask() {
    // >SEPARATOR updateTask default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdate(
        enabled = false,
        cron = "* * * * *",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateTaskV1() {
    // >SEPARATOR updateTaskV1 default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdateV1(
        enabled = false,
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateTransformation() {
    // >SEPARATOR updateTransformation default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.updateTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      transformationCreate = TransformationCreate(
        code = "foo",
        name = "bar",
        description = "baz",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForValidateSource() {
    // >SEPARATOR validateSource default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.validateSource(
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

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForValidateSourceBeforeUpdate() {
    // >SEPARATOR validateSourceBeforeUpdate default
    // Initialize the client
    val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.validateSourceBeforeUpdate(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = "newName",
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }
}

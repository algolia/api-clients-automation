package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.IngestionClient
import algoliasearch.ingestion.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetIngestionClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the createAuthentication method.
    *
    * createAuthenticationOAuth
    */
  def snippetForIngestionClientCreateAuthentication(): Unit = {
    // >SEPARATOR createAuthentication
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.createAuthentication(
      authenticationCreate = AuthenticationCreate(
        `type` = AuthenticationType.withName("oauth"),
        name = "authName",
        input = AuthOAuth(
          url = "http://test.oauth",
          client_id = "myID",
          client_secret = "mySecret"
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createDestination method.
    *
    * createDestination
    */
  def snippetForIngestionClientCreateDestination(): Unit = {
    // >SEPARATOR createDestination
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.createDestination(
      destinationCreate = DestinationCreate(
        `type` = DestinationType.withName("search"),
        name = "destinationName",
        input = DestinationIndexPrefix(
          indexPrefix = "prefix_"
        ),
        authenticationID = Some("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createSource method.
    *
    * createSource
    */
  def snippetForIngestionClientCreateSource(): Unit = {
    // >SEPARATOR createSource
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.createSource(
      sourceCreate = SourceCreate(
        `type` = SourceType.withName("commercetools"),
        name = "sourceName",
        input = SourceCommercetools(
          storeKeys = Some(Seq("myStore")),
          locales = Some(Seq("de")),
          url = "http://commercetools.com",
          projectKey = "keyID"
        ),
        authenticationID = Some("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createTask method.
    *
    * createTaskOnDemand
    */
  def snippetForIngestionClientCreateTask(): Unit = {
    // >SEPARATOR createTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.createTask(
      taskCreate = TaskCreate(
        sourceID = "search",
        destinationID = "destinationName",
        trigger = OnDemandTriggerInput(
          `type` = OnDemandTriggerType.withName("onDemand")
        ),
        action = ActionType.withName("replace")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomGet(): Unit = {
    // >SEPARATOR customGet
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPost(): Unit = {
    // >SEPARATOR customPost
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPut(): Unit = {
    // >SEPARATOR customPut
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteAuthentication method.
    *
    * deleteAuthentication
    */
  def snippetForIngestionClientDeleteAuthentication(): Unit = {
    // >SEPARATOR deleteAuthentication
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteDestination method.
    *
    * deleteDestination
    */
  def snippetForIngestionClientDeleteDestination(): Unit = {
    // >SEPARATOR deleteDestination
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteSource method.
    *
    * deleteSource
    */
  def snippetForIngestionClientDeleteSource(): Unit = {
    // >SEPARATOR deleteSource
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteTask method.
    *
    * deleteTask
    */
  def snippetForIngestionClientDeleteTask(): Unit = {
    // >SEPARATOR deleteTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the disableTask method.
    *
    * disableTask
    */
  def snippetForIngestionClientDisableTask(): Unit = {
    // >SEPARATOR disableTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.disableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the enableTask method.
    *
    * enable task e2e
    */
  def snippetForIngestionClientEnableTask(): Unit = {
    // >SEPARATOR enableTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.enableTask(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getAuthentication method.
    *
    * getAuthentication
    */
  def snippetForIngestionClientGetAuthentication(): Unit = {
    // >SEPARATOR getAuthentication
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getAuthentications method.
    *
    * getAuthentications
    */
  def snippetForIngestionClientGetAuthentications(): Unit = {
    // >SEPARATOR getAuthentications
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getAuthentications(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getDestination method.
    *
    * getDestination
    */
  def snippetForIngestionClientGetDestination(): Unit = {
    // >SEPARATOR getDestination
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getDestinations method.
    *
    * getDestinations
    */
  def snippetForIngestionClientGetDestinations(): Unit = {
    // >SEPARATOR getDestinations
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDestinations(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getDockerSourceStreams method.
    *
    * getDockerSourceStreams
    */
  def snippetForIngestionClientGetDockerSourceStreams(): Unit = {
    // >SEPARATOR getDockerSourceStreams
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDockerSourceStreams(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getEvent method.
    *
    * getEvent
    */
  def snippetForIngestionClientGetEvent(): Unit = {
    // >SEPARATOR getEvent
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getEvent(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      eventID = "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getEvents method.
    *
    * getEvents
    */
  def snippetForIngestionClientGetEvents(): Unit = {
    // >SEPARATOR getEvents
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getEvents(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRun method.
    *
    * getRun
    */
  def snippetForIngestionClientGetRun(): Unit = {
    // >SEPARATOR getRun
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getRun(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRuns method.
    *
    * getRuns
    */
  def snippetForIngestionClientGetRuns(): Unit = {
    // >SEPARATOR getRuns
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getRuns(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getSource method.
    *
    * getSource
    */
  def snippetForIngestionClientGetSource(): Unit = {
    // >SEPARATOR getSource
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getSource(
      sourceID = "75eeb306-51d3-4e5e-a279-3c92bd8893ac"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getSources method.
    *
    * getSources
    */
  def snippetForIngestionClientGetSources(): Unit = {
    // >SEPARATOR getSources
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getSources(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getTask method.
    *
    * getTask
    */
  def snippetForIngestionClientGetTask(): Unit = {
    // >SEPARATOR getTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getTasks method.
    *
    * getTasks
    */
  def snippetForIngestionClientGetTasks(): Unit = {
    // >SEPARATOR getTasks
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getTasks(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the runTask method.
    *
    * runTask
    */
  def snippetForIngestionClientRunTask(): Unit = {
    // >SEPARATOR runTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.runTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchAuthentications method.
    *
    * searchAuthentications
    */
  def snippetForIngestionClientSearchAuthentications(): Unit = {
    // >SEPARATOR searchAuthentications
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.searchAuthentications(
      authenticationSearch = AuthenticationSearch(
        authenticationIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchDestinations method.
    *
    * searchDestinations
    */
  def snippetForIngestionClientSearchDestinations(): Unit = {
    // >SEPARATOR searchDestinations
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.searchDestinations(
      destinationSearch = DestinationSearch(
        destinationIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchSources method.
    *
    * searchSources
    */
  def snippetForIngestionClientSearchSources(): Unit = {
    // >SEPARATOR searchSources
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.searchSources(
      sourceSearch = SourceSearch(
        sourceIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchTasks method.
    *
    * searchTasks
    */
  def snippetForIngestionClientSearchTasks(): Unit = {
    // >SEPARATOR searchTasks
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the triggerDockerSourceDiscover method.
    *
    * triggerDockerSourceDiscover
    */
  def snippetForIngestionClientTriggerDockerSourceDiscover(): Unit = {
    // >SEPARATOR triggerDockerSourceDiscover
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.triggerDockerSourceDiscover(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateAuthentication method.
    *
    * updateAuthentication
    */
  def snippetForIngestionClientUpdateAuthentication(): Unit = {
    // >SEPARATOR updateAuthentication
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.updateAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      authenticationUpdate = AuthenticationUpdate(
        name = Some("newName")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateDestination method.
    *
    * updateDestination
    */
  def snippetForIngestionClientUpdateDestination(): Unit = {
    // >SEPARATOR updateDestination
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.updateDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      destinationUpdate = DestinationUpdate(
        name = Some("newName")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateSource method.
    *
    * updateSource
    */
  def snippetForIngestionClientUpdateSource(): Unit = {
    // >SEPARATOR updateSource
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.updateSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = Some("newName")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateTask method.
    *
    * updateTask
    */
  def snippetForIngestionClientUpdateTask(): Unit = {
    // >SEPARATOR updateTask
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.updateTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdate(
        enabled = Some(false)
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

}

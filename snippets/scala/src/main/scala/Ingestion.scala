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
  }

  /** Snippet for the createDestination method.
    *
    * createDestination
    */
  def snippetForIngestionClientCreateDestination(): Unit = {
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
  }

  /** Snippet for the createSource method.
    *
    * createSource
    */
  def snippetForIngestionClientCreateSource(): Unit = {
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
  }

  /** Snippet for the createTask method.
    *
    * createTaskOnDemand
    */
  def snippetForIngestionClientCreateTask(): Unit = {
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
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomDelete(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomGet(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPost(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPut(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteAuthentication method.
    *
    * deleteAuthentication
    */
  def snippetForIngestionClientDeleteAuthentication(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteDestination method.
    *
    * deleteDestination
    */
  def snippetForIngestionClientDeleteDestination(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteSource method.
    *
    * deleteSource
    */
  def snippetForIngestionClientDeleteSource(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteTask method.
    *
    * deleteTask
    */
  def snippetForIngestionClientDeleteTask(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the disableTask method.
    *
    * disableTask
    */
  def snippetForIngestionClientDisableTask(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.disableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the enableTask method.
    *
    * enableTask
    */
  def snippetForIngestionClientEnableTask(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.enableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getAuthentication method.
    *
    * getAuthentication
    */
  def snippetForIngestionClientGetAuthentication(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getAuthentications method.
    *
    * getAuthentications
    */
  def snippetForIngestionClientGetAuthentications(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getAuthentications(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getDestination method.
    *
    * getDestination
    */
  def snippetForIngestionClientGetDestination(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getDestinations method.
    *
    * getDestinations
    */
  def snippetForIngestionClientGetDestinations(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDestinations(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getDockerSourceStreams method.
    *
    * getDockerSourceStreams
    */
  def snippetForIngestionClientGetDockerSourceStreams(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getDockerSourceStreams(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getEvent method.
    *
    * getEvent
    */
  def snippetForIngestionClientGetEvent(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getEvent(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      eventID = "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getEvents method.
    *
    * getEvents
    */
  def snippetForIngestionClientGetEvents(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getEvents(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRun method.
    *
    * getRun
    */
  def snippetForIngestionClientGetRun(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getRun(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRuns method.
    *
    * getRuns
    */
  def snippetForIngestionClientGetRuns(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getRuns(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSource method.
    *
    * getSource
    */
  def snippetForIngestionClientGetSource(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSources method.
    *
    * getSources
    */
  def snippetForIngestionClientGetSources(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getSources(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTask method.
    *
    * getTask
    */
  def snippetForIngestionClientGetTask(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTasks method.
    *
    * getTasks
    */
  def snippetForIngestionClientGetTasks(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getTasks(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the runTask method.
    *
    * runTask
    */
  def snippetForIngestionClientRunTask(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.runTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchAuthentications method.
    *
    * searchAuthentications
    */
  def snippetForIngestionClientSearchAuthentications(): Unit = {
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
  }

  /** Snippet for the searchDestinations method.
    *
    * searchDestinations
    */
  def snippetForIngestionClientSearchDestinations(): Unit = {
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
  }

  /** Snippet for the searchSources method.
    *
    * searchSources
    */
  def snippetForIngestionClientSearchSources(): Unit = {
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
  }

  /** Snippet for the searchTasks method.
    *
    * searchTasks
    */
  def snippetForIngestionClientSearchTasks(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the triggerDockerSourceDiscover method.
    *
    * triggerDockerSourceDiscover
    */
  def snippetForIngestionClientTriggerDockerSourceDiscover(): Unit = {
    // Initialize the client
    val client = IngestionClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.triggerDockerSourceDiscover(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the updateAuthentication method.
    *
    * updateAuthentication
    */
  def snippetForIngestionClientUpdateAuthentication(): Unit = {
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
  }

  /** Snippet for the updateDestination method.
    *
    * updateDestination
    */
  def snippetForIngestionClientUpdateDestination(): Unit = {
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
  }

  /** Snippet for the updateSource method.
    *
    * updateSource
    */
  def snippetForIngestionClientUpdateSource(): Unit = {
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
  }

  /** Snippet for the updateTask method.
    *
    * updateTask
    */
  def snippetForIngestionClientUpdateTask(): Unit = {
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
  }

}

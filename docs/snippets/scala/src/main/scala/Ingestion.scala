// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.IngestionClient

// IMPORT<
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
    // >SEPARATOR createAuthentication default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createAuthentication(
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

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createDestination method.
    *
    * createDestination
    */
  def snippetForIngestionClientCreateDestination(): Unit = {
    // >SEPARATOR createDestination default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createDestination(
      destinationCreate = DestinationCreate(
        `type` = DestinationType.withName("search"),
        name = "destinationName",
        input = DestinationIndexName(
          indexName = "<YOUR_INDEX_NAME>"
        ),
        authenticationID = Some("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createSource method.
    *
    * createSource
    */
  def snippetForIngestionClientCreateSource(): Unit = {
    // >SEPARATOR createSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createSource(
      sourceCreate = SourceCreate(
        `type` = SourceType.withName("commercetools"),
        name = "sourceName",
        input = Some(
          SourceCommercetools(
            storeKeys = Some(Seq("myStore")),
            locales = Some(Seq("de")),
            url = "http://commercetools.com",
            projectKey = "keyID"
          )
        ),
        authenticationID = Some("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createTask method.
    *
    * task without cron
    */
  def snippetForIngestionClientCreateTask(): Unit = {
    // >SEPARATOR createTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createTask(
      taskCreate = TaskCreate(
        sourceID = "search",
        destinationID = "destinationName",
        action = ActionType.withName("replace")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createTaskV1 method.
    *
    * createTaskOnDemand
    */
  def snippetForIngestionClientCreateTaskV1(): Unit = {
    // >SEPARATOR createTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createTaskV1(
      taskCreate = TaskCreateV1(
        sourceID = "search",
        destinationID = "destinationName",
        trigger = OnDemandTriggerInput(
          `type` = OnDemandTriggerType.withName("onDemand")
        ),
        action = ActionType.withName("replace")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the createTransformation method.
    *
    * createTransformation
    */
  def snippetForIngestionClientCreateTransformation(): Unit = {
    // >SEPARATOR createTransformation default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createTransformation(
      transformationCreate = TransformationCreate(
        code = "foo",
        name = "bar",
        description = Some("baz")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customDelete[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomGet(): Unit = {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customGet[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPost(): Unit = {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customPost[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForIngestionClientCustomPut(): Unit = {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customPut[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteAuthentication method.
    *
    * deleteAuthentication
    */
  def snippetForIngestionClientDeleteAuthentication(): Unit = {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteDestination method.
    *
    * deleteDestination
    */
  def snippetForIngestionClientDeleteDestination(): Unit = {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteSource method.
    *
    * deleteSource
    */
  def snippetForIngestionClientDeleteSource(): Unit = {
    // >SEPARATOR deleteSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteTask method.
    *
    * deleteTask
    */
  def snippetForIngestionClientDeleteTask(): Unit = {
    // >SEPARATOR deleteTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteTaskV1 method.
    *
    * deleteTaskV1
    */
  def snippetForIngestionClientDeleteTaskV1(): Unit = {
    // >SEPARATOR deleteTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteTransformation method.
    *
    * deleteTransformation
    */
  def snippetForIngestionClientDeleteTransformation(): Unit = {
    // >SEPARATOR deleteTransformation default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the disableTask method.
    *
    * disableTask
    */
  def snippetForIngestionClientDisableTask(): Unit = {
    // >SEPARATOR disableTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.disableTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the disableTaskV1 method.
    *
    * disableTaskV1
    */
  def snippetForIngestionClientDisableTaskV1(): Unit = {
    // >SEPARATOR disableTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.disableTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the enableTask method.
    *
    * enableTask
    */
  def snippetForIngestionClientEnableTask(): Unit = {
    // >SEPARATOR enableTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.enableTask(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the enableTaskV1 method.
    *
    * enableTaskV1
    */
  def snippetForIngestionClientEnableTaskV1(): Unit = {
    // >SEPARATOR enableTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.enableTaskV1(
      taskID = "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getAuthentication method.
    *
    * getAuthentication
    */
  def snippetForIngestionClientGetAuthentication(): Unit = {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getDestination method.
    *
    * getDestination
    */
  def snippetForIngestionClientGetDestination(): Unit = {
    // >SEPARATOR getDestination default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getEvent method.
    *
    * getEvent
    */
  def snippetForIngestionClientGetEvent(): Unit = {
    // >SEPARATOR getEvent default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getEvent(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      eventID = "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getRun method.
    *
    * getRun
    */
  def snippetForIngestionClientGetRun(): Unit = {
    // >SEPARATOR getRun default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getRun(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getSource method.
    *
    * getSource
    */
  def snippetForIngestionClientGetSource(): Unit = {
    // >SEPARATOR getSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getSource(
      sourceID = "75eeb306-51d3-4e5e-a279-3c92bd8893ac"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getTask method.
    *
    * getTask
    */
  def snippetForIngestionClientGetTask(): Unit = {
    // >SEPARATOR getTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getTaskV1 method.
    *
    * getTaskV1
    */
  def snippetForIngestionClientGetTaskV1(): Unit = {
    // >SEPARATOR getTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getTransformation method.
    *
    * getTransformation
    */
  def snippetForIngestionClientGetTransformation(): Unit = {
    // >SEPARATOR getTransformation default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listAuthentications method.
    *
    * getAuthentications
    */
  def snippetForIngestionClientListAuthentications(): Unit = {
    // >SEPARATOR listAuthentications default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listAuthentications(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listDestinations method.
    *
    * getDestinations
    */
  def snippetForIngestionClientListDestinations(): Unit = {
    // >SEPARATOR listDestinations default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listDestinations(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listEvents method.
    *
    * getEvents
    */
  def snippetForIngestionClientListEvents(): Unit = {
    // >SEPARATOR listEvents default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listEvents(
      runID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listRuns method.
    *
    * listRuns
    */
  def snippetForIngestionClientListRuns(): Unit = {
    // >SEPARATOR listRuns default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listRuns(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listSources method.
    *
    * listSources
    */
  def snippetForIngestionClientListSources(): Unit = {
    // >SEPARATOR listSources default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listSources(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listTasks method.
    *
    * listTasks
    */
  def snippetForIngestionClientListTasks(): Unit = {
    // >SEPARATOR listTasks default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listTasks(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listTasksV1 method.
    *
    * listTasksV1
    */
  def snippetForIngestionClientListTasksV1(): Unit = {
    // >SEPARATOR listTasksV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listTasksV1(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the listTransformations method.
    *
    * listTransformations
    */
  def snippetForIngestionClientListTransformations(): Unit = {
    // >SEPARATOR listTransformations default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.listTransformations(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the pushTask method.
    *
    * pushTask
    */
  def snippetForIngestionClientPushTask(): Unit = {
    // >SEPARATOR pushTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.pushTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      pushTaskPayload = PushTaskPayload(
        action = Action.withName("addObject"),
        records = Seq(
          PushTaskRecords(
            objectID = "o",
            additionalProperties = Some(List(JField("key", JString("bar")), JField("foo", JString("1"))))
          ),
          PushTaskRecords(
            objectID = "k",
            additionalProperties = Some(List(JField("key", JString("baz")), JField("foo", JString("2"))))
          )
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the runSource method.
    *
    * runSource
    */
  def snippetForIngestionClientRunSource(): Unit = {
    // >SEPARATOR runSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.runSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      runSourcePayload = Some(
        RunSourcePayload(
          indexToInclude = Some(Seq("products_us", "products eu")),
          entityIDs = Some(Seq("1234", "5678")),
          entityType = Some(EntityType.withName("product"))
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the runTask method.
    *
    * runTask
    */
  def snippetForIngestionClientRunTask(): Unit = {
    // >SEPARATOR runTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.runTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the runTaskV1 method.
    *
    * runTaskV1
    */
  def snippetForIngestionClientRunTaskV1(): Unit = {
    // >SEPARATOR runTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.runTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchAuthentications method.
    *
    * searchAuthentications
    */
  def snippetForIngestionClientSearchAuthentications(): Unit = {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchAuthentications(
      authenticationSearch = AuthenticationSearch(
        authenticationIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchDestinations method.
    *
    * searchDestinations
    */
  def snippetForIngestionClientSearchDestinations(): Unit = {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchDestinations(
      destinationSearch = DestinationSearch(
        destinationIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchSources method.
    *
    * searchSources
    */
  def snippetForIngestionClientSearchSources(): Unit = {
    // >SEPARATOR searchSources default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchSources(
      sourceSearch = SourceSearch(
        sourceIDs = Seq("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchTasks method.
    *
    * searchTasks
    */
  def snippetForIngestionClientSearchTasks(): Unit = {
    // >SEPARATOR searchTasks default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchTasks(
      taskSearch = TaskSearch(
        taskIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchTasksV1 method.
    *
    * searchTasksV1
    */
  def snippetForIngestionClientSearchTasksV1(): Unit = {
    // >SEPARATOR searchTasksV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchTasksV1(
      taskSearch = TaskSearch(
        taskIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the searchTransformations method.
    *
    * searchTransformations
    */
  def snippetForIngestionClientSearchTransformations(): Unit = {
    // >SEPARATOR searchTransformations default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.searchTransformations(
      transformationSearch = TransformationSearch(
        transformationIDs = Seq(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the triggerDockerSourceDiscover method.
    *
    * triggerDockerSourceDiscover
    */
  def snippetForIngestionClientTriggerDockerSourceDiscover(): Unit = {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.triggerDockerSourceDiscover(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the tryTransformation method.
    *
    * tryTransformation
    */
  def snippetForIngestionClientTryTransformation(): Unit = {
    // >SEPARATOR tryTransformation default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.tryTransformation(
      transformationTry = TransformationTry(
        code = "foo",
        sampleRecord = JObject(List(JField("bar", JString("baz"))))
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the tryTransformationBeforeUpdate method.
    *
    * tryTransformationBeforeUpdate
    */
  def snippetForIngestionClientTryTransformationBeforeUpdate(): Unit = {
    // >SEPARATOR tryTransformationBeforeUpdate default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.tryTransformationBeforeUpdate(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      transformationTry = TransformationTry(
        code = "foo",
        sampleRecord = JObject(List(JField("bar", JString("baz"))))
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateAuthentication method.
    *
    * updateAuthentication
    */
  def snippetForIngestionClientUpdateAuthentication(): Unit = {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateAuthentication(
      authenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      authenticationUpdate = AuthenticationUpdate(
        name = Some("newName")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateDestination method.
    *
    * updateDestination
    */
  def snippetForIngestionClientUpdateDestination(): Unit = {
    // >SEPARATOR updateDestination default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateDestination(
      destinationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      destinationUpdate = DestinationUpdate(
        name = Some("newName")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateSource method.
    *
    * updateSource
    */
  def snippetForIngestionClientUpdateSource(): Unit = {
    // >SEPARATOR updateSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateSource(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = Some("newName")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateTask method.
    *
    * updateTask
    */
  def snippetForIngestionClientUpdateTask(): Unit = {
    // >SEPARATOR updateTask default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateTask(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdate(
        enabled = Some(false),
        cron = Some("* * * * *")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateTaskV1 method.
    *
    * updateTaskV1
    */
  def snippetForIngestionClientUpdateTaskV1(): Unit = {
    // >SEPARATOR updateTaskV1 default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateTaskV1(
      taskID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      taskUpdate = TaskUpdateV1(
        enabled = Some(false)
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateTransformation method.
    *
    * updateTransformation
    */
  def snippetForIngestionClientUpdateTransformation(): Unit = {
    // >SEPARATOR updateTransformation default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateTransformation(
      transformationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      transformationCreate = TransformationCreate(
        code = "foo",
        name = "bar",
        description = Some("baz")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the validateSource method.
    *
    * validateSource
    */
  def snippetForIngestionClientValidateSource(): Unit = {
    // >SEPARATOR validateSource default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.validateSource(
      sourceCreate = Some(
        SourceCreate(
          `type` = SourceType.withName("commercetools"),
          name = "sourceName",
          input = Some(
            SourceCommercetools(
              storeKeys = Some(Seq("myStore")),
              locales = Some(Seq("de")),
              url = "http://commercetools.com",
              projectKey = "keyID"
            )
          ),
          authenticationID = Some("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        )
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the validateSourceBeforeUpdate method.
    *
    * validateSourceBeforeUpdate
    */
  def snippetForIngestionClientValidateSourceBeforeUpdate(): Unit = {
    // >SEPARATOR validateSourceBeforeUpdate default
    // Initialize the client
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.validateSourceBeforeUpdate(
      sourceID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      sourceUpdate = SourceUpdate(
        name = Some("newName")
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

}

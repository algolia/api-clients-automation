package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.IngestionClient;
import com.algolia.model.ingestion.*;

// IMPORT<

class SnippetIngestionClient {

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationOAuth
  void snippetForCreateAuthentication() {
    // >SEPARATOR createAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createAuthentication(
      new AuthenticationCreate()
        .setType(AuthenticationType.OAUTH)
        .setName("authName")
        .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the createDestination method.
  //
  // createDestination
  void snippetForCreateDestination() {
    // >SEPARATOR createDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createDestination(
      new DestinationCreate()
        .setType(DestinationType.SEARCH)
        .setName("destinationName")
        .setInput(new DestinationIndexName().setIndexName("<YOUR_INDEX_NAME>"))
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the createSource method.
  //
  // createSource
  void snippetForCreateSource() {
    // >SEPARATOR createSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createSource(
      new SourceCreate()
        .setType(SourceType.COMMERCETOOLS)
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(Arrays.asList("myStore"))
            .setLocales(Arrays.asList("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the createTask method.
  //
  // task without cron
  void snippetForCreateTask() {
    // >SEPARATOR createTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createTask(new TaskCreate().setSourceID("search").setDestinationID("destinationName").setAction(ActionType.REPLACE));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the createTaskV1 method.
  //
  // createTaskOnDemand
  void snippetForCreateTaskV1() {
    // >SEPARATOR createTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createTaskV1(
      new TaskCreateV1()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
        .setAction(ActionType.REPLACE)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the createTransformation method.
  //
  // createTransformation
  void snippetForCreateTransformation() {
    // >SEPARATOR createTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createTransformation(new TransformationCreate().setCode("foo").setName("bar").setDescription("baz"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteAuthentication method.
  //
  // deleteAuthentication
  void snippetForDeleteAuthentication() {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteDestination method.
  //
  // deleteDestination
  void snippetForDeleteDestination() {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() {
    // >SEPARATOR deleteSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteTask method.
  //
  // deleteTask
  void snippetForDeleteTask() {
    // >SEPARATOR deleteTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteTaskV1 method.
  //
  // deleteTaskV1
  void snippetForDeleteTaskV1() {
    // >SEPARATOR deleteTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteTransformation method.
  //
  // deleteTransformation
  void snippetForDeleteTransformation() {
    // >SEPARATOR deleteTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the disableTask method.
  //
  // disableTask
  void snippetForDisableTask() {
    // >SEPARATOR disableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the disableTaskV1 method.
  //
  // disableTaskV1
  void snippetForDisableTaskV1() {
    // >SEPARATOR disableTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.disableTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the enableTask method.
  //
  // enableTask
  void snippetForEnableTask() {
    // >SEPARATOR enableTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the enableTaskV1 method.
  //
  // enableTaskV1
  void snippetForEnableTaskV1() {
    // >SEPARATOR enableTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.enableTaskV1("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getAuthentication method.
  //
  // getAuthentication
  void snippetForGetAuthentication() {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getDestination method.
  //
  // getDestination
  void snippetForGetDestination() {
    // >SEPARATOR getDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getEvent method.
  //
  // getEvent
  void snippetForGetEvent() {
    // >SEPARATOR getEvent default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getRun method.
  //
  // getRun
  void snippetForGetRun() {
    // >SEPARATOR getRun default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSource method.
  //
  // getSource
  void snippetForGetSource() {
    // >SEPARATOR getSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() {
    // >SEPARATOR getTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTaskV1 method.
  //
  // getTaskV1
  void snippetForGetTaskV1() {
    // >SEPARATOR getTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTransformation method.
  //
  // getTransformation
  void snippetForGetTransformation() {
    // >SEPARATOR getTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listAuthentications method.
  //
  // getAuthentications
  void snippetForListAuthentications() {
    // >SEPARATOR listAuthentications default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listAuthentications();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listDestinations method.
  //
  // getDestinations
  void snippetForListDestinations() {
    // >SEPARATOR listDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listDestinations();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listEvents method.
  //
  // getEvents
  void snippetForListEvents() {
    // >SEPARATOR listEvents default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listRuns method.
  //
  // listRuns
  void snippetForListRuns() {
    // >SEPARATOR listRuns default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listRuns();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listSources method.
  //
  // listSources
  void snippetForListSources() {
    // >SEPARATOR listSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listSources();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listTasks method.
  //
  // listTasks
  void snippetForListTasks() {
    // >SEPARATOR listTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listTasks();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listTasksV1 method.
  //
  // listTasksV1
  void snippetForListTasksV1() {
    // >SEPARATOR listTasksV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listTasksV1();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listTransformations method.
  //
  // listTransformations
  void snippetForListTransformations() {
    // >SEPARATOR listTransformations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.listTransformations();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the pushTask method.
  //
  // pushTask
  void snippetForPushTask() {
    // >SEPARATOR pushTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.pushTask(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new PushTaskPayload()
        .setAction(Action.ADD_OBJECT)
        .setRecords(
          Arrays.asList(
            new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
            new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the runSource method.
  //
  // runSource
  void snippetForRunSource() {
    // >SEPARATOR runSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.runSource(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new RunSourcePayload()
        .setIndexToInclude(Arrays.asList("products_us", "products eu"))
        .setEntityIDs(Arrays.asList("1234", "5678"))
        .setEntityType(EntityType.PRODUCT)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the runTask method.
  //
  // runTask
  void snippetForRunTask() {
    // >SEPARATOR runTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the runTaskV1 method.
  //
  // runTaskV1
  void snippetForRunTaskV1() {
    // >SEPARATOR runTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.runTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchAuthentications method.
  //
  // searchAuthentications
  void snippetForSearchAuthentications() {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchAuthentications(
      new AuthenticationSearch()
        .setAuthenticationIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchDestinations method.
  //
  // searchDestinations
  void snippetForSearchDestinations() {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchDestinations(
      new DestinationSearch()
        .setDestinationIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSources method.
  //
  // searchSources
  void snippetForSearchSources() {
    // >SEPARATOR searchSources default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchSources(
      new SourceSearch().setSourceIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchTasks method.
  //
  // searchTasks
  void snippetForSearchTasks() {
    // >SEPARATOR searchTasks default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchTasks(
      new TaskSearch()
        .setTaskIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchTasksV1 method.
  //
  // searchTasksV1
  void snippetForSearchTasksV1() {
    // >SEPARATOR searchTasksV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchTasksV1(
      new TaskSearch()
        .setTaskIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchTransformations method.
  //
  // searchTransformations
  void snippetForSearchTransformations() {
    // >SEPARATOR searchTransformations default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchTransformations(
      new TransformationSearch()
        .setTransformationIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the triggerDockerSourceDiscover method.
  //
  // triggerDockerSourceDiscover
  void snippetForTriggerDockerSourceDiscover() {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the tryTransformation method.
  //
  // tryTransformation
  void snippetForTryTransformation() {
    // >SEPARATOR tryTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.tryTransformation(
      new TransformationTry()
        .setCode("foo")
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the tryTransformationBeforeUpdate method.
  //
  // tryTransformationBeforeUpdate
  void snippetForTryTransformationBeforeUpdate() {
    // >SEPARATOR tryTransformationBeforeUpdate default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.tryTransformationBeforeUpdate(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationTry()
        .setCode("foo")
        .setSampleRecord(
          new HashMap() {
            {
              put("bar", "baz");
            }
          }
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateAuthentication method.
  //
  // updateAuthentication
  void snippetForUpdateAuthentication() {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new AuthenticationUpdate().setName("newName"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateDestination method.
  //
  // updateDestination
  void snippetForUpdateDestination() {
    // >SEPARATOR updateDestination default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new DestinationUpdate().setName("newName"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateSource method.
  //
  // updateSource
  void snippetForUpdateSource() {
    // >SEPARATOR updateSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateTask method.
  //
  // updateTask
  void snippetForUpdateTask() {
    // >SEPARATOR updateTask default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false).setCron("* * * * *"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateTaskV1 method.
  //
  // updateTaskV1
  void snippetForUpdateTaskV1() {
    // >SEPARATOR updateTaskV1 default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdateV1().setEnabled(false));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateTransformation method.
  //
  // updateTransformation
  void snippetForUpdateTransformation() {
    // >SEPARATOR updateTransformation default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateTransformation(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationCreate().setCode("foo").setName("bar").setDescription("baz")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the validateSource method.
  //
  // validateSource
  void snippetForValidateSource() {
    // >SEPARATOR validateSource default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.validateSource(
      new SourceCreate()
        .setType(SourceType.COMMERCETOOLS)
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(Arrays.asList("myStore"))
            .setLocales(Arrays.asList("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the validateSourceBeforeUpdate method.
  //
  // validateSourceBeforeUpdate
  void snippetForValidateSourceBeforeUpdate() {
    // >SEPARATOR validateSourceBeforeUpdate default
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.validateSourceBeforeUpdate("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    // >LOG
    // SEPARATOR<
  }
}

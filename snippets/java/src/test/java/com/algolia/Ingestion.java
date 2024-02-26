package com.algolia.methods.snippets;

import com.algolia.api.IngestionClient;
import com.algolia.model.ingestion.*;

class SnippetIngestionClient {

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationOAuth
  void snippetForCreateAuthentication() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createAuthentication(
      new AuthenticationCreate()
        .setType(AuthenticationType.fromValue("oauth"))
        .setName("authName")
        .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
    );
  }

  // Snippet for the createDestination method.
  //
  // createDestination
  void snippetForCreateDestination() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createDestination(
      new DestinationCreate()
        .setType(DestinationType.fromValue("search"))
        .setName("destinationName")
        .setInput(new DestinationIndexPrefix().setIndexPrefix("prefix_"))
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
  }

  // Snippet for the createSource method.
  //
  // createSource
  void snippetForCreateSource() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createSource(
      new SourceCreate()
        .setType(SourceType.fromValue("commercetools"))
        .setName("sourceName")
        .setInput(
          new SourceCommercetools()
            .setStoreKeys(List.of("myStore"))
            .setLocales(List.of("de"))
            .setUrl("http://commercetools.com")
            .setProjectKey("keyID")
        )
        .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
    );
  }

  // Snippet for the createTask method.
  //
  // createTaskOnDemand
  void snippetForCreateTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createTask(
      new TaskCreate()
        .setSourceID("search")
        .setDestinationID("destinationName")
        .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.fromValue("onDemand")))
        .setAction(ActionType.fromValue("replace"))
    );
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the deleteAuthentication method.
  //
  // deleteAuthentication
  void snippetForDeleteAuthentication() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteDestination method.
  //
  // deleteDestination
  void snippetForDeleteDestination() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteTask method.
  //
  // deleteTask
  void snippetForDeleteTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the disableTask method.
  //
  // disableTask
  void snippetForDisableTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the enableTask method.
  //
  // enable task e2e
  void snippetForEnableTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
  }

  // Snippet for the getAuthentication method.
  //
  // getAuthentication
  void snippetForGetAuthentication() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getAuthentications method.
  //
  // getAuthentications
  void snippetForGetAuthentications() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAuthentications();
  }

  // Snippet for the getDestination method.
  //
  // getDestination
  void snippetForGetDestination() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getDestinations method.
  //
  // getDestinations
  void snippetForGetDestinations() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDestinations();
  }

  // Snippet for the getDockerSourceStreams method.
  //
  // getDockerSourceStreams
  void snippetForGetDockerSourceStreams() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getDockerSourceStreams("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getEvent method.
  //
  // getEvent
  void snippetForGetEvent() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
  }

  // Snippet for the getEvents method.
  //
  // getEvents
  void snippetForGetEvents() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getRun method.
  //
  // getRun
  void snippetForGetRun() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getRuns method.
  //
  // getRuns
  void snippetForGetRuns() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getRuns();
  }

  // Snippet for the getSource method.
  //
  // getSource
  void snippetForGetSource() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
  }

  // Snippet for the getSources method.
  //
  // getSources
  void snippetForGetSources() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getSources();
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getTasks method.
  //
  // getTasks
  void snippetForGetTasks() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getTasks();
  }

  // Snippet for the runTask method.
  //
  // runTask
  void snippetForRunTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the searchAuthentications method.
  //
  // searchAuthentications
  void snippetForSearchAuthentications() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchAuthentications(
      new AuthenticationSearch()
        .setAuthenticationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchDestinations method.
  //
  // searchDestinations
  void snippetForSearchDestinations() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchDestinations(
      new DestinationSearch().setDestinationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchSources method.
  //
  // searchSources
  void snippetForSearchSources() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchSources(
      new SourceSearch().setSourceIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchTasks method.
  //
  // searchTasks
  void snippetForSearchTasks() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.searchTasks(
      new TaskSearch()
        .setTaskIDs(
          List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        )
    );
  }

  // Snippet for the triggerDockerSourceDiscover method.
  //
  // triggerDockerSourceDiscover
  void snippetForTriggerDockerSourceDiscover() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the updateAuthentication method.
  //
  // updateAuthentication
  void snippetForUpdateAuthentication() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new AuthenticationUpdate().setName("newName"));
  }

  // Snippet for the updateDestination method.
  //
  // updateDestination
  void snippetForUpdateDestination() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new DestinationUpdate().setName("newName"));
  }

  // Snippet for the updateSource method.
  //
  // updateSource
  void snippetForUpdateSource() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
  }

  // Snippet for the updateTask method.
  //
  // updateTask
  void snippetForUpdateTask() {
    // Initialize the client
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false));
  }
}

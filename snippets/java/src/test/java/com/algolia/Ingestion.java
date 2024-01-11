package com.algolia.methods.snippets;

import com.algolia.api.IngestionClient;
import com.algolia.model.ingestion.*;

class SnippetIngestionClient {

  // Snippet for the createAuthentication method.
  //
  // createAuthenticationOAuth
  void SnippetForCreateAuthentication() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  void SnippetForCreateDestination() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  void SnippetForCreateSource() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  void SnippetForCreateTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  void SnippetForCustomDelete() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteAuthentication method.
  //
  // deleteAuthentication
  void SnippetForDeleteAuthentication() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteDestination method.
  //
  // deleteDestination
  void SnippetForDeleteDestination() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void SnippetForDeleteSource() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the deleteTask method.
  //
  // deleteTask
  void SnippetForDeleteTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the disableTask method.
  //
  // disableTask
  void SnippetForDisableTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the enableTask method.
  //
  // enableTask
  void SnippetForEnableTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.enableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getAuthentication method.
  //
  // getAuthentication
  void SnippetForGetAuthentication() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getAuthentications method.
  //
  // getAuthentications
  void SnippetForGetAuthentications() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getAuthentications();
  }

  // Snippet for the getDestination method.
  //
  // getDestination
  void SnippetForGetDestination() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getDestinations method.
  //
  // getDestinations
  void SnippetForGetDestinations() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getDestinations();
  }

  // Snippet for the getDockerSourceStreams method.
  //
  // getDockerSourceStreams
  void SnippetForGetDockerSourceStreams() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getDockerSourceStreams("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getEvent method.
  //
  // getEvent
  void SnippetForGetEvent() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
  }

  // Snippet for the getEvents method.
  //
  // getEvents
  void SnippetForGetEvents() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getRun method.
  //
  // getRun
  void SnippetForGetRun() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getRuns method.
  //
  // getRuns
  void SnippetForGetRuns() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getRuns();
  }

  // Snippet for the getSource method.
  //
  // getSource
  void SnippetForGetSource() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getSources method.
  //
  // getSources
  void SnippetForGetSources() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getSources();
  }

  // Snippet for the getTask method.
  //
  // getTask
  void SnippetForGetTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the getTasks method.
  //
  // getTasks
  void SnippetForGetTasks() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getTasks();
  }

  // Snippet for the runTask method.
  //
  // runTask
  void SnippetForRunTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the searchAuthentications method.
  //
  // searchAuthentications
  void SnippetForSearchAuthentications() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.searchAuthentications(
      new AuthenticationSearch()
        .setAuthenticationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchDestinations method.
  //
  // searchDestinations
  void SnippetForSearchDestinations() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.searchDestinations(
      new DestinationSearch().setDestinationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchSources method.
  //
  // searchSources
  void SnippetForSearchSources() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.searchSources(
      new SourceSearch().setSourceIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the searchTasks method.
  //
  // searchTasks
  void SnippetForSearchTasks() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.searchTasks(
      new TaskSearch().setTaskIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
    );
  }

  // Snippet for the triggerDockerSourceDiscover method.
  //
  // triggerDockerSourceDiscover
  void SnippetForTriggerDockerSourceDiscover() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  // Snippet for the updateAuthentication method.
  //
  // updateAuthentication
  void SnippetForUpdateAuthentication() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.updateAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new AuthenticationUpdate().setName("newName"));
  }

  // Snippet for the updateDestination method.
  //
  // updateDestination
  void SnippetForUpdateDestination() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.updateDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new DestinationUpdate().setName("newName"));
  }

  // Snippet for the updateSource method.
  //
  // updateSource
  void SnippetForUpdateSource() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
  }

  // Snippet for the updateTask method.
  //
  // updateTask
  void SnippetForUpdateTask() {
    IngestionClient client = new IngestionClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false));
  }
}

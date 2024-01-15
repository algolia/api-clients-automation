using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetIngestionClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the createAuthentication method.
  ///
  /// createAuthenticationOAuth
  /// </summary>
  public async Task SnippetForCreateAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var authenticationCreate0 = new AuthenticationCreate();
    {
      var type1 = (AuthenticationType)Enum.Parse(typeof(AuthenticationType), "Oauth");
      authenticationCreate0.Type = type1; const string name1 = "authName";
      authenticationCreate0.Name = name1; var input1 = new AuthOAuth();
      {
        const string url2 = "http://test.oauth";
        input1.Url = url2; const string client_id2 = "myID";
        input1.ClientId = client_id2; const string client_secret2 = "mySecret";
        input1.ClientSecret = client_secret2;
      }
      authenticationCreate0.Input = new AuthInput(input1);
    }


    var response = await _client.CreateAuthenticationAsync(authenticationCreate0);
  }

  /// <summary>
  /// Snippet for the createDestination method.
  ///
  /// createDestination
  /// </summary>
  public async Task SnippetForCreateDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var destinationCreate0 = new DestinationCreate();
    {
      var type1 = (DestinationType)Enum.Parse(typeof(DestinationType), "Search");
      destinationCreate0.Type = type1; const string name1 = "destinationName";
      destinationCreate0.Name = name1; var input1 = new DestinationIndexPrefix();
      {
        const string indexPrefix2 = "prefix_";
        input1.IndexPrefix = indexPrefix2;
      }
      destinationCreate0.Input = new DestinationInput(input1); const string authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      destinationCreate0.AuthenticationID = authenticationID1;
    }


    var response = await _client.CreateDestinationAsync(destinationCreate0);
  }

  /// <summary>
  /// Snippet for the createSource method.
  ///
  /// createSource
  /// </summary>
  public async Task SnippetForCreateSource0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var sourceCreate0 = new SourceCreate();
    {
      var type1 = (SourceType)Enum.Parse(typeof(SourceType), "Commercetools");
      sourceCreate0.Type = type1; const string name1 = "sourceName";
      sourceCreate0.Name = name1; var input1 = new SourceCommercetools();
      {
        var storeKeys2 = new List<string>();
        const string storeKeys_03 = "myStore";
        storeKeys2.Add(storeKeys_03);
        input1.StoreKeys = storeKeys2; var locales2 = new List<string>();
        const string locales_03 = "de";
        locales2.Add(locales_03);
        input1.Locales = locales2; const string url2 = "http://commercetools.com";
        input1.Url = url2; const string projectKey2 = "keyID";
        input1.ProjectKey = projectKey2;
      }
      sourceCreate0.Input = new SourceInput(input1); const string authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      sourceCreate0.AuthenticationID = authenticationID1;
    }


    var response = await _client.CreateSourceAsync(sourceCreate0);
  }

  /// <summary>
  /// Snippet for the createTask method.
  ///
  /// createTaskOnDemand
  /// </summary>
  public async Task SnippetForCreateTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var taskCreate0 = new TaskCreate();
    {
      const string sourceID1 = "search";
      taskCreate0.SourceID = sourceID1; const string destinationID1 = "destinationName";
      taskCreate0.DestinationID = destinationID1; var trigger1 = new OnDemandTriggerInput();
      {
        var type2 = (OnDemandTriggerType)Enum.Parse(typeof(OnDemandTriggerType), "OnDemand");
        trigger1.Type = type2;
      }
      taskCreate0.Trigger = new TaskCreateTrigger(trigger1); var action1 = (ActionType)Enum.Parse(typeof(ActionType), "Replace");
      taskCreate0.Action = action1;
    }


    var response = await _client.CreateTaskAsync(taskCreate0);
  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomDeleteAsync(path0);
  }

  /// <summary>
  /// Snippet for the customGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomGetAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPostAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteAuthentication method.
  ///
  /// deleteAuthentication
  /// </summary>
  public async Task SnippetForDeleteAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.DeleteAuthenticationAsync(authenticationID0);
  }

  /// <summary>
  /// Snippet for the deleteDestination method.
  ///
  /// deleteDestination
  /// </summary>
  public async Task SnippetForDeleteDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.DeleteDestinationAsync(destinationID0);
  }

  /// <summary>
  /// Snippet for the deleteSource method.
  ///
  /// deleteSource
  /// </summary>
  public async Task SnippetForDeleteSource0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.DeleteSourceAsync(sourceID0);
  }

  /// <summary>
  /// Snippet for the deleteTask method.
  ///
  /// deleteTask
  /// </summary>
  public async Task SnippetForDeleteTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.DeleteTaskAsync(taskID0);
  }

  /// <summary>
  /// Snippet for the disableTask method.
  ///
  /// disableTask
  /// </summary>
  public async Task SnippetForDisableTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.DisableTaskAsync(taskID0);
  }

  /// <summary>
  /// Snippet for the enableTask method.
  ///
  /// enableTask
  /// </summary>
  public async Task SnippetForEnableTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.EnableTaskAsync(taskID0);
  }

  /// <summary>
  /// Snippet for the getAuthentication method.
  ///
  /// getAuthentication
  /// </summary>
  public async Task SnippetForGetAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetAuthenticationAsync(authenticationID0);
  }

  /// <summary>
  /// Snippet for the getAuthentications method.
  ///
  /// getAuthentications
  /// </summary>
  public async Task SnippetForGetAuthentications0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetAuthenticationsAsync();
  }

  /// <summary>
  /// Snippet for the getDestination method.
  ///
  /// getDestination
  /// </summary>
  public async Task SnippetForGetDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetDestinationAsync(destinationID0);
  }

  /// <summary>
  /// Snippet for the getDestinations method.
  ///
  /// getDestinations
  /// </summary>
  public async Task SnippetForGetDestinations0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetDestinationsAsync();
  }

  /// <summary>
  /// Snippet for the getDockerSourceStreams method.
  ///
  /// getDockerSourceStreams
  /// </summary>
  public async Task SnippetForGetDockerSourceStreams0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetDockerSourceStreamsAsync(sourceID0);
  }

  /// <summary>
  /// Snippet for the getEvent method.
  ///
  /// getEvent
  /// </summary>
  public async Task SnippetForGetEvent0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    const string eventID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0c";


    var response = await _client.GetEventAsync(runID0, eventID0);
  }

  /// <summary>
  /// Snippet for the getEvents method.
  ///
  /// getEvents
  /// </summary>
  public async Task SnippetForGetEvents0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetEventsAsync(runID0);
  }

  /// <summary>
  /// Snippet for the getRun method.
  ///
  /// getRun
  /// </summary>
  public async Task SnippetForGetRun0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetRunAsync(runID0);
  }

  /// <summary>
  /// Snippet for the getRuns method.
  ///
  /// getRuns
  /// </summary>
  public async Task SnippetForGetRuns0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetRunsAsync();
  }

  /// <summary>
  /// Snippet for the getSource method.
  ///
  /// getSource
  /// </summary>
  public async Task SnippetForGetSource0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetSourceAsync(sourceID0);
  }

  /// <summary>
  /// Snippet for the getSources method.
  ///
  /// getSources
  /// </summary>
  public async Task SnippetForGetSources0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetSourcesAsync();
  }

  /// <summary>
  /// Snippet for the getTask method.
  ///
  /// getTask
  /// </summary>
  public async Task SnippetForGetTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.GetTaskAsync(taskID0);
  }

  /// <summary>
  /// Snippet for the getTasks method.
  ///
  /// getTasks
  /// </summary>
  public async Task SnippetForGetTasks0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetTasksAsync();
  }

  /// <summary>
  /// Snippet for the runTask method.
  ///
  /// runTask
  /// </summary>
  public async Task SnippetForRunTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.RunTaskAsync(taskID0);
  }

  /// <summary>
  /// Snippet for the searchAuthentications method.
  ///
  /// searchAuthentications
  /// </summary>
  public async Task SnippetForSearchAuthentications0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var authenticationSearch0 = new AuthenticationSearch();
    {
      var authenticationIDs1 = new List<string>();
      const string authenticationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      authenticationIDs1.Add(authenticationIDs_02); const string authenticationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      authenticationIDs1.Add(authenticationIDs_12);
      authenticationSearch0.AuthenticationIDs = authenticationIDs1;
    }


    var response = await _client.SearchAuthenticationsAsync(authenticationSearch0);
  }

  /// <summary>
  /// Snippet for the searchDestinations method.
  ///
  /// searchDestinations
  /// </summary>
  public async Task SnippetForSearchDestinations0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var destinationSearch0 = new DestinationSearch();
    {
      var destinationIDs1 = new List<string>();
      const string destinationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      destinationIDs1.Add(destinationIDs_02); const string destinationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      destinationIDs1.Add(destinationIDs_12);
      destinationSearch0.DestinationIDs = destinationIDs1;
    }


    var response = await _client.SearchDestinationsAsync(destinationSearch0);
  }

  /// <summary>
  /// Snippet for the searchSources method.
  ///
  /// searchSources
  /// </summary>
  public async Task SnippetForSearchSources0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var sourceSearch0 = new SourceSearch();
    {
      var sourceIDs1 = new List<string>();
      const string sourceIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      sourceIDs1.Add(sourceIDs_02); const string sourceIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      sourceIDs1.Add(sourceIDs_12);
      sourceSearch0.SourceIDs = sourceIDs1;
    }


    var response = await _client.SearchSourcesAsync(sourceSearch0);
  }

  /// <summary>
  /// Snippet for the searchTasks method.
  ///
  /// searchTasks
  /// </summary>
  public async Task SnippetForSearchTasks0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var taskSearch0 = new TaskSearch();
    {
      var taskIDs1 = new List<string>();
      const string taskIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      taskIDs1.Add(taskIDs_02); const string taskIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      taskIDs1.Add(taskIDs_12);
      taskSearch0.TaskIDs = taskIDs1;
    }


    var response = await _client.SearchTasksAsync(taskSearch0);
  }

  /// <summary>
  /// Snippet for the triggerDockerSourceDiscover method.
  ///
  /// triggerDockerSourceDiscover
  /// </summary>
  public async Task SnippetForTriggerDockerSourceDiscover0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";


    var response = await _client.TriggerDockerSourceDiscoverAsync(sourceID0);
  }

  /// <summary>
  /// Snippet for the updateAuthentication method.
  ///
  /// updateAuthentication
  /// </summary>
  public async Task SnippetForUpdateAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var authenticationUpdate0 = new AuthenticationUpdate();
    {
      const string name1 = "newName";
      authenticationUpdate0.Name = name1;
    }


    var response = await _client.UpdateAuthenticationAsync(authenticationID0, authenticationUpdate0);
  }

  /// <summary>
  /// Snippet for the updateDestination method.
  ///
  /// updateDestination
  /// </summary>
  public async Task SnippetForUpdateDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var destinationUpdate0 = new DestinationUpdate();
    {
      const string name1 = "newName";
      destinationUpdate0.Name = name1;
    }


    var response = await _client.UpdateDestinationAsync(destinationID0, destinationUpdate0);
  }

  /// <summary>
  /// Snippet for the updateSource method.
  ///
  /// updateSource
  /// </summary>
  public async Task SnippetForUpdateSource0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var sourceUpdate0 = new SourceUpdate();
    {
      const string name1 = "newName";
      sourceUpdate0.Name = name1;
    }


    var response = await _client.UpdateSourceAsync(sourceID0, sourceUpdate0);
  }

  /// <summary>
  /// Snippet for the updateTask method.
  ///
  /// updateTask
  /// </summary>
  public async Task SnippetForUpdateTask0()
  {
    // Initialize the client
    var client = new IngestionClient(new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var taskUpdate0 = new TaskUpdate();
    {
      const bool enabled1 = false;
      taskUpdate0.Enabled = enabled1;
    }


    var response = await _client.UpdateTaskAsync(taskID0, taskUpdate0);
  }

}

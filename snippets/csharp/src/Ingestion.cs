using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Ingestion;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetIngestionClient
{
  /// <summary>
  /// Snippet for the CreateAuthentication method.
  ///
  /// createAuthenticationOAuth
  /// </summary>
  public async Task SnippetForCreateAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CreateAuthenticationAsync(
      new AuthenticationCreate
      {
        Type = Enum.Parse<AuthenticationType>("Oauth"),
        Name = "authName",
        Input = new AuthInput(
          new AuthOAuth
          {
            Url = "http://test.oauth",
            ClientId = "myID",
            ClientSecret = "mySecret",
          }
        ),
      }
    );
  }

  /// <summary>
  /// Snippet for the CreateDestination method.
  ///
  /// createDestination
  /// </summary>
  public async Task SnippetForCreateDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CreateDestinationAsync(
      new DestinationCreate
      {
        Type = Enum.Parse<DestinationType>("Search"),
        Name = "destinationName",
        Input = new DestinationInput(new DestinationIndexPrefix { IndexPrefix = "prefix_", }),
        AuthenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      }
    );
  }

  /// <summary>
  /// Snippet for the CreateSource method.
  ///
  /// createSource
  /// </summary>
  public async Task SnippetForCreateSource0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CreateSourceAsync(
      new SourceCreate
      {
        Type = Enum.Parse<SourceType>("Commercetools"),
        Name = "sourceName",
        Input = new SourceInput(
          new SourceCommercetools
          {
            StoreKeys = new List<string> { "myStore" },
            Locales = new List<string> { "de" },
            Url = "http://commercetools.com",
            ProjectKey = "keyID",
          }
        ),
        AuthenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      }
    );
  }

  /// <summary>
  /// Snippet for the CreateTask method.
  ///
  /// createTaskOnDemand
  /// </summary>
  public async Task SnippetForCreateTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CreateTaskAsync(
      new TaskCreate
      {
        SourceID = "search",
        DestinationID = "destinationName",
        Trigger = new TaskCreateTrigger(
          new OnDemandTriggerInput { Type = Enum.Parse<OnDemandTriggerType>("OnDemand"), }
        ),
        Action = Enum.Parse<ActionType>("Replace"),
      }
    );
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the DeleteAuthentication method.
  ///
  /// deleteAuthentication
  /// </summary>
  public async Task SnippetForDeleteAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the DeleteDestination method.
  ///
  /// deleteDestination
  /// </summary>
  public async Task SnippetForDeleteDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the DeleteSource method.
  ///
  /// deleteSource
  /// </summary>
  public async Task SnippetForDeleteSource0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the DeleteTask method.
  ///
  /// deleteTask
  /// </summary>
  public async Task SnippetForDeleteTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the DisableTask method.
  ///
  /// disableTask
  /// </summary>
  public async Task SnippetForDisableTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DisableTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the EnableTask method.
  ///
  /// enableTask
  /// </summary>
  public async Task SnippetForEnableTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.EnableTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetAuthentication method.
  ///
  /// getAuthentication
  /// </summary>
  public async Task SnippetForGetAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetAuthentications method.
  ///
  /// getAuthentications
  /// </summary>
  public async Task SnippetForGetAuthentications0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAuthenticationsAsync();
  }

  /// <summary>
  /// Snippet for the GetDestination method.
  ///
  /// getDestination
  /// </summary>
  public async Task SnippetForGetDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetDestinations method.
  ///
  /// getDestinations
  /// </summary>
  public async Task SnippetForGetDestinations0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDestinationsAsync();
  }

  /// <summary>
  /// Snippet for the GetDockerSourceStreams method.
  ///
  /// getDockerSourceStreams
  /// </summary>
  public async Task SnippetForGetDockerSourceStreams0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDockerSourceStreamsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetEvent method.
  ///
  /// getEvent
  /// </summary>
  public async Task SnippetForGetEvent0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetEventAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    );
  }

  /// <summary>
  /// Snippet for the GetEvents method.
  ///
  /// getEvents
  /// </summary>
  public async Task SnippetForGetEvents0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetEventsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetRun method.
  ///
  /// getRun
  /// </summary>
  public async Task SnippetForGetRun0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetRunAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetRuns method.
  ///
  /// getRuns
  /// </summary>
  public async Task SnippetForGetRuns0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetRunsAsync();
  }

  /// <summary>
  /// Snippet for the GetSource method.
  ///
  /// getSource
  /// </summary>
  public async Task SnippetForGetSource0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetSources method.
  ///
  /// getSources
  /// </summary>
  public async Task SnippetForGetSources0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSourcesAsync();
  }

  /// <summary>
  /// Snippet for the GetTask method.
  ///
  /// getTask
  /// </summary>
  public async Task SnippetForGetTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the GetTasks method.
  ///
  /// getTasks
  /// </summary>
  public async Task SnippetForGetTasks0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTasksAsync();
  }

  /// <summary>
  /// Snippet for the RunTask method.
  ///
  /// runTask
  /// </summary>
  public async Task SnippetForRunTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.RunTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
  }

  /// <summary>
  /// Snippet for the SearchAuthentications method.
  ///
  /// searchAuthentications
  /// </summary>
  public async Task SnippetForSearchAuthentications0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.SearchAuthenticationsAsync(
      new AuthenticationSearch
      {
        AuthenticationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SearchDestinations method.
  ///
  /// searchDestinations
  /// </summary>
  public async Task SnippetForSearchDestinations0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.SearchDestinationsAsync(
      new DestinationSearch
      {
        DestinationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SearchSources method.
  ///
  /// searchSources
  /// </summary>
  public async Task SnippetForSearchSources0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.SearchSourcesAsync(
      new SourceSearch
      {
        SourceIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SearchTasks method.
  ///
  /// searchTasks
  /// </summary>
  public async Task SnippetForSearchTasks0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.SearchTasksAsync(
      new TaskSearch
      {
        TaskIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the TriggerDockerSourceDiscover method.
  ///
  /// triggerDockerSourceDiscover
  /// </summary>
  public async Task SnippetForTriggerDockerSourceDiscover0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.TriggerDockerSourceDiscoverAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    );
  }

  /// <summary>
  /// Snippet for the UpdateAuthentication method.
  ///
  /// updateAuthentication
  /// </summary>
  public async Task SnippetForUpdateAuthentication0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateAuthenticationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new AuthenticationUpdate { Name = "newName", }
    );
  }

  /// <summary>
  /// Snippet for the UpdateDestination method.
  ///
  /// updateDestination
  /// </summary>
  public async Task SnippetForUpdateDestination0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateDestinationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new DestinationUpdate { Name = "newName", }
    );
  }

  /// <summary>
  /// Snippet for the UpdateSource method.
  ///
  /// updateSource
  /// </summary>
  public async Task SnippetForUpdateSource0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateSourceAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName", }
    );
  }

  /// <summary>
  /// Snippet for the UpdateTask method.
  ///
  /// updateTask
  /// </summary>
  public async Task SnippetForUpdateTask0()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateTaskAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdate { Enabled = false, }
    );
  }
}

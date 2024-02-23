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
  public async Task SnippetForIngestionClientCreateAuthentication()
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
  public async Task SnippetForIngestionClientCreateDestination()
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
  public async Task SnippetForIngestionClientCreateSource()
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
  public async Task SnippetForIngestionClientCreateTask()
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
  public async Task SnippetForIngestionClientCustomDelete()
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
  public async Task SnippetForIngestionClientCustomGet()
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
  public async Task SnippetForIngestionClientCustomPost()
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
  public async Task SnippetForIngestionClientCustomPut()
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
  public async Task SnippetForIngestionClientDeleteAuthentication()
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
  public async Task SnippetForIngestionClientDeleteDestination()
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
  public async Task SnippetForIngestionClientDeleteSource()
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
  public async Task SnippetForIngestionClientDeleteTask()
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
  public async Task SnippetForIngestionClientDisableTask()
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
  /// enable task e2e
  /// </summary>
  public async Task SnippetForIngestionClientEnableTask()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
  }

  /// <summary>
  /// Snippet for the GetAuthentication method.
  ///
  /// getAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientGetAuthentication()
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
  public async Task SnippetForIngestionClientGetAuthentications()
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
  public async Task SnippetForIngestionClientGetDestination()
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
  public async Task SnippetForIngestionClientGetDestinations()
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
  public async Task SnippetForIngestionClientGetDockerSourceStreams()
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
  public async Task SnippetForIngestionClientGetEvent()
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
  public async Task SnippetForIngestionClientGetEvents()
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
  public async Task SnippetForIngestionClientGetRun()
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
  public async Task SnippetForIngestionClientGetRuns()
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
  public async Task SnippetForIngestionClientGetSource()
  {
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
  }

  /// <summary>
  /// Snippet for the GetSources method.
  ///
  /// getSources
  /// </summary>
  public async Task SnippetForIngestionClientGetSources()
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
  public async Task SnippetForIngestionClientGetTask()
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
  public async Task SnippetForIngestionClientGetTasks()
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
  public async Task SnippetForIngestionClientRunTask()
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
  public async Task SnippetForIngestionClientSearchAuthentications()
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
  public async Task SnippetForIngestionClientSearchDestinations()
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
  public async Task SnippetForIngestionClientSearchSources()
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
  public async Task SnippetForIngestionClientSearchTasks()
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
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the TriggerDockerSourceDiscover method.
  ///
  /// triggerDockerSourceDiscover
  /// </summary>
  public async Task SnippetForIngestionClientTriggerDockerSourceDiscover()
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
  public async Task SnippetForIngestionClientUpdateAuthentication()
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
  public async Task SnippetForIngestionClientUpdateDestination()
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
  public async Task SnippetForIngestionClientUpdateSource()
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
  public async Task SnippetForIngestionClientUpdateTask()
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

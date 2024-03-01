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
    // >SEPARATOR createAuthentication
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateDestination method.
  ///
  /// createDestination
  /// </summary>
  public async Task SnippetForIngestionClientCreateDestination()
  {
    // >SEPARATOR createDestination
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateSource method.
  ///
  /// createSource
  /// </summary>
  public async Task SnippetForIngestionClientCreateSource()
  {
    // >SEPARATOR createSource
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateTask method.
  ///
  /// createTaskOnDemand
  /// </summary>
  public async Task SnippetForIngestionClientCreateTask()
  {
    // >SEPARATOR createTask
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteAuthentication method.
  ///
  /// deleteAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientDeleteAuthentication()
  {
    // >SEPARATOR deleteAuthentication
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteDestination method.
  ///
  /// deleteDestination
  /// </summary>
  public async Task SnippetForIngestionClientDeleteDestination()
  {
    // >SEPARATOR deleteDestination
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteSource method.
  ///
  /// deleteSource
  /// </summary>
  public async Task SnippetForIngestionClientDeleteSource()
  {
    // >SEPARATOR deleteSource
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteTask method.
  ///
  /// deleteTask
  /// </summary>
  public async Task SnippetForIngestionClientDeleteTask()
  {
    // >SEPARATOR deleteTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DisableTask method.
  ///
  /// disableTask
  /// </summary>
  public async Task SnippetForIngestionClientDisableTask()
  {
    // >SEPARATOR disableTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DisableTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the EnableTask method.
  ///
  /// enable task e2e
  /// </summary>
  public async Task SnippetForIngestionClientEnableTask()
  {
    // >SEPARATOR enableTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAuthentication method.
  ///
  /// getAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientGetAuthentication()
  {
    // >SEPARATOR getAuthentication
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAuthentications method.
  ///
  /// getAuthentications
  /// </summary>
  public async Task SnippetForIngestionClientGetAuthentications()
  {
    // >SEPARATOR getAuthentications
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAuthenticationsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDestination method.
  ///
  /// getDestination
  /// </summary>
  public async Task SnippetForIngestionClientGetDestination()
  {
    // >SEPARATOR getDestination
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDestinations method.
  ///
  /// getDestinations
  /// </summary>
  public async Task SnippetForIngestionClientGetDestinations()
  {
    // >SEPARATOR getDestinations
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDestinationsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDockerSourceStreams method.
  ///
  /// getDockerSourceStreams
  /// </summary>
  public async Task SnippetForIngestionClientGetDockerSourceStreams()
  {
    // >SEPARATOR getDockerSourceStreams
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetDockerSourceStreamsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetEvent method.
  ///
  /// getEvent
  /// </summary>
  public async Task SnippetForIngestionClientGetEvent()
  {
    // >SEPARATOR getEvent
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetEventAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetEvents method.
  ///
  /// getEvents
  /// </summary>
  public async Task SnippetForIngestionClientGetEvents()
  {
    // >SEPARATOR getEvents
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetEventsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRun method.
  ///
  /// getRun
  /// </summary>
  public async Task SnippetForIngestionClientGetRun()
  {
    // >SEPARATOR getRun
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetRunAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRuns method.
  ///
  /// getRuns
  /// </summary>
  public async Task SnippetForIngestionClientGetRuns()
  {
    // >SEPARATOR getRuns
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetRunsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSource method.
  ///
  /// getSource
  /// </summary>
  public async Task SnippetForIngestionClientGetSource()
  {
    // >SEPARATOR getSource
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSources method.
  ///
  /// getSources
  /// </summary>
  public async Task SnippetForIngestionClientGetSources()
  {
    // >SEPARATOR getSources
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSourcesAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTask method.
  ///
  /// getTask
  /// </summary>
  public async Task SnippetForIngestionClientGetTask()
  {
    // >SEPARATOR getTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTasks method.
  ///
  /// getTasks
  /// </summary>
  public async Task SnippetForIngestionClientGetTasks()
  {
    // >SEPARATOR getTasks
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTasksAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RunTask method.
  ///
  /// runTask
  /// </summary>
  public async Task SnippetForIngestionClientRunTask()
  {
    // >SEPARATOR runTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.RunTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchAuthentications method.
  ///
  /// searchAuthentications
  /// </summary>
  public async Task SnippetForIngestionClientSearchAuthentications()
  {
    // >SEPARATOR searchAuthentications
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchDestinations method.
  ///
  /// searchDestinations
  /// </summary>
  public async Task SnippetForIngestionClientSearchDestinations()
  {
    // >SEPARATOR searchDestinations
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchSources method.
  ///
  /// searchSources
  /// </summary>
  public async Task SnippetForIngestionClientSearchSources()
  {
    // >SEPARATOR searchSources
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchTasks method.
  ///
  /// searchTasks
  /// </summary>
  public async Task SnippetForIngestionClientSearchTasks()
  {
    // >SEPARATOR searchTasks
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the TriggerDockerSourceDiscover method.
  ///
  /// triggerDockerSourceDiscover
  /// </summary>
  public async Task SnippetForIngestionClientTriggerDockerSourceDiscover()
  {
    // >SEPARATOR triggerDockerSourceDiscover
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.TriggerDockerSourceDiscoverAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateAuthentication method.
  ///
  /// updateAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientUpdateAuthentication()
  {
    // >SEPARATOR updateAuthentication
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateAuthenticationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new AuthenticationUpdate { Name = "newName", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateDestination method.
  ///
  /// updateDestination
  /// </summary>
  public async Task SnippetForIngestionClientUpdateDestination()
  {
    // >SEPARATOR updateDestination
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateDestinationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new DestinationUpdate { Name = "newName", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateSource method.
  ///
  /// updateSource
  /// </summary>
  public async Task SnippetForIngestionClientUpdateSource()
  {
    // >SEPARATOR updateSource
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateSourceAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateTask method.
  ///
  /// updateTask
  /// </summary>
  public async Task SnippetForIngestionClientUpdateTask()
  {
    // >SEPARATOR updateTask
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateTaskAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdate { Enabled = false, }
    );
    // SEPARATOR<
  }
}

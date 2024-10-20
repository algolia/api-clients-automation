// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;
// IMPORT<
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetIngestionClient
{
  /// <summary>
  /// Snippet for the CreateAuthentication method.
  ///
  /// createAuthenticationOAuth
  /// </summary>
  public async Task SnippetForIngestionClientCreateAuthentication()
  {
    // >SEPARATOR createAuthentication default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateDestination method.
  ///
  /// createDestination
  /// </summary>
  public async Task SnippetForIngestionClientCreateDestination()
  {
    // >SEPARATOR createDestination default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CreateDestinationAsync(
      new DestinationCreate
      {
        Type = Enum.Parse<DestinationType>("Search"),
        Name = "destinationName",
        Input = new DestinationInput(new DestinationIndexName { IndexName = "<YOUR_INDEX_NAME>" }),
        AuthenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateSource method.
  ///
  /// createSource
  /// </summary>
  public async Task SnippetForIngestionClientCreateSource()
  {
    // >SEPARATOR createSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateTask method.
  ///
  /// task without cron
  /// </summary>
  public async Task SnippetForIngestionClientCreateTask()
  {
    // >SEPARATOR createTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CreateTaskAsync(
      new TaskCreate
      {
        SourceID = "search",
        DestinationID = "destinationName",
        Action = Enum.Parse<ActionType>("Replace"),
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateTaskV1 method.
  ///
  /// createTaskOnDemand
  /// </summary>
  public async Task SnippetForIngestionClientCreateTaskV1()
  {
    // >SEPARATOR createTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CreateTaskV1Async(
      new TaskCreateV1
      {
        SourceID = "search",
        DestinationID = "destinationName",
        Trigger = new TaskCreateTrigger(
          new OnDemandTriggerInput { Type = Enum.Parse<OnDemandTriggerType>("OnDemand") }
        ),
        Action = Enum.Parse<ActionType>("Replace"),
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CreateTransformation method.
  ///
  /// createTransformation
  /// </summary>
  public async Task SnippetForIngestionClientCreateTransformation()
  {
    // >SEPARATOR createTransformation default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CreateTransformationAsync(
      new TransformationCreate
      {
        Code = "foo",
        Name = "bar",
        Description = "baz",
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomDelete()
  {
    // >SEPARATOR customDelete default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomGet()
  {
    // >SEPARATOR customGet default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomPost()
  {
    // >SEPARATOR customPost default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForIngestionClientCustomPut()
  {
    // >SEPARATOR customPut default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteAuthentication method.
  ///
  /// deleteAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientDeleteAuthentication()
  {
    // >SEPARATOR deleteAuthentication default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteDestination method.
  ///
  /// deleteDestination
  /// </summary>
  public async Task SnippetForIngestionClientDeleteDestination()
  {
    // >SEPARATOR deleteDestination default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteSource method.
  ///
  /// deleteSource
  /// </summary>
  public async Task SnippetForIngestionClientDeleteSource()
  {
    // >SEPARATOR deleteSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteTask method.
  ///
  /// deleteTask
  /// </summary>
  public async Task SnippetForIngestionClientDeleteTask()
  {
    // >SEPARATOR deleteTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteTaskV1 method.
  ///
  /// deleteTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientDeleteTaskV1()
  {
    // >SEPARATOR deleteTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteTaskV1Async("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteTransformation method.
  ///
  /// deleteTransformation
  /// </summary>
  public async Task SnippetForIngestionClientDeleteTransformation()
  {
    // >SEPARATOR deleteTransformation default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteTransformationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DisableTask method.
  ///
  /// disableTask
  /// </summary>
  public async Task SnippetForIngestionClientDisableTask()
  {
    // >SEPARATOR disableTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DisableTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DisableTaskV1 method.
  ///
  /// disableTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientDisableTaskV1()
  {
    // >SEPARATOR disableTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DisableTaskV1Async("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the EnableTask method.
  ///
  /// enableTask
  /// </summary>
  public async Task SnippetForIngestionClientEnableTask()
  {
    // >SEPARATOR enableTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the EnableTaskV1 method.
  ///
  /// enableTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientEnableTaskV1()
  {
    // >SEPARATOR enableTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.EnableTaskV1Async("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAuthentication method.
  ///
  /// getAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientGetAuthentication()
  {
    // >SEPARATOR getAuthentication default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDestination method.
  ///
  /// getDestination
  /// </summary>
  public async Task SnippetForIngestionClientGetDestination()
  {
    // >SEPARATOR getDestination default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetEvent method.
  ///
  /// getEvent
  /// </summary>
  public async Task SnippetForIngestionClientGetEvent()
  {
    // >SEPARATOR getEvent default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetEventAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRun method.
  ///
  /// getRun
  /// </summary>
  public async Task SnippetForIngestionClientGetRun()
  {
    // >SEPARATOR getRun default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetRunAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSource method.
  ///
  /// getSource
  /// </summary>
  public async Task SnippetForIngestionClientGetSource()
  {
    // >SEPARATOR getSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTask method.
  ///
  /// getTask
  /// </summary>
  public async Task SnippetForIngestionClientGetTask()
  {
    // >SEPARATOR getTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTaskV1 method.
  ///
  /// getTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientGetTaskV1()
  {
    // >SEPARATOR getTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTaskV1Async("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTransformation method.
  ///
  /// getTransformation
  /// </summary>
  public async Task SnippetForIngestionClientGetTransformation()
  {
    // >SEPARATOR getTransformation default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTransformationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListAuthentications method.
  ///
  /// getAuthentications
  /// </summary>
  public async Task SnippetForIngestionClientListAuthentications()
  {
    // >SEPARATOR listAuthentications default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListAuthenticationsAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListDestinations method.
  ///
  /// getDestinations
  /// </summary>
  public async Task SnippetForIngestionClientListDestinations()
  {
    // >SEPARATOR listDestinations default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListDestinationsAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListEvents method.
  ///
  /// getEvents
  /// </summary>
  public async Task SnippetForIngestionClientListEvents()
  {
    // >SEPARATOR listEvents default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListEventsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListRuns method.
  ///
  /// listRuns
  /// </summary>
  public async Task SnippetForIngestionClientListRuns()
  {
    // >SEPARATOR listRuns default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListRunsAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListSources method.
  ///
  /// listSources
  /// </summary>
  public async Task SnippetForIngestionClientListSources()
  {
    // >SEPARATOR listSources default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListSourcesAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListTasks method.
  ///
  /// listTasks
  /// </summary>
  public async Task SnippetForIngestionClientListTasks()
  {
    // >SEPARATOR listTasks default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListTasksAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListTasksV1 method.
  ///
  /// listTasksV1
  /// </summary>
  public async Task SnippetForIngestionClientListTasksV1()
  {
    // >SEPARATOR listTasksV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListTasksV1Async();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListTransformations method.
  ///
  /// listTransformations
  /// </summary>
  public async Task SnippetForIngestionClientListTransformations()
  {
    // >SEPARATOR listTransformations default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListTransformationsAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushTask method.
  ///
  /// pushTask
  /// </summary>
  public async Task SnippetForIngestionClientPushTask()
  {
    // >SEPARATOR pushTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushTaskAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new PushTaskPayload
      {
        Action = Enum.Parse<Action>("AddObject"),
        Records = new List<PushTaskRecords>
        {
          new PushTaskRecords
          {
            ObjectID = "o",
            AdditionalProperties = new Dictionary<string, object>
            {
              { "key", "bar" },
              { "foo", "1" },
            },
          },
          new PushTaskRecords
          {
            ObjectID = "k",
            AdditionalProperties = new Dictionary<string, object>
            {
              { "key", "baz" },
              { "foo", "2" },
            },
          },
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RunSource method.
  ///
  /// runSource
  /// </summary>
  public async Task SnippetForIngestionClientRunSource()
  {
    // >SEPARATOR runSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.RunSourceAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new RunSourcePayload
      {
        IndexToInclude = new List<string> { "products_us", "products eu" },
        EntityIDs = new List<string> { "1234", "5678" },
        EntityType = Enum.Parse<EntityType>("Product"),
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RunTask method.
  ///
  /// runTask
  /// </summary>
  public async Task SnippetForIngestionClientRunTask()
  {
    // >SEPARATOR runTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.RunTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RunTaskV1 method.
  ///
  /// runTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientRunTaskV1()
  {
    // >SEPARATOR runTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.RunTaskV1Async("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchAuthentications method.
  ///
  /// searchAuthentications
  /// </summary>
  public async Task SnippetForIngestionClientSearchAuthentications()
  {
    // >SEPARATOR searchAuthentications default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchAuthenticationsAsync(
      new AuthenticationSearch
      {
        AuthenticationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchDestinations method.
  ///
  /// searchDestinations
  /// </summary>
  public async Task SnippetForIngestionClientSearchDestinations()
  {
    // >SEPARATOR searchDestinations default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchDestinationsAsync(
      new DestinationSearch
      {
        DestinationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchSources method.
  ///
  /// searchSources
  /// </summary>
  public async Task SnippetForIngestionClientSearchSources()
  {
    // >SEPARATOR searchSources default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchSourcesAsync(
      new SourceSearch
      {
        SourceIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchTasks method.
  ///
  /// searchTasks
  /// </summary>
  public async Task SnippetForIngestionClientSearchTasks()
  {
    // >SEPARATOR searchTasks default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchTasksAsync(
      new TaskSearch
      {
        TaskIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchTasksV1 method.
  ///
  /// searchTasksV1
  /// </summary>
  public async Task SnippetForIngestionClientSearchTasksV1()
  {
    // >SEPARATOR searchTasksV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchTasksV1Async(
      new TaskSearch
      {
        TaskIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchTransformations method.
  ///
  /// searchTransformations
  /// </summary>
  public async Task SnippetForIngestionClientSearchTransformations()
  {
    // >SEPARATOR searchTransformations default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.SearchTransformationsAsync(
      new TransformationSearch
      {
        TransformationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetClientApiKey method.
  ///
  /// switch API key
  /// </summary>
  public async Task SnippetForIngestionClientSetClientApiKey()
  {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    client.SetClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the TriggerDockerSourceDiscover method.
  ///
  /// triggerDockerSourceDiscover
  /// </summary>
  public async Task SnippetForIngestionClientTriggerDockerSourceDiscover()
  {
    // >SEPARATOR triggerDockerSourceDiscover default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.TriggerDockerSourceDiscoverAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the TryTransformation method.
  ///
  /// tryTransformation
  /// </summary>
  public async Task SnippetForIngestionClientTryTransformation()
  {
    // >SEPARATOR tryTransformation default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.TryTransformationAsync(
      new TransformationTry
      {
        Code = "foo",
        SampleRecord = new Dictionary<string, string> { { "bar", "baz" } },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the TryTransformationBeforeUpdate method.
  ///
  /// tryTransformationBeforeUpdate
  /// </summary>
  public async Task SnippetForIngestionClientTryTransformationBeforeUpdate()
  {
    // >SEPARATOR tryTransformationBeforeUpdate default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.TryTransformationBeforeUpdateAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationTry
      {
        Code = "foo",
        SampleRecord = new Dictionary<string, string> { { "bar", "baz" } },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateAuthentication method.
  ///
  /// updateAuthentication
  /// </summary>
  public async Task SnippetForIngestionClientUpdateAuthentication()
  {
    // >SEPARATOR updateAuthentication default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateAuthenticationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new AuthenticationUpdate { Name = "newName" }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateDestination method.
  ///
  /// updateDestination
  /// </summary>
  public async Task SnippetForIngestionClientUpdateDestination()
  {
    // >SEPARATOR updateDestination default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateDestinationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new DestinationUpdate { Name = "newName" }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateSource method.
  ///
  /// updateSource
  /// </summary>
  public async Task SnippetForIngestionClientUpdateSource()
  {
    // >SEPARATOR updateSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateSourceAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName" }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateTask method.
  ///
  /// updateTask
  /// </summary>
  public async Task SnippetForIngestionClientUpdateTask()
  {
    // >SEPARATOR updateTask default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateTaskAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdate { Enabled = false, Cron = "* * * * *" }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateTaskV1 method.
  ///
  /// updateTaskV1
  /// </summary>
  public async Task SnippetForIngestionClientUpdateTaskV1()
  {
    // >SEPARATOR updateTaskV1 default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateTaskV1Async(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdateV1 { Enabled = false }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateTransformation method.
  ///
  /// updateTransformation
  /// </summary>
  public async Task SnippetForIngestionClientUpdateTransformation()
  {
    // >SEPARATOR updateTransformation default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.UpdateTransformationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TransformationCreate
      {
        Code = "foo",
        Name = "bar",
        Description = "baz",
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ValidateSource method.
  ///
  /// validateSource
  /// </summary>
  public async Task SnippetForIngestionClientValidateSource()
  {
    // >SEPARATOR validateSource default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ValidateSourceAsync(
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
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ValidateSourceBeforeUpdate method.
  ///
  /// validateSourceBeforeUpdate
  /// </summary>
  public async Task SnippetForIngestionClientValidateSourceBeforeUpdate()
  {
    // >SEPARATOR validateSourceBeforeUpdate default
    // Initialize the client
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ValidateSourceBeforeUpdateAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName" }
    );
    // >LOG
    // SEPARATOR<
  }
}

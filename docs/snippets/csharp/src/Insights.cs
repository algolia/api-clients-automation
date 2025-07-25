// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Insights;
// IMPORT<
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetInsightsClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomDelete()
  {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with all parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomDelete1()
  {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomGet()
  {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with all parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomGet1()
  {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters with space" } }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// requestOptions should be escaped too
  /// </summary>
  public async Task SnippetForInsightsClientCustomGet2()
  {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "to be overriden" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("query", "parameters with space")
        .AddExtraQueryParameters("and an array", new List<object> { "array", "with spaces" })
        .AddExtraHeader("x-header-1", "spaces are left alone")
        .Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost()
  {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with all parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost1()
  {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions can override default query parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost2()
  {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query", "myQueryParameter").Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions merges query parameters with default ones
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost3()
  {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query2", "myQueryParameter").Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions can override default headers
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost4()
  {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY").Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions merges headers with default ones
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost5()
  {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY").Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions queryParameters accepts booleans
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost6()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("isItWorking", true).Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions queryParameters accepts integers
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost7()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("myParam", 2).Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions queryParameters accepts list of string
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost8()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { "b and c", "d" })
        .Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions queryParameters accepts list of booleans
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost9()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { true, true, false })
        .Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// requestOptions queryParameters accepts list of integers
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost10()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync(
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { 1, 2 })
        .Build()
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPut()
  {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with all parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPut1()
  {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteUserToken method.
  ///
  /// deleteUserToken
  /// </summary>
  public async Task SnippetForInsightsClientDeleteUserToken()
  {
    // >SEPARATOR deleteUserToken default
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    await client.DeleteUserTokenAsync("test-user-1");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// pushEvents
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents()
  {
    // >SEPARATOR pushEvents pushEvents
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ClickedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ClickEvent>("Click"),
              EventName = "Product Clicked",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              Positions = new List<int> { 7, 6 },
            }
          ),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// Many events type
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents1()
  {
    // >SEPARATOR pushEvents Many events type
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ConvertedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ConversionEvent>("Conversion"),
              EventName = "Product Purchased",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1753228800000L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
            }
          ),
          new EventsItems(
            new ViewedObjectIDs
            {
              EventType = Enum.Parse<ViewEvent>("View"),
              EventName = "Product Detail Page Viewed",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1753228800000L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
            }
          ),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// ConvertedObjectIDsAfterSearch
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents2()
  {
    // >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ConvertedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ConversionEvent>("Conversion"),
              EventName = "Product Purchased",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
            }
          ),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// ViewedObjectIDs
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents3()
  {
    // >SEPARATOR pushEvents ViewedObjectIDs
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ViewedObjectIDs
            {
              EventType = Enum.Parse<ViewEvent>("View"),
              EventName = "Product Detail Page Viewed",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
            }
          ),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// AddedToCartObjectIDs
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents4()
  {
    // >SEPARATOR pushEvents AddedToCartObjectIDs
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new AddedToCartObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ConversionEvent>("Conversion"),
              EventSubtype = Enum.Parse<AddToCartEvent>("AddToCart"),
              EventName = "Product Added To Cart",
              Index = "products",
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              ObjectData = new List<ObjectDataAfterSearch>
              {
                new ObjectDataAfterSearch
                {
                  Price = new Price(19.99),
                  Quantity = 10,
                  Discount = new Discount(2.5),
                },
                new ObjectDataAfterSearch
                {
                  Price = new Price("8$"),
                  Quantity = 7,
                  Discount = new Discount("30%"),
                },
              },
              Currency = "USD",
            }
          ),
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
  public async Task SnippetForInsightsClientSetClientApiKey()
  {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    client.SetClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}

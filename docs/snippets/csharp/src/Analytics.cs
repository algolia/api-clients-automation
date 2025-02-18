// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Analytics;
// IMPORT<
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetAnalyticsClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientCustomDelete()
  {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomDelete1()
  {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomGet()
  {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomGet1()
  {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomGet2()
  {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost()
  {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost1()
  {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost2()
  {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost3()
  {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost4()
  {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost5()
  {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost6()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost7()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost8()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost9()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost10()
  {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPut()
  {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPut1()
  {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  /// Snippet for the GetAddToCartRate method.
  ///
  /// get getAddToCartRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAddToCartRate()
  {
    // >SEPARATOR getAddToCartRate get getAddToCartRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetAddToCartRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAddToCartRate method.
  ///
  /// get getAddToCartRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAddToCartRate1()
  {
    // >SEPARATOR getAddToCartRate get getAddToCartRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetAddToCartRateAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAverageClickPosition method.
  ///
  /// get getAverageClickPosition with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAverageClickPosition()
  {
    // >SEPARATOR getAverageClickPosition get getAverageClickPosition with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetAverageClickPositionAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAverageClickPosition method.
  ///
  /// get getAverageClickPosition with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAverageClickPosition1()
  {
    // >SEPARATOR getAverageClickPosition get getAverageClickPosition with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetAverageClickPositionAsync(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickPositions method.
  ///
  /// get getClickPositions with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickPositions()
  {
    // >SEPARATOR getClickPositions get getClickPositions with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetClickPositionsAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickPositions method.
  ///
  /// get getClickPositions with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickPositions1()
  {
    // >SEPARATOR getClickPositions get getClickPositions with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetClickPositionsAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickThroughRate method.
  ///
  /// get getClickThroughRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickThroughRate()
  {
    // >SEPARATOR getClickThroughRate get getClickThroughRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetClickThroughRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickThroughRate method.
  ///
  /// get getClickThroughRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickThroughRate1()
  {
    // >SEPARATOR getClickThroughRate get getClickThroughRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetClickThroughRateAsync(
      "index",
      "1999-09-19",
      "2001-01-01",
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetConversionRate method.
  ///
  /// get getConversationRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetConversionRate()
  {
    // >SEPARATOR getConversionRate get getConversationRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetConversionRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetConversionRate method.
  ///
  /// get getConversationRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetConversionRate1()
  {
    // >SEPARATOR getConversionRate get getConversationRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetConversionRateAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoClickRate method.
  ///
  /// get getNoClickRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoClickRate()
  {
    // >SEPARATOR getNoClickRate get getNoClickRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetNoClickRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoClickRate method.
  ///
  /// get getNoClickRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoClickRate1()
  {
    // >SEPARATOR getNoClickRate get getNoClickRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetNoClickRateAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoResultsRate method.
  ///
  /// get getNoResultsRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoResultsRate()
  {
    // >SEPARATOR getNoResultsRate get getNoResultsRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetNoResultsRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoResultsRate method.
  ///
  /// get getNoResultsRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoResultsRate1()
  {
    // >SEPARATOR getNoResultsRate get getNoResultsRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetNoResultsRateAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetPurchaseRate method.
  ///
  /// get getPurchaseRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetPurchaseRate()
  {
    // >SEPARATOR getPurchaseRate get getPurchaseRate with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetPurchaseRateAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetPurchaseRate method.
  ///
  /// get getPurchaseRate with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetPurchaseRate1()
  {
    // >SEPARATOR getPurchaseRate get getPurchaseRate with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetPurchaseRateAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRevenue method.
  ///
  /// get getRevenue with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetRevenue()
  {
    // >SEPARATOR getRevenue get getRevenue with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetRevenueAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRevenue method.
  ///
  /// get getRevenue with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetRevenue1()
  {
    // >SEPARATOR getRevenue get getRevenue with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetRevenueAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesCount method.
  ///
  /// get getSearchesCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesCount()
  {
    // >SEPARATOR getSearchesCount get getSearchesCount with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesCountAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesCount method.
  ///
  /// get getSearchesCount with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesCount1()
  {
    // >SEPARATOR getSearchesCount get getSearchesCount with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesCountAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoClicks method.
  ///
  /// get getSearchesNoClicks with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoClicks()
  {
    // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoClicksAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoClicks method.
  ///
  /// get getSearchesNoClicks with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoClicks1()
  {
    // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoClicksAsync(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoResults method.
  ///
  /// get getSearchesNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoResults()
  {
    // >SEPARATOR getSearchesNoResults get getSearchesNoResults with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoResultsAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoResults method.
  ///
  /// get getSearchesNoResults with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoResults1()
  {
    // >SEPARATOR getSearchesNoResults get getSearchesNoResults with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoResultsAsync(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetStatus method.
  ///
  /// get getStatus with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetStatus()
  {
    // >SEPARATOR getStatus default
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetStatusAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopCountries method.
  ///
  /// get getTopCountries with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopCountries()
  {
    // >SEPARATOR getTopCountries get getTopCountries with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopCountriesAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopCountries method.
  ///
  /// get getTopCountries with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopCountries1()
  {
    // >SEPARATOR getTopCountries get getTopCountries with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopCountriesAsync(
      "index",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterAttributes method.
  ///
  /// get getTopFilterAttributes with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterAttributes()
  {
    // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterAttributesAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterAttributes method.
  ///
  /// get getTopFilterAttributes with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterAttributes1()
  {
    // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterAttributesAsync(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute()
  {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync("myAttribute", "index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with minimal parameters and multiple attributes
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute1()
  {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters and multiple attributes
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync("myAttribute1,myAttribute2", "index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute2()
  {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync(
      "myAttribute",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with all parameters and multiple attributes
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute3()
  {
    // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters and multiple attributes
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync(
      "myAttribute1,myAttribute2",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFiltersNoResults method.
  ///
  /// get getTopFiltersNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFiltersNoResults()
  {
    // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFiltersNoResultsAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFiltersNoResults method.
  ///
  /// get getTopFiltersNoResults with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFiltersNoResults1()
  {
    // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopFiltersNoResultsAsync(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopHits method.
  ///
  /// get getTopHits with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopHits()
  {
    // >SEPARATOR getTopHits get getTopHits with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopHitsAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopHits method.
  ///
  /// get getTopHits with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopHits1()
  {
    // >SEPARATOR getTopHits get getTopHits with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopHitsAsync(
      "index",
      "mySearch",
      true,
      true,
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopSearches method.
  ///
  /// get getTopSearches with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopSearches()
  {
    // >SEPARATOR getTopSearches get getTopSearches with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopSearchesAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopSearches method.
  ///
  /// get getTopSearches with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopSearches1()
  {
    // >SEPARATOR getTopSearches get getTopSearches with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetTopSearchesAsync(
      "index",
      true,
      true,
      "1999-09-19",
      "2001-01-01",
      Enum.Parse<OrderBy>("SearchCount"),
      Enum.Parse<Direction>("Asc"),
      21,
      42,
      "tag"
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUsersCount method.
  ///
  /// get getUsersCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetUsersCount()
  {
    // >SEPARATOR getUsersCount get getUsersCount with minimal parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetUsersCountAsync("index");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUsersCount method.
  ///
  /// get getUsersCount with all parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetUsersCount1()
  {
    // >SEPARATOR getUsersCount get getUsersCount with all parameters
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetUsersCountAsync("index", "1999-09-19", "2001-01-01", "tag");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetClientApiKey method.
  ///
  /// switch API key
  /// </summary>
  public async Task SnippetForAnalyticsClientSetClientApiKey()
  {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    client.SetClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}

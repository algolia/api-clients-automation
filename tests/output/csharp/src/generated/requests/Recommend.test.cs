using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Recommend;
using Algolia.Search.Serializer;
using dotenv.net;
using Newtonsoft.Json;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class RecommendClientRequestTests
{
  private readonly RecommendClient _client;
  private readonly EchoHttpRequester _echo;

  public RecommendClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new RecommendClient(new RecommendConfig("appId", "apiKey"), _echo);
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "allow del method for a custom path with minimal parameters")]
  public async Task CustomDeleteTest0()
  {
    await _client.CustomDeleteAsync("/test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "allow del method for a custom path with all parameters")]
  public async Task CustomDeleteTest1()
  {
    await _client.CustomDeleteAsync(
      "/test/all",
      new Dictionary<string, object> { { "query", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "allow get method for a custom path with minimal parameters")]
  public async Task CustomGetTest0()
  {
    await _client.CustomGetAsync("/test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "allow get method for a custom path with all parameters")]
  public async Task CustomGetTest1()
  {
    await _client.CustomGetAsync(
      "/test/all",
      new Dictionary<string, object> { { "query", "parameters with space" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters%20with%20space\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions should be escaped too")]
  public async Task CustomGetTest2()
  {
    await _client.CustomGetAsync(
      "/test/all",
      new Dictionary<string, object> { { "query", "to be overriden" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("query", "parameters with space")
        .AddExtraQueryParameters("and an array", new List<object> { "array", "with spaces" })
        .AddExtraHeader("x-header-1", "spaces are left alone")
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"x-header-1\":\"spaces are left alone\"}"
    );
    var actualHeaders = req.Headers;
    foreach (var expectedHeader in expectedHeaders)
    {
      string actualHeaderValue;
      actualHeaders.TryGetValue(expectedHeader.Key, out actualHeaderValue);
      Assert.Equal(expectedHeader.Value, actualHeaderValue);
    }
  }

  [Fact(DisplayName = "allow post method for a custom path with minimal parameters")]
  public async Task CustomPostTest0()
  {
    await _client.CustomPostAsync("/test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "allow post method for a custom path with all parameters")]
  public async Task CustomPostTest1()
  {
    await _client.CustomPostAsync(
      "/test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"body\":\"parameters\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions can override default query parameters")]
  public async Task CustomPostTest2()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"myQueryParameter\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions merges query parameters with default ones")]
  public async Task CustomPostTest3()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query2", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions can override default headers")]
  public async Task CustomPostTest4()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"x-algolia-api-key\":\"myApiKey\"}"
    );
    var actualHeaders = req.Headers;
    foreach (var expectedHeader in expectedHeaders)
    {
      string actualHeaderValue;
      actualHeaders.TryGetValue(expectedHeader.Key, out actualHeaderValue);
      Assert.Equal(expectedHeader.Value, actualHeaderValue);
    }
  }

  [Fact(DisplayName = "requestOptions merges headers with default ones")]
  public async Task CustomPostTest5()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"x-algolia-api-key\":\"myApiKey\"}"
    );
    var actualHeaders = req.Headers;
    foreach (var expectedHeader in expectedHeaders)
    {
      string actualHeaderValue;
      actualHeaders.TryGetValue(expectedHeader.Key, out actualHeaderValue);
      Assert.Equal(expectedHeader.Value, actualHeaderValue);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts booleans")]
  public async Task CustomPostTest6()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("isItWorking", true).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"isItWorking\":\"true\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts integers")]
  public async Task CustomPostTest7()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("myParam", 2).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"2\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of string")]
  public async Task CustomPostTest8()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { "b and c", "d" })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of booleans")]
  public async Task CustomPostTest9()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { true, true, false })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of integers")]
  public async Task CustomPostTest10()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { 1, 2 })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "allow put method for a custom path with minimal parameters")]
  public async Task CustomPutTest0()
  {
    await _client.CustomPutAsync("/test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "allow put method for a custom path with all parameters")]
  public async Task CustomPutTest1()
  {
    await _client.CustomPutAsync(
      "/test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"body\":\"parameters\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }
  }

  [Fact(DisplayName = "deleteRecommendRule0")]
  public async Task DeleteRecommendRuleTest0()
  {
    await _client.DeleteRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/objectID", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getRecommendRule0")]
  public async Task GetRecommendRuleTest0()
  {
    await _client.GetRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/objectID", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getRecommendStatus0")]
  public async Task GetRecommendStatusTest0()
  {
    await _client.GetRecommendStatusAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      12345L
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/task/12345", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "get recommendations for recommend model with minimal parameters")]
  public async Task GetRecommendationsTest0()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName",
              ObjectID = "objectID",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 42,
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get recommendations for recommend model with all parameters")]
  public async Task GetRecommendationsTest1()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName",
              ObjectID = "objectID",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 42,
              MaxRecommendations = 10,
              QueryParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("query") }
                ),
              },
              FallbackParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("fallback") }
                ),
              },
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get recommendations for trending model with minimal parameters")]
  public async Task GetRecommendationsTest2()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new TrendingItemsQuery
            {
              IndexName = "indexName",
              Model = Enum.Parse<TrendingItemsModel>("TrendingItems"),
              Threshold = 42,
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get recommendations for trending model with all parameters")]
  public async Task GetRecommendationsTest3()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new TrendingItemsQuery
            {
              IndexName = "indexName",
              Model = Enum.Parse<TrendingItemsModel>("TrendingItems"),
              Threshold = 42,
              MaxRecommendations = 10,
              FacetName = "myFacetName",
              FacetValue = "myFacetValue",
              QueryParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("query") }
                ),
              },
              FallbackParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("fallback") }
                ),
              },
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get multiple recommendations with minimal parameters")]
  public async Task GetRecommendationsTest4()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName1",
              ObjectID = "objectID1",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 21,
            }
          ),
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName2",
              ObjectID = "objectID2",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 21,
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get multiple recommendations with all parameters")]
  public async Task GetRecommendationsTest5()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName1",
              ObjectID = "objectID1",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 21,
              MaxRecommendations = 10,
              QueryParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("query1") }
                ),
              },
              FallbackParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("fallback1") }
                ),
              },
            }
          ),
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName2",
              ObjectID = "objectID2",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 21,
              MaxRecommendations = 10,
              QueryParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("query2") }
                ),
              },
              FallbackParameters = new SearchParamsObject
              {
                Query = "myQuery",
                FacetFilters = new FacetFilters(
                  new List<MixedSearchFilters> { new MixedSearchFilters("fallback2") }
                ),
              },
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "get frequently bought together recommendations")]
  public async Task GetRecommendationsTest6()
  {
    await _client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName1",
              ObjectID = "objectID1",
              Model = Enum.Parse<RecommendationModels>("BoughtTogether"),
              Threshold = 42,
            }
          )
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "searchRecommendRules0")]
  public async Task SearchRecommendRulesTest0()
  {
    await _client.SearchRecommendRulesAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts")
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(false));
  }
}

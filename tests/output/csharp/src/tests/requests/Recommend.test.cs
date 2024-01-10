using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Recommend;
using Xunit;
using Newtonsoft.Json;
using Quibble.Xunit;
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
  public void Dispose()
  {

  }

  [Fact(DisplayName = "allow del method for a custom path with minimal parameters")]
  public async Task CustomDeleteTest0()
  {
    const string path0 = "/test/minimal";

    await _client.CustomDeleteAsync(path0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "allow del method for a custom path with all parameters")]
  public async Task CustomDeleteTest1()
  {
    const string path0 = "/test/all";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }

    await _client.CustomDeleteAsync(path0, parameters0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "allow get method for a custom path with minimal parameters")]
  public async Task CustomGetTest0()
  {
    const string path0 = "/test/minimal";

    await _client.CustomGetAsync(path0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "allow get method for a custom path with all parameters")]
  public async Task CustomGetTest1()
  {
    const string path0 = "/test/all";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }

    await _client.CustomGetAsync(path0, parameters0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "allow post method for a custom path with minimal parameters")]
  public async Task CustomPostTest0()
  {
    const string path0 = "/test/minimal";

    await _client.CustomPostAsync(path0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allow post method for a custom path with all parameters")]
  public async Task CustomPostTest1()
  {
    const string path0 = "/test/all";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string body1 = "parameters";
      body0.Add("body", body1);
    }

    await _client.CustomPostAsync(path0, parameters0, body0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"body\":\"parameters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions can override default query parameters")]
  public async Task CustomPostTest2()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("query", "myQueryParameter"
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"myQueryParameter\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions merges query parameters with default ones")]
  public async Task CustomPostTest3()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("query2", "myQueryParameter"
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions can override default headers")]
  public async Task CustomPostTest4()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.Headers.Add("x-algolia-api-key", "myApiKey");
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"x-algolia-api-key\":\"myApiKey\"}");
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
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.Headers.Add("x-algolia-api-key", "myApiKey");
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"x-algolia-api-key\":\"myApiKey\"}");
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
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("isItWorking", true
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"isItWorking\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions queryParameters accepts integers")]
  public async Task CustomPostTest7()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("myParam", 2
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"myParam\":\"2\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions queryParameters accepts list of string")]
  public async Task CustomPostTest8()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("myParam", new List<object>{   "c"
,  "d"
 }
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"myParam\":\"c,d\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions queryParameters accepts list of booleans")]
  public async Task CustomPostTest9()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("myParam", new List<object>{   true
,  true
,  false
 }
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "requestOptions queryParameters accepts list of integers")]
  public async Task CustomPostTest10()
  {
    const string path0 = "/test/requestOptions";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string facet1 = "filters";
      body0.Add("facet", facet1);
    }

    var requestOptions = new RequestOptions();
    requestOptions.QueryParameters.Add("myParam", new List<object>{   1
,  2
 }
);
    await _client.CustomPostAsync(path0, parameters0, body0, requestOptions);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\",\"myParam\":\"1,2\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "allow put method for a custom path with minimal parameters")]
  public async Task CustomPutTest0()
  {
    const string path0 = "/test/minimal";

    await _client.CustomPutAsync(path0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/minimal", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allow put method for a custom path with all parameters")]
  public async Task CustomPutTest1()
  {
    const string path0 = "/test/all";
    var parameters0 = new Dictionary<string, object>();
    {
      const string query1 = "parameters";
      parameters0.Add("query", query1);
    }
    var body0 = new Dictionary<string, string>();
    {
      const string body1 = "parameters";
      body0.Add("body", body1);
    }

    await _client.CustomPutAsync(path0, parameters0, body0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"body\":\"parameters\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"query\":\"parameters\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "deleteRecommendRule0")]
  public async Task DeleteRecommendRuleTest0()
  {
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const string objectID0 = "objectID";

    await _client.DeleteRecommendRuleAsync(indexName0, model0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/objectID", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getRecommendRule0")]
  public async Task GetRecommendRuleTest0()
  {
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const string objectID0 = "objectID";

    await _client.GetRecommendRuleAsync(indexName0, model0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/objectID", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getRecommendStatus0")]
  public async Task GetRecommendStatusTest0()
  {
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const long taskID0 = 12345L;

    await _client.GetRecommendStatusAsync(indexName0, model0, taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/task/12345", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "get recommendations for recommend model with minimal parameters")]
  public async Task GetRecommendationsTest0()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get recommendations for recommend model with all parameters")]
  public async Task GetRecommendationsTest1()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3; const int maxRecommendations3 = 10;
        requests_02.MaxRecommendations = maxRecommendations3; var queryParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          queryParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "query";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          queryParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.QueryParameters = queryParameters3; var fallbackParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          fallbackParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "fallback";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          fallbackParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.FallbackParameters = fallbackParameters3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get recommendations for trending model with minimal parameters")]
  public async Task GetRecommendationsTest2()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new TrendingItemsQuery();
      {
        const string indexName3 = "indexName";
        requests_02.IndexName = indexName3; var model3 = (TrendingItemsModel)Enum.Parse(typeof(TrendingItemsModel), "TrendingItems");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get recommendations for trending model with all parameters")]
  public async Task GetRecommendationsTest3()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new TrendingItemsQuery();
      {
        const string indexName3 = "indexName";
        requests_02.IndexName = indexName3; var model3 = (TrendingItemsModel)Enum.Parse(typeof(TrendingItemsModel), "TrendingItems");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3; const int maxRecommendations3 = 10;
        requests_02.MaxRecommendations = maxRecommendations3; const string facetName3 = "myFacetName";
        requests_02.FacetName = facetName3; const string facetValue3 = "myFacetValue";
        requests_02.FacetValue = facetValue3; var queryParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          queryParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "query";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          queryParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.QueryParameters = queryParameters3; var fallbackParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          fallbackParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "fallback";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          fallbackParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.FallbackParameters = fallbackParameters3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get multiple recommendations with minimal parameters")]
  public async Task GetRecommendationsTest4()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName1";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID1";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_02.Model = model3; const int threshold3 = 21;
        requests_02.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_02)); var requests_12 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName2";
        requests_12.IndexName = indexName3; const string objectID3 = "objectID2";
        requests_12.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_12.Model = model3; const int threshold3 = 21;
        requests_12.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_12));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get multiple recommendations with all parameters")]
  public async Task GetRecommendationsTest5()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName1";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID1";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_02.Model = model3; const int threshold3 = 21;
        requests_02.Threshold = threshold3; const int maxRecommendations3 = 10;
        requests_02.MaxRecommendations = maxRecommendations3; var queryParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          queryParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "query1";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          queryParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.QueryParameters = queryParameters3; var fallbackParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          fallbackParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "fallback1";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          fallbackParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_02.FallbackParameters = fallbackParameters3;
      }
      requests1.Add(new RecommendationsRequest(requests_02)); var requests_12 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName2";
        requests_12.IndexName = indexName3; const string objectID3 = "objectID2";
        requests_12.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_12.Model = model3; const int threshold3 = 21;
        requests_12.Threshold = threshold3; const int maxRecommendations3 = 10;
        requests_12.MaxRecommendations = maxRecommendations3; var queryParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          queryParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "query2";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          queryParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_12.QueryParameters = queryParameters3; var fallbackParameters3 = new SearchParamsObject();
        {
          const string query4 = "myQuery";
          fallbackParameters3.Query = query4; var facetFilters4 = new List<MixedSearchFilters>();
          const string facetFilters_05 = "fallback2";
          facetFilters4.Add(new MixedSearchFilters(facetFilters_05));
          fallbackParameters3.FacetFilters = new FacetFilters(facetFilters4);
        }
        requests_12.FallbackParameters = fallbackParameters3;
      }
      requests1.Add(new RecommendationsRequest(requests_12));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get frequently bought together recommendations")]
  public async Task GetRecommendationsTest6()
  {
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName1";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID1";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "BoughtTogether");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }

    await _client.GetRecommendationsAsync(getRecommendationsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/recommendations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchRecommendRules0")]
  public async Task SearchRecommendRulesTest0()
  {
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");

    await _client.SearchRecommendRulesAsync(indexName0, model0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/related-products/recommend/rules/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
}

using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.QuerySuggestions;
using dotenv.net;
using Newtonsoft.Json;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class QuerySuggestionsClientRequestTests
{
  private readonly QuerySuggestionsClient _client;
  private readonly EchoHttpRequester _echo;

  public QuerySuggestionsClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("appId", "apiKey", "us"),
      _echo
    );
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "createConfig0")]
  public async Task CreateConfigTest0()
  {
    await _client.CreateConfigAsync(
      new QuerySuggestionsConfigurationWithIndex
      {
        IndexName = "theIndexName",
        SourceIndices = new List<SourceIndex>
        {
          new SourceIndex
          {
            IndexName = "testIndex",
            Facets = new List<Facet> { new Facet { Attribute = "test", } },
            Generate = new List<List<string>>
            {
              new List<string> { "facetA", "facetB" },
              new List<string> { "facetC" }
            },
          }
        },
        Languages = new Languages(new List<string> { "french" }),
        Exclude = new List<string> { "test" },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"indexName\":\"theIndexName\",\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attribute\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
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
      new Dictionary<string, object> { { "query", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions can override default query parameters")]
  public async Task CustomPostTest2()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>() { { "query", "myQueryParameter" } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions merges query parameters with default ones")]
  public async Task CustomPostTest3()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>() { { "query2", "myQueryParameter" } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions can override default headers")]
  public async Task CustomPostTest4()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        Headers = new Dictionary<string, string>() { { "x-algolia-api-key", "myApiKey" } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
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
      new RequestOptions()
      {
        Headers = new Dictionary<string, string>() { { "x-algolia-api-key", "myApiKey" } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
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
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>() { { "isItWorking", true } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts integers")]
  public async Task CustomPostTest7()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>() { { "myParam", 2 } },
      }
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of string")]
  public async Task CustomPostTest8()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>()
        {
          {
            "myParam",
            new List<object> { "c", "d" }
          }
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"c,d\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of booleans")]
  public async Task CustomPostTest9()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>()
        {
          {
            "myParam",
            new List<object> { true, true, false }
          }
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "requestOptions queryParameters accepts list of integers")]
  public async Task CustomPostTest10()
  {
    await _client.CustomPostAsync(
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptions()
      {
        QueryParameters = new Dictionary<string, object>()
        {
          {
            "myParam",
            new List<object> { 1, 2 }
          }
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"query\":\"parameters\",\"myParam\":\"1,2\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
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

    foreach (var query in actualQuery)
    {
      expectedQuery.TryGetValue(query.Key, out var result);
      Assert.Equal(query.Value, result);
    }
  }

  [Fact(DisplayName = "deleteConfig0")]
  public async Task DeleteConfigTest0()
  {
    await _client.DeleteConfigAsync("theIndexName");

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs/theIndexName", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getAllConfigs0")]
  public async Task GetAllConfigsTest0()
  {
    await _client.GetAllConfigsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getConfig0")]
  public async Task GetConfigTest0()
  {
    await _client.GetConfigAsync("theIndexName");

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs/theIndexName", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getConfigStatus0")]
  public async Task GetConfigStatusTest0()
  {
    await _client.GetConfigStatusAsync("theIndexName");

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs/theIndexName/status", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getLogFile0")]
  public async Task GetLogFileTest0()
  {
    await _client.GetLogFileAsync("theIndexName");

    var req = _echo.LastResponse;
    Assert.Equal("/1/logs/theIndexName", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "updateConfig0")]
  public async Task UpdateConfigTest0()
  {
    await _client.UpdateConfigAsync(
      "theIndexName",
      new QuerySuggestionsConfiguration
      {
        SourceIndices = new List<SourceIndex>
        {
          new SourceIndex
          {
            IndexName = "testIndex",
            Facets = new List<Facet> { new Facet { Attribute = "test", } },
            Generate = new List<List<string>>
            {
              new List<string> { "facetA", "facetB" },
              new List<string> { "facetC" }
            },
          }
        },
        Languages = new Languages(new List<string> { "french" }),
        Exclude = new List<string> { "test" },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/configs/theIndexName", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attribute\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }
}

using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Analytics;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class AnalyticsClientRequestTests
{
  private readonly AnalyticsClient _client,
    _e2eClient;
  private readonly EchoHttpRequester _echo;

  public AnalyticsClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);

    DotEnv.Load(
      options: new DotEnvOptions(
        ignoreExceptions: true,
        probeForEnv: true,
        probeLevelsToSearch: 8,
        envFilePaths: new[] { ".env" }
      )
    );

    var e2EAppId = Environment.GetEnvironmentVariable("ALGOLIA_APPLICATION_ID");
    if (e2EAppId == null)
    {
      throw new Exception("please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests");
    }

    var e2EApiKey = Environment.GetEnvironmentVariable("ALGOLIA_ADMIN_KEY");
    if (e2EApiKey == null)
    {
      throw new Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests");
    }

    _e2eClient = new AnalyticsClient(new AnalyticsConfig(e2EAppId, e2EApiKey, "us"));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "allow del method for a custom path with minimal parameters")]
  public async Task CustomDeleteTest0()
  {
    await _client.CustomDeleteAsync("test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/test/minimal", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "allow del method for a custom path with all parameters")]
  public async Task CustomDeleteTest1()
  {
    await _client.CustomDeleteAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/all", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    await _client.CustomGetAsync("test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/test/minimal", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "allow get method for a custom path with all parameters")]
  public async Task CustomGetTest1()
  {
    await _client.CustomGetAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters with space" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/all",
      new Dictionary<string, object> { { "query", "to be overriden" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("query", "parameters with space")
        .AddExtraQueryParameters("and an array", new List<object> { "array", "with spaces" })
        .AddExtraHeader("x-header-1", "spaces are left alone")
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/all", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    var expectedHeaders = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    await _client.CustomPostAsync("test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/test/minimal", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "allow post method for a custom path with all parameters")]
  public async Task CustomPostTest1()
  {
    await _client.CustomPostAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/all", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"body\":\"parameters\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query2", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    var expectedHeaders = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    var expectedHeaders = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("isItWorking", true).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("myParam", 2).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { "b and c", "d" })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { true, true, false })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
      "test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder()
        .AddExtraQueryParameters("myParam", new List<object> { 1, 2 })
        .Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/requestOptions", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"facet\":\"filters\"}", req.Body, new JsonDiffConfig(false));
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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
    await _client.CustomPutAsync("test/minimal");

    var req = _echo.LastResponse;
    Assert.Equal("/test/minimal", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "allow put method for a custom path with all parameters")]
  public async Task CustomPutTest1()
  {
    await _client.CustomPutAsync(
      "test/all",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "body", "parameters" } }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/test/all", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"body\":\"parameters\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
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

  [Fact(DisplayName = "get getAverageClickPosition with minimal parameters")]
  public async Task GetAverageClickPositionTest0()
  {
    await _client.GetAverageClickPositionAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/averageClickPosition", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getAverageClickPosition with all parameters")]
  public async Task GetAverageClickPositionTest1()
  {
    await _client.GetAverageClickPositionAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/averageClickPosition", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getClickPositions with minimal parameters")]
  public async Task GetClickPositionsTest0()
  {
    await _client.GetClickPositionsAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/positions", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getClickPositions with all parameters")]
  public async Task GetClickPositionsTest1()
  {
    await _client.GetClickPositionsAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/positions", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getClickThroughRate with minimal parameters")]
  public async Task GetClickThroughRateTest0()
  {
    await _client.GetClickThroughRateAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/clickThroughRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getClickThroughRate with all parameters")]
  public async Task GetClickThroughRateTest1()
  {
    await _client.GetClickThroughRateAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/clicks/clickThroughRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getConversationRate with minimal parameters")]
  public async Task GetConversationRateTest0()
  {
    await _client.GetConversationRateAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/conversions/conversionRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getConversationRate with all parameters")]
  public async Task GetConversationRateTest1()
  {
    await _client.GetConversationRateAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/conversions/conversionRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getNoClickRate with minimal parameters")]
  public async Task GetNoClickRateTest0()
  {
    await _client.GetNoClickRateAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClickRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getNoClickRate with all parameters")]
  public async Task GetNoClickRateTest1()
  {
    await _client.GetNoClickRateAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClickRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getNoResultsRate with minimal parameters")]
  public async Task GetNoResultsRateTest0()
  {
    await _client.GetNoResultsRateAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResultRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getNoResultsRate with all parameters")]
  public async Task GetNoResultsRateTest1()
  {
    await _client.GetNoResultsRateAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResultRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getSearchesCount with minimal parameters")]
  public async Task GetSearchesCountTest0()
  {
    await _client.GetSearchesCountAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getSearchesCount with all parameters")]
  public async Task GetSearchesCountTest1()
  {
    await _client.GetSearchesCountAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getSearchesNoClicks with minimal parameters")]
  public async Task GetSearchesNoClicksTest0()
  {
    await _client.GetSearchesNoClicksAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClicks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getSearchesNoClicks with all parameters")]
  public async Task GetSearchesNoClicksTest1()
  {
    await _client.GetSearchesNoClicksAsync("index", "1999-09-19", "2001-01-01", 21, 42, "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClicks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getSearchesNoResults with minimal parameters")]
  public async Task GetSearchesNoResultsTest0()
  {
    await _client.GetSearchesNoResultsAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getSearchesNoResults with all parameters")]
  public async Task GetSearchesNoResultsTest1()
  {
    await _client.GetSearchesNoResultsAsync("index", "1999-09-19", "2001-01-01", 21, 42, "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getStatus with minimal parameters")]
  public async Task GetStatusTest0()
  {
    await _client.GetStatusAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/status", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopCountries with minimal parameters")]
  public async Task GetTopCountriesTest0()
  {
    await _client.GetTopCountriesAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/countries", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopCountries with all parameters")]
  public async Task GetTopCountriesTest1()
  {
    await _client.GetTopCountriesAsync("index", "1999-09-19", "2001-01-01", 21, 42, "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/countries", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopFilterAttributes with minimal parameters")]
  public async Task GetTopFilterAttributesTest0()
  {
    await _client.GetTopFilterAttributesAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopFilterAttributes with all parameters")]
  public async Task GetTopFilterAttributesTest1()
  {
    await _client.GetTopFilterAttributesAsync(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopFilterForAttribute with minimal parameters")]
  public async Task GetTopFilterForAttributeTest0()
  {
    await _client.GetTopFilterForAttributeAsync("myAttribute", "index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(
    DisplayName = "get getTopFilterForAttribute with minimal parameters and multiple attributes"
  )]
  public async Task GetTopFilterForAttributeTest1()
  {
    await _client.GetTopFilterForAttributeAsync("myAttribute1,myAttribute2", "index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute1%2CmyAttribute2", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopFilterForAttribute with all parameters")]
  public async Task GetTopFilterForAttributeTest2()
  {
    await _client.GetTopFilterForAttributeAsync(
      "myAttribute",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopFilterForAttribute with all parameters and multiple attributes")]
  public async Task GetTopFilterForAttributeTest3()
  {
    await _client.GetTopFilterForAttributeAsync(
      "myAttribute1,myAttribute2",
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute1%2CmyAttribute2", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopFiltersNoResults with minimal parameters")]
  public async Task GetTopFiltersNoResultsTest0()
  {
    await _client.GetTopFiltersNoResultsAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopFiltersNoResults with all parameters")]
  public async Task GetTopFiltersNoResultsTest1()
  {
    await _client.GetTopFiltersNoResultsAsync(
      "index",
      "mySearch",
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/filters/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopHits with minimal parameters")]
  public async Task GetTopHitsTest0()
  {
    await _client.GetTopHitsAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/hits", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopHits with all parameters")]
  public async Task GetTopHitsTest1()
  {
    await _client.GetTopHitsAsync(
      "index",
      "mySearch",
      true,
      "1999-09-19",
      "2001-01-01",
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/hits", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"search\":\"mySearch\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "get getTopSearches with minimal parameters")]
  public async Task GetTopSearchesTest0()
  {
    await _client.GetTopSearchesAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getTopSearches with all parameters")]
  public async Task GetTopSearchesTest1()
  {
    await _client.GetTopSearchesAsync(
      "index",
      true,
      "1999-09-19",
      "2001-01-01",
      Enum.Parse<OrderBy>("SearchCount"),
      Enum.Parse<Direction>("Asc"),
      21,
      42,
      "tag"
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"orderBy\":\"searchCount\",\"direction\":\"asc\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
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

  [Fact(DisplayName = "e2e with complex query params")]
  public async Task GetTopSearchesTest2()
  {
    await _client.GetTopSearchesAsync("cts_e2e_space in index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/searches", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"cts_e2e_space%20in%20index\"}"
    );
    Assert.NotNull(expectedQuery);

    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var actual in actualQuery)
    {
      expectedQuery.TryGetValue(actual.Key, out var expected);
      Assert.Equal(expected, actual.Value);
    }

    // e2e
    try
    {
      var resp = await _e2eClient.GetTopSearchesAsync("cts_e2e_space in index");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"searches\":[{\"search\":\"\",\"nbHits\":0}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "get getUsersCount with minimal parameters")]
  public async Task GetUsersCountTest0()
  {
    await _client.GetUsersCountAsync("index");

    var req = _echo.LastResponse;
    Assert.Equal("/2/users/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\"}"
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

  [Fact(DisplayName = "get getUsersCount with all parameters")]
  public async Task GetUsersCountTest1()
  {
    await _client.GetUsersCountAsync("index", "1999-09-19", "2001-01-01", "tag");

    var req = _echo.LastResponse;
    Assert.Equal("/2/users/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
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
}

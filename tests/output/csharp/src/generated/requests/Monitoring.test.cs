using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Monitoring;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class MonitoringClientRequestTests
{
  private readonly MonitoringClient _client,
    _e2eClient;
  private readonly EchoHttpRequester _echo;

  public MonitoringClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new MonitoringClient(new MonitoringConfig("appId", "apiKey"), _echo);

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

    var e2EApiKey = Environment.GetEnvironmentVariable("MONITORING_API_KEY");
    if (e2EApiKey == null)
    {
      throw new Exception("please provide an `MONITORING_API_KEY` env var for e2e tests");
    }

    _e2eClient = new MonitoringClient(new MonitoringConfig(e2EAppId, e2EApiKey));
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("query2", "myQueryParameter").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraHeader("x-algolia-api-key", "myApiKey").Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("isItWorking", true).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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
      "/test/requestOptions",
      new Dictionary<string, object> { { "query", "parameters" } },
      new Dictionary<string, string> { { "facet", "filters" } },
      new RequestOptionBuilder().AddExtraQueryParameters("myParam", 2).Build()
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/test/requestOptions", req.Path);
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

  [Fact(DisplayName = "getClusterIncidents")]
  public async Task GetClusterIncidentsTest0()
  {
    await _client.GetClusterIncidentsAsync("c1-de");

    var req = _echo.LastResponse;
    Assert.Equal("/1/incidents/c1-de", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getClusterStatus")]
  public async Task GetClusterStatusTest0()
  {
    await _client.GetClusterStatusAsync("c1-de");

    var req = _echo.LastResponse;
    Assert.Equal("/1/status/c1-de", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getIncidents")]
  public async Task GetIncidentsTest0()
  {
    await _client.GetIncidentsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/incidents", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getIndexingTime")]
  public async Task GetIndexingTimeTest0()
  {
    await _client.GetIndexingTimeAsync("c1-de");

    var req = _echo.LastResponse;
    Assert.Equal("/1/indexing/c1-de", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getInventory")]
  public async Task GetInventoryTest0()
  {
    await _client.GetInventoryAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/inventory/servers", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);

    // e2e
    try
    {
      var resp = await _e2eClient.GetInventoryAsync();
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"inventory\":[{\"name\":\"c30-use-3\",\"region\":\"use\",\"is_replica\":false,\"cluster\":\"c30-use\",\"status\":\"PRODUCTION\",\"type\":\"cluster\"},{\"name\":\"c30-use-2\",\"region\":\"use\",\"is_replica\":false,\"cluster\":\"c30-use\",\"status\":\"PRODUCTION\",\"type\":\"cluster\"},{\"name\":\"c30-use-1\",\"region\":\"use\",\"is_replica\":false,\"cluster\":\"c30-use\",\"status\":\"PRODUCTION\",\"type\":\"cluster\"}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getLatency")]
  public async Task GetLatencyTest0()
  {
    await _client.GetLatencyAsync("c1-de");

    var req = _echo.LastResponse;
    Assert.Equal("/1/latency/c1-de", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getMetrics")]
  public async Task GetMetricsTest0()
  {
    await _client.GetMetricsAsync(Enum.Parse<Metric>("AvgBuildTime"), Enum.Parse<Period>("Minute"));

    var req = _echo.LastResponse;
    Assert.Equal("/1/infrastructure/avg_build_time/period/minute", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getReachability")]
  public async Task GetReachabilityTest0()
  {
    await _client.GetReachabilityAsync("c1-de");

    var req = _echo.LastResponse;
    Assert.Equal("/1/reachability/c1-de/probes", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getStatus")]
  public async Task GetStatusTest0()
  {
    await _client.GetStatusAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/status", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);

    // e2e
    try
    {
      var resp = await _e2eClient.GetStatusAsync();
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"status\":{\"c30-use\":\"operational\"}}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }
}

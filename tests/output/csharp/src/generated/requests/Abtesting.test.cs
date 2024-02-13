using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Abtesting;
using Algolia.Search.Serializer;
using dotenv.net;
using Newtonsoft.Json;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class AbtestingClientRequestTests
{
  private readonly AbtestingClient _client,
    _e2eClient;
  private readonly EchoHttpRequester _echo;

  public AbtestingClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new AbtestingClient(new AbtestingConfig("appId", "apiKey", "us"), _echo);

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

    _e2eClient = new AbtestingClient(new AbtestingConfig(e2EAppId, e2EApiKey, "us"));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "addABTests with minimal parameters")]
  public async Task AddABTestsTest0()
  {
    await _client.AddABTestsAsync(
      new AddABTestsRequest
      {
        EndAt = "2022-12-31T00:00:00.000Z",
        Name = "myABTest",
        Variants = new List<AddABTestsVariant>
        {
          new AddABTestsVariant(
            new AbTestsVariant { Index = "AB_TEST_1", TrafficPercentage = 30, }
          ),
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_2", TrafficPercentage = 50, })
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"endAt\":\"2022-12-31T00:00:00.000Z\",\"name\":\"myABTest\",\"variants\":[{\"index\":\"AB_TEST_1\",\"trafficPercentage\":30},{\"index\":\"AB_TEST_2\",\"trafficPercentage\":50}]}",
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
      "{\"query\":\"parameters\",\"myParam\":\"c%2Cd\"}"
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

  [Fact(DisplayName = "deleteABTest")]
  public async Task DeleteABTestTest0()
  {
    await _client.DeleteABTestAsync(42);

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests/42", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getABTest")]
  public async Task GetABTestTest0()
  {
    await _client.GetABTestAsync(42);

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests/42", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "listABTests with minimal parameters")]
  public async Task ListABTestsTest0()
  {
    await _client.ListABTestsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "listABTests with parameters")]
  public async Task ListABTestsTest1()
  {
    await _client.ListABTestsAsync(0, 21, "cts_e2e ab", "t");

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>(
      "{\"offset\":\"0\",\"limit\":\"21\",\"indexPrefix\":\"cts_e2e%20ab\",\"indexSuffix\":\"t\"}"
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
      var resp = await _e2eClient.ListABTestsAsync(0, 21, "cts_e2e ab", "t");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"abtests\":[{\"abTestID\":84617,\"createdAt\":\"2024-02-06T10:04:30.209477Z\",\"endAt\":\"2024-05-06T09:04:26.469Z\",\"name\":\"cts_e2e_abtest\",\"status\":\"active\",\"variants\":[{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"\",\"index\":\"cts_e2e_search_facet\",\"purchaseCount\":0,\"trafficPercentage\":25},{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"\",\"index\":\"cts_e2e abtest\",\"purchaseCount\":0,\"trafficPercentage\":75}]}],\"count\":1,\"total\":1}",
        JsonConvert.SerializeObject(resp, settings: JsonConfig.AlgoliaJsonSerializerSettings),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "stopABTest")]
  public async Task StopABTestTest0()
  {
    await _client.StopABTestAsync(42);

    var req = _echo.LastResponse;
    Assert.Equal("/2/abtests/42/stop", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
}

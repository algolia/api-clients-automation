using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Ingestion;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class IngestionClientRequestTests
{
  private readonly IngestionClient _client,
    _e2eClient;
  private readonly EchoHttpRequester _echo;

  public IngestionClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);

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

    _e2eClient = new IngestionClient(new IngestionConfig(e2EAppId, e2EApiKey, "us"));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "createAuthenticationOAuth")]
  public async Task CreateAuthenticationTest0()
  {
    await _client.CreateAuthenticationAsync(
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

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createAuthenticationAlgolia")]
  public async Task CreateAuthenticationTest1()
  {
    await _client.CreateAuthenticationAsync(
      new AuthenticationCreate
      {
        Type = Enum.Parse<AuthenticationType>("Algolia"),
        Name = "authName",
        Input = new AuthInput(new AuthAlgolia { AppID = "myappID", ApiKey = "randomApiKey", }),
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"type\":\"algolia\",\"name\":\"authName\",\"input\":{\"appID\":\"myappID\",\"apiKey\":\"randomApiKey\"}}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createDestination")]
  public async Task CreateDestinationTest0()
  {
    await _client.CreateDestinationAsync(
      new DestinationCreate
      {
        Type = Enum.Parse<DestinationType>("Search"),
        Name = "destinationName",
        Input = new DestinationInput(new DestinationIndexPrefix { IndexPrefix = "prefix_", }),
        AuthenticationID = "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexPrefix\":\"prefix_\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createSource")]
  public async Task CreateSourceTest0()
  {
    await _client.CreateSourceAsync(
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

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"type\":\"commercetools\",\"name\":\"sourceName\",\"input\":{\"storeKeys\":[\"myStore\"],\"locales\":[\"de\"],\"url\":\"http://commercetools.com\",\"projectKey\":\"keyID\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createTaskOnDemand")]
  public async Task CreateTaskTest0()
  {
    await _client.CreateTaskAsync(
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

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createTaskSchedule")]
  public async Task CreateTaskTest1()
  {
    await _client.CreateTaskAsync(
      new TaskCreate
      {
        SourceID = "search",
        DestinationID = "destinationName",
        Trigger = new TaskCreateTrigger(
          new ScheduleTriggerInput
          {
            Type = Enum.Parse<ScheduleTriggerType>("Schedule"),
            Cron = "* * * * *",
          }
        ),
        Action = Enum.Parse<ActionType>("Replace"),
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"schedule\",\"cron\":\"* * * * *\"},\"action\":\"replace\"}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "createTaskSubscription")]
  public async Task CreateTaskTest2()
  {
    await _client.CreateTaskAsync(
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

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}",
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

  [Fact(DisplayName = "deleteAuthentication")]
  public async Task DeleteAuthenticationTest0()
  {
    await _client.DeleteAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "deleteDestination")]
  public async Task DeleteDestinationTest0()
  {
    await _client.DeleteDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "deleteSource")]
  public async Task DeleteSourceTest0()
  {
    await _client.DeleteSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "deleteTask")]
  public async Task DeleteTaskTest0()
  {
    await _client.DeleteTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "disableTask")]
  public async Task DisableTaskTest0()
  {
    await _client.DisableTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }

  [Fact(DisplayName = "enable task e2e")]
  public async Task EnableTaskTest0()
  {
    await _client.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    Assert.Equal("{}", req.Body);

    // e2e
    try
    {
      var resp = await _e2eClient.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getAuthentication")]
  public async Task GetAuthenticationTest0()
  {
    await _client.GetAuthenticationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getAuthentications")]
  public async Task GetAuthenticationsTest0()
  {
    await _client.GetAuthenticationsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getAuthentications with query params")]
  public async Task GetAuthenticationsTest1()
  {
    await _client.GetAuthenticationsAsync(
      10,
      1,
      new List<AuthenticationType>
      {
        Enum.Parse<AuthenticationType>("Basic"),
        Enum.Parse<AuthenticationType>("Algolia")
      },
      new List<PlatformWithNone> { new PlatformWithNone(Enum.Parse<PlatformNone>("None")) },
      Enum.Parse<AuthenticationSortKeys>("CreatedAt"),
      Enum.Parse<OrderKeys>("Desc")
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonSerializer.Deserialize<Dictionary<string, string>>(
      "{\"itemsPerPage\":\"10\",\"page\":\"1\",\"type\":\"basic%2Calgolia\",\"platform\":\"none\",\"sort\":\"createdAt\",\"order\":\"desc\"}"
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
      var resp = await _e2eClient.GetAuthenticationsAsync(
        10,
        1,
        new List<AuthenticationType>
        {
          Enum.Parse<AuthenticationType>("Basic"),
          Enum.Parse<AuthenticationType>("Algolia")
        },
        new List<PlatformWithNone> { new PlatformWithNone(Enum.Parse<PlatformNone>("None")) },
        Enum.Parse<AuthenticationSortKeys>("CreatedAt"),
        Enum.Parse<OrderKeys>("Desc")
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"pagination\":{\"page\":1,\"itemsPerPage\":10},\"authentications\":[{\"authenticationID\":\"b57a7ea5-8592-493b-b75b-6c66d77aee7f\",\"type\":\"algolia\",\"name\":\"Auto-generated Authentication for T8JK9S7I7X - 1704732447751\",\"input\":{},\"createdAt\":\"2024-01-08T16:47:31Z\",\"updatedAt\":\"2024-01-08T16:47:31Z\"},{},{},{},{},{},{},{}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getDestination")]
  public async Task GetDestinationTest0()
  {
    await _client.GetDestinationAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getDestinations")]
  public async Task GetDestinationsTest0()
  {
    await _client.GetDestinationsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getDockerSourceStreams")]
  public async Task GetDockerSourceStreamsTest0()
  {
    await _client.GetDockerSourceStreamsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getEvent")]
  public async Task GetEventTest0()
  {
    await _client.GetEventAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
    );

    var req = _echo.LastResponse;
    Assert.Equal(
      "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c",
      req.Path
    );
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getEvents")]
  public async Task GetEventsTest0()
  {
    await _client.GetEventsAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getRun")]
  public async Task GetRunTest0()
  {
    await _client.GetRunAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getRuns")]
  public async Task GetRunsTest0()
  {
    await _client.GetRunsAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/runs", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getSource")]
  public async Task GetSourceTest0()
  {
    await _client.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);

    // e2e
    try
    {
      var resp = await _e2eClient.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"name\":\"cts_e2e_browse\",\"type\":\"json\",\"input\":{\"url\":\"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json\"}}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getSources")]
  public async Task GetSourcesTest0()
  {
    await _client.GetSourcesAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getTask")]
  public async Task GetTaskTest0()
  {
    await _client.GetTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "getTasks")]
  public async Task GetTasksTest0()
  {
    await _client.GetTasksAsync();

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }

  [Fact(DisplayName = "runTask")]
  public async Task RunTaskTest0()
  {
    await _client.RunTaskAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }

  [Fact(DisplayName = "searchAuthentications")]
  public async Task SearchAuthenticationsTest0()
  {
    await _client.SearchAuthenticationsAsync(
      new AuthenticationSearch
      {
        AuthenticationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"authenticationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "searchDestinations")]
  public async Task SearchDestinationsTest0()
  {
    await _client.SearchDestinationsAsync(
      new DestinationSearch
      {
        DestinationIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"destinationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "searchSources")]
  public async Task SearchSourcesTest0()
  {
    await _client.SearchSourcesAsync(
      new SourceSearch
      {
        SourceIDs = new List<string>
        {
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a"
        },
      }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"sourceIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "searchTasks")]
  public async Task SearchTasksTest0()
  {
    await _client.SearchTasksAsync(
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

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault(
      "{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\",\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"]}",
      req.Body,
      new JsonDiffConfig(false)
    );

    // e2e
    try
    {
      var resp = await _e2eClient.SearchTasksAsync(
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
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\",\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"destinationID\":\"506d79fa-e29d-4bcf-907c-6b6a41172153\",\"trigger\":{\"type\":\"onDemand\"},\"enabled\":true,\"failureThreshold\":0,\"action\":\"replace\",\"createdAt\":\"2024-01-08T16:47:41Z\"}]",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "triggerDockerSourceDiscover")]
  public async Task TriggerDockerSourceDiscoverTest0()
  {
    await _client.TriggerDockerSourceDiscoverAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }

  [Fact(DisplayName = "updateAuthentication")]
  public async Task UpdateAuthenticationTest0()
  {
    await _client.UpdateAuthenticationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new AuthenticationUpdate { Name = "newName", }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "updateDestination")]
  public async Task UpdateDestinationTest0()
  {
    await _client.UpdateDestinationAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new DestinationUpdate { Name = "newName", }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "updateSource")]
  public async Task UpdateSourceTest0()
  {
    await _client.UpdateSourceAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate { Name = "newName", }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(false));
  }

  [Fact(DisplayName = "updateTask")]
  public async Task UpdateTaskTest0()
  {
    await _client.UpdateTaskAsync(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new TaskUpdate { Enabled = false, }
    );

    var req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"enabled\":false}", req.Body, new JsonDiffConfig(false));
  }
}

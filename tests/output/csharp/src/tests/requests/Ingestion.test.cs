using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;
using Xunit;
using Newtonsoft.Json;
using Quibble.Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class IngestionClientRequestTests
{
  private readonly IngestionClient _client;
  private readonly EchoHttpRequester _echo;

  public IngestionClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
  }

  [Fact]
  public void Dispose()
  {

  }

  [Fact(DisplayName = "createAuthenticationOAuth")]
  public async Task CreateAuthenticationTest0()
  {
    var authenticationCreate0 = new AuthenticationCreate();
    {
      var type1 = (AuthenticationType)Enum.Parse(typeof(AuthenticationType), "Oauth");
      authenticationCreate0.Type = type1; const string name1 = "authName";
      authenticationCreate0.Name = name1; var input1 = new AuthOAuth();
      {
        const string url2 = "http://test.oauth";
        input1.Url = url2; const string client_id2 = "myID";
        input1.ClientId = client_id2; const string client_secret2 = "mySecret";
        input1.ClientSecret = client_secret2;
      }
      authenticationCreate0.Input = new AuthInput(input1);
    }

    await _client.CreateAuthenticationAsync(authenticationCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createAuthenticationAlgolia")]
  public async Task CreateAuthenticationTest1()
  {
    var authenticationCreate0 = new AuthenticationCreate();
    {
      var type1 = (AuthenticationType)Enum.Parse(typeof(AuthenticationType), "Algolia");
      authenticationCreate0.Type = type1; const string name1 = "authName";
      authenticationCreate0.Name = name1; var input1 = new AuthAlgolia();
      {
        const string appID2 = "myappID";
        input1.AppID = appID2; const string apiKey2 = "randomApiKey";
        input1.ApiKey = apiKey2;
      }
      authenticationCreate0.Input = new AuthInput(input1);
    }

    await _client.CreateAuthenticationAsync(authenticationCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"type\":\"algolia\",\"name\":\"authName\",\"input\":{\"appID\":\"myappID\",\"apiKey\":\"randomApiKey\"}}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createDestination")]
  public async Task CreateDestinationTest0()
  {
    var destinationCreate0 = new DestinationCreate();
    {
      var type1 = (DestinationType)Enum.Parse(typeof(DestinationType), "Search");
      destinationCreate0.Type = type1; const string name1 = "destinationName";
      destinationCreate0.Name = name1; var input1 = new DestinationIndexPrefix();
      {
        const string indexPrefix2 = "prefix_";
        input1.IndexPrefix = indexPrefix2;
      }
      destinationCreate0.Input = new DestinationInput(input1); const string authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      destinationCreate0.AuthenticationID = authenticationID1;
    }

    await _client.CreateDestinationAsync(destinationCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexPrefix\":\"prefix_\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createSource")]
  public async Task CreateSourceTest0()
  {
    var sourceCreate0 = new SourceCreate();
    {
      var type1 = (SourceType)Enum.Parse(typeof(SourceType), "Commercetools");
      sourceCreate0.Type = type1; const string name1 = "sourceName";
      sourceCreate0.Name = name1; var input1 = new SourceCommercetools();
      {
        var storeKeys2 = new List<string>();
        const string storeKeys_03 = "myStore";
        storeKeys2.Add(storeKeys_03);
        input1.StoreKeys = storeKeys2; var locales2 = new List<string>();
        const string locales_03 = "de";
        locales2.Add(locales_03);
        input1.Locales = locales2; const string url2 = "http://commercetools.com";
        input1.Url = url2; const string projectKey2 = "keyID";
        input1.ProjectKey = projectKey2;
      }
      sourceCreate0.Input = new SourceInput(input1); const string authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      sourceCreate0.AuthenticationID = authenticationID1;
    }

    await _client.CreateSourceAsync(sourceCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"type\":\"commercetools\",\"name\":\"sourceName\",\"input\":{\"storeKeys\":[\"myStore\"],\"locales\":[\"de\"],\"url\":\"http://commercetools.com\",\"projectKey\":\"keyID\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createTaskOnDemand")]
  public async Task CreateTaskTest0()
  {
    var taskCreate0 = new TaskCreate();
    {
      const string sourceID1 = "search";
      taskCreate0.SourceID = sourceID1; const string destinationID1 = "destinationName";
      taskCreate0.DestinationID = destinationID1; var trigger1 = new OnDemandTriggerInput();
      {
        var type2 = (OnDemandTriggerType)Enum.Parse(typeof(OnDemandTriggerType), "OnDemand");
        trigger1.Type = type2;
      }
      taskCreate0.Trigger = new TaskCreateTrigger(trigger1); var action1 = (ActionType)Enum.Parse(typeof(ActionType), "Replace");
      taskCreate0.Action = action1;
    }

    await _client.CreateTaskAsync(taskCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createTaskSchedule")]
  public async Task CreateTaskTest1()
  {
    var taskCreate0 = new TaskCreate();
    {
      const string sourceID1 = "search";
      taskCreate0.SourceID = sourceID1; const string destinationID1 = "destinationName";
      taskCreate0.DestinationID = destinationID1; var trigger1 = new ScheduleTriggerInput();
      {
        var type2 = (ScheduleTriggerType)Enum.Parse(typeof(ScheduleTriggerType), "Schedule");
        trigger1.Type = type2; const string cron2 = "* * * * *";
        trigger1.Cron = cron2;
      }
      taskCreate0.Trigger = new TaskCreateTrigger(trigger1); var action1 = (ActionType)Enum.Parse(typeof(ActionType), "Replace");
      taskCreate0.Action = action1;
    }

    await _client.CreateTaskAsync(taskCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"schedule\",\"cron\":\"* * * * *\"},\"action\":\"replace\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "createTaskSubscription")]
  public async Task CreateTaskTest2()
  {
    var taskCreate0 = new TaskCreate();
    {
      const string sourceID1 = "search";
      taskCreate0.SourceID = sourceID1; const string destinationID1 = "destinationName";
      taskCreate0.DestinationID = destinationID1; var trigger1 = new OnDemandTriggerInput();
      {
        var type2 = (OnDemandTriggerType)Enum.Parse(typeof(OnDemandTriggerType), "OnDemand");
        trigger1.Type = type2;
      }
      taskCreate0.Trigger = new TaskCreateTrigger(trigger1); var action1 = (ActionType)Enum.Parse(typeof(ActionType), "Replace");
      taskCreate0.Action = action1;
    }

    await _client.CreateTaskAsync(taskCreate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}", req.Body, new JsonDiffConfig(true));
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
  [Fact(DisplayName = "deleteAuthentication")]
  public async Task DeleteAuthenticationTest0()
  {
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.DeleteAuthenticationAsync(authenticationID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteDestination")]
  public async Task DeleteDestinationTest0()
  {
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.DeleteDestinationAsync(destinationID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteSource")]
  public async Task DeleteSourceTest0()
  {
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.DeleteSourceAsync(sourceID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteTask")]
  public async Task DeleteTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.DeleteTaskAsync(taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "disableTask")]
  public async Task DisableTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.DisableTaskAsync(taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "enableTask")]
  public async Task EnableTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.EnableTaskAsync(taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/enable", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "getAuthentication")]
  public async Task GetAuthenticationTest0()
  {
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetAuthenticationAsync(authenticationID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getAuthentications")]
  public async Task GetAuthenticationsTest0()
  {

    await _client.GetAuthenticationsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getDestination")]
  public async Task GetDestinationTest0()
  {
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetDestinationAsync(destinationID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getDestinations")]
  public async Task GetDestinationsTest0()
  {

    await _client.GetDestinationsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getDockerSourceStreams")]
  public async Task GetDockerSourceStreamsTest0()
  {
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetDockerSourceStreamsAsync(sourceID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getEvent")]
  public async Task GetEventTest0()
  {
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    const string eventID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0c";

    await _client.GetEventAsync(runID0, eventID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getEvents")]
  public async Task GetEventsTest0()
  {
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetEventsAsync(runID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getRun")]
  public async Task GetRunTest0()
  {
    const string runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetRunAsync(runID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getRuns")]
  public async Task GetRunsTest0()
  {

    await _client.GetRunsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/runs", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getSource")]
  public async Task GetSourceTest0()
  {
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetSourceAsync(sourceID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getSources")]
  public async Task GetSourcesTest0()
  {

    await _client.GetSourcesAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getTask")]
  public async Task GetTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.GetTaskAsync(taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getTasks")]
  public async Task GetTasksTest0()
  {

    await _client.GetTasksAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "runTask")]
  public async Task RunTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.RunTaskAsync(taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "searchAuthentications")]
  public async Task SearchAuthenticationsTest0()
  {
    var authenticationSearch0 = new AuthenticationSearch();
    {
      var authenticationIDs1 = new List<string>();
      const string authenticationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      authenticationIDs1.Add(authenticationIDs_02); const string authenticationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      authenticationIDs1.Add(authenticationIDs_12);
      authenticationSearch0.AuthenticationIDs = authenticationIDs1;
    }

    await _client.SearchAuthenticationsAsync(authenticationSearch0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"authenticationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchDestinations")]
  public async Task SearchDestinationsTest0()
  {
    var destinationSearch0 = new DestinationSearch();
    {
      var destinationIDs1 = new List<string>();
      const string destinationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      destinationIDs1.Add(destinationIDs_02); const string destinationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      destinationIDs1.Add(destinationIDs_12);
      destinationSearch0.DestinationIDs = destinationIDs1;
    }

    await _client.SearchDestinationsAsync(destinationSearch0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"destinationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchSources")]
  public async Task SearchSourcesTest0()
  {
    var sourceSearch0 = new SourceSearch();
    {
      var sourceIDs1 = new List<string>();
      const string sourceIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      sourceIDs1.Add(sourceIDs_02); const string sourceIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      sourceIDs1.Add(sourceIDs_12);
      sourceSearch0.SourceIDs = sourceIDs1;
    }

    await _client.SearchSourcesAsync(sourceSearch0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"sourceIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchTasks")]
  public async Task SearchTasksTest0()
  {
    var taskSearch0 = new TaskSearch();
    {
      var taskIDs1 = new List<string>();
      const string taskIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      taskIDs1.Add(taskIDs_02); const string taskIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
      taskIDs1.Add(taskIDs_12);
      taskSearch0.TaskIDs = taskIDs1;
    }

    await _client.SearchTasksAsync(taskSearch0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "triggerDockerSourceDiscover")]
  public async Task TriggerDockerSourceDiscoverTest0()
  {
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    await _client.TriggerDockerSourceDiscoverAsync(sourceID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "updateAuthentication")]
  public async Task UpdateAuthenticationTest0()
  {
    const string authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var authenticationUpdate0 = new AuthenticationUpdate();
    {
      const string name1 = "newName";
      authenticationUpdate0.Name = name1;
    }

    await _client.UpdateAuthenticationAsync(authenticationID0, authenticationUpdate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "updateDestination")]
  public async Task UpdateDestinationTest0()
  {
    const string destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var destinationUpdate0 = new DestinationUpdate();
    {
      const string name1 = "newName";
      destinationUpdate0.Name = name1;
    }

    await _client.UpdateDestinationAsync(destinationID0, destinationUpdate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "updateSource")]
  public async Task UpdateSourceTest0()
  {
    const string sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var sourceUpdate0 = new SourceUpdate();
    {
      const string name1 = "newName";
      sourceUpdate0.Name = name1;
    }

    await _client.UpdateSourceAsync(sourceID0, sourceUpdate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"name\":\"newName\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "updateTask")]
  public async Task UpdateTaskTest0()
  {
    const string taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    var taskUpdate0 = new TaskUpdate();
    {
      const bool enabled1 = false;
      taskUpdate0.Enabled = enabled1;
    }

    await _client.UpdateTaskAsync(taskID0, taskUpdate0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.Path);
    Assert.Equal("PATCH", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"enabled\":false}", req.Body, new JsonDiffConfig(true));
  }
}

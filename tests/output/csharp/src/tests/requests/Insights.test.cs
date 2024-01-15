using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Insights;
using Xunit;
using Newtonsoft.Json;
using Quibble.Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class InsightsClientRequestTests
{
  private readonly InsightsClient _client;
  private readonly EchoHttpRequester _echo;

  public InsightsClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
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
  [Fact(DisplayName = "deleteUserToken0")]
  public async Task DeleteUserTokenTest0()
  {
    const string userToken0 = "test-user-1";

    await _client.DeleteUserTokenAsync(userToken0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/usertokens/test-user-1", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "pushEvents0")]
  public async Task PushEventsTest0()
  {
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new ClickedObjectIDsAfterSearch();
      {
        var eventType3 = (ClickEvent)Enum.Parse(typeof(ClickEvent), "Click");
        events_02.EventType = eventType3; const string eventName3 = "Product Clicked";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3; const string queryID3 = "43b15df305339e827f0ac0bdc5ebcaa7";
        events_02.QueryID = queryID3; var positions3 = new List<int>();
        const int positions_04 = 7;
        positions3.Add(positions_04); const int positions_14 = 6;
        positions3.Add(positions_14);
        events_02.Positions = positions3;
      }
      events1.Add(new EventsItems(events_02));
      insightsEvents0.Events = events1;
    }

    await _client.PushEventsAsync(insightsEvents0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/events", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"events\":[{\"eventType\":\"click\",\"eventName\":\"Product Clicked\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"positions\":[7,6]}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "Many events type")]
  public async Task PushEventsTest1()
  {
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new ConvertedObjectIDsAfterSearch();
      {
        var eventType3 = (ConversionEvent)Enum.Parse(typeof(ConversionEvent), "Conversion");
        events_02.EventType = eventType3; const string eventName3 = "Product Purchased";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3; const string queryID3 = "43b15df305339e827f0ac0bdc5ebcaa7";
        events_02.QueryID = queryID3;
      }
      events1.Add(new EventsItems(events_02)); var events_12 = new ViewedObjectIDs();
      {
        var eventType3 = (ViewEvent)Enum.Parse(typeof(ViewEvent), "View");
        events_12.EventType = eventType3; const string eventName3 = "Product Detail Page Viewed";
        events_12.EventName = eventName3; const string index3 = "products";
        events_12.Index = index3; const string userToken3 = "user-123456";
        events_12.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_12.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_12.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_12.ObjectIDs = objectIDs3;
      }
      events1.Add(new EventsItems(events_12));
      insightsEvents0.Events = events1;
    }

    await _client.PushEventsAsync(insightsEvents0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/events", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"},{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "ConvertedObjectIDsAfterSearch")]
  public async Task PushEventsTest2()
  {
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new ConvertedObjectIDsAfterSearch();
      {
        var eventType3 = (ConversionEvent)Enum.Parse(typeof(ConversionEvent), "Conversion");
        events_02.EventType = eventType3; const string eventName3 = "Product Purchased";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3; const string queryID3 = "43b15df305339e827f0ac0bdc5ebcaa7";
        events_02.QueryID = queryID3;
      }
      events1.Add(new EventsItems(events_02));
      insightsEvents0.Events = events1;
    }

    await _client.PushEventsAsync(insightsEvents0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/events", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "ViewedObjectIDs")]
  public async Task PushEventsTest3()
  {
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new ViewedObjectIDs();
      {
        var eventType3 = (ViewEvent)Enum.Parse(typeof(ViewEvent), "View");
        events_02.EventType = eventType3; const string eventName3 = "Product Detail Page Viewed";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3;
      }
      events1.Add(new EventsItems(events_02));
      insightsEvents0.Events = events1;
    }

    await _client.PushEventsAsync(insightsEvents0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/events", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"events\":[{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "AddedToCartObjectIDs")]
  public async Task PushEventsTest4()
  {
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new AddedToCartObjectIDsAfterSearch();
      {
        var eventType3 = (ConversionEvent)Enum.Parse(typeof(ConversionEvent), "Conversion");
        events_02.EventType = eventType3; var eventSubtype3 = (AddToCartEvent)Enum.Parse(typeof(AddToCartEvent), "AddToCart");
        events_02.EventSubtype = eventSubtype3; const string eventName3 = "Product Added To Cart";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string queryID3 = "43b15df305339e827f0ac0bdc5ebcaa7";
        events_02.QueryID = queryID3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3; var objectData3 = new List<ObjectDataAfterSearch>();
        var objectData_04 = new ObjectDataAfterSearch();
        {
          const double price5 = 19.99;
          objectData_04.Price = new Price(price5); const int quantity5 = 10;
          objectData_04.Quantity = quantity5; const double discount5 = 2.5;
          objectData_04.Discount = new Discount(discount5);
        }
        objectData3.Add(objectData_04); var objectData_14 = new ObjectDataAfterSearch();
        {
          const string price5 = "8$";
          objectData_14.Price = new Price(price5); const int quantity5 = 7;
          objectData_14.Quantity = quantity5; const string discount5 = "30%";
          objectData_14.Discount = new Discount(discount5);
        }
        objectData3.Add(objectData_14);
        events_02.ObjectData = objectData3; const string currency3 = "USD";
        events_02.Currency = currency3;
      }
      events1.Add(new EventsItems(events_02));
      insightsEvents0.Events = events1;
    }

    await _client.PushEventsAsync(insightsEvents0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/events", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"events\":[{\"eventType\":\"conversion\",\"eventSubtype\":\"addToCart\",\"eventName\":\"Product Added To Cart\",\"index\":\"products\",\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"objectData\":[{\"price\":19.99,\"quantity\":10,\"discount\":2.5},{\"price\":\"8$\",\"quantity\":7,\"discount\":\"30%\"}],\"currency\":\"USD\"}]}", req.Body, new JsonDiffConfig(true));
  }
}

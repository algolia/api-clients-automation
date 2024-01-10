using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Analytics;
using Xunit;
using Newtonsoft.Json;
using Quibble.Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class AnalyticsClientRequestTests
{
  private readonly AnalyticsClient _client;
  private readonly EchoHttpRequester _echo;

  public AnalyticsClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);
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
  [Fact(DisplayName = "get getAverageClickPosition with minimal parameters")]
  public async Task GetAverageClickPositionTest0()
  {
    const string index0 = "index";

    await _client.GetAverageClickPositionAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/averageClickPosition", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getAverageClickPosition with all parameters")]
  public async Task GetAverageClickPositionTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetAverageClickPositionAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/averageClickPosition", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getClickPositions with minimal parameters")]
  public async Task GetClickPositionsTest0()
  {
    const string index0 = "index";

    await _client.GetClickPositionsAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/positions", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getClickPositions with all parameters")]
  public async Task GetClickPositionsTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetClickPositionsAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/positions", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getClickThroughRate with minimal parameters")]
  public async Task GetClickThroughRateTest0()
  {
    const string index0 = "index";

    await _client.GetClickThroughRateAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/clickThroughRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getClickThroughRate with all parameters")]
  public async Task GetClickThroughRateTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetClickThroughRateAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/clicks/clickThroughRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getConversationRate with minimal parameters")]
  public async Task GetConversationRateTest0()
  {
    const string index0 = "index";

    await _client.GetConversationRateAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/conversions/conversionRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getConversationRate with all parameters")]
  public async Task GetConversationRateTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetConversationRateAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/conversions/conversionRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getNoClickRate with minimal parameters")]
  public async Task GetNoClickRateTest0()
  {
    const string index0 = "index";

    await _client.GetNoClickRateAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClickRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getNoClickRate with all parameters")]
  public async Task GetNoClickRateTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetNoClickRateAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClickRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getNoResultsRate with minimal parameters")]
  public async Task GetNoResultsRateTest0()
  {
    const string index0 = "index";

    await _client.GetNoResultsRateAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResultRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getNoResultsRate with all parameters")]
  public async Task GetNoResultsRateTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetNoResultsRateAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResultRate", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesCount with minimal parameters")]
  public async Task GetSearchesCountTest0()
  {
    const string index0 = "index";

    await _client.GetSearchesCountAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesCount with all parameters")]
  public async Task GetSearchesCountTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetSearchesCountAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesNoClicks with minimal parameters")]
  public async Task GetSearchesNoClicksTest0()
  {
    const string index0 = "index";

    await _client.GetSearchesNoClicksAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClicks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesNoClicks with all parameters")]
  public async Task GetSearchesNoClicksTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetSearchesNoClicksAsync(index0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noClicks", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesNoResults with minimal parameters")]
  public async Task GetSearchesNoResultsTest0()
  {
    const string index0 = "index";

    await _client.GetSearchesNoResultsAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getSearchesNoResults with all parameters")]
  public async Task GetSearchesNoResultsTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetSearchesNoResultsAsync(index0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getStatus with minimal parameters")]
  public async Task GetStatusTest0()
  {
    const string index0 = "index";

    await _client.GetStatusAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/status", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopCountries with minimal parameters")]
  public async Task GetTopCountriesTest0()
  {
    const string index0 = "index";

    await _client.GetTopCountriesAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/countries", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopCountries with all parameters")]
  public async Task GetTopCountriesTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopCountriesAsync(index0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/countries", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterAttributes with minimal parameters")]
  public async Task GetTopFilterAttributesTest0()
  {
    const string index0 = "index";

    await _client.GetTopFilterAttributesAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterAttributes with all parameters")]
  public async Task GetTopFilterAttributesTest1()
  {
    const string index0 = "index";
    const string search0 = "mySearch";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopFilterAttributesAsync(index0, search0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterForAttribute with minimal parameters")]
  public async Task GetTopFilterForAttributeTest0()
  {
    const string attribute0 = "myAttribute";
    const string index0 = "index";

    await _client.GetTopFilterForAttributeAsync(attribute0, index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterForAttribute with minimal parameters and multiple attributes")]
  public async Task GetTopFilterForAttributeTest1()
  {
    const string attribute0 = "myAttribute1,myAttribute2";
    const string index0 = "index";

    await _client.GetTopFilterForAttributeAsync(attribute0, index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute1%2CmyAttribute2", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterForAttribute with all parameters")]
  public async Task GetTopFilterForAttributeTest2()
  {
    const string attribute0 = "myAttribute";
    const string index0 = "index";
    const string search0 = "mySearch";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopFilterForAttributeAsync(attribute0, index0, search0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFilterForAttribute with all parameters and multiple attributes")]
  public async Task GetTopFilterForAttributeTest3()
  {
    const string attribute0 = "myAttribute1,myAttribute2";
    const string index0 = "index";
    const string search0 = "mySearch";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopFilterForAttributeAsync(attribute0, index0, search0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/myAttribute1%2CmyAttribute2", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFiltersNoResults with minimal parameters")]
  public async Task GetTopFiltersNoResultsTest0()
  {
    const string index0 = "index";

    await _client.GetTopFiltersNoResultsAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopFiltersNoResults with all parameters")]
  public async Task GetTopFiltersNoResultsTest1()
  {
    const string index0 = "index";
    const string search0 = "mySearch";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopFiltersNoResultsAsync(index0, search0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/filters/noResults", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopHits with minimal parameters")]
  public async Task GetTopHitsTest0()
  {
    const string index0 = "index";

    await _client.GetTopHitsAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/hits", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopHits with all parameters")]
  public async Task GetTopHitsTest1()
  {
    const string index0 = "index";
    const string search0 = "mySearch";
    const bool clickAnalytics0 = true;
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopHitsAsync(index0, search0, clickAnalytics0, startDate0, endDate0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/hits", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"search\":\"mySearch\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopSearches with minimal parameters")]
  public async Task GetTopSearchesTest0()
  {
    const string index0 = "index";

    await _client.GetTopSearchesAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getTopSearches with all parameters")]
  public async Task GetTopSearchesTest1()
  {
    const string index0 = "index";
    const bool clickAnalytics0 = true;
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    var orderBy0 = (OrderBy)Enum.Parse(typeof(OrderBy), "SearchCount");
    var direction0 = (Direction)Enum.Parse(typeof(Direction), "Asc");
    const int limit0 = 21;
    const int offset0 = 42;
    const string tags0 = "tag";

    await _client.GetTopSearchesAsync(index0, clickAnalytics0, startDate0, endDate0, orderBy0, direction0, limit0, offset0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/searches", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"orderBy\":\"searchCount\",\"direction\":\"asc\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getUsersCount with minimal parameters")]
  public async Task GetUsersCountTest0()
  {
    const string index0 = "index";

    await _client.GetUsersCountAsync(index0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/users/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "get getUsersCount with all parameters")]
  public async Task GetUsersCountTest1()
  {
    const string index0 = "index";
    const string startDate0 = "1999-09-19";
    const string endDate0 = "2001-01-01";
    const string tags0 = "tag";

    await _client.GetUsersCountAsync(index0, startDate0, endDate0, tags0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/2/users/count", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
}

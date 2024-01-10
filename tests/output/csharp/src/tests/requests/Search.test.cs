using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;
using Xunit;
using Newtonsoft.Json;
using Quibble.Xunit;
using Action = Algolia.Search.Models.Search.Action;

public class SearchClientRequestTests
{
  private readonly SearchClient _client;
  private readonly EchoHttpRequester _echo;

  public SearchClientRequestTests()
  {
    _echo = new EchoHttpRequester();
    _client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
  }

  [Fact]
  public void Dispose()
  {

  }

  [Fact(DisplayName = "addApiKey0")]
  public async Task AddApiKeyTest0()
  {
    var apiKey0 = new ApiKey();
    {
      var acl1 = new List<Acl>();
      var acl_02 = (Acl)Enum.Parse(typeof(Acl), "Search");
      acl1.Add(acl_02); var acl_12 = (Acl)Enum.Parse(typeof(Acl), "AddObject");
      acl1.Add(acl_12);
      apiKey0.Acl = acl1; const string description1 = "my new api key";
      apiKey0.Description = description1; const int validity1 = 300;
      apiKey0.Validity = validity1; const int maxQueriesPerIPPerHour1 = 100;
      apiKey0.MaxQueriesPerIPPerHour = maxQueriesPerIPPerHour1; const int maxHitsPerQuery1 = 20;
      apiKey0.MaxHitsPerQuery = maxHitsPerQuery1;
    }

    await _client.AddApiKeyAsync(apiKey0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "addOrUpdateObject0")]
  public async Task AddOrUpdateObjectTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "uniqueID";
    var body0 = new Dictionary<string, string>();
    {
      const string key1 = "value";
      body0.Add("key", key1);
    }

    await _client.AddOrUpdateObjectAsync(indexName0, objectID0, body0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/uniqueID", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"key\":\"value\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "appendSource0")]
  public async Task AppendSourceTest0()
  {
    var source0 = new Source();
    {
      const string source1 = "theSource";
      source0.VarSource = source1; const string description1 = "theDescription";
      source0.Description = description1;
    }

    await _client.AppendSourceAsync(source0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/security/sources/append", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"source\":\"theSource\",\"description\":\"theDescription\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "assignUserId0")]
  public async Task AssignUserIdTest0()
  {
    const string xAlgoliaUserID0 = "userID";
    var assignUserIdParams0 = new AssignUserIdParams();
    {
      const string cluster1 = "theCluster";
      assignUserIdParams0.Cluster = cluster1;
    }

    await _client.AssignUserIdAsync(xAlgoliaUserID0, assignUserIdParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"cluster\":\"theCluster\"}", req.Body, new JsonDiffConfig(true));
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"x-algolia-user-id\":\"userID\"}");
    var actualHeaders = req.Headers;
    foreach (var expectedHeader in expectedHeaders)
    {
      string actualHeaderValue;
      actualHeaders.TryGetValue(expectedHeader.Key, out actualHeaderValue);
      Assert.Equal(expectedHeader.Value, actualHeaderValue);
    }
  }
  [Fact(DisplayName = "allows batch method with `addObject` action")]
  public async Task BatchTest0()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "AddObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `clear` action")]
  public async Task BatchTest1()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "Clear");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"clear\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `delete` action")]
  public async Task BatchTest2()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "Delete");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `deleteObject` action")]
  public async Task BatchTest3()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "DeleteObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"deleteObject\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `partialUpdateObject` action")]
  public async Task BatchTest4()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "PartialUpdateObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"partialUpdateObject\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `partialUpdateObjectNoCreate` action")]
  public async Task BatchTest5()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "PartialUpdateObjectNoCreate");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"partialUpdateObjectNoCreate\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "allows batch method with `updateObject` action")]
  public async Task BatchTest6()
  {
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "UpdateObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }

    await _client.BatchAsync(indexName0, batchWriteParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"updateObject\",\"body\":{\"key\":\"value\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "batchAssignUserIds0")]
  public async Task BatchAssignUserIdsTest0()
  {
    const string xAlgoliaUserID0 = "userID";
    var batchAssignUserIdsParams0 = new BatchAssignUserIdsParams();
    {
      const string cluster1 = "theCluster";
      batchAssignUserIdsParams0.Cluster = cluster1; var users1 = new List<string>();
      const string users_02 = "user1";
      users1.Add(users_02); const string users_12 = "user2";
      users1.Add(users_12);
      batchAssignUserIdsParams0.Users = users1;
    }

    await _client.BatchAssignUserIdsAsync(xAlgoliaUserID0, batchAssignUserIdsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}", req.Body, new JsonDiffConfig(true));
    var expectedHeaders = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"x-algolia-user-id\":\"userID\"}");
    var actualHeaders = req.Headers;
    foreach (var expectedHeader in expectedHeaders)
    {
      string actualHeaderValue;
      actualHeaders.TryGetValue(expectedHeader.Key, out actualHeaderValue);
      Assert.Equal(expectedHeader.Value, actualHeaderValue);
    }
  }
  [Fact(DisplayName = "get batchDictionaryEntries results with minimal parameters")]
  public async Task BatchDictionaryEntriesTest0()
  {
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      var requests1 = new List<BatchDictionaryEntriesRequest>();
      var requests_02 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "AddEntry");
        requests_02.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "1";
          body3.ObjectID = objectID4; const string language4 = "en";
          body3.Language = language4;
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02); var requests_12 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "DeleteEntry");
        requests_12.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "2";
          body3.ObjectID = objectID4; const string language4 = "fr";
          body3.Language = language4;
        }
        requests_12.Body = body3;
      }
      requests1.Add(requests_12);
      batchDictionaryEntriesParams0.Requests = requests1;
    }

    await _client.BatchDictionaryEntriesAsync(dictionaryName0, batchDictionaryEntriesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/compounds/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get batchDictionaryEntries results with all parameters")]
  public async Task BatchDictionaryEntriesTest1()
  {
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      const bool clearExistingDictionaryEntries1 = false;
      batchDictionaryEntriesParams0.ClearExistingDictionaryEntries = clearExistingDictionaryEntries1; var requests1 = new List<BatchDictionaryEntriesRequest>();
      var requests_02 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "AddEntry");
        requests_02.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "1";
          body3.ObjectID = objectID4; const string language4 = "en";
          body3.Language = language4; const string word4 = "fancy";
          body3.Word = word4; var words4 = new List<string>();
          const string words_05 = "believe";
          words4.Add(words_05); const string words_15 = "algolia";
          words4.Add(words_15);
          body3.Words = words4; var decomposition4 = new List<string>();
          const string decomposition_05 = "trust";
          decomposition4.Add(decomposition_05); const string decomposition_15 = "algolia";
          decomposition4.Add(decomposition_15);
          body3.Decomposition = decomposition4; var state4 = (DictionaryEntryState)Enum.Parse(typeof(DictionaryEntryState), "Enabled");
          body3.State = state4;
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02); var requests_12 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "DeleteEntry");
        requests_12.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "2";
          body3.ObjectID = objectID4; const string language4 = "fr";
          body3.Language = language4; const string word4 = "humility";
          body3.Word = word4; var words4 = new List<string>();
          const string words_05 = "candor";
          words4.Add(words_05); const string words_15 = "algolia";
          words4.Add(words_15);
          body3.Words = words4; var decomposition4 = new List<string>();
          const string decomposition_05 = "grit";
          decomposition4.Add(decomposition_05); const string decomposition_15 = "algolia";
          decomposition4.Add(decomposition_15);
          body3.Decomposition = decomposition4; var state4 = (DictionaryEntryState)Enum.Parse(typeof(DictionaryEntryState), "Enabled");
          body3.State = state4;
        }
        requests_12.Body = body3;
      }
      requests1.Add(requests_12);
      batchDictionaryEntriesParams0.Requests = requests1;
    }

    await _client.BatchDictionaryEntriesAsync(dictionaryName0, batchDictionaryEntriesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/compounds/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"fancy\",\"words\":[\"believe\",\"algolia\"],\"decomposition\":[\"trust\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"humility\",\"words\":[\"candor\",\"algolia\"],\"decomposition\":[\"grit\",\"algolia\"],\"state\":\"enabled\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get batchDictionaryEntries results additional properties")]
  public async Task BatchDictionaryEntriesTest2()
  {
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      var requests1 = new List<BatchDictionaryEntriesRequest>();
      var requests_02 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "AddEntry");
        requests_02.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "1";
          body3.ObjectID = objectID4; const string language4 = "en";
          body3.Language = language4; const string additional4 = "try me";
          body3.AdditionalProperties.Add("additional", additional4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchDictionaryEntriesParams0.Requests = requests1;
    }

    await _client.BatchDictionaryEntriesAsync(dictionaryName0, batchDictionaryEntriesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/compounds/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"additional\":\"try me\"}}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "browse with minimal parameters")]
  public async Task BrowseTest0()
  {
    const string indexName0 = "cts_e2e_browse";

    await _client.BrowseAsync<Object>(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/cts_e2e_browse/browse", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "browse with search parameters")]
  public async Task BrowseTest1()
  {
    const string indexName0 = "indexName";
    var browseParams0 = new BrowseParamsObject();
    {
      const string query1 = "myQuery";
      browseParams0.Query = query1; var facetFilters1 = new List<MixedSearchFilters>();
      const string facetFilters_02 = "tags:algolia";
      facetFilters1.Add(new MixedSearchFilters(facetFilters_02));
      browseParams0.FacetFilters = new FacetFilters(facetFilters1);
    }

    await _client.BrowseAsync<Object>(indexName0, new BrowseParams(browseParams0));

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/browse", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "browse allow a cursor in parameters")]
  public async Task BrowseTest2()
  {
    const string indexName0 = "indexName";
    var browseParams0 = new BrowseParamsObject();
    {
      const string cursor1 = "test";
      browseParams0.Cursor = cursor1;
    }

    await _client.BrowseAsync<Object>(indexName0, new BrowseParams(browseParams0));

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/browse", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"cursor\":\"test\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "clearAllSynonyms0")]
  public async Task ClearAllSynonymsTest0()
  {
    const string indexName0 = "indexName";

    await _client.ClearAllSynonymsAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/clear", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "clearObjects0")]
  public async Task ClearObjectsTest0()
  {
    const string indexName0 = "theIndexName";

    await _client.ClearObjectsAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/clear", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "clearRules0")]
  public async Task ClearRulesTest0()
  {
    const string indexName0 = "indexName";

    await _client.ClearRulesAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/clear", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
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
  [Fact(DisplayName = "deleteApiKey0")]
  public async Task DeleteApiKeyTest0()
  {
    const string key0 = "myTestApiKey";

    await _client.DeleteApiKeyAsync(key0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys/myTestApiKey", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteBy0")]
  public async Task DeleteByTest0()
  {
    const string indexName0 = "theIndexName";
    var deleteByParams0 = new DeleteByParams();
    {
      const string filters1 = "brand:brandName";
      deleteByParams0.Filters = filters1;
    }

    await _client.DeleteByAsync(indexName0, deleteByParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/deleteByQuery", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"filters\":\"brand:brandName\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "deleteIndex0")]
  public async Task DeleteIndexTest0()
  {
    const string indexName0 = "theIndexName";

    await _client.DeleteIndexAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteObject0")]
  public async Task DeleteObjectTest0()
  {
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";

    await _client.DeleteObjectAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/uniqueID", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "delete rule simple case")]
  public async Task DeleteRuleTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";

    await _client.DeleteRuleAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/id1", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "delete rule with simple characters to encode in objectID")]
  public async Task DeleteRuleTest1()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "test/with/slash";

    await _client.DeleteRuleAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/test%2Fwith%2Fslash", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteSource0")]
  public async Task DeleteSourceTest0()
  {
    const string source0 = "theSource";

    await _client.DeleteSourceAsync(source0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/security/sources/theSource", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "deleteSynonym0")]
  public async Task DeleteSynonymTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";

    await _client.DeleteSynonymAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/id1", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getApiKey0")]
  public async Task GetApiKeyTest0()
  {
    const string key0 = "myTestApiKey";

    await _client.GetApiKeyAsync(key0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys/myTestApiKey", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "get getDictionaryLanguages")]
  public async Task GetDictionaryLanguagesTest0()
  {

    await _client.GetDictionaryLanguagesAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/*/languages", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "get getDictionarySettings results")]
  public async Task GetDictionarySettingsTest0()
  {

    await _client.GetDictionarySettingsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/*/settings", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getLogs with minimal parameters")]
  public async Task GetLogsTest0()
  {

    await _client.GetLogsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/logs", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getLogs with parameters")]
  public async Task GetLogsTest1()
  {
    const int offset0 = 5;
    const int length0 = 10;
    const string indexName0 = "theIndexName";
    var type0 = (LogType)Enum.Parse(typeof(LogType), "All");

    await _client.GetLogsAsync(offset0, length0, indexName0, type0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/logs", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"offset\":\"5\",\"length\":\"10\",\"indexName\":\"theIndexName\",\"type\":\"all\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "getObject0")]
  public async Task GetObjectTest0()
  {
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";
    var attributesToRetrieve0 = new List<string>();
    const string attributesToRetrieve_01 = "attr1";
    attributesToRetrieve0.Add(attributesToRetrieve_01); const string attributesToRetrieve_11 = "attr2";
    attributesToRetrieve0.Add(attributesToRetrieve_11);

    await _client.GetObjectAsync(indexName0, objectID0, attributesToRetrieve0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/uniqueID", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"attributesToRetrieve\":\"attr1,attr2\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "getObjects0")]
  public async Task GetObjectsTest0()
  {
    var getObjectsParams0 = new GetObjectsParams();
    {
      var requests1 = new List<GetObjectsRequest>();
      var requests_02 = new GetObjectsRequest();
      {
        var attributesToRetrieve3 = new List<string>();
        const string attributesToRetrieve_04 = "attr1";
        attributesToRetrieve3.Add(attributesToRetrieve_04); const string attributesToRetrieve_14 = "attr2";
        attributesToRetrieve3.Add(attributesToRetrieve_14);
        requests_02.AttributesToRetrieve = attributesToRetrieve3; const string objectID3 = "uniqueID";
        requests_02.ObjectID = objectID3; const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(requests_02);
      getObjectsParams0.Requests = requests1;
    }

    await _client.GetObjectsAsync<Object>(getObjectsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/objects", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "getRule0")]
  public async Task GetRuleTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";

    await _client.GetRuleAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/id1", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getSettings0")]
  public async Task GetSettingsTest0()
  {
    const string indexName0 = "cts_e2e_settings";

    await _client.GetSettingsAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/cts_e2e_settings/settings", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getSources0")]
  public async Task GetSourcesTest0()
  {

    await _client.GetSourcesAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/security/sources", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getSynonym0")]
  public async Task GetSynonymTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";

    await _client.GetSynonymAsync(indexName0, objectID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/id1", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getTask0")]
  public async Task GetTaskTest0()
  {
    const string indexName0 = "theIndexName";
    const long taskID0 = 123L;

    await _client.GetTaskAsync(indexName0, taskID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/task/123", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getTopUserIds0")]
  public async Task GetTopUserIdsTest0()
  {

    await _client.GetTopUserIdsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/top", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "getUserId0")]
  public async Task GetUserIdTest0()
  {
    const string userID0 = "uniqueID";

    await _client.GetUserIdAsync(userID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/uniqueID", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "hasPendingMappings with minimal parameters")]
  public async Task HasPendingMappingsTest0()
  {

    await _client.HasPendingMappingsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/pending", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "hasPendingMappings with parameters")]
  public async Task HasPendingMappingsTest1()
  {
    const bool getClusters0 = true;

    await _client.HasPendingMappingsAsync(getClusters0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/pending", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"getClusters\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "listApiKeys0")]
  public async Task ListApiKeysTest0()
  {

    await _client.ListApiKeysAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "listClusters0")]
  public async Task ListClustersTest0()
  {

    await _client.ListClustersAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "listIndices with minimal parameters")]
  public async Task ListIndicesTest0()
  {

    await _client.ListIndicesAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "listIndices with parameters")]
  public async Task ListIndicesTest1()
  {
    const int page0 = 8;
    const int hitsPerPage0 = 3;

    await _client.ListIndicesAsync(page0, hitsPerPage0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"page\":\"8\",\"hitsPerPage\":\"3\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "listUserIds with minimal parameters")]
  public async Task ListUserIdsTest0()
  {

    await _client.ListUserIdsAsync();

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "listUserIds with parameters")]
  public async Task ListUserIdsTest1()
  {
    const int page0 = 8;
    const int hitsPerPage0 = 100;

    await _client.ListUserIdsAsync(page0, hitsPerPage0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping", req.Path);
    Assert.Equal("GET", req.Method.ToString());
    Assert.Null(req.Body);
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"page\":\"8\",\"hitsPerPage\":\"100\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "multipleBatch0")]
  public async Task MultipleBatchTest0()
  {
    var batchParams0 = new BatchParams();
    {
      var requests1 = new List<MultipleBatchRequest>();
      var requests_02 = new MultipleBatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "AddObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3; const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(requests_02);
      batchParams0.Requests = requests1;
    }

    await _client.MultipleBatchAsync(batchParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "operationIndex0")]
  public async Task OperationIndexTest0()
  {
    const string indexName0 = "theIndexName";
    var operationIndexParams0 = new OperationIndexParams();
    {
      var operation1 = (OperationType)Enum.Parse(typeof(OperationType), "Copy");
      operationIndexParams0.Operation = operation1; const string destination1 = "dest";
      operationIndexParams0.Destination = destination1; var scope1 = new List<ScopeType>();
      var scope_02 = (ScopeType)Enum.Parse(typeof(ScopeType), "Rules");
      scope1.Add(scope_02); var scope_12 = (ScopeType)Enum.Parse(typeof(ScopeType), "Settings");
      scope1.Add(scope_12);
      operationIndexParams0.Scope = scope1;
    }

    await _client.OperationIndexAsync(indexName0, operationIndexParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/operation", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "partialUpdateObject0")]
  public async Task PartialUpdateObjectTest0()
  {
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";
    var attributesToUpdate0 = new Dictionary<string, AttributeToUpdate>();
    {
      const string id11 = "test";
      attributesToUpdate0.Add("id1", new AttributeToUpdate(id11)); var id21 = new BuiltInOperation();
      {
        var _operation2 = (BuiltInOperationType)Enum.Parse(typeof(BuiltInOperationType), "AddUnique");
        id21.Operation = _operation2; const string value2 = "test2";
        id21.Value = value2;
      }
      attributesToUpdate0.Add("id2", new AttributeToUpdate(id21));
    }
    const bool createIfNotExists0 = true;

    await _client.PartialUpdateObjectAsync(indexName0, objectID0, attributesToUpdate0, createIfNotExists0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/uniqueID/partial", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"createIfNotExists\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "removeUserId0")]
  public async Task RemoveUserIdTest0()
  {
    const string userID0 = "uniqueID";

    await _client.RemoveUserIdAsync(userID0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/uniqueID", req.Path);
    Assert.Equal("DELETE", req.Method.ToString());
    Assert.Null(req.Body);
  }
  [Fact(DisplayName = "replaceSources0")]
  public async Task ReplaceSourcesTest0()
  {
    var source0 = new List<Source>();
    var source_01 = new Source();
    {
      const string source2 = "theSource";
      source_01.VarSource = source2; const string description2 = "theDescription";
      source_01.Description = description2;
    }
    source0.Add(source_01);

    await _client.ReplaceSourcesAsync(source0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/security/sources", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("[{\"source\":\"theSource\",\"description\":\"theDescription\"}]", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "restoreApiKey0")]
  public async Task RestoreApiKeyTest0()
  {
    const string key0 = "myApiKey";

    await _client.RestoreApiKeyAsync(key0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys/myApiKey/restore", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    Assert.Equal("{}", req.Body);
  }
  [Fact(DisplayName = "saveObject0")]
  public async Task SaveObjectTest0()
  {
    const string indexName0 = "theIndexName";
    var body0 = new Dictionary<string, string>();
    {
      const string objectID1 = "id";
      body0.Add("objectID", objectID1); const string test1 = "val";
      body0.Add("test", test1);
    }

    await _client.SaveObjectAsync(indexName0, body0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"objectID\":\"id\",\"test\":\"val\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "saveRule with minimal parameters")]
  public async Task SaveRuleTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";
    var rule0 = new Rule();
    {
      const string objectID1 = "id1";
      rule0.ObjectID = objectID1; var conditions1 = new List<Condition>();
      var conditions_02 = new Condition();
      {
        const string pattern3 = "apple";
        conditions_02.Pattern = pattern3; var anchoring3 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_02.Anchoring = anchoring3;
      }
      conditions1.Add(conditions_02);
      rule0.Conditions = conditions1;
    }

    await _client.SaveRuleAsync(indexName0, objectID0, rule0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/id1", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "saveRule with all parameters")]
  public async Task SaveRuleTest1()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";
    var rule0 = new Rule();
    {
      const string objectID1 = "id1";
      rule0.ObjectID = objectID1; var conditions1 = new List<Condition>();
      var conditions_02 = new Condition();
      {
        const string pattern3 = "apple";
        conditions_02.Pattern = pattern3; var anchoring3 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_02.Anchoring = anchoring3; const bool alternatives3 = false;
        conditions_02.Alternatives = alternatives3; const string context3 = "search";
        conditions_02.Context = context3;
      }
      conditions1.Add(conditions_02);
      rule0.Conditions = conditions1; var consequence1 = new Consequence();
      {
        var params2 = new ConsequenceParams();
        {
          const string filters3 = "brand:apple";
          params2.Filters = filters3; var query3 = new ConsequenceQueryObject();
          {
            var remove4 = new List<string>();
            const string remove_05 = "algolia";
            remove4.Add(remove_05);
            query3.Remove = remove4; var edits4 = new List<Edit>();
            var edits_05 = new Edit();
            {
              var type6 = (EditType)Enum.Parse(typeof(EditType), "Remove");
              edits_05.Type = type6; const string delete6 = "abc";
              edits_05.Delete = delete6; const string insert6 = "cde";
              edits_05.Insert = insert6;
            }
            edits4.Add(edits_05); var edits_15 = new Edit();
            {
              var type6 = (EditType)Enum.Parse(typeof(EditType), "Replace");
              edits_15.Type = type6; const string delete6 = "abc";
              edits_15.Delete = delete6; const string insert6 = "cde";
              edits_15.Insert = insert6;
            }
            edits4.Add(edits_15);
            query3.Edits = edits4;
          }
          params2.Query = new ConsequenceQuery(query3);
        }
        consequence1.VarParams = params2; var hide2 = new List<ConsequenceHide>();
        var hide_03 = new ConsequenceHide();
        {
          const string objectID4 = "321";
          hide_03.ObjectID = objectID4;
        }
        hide2.Add(hide_03);
        consequence1.Hide = hide2; const bool filterPromotes2 = false;
        consequence1.FilterPromotes = filterPromotes2; var userData2 = new Dictionary<string, string> { { "algolia", "aloglia" } };
        consequence1.UserData = userData2; var promote2 = new List<Promote>();
        var promote_03 = new PromoteObjectID();
        {
          const string objectID4 = "abc";
          promote_03.ObjectID = objectID4; const int position4 = 3;
          promote_03.Position = position4;
        }
        promote2.Add(new Promote(promote_03)); var promote_13 = new PromoteObjectIDs();
        {
          var objectIDs4 = new List<string>();
          const string objectIDs_05 = "abc";
          objectIDs4.Add(objectIDs_05); const string objectIDs_15 = "def";
          objectIDs4.Add(objectIDs_15);
          promote_13.ObjectIDs = objectIDs4; const int position4 = 1;
          promote_13.Position = position4;
        }
        promote2.Add(new Promote(promote_13));
        consequence1.Promote = promote2;
      }
      rule0.Consequence = consequence1; const string description1 = "test";
      rule0.Description = description1; const bool enabled1 = true;
      rule0.Enabled = enabled1; var validity1 = new List<TimeRange>();
      var validity_02 = new TimeRange();
      {
        const int from3 = 1656670273;
        validity_02.From = from3; const int until3 = 1656670277;
        validity_02.Until = until3;
      }
      validity1.Add(validity_02);
      rule0.Validity = validity1;
    }
    const bool forwardToReplicas0 = true;

    await _client.SaveRuleAsync(indexName0, objectID0, rule0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/id1", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "saveRules with minimal parameters")]
  public async Task SaveRulesTest0()
  {
    const string indexName0 = "indexName";
    var rules0 = new List<Rule>();
    var rules_01 = new Rule();
    {
      const string objectID2 = "a-rule-id";
      rules_01.ObjectID = objectID2; var conditions2 = new List<Condition>();
      var conditions_03 = new Condition();
      {
        const string pattern4 = "smartphone";
        conditions_03.Pattern = pattern4; var anchoring4 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_03.Anchoring = anchoring4;
      }
      conditions2.Add(conditions_03);
      rules_01.Conditions = conditions2;
    }
    rules0.Add(rules_01); var rules_11 = new Rule();
    {
      const string objectID2 = "a-second-rule-id";
      rules_11.ObjectID = objectID2; var conditions2 = new List<Condition>();
      var conditions_03 = new Condition();
      {
        const string pattern4 = "apple";
        conditions_03.Pattern = pattern4; var anchoring4 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_03.Anchoring = anchoring4;
      }
      conditions2.Add(conditions_03);
      rules_11.Conditions = conditions2;
    }
    rules0.Add(rules_11);

    await _client.SaveRulesAsync(indexName0, rules0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}]},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}]", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "saveRules with all parameters")]
  public async Task SaveRulesTest1()
  {
    const string indexName0 = "indexName";
    var rules0 = new List<Rule>();
    var rules_01 = new Rule();
    {
      const string objectID2 = "id1";
      rules_01.ObjectID = objectID2; var conditions2 = new List<Condition>();
      var conditions_03 = new Condition();
      {
        const string pattern4 = "apple";
        conditions_03.Pattern = pattern4; var anchoring4 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_03.Anchoring = anchoring4; const bool alternatives4 = false;
        conditions_03.Alternatives = alternatives4; const string context4 = "search";
        conditions_03.Context = context4;
      }
      conditions2.Add(conditions_03);
      rules_01.Conditions = conditions2; var consequence2 = new Consequence();
      {
        var params3 = new ConsequenceParams();
        {
          const string filters4 = "brand:apple";
          params3.Filters = filters4; var query4 = new ConsequenceQueryObject();
          {
            var remove5 = new List<string>();
            const string remove_06 = "algolia";
            remove5.Add(remove_06);
            query4.Remove = remove5; var edits5 = new List<Edit>();
            var edits_06 = new Edit();
            {
              var type7 = (EditType)Enum.Parse(typeof(EditType), "Remove");
              edits_06.Type = type7; const string delete7 = "abc";
              edits_06.Delete = delete7; const string insert7 = "cde";
              edits_06.Insert = insert7;
            }
            edits5.Add(edits_06); var edits_16 = new Edit();
            {
              var type7 = (EditType)Enum.Parse(typeof(EditType), "Replace");
              edits_16.Type = type7; const string delete7 = "abc";
              edits_16.Delete = delete7; const string insert7 = "cde";
              edits_16.Insert = insert7;
            }
            edits5.Add(edits_16);
            query4.Edits = edits5;
          }
          params3.Query = new ConsequenceQuery(query4);
        }
        consequence2.VarParams = params3; var hide3 = new List<ConsequenceHide>();
        var hide_04 = new ConsequenceHide();
        {
          const string objectID5 = "321";
          hide_04.ObjectID = objectID5;
        }
        hide3.Add(hide_04);
        consequence2.Hide = hide3; const bool filterPromotes3 = false;
        consequence2.FilterPromotes = filterPromotes3; var userData3 = new Dictionary<string, string> { { "algolia", "aloglia" } };
        consequence2.UserData = userData3; var promote3 = new List<Promote>();
        var promote_04 = new PromoteObjectID();
        {
          const string objectID5 = "abc";
          promote_04.ObjectID = objectID5; const int position5 = 3;
          promote_04.Position = position5;
        }
        promote3.Add(new Promote(promote_04)); var promote_14 = new PromoteObjectIDs();
        {
          var objectIDs5 = new List<string>();
          const string objectIDs_06 = "abc";
          objectIDs5.Add(objectIDs_06); const string objectIDs_16 = "def";
          objectIDs5.Add(objectIDs_16);
          promote_14.ObjectIDs = objectIDs5; const int position5 = 1;
          promote_14.Position = position5;
        }
        promote3.Add(new Promote(promote_14));
        consequence2.Promote = promote3;
      }
      rules_01.Consequence = consequence2; const string description2 = "test";
      rules_01.Description = description2; const bool enabled2 = true;
      rules_01.Enabled = enabled2; var validity2 = new List<TimeRange>();
      var validity_03 = new TimeRange();
      {
        const int from4 = 1656670273;
        validity_03.From = from4; const int until4 = 1656670277;
        validity_03.Until = until4;
      }
      validity2.Add(validity_03);
      rules_01.Validity = validity2;
    }
    rules0.Add(rules_01);
    const bool forwardToReplicas0 = true;
    const bool clearExistingRules0 = true;

    await _client.SaveRulesAsync(indexName0, rules0, forwardToReplicas0, clearExistingRules0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("[{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}]", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\",\"clearExistingRules\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "saveSynonym0")]
  public async Task SaveSynonymTest0()
  {
    const string indexName0 = "indexName";
    const string objectID0 = "id1";
    var synonymHit0 = new SynonymHit();
    {
      const string objectID1 = "id1";
      synonymHit0.ObjectID = objectID1; var type1 = (SynonymType)Enum.Parse(typeof(SynonymType), "Synonym");
      synonymHit0.Type = type1; var synonyms1 = new List<string>();
      const string synonyms_02 = "car";
      synonyms1.Add(synonyms_02); const string synonyms_12 = "vehicule";
      synonyms1.Add(synonyms_12); const string synonyms_22 = "auto";
      synonyms1.Add(synonyms_22);
      synonymHit0.Synonyms = synonyms1;
    }
    const bool forwardToReplicas0 = true;

    await _client.SaveSynonymAsync(indexName0, objectID0, synonymHit0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/id1", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "saveSynonyms0")]
  public async Task SaveSynonymsTest0()
  {
    const string indexName0 = "indexName";
    var synonymHit0 = new List<SynonymHit>();
    var synonymHit_01 = new SynonymHit();
    {
      const string objectID2 = "id1";
      synonymHit_01.ObjectID = objectID2; var type2 = (SynonymType)Enum.Parse(typeof(SynonymType), "Synonym");
      synonymHit_01.Type = type2; var synonyms2 = new List<string>();
      const string synonyms_03 = "car";
      synonyms2.Add(synonyms_03); const string synonyms_13 = "vehicule";
      synonyms2.Add(synonyms_13); const string synonyms_23 = "auto";
      synonyms2.Add(synonyms_23);
      synonymHit_01.Synonyms = synonyms2;
    }
    synonymHit0.Add(synonymHit_01); var synonymHit_11 = new SynonymHit();
    {
      const string objectID2 = "id2";
      synonymHit_11.ObjectID = objectID2; var type2 = (SynonymType)Enum.Parse(typeof(SynonymType), "Onewaysynonym");
      synonymHit_11.Type = type2; const string input2 = "iphone";
      synonymHit_11.Input = input2; var synonyms2 = new List<string>();
      const string synonyms_03 = "ephone";
      synonyms2.Add(synonyms_03); const string synonyms_13 = "aphone";
      synonyms2.Add(synonyms_13); const string synonyms_23 = "yphone";
      synonyms2.Add(synonyms_23);
      synonymHit_11.Synonyms = synonyms2;
    }
    synonymHit0.Add(synonymHit_11);
    const bool forwardToReplicas0 = true;
    const bool replaceExistingSynonyms0 = false;

    await _client.SaveSynonymsAsync(indexName0, synonymHit0, forwardToReplicas0, replaceExistingSynonyms0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/batch", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"false\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "search for a single hits request with minimal parameters")]
  public async Task SearchTest0()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const string indexName3 = "cts_e2e_search_empty_index";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"cts_e2e_search_empty_index\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search for a single facet request with minimal parameters")]
  public async Task SearchTest1()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForFacets();
      {
        const string indexName3 = "cts_e2e_search_facet";
        requests_02.IndexName = indexName3; var type3 = (SearchTypeFacet)Enum.Parse(typeof(SearchTypeFacet), "Facet");
        requests_02.Type = type3; const string facet3 = "editor";
        requests_02.Facet = facet3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1; var strategy1 = (SearchStrategy)Enum.Parse(typeof(SearchStrategy), "StopIfEnoughMatches");
      searchMethodParams0.Strategy = strategy1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"cts_e2e_search_facet\",\"type\":\"facet\",\"facet\":\"editor\"}],\"strategy\":\"stopIfEnoughMatches\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search for a single hits request with all parameters")]
  public async Task SearchTest2()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3; const string query3 = "myQuery";
        requests_02.Query = query3; const int hitsPerPage3 = 50;
        requests_02.HitsPerPage = hitsPerPage3; var type3 = (SearchTypeDefault)Enum.Parse(typeof(SearchTypeDefault), "Default");
        requests_02.Type = type3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search for a single facet request with all parameters")]
  public async Task SearchTest3()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForFacets();
      {
        const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3; var type3 = (SearchTypeFacet)Enum.Parse(typeof(SearchTypeFacet), "Facet");
        requests_02.Type = type3; const string facet3 = "theFacet";
        requests_02.Facet = facet3; const string facetQuery3 = "theFacetQuery";
        requests_02.FacetQuery = facetQuery3; const string query3 = "theQuery";
        requests_02.Query = query3; const int maxFacetHits3 = 50;
        requests_02.MaxFacetHits = maxFacetHits3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1; var strategy1 = (SearchStrategy)Enum.Parse(typeof(SearchStrategy), "StopIfEnoughMatches");
      searchMethodParams0.Strategy = strategy1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50}],\"strategy\":\"stopIfEnoughMatches\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search for multiple mixed requests in multiple indices with minimal parameters")]
  public async Task SearchTest4()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(new SearchQuery(requests_02)); var requests_12 = new SearchForFacets();
      {
        const string indexName3 = "theIndexName2";
        requests_12.IndexName = indexName3; var type3 = (SearchTypeFacet)Enum.Parse(typeof(SearchTypeFacet), "Facet");
        requests_12.Type = type3; const string facet3 = "theFacet";
        requests_12.Facet = facet3;
      }
      requests1.Add(new SearchQuery(requests_12)); var requests_22 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_22.IndexName = indexName3; var type3 = (SearchTypeDefault)Enum.Parse(typeof(SearchTypeDefault), "Default");
        requests_22.Type = type3;
      }
      requests1.Add(new SearchQuery(requests_22));
      searchMethodParams0.Requests = requests1; var strategy1 = (SearchStrategy)Enum.Parse(typeof(SearchStrategy), "StopIfEnoughMatches");
      searchMethodParams0.Strategy = strategy1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"theIndexName\"},{\"indexName\":\"theIndexName2\",\"type\":\"facet\",\"facet\":\"theFacet\"},{\"indexName\":\"theIndexName\",\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search for multiple mixed requests in multiple indices with all parameters")]
  public async Task SearchTest5()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForFacets();
      {
        const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3; var type3 = (SearchTypeFacet)Enum.Parse(typeof(SearchTypeFacet), "Facet");
        requests_02.Type = type3; const string facet3 = "theFacet";
        requests_02.Facet = facet3; const string facetQuery3 = "theFacetQuery";
        requests_02.FacetQuery = facetQuery3; const string query3 = "theQuery";
        requests_02.Query = query3; const int maxFacetHits3 = 50;
        requests_02.MaxFacetHits = maxFacetHits3;
      }
      requests1.Add(new SearchQuery(requests_02)); var requests_12 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_12.IndexName = indexName3; const string query3 = "myQuery";
        requests_12.Query = query3; const int hitsPerPage3 = 50;
        requests_12.HitsPerPage = hitsPerPage3; var type3 = (SearchTypeDefault)Enum.Parse(typeof(SearchTypeDefault), "Default");
        requests_12.Type = type3;
      }
      requests1.Add(new SearchQuery(requests_12));
      searchMethodParams0.Requests = requests1; var strategy1 = (SearchStrategy)Enum.Parse(typeof(SearchStrategy), "StopIfEnoughMatches");
      searchMethodParams0.Strategy = strategy1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50},{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search filters accept all of the possible shapes")]
  public async Task SearchTest6()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3; const string facetFilters3 = "mySearch:filters";
        requests_02.FacetFilters = new FacetFilters(facetFilters3); const string reRankingApplyFilter3 = "mySearch:filters";
        requests_02.ReRankingApplyFilter = new ReRankingApplyFilter(reRankingApplyFilter3); const string tagFilters3 = "mySearch:filters";
        requests_02.TagFilters = new TagFilters(tagFilters3); const string numericFilters3 = "mySearch:filters";
        requests_02.NumericFilters = new NumericFilters(numericFilters3); const string optionalFilters3 = "mySearch:filters";
        requests_02.OptionalFilters = new OptionalFilters(optionalFilters3);
      }
      requests1.Add(new SearchQuery(requests_02)); var requests_12 = new SearchForHits();
      {
        const string indexName3 = "theIndexName";
        requests_12.IndexName = indexName3; var facetFilters3 = new List<MixedSearchFilters>();
        const string facetFilters_04 = "mySearch:filters";
        facetFilters3.Add(new MixedSearchFilters(facetFilters_04)); var facetFilters_14 = new List<string>();
        const string facetFilters_1_05 = "mySearch:filters";
        facetFilters_14.Add(facetFilters_1_05);
        facetFilters3.Add(new MixedSearchFilters(facetFilters_14));
        requests_12.FacetFilters = new FacetFilters(facetFilters3); var reRankingApplyFilter3 = new List<MixedSearchFilters>();
        const string reRankingApplyFilter_04 = "mySearch:filters";
        reRankingApplyFilter3.Add(new MixedSearchFilters(reRankingApplyFilter_04)); var reRankingApplyFilter_14 = new List<string>();
        const string reRankingApplyFilter_1_05 = "mySearch:filters";
        reRankingApplyFilter_14.Add(reRankingApplyFilter_1_05);
        reRankingApplyFilter3.Add(new MixedSearchFilters(reRankingApplyFilter_14));
        requests_12.ReRankingApplyFilter = new ReRankingApplyFilter(reRankingApplyFilter3); var tagFilters3 = new List<MixedSearchFilters>();
        const string tagFilters_04 = "mySearch:filters";
        tagFilters3.Add(new MixedSearchFilters(tagFilters_04)); var tagFilters_14 = new List<string>();
        const string tagFilters_1_05 = "mySearch:filters";
        tagFilters_14.Add(tagFilters_1_05);
        tagFilters3.Add(new MixedSearchFilters(tagFilters_14));
        requests_12.TagFilters = new TagFilters(tagFilters3); var numericFilters3 = new List<MixedSearchFilters>();
        const string numericFilters_04 = "mySearch:filters";
        numericFilters3.Add(new MixedSearchFilters(numericFilters_04)); var numericFilters_14 = new List<string>();
        const string numericFilters_1_05 = "mySearch:filters";
        numericFilters_14.Add(numericFilters_1_05);
        numericFilters3.Add(new MixedSearchFilters(numericFilters_14));
        requests_12.NumericFilters = new NumericFilters(numericFilters3); var optionalFilters3 = new List<MixedSearchFilters>();
        const string optionalFilters_04 = "mySearch:filters";
        optionalFilters3.Add(new MixedSearchFilters(optionalFilters_04)); var optionalFilters_14 = new List<string>();
        const string optionalFilters_1_05 = "mySearch:filters";
        optionalFilters_14.Add(optionalFilters_1_05);
        optionalFilters3.Add(new MixedSearchFilters(optionalFilters_14));
        requests_12.OptionalFilters = new OptionalFilters(optionalFilters3);
      }
      requests1.Add(new SearchQuery(requests_12));
      searchMethodParams0.Requests = requests1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"indexName\":\"theIndexName\",\"facetFilters\":\"mySearch:filters\",\"reRankingApplyFilter\":\"mySearch:filters\",\"tagFilters\":\"mySearch:filters\",\"numericFilters\":\"mySearch:filters\",\"optionalFilters\":\"mySearch:filters\"},{\"indexName\":\"theIndexName\",\"facetFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"reRankingApplyFilter\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"tagFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"numericFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"optionalFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]]}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search with all search parameters")]
  public async Task SearchTest7()
  {
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const bool advancedSyntax3 = true;
        requests_02.AdvancedSyntax = advancedSyntax3; var advancedSyntaxFeatures3 = new List<AdvancedSyntaxFeatures>();
        var advancedSyntaxFeatures_04 = (AdvancedSyntaxFeatures)Enum.Parse(typeof(AdvancedSyntaxFeatures), "ExactPhrase");
        advancedSyntaxFeatures3.Add(advancedSyntaxFeatures_04);
        requests_02.AdvancedSyntaxFeatures = advancedSyntaxFeatures3; const bool allowTyposOnNumericTokens3 = true;
        requests_02.AllowTyposOnNumericTokens = allowTyposOnNumericTokens3; var alternativesAsExact3 = new List<AlternativesAsExact>();
        var alternativesAsExact_04 = (AlternativesAsExact)Enum.Parse(typeof(AlternativesAsExact), "MultiWordsSynonym");
        alternativesAsExact3.Add(alternativesAsExact_04);
        requests_02.AlternativesAsExact = alternativesAsExact3; const bool analytics3 = true;
        requests_02.Analytics = analytics3; var analyticsTags3 = new List<string>();
        const string analyticsTags_04 = "";
        analyticsTags3.Add(analyticsTags_04);
        requests_02.AnalyticsTags = analyticsTags3; const string aroundLatLng3 = "";
        requests_02.AroundLatLng = aroundLatLng3; const bool aroundLatLngViaIP3 = true;
        requests_02.AroundLatLngViaIP = aroundLatLngViaIP3; const int aroundPrecision3 = 0;
        requests_02.AroundPrecision = new AroundPrecision(aroundPrecision3); var aroundRadius3 = (AroundRadiusAll)Enum.Parse(typeof(AroundRadiusAll), "All");
        requests_02.AroundRadius = new AroundRadius(aroundRadius3); const bool attributeCriteriaComputedByMinProximity3 = true;
        requests_02.AttributeCriteriaComputedByMinProximity = attributeCriteriaComputedByMinProximity3; var attributesForFaceting3 = new List<string>();
        const string attributesForFaceting_04 = "";
        attributesForFaceting3.Add(attributesForFaceting_04);
        requests_02.AttributesForFaceting = attributesForFaceting3; var attributesToHighlight3 = new List<string>();
        const string attributesToHighlight_04 = "";
        attributesToHighlight3.Add(attributesToHighlight_04);
        requests_02.AttributesToHighlight = attributesToHighlight3; var attributesToRetrieve3 = new List<string>();
        const string attributesToRetrieve_04 = "";
        attributesToRetrieve3.Add(attributesToRetrieve_04);
        requests_02.AttributesToRetrieve = attributesToRetrieve3; var attributesToSnippet3 = new List<string>();
        const string attributesToSnippet_04 = "";
        attributesToSnippet3.Add(attributesToSnippet_04);
        requests_02.AttributesToSnippet = attributesToSnippet3; const bool clickAnalytics3 = true;
        requests_02.ClickAnalytics = clickAnalytics3; var customRanking3 = new List<string>();
        const string customRanking_04 = "";
        customRanking3.Add(customRanking_04);
        requests_02.CustomRanking = customRanking3; const bool decompoundQuery3 = true;
        requests_02.DecompoundQuery = decompoundQuery3; var disableExactOnAttributes3 = new List<string>();
        const string disableExactOnAttributes_04 = "";
        disableExactOnAttributes3.Add(disableExactOnAttributes_04);
        requests_02.DisableExactOnAttributes = disableExactOnAttributes3; var disableTypoToleranceOnAttributes3 = new List<string>();
        const string disableTypoToleranceOnAttributes_04 = "";
        disableTypoToleranceOnAttributes3.Add(disableTypoToleranceOnAttributes_04);
        requests_02.DisableTypoToleranceOnAttributes = disableTypoToleranceOnAttributes3; const int distinct3 = 0;
        requests_02.Distinct = new Distinct(distinct3); const bool enableABTest3 = true;
        requests_02.EnableABTest = enableABTest3; const bool enablePersonalization3 = true;
        requests_02.EnablePersonalization = enablePersonalization3; const bool enableReRanking3 = true;
        requests_02.EnableReRanking = enableReRanking3; const bool enableRules3 = true;
        requests_02.EnableRules = enableRules3; var exactOnSingleWordQuery3 = (ExactOnSingleWordQuery)Enum.Parse(typeof(ExactOnSingleWordQuery), "Attribute");
        requests_02.ExactOnSingleWordQuery = exactOnSingleWordQuery3; var explain3 = new List<string>();
        const string explain_04 = "foo";
        explain3.Add(explain_04); const string explain_14 = "bar";
        explain3.Add(explain_14);
        requests_02.Explain = explain3; var facetFilters3 = new List<MixedSearchFilters>();
        const string facetFilters_04 = "";
        facetFilters3.Add(new MixedSearchFilters(facetFilters_04));
        requests_02.FacetFilters = new FacetFilters(facetFilters3); const bool facetingAfterDistinct3 = true;
        requests_02.FacetingAfterDistinct = facetingAfterDistinct3; var facets3 = new List<string>();
        const string facets_04 = "";
        facets3.Add(facets_04);
        requests_02.Facets = facets3; const string filters3 = "";
        requests_02.Filters = filters3; const bool getRankingInfo3 = true;
        requests_02.GetRankingInfo = getRankingInfo3; const string highlightPostTag3 = "";
        requests_02.HighlightPostTag = highlightPostTag3; const string highlightPreTag3 = "";
        requests_02.HighlightPreTag = highlightPreTag3; const int hitsPerPage3 = 1;
        requests_02.HitsPerPage = hitsPerPage3; const bool ignorePlurals3 = false;
        requests_02.IgnorePlurals = new IgnorePlurals(ignorePlurals3); const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3; var insideBoundingBox3 = new List<List<Double>>();
        var insideBoundingBox_04 = new List<Double>();
        const double insideBoundingBox_0_05 = 47.3165;
        insideBoundingBox_04.Add(insideBoundingBox_0_05); const double insideBoundingBox_0_15 = 4.9665;
        insideBoundingBox_04.Add(insideBoundingBox_0_15); const double insideBoundingBox_0_25 = 47.3424;
        insideBoundingBox_04.Add(insideBoundingBox_0_25); const double insideBoundingBox_0_35 = 5.0201;
        insideBoundingBox_04.Add(insideBoundingBox_0_35);
        insideBoundingBox3.Add(insideBoundingBox_04); var insideBoundingBox_14 = new List<Double>();
        const double insideBoundingBox_1_05 = 40.9234;
        insideBoundingBox_14.Add(insideBoundingBox_1_05); const double insideBoundingBox_1_15 = 2.1185;
        insideBoundingBox_14.Add(insideBoundingBox_1_15); const double insideBoundingBox_1_25 = 38.643;
        insideBoundingBox_14.Add(insideBoundingBox_1_25); const double insideBoundingBox_1_35 = 1.9916;
        insideBoundingBox_14.Add(insideBoundingBox_1_35);
        insideBoundingBox3.Add(insideBoundingBox_14);
        requests_02.InsideBoundingBox = insideBoundingBox3; var insidePolygon3 = new List<List<Double>>();
        var insidePolygon_04 = new List<Double>();
        const double insidePolygon_0_05 = 47.3165;
        insidePolygon_04.Add(insidePolygon_0_05); const double insidePolygon_0_15 = 4.9665;
        insidePolygon_04.Add(insidePolygon_0_15); const double insidePolygon_0_25 = 47.3424;
        insidePolygon_04.Add(insidePolygon_0_25); const double insidePolygon_0_35 = 5.0201;
        insidePolygon_04.Add(insidePolygon_0_35); const double insidePolygon_0_45 = 47.32;
        insidePolygon_04.Add(insidePolygon_0_45); const double insidePolygon_0_55 = 4.9;
        insidePolygon_04.Add(insidePolygon_0_55);
        insidePolygon3.Add(insidePolygon_04); var insidePolygon_14 = new List<Double>();
        const double insidePolygon_1_05 = 40.9234;
        insidePolygon_14.Add(insidePolygon_1_05); const double insidePolygon_1_15 = 2.1185;
        insidePolygon_14.Add(insidePolygon_1_15); const double insidePolygon_1_25 = 38.643;
        insidePolygon_14.Add(insidePolygon_1_25); const double insidePolygon_1_35 = 1.9916;
        insidePolygon_14.Add(insidePolygon_1_35); const double insidePolygon_1_45 = 39.2587;
        insidePolygon_14.Add(insidePolygon_1_45); const double insidePolygon_1_55 = 2.0104;
        insidePolygon_14.Add(insidePolygon_1_55);
        insidePolygon3.Add(insidePolygon_14);
        requests_02.InsidePolygon = insidePolygon3; const string keepDiacriticsOnCharacters3 = "";
        requests_02.KeepDiacriticsOnCharacters = keepDiacriticsOnCharacters3; const int length3 = 1;
        requests_02.Length = length3; const int maxValuesPerFacet3 = 0;
        requests_02.MaxValuesPerFacet = maxValuesPerFacet3; const int minProximity3 = 1;
        requests_02.MinProximity = minProximity3; const int minWordSizefor1Typo3 = 0;
        requests_02.MinWordSizefor1Typo = minWordSizefor1Typo3; const int minWordSizefor2Typos3 = 0;
        requests_02.MinWordSizefor2Typos = minWordSizefor2Typos3; const int minimumAroundRadius3 = 1;
        requests_02.MinimumAroundRadius = minimumAroundRadius3; var naturalLanguages3 = new List<string>();
        const string naturalLanguages_04 = "";
        naturalLanguages3.Add(naturalLanguages_04);
        requests_02.NaturalLanguages = naturalLanguages3; var numericFilters3 = new List<MixedSearchFilters>();
        const string numericFilters_04 = "";
        numericFilters3.Add(new MixedSearchFilters(numericFilters_04));
        requests_02.NumericFilters = new NumericFilters(numericFilters3); const int offset3 = 0;
        requests_02.Offset = offset3; var optionalFilters3 = new List<MixedSearchFilters>();
        const string optionalFilters_04 = "";
        optionalFilters3.Add(new MixedSearchFilters(optionalFilters_04));
        requests_02.OptionalFilters = new OptionalFilters(optionalFilters3); var optionalWords3 = new List<string>();
        const string optionalWords_04 = "";
        optionalWords3.Add(optionalWords_04);
        requests_02.OptionalWords = optionalWords3; const int page3 = 0;
        requests_02.Page = page3; const bool percentileComputation3 = true;
        requests_02.PercentileComputation = percentileComputation3; const int personalizationImpact3 = 0;
        requests_02.PersonalizationImpact = personalizationImpact3; const string query3 = "";
        requests_02.Query = query3; var queryLanguages3 = new List<string>();
        const string queryLanguages_04 = "";
        queryLanguages3.Add(queryLanguages_04);
        requests_02.QueryLanguages = queryLanguages3; var queryType3 = (QueryType)Enum.Parse(typeof(QueryType), "PrefixAll");
        requests_02.QueryType = queryType3; var ranking3 = new List<string>();
        const string ranking_04 = "";
        ranking3.Add(ranking_04);
        requests_02.Ranking = ranking3; var reRankingApplyFilter3 = new List<MixedSearchFilters>();
        const string reRankingApplyFilter_04 = "";
        reRankingApplyFilter3.Add(new MixedSearchFilters(reRankingApplyFilter_04));
        requests_02.ReRankingApplyFilter = new ReRankingApplyFilter(reRankingApplyFilter3); const int relevancyStrictness3 = 0;
        requests_02.RelevancyStrictness = relevancyStrictness3; const bool removeStopWords3 = true;
        requests_02.RemoveStopWords = new RemoveStopWords(removeStopWords3); var removeWordsIfNoResults3 = (RemoveWordsIfNoResults)Enum.Parse(typeof(RemoveWordsIfNoResults), "AllOptional");
        requests_02.RemoveWordsIfNoResults = removeWordsIfNoResults3; var renderingContent3 = new RenderingContent();
        {
          var facetOrdering4 = new FacetOrdering();
          {
            var facets5 = new Facets();
            {
              var order6 = new List<string>();
              const string order_07 = "a";
              order6.Add(order_07); const string order_17 = "b";
              order6.Add(order_17);
              facets5.Order = order6;
            }
            facetOrdering4.Facets = facets5; var values5 = new Dictionary<string, Value>();
            {
              var a6 = new Value();
              {
                var order7 = new List<string>();
                const string order_08 = "b";
                order7.Add(order_08);
                a6.Order = order7; var sortRemainingBy7 = (SortRemainingBy)Enum.Parse(typeof(SortRemainingBy), "Count");
                a6.SortRemainingBy = sortRemainingBy7;
              }
              values5.Add("a", a6);
            }
            facetOrdering4.Values = values5;
          }
          renderingContent3.FacetOrdering = facetOrdering4;
        }
        requests_02.RenderingContent = renderingContent3; const bool replaceSynonymsInHighlight3 = true;
        requests_02.ReplaceSynonymsInHighlight = replaceSynonymsInHighlight3; var responseFields3 = new List<string>();
        const string responseFields_04 = "";
        responseFields3.Add(responseFields_04);
        requests_02.ResponseFields = responseFields3; const bool restrictHighlightAndSnippetArrays3 = true;
        requests_02.RestrictHighlightAndSnippetArrays = restrictHighlightAndSnippetArrays3; var restrictSearchableAttributes3 = new List<string>();
        const string restrictSearchableAttributes_04 = "";
        restrictSearchableAttributes3.Add(restrictSearchableAttributes_04);
        requests_02.RestrictSearchableAttributes = restrictSearchableAttributes3; var ruleContexts3 = new List<string>();
        const string ruleContexts_04 = "";
        ruleContexts3.Add(ruleContexts_04);
        requests_02.RuleContexts = ruleContexts3; const string similarQuery3 = "";
        requests_02.SimilarQuery = similarQuery3; const string snippetEllipsisText3 = "";
        requests_02.SnippetEllipsisText = snippetEllipsisText3; const string sortFacetValuesBy3 = "";
        requests_02.SortFacetValuesBy = sortFacetValuesBy3; const bool sumOrFiltersScores3 = true;
        requests_02.SumOrFiltersScores = sumOrFiltersScores3; const bool synonyms3 = true;
        requests_02.Synonyms = synonyms3; var tagFilters3 = new List<MixedSearchFilters>();
        const string tagFilters_04 = "";
        tagFilters3.Add(new MixedSearchFilters(tagFilters_04));
        requests_02.TagFilters = new TagFilters(tagFilters3); var type3 = (SearchTypeDefault)Enum.Parse(typeof(SearchTypeDefault), "Default");
        requests_02.Type = type3; var typoTolerance3 = (TypoToleranceEnum)Enum.Parse(typeof(TypoToleranceEnum), "Min");
        requests_02.TypoTolerance = new TypoTolerance(typoTolerance3); const string userToken3 = "";
        requests_02.UserToken = userToken3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1;
    }

    await _client.SearchAsync<Object>(searchMethodParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/*/queries", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"requests\":[{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"multiWordsSynonym\"],\"analytics\":true,\"analyticsTags\":[\"\"],\"aroundLatLng\":\"\",\"aroundLatLngViaIP\":true,\"aroundPrecision\":0,\"aroundRadius\":\"all\",\"attributeCriteriaComputedByMinProximity\":true,\"attributesForFaceting\":[\"\"],\"attributesToHighlight\":[\"\"],\"attributesToRetrieve\":[\"\"],\"attributesToSnippet\":[\"\"],\"clickAnalytics\":true,\"customRanking\":[\"\"],\"decompoundQuery\":true,\"disableExactOnAttributes\":[\"\"],\"disableTypoToleranceOnAttributes\":[\"\"],\"distinct\":0,\"enableABTest\":true,\"enablePersonalization\":true,\"enableReRanking\":true,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"explain\":[\"foo\",\"bar\"],\"facetFilters\":[\"\"],\"facetingAfterDistinct\":true,\"facets\":[\"\"],\"filters\":\"\",\"getRankingInfo\":true,\"highlightPostTag\":\"\",\"highlightPreTag\":\"\",\"hitsPerPage\":1,\"ignorePlurals\":false,\"indexName\":\"theIndexName\",\"insideBoundingBox\":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],\"insidePolygon\":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],\"keepDiacriticsOnCharacters\":\"\",\"length\":1,\"maxValuesPerFacet\":0,\"minProximity\":1,\"minWordSizefor1Typo\":0,\"minWordSizefor2Typos\":0,\"minimumAroundRadius\":1,\"naturalLanguages\":[\"\"],\"numericFilters\":[\"\"],\"offset\":0,\"optionalFilters\":[\"\"],\"optionalWords\":[\"\"],\"page\":0,\"percentileComputation\":true,\"personalizationImpact\":0,\"query\":\"\",\"queryLanguages\":[\"\"],\"queryType\":\"prefixAll\",\"ranking\":[\"\"],\"reRankingApplyFilter\":[\"\"],\"relevancyStrictness\":0,\"removeStopWords\":true,\"removeWordsIfNoResults\":\"allOptional\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"responseFields\":[\"\"],\"restrictHighlightAndSnippetArrays\":true,\"restrictSearchableAttributes\":[\"\"],\"ruleContexts\":[\"\"],\"similarQuery\":\"\",\"snippetEllipsisText\":\"\",\"sortFacetValuesBy\":\"\",\"sumOrFiltersScores\":true,\"synonyms\":true,\"tagFilters\":[\"\"],\"type\":\"default\",\"typoTolerance\":\"min\",\"userToken\":\"\"}]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get searchDictionaryEntries results with minimal parameters")]
  public async Task SearchDictionaryEntriesTest0()
  {
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var searchDictionaryEntriesParams0 = new SearchDictionaryEntriesParams();
    {
      const string query1 = "foo";
      searchDictionaryEntriesParams0.Query = query1;
    }

    await _client.SearchDictionaryEntriesAsync(dictionaryName0, searchDictionaryEntriesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/compounds/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"foo\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get searchDictionaryEntries results with all parameters")]
  public async Task SearchDictionaryEntriesTest1()
  {
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var searchDictionaryEntriesParams0 = new SearchDictionaryEntriesParams();
    {
      const string query1 = "foo";
      searchDictionaryEntriesParams0.Query = query1; const int page1 = 4;
      searchDictionaryEntriesParams0.Page = page1; const int hitsPerPage1 = 2;
      searchDictionaryEntriesParams0.HitsPerPage = hitsPerPage1; const string language1 = "fr";
      searchDictionaryEntriesParams0.Language = language1;
    }

    await _client.SearchDictionaryEntriesAsync(dictionaryName0, searchDictionaryEntriesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/compounds/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get searchForFacetValues results with minimal parameters")]
  public async Task SearchForFacetValuesTest0()
  {
    const string indexName0 = "indexName";
    const string facetName0 = "facetName";

    await _client.SearchForFacetValuesAsync(indexName0, facetName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/facets/facetName/query", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get searchForFacetValues results with all parameters")]
  public async Task SearchForFacetValuesTest1()
  {
    const string indexName0 = "indexName";
    const string facetName0 = "facetName";
    var searchForFacetValuesRequest0 = new SearchForFacetValuesRequest();
    {
      const string params1 = "query=foo&facetFilters=['bar']";
      searchForFacetValuesRequest0.VarParams = params1; const string facetQuery1 = "foo";
      searchForFacetValuesRequest0.FacetQuery = facetQuery1; const int maxFacetHits1 = 42;
      searchForFacetValuesRequest0.MaxFacetHits = maxFacetHits1;
    }

    await _client.SearchForFacetValuesAsync(indexName0, facetName0, searchForFacetValuesRequest0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/facets/facetName/query", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchRules0")]
  public async Task SearchRulesTest0()
  {
    const string indexName0 = "indexName";
    var searchRulesParams0 = new SearchRulesParams();
    {
      const string query1 = "something";
      searchRulesParams0.Query = query1;
    }

    await _client.SearchRulesAsync(indexName0, searchRulesParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/rules/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"something\"}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search with minimal parameters")]
  public async Task SearchSingleIndexTest0()
  {
    const string indexName0 = "indexName";

    await _client.SearchSingleIndexAsync<Object>(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/query", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search with special characters in indexName")]
  public async Task SearchSingleIndexTest1()
  {
    const string indexName0 = "cts_e2e_space in index";

    await _client.SearchSingleIndexAsync<Object>(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/cts_e2e_space%20in%20index/query", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "search with searchParams")]
  public async Task SearchSingleIndexTest2()
  {
    const string indexName0 = "indexName";
    var searchParams0 = new SearchParamsObject();
    {
      const string query1 = "myQuery";
      searchParams0.Query = query1; var facetFilters1 = new List<MixedSearchFilters>();
      const string facetFilters_02 = "tags:algolia";
      facetFilters1.Add(new MixedSearchFilters(facetFilters_02));
      searchParams0.FacetFilters = new FacetFilters(facetFilters1);
    }

    await _client.SearchSingleIndexAsync<Object>(indexName0, new SearchParams(searchParams0));

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/query", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchSynonyms with minimal parameters")]
  public async Task SearchSynonymsTest0()
  {
    const string indexName0 = "indexName";

    await _client.SearchSynonymsAsync(indexName0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "searchSynonyms with all parameters")]
  public async Task SearchSynonymsTest1()
  {
    const string indexName0 = "indexName";
    var type0 = (SynonymType)Enum.Parse(typeof(SynonymType), "Altcorrection1");
    const int page0 = 10;
    const int hitsPerPage0 = 10;
    var searchSynonymsParams0 = new SearchSynonymsParams();
    {
      const string query1 = "myQuery";
      searchSynonymsParams0.Query = query1;
    }

    await _client.SearchSynonymsAsync(indexName0, type0, page0, hitsPerPage0, searchSynonymsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/indexName/synonyms/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"myQuery\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"type\":\"altcorrection1\",\"page\":\"10\",\"hitsPerPage\":\"10\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "searchUserIds0")]
  public async Task SearchUserIdsTest0()
  {
    var searchUserIdsParams0 = new SearchUserIdsParams();
    {
      const string query1 = "test";
      searchUserIdsParams0.Query = query1; const string clusterName1 = "theClusterName";
      searchUserIdsParams0.ClusterName = clusterName1; const int page1 = 5;
      searchUserIdsParams0.Page = page1; const int hitsPerPage1 = 10;
      searchUserIdsParams0.HitsPerPage = hitsPerPage1;
    }

    await _client.SearchUserIdsAsync(searchUserIdsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/clusters/mapping/search", req.Path);
    Assert.Equal("POST", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get setDictionarySettings results with minimal parameters")]
  public async Task SetDictionarySettingsTest0()
  {
    var dictionarySettingsParams0 = new DictionarySettingsParams();
    {
      var disableStandardEntries1 = new StandardEntries();
      {
        var plurals2 = new Dictionary<string, Boolean>();
        {
          const bool fr3 = false;
          plurals2.Add("fr", fr3); const bool en3 = false;
          plurals2.Add("en", en3); const bool ru3 = true;
          plurals2.Add("ru", ru3);
        }
        disableStandardEntries1.Plurals = plurals2;
      }
      dictionarySettingsParams0.DisableStandardEntries = disableStandardEntries1;
    }

    await _client.SetDictionarySettingsAsync(dictionarySettingsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/*/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "get setDictionarySettings results with all parameters")]
  public async Task SetDictionarySettingsTest1()
  {
    var dictionarySettingsParams0 = new DictionarySettingsParams();
    {
      var disableStandardEntries1 = new StandardEntries();
      {
        var plurals2 = new Dictionary<string, Boolean>();
        {
          const bool fr3 = false;
          plurals2.Add("fr", fr3); const bool en3 = false;
          plurals2.Add("en", en3); const bool ru3 = true;
          plurals2.Add("ru", ru3);
        }
        disableStandardEntries1.Plurals = plurals2; var stopwords2 = new Dictionary<string, Boolean>();
        {
          const bool fr3 = false;
          stopwords2.Add("fr", fr3);
        }
        disableStandardEntries1.Stopwords = stopwords2; var compounds2 = new Dictionary<string, Boolean>();
        {
          const bool ru3 = true;
          compounds2.Add("ru", ru3);
        }
        disableStandardEntries1.Compounds = compounds2;
      }
      dictionarySettingsParams0.DisableStandardEntries = disableStandardEntries1;
    }

    await _client.SetDictionarySettingsAsync(dictionarySettingsParams0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/dictionaries/*/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "setSettings with minimal parameters")]
  public async Task SetSettingsTest0()
  {
    const string indexName0 = "cts_e2e_settings";
    var indexSettings0 = new IndexSettings();
    {
      const int paginationLimitedTo1 = 10;
      indexSettings0.PaginationLimitedTo = paginationLimitedTo1;
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/cts_e2e_settings/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"paginationLimitedTo\":10}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow boolean `typoTolerance`")]
  public async Task SetSettingsTest1()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const bool typoTolerance1 = true;
      indexSettings0.TypoTolerance = new TypoTolerance(typoTolerance1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"typoTolerance\":true}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow enum `typoTolerance`")]
  public async Task SetSettingsTest2()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      var typoTolerance1 = (TypoToleranceEnum)Enum.Parse(typeof(TypoToleranceEnum), "Min");
      indexSettings0.TypoTolerance = new TypoTolerance(typoTolerance1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"typoTolerance\":\"min\"}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow boolean `ignorePlurals`")]
  public async Task SetSettingsTest3()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const bool ignorePlurals1 = true;
      indexSettings0.IgnorePlurals = new IgnorePlurals(ignorePlurals1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"ignorePlurals\":true}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow list of string `ignorePlurals`")]
  public async Task SetSettingsTest4()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      var ignorePlurals1 = new List<string>();
      const string ignorePlurals_02 = "algolia";
      ignorePlurals1.Add(ignorePlurals_02);
      indexSettings0.IgnorePlurals = new IgnorePlurals(ignorePlurals1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"ignorePlurals\":[\"algolia\"]}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow boolean `removeStopWords`")]
  public async Task SetSettingsTest5()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const bool removeStopWords1 = true;
      indexSettings0.RemoveStopWords = new RemoveStopWords(removeStopWords1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"removeStopWords\":true}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow list of string `removeStopWords`")]
  public async Task SetSettingsTest6()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      var removeStopWords1 = new List<string>();
      const string removeStopWords_02 = "algolia";
      removeStopWords1.Add(removeStopWords_02);
      indexSettings0.RemoveStopWords = new RemoveStopWords(removeStopWords1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"removeStopWords\":[\"algolia\"]}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow boolean `distinct`")]
  public async Task SetSettingsTest7()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const bool distinct1 = true;
      indexSettings0.Distinct = new Distinct(distinct1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"distinct\":true}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow integers for `distinct`")]
  public async Task SetSettingsTest8()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const int distinct1 = 1;
      indexSettings0.Distinct = new Distinct(distinct1);
    }
    const bool forwardToReplicas0 = true;

    await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"distinct\":1}", req.Body, new JsonDiffConfig(true));
    var expectedQuery = JsonConvert.DeserializeObject<Dictionary<string, string>>("{\"forwardToReplicas\":\"true\"}");
    var actualQuery = req.QueryParameters;
    Assert.Equal(expectedQuery.Count, actualQuery.Count);

    foreach (var query in actualQuery)
    {
      string result;
      expectedQuery.TryGetValue(query.Key, out result);
      Assert.Equal(query.Value, result);
    }
  }
  [Fact(DisplayName = "setSettings allow all `indexSettings`")]
  public async Task SetSettingsTest9()
  {
    const string indexName0 = "theIndexName";
    var indexSettings0 = new IndexSettings();
    {
      const bool advancedSyntax1 = true;
      indexSettings0.AdvancedSyntax = advancedSyntax1; var advancedSyntaxFeatures1 = new List<AdvancedSyntaxFeatures>();
      var advancedSyntaxFeatures_02 = (AdvancedSyntaxFeatures)Enum.Parse(typeof(AdvancedSyntaxFeatures), "ExactPhrase");
      advancedSyntaxFeatures1.Add(advancedSyntaxFeatures_02);
      indexSettings0.AdvancedSyntaxFeatures = advancedSyntaxFeatures1; const bool allowCompressionOfIntegerArray1 = true;
      indexSettings0.AllowCompressionOfIntegerArray = allowCompressionOfIntegerArray1; const bool allowTyposOnNumericTokens1 = true;
      indexSettings0.AllowTyposOnNumericTokens = allowTyposOnNumericTokens1; var alternativesAsExact1 = new List<AlternativesAsExact>();
      var alternativesAsExact_02 = (AlternativesAsExact)Enum.Parse(typeof(AlternativesAsExact), "SingleWordSynonym");
      alternativesAsExact1.Add(alternativesAsExact_02);
      indexSettings0.AlternativesAsExact = alternativesAsExact1; const bool attributeCriteriaComputedByMinProximity1 = true;
      indexSettings0.AttributeCriteriaComputedByMinProximity = attributeCriteriaComputedByMinProximity1; const string attributeForDistinct1 = "test";
      indexSettings0.AttributeForDistinct = attributeForDistinct1; var attributesForFaceting1 = new List<string>();
      const string attributesForFaceting_02 = "algolia";
      attributesForFaceting1.Add(attributesForFaceting_02);
      indexSettings0.AttributesForFaceting = attributesForFaceting1; var attributesToHighlight1 = new List<string>();
      const string attributesToHighlight_02 = "algolia";
      attributesToHighlight1.Add(attributesToHighlight_02);
      indexSettings0.AttributesToHighlight = attributesToHighlight1; var attributesToRetrieve1 = new List<string>();
      const string attributesToRetrieve_02 = "algolia";
      attributesToRetrieve1.Add(attributesToRetrieve_02);
      indexSettings0.AttributesToRetrieve = attributesToRetrieve1; var attributesToSnippet1 = new List<string>();
      const string attributesToSnippet_02 = "algolia";
      attributesToSnippet1.Add(attributesToSnippet_02);
      indexSettings0.AttributesToSnippet = attributesToSnippet1; var attributesToTransliterate1 = new List<string>();
      const string attributesToTransliterate_02 = "algolia";
      attributesToTransliterate1.Add(attributesToTransliterate_02);
      indexSettings0.AttributesToTransliterate = attributesToTransliterate1; var camelCaseAttributes1 = new List<string>();
      const string camelCaseAttributes_02 = "algolia";
      camelCaseAttributes1.Add(camelCaseAttributes_02);
      indexSettings0.CamelCaseAttributes = camelCaseAttributes1; var customNormalization1 = new Dictionary<string, Dictionary<string, string>>();
      {
        var algolia2 = new Dictionary<string, string>();
        {
          const string aloglia3 = "aglolia";
          algolia2.Add("aloglia", aloglia3);
        }
        customNormalization1.Add("algolia", algolia2);
      }
      indexSettings0.CustomNormalization = customNormalization1; var customRanking1 = new List<string>();
      const string customRanking_02 = "algolia";
      customRanking1.Add(customRanking_02);
      indexSettings0.CustomRanking = customRanking1; const bool decompoundQuery1 = false;
      indexSettings0.DecompoundQuery = decompoundQuery1; var decompoundedAttributes1 = new Dictionary<string, string>();
      {
        const string algolia2 = "aloglia";
        decompoundedAttributes1.Add("algolia", algolia2);
      }
      indexSettings0.DecompoundedAttributes = decompoundedAttributes1; var disableExactOnAttributes1 = new List<string>();
      const string disableExactOnAttributes_02 = "algolia";
      disableExactOnAttributes1.Add(disableExactOnAttributes_02);
      indexSettings0.DisableExactOnAttributes = disableExactOnAttributes1; var disablePrefixOnAttributes1 = new List<string>();
      const string disablePrefixOnAttributes_02 = "algolia";
      disablePrefixOnAttributes1.Add(disablePrefixOnAttributes_02);
      indexSettings0.DisablePrefixOnAttributes = disablePrefixOnAttributes1; var disableTypoToleranceOnAttributes1 = new List<string>();
      const string disableTypoToleranceOnAttributes_02 = "algolia";
      disableTypoToleranceOnAttributes1.Add(disableTypoToleranceOnAttributes_02);
      indexSettings0.DisableTypoToleranceOnAttributes = disableTypoToleranceOnAttributes1; var disableTypoToleranceOnWords1 = new List<string>();
      const string disableTypoToleranceOnWords_02 = "algolia";
      disableTypoToleranceOnWords1.Add(disableTypoToleranceOnWords_02);
      indexSettings0.DisableTypoToleranceOnWords = disableTypoToleranceOnWords1; const int distinct1 = 3;
      indexSettings0.Distinct = new Distinct(distinct1); const bool enablePersonalization1 = true;
      indexSettings0.EnablePersonalization = enablePersonalization1; const bool enableReRanking1 = false;
      indexSettings0.EnableReRanking = enableReRanking1; const bool enableRules1 = true;
      indexSettings0.EnableRules = enableRules1; var exactOnSingleWordQuery1 = (ExactOnSingleWordQuery)Enum.Parse(typeof(ExactOnSingleWordQuery), "Attribute");
      indexSettings0.ExactOnSingleWordQuery = exactOnSingleWordQuery1; const string highlightPreTag1 = "<span>";
      indexSettings0.HighlightPreTag = highlightPreTag1; const string highlightPostTag1 = "</span>";
      indexSettings0.HighlightPostTag = highlightPostTag1; const int hitsPerPage1 = 10;
      indexSettings0.HitsPerPage = hitsPerPage1; const bool ignorePlurals1 = false;
      indexSettings0.IgnorePlurals = new IgnorePlurals(ignorePlurals1); var indexLanguages1 = new List<string>();
      const string indexLanguages_02 = "algolia";
      indexLanguages1.Add(indexLanguages_02);
      indexSettings0.IndexLanguages = indexLanguages1; const string keepDiacriticsOnCharacters1 = "abc";
      indexSettings0.KeepDiacriticsOnCharacters = keepDiacriticsOnCharacters1; const int maxFacetHits1 = 20;
      indexSettings0.MaxFacetHits = maxFacetHits1; const int maxValuesPerFacet1 = 30;
      indexSettings0.MaxValuesPerFacet = maxValuesPerFacet1; const int minProximity1 = 6;
      indexSettings0.MinProximity = minProximity1; const int minWordSizefor1Typo1 = 5;
      indexSettings0.MinWordSizefor1Typo = minWordSizefor1Typo1; const int minWordSizefor2Typos1 = 11;
      indexSettings0.MinWordSizefor2Typos = minWordSizefor2Typos1; var mode1 = (Mode)Enum.Parse(typeof(Mode), "NeuralSearch");
      indexSettings0.Mode = mode1; var numericAttributesForFiltering1 = new List<string>();
      const string numericAttributesForFiltering_02 = "algolia";
      numericAttributesForFiltering1.Add(numericAttributesForFiltering_02);
      indexSettings0.NumericAttributesForFiltering = numericAttributesForFiltering1; var optionalWords1 = new List<string>();
      const string optionalWords_02 = "myspace";
      optionalWords1.Add(optionalWords_02);
      indexSettings0.OptionalWords = optionalWords1; const int paginationLimitedTo1 = 0;
      indexSettings0.PaginationLimitedTo = paginationLimitedTo1; var queryLanguages1 = new List<string>();
      const string queryLanguages_02 = "algolia";
      queryLanguages1.Add(queryLanguages_02);
      indexSettings0.QueryLanguages = queryLanguages1; var queryType1 = (QueryType)Enum.Parse(typeof(QueryType), "PrefixLast");
      indexSettings0.QueryType = queryType1; var ranking1 = new List<string>();
      const string ranking_02 = "geo";
      ranking1.Add(ranking_02);
      indexSettings0.Ranking = ranking1; const string reRankingApplyFilter1 = "mySearch:filters";
      indexSettings0.ReRankingApplyFilter = new ReRankingApplyFilter(reRankingApplyFilter1); const int relevancyStrictness1 = 10;
      indexSettings0.RelevancyStrictness = relevancyStrictness1; const bool removeStopWords1 = false;
      indexSettings0.RemoveStopWords = new RemoveStopWords(removeStopWords1); var removeWordsIfNoResults1 = (RemoveWordsIfNoResults)Enum.Parse(typeof(RemoveWordsIfNoResults), "LastWords");
      indexSettings0.RemoveWordsIfNoResults = removeWordsIfNoResults1; var renderingContent1 = new RenderingContent();
      {
        var facetOrdering2 = new FacetOrdering();
        {
          var facets3 = new Facets();
          {
            var order4 = new List<string>();
            const string order_05 = "a";
            order4.Add(order_05); const string order_15 = "b";
            order4.Add(order_15);
            facets3.Order = order4;
          }
          facetOrdering2.Facets = facets3; var values3 = new Dictionary<string, Value>();
          {
            var a4 = new Value();
            {
              var order5 = new List<string>();
              const string order_06 = "b";
              order5.Add(order_06);
              a4.Order = order5; var sortRemainingBy5 = (SortRemainingBy)Enum.Parse(typeof(SortRemainingBy), "Count");
              a4.SortRemainingBy = sortRemainingBy5;
            }
            values3.Add("a", a4);
          }
          facetOrdering2.Values = values3;
        }
        renderingContent1.FacetOrdering = facetOrdering2;
      }
      indexSettings0.RenderingContent = renderingContent1; const bool replaceSynonymsInHighlight1 = true;
      indexSettings0.ReplaceSynonymsInHighlight = replaceSynonymsInHighlight1; var replicas1 = new List<string>();
      const string replicas_02 = "";
      replicas1.Add(replicas_02);
      indexSettings0.Replicas = replicas1; var responseFields1 = new List<string>();
      const string responseFields_02 = "algolia";
      responseFields1.Add(responseFields_02);
      indexSettings0.ResponseFields = responseFields1; const bool restrictHighlightAndSnippetArrays1 = true;
      indexSettings0.RestrictHighlightAndSnippetArrays = restrictHighlightAndSnippetArrays1; var searchableAttributes1 = new List<string>();
      const string searchableAttributes_02 = "foo";
      searchableAttributes1.Add(searchableAttributes_02);
      indexSettings0.SearchableAttributes = searchableAttributes1; var semanticSearch1 = new SemanticSearch();
      {
        var eventSources2 = new List<string>();
        const string eventSources_03 = "foo";
        eventSources2.Add(eventSources_03);
        semanticSearch1.EventSources = eventSources2;
      }
      indexSettings0.SemanticSearch = semanticSearch1; const string separatorsToIndex1 = "bar";
      indexSettings0.SeparatorsToIndex = separatorsToIndex1; const string snippetEllipsisText1 = "---";
      indexSettings0.SnippetEllipsisText = snippetEllipsisText1; const string sortFacetValuesBy1 = "date";
      indexSettings0.SortFacetValuesBy = sortFacetValuesBy1; const bool typoTolerance1 = false;
      indexSettings0.TypoTolerance = new TypoTolerance(typoTolerance1); var unretrievableAttributes1 = new List<string>();
      const string unretrievableAttributes_02 = "foo";
      unretrievableAttributes1.Add(unretrievableAttributes_02);
      indexSettings0.UnretrievableAttributes = unretrievableAttributes1; var userData1 = new Dictionary<string, string>();
      {
        const string user2 = "data";
        userData1.Add("user", user2);
      }
      indexSettings0.UserData = userData1;
    }

    await _client.SetSettingsAsync(indexName0, indexSettings0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/indexes/theIndexName/settings", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowCompressionOfIntegerArray\":true,\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"singleWordSynonym\"],\"attributeCriteriaComputedByMinProximity\":true,\"attributeForDistinct\":\"test\",\"attributesForFaceting\":[\"algolia\"],\"attributesToHighlight\":[\"algolia\"],\"attributesToRetrieve\":[\"algolia\"],\"attributesToSnippet\":[\"algolia\"],\"attributesToTransliterate\":[\"algolia\"],\"camelCaseAttributes\":[\"algolia\"],\"customNormalization\":{\"algolia\":{\"aloglia\":\"aglolia\"}},\"customRanking\":[\"algolia\"],\"decompoundQuery\":false,\"decompoundedAttributes\":{\"algolia\":\"aloglia\"},\"disableExactOnAttributes\":[\"algolia\"],\"disablePrefixOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnWords\":[\"algolia\"],\"distinct\":3,\"enablePersonalization\":true,\"enableReRanking\":false,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"highlightPreTag\":\"<span>\",\"highlightPostTag\":\"</span>\",\"hitsPerPage\":10,\"ignorePlurals\":false,\"indexLanguages\":[\"algolia\"],\"keepDiacriticsOnCharacters\":\"abc\",\"maxFacetHits\":20,\"maxValuesPerFacet\":30,\"minProximity\":6,\"minWordSizefor1Typo\":5,\"minWordSizefor2Typos\":11,\"mode\":\"neuralSearch\",\"numericAttributesForFiltering\":[\"algolia\"],\"optionalWords\":[\"myspace\"],\"paginationLimitedTo\":0,\"queryLanguages\":[\"algolia\"],\"queryType\":\"prefixLast\",\"ranking\":[\"geo\"],\"reRankingApplyFilter\":\"mySearch:filters\",\"relevancyStrictness\":10,\"removeStopWords\":false,\"removeWordsIfNoResults\":\"lastWords\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"replicas\":[\"\"],\"responseFields\":[\"algolia\"],\"restrictHighlightAndSnippetArrays\":true,\"searchableAttributes\":[\"foo\"],\"semanticSearch\":{\"eventSources\":[\"foo\"]},\"separatorsToIndex\":\"bar\",\"snippetEllipsisText\":\"---\",\"sortFacetValuesBy\":\"date\",\"typoTolerance\":false,\"unretrievableAttributes\":[\"foo\"],\"userData\":{\"user\":\"data\"}}", req.Body, new JsonDiffConfig(true));
  }
  [Fact(DisplayName = "updateApiKey0")]
  public async Task UpdateApiKeyTest0()
  {
    const string key0 = "myApiKey";
    var apiKey0 = new ApiKey();
    {
      var acl1 = new List<Acl>();
      var acl_02 = (Acl)Enum.Parse(typeof(Acl), "Search");
      acl1.Add(acl_02); var acl_12 = (Acl)Enum.Parse(typeof(Acl), "AddObject");
      acl1.Add(acl_12);
      apiKey0.Acl = acl1; const int validity1 = 300;
      apiKey0.Validity = validity1; const int maxQueriesPerIPPerHour1 = 100;
      apiKey0.MaxQueriesPerIPPerHour = maxQueriesPerIPPerHour1; const int maxHitsPerQuery1 = 20;
      apiKey0.MaxHitsPerQuery = maxHitsPerQuery1;
    }

    await _client.UpdateApiKeyAsync(key0, apiKey0);

    EchoResponse req = _echo.LastResponse;
    Assert.Equal("/1/keys/myApiKey", req.Path);
    Assert.Equal("PUT", req.Method.ToString());
    JsonAssert.EqualOverrideDefault("{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}", req.Body, new JsonDiffConfig(true));
  }
}

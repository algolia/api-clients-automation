package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.EchoRequester;
import com.algolia.EchoResponse;
import com.algolia.api.SearchClient;
import com.algolia.model.search.*;
import com.algolia.utils.JSON;
import com.google.gson.reflect.TypeToken;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchClientTests {

  private SearchClient client;
  private EchoRequester requester;

  @BeforeAll
  void init() {
    requester = new EchoRequester();
    client = new SearchClient("appId", "apiKey", requester);
  }

  @Test
  @DisplayName("addApiKey")
  void addApiKeyTest0() {
    ApiKey apiKey0 = new ApiKey();
    {
      List<Acl> acl1 = new ArrayList<>();
      {
        Acl acl_02 = Acl.fromValue("search");
        acl1.add(acl_02);
        Acl acl_12 = Acl.fromValue("addObject");
        acl1.add(acl_12);
      }
      apiKey0.setAcl(acl1);
      String description1 = "my new api key";
      apiKey0.setDescription(description1);
      int validity1 = 300;
      apiKey0.setValidity(validity1);
      int maxQueriesPerIPPerHour1 = 100;
      apiKey0.setMaxQueriesPerIPPerHour(maxQueriesPerIPPerHour1);
      int maxHitsPerQuery1 = 20;
      apiKey0.setMaxHitsPerQuery(maxHitsPerQuery1);
    }

    assertDoesNotThrow(() -> {
      client.addApiKey(apiKey0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api" +
        " key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("addOrUpdateObject")
  void addOrUpdateObjectTest0() {
    String indexName0 = "indexName";
    String objectID0 = "uniqueID";
    Map<String, String> body0 = new HashMap<>();
    {
      String key1 = "value";
      body0.put("key", key1);
    }

    assertDoesNotThrow(() -> {
      client.addOrUpdateObject(indexName0, objectID0, body0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/uniqueID");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"key\":\"value\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("appendSource")
  void appendSourceTest0() {
    Source source0 = new Source();
    {
      String source1 = "theSource";
      source0.setSource(source1);
      String description1 = "theDescription";
      source0.setDescription(description1);
    }

    assertDoesNotThrow(() -> {
      client.appendSource(source0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/security/sources/append");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"source\":\"theSource\",\"description\":\"theDescription\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("assignUserId")
  void assignUserIdTest0() {
    String xAlgoliaUserID0 = "userID";
    AssignUserIdParams assignUserIdParams0 = new AssignUserIdParams();
    {
      String cluster1 = "theCluster";
      assignUserIdParams0.setCluster(cluster1);
    }

    assertDoesNotThrow(() -> {
      client.assignUserId(xAlgoliaUserID0, assignUserIdParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"cluster\":\"theCluster\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("batch")
  void batchTest0() {
    String indexName0 = "theIndexName";
    BatchWriteParams batchWriteParams0 = new BatchWriteParams();
    {
      List<BatchOperation> requests1 = new ArrayList<>();
      {
        BatchOperation requests_02 = new BatchOperation();
        {
          Action action3 = Action.fromValue("delete");
          requests_02.setAction(action3);
          Map<String, String> body3 = new HashMap<>();
          {
            String key4 = "value";
            body3.put("key", key4);
          }
          requests_02.setBody(body3);
        }
        requests1.add(requests_02);
      }
      batchWriteParams0.setRequests(requests1);
    }

    assertDoesNotThrow(() -> {
      client.batch(indexName0, batchWriteParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"}}]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("batchAssignUserIds")
  void batchAssignUserIdsTest0() {
    String xAlgoliaUserID0 = "userID";
    BatchAssignUserIdsParams batchAssignUserIdsParams0 = new BatchAssignUserIdsParams();
    {
      String cluster1 = "theCluster";
      batchAssignUserIdsParams0.setCluster(cluster1);
      List<String> users1 = new ArrayList<>();
      {
        String users_02 = "user1";
        users1.add(users_02);
        String users_12 = "user2";
        users1.add(users_12);
      }
      batchAssignUserIdsParams0.setUsers(users1);
    }

    assertDoesNotThrow(() -> {
      client.batchAssignUserIds(xAlgoliaUserID0, batchAssignUserIdsParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with minimal parameters")
  void batchDictionaryEntriesTest0() {
    DictionaryType dictionaryName0 = DictionaryType.fromValue("compounds");
    BatchDictionaryEntriesParams batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      List<BatchDictionaryEntriesRequest> requests1 = new ArrayList<>();
      {
        BatchDictionaryEntriesRequest requests_02 = new BatchDictionaryEntriesRequest();
        {
          DictionaryAction action3 = DictionaryAction.fromValue("addEntry");
          requests_02.setAction(action3);
          DictionaryEntry body3 = new DictionaryEntry();
          {
            String objectID4 = "1";
            body3.setObjectID(objectID4);
            String language4 = "en";
            body3.setLanguage(language4);
          }
          requests_02.setBody(body3);
        }
        requests1.add(requests_02);
        BatchDictionaryEntriesRequest requests_12 = new BatchDictionaryEntriesRequest();
        {
          DictionaryAction action3 = DictionaryAction.fromValue("deleteEntry");
          requests_12.setAction(action3);
          DictionaryEntry body3 = new DictionaryEntry();
          {
            String objectID4 = "2";
            body3.setObjectID(objectID4);
            String language4 = "fr";
            body3.setLanguage(language4);
          }
          requests_12.setBody(body3);
        }
        requests1.add(requests_12);
      }
      batchDictionaryEntriesParams0.setRequests(requests1);
    }

    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        dictionaryName0,
        batchDictionaryEntriesParams0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/compounds/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with all parameters")
  void batchDictionaryEntriesTest1() {
    DictionaryType dictionaryName0 = DictionaryType.fromValue("compounds");
    BatchDictionaryEntriesParams batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      boolean clearExistingDictionaryEntries1 = false;
      batchDictionaryEntriesParams0.setClearExistingDictionaryEntries(
        clearExistingDictionaryEntries1
      );
      List<BatchDictionaryEntriesRequest> requests1 = new ArrayList<>();
      {
        BatchDictionaryEntriesRequest requests_02 = new BatchDictionaryEntriesRequest();
        {
          DictionaryAction action3 = DictionaryAction.fromValue("addEntry");
          requests_02.setAction(action3);
          DictionaryEntry body3 = new DictionaryEntry();
          {
            String objectID4 = "1";
            body3.setObjectID(objectID4);
            String language4 = "en";
            body3.setLanguage(language4);
            String word4 = "fancy";
            body3.setWord(word4);
            List<String> words4 = new ArrayList<>();
            {
              String words_05 = "believe";
              words4.add(words_05);
              String words_15 = "algolia";
              words4.add(words_15);
            }
            body3.setWords(words4);
            List<String> decomposition4 = new ArrayList<>();
            {
              String decomposition_05 = "trust";
              decomposition4.add(decomposition_05);
              String decomposition_15 = "algolia";
              decomposition4.add(decomposition_15);
            }
            body3.setDecomposition(decomposition4);
            DictionaryEntryState state4 = DictionaryEntryState.fromValue(
              "enabled"
            );
            body3.setState(state4);
          }
          requests_02.setBody(body3);
        }
        requests1.add(requests_02);
        BatchDictionaryEntriesRequest requests_12 = new BatchDictionaryEntriesRequest();
        {
          DictionaryAction action3 = DictionaryAction.fromValue("deleteEntry");
          requests_12.setAction(action3);
          DictionaryEntry body3 = new DictionaryEntry();
          {
            String objectID4 = "2";
            body3.setObjectID(objectID4);
            String language4 = "fr";
            body3.setLanguage(language4);
            String word4 = "humility";
            body3.setWord(word4);
            List<String> words4 = new ArrayList<>();
            {
              String words_05 = "candor";
              words4.add(words_05);
              String words_15 = "algolia";
              words4.add(words_15);
            }
            body3.setWords(words4);
            List<String> decomposition4 = new ArrayList<>();
            {
              String decomposition_05 = "grit";
              decomposition4.add(decomposition_05);
              String decomposition_15 = "algolia";
              decomposition4.add(decomposition_15);
            }
            body3.setDecomposition(decomposition4);
            DictionaryEntryState state4 = DictionaryEntryState.fromValue(
              "enabled"
            );
            body3.setState(state4);
          }
          requests_12.setBody(body3);
        }
        requests1.add(requests_12);
      }
      batchDictionaryEntriesParams0.setRequests(requests1);
    }

    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        dictionaryName0,
        batchDictionaryEntriesParams0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/compounds/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"fancy\",\"words\":[\"believe\",\"algolia\"],\"decomposition\":[\"trust\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"humility\",\"words\":[\"candor\",\"algolia\"],\"decomposition\":[\"grit\",\"algolia\"],\"state\":\"enabled\"}}]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("batchRules")
  void batchRulesTest0() {
    String indexName0 = "indexName";
    List<Rule> rule0 = new ArrayList<>();
    {
      Rule rule_01 = new Rule();
      {
        String objectID2 = "a-rule-id";
        rule_01.setObjectID(objectID2);
        List<Condition> conditions2 = new ArrayList<>();
        {
          Condition conditions_03 = new Condition();
          {
            String pattern4 = "smartphone";
            conditions_03.setPattern(pattern4);
            Anchoring anchoring4 = Anchoring.fromValue("contains");
            conditions_03.setAnchoring(anchoring4);
          }
          conditions2.add(conditions_03);
        }
        rule_01.setConditions(conditions2);
        Consequence consequence2 = new Consequence();
        {
          ConsequenceParams params3 = new ConsequenceParams();
          {
            String filters4 = "category:smartphone";
            params3.setFilters(filters4);
          }
          consequence2.setParams(params3);
        }
        rule_01.setConsequence(consequence2);
      }
      rule0.add(rule_01);
      Rule rule_11 = new Rule();
      {
        String objectID2 = "a-second-rule-id";
        rule_11.setObjectID(objectID2);
        List<Condition> conditions2 = new ArrayList<>();
        {
          Condition conditions_03 = new Condition();
          {
            String pattern4 = "apple";
            conditions_03.setPattern(pattern4);
            Anchoring anchoring4 = Anchoring.fromValue("contains");
            conditions_03.setAnchoring(anchoring4);
          }
          conditions2.add(conditions_03);
        }
        rule_11.setConditions(conditions2);
        Consequence consequence2 = new Consequence();
        {
          ConsequenceParams params3 = new ConsequenceParams();
          {
            String filters4 = "brand:apple";
            params3.setFilters(filters4);
          }
          consequence2.setParams(params3);
        }
        rule_11.setConsequence(consequence2);
      }
      rule0.add(rule_11);
    }
    boolean forwardToReplicas0 = true;
    boolean clearExistingRules0 = true;

    assertDoesNotThrow(() -> {
      client.batchRules(
        indexName0,
        rule0,
        forwardToReplicas0,
        clearExistingRules0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"category:smartphone\"}}},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}]",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"forwardToReplicas\":\"true\",\"clearExistingRules\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("get browse results with minimal parameters")
  void browseTest0() {
    String indexName0 = "indexName";

    assertDoesNotThrow(() -> {
      client.browse(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/browse");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("get browse results with all parameters")
  void browseTest1() {
    String indexName0 = "indexName";
    BrowseRequest browseRequest0 = new BrowseRequest();
    {
      String params1 = "query=foo&facetFilters=['bar']";
      browseRequest0.setParams(params1);
      String cursor1 = "cts";
      browseRequest0.setCursor(cursor1);
    }

    assertDoesNotThrow(() -> {
      client.browse(indexName0, browseRequest0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/browse");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"params\":\"query=foo&facetFilters=['bar']\",\"cursor\":\"cts\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("clearAllSynonyms")
  void clearAllSynonymsTest0() {
    String indexName0 = "indexName";

    assertDoesNotThrow(() -> {
      client.clearAllSynonyms(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/clear");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("clearObjects")
  void clearObjectsTest0() {
    String indexName0 = "theIndexName";

    assertDoesNotThrow(() -> {
      client.clearObjects(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/clear");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("clearRules")
  void clearRulesTest0() {
    String indexName0 = "indexName";

    assertDoesNotThrow(() -> {
      client.clearRules(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/clear");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("allow del method for a custom path with minimal parameters")
  void delTest0() {
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.del(path0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/minimal");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void delTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }

    assertDoesNotThrow(() -> {
      client.del(path0, parameters0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/all");
    assertEquals(req.method, "DELETE");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"query\":\"parameters\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("deleteApiKey")
  void deleteApiKeyTest0() {
    String key0 = "myTestApiKey";

    assertDoesNotThrow(() -> {
      client.deleteApiKey(key0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys/myTestApiKey");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("deleteBy")
  void deleteByTest0() {
    String indexName0 = "theIndexName";
    SearchParamsObject searchParams0 = new SearchParamsObject();
    {
      String query1 = "testQuery";
      searchParams0.setQuery(query1);
    }

    assertDoesNotThrow(() -> {
      client.deleteBy(
        indexName0,
        SearchParams.ofSearchParamsObject(searchParams0)
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/deleteByQuery");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"testQuery\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("deleteIndex")
  void deleteIndexTest0() {
    String indexName0 = "theIndexName";

    assertDoesNotThrow(() -> {
      client.deleteIndex(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("deleteObject")
  void deleteObjectTest0() {
    String indexName0 = "theIndexName";
    String objectID0 = "uniqueID";

    assertDoesNotThrow(() -> {
      client.deleteObject(indexName0, objectID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/uniqueID");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("deleteRule")
  void deleteRuleTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";

    assertDoesNotThrow(() -> {
      client.deleteRule(indexName0, objectID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/id1");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("deleteSource")
  void deleteSourceTest0() {
    String source0 = "theSource";

    assertDoesNotThrow(() -> {
      client.deleteSource(source0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/security/sources/theSource");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("deleteSynonym")
  void deleteSynonymTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";

    assertDoesNotThrow(() -> {
      client.deleteSynonym(indexName0, objectID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("allow get method for a custom path with minimal parameters")
  void getTest0() {
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.get(path0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/minimal");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void getTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }

    assertDoesNotThrow(() -> {
      client.get(path0, parameters0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/all");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"query\":\"parameters\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("getApiKey")
  void getApiKeyTest0() {
    String key0 = "myTestApiKey";

    assertDoesNotThrow(() -> {
      client.getApiKey(key0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys/myTestApiKey");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("get getDictionaryLanguages")
  void getDictionaryLanguagesTest0() {
    assertDoesNotThrow(() -> {
      client.getDictionaryLanguages();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/*/languages");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("get getDictionarySettings results")
  void getDictionarySettingsTest0() {
    assertDoesNotThrow(() -> {
      client.getDictionarySettings();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/*/settings");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getLogs")
  void getLogsTest0() {
    int offset0 = 5;
    int length0 = 10;
    String indexName0 = "theIndexName";
    LogType type0 = LogType.fromValue("all");

    assertDoesNotThrow(() -> {
      client.getLogs(offset0, length0, indexName0, type0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/logs");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"offset\":\"5\",\"length\":\"10\",\"indexName\":\"theIndexName\",\"type\":\"all\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("getObject")
  void getObjectTest0() {
    String indexName0 = "theIndexName";
    String objectID0 = "uniqueID";
    List<String> attributesToRetrieve0 = new ArrayList<>();
    {
      String attributesToRetrieve_01 = "attr1";
      attributesToRetrieve0.add(attributesToRetrieve_01);
      String attributesToRetrieve_11 = "attr2";
      attributesToRetrieve0.add(attributesToRetrieve_11);
    }

    assertDoesNotThrow(() -> {
      client.getObject(indexName0, objectID0, attributesToRetrieve0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/uniqueID");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"attributesToRetrieve\":\"attr1,attr2\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("getObjects")
  void getObjectsTest0() {
    GetObjectsParams getObjectsParams0 = new GetObjectsParams();
    {
      List<MultipleGetObjectsParams> requests1 = new ArrayList<>();
      {
        MultipleGetObjectsParams requests_02 = new MultipleGetObjectsParams();
        {
          List<String> attributesToRetrieve3 = new ArrayList<>();
          {
            String attributesToRetrieve_04 = "attr1";
            attributesToRetrieve3.add(attributesToRetrieve_04);
            String attributesToRetrieve_14 = "attr2";
            attributesToRetrieve3.add(attributesToRetrieve_14);
          }
          requests_02.setAttributesToRetrieve(attributesToRetrieve3);
          String objectID3 = "uniqueID";
          requests_02.setObjectID(objectID3);
          String indexName3 = "theIndexName";
          requests_02.setIndexName(indexName3);
        }
        requests1.add(requests_02);
      }
      getObjectsParams0.setRequests(requests1);
    }

    assertDoesNotThrow(() -> {
      client.getObjects(getObjectsParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/*/objects");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("getRule")
  void getRuleTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";

    assertDoesNotThrow(() -> {
      client.getRule(indexName0, objectID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/id1");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getSettings")
  void getSettingsTest0() {
    String indexName0 = "theIndexName";

    assertDoesNotThrow(() -> {
      client.getSettings(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/settings");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getSources")
  void getSourcesTest0() {
    assertDoesNotThrow(() -> {
      client.getSources();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/security/sources");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getSynonym")
  void getSynonymTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";

    assertDoesNotThrow(() -> {
      client.getSynonym(indexName0, objectID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest0() {
    String indexName0 = "theIndexName";
    int taskID0 = 123;

    assertDoesNotThrow(() -> {
      client.getTask(indexName0, taskID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/task/123");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getTopUserIds")
  void getTopUserIdsTest0() {
    assertDoesNotThrow(() -> {
      client.getTopUserIds();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/top");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("getUserId")
  void getUserIdTest0() {
    String userID0 = "uniqueID";

    assertDoesNotThrow(() -> {
      client.getUserId(userID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/uniqueID");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("hasPendingMappings")
  void hasPendingMappingsTest0() {
    boolean getClusters0 = true;

    assertDoesNotThrow(() -> {
      client.hasPendingMappings(getClusters0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/pending");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"getClusters\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("listApiKeys")
  void listApiKeysTest0() {
    assertDoesNotThrow(() -> {
      client.listApiKeys();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("listClusters")
  void listClustersTest0() {
    assertDoesNotThrow(() -> {
      client.listClusters();
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters");
    assertEquals(req.method, "GET");
  }

  @Test
  @DisplayName("listIndices")
  void listIndicesTest0() {
    int page0 = 8;

    assertDoesNotThrow(() -> {
      client.listIndices(page0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"page\":\"8\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("listUserIds")
  void listUserIdsTest0() {
    int page0 = 8;
    int hitsPerPage0 = 100;

    assertDoesNotThrow(() -> {
      client.listUserIds(page0, hitsPerPage0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping");
    assertEquals(req.method, "GET");

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"page\":\"8\",\"hitsPerPage\":\"100\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest0() {
    BatchParams batchParams0 = new BatchParams();
    {
      List<MultipleBatchOperation> requests1 = new ArrayList<>();
      {
        MultipleBatchOperation requests_02 = new MultipleBatchOperation();
        {
          Action action3 = Action.fromValue("addObject");
          requests_02.setAction(action3);
          Map<String, String> body3 = new HashMap<>();
          {
            String key4 = "value";
            body3.put("key", key4);
          }
          requests_02.setBody(body3);
          String indexName3 = "theIndexName";
          requests_02.setIndexName(indexName3);
        }
        requests1.add(requests_02);
      }
      batchParams0.setRequests(requests1);
    }

    assertDoesNotThrow(() -> {
      client.multipleBatch(batchParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/*/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("multipleQueries for a single request with minimal parameters")
  void multipleQueriesTest0() {
    MultipleQueriesParams multipleQueriesParams0 = new MultipleQueriesParams();
    {
      List<MultipleQueries> requests1 = new ArrayList<>();
      {
        MultipleQueries requests_02 = new MultipleQueries();
        {
          String indexName3 = "theIndexName";
          requests_02.setIndexName(indexName3);
        }
        requests1.add(requests_02);
      }
      multipleQueriesParams0.setRequests(requests1);
      MultipleQueriesStrategy strategy1 = MultipleQueriesStrategy.fromValue(
        "stopIfEnoughMatches"
      );
      multipleQueriesParams0.setStrategy(strategy1);
    }

    assertDoesNotThrow(() -> {
      client.multipleQueries(multipleQueriesParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/*/queries");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("multipleQueries for multiple requests with all parameters")
  void multipleQueriesTest1() {
    MultipleQueriesParams multipleQueriesParams0 = new MultipleQueriesParams();
    {
      List<MultipleQueries> requests1 = new ArrayList<>();
      {
        MultipleQueries requests_02 = new MultipleQueries();
        {
          String indexName3 = "theIndexName";
          requests_02.setIndexName(indexName3);
          String query3 = "test";
          requests_02.setQuery(query3);
          MultipleQueriesType type3 = MultipleQueriesType.fromValue("facet");
          requests_02.setType(type3);
          String facet3 = "theFacet";
          requests_02.setFacet(facet3);
          String params3 = "testParam";
          requests_02.setParams(params3);
        }
        requests1.add(requests_02);
        MultipleQueries requests_12 = new MultipleQueries();
        {
          String indexName3 = "theIndexName";
          requests_12.setIndexName(indexName3);
          String query3 = "test";
          requests_12.setQuery(query3);
          MultipleQueriesType type3 = MultipleQueriesType.fromValue("default");
          requests_12.setType(type3);
          String params3 = "testParam";
          requests_12.setParams(params3);
        }
        requests1.add(requests_12);
      }
      multipleQueriesParams0.setRequests(requests1);
      MultipleQueriesStrategy strategy1 = MultipleQueriesStrategy.fromValue(
        "stopIfEnoughMatches"
      );
      multipleQueriesParams0.setStrategy(strategy1);
    }

    assertDoesNotThrow(() -> {
      client.multipleQueries(multipleQueriesParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/*/queries");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"test\",\"type\":\"facet\",\"facet\":\"theFacet\",\"params\":\"testParam\"},{\"indexName\":\"theIndexName\",\"query\":\"test\",\"type\":\"default\",\"params\":\"testParam\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("operationIndex")
  void operationIndexTest0() {
    String indexName0 = "theIndexName";
    OperationIndexParams operationIndexParams0 = new OperationIndexParams();
    {
      OperationType operation1 = OperationType.fromValue("copy");
      operationIndexParams0.setOperation(operation1);
      String destination1 = "dest";
      operationIndexParams0.setDestination(destination1);
      List<ScopeType> scope1 = new ArrayList<>();
      {
        ScopeType scope_02 = ScopeType.fromValue("rules");
        scope1.add(scope_02);
        ScopeType scope_12 = ScopeType.fromValue("settings");
        scope1.add(scope_12);
      }
      operationIndexParams0.setScope(scope1);
    }

    assertDoesNotThrow(() -> {
      client.operationIndex(indexName0, operationIndexParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/operation");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("partialUpdateObject")
  void partialUpdateObjectTest0() {
    String indexName0 = "theIndexName";
    String objectID0 = "uniqueID";
    List<Map<String, AttributeOrBuiltInOperation>> attributeOrBuiltInOperation0 = new ArrayList<>();
    {
      Map<String, AttributeOrBuiltInOperation> attributeOrBuiltInOperation_01 = new HashMap<>();
      {
        String id12 = "test";
        attributeOrBuiltInOperation_01.put(
          "id1",
          AttributeOrBuiltInOperation.ofString(id12)
        );
        BuiltInOperation id22 = new BuiltInOperation();
        {
          BuiltInOperationType operation3 = BuiltInOperationType.fromValue(
            "AddUnique"
          );
          id22.setOperation(operation3);
          String value3 = "test2";
          id22.setValue(value3);
        }
        attributeOrBuiltInOperation_01.put(
          "id2",
          AttributeOrBuiltInOperation.ofBuiltInOperation(id22)
        );
      }
      attributeOrBuiltInOperation0.add(attributeOrBuiltInOperation_01);
    }
    boolean createIfNotExists0 = true;

    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        indexName0,
        objectID0,
        attributeOrBuiltInOperation0,
        createIfNotExists0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/uniqueID/partial");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}]",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"createIfNotExists\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("allow post method for a custom path with minimal parameters")
  void postTest0() {
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.post(path0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/minimal");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void postTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String body1 = "parameters";
      body0.put("body", body1);
    }

    assertDoesNotThrow(() -> {
      client.post(path0, parameters0, body0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/all");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"body\":\"parameters\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"query\":\"parameters\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("allow put method for a custom path with minimal parameters")
  void putTest0() {
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.put(path0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/minimal");
    assertEquals(req.method, "PUT");
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void putTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String body1 = "parameters";
      body0.put("body", body1);
    }

    assertDoesNotThrow(() -> {
      client.put(path0, parameters0, body0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/test/all");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"body\":\"parameters\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"query\":\"parameters\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("removeUserId")
  void removeUserIdTest0() {
    String userID0 = "uniqueID";

    assertDoesNotThrow(() -> {
      client.removeUserId(userID0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/uniqueID");
    assertEquals(req.method, "DELETE");
  }

  @Test
  @DisplayName("replaceSources")
  void replaceSourcesTest0() {
    List<Source> source0 = new ArrayList<>();
    {
      Source source_01 = new Source();
      {
        String source2 = "theSource";
        source_01.setSource(source2);
        String description2 = "theDescription";
        source_01.setDescription(description2);
      }
      source0.add(source_01);
    }

    assertDoesNotThrow(() -> {
      client.replaceSources(source0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/security/sources");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"source\":\"theSource\",\"description\":\"theDescription\"}]",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("restoreApiKey")
  void restoreApiKeyTest0() {
    String key0 = "myApiKey";

    assertDoesNotThrow(() -> {
      client.restoreApiKey(key0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys/myApiKey/restore");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("saveObject")
  void saveObjectTest0() {
    String indexName0 = "theIndexName";
    Map<String, String> body0 = new HashMap<>();
    {
      String objectID1 = "id";
      body0.put("objectID", objectID1);
      String test1 = "val";
      body0.put("test", test1);
    }

    assertDoesNotThrow(() -> {
      client.saveObject(indexName0, body0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id\",\"test\":\"val\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("saveRule")
  void saveRuleTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";
    Rule rule0 = new Rule();
    {
      String objectID1 = "id1";
      rule0.setObjectID(objectID1);
      List<Condition> conditions1 = new ArrayList<>();
      {
        Condition conditions_02 = new Condition();
        {
          String pattern3 = "apple";
          conditions_02.setPattern(pattern3);
          Anchoring anchoring3 = Anchoring.fromValue("contains");
          conditions_02.setAnchoring(anchoring3);
        }
        conditions1.add(conditions_02);
      }
      rule0.setConditions(conditions1);
      Consequence consequence1 = new Consequence();
      {
        ConsequenceParams params2 = new ConsequenceParams();
        {
          String filters3 = "brand:apple";
          params2.setFilters(filters3);
        }
        consequence1.setParams(params2);
      }
      rule0.setConsequence(consequence1);
    }
    boolean forwardToReplicas0 = true;

    assertDoesNotThrow(() -> {
      client.saveRule(indexName0, objectID0, rule0, forwardToReplicas0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/id1");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("saveSynonym")
  void saveSynonymTest0() {
    String indexName0 = "indexName";
    String objectID0 = "id1";
    SynonymHit synonymHit0 = new SynonymHit();
    {
      String objectID1 = "id1";
      synonymHit0.setObjectID(objectID1);
      SynonymType type1 = SynonymType.fromValue("synonym");
      synonymHit0.setType(type1);
      List<String> synonyms1 = new ArrayList<>();
      {
        String synonyms_02 = "car";
        synonyms1.add(synonyms_02);
        String synonyms_12 = "vehicule";
        synonyms1.add(synonyms_12);
        String synonyms_22 = "auto";
        synonyms1.add(synonyms_22);
      }
      synonymHit0.setSynonyms(synonyms1);
    }
    boolean forwardToReplicas0 = true;

    assertDoesNotThrow(() -> {
      client.saveSynonym(
        indexName0,
        objectID0,
        synonymHit0,
        forwardToReplicas0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("saveSynonyms")
  void saveSynonymsTest0() {
    String indexName0 = "indexName";
    List<SynonymHit> synonymHit0 = new ArrayList<>();
    {
      SynonymHit synonymHit_01 = new SynonymHit();
      {
        String objectID2 = "id1";
        synonymHit_01.setObjectID(objectID2);
        SynonymType type2 = SynonymType.fromValue("synonym");
        synonymHit_01.setType(type2);
        List<String> synonyms2 = new ArrayList<>();
        {
          String synonyms_03 = "car";
          synonyms2.add(synonyms_03);
          String synonyms_13 = "vehicule";
          synonyms2.add(synonyms_13);
          String synonyms_23 = "auto";
          synonyms2.add(synonyms_23);
        }
        synonymHit_01.setSynonyms(synonyms2);
      }
      synonymHit0.add(synonymHit_01);
      SynonymHit synonymHit_11 = new SynonymHit();
      {
        String objectID2 = "id2";
        synonymHit_11.setObjectID(objectID2);
        SynonymType type2 = SynonymType.fromValue("onewaysynonym");
        synonymHit_11.setType(type2);
        String input2 = "iphone";
        synonymHit_11.setInput(input2);
        List<String> synonyms2 = new ArrayList<>();
        {
          String synonyms_03 = "ephone";
          synonyms2.add(synonyms_03);
          String synonyms_13 = "aphone";
          synonyms2.add(synonyms_13);
          String synonyms_23 = "yphone";
          synonyms2.add(synonyms_23);
        }
        synonymHit_11.setSynonyms(synonyms2);
      }
      synonymHit0.add(synonymHit_11);
    }
    boolean forwardToReplicas0 = true;
    boolean replaceExistingSynonyms0 = false;

    assertDoesNotThrow(() -> {
      client.saveSynonyms(
        indexName0,
        synonymHit0,
        forwardToReplicas0,
        replaceExistingSynonyms0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/batch");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"false\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("search with minimal parameters")
  void searchTest0() {
    String indexName0 = "indexName";
    SearchParamsObject searchParams0 = new SearchParamsObject();
    {
      String query1 = "myQuery";
      searchParams0.setQuery(query1);
    }

    assertDoesNotThrow(() -> {
      client.search(
        indexName0,
        SearchParams.ofSearchParamsObject(searchParams0)
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/query");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"myQuery\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("search with facetFilters")
  void searchTest1() {
    String indexName0 = "indexName";
    SearchParamsObject searchParams0 = new SearchParamsObject();
    {
      String query1 = "myQuery";
      searchParams0.setQuery(query1);
      List<String> facetFilters1 = new ArrayList<>();
      {
        String facetFilters_02 = "tags:algolia";
        facetFilters1.add(facetFilters_02);
      }
      searchParams0.setFacetFilters(FacetFilters.ofListString(facetFilters1));
    }

    assertDoesNotThrow(() -> {
      client.search(
        indexName0,
        SearchParams.ofSearchParamsObject(searchParams0)
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/query");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with minimal parameters")
  void searchDictionaryEntriesTest0() {
    DictionaryType dictionaryName0 = DictionaryType.fromValue("compounds");
    SearchDictionaryEntriesParams searchDictionaryEntriesParams0 = new SearchDictionaryEntriesParams();
    {
      String query1 = "foo";
      searchDictionaryEntriesParams0.setQuery(query1);
    }

    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(
        dictionaryName0,
        searchDictionaryEntriesParams0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/compounds/search");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"foo\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with all parameters")
  void searchDictionaryEntriesTest1() {
    DictionaryType dictionaryName0 = DictionaryType.fromValue("compounds");
    SearchDictionaryEntriesParams searchDictionaryEntriesParams0 = new SearchDictionaryEntriesParams();
    {
      String query1 = "foo";
      searchDictionaryEntriesParams0.setQuery(query1);
      int page1 = 4;
      searchDictionaryEntriesParams0.setPage(page1);
      int hitsPerPage1 = 2;
      searchDictionaryEntriesParams0.setHitsPerPage(hitsPerPage1);
      String language1 = "fr";
      searchDictionaryEntriesParams0.setLanguage(language1);
    }

    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(
        dictionaryName0,
        searchDictionaryEntriesParams0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/compounds/search");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchForFacetValues results with minimal parameters")
  void searchForFacetValuesTest0() {
    String indexName0 = "indexName";
    String facetName0 = "facetName";

    assertDoesNotThrow(() -> {
      client.searchForFacetValues(indexName0, facetName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/facets/facetName/query");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("get searchForFacetValues results with all parameters")
  void searchForFacetValuesTest1() {
    String indexName0 = "indexName";
    String facetName0 = "facetName";
    SearchForFacetValuesRequest searchForFacetValuesRequest0 = new SearchForFacetValuesRequest();
    {
      String params1 = "query=foo&facetFilters=['bar']";
      searchForFacetValuesRequest0.setParams(params1);
      String facetQuery1 = "foo";
      searchForFacetValuesRequest0.setFacetQuery(facetQuery1);
      int maxFacetHits1 = 42;
      searchForFacetValuesRequest0.setMaxFacetHits(maxFacetHits1);
    }

    assertDoesNotThrow(() -> {
      client.searchForFacetValues(
        indexName0,
        facetName0,
        searchForFacetValuesRequest0
      );
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/facets/facetName/query");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("searchRules")
  void searchRulesTest0() {
    String indexName0 = "indexName";
    SearchRulesParams searchRulesParams0 = new SearchRulesParams();
    {
      String query1 = "something";
      searchRulesParams0.setQuery(query1);
    }

    assertDoesNotThrow(() -> {
      client.searchRules(indexName0, searchRulesParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/rules/search");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"something\"}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("searchSynonyms")
  void searchSynonymsTest0() {
    String indexName0 = "indexName";

    assertDoesNotThrow(() -> {
      client.searchSynonyms(indexName0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/indexName/synonyms/search");
    assertEquals(req.method, "POST");
  }

  @Test
  @DisplayName("searchUserIds")
  void searchUserIdsTest0() {
    SearchUserIdsParams searchUserIdsParams0 = new SearchUserIdsParams();
    {
      String query1 = "test";
      searchUserIdsParams0.setQuery(query1);
      String clusterName1 = "theClusterName";
      searchUserIdsParams0.setClusterName(clusterName1);
      int page1 = 5;
      searchUserIdsParams0.setPage(page1);
      int hitsPerPage1 = 10;
      searchUserIdsParams0.setHitsPerPage(hitsPerPage1);
    }

    assertDoesNotThrow(() -> {
      client.searchUserIds(searchUserIdsParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/clusters/mapping/search");
    assertEquals(req.method, "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get setDictionarySettings results with minimal parameters")
  void setDictionarySettingsTest0() {
    DictionarySettingsParams dictionarySettingsParams0 = new DictionarySettingsParams();
    {
      StandardEntries disableStandardEntries1 = new StandardEntries();
      {
        Map<String, Boolean> plurals2 = new HashMap<>();
        {
          boolean fr3 = false;
          plurals2.put("fr", fr3);
          boolean en3 = false;
          plurals2.put("en", en3);
          boolean ru3 = true;
          plurals2.put("ru", ru3);
        }
        disableStandardEntries1.setPlurals(plurals2);
      }
      dictionarySettingsParams0.setDisableStandardEntries(
        disableStandardEntries1
      );
    }

    assertDoesNotThrow(() -> {
      client.setDictionarySettings(dictionarySettingsParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/*/settings");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get setDictionarySettings results with all parameters")
  void setDictionarySettingsTest1() {
    DictionarySettingsParams dictionarySettingsParams0 = new DictionarySettingsParams();
    {
      StandardEntries disableStandardEntries1 = new StandardEntries();
      {
        Map<String, Boolean> plurals2 = new HashMap<>();
        {
          boolean fr3 = false;
          plurals2.put("fr", fr3);
          boolean en3 = false;
          plurals2.put("en", en3);
          boolean ru3 = true;
          plurals2.put("ru", ru3);
        }
        disableStandardEntries1.setPlurals(plurals2);
        Map<String, Boolean> stopwords2 = new HashMap<>();
        {
          boolean fr3 = false;
          stopwords2.put("fr", fr3);
        }
        disableStandardEntries1.setStopwords(stopwords2);
        Map<String, Boolean> compounds2 = new HashMap<>();
        {
          boolean ru3 = true;
          compounds2.put("ru", ru3);
        }
        disableStandardEntries1.setCompounds(compounds2);
      }
      dictionarySettingsParams0.setDisableStandardEntries(
        disableStandardEntries1
      );
    }

    assertDoesNotThrow(() -> {
      client.setDictionarySettings(dictionarySettingsParams0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/dictionaries/*/settings");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("setSettings")
  void setSettingsTest0() {
    String indexName0 = "theIndexName";
    IndexSettings indexSettings0 = new IndexSettings();
    {
      int paginationLimitedTo1 = 10;
      indexSettings0.setPaginationLimitedTo(paginationLimitedTo1);
    }
    boolean forwardToReplicas0 = true;

    assertDoesNotThrow(() -> {
      client.setSettings(indexName0, indexSettings0, forwardToReplicas0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/indexes/theIndexName/settings");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"paginationLimitedTo\":10}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });

    Map<String, String> expectedQuery = JSON.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    Map<String, String> actualQuery = req.queryParameters;

    assertEquals(expectedQuery.size(), actualQuery.size());
    for (Map.Entry<String, String> p : actualQuery.entrySet()) {
      assertEquals(expectedQuery.get(p.getKey()), p.getValue());
    }
  }

  @Test
  @DisplayName("updateApiKey")
  void updateApiKeyTest0() {
    String key0 = "myApiKey";
    ApiKey apiKey0 = new ApiKey();
    {
      List<Acl> acl1 = new ArrayList<>();
      {
        Acl acl_02 = Acl.fromValue("search");
        acl1.add(acl_02);
        Acl acl_12 = Acl.fromValue("addObject");
        acl1.add(acl_12);
      }
      apiKey0.setAcl(acl1);
      int validity1 = 300;
      apiKey0.setValidity(validity1);
      int maxQueriesPerIPPerHour1 = 100;
      apiKey0.setMaxQueriesPerIPPerHour(maxQueriesPerIPPerHour1);
      int maxHitsPerQuery1 = 20;
      apiKey0.setMaxHitsPerQuery(maxHitsPerQuery1);
    }

    assertDoesNotThrow(() -> {
      client.updateApiKey(key0, apiKey0);
    });
    EchoResponse req = requester.getLastEchoResponse();

    assertEquals(req.path, "/1/keys/myApiKey");
    assertEquals(req.method, "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.body,
        JSONCompareMode.STRICT_ORDER
      );
    });
  }
}

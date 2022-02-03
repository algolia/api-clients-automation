package com.algolia;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.model.*;
import com.algolia.search.SearchApi;
import com.algolia.utils.echo.*;
import com.google.gson.reflect.TypeToken;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchApiTests {

  private SearchApi client;
  private JSON json;

  @BeforeAll
  void init() {
    client = new SearchApi("APPID", "apiKey", new EchoRequester());
    json = new JSON();
  }

  @Test
  @DisplayName("addApiKey")
  void addApiKeyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.addApiKey(param0);
      }
    );

    assertEquals(req.getPath(), "/1/keys");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api" +
        " key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("addOrUpdateObject")
  void addOrUpdateObjectTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.addOrUpdateObject(indexName1, objectID1, body1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/uniqueID");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"key\":\"value\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("appendSource")
  void appendSourceTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.appendSource(param0);
      }
    );

    assertEquals(req.getPath(), "/1/security/sources/append");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"source\":\"theSource\",\"description\":\"theDescription\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("assignUserId")
  void assignUserIdTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.assignUserId(xAlgoliaUserID1, assignUserIdParams1);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"cluster\":\"theCluster\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"X-Algolia-User-ID\":\"userID\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("batch")
  void batchTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.batch(indexName1, batchWriteParams1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"},\"indexName\":\"otherIndexName\"}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("batchAssignUserIds")
  void batchAssignUserIdsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.batchAssignUserIds(
          xAlgoliaUserID1,
          batchAssignUserIdsParams1
        );
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"X-Algolia-User-ID\":\"userID\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with minimal parameters")
  void batchDictionaryEntriesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.batchDictionaryEntries(
          dictionaryName1,
          batchDictionaryEntries1
        );
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/compounds/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with all parameters")
  void batchDictionaryEntriesTest1() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.batchDictionaryEntries(
          dictionaryName1,
          batchDictionaryEntries1
        );
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/compounds/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"yo\",\"words\":[\"yo\",\"algolia\"],\"decomposition\":[\"yo\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"salut\",\"words\":[\"salut\",\"algolia\"],\"decomposition\":[\"salut\",\"algolia\"],\"state\":\"enabled\"}}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("batchRules")
  void batchRulesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.batchRules(
          indexName1,
          rule1,
          forwardToReplicas1,
          clearExistingRules1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"category:smartphone\"}}},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}]",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"forwardToReplicas\":\"true\",\"clearExistingRules\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("get browse results with minimal parameters")
  void browseTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.browse(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/browse");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("get browse results with all parameters")
  void browseTest1() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.browse(indexName1, browseRequest1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/browse");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"params\":\"query=foo&facetFilters=['bar']\",\"cursor\":\"cts\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("clearAllSynonyms")
  void clearAllSynonymsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.clearAllSynonyms(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/clear");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("clearObjects")
  void clearObjectsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.clearObjects(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/clear");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("clearRules")
  void clearRulesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.clearRules(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/clear");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("deleteApiKey")
  void deleteApiKeyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteApiKey(key1);
      }
    );

    assertEquals(req.getPath(), "/1/keys/myTestApiKey");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("deleteBy")
  void deleteByTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteBy(indexName1, searchParams1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/deleteByQuery");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"testQuery\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("deleteIndex")
  void deleteIndexTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteIndex(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("deleteObject")
  void deleteObjectTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteObject(indexName1, objectID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/uniqueID");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("deleteRule")
  void deleteRuleTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteRule(indexName1, objectID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/id1");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("deleteSource")
  void deleteSourceTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteSource(source1);
      }
    );

    assertEquals(req.getPath(), "/1/security/sources/theSource");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("deleteSynonym")
  void deleteSynonymTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteSynonym(indexName1, objectID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("getApiKey")
  void getApiKeyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getApiKey(key1);
      }
    );

    assertEquals(req.getPath(), "/1/keys/myTestApiKey");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("get getDictionaryLanguages")
  void getDictionaryLanguagesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getDictionaryLanguages();
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/*/languages");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("get getDictionarySettings results")
  void getDictionarySettingsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getDictionarySettings();
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/*/settings");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getLogs")
  void getLogsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getLogs(offset1, length1, indexName1, type1);
      }
    );

    assertEquals(req.getPath(), "/1/logs");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"offset\":\"5\",\"length\":\"10\",\"indexName\":\"theIndexName\",\"type\":\"all\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("getObject")
  void getObjectTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getObject(indexName1, objectID1, attributesToRetrieve1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/uniqueID");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"attributesToRetrieve\":\"attr1,attr2\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("getObjects")
  void getObjectsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getObjects(param0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/objects");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("getRule")
  void getRuleTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRule(indexName1, objectID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/id1");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getSettings")
  void getSettingsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getSettings(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/settings");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getSources")
  void getSourcesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getSources();
      }
    );

    assertEquals(req.getPath(), "/1/security/sources");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getSynonym")
  void getSynonymTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getSynonym(indexName1, objectID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getTask(indexName1, taskID1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/task/123");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getTopUserIds")
  void getTopUserIdsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getTopUserIds();
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/top");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getUserId")
  void getUserIdTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getUserId(userID1);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/uniqueID");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("hasPendingMappings")
  void hasPendingMappingsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.hasPendingMappings(getClusters1);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/pending");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"getClusters\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("listApiKeys")
  void listApiKeysTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.listApiKeys();
      }
    );

    assertEquals(req.getPath(), "/1/keys");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("listClusters")
  void listClustersTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.listClusters();
      }
    );

    assertEquals(req.getPath(), "/1/clusters");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("listIndices")
  void listIndicesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.listIndices(page1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"page\":\"8\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("listUserIds")
  void listUserIdsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.listUserIds(page1, hitsPerPage1);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping");
    assertEquals(req.getMethod(), "GET");

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"page\":\"8\",\"hitsPerPage\":\"100\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.multipleBatch(param0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("multipleQueries")
  void multipleQueriesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.multipleQueries(param0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/queries");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"test\",\"type\":\"facet\",\"facet\":\"theFacet\",\"params\":\"testParam\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("operationIndex")
  void operationIndexTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.operationIndex(indexName1, operationIndexParams1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/operation");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("partialUpdateObject")
  void partialUpdateObjectTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.partialUpdateObject(
          indexName1,
          objectID1,
          stringBuiltInOperation1,
          createIfNotExists1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/uniqueID/partial");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}]",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"createIfNotExists\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("removeUserId")
  void removeUserIdTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.removeUserId(userID1);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/uniqueID");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("replaceSources")
  void replaceSourcesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.replaceSources(source1);
      }
    );

    assertEquals(req.getPath(), "/1/security/sources");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"source\":\"theSource\",\"description\":\"theDescription\"}]",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("restoreApiKey")
  void restoreApiKeyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.restoreApiKey(key1);
      }
    );

    assertEquals(req.getPath(), "/1/keys/myApiKey/restore");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("saveObject")
  void saveObjectTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.saveObject(indexName1, body1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id\",\"test\":\"val\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("saveRule")
  void saveRuleTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.saveRule(
          indexName1,
          objectID1,
          rule1,
          forwardToReplicas1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/id1");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("saveSynonym")
  void saveSynonymTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.saveSynonym(
          indexName1,
          objectID1,
          synonymHit1,
          forwardToReplicas1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/id1");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("saveSynonyms")
  void saveSynonymsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.saveSynonyms(
          indexName1,
          synonymHit1,
          forwardToReplicas1,
          replaceExistingSynonyms1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/batch");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"false\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("search")
  void searchTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.search(indexName1, searchParams1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/query");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"myQuery\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with minimal parameters")
  void searchDictionaryEntriesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchDictionaryEntries(
          dictionaryName1,
          searchDictionaryEntries1
        );
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/compounds/search");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"foo\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with all parameters")
  void searchDictionaryEntriesTest1() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchDictionaryEntries(
          dictionaryName1,
          searchDictionaryEntries1
        );
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/compounds/search");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get searchForFacetValues results with minimal parameters")
  void searchForFacetValuesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchForFacetValues(indexName1, facetName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/facets/facetName/query");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("get searchForFacetValues results with all parameters")
  void searchForFacetValuesTest1() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchForFacetValues(
          indexName1,
          facetName1,
          searchForFacetValuesRequest1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/facets/facetName/query");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("searchRules")
  void searchRulesTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchRules(indexName1, searchRulesParams1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/rules/search");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"something\"}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("searchSynonyms")
  void searchSynonymsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchSynonyms(indexName1);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/indexName/synonyms/search");
    assertEquals(req.getMethod(), "POST");
  }

  @Test
  @DisplayName("searchUserIds")
  void searchUserIdsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.searchUserIds(param0);
      }
    );

    assertEquals(req.getPath(), "/1/clusters/mapping/search");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get setDictionarySettings results with minimal parameters")
  void setDictionarySettingsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.setDictionarySettings(param0);
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/*/settings");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get setDictionarySettings results with all parameters")
  void setDictionarySettingsTest1() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.setDictionarySettings(param0);
      }
    );

    assertEquals(req.getPath(), "/1/dictionaries/*/settings");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("setSettings")
  void setSettingsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.setSettings(
          indexName1,
          indexSettings1,
          forwardToReplicas1
        );
      }
    );

    assertEquals(req.getPath(), "/1/indexes/theIndexName/settings");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"paginationLimitedTo\":10}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });

    HashMap<String, String> expectedQuery = json.deserialize(
      "{\"forwardToReplicas\":\"true\"}",
      new TypeToken<HashMap<String, String>>() {}.getType()
    );
    List<Pair> acutalQuery = req.getQueryParams();
    for (Pair p : acutalQuery) {
      assertEquals(expectedQuery.get(p.getName()), p.getValue());
    }
  }

  @Test
  @DisplayName("updateApiKey")
  void updateApiKeyTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.updateApiKey(key1, apiKey1);
      }
    );

    assertEquals(req.getPath(), "/1/keys/myApiKey");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }
}

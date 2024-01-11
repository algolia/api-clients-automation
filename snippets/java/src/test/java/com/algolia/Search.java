package com.algolia.methods.snippets;

import com.algolia.api.SearchClient;
import com.algolia.model.search.*;

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // addApiKey0
  void SnippetForAddApiKey() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.addApiKey(
      new ApiKey()
        .setAcl(List.of(Acl.fromValue("search"), Acl.fromValue("addObject")))
        .setDescription("my new api key")
        .setValidity(300)
        .setMaxQueriesPerIPPerHour(100)
        .setMaxHitsPerQuery(20)
    );
  }

  // Snippet for the addOrUpdateObject method.
  //
  // addOrUpdateObject0
  void SnippetForAddOrUpdateObject() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.addOrUpdateObject("indexName", "uniqueID", Map.of("key", "value"));
  }

  // Snippet for the appendSource method.
  //
  // appendSource0
  void SnippetForAppendSource() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
  }

  // Snippet for the assignUserId method.
  //
  // assignUserId0
  void SnippetForAssignUserId() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
  }

  // Snippet for the batch method.
  //
  // allows batch method with `addObject` action
  void SnippetForBatch() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.batch(
      "theIndexName",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "value"))))
    );
  }

  // Snippet for the batchAssignUserIds method.
  //
  // batchAssignUserIds0
  void SnippetForBatchAssignUserIds() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(List.of("user1", "user2")));
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // get batchDictionaryEntries results with minimal parameters
  void SnippetForBatchDictionaryEntries() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.batchDictionaryEntries(
      DictionaryType.fromValue("compounds"),
      new BatchDictionaryEntriesParams()
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.fromValue("addEntry"))
              .setBody(new DictionaryEntry().setObjectID("1").setLanguage("en")),
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.fromValue("deleteEntry"))
              .setBody(new DictionaryEntry().setObjectID("2").setLanguage("fr"))
          )
        )
    );
  }

  // Snippet for the browse method.
  //
  // browse with minimal parameters
  void SnippetForBrowse() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.browse("cts_e2e_browse", Object.class);
  }

  // Snippet for the clearAllSynonyms method.
  //
  // clearAllSynonyms0
  void SnippetForClearAllSynonyms() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.clearAllSynonyms("indexName");
  }

  // Snippet for the clearObjects method.
  //
  // clearObjects0
  void SnippetForClearObjects() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.clearObjects("theIndexName");
  }

  // Snippet for the clearRules method.
  //
  // clearRules0
  void SnippetForClearRules() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.clearRules("indexName");
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteApiKey method.
  //
  // deleteApiKey0
  void SnippetForDeleteApiKey() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteApiKey("myTestApiKey");
  }

  // Snippet for the deleteBy method.
  //
  // deleteBy0
  void SnippetForDeleteBy() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
  }

  // Snippet for the deleteIndex method.
  //
  // deleteIndex0
  void SnippetForDeleteIndex() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteIndex("theIndexName");
  }

  // Snippet for the deleteObject method.
  //
  // deleteObject0
  void SnippetForDeleteObject() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteObject("theIndexName", "uniqueID");
  }

  // Snippet for the deleteRule method.
  //
  // delete rule simple case
  void SnippetForDeleteRule() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteRule("indexName", "id1");
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource0
  void SnippetForDeleteSource() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteSource("theSource");
  }

  // Snippet for the deleteSynonym method.
  //
  // deleteSynonym0
  void SnippetForDeleteSynonym() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteSynonym("indexName", "id1");
  }

  // Snippet for the getApiKey method.
  //
  // getApiKey0
  void SnippetForGetApiKey() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getApiKey("myTestApiKey");
  }

  // Snippet for the getDictionaryLanguages method.
  //
  // get getDictionaryLanguages
  void SnippetForGetDictionaryLanguages() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getDictionaryLanguages();
  }

  // Snippet for the getDictionarySettings method.
  //
  // get getDictionarySettings results
  void SnippetForGetDictionarySettings() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getDictionarySettings();
  }

  // Snippet for the getLogs method.
  //
  // getLogs with minimal parameters
  void SnippetForGetLogs() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getLogs();
  }

  // Snippet for the getObject method.
  //
  // getObject0
  void SnippetForGetObject() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getObject("theIndexName", "uniqueID", List.of("attr1", "attr2"));
  }

  // Snippet for the getObjects method.
  //
  // getObjects0
  void SnippetForGetObjects() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getObjects(
      new GetObjectsParams()
        .setRequests(
          List.of(
            new GetObjectsRequest().setAttributesToRetrieve(List.of("attr1", "attr2")).setObjectID("uniqueID").setIndexName("theIndexName")
          )
        ),
      Object.class
    );
  }

  // Snippet for the getRule method.
  //
  // getRule0
  void SnippetForGetRule() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getRule("indexName", "id1");
  }

  // Snippet for the getSettings method.
  //
  // getSettings0
  void SnippetForGetSettings() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getSettings("cts_e2e_settings");
  }

  // Snippet for the getSources method.
  //
  // getSources0
  void SnippetForGetSources() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getSources();
  }

  // Snippet for the getSynonym method.
  //
  // getSynonym0
  void SnippetForGetSynonym() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getSynonym("indexName", "id1");
  }

  // Snippet for the getTask method.
  //
  // getTask0
  void SnippetForGetTask() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getTask("theIndexName", 123L);
  }

  // Snippet for the getTopUserIds method.
  //
  // getTopUserIds0
  void SnippetForGetTopUserIds() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getTopUserIds();
  }

  // Snippet for the getUserId method.
  //
  // getUserId0
  void SnippetForGetUserId() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getUserId("uniqueID");
  }

  // Snippet for the hasPendingMappings method.
  //
  // hasPendingMappings with minimal parameters
  void SnippetForHasPendingMappings() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.hasPendingMappings();
  }

  // Snippet for the listApiKeys method.
  //
  // listApiKeys0
  void SnippetForListApiKeys() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.listApiKeys();
  }

  // Snippet for the listClusters method.
  //
  // listClusters0
  void SnippetForListClusters() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.listClusters();
  }

  // Snippet for the listIndices method.
  //
  // listIndices with minimal parameters
  void SnippetForListIndices() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.listIndices();
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with minimal parameters
  void SnippetForListUserIds() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.listUserIds();
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch0
  void SnippetForMultipleBatch() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.multipleBatch(
      new BatchParams()
        .setRequests(
          List.of(
            new MultipleBatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "value")).setIndexName("theIndexName")
          )
        )
    );
  }

  // Snippet for the operationIndex method.
  //
  // operationIndex0
  void SnippetForOperationIndex() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.operationIndex(
      "theIndexName",
      new OperationIndexParams()
        .setOperation(OperationType.fromValue("copy"))
        .setDestination("dest")
        .setScope(List.of(ScopeType.fromValue("rules"), ScopeType.fromValue("settings")))
    );
  }

  // Snippet for the partialUpdateObject method.
  //
  // partialUpdateObject0
  void SnippetForPartialUpdateObject() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.partialUpdateObject(
      "theIndexName",
      "uniqueID",
      Map.of(
        "id1",
        AttributeToUpdate.of("test"),
        "id2",
        new BuiltInOperation().setOperation(BuiltInOperationType.fromValue("AddUnique")).setValue("test2")
      ),
      true
    );
  }

  // Snippet for the removeUserId method.
  //
  // removeUserId0
  void SnippetForRemoveUserId() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.removeUserId("uniqueID");
  }

  // Snippet for the replaceSources method.
  //
  // replaceSources0
  void SnippetForReplaceSources() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.replaceSources(List.of(new Source().setSource("theSource").setDescription("theDescription")));
  }

  // Snippet for the restoreApiKey method.
  //
  // restoreApiKey0
  void SnippetForRestoreApiKey() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.restoreApiKey("myApiKey");
  }

  // Snippet for the saveObject method.
  //
  // saveObject0
  void SnippetForSaveObject() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.saveObject("theIndexName", Map.of("objectID", "id", "test", "val"));
  }

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void SnippetForSaveRule() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.saveRule(
      "indexName",
      "id1",
      new Rule()
        .setObjectID("id1")
        .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains"))))
    );
  }

  // Snippet for the saveRules method.
  //
  // saveRules with minimal parameters
  void SnippetForSaveRules() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.saveRules(
      "indexName",
      List.of(
        new Rule()
          .setObjectID("a-rule-id")
          .setConditions(List.of(new Condition().setPattern("smartphone").setAnchoring(Anchoring.fromValue("contains")))),
        new Rule()
          .setObjectID("a-second-rule-id")
          .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains"))))
      )
    );
  }

  // Snippet for the saveSynonym method.
  //
  // saveSynonym0
  void SnippetForSaveSynonym() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.saveSynonym(
      "indexName",
      "id1",
      new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
      true
    );
  }

  // Snippet for the saveSynonyms method.
  //
  // saveSynonyms0
  void SnippetForSaveSynonyms() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.saveSynonyms(
      "indexName",
      List.of(
        new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
        new SynonymHit()
          .setObjectID("id2")
          .setType(SynonymType.fromValue("onewaysynonym"))
          .setInput("iphone")
          .setSynonyms(List.of("ephone", "aphone", "yphone"))
      ),
      true,
      false
    );
  }

  // Snippet for the search method.
  //
  // search for a single hits request with minimal parameters
  void SnippetForSearch() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.search(
      new SearchMethodParams().setRequests(List.of(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))),
      Object.class
    );
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with minimal parameters
  void SnippetForSearchDictionaryEntries() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchDictionaryEntries(DictionaryType.fromValue("compounds"), new SearchDictionaryEntriesParams().setQuery("foo"));
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void SnippetForSearchForFacetValues() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchForFacetValues("indexName", "facetName");
  }

  // Snippet for the searchRules method.
  //
  // searchRules0
  void SnippetForSearchRules() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchRules("indexName", new SearchRulesParams().setQuery("something"));
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with minimal parameters
  void SnippetForSearchSingleIndex() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchSingleIndex("indexName", Object.class);
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with minimal parameters
  void SnippetForSearchSynonyms() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchSynonyms("indexName");
  }

  // Snippet for the searchUserIds method.
  //
  // searchUserIds0
  void SnippetForSearchUserIds() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchUserIds(new SearchUserIdsParams().setQuery("test").setClusterName("theClusterName").setPage(5).setHitsPerPage(10));
  }

  // Snippet for the setDictionarySettings method.
  //
  // get setDictionarySettings results with minimal parameters
  void SnippetForSetDictionarySettings() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.setDictionarySettings(
      new DictionarySettingsParams()
        .setDisableStandardEntries(new StandardEntries().setPlurals(Map.of("fr", false, "en", false, "ru", true)))
    );
  }

  // Snippet for the setSettings method.
  //
  // setSettings with minimal parameters
  void SnippetForSetSettings() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.setSettings("cts_e2e_settings", new IndexSettings().setPaginationLimitedTo(10), true);
  }

  // Snippet for the updateApiKey method.
  //
  // updateApiKey0
  void SnippetForUpdateApiKey() {
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.updateApiKey(
      "myApiKey",
      new ApiKey()
        .setAcl(List.of(Acl.fromValue("search"), Acl.fromValue("addObject")))
        .setValidity(300)
        .setMaxQueriesPerIPPerHour(100)
        .setMaxHitsPerQuery(20)
    );
  }
}

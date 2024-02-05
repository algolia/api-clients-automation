package com.algolia.methods.snippets;

import com.algolia.api.SearchClient;
import com.algolia.model.search.*;

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // addApiKey0
  void snippetForAddApiKey() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForAddOrUpdateObject() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.addOrUpdateObject("indexName", "uniqueID", Map.of("key", "value"));
  }

  // Snippet for the appendSource method.
  //
  // appendSource0
  void snippetForAppendSource() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
  }

  // Snippet for the assignUserId method.
  //
  // assignUserId0
  void snippetForAssignUserId() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
  }

  // Snippet for the batch method.
  //
  // allows batch method with `addObject` action
  void snippetForBatch() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "theIndexName",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "value"))))
    );
  }

  // Snippet for the batchAssignUserIds method.
  //
  // batchAssignUserIds0
  void snippetForBatchAssignUserIds() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(List.of("user1", "user2")));
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // get batchDictionaryEntries results with minimal parameters
  void snippetForBatchDictionaryEntries() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForBrowse() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.browse("cts_e2e_browse", Hit.class);
  }

  // Snippet for the clearObjects method.
  //
  // clearObjects0
  void snippetForClearObjects() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearObjects("theIndexName");
  }

  // Snippet for the clearRules method.
  //
  // clearRules0
  void snippetForClearRules() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearRules("indexName");
  }

  // Snippet for the clearSynonyms method.
  //
  // clearSynonyms0
  void snippetForClearSynonyms() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearSynonyms("indexName");
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the deleteApiKey method.
  //
  // deleteApiKey0
  void snippetForDeleteApiKey() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteApiKey("myTestApiKey");
  }

  // Snippet for the deleteBy method.
  //
  // deleteBy0
  void snippetForDeleteBy() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
  }

  // Snippet for the deleteIndex method.
  //
  // deleteIndex0
  void snippetForDeleteIndex() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteIndex("theIndexName");
  }

  // Snippet for the deleteObject method.
  //
  // deleteObject0
  void snippetForDeleteObject() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteObject("theIndexName", "uniqueID");
  }

  // Snippet for the deleteRule method.
  //
  // delete rule simple case
  void snippetForDeleteRule() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteRule("indexName", "id1");
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource0
  void snippetForDeleteSource() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSource("theSource");
  }

  // Snippet for the deleteSynonym method.
  //
  // deleteSynonym0
  void snippetForDeleteSynonym() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSynonym("indexName", "id1");
  }

  // Snippet for the getApiKey method.
  //
  // getApiKey0
  void snippetForGetApiKey() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getApiKey("myTestApiKey");
  }

  // Snippet for the getDictionaryLanguages method.
  //
  // get getDictionaryLanguages
  void snippetForGetDictionaryLanguages() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getDictionaryLanguages();
  }

  // Snippet for the getDictionarySettings method.
  //
  // get getDictionarySettings results
  void snippetForGetDictionarySettings() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getDictionarySettings();
  }

  // Snippet for the getLogs method.
  //
  // getLogs with minimal parameters
  void snippetForGetLogs() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLogs();
  }

  // Snippet for the getObject method.
  //
  // getObject0
  void snippetForGetObject() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getObject("theIndexName", "uniqueID", List.of("attr1", "attr2"));
  }

  // Snippet for the getObjects method.
  //
  // getObjects0
  void snippetForGetObjects() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getObjects(
      new GetObjectsParams()
        .setRequests(
          List.of(
            new GetObjectsRequest().setAttributesToRetrieve(List.of("attr1", "attr2")).setObjectID("uniqueID").setIndexName("theIndexName")
          )
        ),
      Hit.class
    );
  }

  // Snippet for the getRule method.
  //
  // getRule0
  void snippetForGetRule() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRule("indexName", "id1");
  }

  // Snippet for the getSettings method.
  //
  // getSettings0
  void snippetForGetSettings() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSettings("cts_e2e_settings");
  }

  // Snippet for the getSources method.
  //
  // getSources0
  void snippetForGetSources() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSources();
  }

  // Snippet for the getSynonym method.
  //
  // getSynonym0
  void snippetForGetSynonym() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSynonym("indexName", "id1");
  }

  // Snippet for the getTask method.
  //
  // getTask0
  void snippetForGetTask() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTask("theIndexName", 123L);
  }

  // Snippet for the getTopUserIds method.
  //
  // getTopUserIds0
  void snippetForGetTopUserIds() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTopUserIds();
  }

  // Snippet for the getUserId method.
  //
  // getUserId0
  void snippetForGetUserId() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getUserId("uniqueID");
  }

  // Snippet for the hasPendingMappings method.
  //
  // hasPendingMappings with minimal parameters
  void snippetForHasPendingMappings() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.hasPendingMappings();
  }

  // Snippet for the listApiKeys method.
  //
  // listApiKeys0
  void snippetForListApiKeys() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listApiKeys();
  }

  // Snippet for the listClusters method.
  //
  // listClusters0
  void snippetForListClusters() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listClusters();
  }

  // Snippet for the listIndices method.
  //
  // listIndices with minimal parameters
  void snippetForListIndices() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listIndices();
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with minimal parameters
  void snippetForListUserIds() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listUserIds();
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch0
  void snippetForMultipleBatch() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForOperationIndex() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForPartialUpdateObject() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForRemoveUserId() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.removeUserId("uniqueID");
  }

  // Snippet for the replaceSources method.
  //
  // replaceSources0
  void snippetForReplaceSources() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.replaceSources(List.of(new Source().setSource("theSource").setDescription("theDescription")));
  }

  // Snippet for the restoreApiKey method.
  //
  // restoreApiKey0
  void snippetForRestoreApiKey() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.restoreApiKey("myApiKey");
  }

  // Snippet for the saveObject method.
  //
  // saveObject0
  void snippetForSaveObject() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveObject("theIndexName", Map.of("objectID", "id", "test", "val"));
  }

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void snippetForSaveRule() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForSaveRules() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForSaveSynonym() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForSaveSynonyms() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
  void snippetForSearch() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(new SearchMethodParams().setRequests(List.of(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))), Hit.class);
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with minimal parameters
  void snippetForSearchDictionaryEntries() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchDictionaryEntries(DictionaryType.fromValue("compounds"), new SearchDictionaryEntriesParams().setQuery("foo"));
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void snippetForSearchForFacetValues() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchForFacetValues("indexName", "facetName");
  }

  // Snippet for the searchRules method.
  //
  // searchRules0
  void snippetForSearchRules() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchRules("indexName", new SearchRulesParams().setQuery("something"));
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with minimal parameters
  void snippetForSearchSingleIndex() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchSingleIndex("indexName", Hit.class);
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with minimal parameters
  void snippetForSearchSynonyms() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchSynonyms("indexName");
  }

  // Snippet for the searchUserIds method.
  //
  // searchUserIds0
  void snippetForSearchUserIds() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchUserIds(new SearchUserIdsParams().setQuery("test").setClusterName("theClusterName").setPage(5).setHitsPerPage(10));
  }

  // Snippet for the setDictionarySettings method.
  //
  // get setDictionarySettings results with minimal parameters
  void snippetForSetDictionarySettings() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setDictionarySettings(
      new DictionarySettingsParams()
        .setDisableStandardEntries(new StandardEntries().setPlurals(Map.of("fr", false, "en", false, "ru", true)))
    );
  }

  // Snippet for the setSettings method.
  //
  // setSettings with minimal parameters
  void snippetForSetSettings() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setSettings("cts_e2e_settings", new IndexSettings().setPaginationLimitedTo(10), true);
  }

  // Snippet for the updateApiKey method.
  //
  // updateApiKey0
  void snippetForUpdateApiKey() {
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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

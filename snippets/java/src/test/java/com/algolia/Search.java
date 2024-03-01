package com.algolia.methods.snippets;

import com.algolia.api.SearchClient;
import com.algolia.model.search.*;

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // addApiKey0
  void snippetForAddApiKey() {
    // >SEPARATOR addApiKey
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
    // SEPARATOR<
  }

  // Snippet for the addOrUpdateObject method.
  //
  // addOrUpdateObject0
  void snippetForAddOrUpdateObject() {
    // >SEPARATOR addOrUpdateObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.addOrUpdateObject("indexName", "uniqueID", Map.of("key", "value"));
    // SEPARATOR<
  }

  // Snippet for the appendSource method.
  //
  // appendSource0
  void snippetForAppendSource() {
    // >SEPARATOR appendSource
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
    // SEPARATOR<
  }

  // Snippet for the assignUserId method.
  //
  // assignUserId0
  void snippetForAssignUserId() {
    // >SEPARATOR assignUserId
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // allows batch method with `addObject` action
  void snippetForBatch() {
    // >SEPARATOR batch
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "theIndexName",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batchAssignUserIds method.
  //
  // batchAssignUserIds0
  void snippetForBatchAssignUserIds() {
    // >SEPARATOR batchAssignUserIds
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(List.of("user1", "user2")));
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // get batchDictionaryEntries results with minimal parameters
  void snippetForBatchDictionaryEntries() {
    // >SEPARATOR batchDictionaryEntries
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
    // SEPARATOR<
  }

  // Snippet for the browse method.
  //
  // browse with minimal parameters
  void snippetForBrowse() {
    // >SEPARATOR browse
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.browse("cts_e2e_browse", Hit.class);
    // SEPARATOR<
  }

  // Snippet for the clearObjects method.
  //
  // clearObjects0
  void snippetForClearObjects() {
    // >SEPARATOR clearObjects
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearObjects("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the clearRules method.
  //
  // clearRules0
  void snippetForClearRules() {
    // >SEPARATOR clearRules
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearRules("indexName");
    // SEPARATOR<
  }

  // Snippet for the clearSynonyms method.
  //
  // clearSynonyms0
  void snippetForClearSynonyms() {
    // >SEPARATOR clearSynonyms
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearSynonyms("indexName");
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteApiKey method.
  //
  // deleteApiKey0
  void snippetForDeleteApiKey() {
    // >SEPARATOR deleteApiKey
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteApiKey("myTestApiKey");
    // SEPARATOR<
  }

  // Snippet for the deleteBy method.
  //
  // deleteBy0
  void snippetForDeleteBy() {
    // >SEPARATOR deleteBy
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
    // SEPARATOR<
  }

  // Snippet for the deleteIndex method.
  //
  // deleteIndex0
  void snippetForDeleteIndex() {
    // >SEPARATOR deleteIndex
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteIndex("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the deleteObject method.
  //
  // deleteObject0
  void snippetForDeleteObject() {
    // >SEPARATOR deleteObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteObject("theIndexName", "uniqueID");
    // SEPARATOR<
  }

  // Snippet for the deleteRule method.
  //
  // delete rule simple case
  void snippetForDeleteRule() {
    // >SEPARATOR deleteRule
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteRule("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource0
  void snippetForDeleteSource() {
    // >SEPARATOR deleteSource
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSource("theSource");
    // SEPARATOR<
  }

  // Snippet for the deleteSynonym method.
  //
  // deleteSynonym0
  void snippetForDeleteSynonym() {
    // >SEPARATOR deleteSynonym
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSynonym("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getApiKey method.
  //
  // getApiKey0
  void snippetForGetApiKey() {
    // >SEPARATOR getApiKey
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getApiKey("myTestApiKey");
    // SEPARATOR<
  }

  // Snippet for the getDictionaryLanguages method.
  //
  // get getDictionaryLanguages
  void snippetForGetDictionaryLanguages() {
    // >SEPARATOR getDictionaryLanguages
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getDictionaryLanguages();
    // SEPARATOR<
  }

  // Snippet for the getDictionarySettings method.
  //
  // get getDictionarySettings results
  void snippetForGetDictionarySettings() {
    // >SEPARATOR getDictionarySettings
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getDictionarySettings();
    // SEPARATOR<
  }

  // Snippet for the getLogs method.
  //
  // getLogs with minimal parameters
  void snippetForGetLogs() {
    // >SEPARATOR getLogs
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLogs();
    // SEPARATOR<
  }

  // Snippet for the getObject method.
  //
  // getObject0
  void snippetForGetObject() {
    // >SEPARATOR getObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getObject("theIndexName", "uniqueID", List.of("attr1", "attr2"));
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // getObjects0
  void snippetForGetObjects() {
    // >SEPARATOR getObjects
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
    // SEPARATOR<
  }

  // Snippet for the getRule method.
  //
  // getRule0
  void snippetForGetRule() {
    // >SEPARATOR getRule
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRule("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getSettings method.
  //
  // getSettings0
  void snippetForGetSettings() {
    // >SEPARATOR getSettings
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSettings("cts_e2e_settings");
    // SEPARATOR<
  }

  // Snippet for the getSources method.
  //
  // getSources0
  void snippetForGetSources() {
    // >SEPARATOR getSources
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSources();
    // SEPARATOR<
  }

  // Snippet for the getSynonym method.
  //
  // getSynonym0
  void snippetForGetSynonym() {
    // >SEPARATOR getSynonym
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSynonym("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask0
  void snippetForGetTask() {
    // >SEPARATOR getTask
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTask("theIndexName", 123L);
    // SEPARATOR<
  }

  // Snippet for the getTopUserIds method.
  //
  // getTopUserIds0
  void snippetForGetTopUserIds() {
    // >SEPARATOR getTopUserIds
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTopUserIds();
    // SEPARATOR<
  }

  // Snippet for the getUserId method.
  //
  // getUserId0
  void snippetForGetUserId() {
    // >SEPARATOR getUserId
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getUserId("uniqueID");
    // SEPARATOR<
  }

  // Snippet for the hasPendingMappings method.
  //
  // hasPendingMappings with minimal parameters
  void snippetForHasPendingMappings() {
    // >SEPARATOR hasPendingMappings
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.hasPendingMappings();
    // SEPARATOR<
  }

  // Snippet for the listApiKeys method.
  //
  // listApiKeys0
  void snippetForListApiKeys() {
    // >SEPARATOR listApiKeys
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listApiKeys();
    // SEPARATOR<
  }

  // Snippet for the listClusters method.
  //
  // listClusters0
  void snippetForListClusters() {
    // >SEPARATOR listClusters
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listClusters();
    // SEPARATOR<
  }

  // Snippet for the listIndices method.
  //
  // listIndices with minimal parameters
  void snippetForListIndices() {
    // >SEPARATOR listIndices
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listIndices();
    // SEPARATOR<
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with minimal parameters
  void snippetForListUserIds() {
    // >SEPARATOR listUserIds
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listUserIds();
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch0
  void snippetForMultipleBatch() {
    // >SEPARATOR multipleBatch
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
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // operationIndex0
  void snippetForOperationIndex() {
    // >SEPARATOR operationIndex
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
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // partialUpdateObject0
  void snippetForPartialUpdateObject() {
    // >SEPARATOR partialUpdateObject
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
    // SEPARATOR<
  }

  // Snippet for the removeUserId method.
  //
  // removeUserId0
  void snippetForRemoveUserId() {
    // >SEPARATOR removeUserId
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.removeUserId("uniqueID");
    // SEPARATOR<
  }

  // Snippet for the replaceSources method.
  //
  // replaceSources0
  void snippetForReplaceSources() {
    // >SEPARATOR replaceSources
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.replaceSources(List.of(new Source().setSource("theSource").setDescription("theDescription")));
    // SEPARATOR<
  }

  // Snippet for the restoreApiKey method.
  //
  // restoreApiKey0
  void snippetForRestoreApiKey() {
    // >SEPARATOR restoreApiKey
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.restoreApiKey("myApiKey");
    // SEPARATOR<
  }

  // Snippet for the saveObject method.
  //
  // saveObject0
  void snippetForSaveObject() {
    // >SEPARATOR saveObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveObject("theIndexName", Map.of("objectID", "id", "test", "val"));
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void snippetForSaveRule() {
    // >SEPARATOR saveRule
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
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules with minimal parameters
  void snippetForSaveRules() {
    // >SEPARATOR saveRules
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
    // SEPARATOR<
  }

  // Snippet for the saveSynonym method.
  //
  // saveSynonym0
  void snippetForSaveSynonym() {
    // >SEPARATOR saveSynonym
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveSynonym(
      "indexName",
      "id1",
      new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
      true
    );
    // SEPARATOR<
  }

  // Snippet for the saveSynonyms method.
  //
  // saveSynonyms0
  void snippetForSaveSynonyms() {
    // >SEPARATOR saveSynonyms
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
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for a single hits request with minimal parameters
  void snippetForSearch() {
    // >SEPARATOR search
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(new SearchMethodParams().setRequests(List.of(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))), Hit.class);
    // SEPARATOR<
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with minimal parameters
  void snippetForSearchDictionaryEntries() {
    // >SEPARATOR searchDictionaryEntries
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchDictionaryEntries(DictionaryType.fromValue("compounds"), new SearchDictionaryEntriesParams().setQuery("foo"));
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void snippetForSearchForFacetValues() {
    // >SEPARATOR searchForFacetValues
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchForFacetValues("indexName", "facetName");
    // SEPARATOR<
  }

  // Snippet for the searchRules method.
  //
  // searchRules0
  void snippetForSearchRules() {
    // >SEPARATOR searchRules
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchRules("indexName", new SearchRulesParams().setQuery("something"));
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with minimal parameters
  void snippetForSearchSingleIndex() {
    // >SEPARATOR searchSingleIndex
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchSingleIndex("indexName", Hit.class);
    // SEPARATOR<
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with minimal parameters
  void snippetForSearchSynonyms() {
    // >SEPARATOR searchSynonyms
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchSynonyms("indexName");
    // SEPARATOR<
  }

  // Snippet for the searchUserIds method.
  //
  // searchUserIds0
  void snippetForSearchUserIds() {
    // >SEPARATOR searchUserIds
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchUserIds(new SearchUserIdsParams().setQuery("test").setClusterName("theClusterName").setPage(5).setHitsPerPage(10));
    // SEPARATOR<
  }

  // Snippet for the setDictionarySettings method.
  //
  // get setDictionarySettings results with minimal parameters
  void snippetForSetDictionarySettings() {
    // >SEPARATOR setDictionarySettings
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setDictionarySettings(
      new DictionarySettingsParams()
        .setDisableStandardEntries(new StandardEntries().setPlurals(Map.of("fr", false, "en", false, "ru", true)))
    );
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // setSettings with minimal parameters
  void snippetForSetSettings() {
    // >SEPARATOR setSettings
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setSettings("cts_e2e_settings", new IndexSettings().setPaginationLimitedTo(10), true);
    // SEPARATOR<
  }

  // Snippet for the updateApiKey method.
  //
  // updateApiKey0
  void snippetForUpdateApiKey() {
    // >SEPARATOR updateApiKey
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
    // SEPARATOR<
  }
}

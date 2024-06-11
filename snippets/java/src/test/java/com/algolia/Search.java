package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.SearchClient;
import com.algolia.model.search.*;

// IMPORT<

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // addApiKey
  void snippetForAddApiKey() {
    // >SEPARATOR addApiKey default
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
  // addOrUpdateObject
  void snippetForAddOrUpdateObject() {
    // >SEPARATOR addOrUpdateObject default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.addOrUpdateObject("indexName", "uniqueID", Map.of("key", "value"));
    // SEPARATOR<
  }

  // Snippet for the appendSource method.
  //
  // appendSource
  void snippetForAppendSource() {
    // >SEPARATOR appendSource default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
    // SEPARATOR<
  }

  // Snippet for the assignUserId method.
  //
  // assignUserId
  void snippetForAssignUserId() {
    // >SEPARATOR assignUserId default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // addObject
  void snippetForBatch() {
    // >SEPARATOR batch addObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          List.of(
            new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "bar", "foo", "1")),
            new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "baz", "foo", "2"))
          )
        )
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // clear
  void snippetForBatch1() {
    // >SEPARATOR batch clear
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.fromValue("clear")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // delete
  void snippetForBatch2() {
    // >SEPARATOR batch delete
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.fromValue("delete")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // deleteObject
  void snippetForBatch3() {
    // >SEPARATOR batch deleteObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("deleteObject")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // partialUpdateObject
  void snippetForBatch4() {
    // >SEPARATOR batch partialUpdateObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("partialUpdateObject")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // partialUpdateObjectNoCreate
  void snippetForBatch5() {
    // >SEPARATOR batch partialUpdateObjectNoCreate
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("partialUpdateObjectNoCreate")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // updateObject
  void snippetForBatch6() {
    // >SEPARATOR batch updateObject
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("updateObject")).setBody(Map.of("key", "value"))))
    );
    // SEPARATOR<
  }

  // Snippet for the batchAssignUserIds method.
  //
  // batchAssignUserIds
  void snippetForBatchAssignUserIds() {
    // >SEPARATOR batchAssignUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(List.of("user1", "user2")));
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // replace
  void snippetForBatchDictionaryEntries() {
    // >SEPARATOR batchDictionaryEntries replace
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.fromValue("plurals"),
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.fromValue("addEntry"))
              .setBody(
                new DictionaryEntry()
                  .setObjectID("1")
                  .setLanguage(SupportedLanguage.fromValue("en"))
                  .setWord("fancy")
                  .setWords(List.of("believe", "algolia"))
                  .setDecomposition(List.of("trust", "algolia"))
                  .setState(DictionaryEntryState.fromValue("enabled"))
              )
          )
        )
    );
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // delete
  void snippetForBatchDictionaryEntries1() {
    // >SEPARATOR batchDictionaryEntries delete
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.fromValue("plurals"),
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.fromValue("deleteEntry"))
              .setBody(
                new DictionaryEntry()
                  .setObjectID("1")
                  .setLanguage(SupportedLanguage.fromValue("en"))
                  .setWord("fancy")
                  .setWords(List.of("believe", "algolia"))
                  .setDecomposition(List.of("trust", "algolia"))
                  .setState(DictionaryEntryState.fromValue("enabled"))
              )
          )
        )
    );
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // append
  void snippetForBatchDictionaryEntries2() {
    // >SEPARATOR batchDictionaryEntries append
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.fromValue("stopwords"),
      new BatchDictionaryEntriesParams()
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.fromValue("addEntry"))
              .setBody(
                new DictionaryEntry()
                  .setObjectID("1")
                  .setLanguage(SupportedLanguage.fromValue("en"))
                  .setAdditionalProperty("additional", "try me")
              )
          )
        )
    );
    // SEPARATOR<
  }

  // Snippet for the browse method.
  //
  // browse with minimal parameters
  void snippetForBrowse() {
    // >SEPARATOR browse default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.browse("cts_e2e_browse", Hit.class);
    // SEPARATOR<
  }

  // Snippet for the clearObjects method.
  //
  // clearObjects
  void snippetForClearObjects() {
    // >SEPARATOR clearObjects default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearObjects("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the clearRules method.
  //
  // clearRules
  void snippetForClearRules() {
    // >SEPARATOR clearRules default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.clearRules("indexName");
    // SEPARATOR<
  }

  // Snippet for the clearSynonyms method.
  //
  // clearSynonyms
  void snippetForClearSynonyms() {
    // >SEPARATOR clearSynonyms default
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
    // >SEPARATOR customDelete default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteApiKey method.
  //
  // deleteApiKey
  void snippetForDeleteApiKey() {
    // >SEPARATOR deleteApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteApiKey("myTestApiKey");
    // SEPARATOR<
  }

  // Snippet for the deleteBy method.
  //
  // deleteBy
  void snippetForDeleteBy() {
    // >SEPARATOR deleteBy default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
    // SEPARATOR<
  }

  // Snippet for the deleteIndex method.
  //
  // deleteIndex
  void snippetForDeleteIndex() {
    // >SEPARATOR deleteIndex default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteIndex("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the deleteObject method.
  //
  // deleteObject
  void snippetForDeleteObject() {
    // >SEPARATOR deleteObject default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteObject("<YOUR_INDEX_NAME>", "uniqueID");
    // SEPARATOR<
  }

  // Snippet for the deleteRule method.
  //
  // delete rule simple case
  void snippetForDeleteRule() {
    // >SEPARATOR deleteRule default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteRule("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() {
    // >SEPARATOR deleteSource default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSource("theSource");
    // SEPARATOR<
  }

  // Snippet for the deleteSynonym method.
  //
  // deleteSynonym
  void snippetForDeleteSynonym() {
    // >SEPARATOR deleteSynonym default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteSynonym("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getApiKey method.
  //
  // getApiKey
  void snippetForGetApiKey() {
    // >SEPARATOR getApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getApiKey("myTestApiKey");
    // SEPARATOR<
  }

  // Snippet for the getAppTask method.
  //
  // getAppTask
  void snippetForGetAppTask() {
    // >SEPARATOR getAppTask default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getAppTask(123L);
    // SEPARATOR<
  }

  // Snippet for the getDictionaryLanguages method.
  //
  // get getDictionaryLanguages
  void snippetForGetDictionaryLanguages() {
    // >SEPARATOR getDictionaryLanguages default
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
    // >SEPARATOR getDictionarySettings default
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
    // >SEPARATOR getLogs default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLogs();
    // SEPARATOR<
  }

  // Snippet for the getObject method.
  //
  // getObject
  void snippetForGetObject() {
    // >SEPARATOR getObject default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getObject("theIndexName", "uniqueID", List.of("attr1", "attr2"));
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // getObjects
  void snippetForGetObjects() {
    // >SEPARATOR getObjects default
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
  // getRule
  void snippetForGetRule() {
    // >SEPARATOR getRule default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRule("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getSettings method.
  //
  // getSettings
  void snippetForGetSettings() {
    // >SEPARATOR getSettings default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSettings("cts_e2e_settings");
    // SEPARATOR<
  }

  // Snippet for the getSources method.
  //
  // getSources
  void snippetForGetSources() {
    // >SEPARATOR getSources default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSources();
    // SEPARATOR<
  }

  // Snippet for the getSynonym method.
  //
  // getSynonym
  void snippetForGetSynonym() {
    // >SEPARATOR getSynonym default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getSynonym("indexName", "id1");
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() {
    // >SEPARATOR getTask default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTask("theIndexName", 123L);
    // SEPARATOR<
  }

  // Snippet for the getTopUserIds method.
  //
  // getTopUserIds
  void snippetForGetTopUserIds() {
    // >SEPARATOR getTopUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getTopUserIds();
    // SEPARATOR<
  }

  // Snippet for the getUserId method.
  //
  // getUserId
  void snippetForGetUserId() {
    // >SEPARATOR getUserId default
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
    // >SEPARATOR hasPendingMappings default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.hasPendingMappings();
    // SEPARATOR<
  }

  // Snippet for the listApiKeys method.
  //
  // listApiKeys
  void snippetForListApiKeys() {
    // >SEPARATOR listApiKeys default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listApiKeys();
    // SEPARATOR<
  }

  // Snippet for the listClusters method.
  //
  // listClusters
  void snippetForListClusters() {
    // >SEPARATOR listClusters default
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
    // >SEPARATOR listIndices default
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
    // >SEPARATOR listUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.listUserIds();
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch() {
    // >SEPARATOR multipleBatch default
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
  // scopes
  void snippetForOperationIndex() {
    // >SEPARATOR operationIndex scopes
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams()
        .setOperation(OperationType.fromValue("move"))
        .setDestination("<DESTINATION_INDEX_NAME>")
        .setScope(List.of(ScopeType.fromValue("rules"), ScopeType.fromValue("settings")))
    );
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // copy
  void snippetForOperationIndex1() {
    // >SEPARATOR operationIndex copy
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams().setOperation(OperationType.fromValue("copy")).setDestination("<DESTINATION_INDEX_NAME>")
    );
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // move
  void snippetForOperationIndex2() {
    // >SEPARATOR operationIndex move
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams().setOperation(OperationType.fromValue("move")).setDestination("<DESTINATION_INDEX_NAME>")
    );
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // partialUpdateObject
  void snippetForPartialUpdateObject() {
    // >SEPARATOR partialUpdateObject default
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
  // removeUserId
  void snippetForRemoveUserId() {
    // >SEPARATOR removeUserId default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.removeUserId("uniqueID");
    // SEPARATOR<
  }

  // Snippet for the replaceSources method.
  //
  // replaceSources
  void snippetForReplaceSources() {
    // >SEPARATOR replaceSources default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.replaceSources(List.of(new Source().setSource("theSource").setDescription("theDescription")));
    // SEPARATOR<
  }

  // Snippet for the restoreApiKey method.
  //
  // restoreApiKey
  void snippetForRestoreApiKey() {
    // >SEPARATOR restoreApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.restoreApiKey("myApiKey");
    // SEPARATOR<
  }

  // Snippet for the saveObject method.
  //
  // saveObject
  void snippetForSaveObject() {
    // >SEPARATOR saveObject default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveObject("<YOUR_INDEX_NAME>", Map.of("objectID", "id", "test", "val"));
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void snippetForSaveRule() {
    // >SEPARATOR saveRule default
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
    // >SEPARATOR saveRules default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveRules(
      "<YOUR_INDEX_NAME>",
      List.of(
        new Rule()
          .setObjectID("a-rule-id")
          .setConditions(List.of(new Condition().setPattern("smartphone").setAnchoring(Anchoring.fromValue("contains")))),
        new Rule()
          .setObjectID("a-second-rule-id")
          .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains"))))
      ),
      false,
      true
    );
    // SEPARATOR<
  }

  // Snippet for the saveSynonym method.
  //
  // saveSynonym
  void snippetForSaveSynonym() {
    // >SEPARATOR saveSynonym default
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
  // saveSynonyms
  void snippetForSaveSynonyms() {
    // >SEPARATOR saveSynonyms default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveSynonyms(
      "<YOUR_INDEX_NAME>",
      List.of(
        new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
        new SynonymHit()
          .setObjectID("id2")
          .setType(SynonymType.fromValue("onewaysynonym"))
          .setInput("iphone")
          .setSynonyms(List.of("ephone", "aphone", "yphone"))
      ),
      true,
      true
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // withHitsPerPage
  void snippetForSearch() {
    // >SEPARATOR search withHitsPerPage
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterOnly
  void snippetForSearch1() {
    // >SEPARATOR search filterOnly
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("actor:Scarlett Johansson"))
        ),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterOr
  void snippetForSearch2() {
    // >SEPARATOR search filterOr
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          List.of(
            new SearchForHits()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setQuery("<YOUR_QUERY>")
              .setFilters("actor:Tom Cruise OR actor:Scarlett Johansson")
          )
        ),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterNot
  void snippetForSearch3() {
    // >SEPARATOR search filterNot
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("NOT actor:Nicolas Cage"))
        ),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // retrieveFacets
  void snippetForSearch5() {
    // >SEPARATOR search retrieveFacets
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(List.of("author", "genre")))
        ),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // retrieveFacetsWildcard
  void snippetForSearch6() {
    // >SEPARATOR search retrieveFacetsWildcard
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(List.of("*")))),
      Hit.class
    );
    // SEPARATOR<
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with minimal parameters
  void snippetForSearchDictionaryEntries() {
    // >SEPARATOR searchDictionaryEntries default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchDictionaryEntries(DictionaryType.fromValue("stopwords"), new SearchDictionaryEntriesParams().setQuery("about"));
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void snippetForSearchForFacetValues() {
    // >SEPARATOR searchForFacetValues default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchForFacetValues("indexName", "facetName");
    // SEPARATOR<
  }

  // Snippet for the searchRules method.
  //
  // searchRules
  void snippetForSearchRules() {
    // >SEPARATOR searchRules default
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
    // >SEPARATOR searchSingleIndex default
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
    // >SEPARATOR searchSynonyms default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchSynonyms("indexName");
    // SEPARATOR<
  }

  // Snippet for the searchUserIds method.
  //
  // searchUserIds
  void snippetForSearchUserIds() {
    // >SEPARATOR searchUserIds default
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
    // >SEPARATOR setDictionarySettings default
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
  // setSettingsAttributesForFaceting
  void snippetForSetSettings() {
    // >SEPARATOR setSettings setSettingsAttributesForFaceting
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setAttributesForFaceting(List.of("actor", "filterOnly(category)", "searchable(publisher)"))
    );
    // SEPARATOR<
  }

  // Snippet for the updateApiKey method.
  //
  // updateApiKey
  void snippetForUpdateApiKey() {
    // >SEPARATOR updateApiKey default
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

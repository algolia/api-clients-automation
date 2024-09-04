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
        .setAcl(List.of(Acl.SEARCH, Acl.ADD_OBJECT))
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
    client.addOrUpdateObject("<YOUR_INDEX_NAME>", "uniqueID", Map.of("key", "value"));
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
            new BatchRequest().setAction(Action.ADD_OBJECT).setBody(Map.of("key", "bar", "foo", "1")),
            new BatchRequest().setAction(Action.ADD_OBJECT).setBody(Map.of("key", "baz", "foo", "2"))
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
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.CLEAR).setBody(Map.of("key", "value"))))
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
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.DELETE).setBody(Map.of("key", "value"))))
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
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.DELETE_OBJECT).setBody(Map.of("key", "value"))))
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
        .setRequests(List.of(new BatchRequest().setAction(Action.PARTIAL_UPDATE_OBJECT).setBody(Map.of("key", "value"))))
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
        .setRequests(List.of(new BatchRequest().setAction(Action.PARTIAL_UPDATE_OBJECT_NO_CREATE).setBody(Map.of("key", "value"))))
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
      new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.UPDATE_OBJECT).setBody(Map.of("key", "value"))))
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
      DictionaryType.PLURALS,
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.ADD_ENTRY)
              .setBody(
                new DictionaryEntry()
                  .setObjectID("1")
                  .setLanguage(SupportedLanguage.EN)
                  .setWord("fancy")
                  .setWords(List.of("believe", "algolia"))
                  .setDecomposition(List.of("trust", "algolia"))
                  .setState(DictionaryEntryState.ENABLED)
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
      DictionaryType.PLURALS,
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest().setAction(DictionaryAction.DELETE_ENTRY).setBody(new DictionaryEntry().setObjectID("1"))
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
      DictionaryType.STOPWORDS,
      new BatchDictionaryEntriesParams()
        .setRequests(
          List.of(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.ADD_ENTRY)
              .setBody(
                new DictionaryEntry().setObjectID("1").setLanguage(SupportedLanguage.EN).setAdditionalProperty("additional", "try me")
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
    client.browse("<YOUR_INDEX_NAME>", Hit.class);
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
    client.clearObjects("<YOUR_INDEX_NAME>");
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
    client.clearRules("<YOUR_INDEX_NAME>");
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
    client.clearSynonyms("<YOUR_INDEX_NAME>");
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
    client.deleteBy("<YOUR_INDEX_NAME>", new DeleteByParams().setFilters("brand:brandName"));
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
    client.deleteIndex("<YOUR_INDEX_NAME>");
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

  // Snippet for the deleteObjects method.
  //
  // call deleteObjects without error
  void snippetForDeleteObjects() {
    // >SEPARATOR deleteObjects default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteObjects("<YOUR_INDEX_NAME>", List.of("1", "2"));
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
    client.deleteRule("<YOUR_INDEX_NAME>", "id1");
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
    client.deleteSynonym("<YOUR_INDEX_NAME>", "id1");
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // generate secured api key basic
  void snippetForGenerateSecuredApiKey() {
    // >SEPARATOR generateSecuredApiKey generate secured api key basic
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions().setValidUntil(2524604400L).setRestrictIndices(List.of("Movies"))
    );
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // generate secured api key with searchParams
  void snippetForGenerateSecuredApiKey1() {
    // >SEPARATOR generateSecuredApiKey generate secured api key with searchParams
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions()
        .setValidUntil(2524604400L)
        .setRestrictIndices(List.of("Movies", "cts_e2e_settings"))
        .setRestrictSources("192.168.1.0/24")
        .setFilters("category:Book OR category:Ebook AND _tags:published")
        .setUserToken("user123")
        .setSearchParams(
          new SearchParamsObject()
            .setQuery("batman")
            .setTypoTolerance(TypoToleranceEnum.STRICT)
            .setAroundRadius(AroundRadiusAll.ALL)
            .setMode(Mode.NEURAL_SEARCH)
            .setHitsPerPage(10)
            .setOptionalWords(List.of("one", "two"))
        )
    );
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
    client.getObject("<YOUR_INDEX_NAME>", "uniqueID", List.of("attr1", "attr2"));
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
            new GetObjectsRequest()
              .setAttributesToRetrieve(List.of("attr1", "attr2"))
              .setObjectID("uniqueID")
              .setIndexName("<YOUR_INDEX_NAME>")
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
    client.getRule("<YOUR_INDEX_NAME>", "qr-1725004648916");
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
    client.getSettings("<YOUR_INDEX_NAME>");
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
    client.getSynonym("<YOUR_INDEX_NAME>", "id1");
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
    client.getTask("<YOUR_INDEX_NAME>", 123L);
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

  // Snippet for the indexExists method.
  //
  // indexExists
  void snippetForIndexExists() {
    // >SEPARATOR indexExists indexExists
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
    // SEPARATOR<
  }

  // Snippet for the indexExists method.
  //
  // indexNotExists
  void snippetForIndexExists1() {
    // >SEPARATOR indexExists indexNotExists
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
    // SEPARATOR<
  }

  // Snippet for the indexExists method.
  //
  // indexExistsWithError
  void snippetForIndexExists2() {
    // >SEPARATOR indexExists indexExistsWithError
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
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
          List.of(new MultipleBatchRequest().setAction(Action.ADD_OBJECT).setBody(Map.of("key", "value")).setIndexName("<YOUR_INDEX_NAME>"))
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
        .setOperation(OperationType.MOVE)
        .setDestination("<DESTINATION_INDEX_NAME>")
        .setScope(List.of(ScopeType.RULES, ScopeType.SETTINGS))
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
      new OperationIndexParams().setOperation(OperationType.COPY).setDestination("<DESTINATION_INDEX_NAME>")
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
      new OperationIndexParams().setOperation(OperationType.MOVE).setDestination("<DESTINATION_INDEX_NAME>")
    );
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for a string attribute
  void snippetForPartialUpdateObject() {
    // >SEPARATOR partialUpdateObject default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.partialUpdateObject("<YOUR_INDEX_NAME>", "uniqueID", Map.of("attributeId", "new value"));
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObjects method.
  //
  // call partialUpdateObjects with createIfNotExists=true
  void snippetForPartialUpdateObjects() {
    // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists&#x3D;true
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.partialUpdateObjects(
      "<YOUR_INDEX_NAME>",
      List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit")),
      true
    );
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObjects method.
  //
  // call partialUpdateObjects with createIfNotExists=false
  void snippetForPartialUpdateObjects1() {
    // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists&#x3D;false
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.partialUpdateObjects(
      "<YOUR_INDEX_NAME>",
      List.of(Map.of("objectID", "3", "name", "Cyril"), Map.of("objectID", "4", "name", "David")),
      false
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

  // Snippet for the replaceAllObjects method.
  //
  // call replaceAllObjects without error
  void snippetForReplaceAllObjects() {
    // >SEPARATOR replaceAllObjects default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.replaceAllObjects(
      "<YOUR_INDEX_NAME>",
      List.of(
        Map.of("objectID", "1", "name", "Adam"),
        Map.of("objectID", "2", "name", "Benoit"),
        Map.of("objectID", "3", "name", "Cyril"),
        Map.of("objectID", "4", "name", "David"),
        Map.of("objectID", "5", "name", "Eva"),
        Map.of("objectID", "6", "name", "Fiona"),
        Map.of("objectID", "7", "name", "Gael"),
        Map.of("objectID", "8", "name", "Hugo"),
        Map.of("objectID", "9", "name", "Igor"),
        Map.of("objectID", "10", "name", "Julia")
      ),
      3
    );
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

  // Snippet for the saveObjects method.
  //
  // call saveObjects without error
  void snippetForSaveObjects() {
    // >SEPARATOR saveObjects call saveObjects without error
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveObjects("<YOUR_INDEX_NAME>", List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit")));
    // SEPARATOR<
  }

  // Snippet for the saveObjects method.
  //
  // saveObjects should report errors
  void snippetForSaveObjects1() {
    // >SEPARATOR saveObjects saveObjects should report errors
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.saveObjects("<YOUR_INDEX_NAME>", List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit")));
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
      "<YOUR_INDEX_NAME>",
      "id1",
      new Rule().setObjectID("id1").setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
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
          .setConditions(List.of(new Condition().setPattern("smartphone").setAnchoring(Anchoring.CONTAINS))),
        new Rule()
          .setObjectID("a-second-rule-id")
          .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
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
      "<YOUR_INDEX_NAME>",
      "id1",
      new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(List.of("car", "vehicule", "auto")),
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
        new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(List.of("car", "vehicule", "auto")),
        new SynonymHit()
          .setObjectID("id2")
          .setType(SynonymType.ONEWAYSYNONYM)
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
  void snippetForSearch4() {
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
  void snippetForSearch5() {
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
    client.searchDictionaryEntries(DictionaryType.STOPWORDS, new SearchDictionaryEntriesParams().setQuery("about"));
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
    client.searchForFacetValues("<YOUR_INDEX_NAME>", "facetName");
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
    client.searchRules("<YOUR_INDEX_NAME>", new SearchRulesParams().setQuery("zorro"));
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
    client.searchSingleIndex("<YOUR_INDEX_NAME>", Hit.class);
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
    client.searchSynonyms("<YOUR_INDEX_NAME>");
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
    // >SEPARATOR setSettings default
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
      new ApiKey().setAcl(List.of(Acl.SEARCH, Acl.ADD_OBJECT)).setValidity(300).setMaxQueriesPerIPPerHour(100).setMaxHitsPerQuery(20)
    );
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key helper - add
  void snippetForWaitForApiKey() {
    // >SEPARATOR waitForApiKey wait for api key helper - add
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.waitForApiKey("api-key-add-operation-test-java", ApiKeyOperation.ADD);
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key - update
  void snippetForWaitForApiKey1() {
    // >SEPARATOR waitForApiKey wait for api key - update
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.waitForApiKey(
      "api-key-update-operation-test-java",
      ApiKeyOperation.UPDATE,
      new ApiKey()
        .setDescription("my updated api key")
        .setAcl(List.of(Acl.SEARCH, Acl.ADD_OBJECT, Acl.DELETE_OBJECT))
        .setIndexes(List.of("Movies", "Books"))
        .setReferers(List.of("*google.com", "*algolia.com"))
        .setValidity(305)
        .setMaxQueriesPerIPPerHour(95)
        .setMaxHitsPerQuery(20)
    );
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key - delete
  void snippetForWaitForApiKey2() {
    // >SEPARATOR waitForApiKey wait for api key - delete
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.waitForApiKey("api-key-delete-operation-test-java", ApiKeyOperation.DELETE);
    // SEPARATOR<
  }

  // Snippet for the waitForAppTask method.
  //
  // wait for an application-level task
  void snippetForWaitForAppTask() {
    // >SEPARATOR waitForAppTask default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.waitForAppTask(123L);
    // SEPARATOR<
  }

  // Snippet for the waitForTask method.
  //
  // wait for task
  void snippetForWaitForTask() {
    // >SEPARATOR waitForTask default
    // Initialize the client
    SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.waitForTask("<YOUR_INDEX_NAME>", 123L);
    // SEPARATOR<
  }
}

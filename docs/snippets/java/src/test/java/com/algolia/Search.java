package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.SearchClient;
import com.algolia.model.search.*;
// IMPORT<
import java.util.*;

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // addApiKey
  void snippetForAddApiKey() throws Exception {
    // >SEPARATOR addApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.addApiKey(
      new ApiKey()
        .setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT))
        .setDescription("my new api key")
        .setValidity(300)
        .setMaxQueriesPerIPPerHour(100)
        .setMaxHitsPerQuery(20)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the addOrUpdateObject method.
  //
  // addOrUpdateObject
  void snippetForAddOrUpdateObject() throws Exception {
    // >SEPARATOR addOrUpdateObject default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.addOrUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("key", "value");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the appendSource method.
  //
  // appendSource
  void snippetForAppendSource() throws Exception {
    // >SEPARATOR appendSource default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the assignUserId method.
  //
  // assignUserId
  void snippetForAssignUserId() throws Exception {
    // >SEPARATOR assignUserId default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // addObject
  void snippetForBatch() throws Exception {
    // >SEPARATOR batch addObject
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.ADD_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "bar");
                    put("foo", "1");
                  }
                }
              ),
            new BatchRequest()
              .setAction(Action.ADD_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "baz");
                    put("foo", "2");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // clear
  void snippetForBatch1() throws Exception {
    // >SEPARATOR batch clear
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.CLEAR)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // delete
  void snippetForBatch2() throws Exception {
    // >SEPARATOR batch delete
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.DELETE)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // deleteObject
  void snippetForBatch3() throws Exception {
    // >SEPARATOR batch deleteObject
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.DELETE_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // partialUpdateObject
  void snippetForBatch4() throws Exception {
    // >SEPARATOR batch partialUpdateObject
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.PARTIAL_UPDATE_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // partialUpdateObjectNoCreate
  void snippetForBatch5() throws Exception {
    // >SEPARATOR batch partialUpdateObjectNoCreate
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.PARTIAL_UPDATE_OBJECT_NO_CREATE)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batch method.
  //
  // updateObject
  void snippetForBatch6() throws Exception {
    // >SEPARATOR batch updateObject
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batch(
      "<YOUR_INDEX_NAME>",
      new BatchWriteParams()
        .setRequests(
          Arrays.asList(
            new BatchRequest()
              .setAction(Action.UPDATE_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batchAssignUserIds method.
  //
  // batchAssignUserIds
  void snippetForBatchAssignUserIds() throws Exception {
    // >SEPARATOR batchAssignUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(Arrays.asList("user1", "user2")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // replace
  void snippetForBatchDictionaryEntries() throws Exception {
    // >SEPARATOR batchDictionaryEntries replace
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.PLURALS,
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          Arrays.asList(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.ADD_ENTRY)
              .setBody(
                new DictionaryEntry()
                  .setObjectID("1")
                  .setLanguage(SupportedLanguage.EN)
                  .setWord("fancy")
                  .setWords(Arrays.asList("believe", "algolia"))
                  .setDecomposition(Arrays.asList("trust", "algolia"))
                  .setState(DictionaryEntryState.ENABLED)
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // delete
  void snippetForBatchDictionaryEntries1() throws Exception {
    // >SEPARATOR batchDictionaryEntries delete
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.PLURALS,
      new BatchDictionaryEntriesParams()
        .setClearExistingDictionaryEntries(true)
        .setRequests(
          Arrays.asList(
            new BatchDictionaryEntriesRequest().setAction(DictionaryAction.DELETE_ENTRY).setBody(new DictionaryEntry().setObjectID("1"))
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the batchDictionaryEntries method.
  //
  // append
  void snippetForBatchDictionaryEntries2() throws Exception {
    // >SEPARATOR batchDictionaryEntries append
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.batchDictionaryEntries(
      DictionaryType.STOPWORDS,
      new BatchDictionaryEntriesParams()
        .setRequests(
          Arrays.asList(
            new BatchDictionaryEntriesRequest()
              .setAction(DictionaryAction.ADD_ENTRY)
              .setBody(
                new DictionaryEntry().setObjectID("1").setLanguage(SupportedLanguage.EN).setAdditionalProperty("additional", "try me")
              )
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the browse method.
  //
  // browse with minimal parameters
  void snippetForBrowse() throws Exception {
    // >SEPARATOR browse default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.browse("<YOUR_INDEX_NAME>", Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the clearObjects method.
  //
  // clearObjects
  void snippetForClearObjects() throws Exception {
    // >SEPARATOR clearObjects default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.clearObjects("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the clearRules method.
  //
  // clearRules
  void snippetForClearRules() throws Exception {
    // >SEPARATOR clearRules default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.clearRules("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the clearSynonyms method.
  //
  // clearSynonyms
  void snippetForClearSynonyms() throws Exception {
    // >SEPARATOR clearSynonyms default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.clearSynonyms("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteApiKey method.
  //
  // deleteApiKey
  void snippetForDeleteApiKey() throws Exception {
    // >SEPARATOR deleteApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteApiKey("myTestApiKey");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteBy method.
  //
  // deleteBy
  void snippetForDeleteBy() throws Exception {
    // >SEPARATOR deleteBy default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteBy("<YOUR_INDEX_NAME>", new DeleteByParams().setFilters("brand:brandName"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteIndex method.
  //
  // deleteIndex
  void snippetForDeleteIndex() throws Exception {
    // >SEPARATOR deleteIndex default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteIndex("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteObject method.
  //
  // deleteObject
  void snippetForDeleteObject() throws Exception {
    // >SEPARATOR deleteObject default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteObject("<YOUR_INDEX_NAME>", "uniqueID");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteObjects method.
  //
  // call deleteObjects without error
  void snippetForDeleteObjects() throws Exception {
    // >SEPARATOR deleteObjects default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteObjects("<YOUR_INDEX_NAME>", Arrays.asList("1", "2"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteRule method.
  //
  // delete rule simple case
  void snippetForDeleteRule() throws Exception {
    // >SEPARATOR deleteRule default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteRule("<YOUR_INDEX_NAME>", "id1");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteSource method.
  //
  // deleteSource
  void snippetForDeleteSource() throws Exception {
    // >SEPARATOR deleteSource default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteSource("theSource");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteSynonym method.
  //
  // deleteSynonym
  void snippetForDeleteSynonym() throws Exception {
    // >SEPARATOR deleteSynonym default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteSynonym("<YOUR_INDEX_NAME>", "id1");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // generate secured api key basic
  void snippetForGenerateSecuredApiKey() throws Exception {
    // >SEPARATOR generateSecuredApiKey generate secured api key basic
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions().setValidUntil(2524604400L).setRestrictIndices(Arrays.asList("Movies"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // generate secured api key with searchParams
  void snippetForGenerateSecuredApiKey1() throws Exception {
    // >SEPARATOR generateSecuredApiKey generate secured api key with searchParams
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions()
        .setValidUntil(2524604400L)
        .setRestrictIndices(Arrays.asList("Movies", "cts_e2e_settings"))
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
            .setOptionalWords(Arrays.asList("one", "two"))
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getApiKey method.
  //
  // getApiKey
  void snippetForGetApiKey() throws Exception {
    // >SEPARATOR getApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getApiKey("myTestApiKey");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getAppTask method.
  //
  // getAppTask
  void snippetForGetAppTask() throws Exception {
    // >SEPARATOR getAppTask default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getAppTask(123L);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getDictionaryLanguages method.
  //
  // get getDictionaryLanguages
  void snippetForGetDictionaryLanguages() throws Exception {
    // >SEPARATOR getDictionaryLanguages default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getDictionaryLanguages();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getDictionarySettings method.
  //
  // get getDictionarySettings results
  void snippetForGetDictionarySettings() throws Exception {
    // >SEPARATOR getDictionarySettings default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getDictionarySettings();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getLogs method.
  //
  // getLogs with minimal parameters
  void snippetForGetLogs() throws Exception {
    // >SEPARATOR getLogs default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getLogs();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObject method.
  //
  // getObject
  void snippetForGetObject() throws Exception {
    // >SEPARATOR getObject default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObject("<YOUR_INDEX_NAME>", "uniqueID", Arrays.asList("attr1", "attr2"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // getObjects
  void snippetForGetObjects() throws Exception {
    // >SEPARATOR getObjects default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObjects(
      new GetObjectsParams()
        .setRequests(
          Arrays.asList(
            new GetObjectsRequest()
              .setAttributesToRetrieve(Arrays.asList("attr1", "attr2"))
              .setObjectID("uniqueID")
              .setIndexName("<YOUR_INDEX_NAME>")
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getRule method.
  //
  // getRule
  void snippetForGetRule() throws Exception {
    // >SEPARATOR getRule default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getRule("<YOUR_INDEX_NAME>", "qr-1725004648916");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSettings method.
  //
  // getSettings
  void snippetForGetSettings() throws Exception {
    // >SEPARATOR getSettings default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getSettings("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSources method.
  //
  // getSources
  void snippetForGetSources() throws Exception {
    // >SEPARATOR getSources default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getSources();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getSynonym method.
  //
  // getSynonym
  void snippetForGetSynonym() throws Exception {
    // >SEPARATOR getSynonym default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getSynonym("<YOUR_INDEX_NAME>", "id1");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() throws Exception {
    // >SEPARATOR getTask default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getTask("<YOUR_INDEX_NAME>", 123L);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getTopUserIds method.
  //
  // getTopUserIds
  void snippetForGetTopUserIds() throws Exception {
    // >SEPARATOR getTopUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getTopUserIds();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getUserId method.
  //
  // getUserId
  void snippetForGetUserId() throws Exception {
    // >SEPARATOR getUserId default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getUserId("uniqueID");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the hasPendingMappings method.
  //
  // hasPendingMappings with minimal parameters
  void snippetForHasPendingMappings() throws Exception {
    // >SEPARATOR hasPendingMappings default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.hasPendingMappings();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the indexExists method.
  //
  // indexExists
  void snippetForIndexExists() throws Exception {
    // >SEPARATOR indexExists indexExists
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the indexExists method.
  //
  // indexNotExists
  void snippetForIndexExists1() throws Exception {
    // >SEPARATOR indexExists indexNotExists
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the indexExists method.
  //
  // indexExistsWithError
  void snippetForIndexExists2() throws Exception {
    // >SEPARATOR indexExists indexExistsWithError
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.indexExists("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listApiKeys method.
  //
  // listApiKeys
  void snippetForListApiKeys() throws Exception {
    // >SEPARATOR listApiKeys default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listApiKeys();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listClusters method.
  //
  // listClusters
  void snippetForListClusters() throws Exception {
    // >SEPARATOR listClusters default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listClusters();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listIndices method.
  //
  // listIndices with minimal parameters
  void snippetForListIndices() throws Exception {
    // >SEPARATOR listIndices default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listIndices();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with minimal parameters
  void snippetForListUserIds() throws Exception {
    // >SEPARATOR listUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listUserIds();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch() throws Exception {
    // >SEPARATOR multipleBatch default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.multipleBatch(
      new BatchParams()
        .setRequests(
          Arrays.asList(
            new MultipleBatchRequest()
              .setAction(Action.ADD_OBJECT)
              .setBody(
                new HashMap() {
                  {
                    put("key", "value");
                  }
                }
              )
              .setIndexName("<YOUR_INDEX_NAME>")
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // scopes
  void snippetForOperationIndex() throws Exception {
    // >SEPARATOR operationIndex scopes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams()
        .setOperation(OperationType.MOVE)
        .setDestination("<DESTINATION_INDEX_NAME>")
        .setScope(Arrays.asList(ScopeType.RULES, ScopeType.SETTINGS))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // copy
  void snippetForOperationIndex1() throws Exception {
    // >SEPARATOR operationIndex copy
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams().setOperation(OperationType.COPY).setDestination("<DESTINATION_INDEX_NAME>")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the operationIndex method.
  //
  // move
  void snippetForOperationIndex2() throws Exception {
    // >SEPARATOR operationIndex move
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.operationIndex(
      "<SOURCE_INDEX_NAME>",
      new OperationIndexParams().setOperation(OperationType.MOVE).setDestination("<DESTINATION_INDEX_NAME>")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for a string attribute
  void snippetForPartialUpdateObject() throws Exception {
    // >SEPARATOR partialUpdateObject default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("attributeId", "new value");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObjects method.
  //
  // call partialUpdateObjects with createIfNotExists=true
  void snippetForPartialUpdateObjects() throws Exception {
    // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists=true
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("name", "Adam");
          }
        },
        new HashMap() {
          {
            put("objectID", "2");
            put("name", "Benoit");
          }
        }
      ),
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObjects method.
  //
  // call partialUpdateObjects with createIfNotExists=false
  void snippetForPartialUpdateObjects1() throws Exception {
    // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists=false
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "3");
            put("name", "Cyril");
          }
        },
        new HashMap() {
          {
            put("objectID", "4");
            put("name", "David");
          }
        }
      ),
      false
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the removeUserId method.
  //
  // removeUserId
  void snippetForRemoveUserId() throws Exception {
    // >SEPARATOR removeUserId default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.removeUserId("uniqueID");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the replaceAllObjects method.
  //
  // call replaceAllObjects without error
  void snippetForReplaceAllObjects() throws Exception {
    // >SEPARATOR replaceAllObjects default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.replaceAllObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("name", "Adam");
          }
        },
        new HashMap() {
          {
            put("objectID", "2");
            put("name", "Benoit");
          }
        },
        new HashMap() {
          {
            put("objectID", "3");
            put("name", "Cyril");
          }
        },
        new HashMap() {
          {
            put("objectID", "4");
            put("name", "David");
          }
        },
        new HashMap() {
          {
            put("objectID", "5");
            put("name", "Eva");
          }
        },
        new HashMap() {
          {
            put("objectID", "6");
            put("name", "Fiona");
          }
        },
        new HashMap() {
          {
            put("objectID", "7");
            put("name", "Gael");
          }
        },
        new HashMap() {
          {
            put("objectID", "8");
            put("name", "Hugo");
          }
        },
        new HashMap() {
          {
            put("objectID", "9");
            put("name", "Igor");
          }
        },
        new HashMap() {
          {
            put("objectID", "10");
            put("name", "Julia");
          }
        }
      ),
      3
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the replaceSources method.
  //
  // replaceSources
  void snippetForReplaceSources() throws Exception {
    // >SEPARATOR replaceSources default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.replaceSources(Arrays.asList(new Source().setSource("theSource").setDescription("theDescription")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the restoreApiKey method.
  //
  // restoreApiKey
  void snippetForRestoreApiKey() throws Exception {
    // >SEPARATOR restoreApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.restoreApiKey("ALGOLIA_API_KEY");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveObject method.
  //
  // saveObject
  void snippetForSaveObject() throws Exception {
    // >SEPARATOR saveObject default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObject(
      "<YOUR_INDEX_NAME>",
      new HashMap() {
        {
          put("objectID", "id");
          put("test", "val");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveObjects method.
  //
  // call saveObjects without error
  void snippetForSaveObjects() throws Exception {
    // >SEPARATOR saveObjects call saveObjects without error
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("name", "Adam");
          }
        },
        new HashMap() {
          {
            put("objectID", "2");
            put("name", "Benoit");
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveObjects method.
  //
  // saveObjects should report errors
  void snippetForSaveObjects1() throws Exception {
    // >SEPARATOR saveObjects saveObjects should report errors
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("name", "Adam");
          }
        },
        new HashMap() {
          {
            put("objectID", "2");
            put("name", "Benoit");
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void snippetForSaveRule() throws Exception {
    // >SEPARATOR saveRule default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "id1",
      new Rule().setObjectID("id1").setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules with minimal parameters
  void snippetForSaveRules() throws Exception {
    // >SEPARATOR saveRules default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRules(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new Rule()
          .setObjectID("a-rule-id")
          .setConditions(Arrays.asList(new Condition().setPattern("smartphone").setAnchoring(Anchoring.CONTAINS))),
        new Rule()
          .setObjectID("a-second-rule-id")
          .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
      ),
      false,
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveSynonym method.
  //
  // saveSynonym
  void snippetForSaveSynonym() throws Exception {
    // >SEPARATOR saveSynonym default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveSynonym(
      "<YOUR_INDEX_NAME>",
      "id1",
      new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(Arrays.asList("car", "vehicule", "auto")),
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveSynonyms method.
  //
  // saveSynonyms
  void snippetForSaveSynonyms() throws Exception {
    // >SEPARATOR saveSynonyms default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveSynonyms(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(Arrays.asList("car", "vehicule", "auto")),
        new SynonymHit()
          .setObjectID("id2")
          .setType(SynonymType.ONEWAYSYNONYM)
          .setInput("iphone")
          .setSynonyms(Arrays.asList("ephone", "aphone", "yphone"))
      ),
      true,
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // withHitsPerPage
  void snippetForSearch() throws Exception {
    // >SEPARATOR search withHitsPerPage
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterOnly
  void snippetForSearch1() throws Exception {
    // >SEPARATOR search filterOnly
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("actor:Scarlett Johansson")
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterOr
  void snippetForSearch2() throws Exception {
    // >SEPARATOR search filterOr
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForHits()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setQuery("<YOUR_QUERY>")
              .setFilters("actor:Tom Cruise OR actor:Scarlett Johansson")
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // filterNot
  void snippetForSearch3() throws Exception {
    // >SEPARATOR search filterNot
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("NOT actor:Nicolas Cage"))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // retrieveFacets
  void snippetForSearch4() throws Exception {
    // >SEPARATOR search retrieveFacets
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(Arrays.asList("author", "genre"))
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // retrieveFacetsWildcard
  void snippetForSearch5() throws Exception {
    // >SEPARATOR search retrieveFacetsWildcard
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(Arrays.asList("*")))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with minimal parameters
  void snippetForSearchDictionaryEntries() throws Exception {
    // >SEPARATOR searchDictionaryEntries default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchDictionaryEntries(DictionaryType.STOPWORDS, new SearchDictionaryEntriesParams().setQuery("about"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void snippetForSearchForFacetValues() throws Exception {
    // >SEPARATOR searchForFacetValues default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchForFacetValues("<YOUR_INDEX_NAME>", "facetName");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchRules method.
  //
  // searchRules
  void snippetForSearchRules() throws Exception {
    // >SEPARATOR searchRules default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchRules("<YOUR_INDEX_NAME>", new SearchRulesParams().setQuery("zorro"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with minimal parameters
  void snippetForSearchSingleIndex() throws Exception {
    // >SEPARATOR searchSingleIndex default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with minimal parameters
  void snippetForSearchSynonyms() throws Exception {
    // >SEPARATOR searchSynonyms default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSynonyms("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchUserIds method.
  //
  // searchUserIds
  void snippetForSearchUserIds() throws Exception {
    // >SEPARATOR searchUserIds default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchUserIds(new SearchUserIdsParams().setQuery("test").setClusterName("theClusterName").setPage(5).setHitsPerPage(10));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setDictionarySettings method.
  //
  // get setDictionarySettings results with minimal parameters
  void snippetForSetDictionarySettings() throws Exception {
    // >SEPARATOR setDictionarySettings default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setDictionarySettings(
      new DictionarySettingsParams()
        .setDisableStandardEntries(
          new StandardEntries()
            .setPlurals(
              new HashMap() {
                {
                  put("fr", false);
                  put("en", false);
                  put("ru", true);
                }
              }
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // setSettingsAttributesForFaceting
  void snippetForSetSettings() throws Exception {
    // >SEPARATOR setSettings default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setAttributesForFaceting(Arrays.asList("actor", "filterOnly(category)", "searchable(publisher)"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateApiKey method.
  //
  // updateApiKey
  void snippetForUpdateApiKey() throws Exception {
    // >SEPARATOR updateApiKey default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.updateApiKey(
      "ALGOLIA_API_KEY",
      new ApiKey().setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT)).setValidity(300).setMaxQueriesPerIPPerHour(100).setMaxHitsPerQuery(20)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key helper - add
  void snippetForWaitForApiKey() throws Exception {
    // >SEPARATOR waitForApiKey wait for api key helper - add
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.waitForApiKey("api-key-add-operation-test-java", ApiKeyOperation.ADD);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key - update
  void snippetForWaitForApiKey1() throws Exception {
    // >SEPARATOR waitForApiKey wait for api key - update
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.waitForApiKey(
      "api-key-update-operation-test-java",
      ApiKeyOperation.UPDATE,
      new ApiKey()
        .setDescription("my updated api key")
        .setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT, Acl.DELETE_OBJECT))
        .setIndexes(Arrays.asList("Movies", "Books"))
        .setReferers(Arrays.asList("*google.com", "*algolia.com"))
        .setValidity(305)
        .setMaxQueriesPerIPPerHour(95)
        .setMaxHitsPerQuery(20)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the waitForApiKey method.
  //
  // wait for api key - delete
  void snippetForWaitForApiKey2() throws Exception {
    // >SEPARATOR waitForApiKey wait for api key - delete
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.waitForApiKey("api-key-delete-operation-test-java", ApiKeyOperation.DELETE);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the waitForAppTask method.
  //
  // wait for an application-level task
  void snippetForWaitForAppTask() throws Exception {
    // >SEPARATOR waitForAppTask default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.waitForAppTask(123L);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the waitForTask method.
  //
  // wait for task
  void snippetForWaitForTask() throws Exception {
    // >SEPARATOR waitForTask default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.waitForTask("<YOUR_INDEX_NAME>", 123L);
    // >LOG
    // SEPARATOR<
  }
}

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
  // simple
  void snippetForAssignUserId() throws Exception {
    // >SEPARATOR assignUserId default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.assignUserId("user42", new AssignUserIdParams().setCluster("d4242-eu"));
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
  // api key basic
  void snippetForGenerateSecuredApiKey() throws Exception {
    // >SEPARATOR generateSecuredApiKey api key basic
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
  // with searchParams
  void snippetForGenerateSecuredApiKey1() throws Exception {
    // >SEPARATOR generateSecuredApiKey with searchParams
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
            .setOptionalWords(OptionalWords.of(Arrays.asList("one", "two")))
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // with filters
  void snippetForGenerateSecuredApiKey2() throws Exception {
    // >SEPARATOR generateSecuredApiKey with filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions().setFilters("user:user42 AND user:public AND (visible_by:John OR visible_by:group/Finance)")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // with visible_by filter
  void snippetForGenerateSecuredApiKey3() throws Exception {
    // >SEPARATOR generateSecuredApiKey with visible_by filter
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey(
      "2640659426d5107b6e47d75db9cbaef8",
      new SecuredApiKeyRestrictions().setFilters("visible_by:group/Finance")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // with userID
  void snippetForGenerateSecuredApiKey4() throws Exception {
    // >SEPARATOR generateSecuredApiKey with userID
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey("2640659426d5107b6e47d75db9cbaef8", new SecuredApiKeyRestrictions().setUserToken("user42"));
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
  // Partial update with a new value for an object attribute
  void snippetForPartialUpdateObject() throws Exception {
    // >SEPARATOR partialUpdateObject Partial update with a new value for an object attribute
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put(
            "attributeId",
            new HashMap() {
              {
                put("nested", "value");
              }
            }
          );
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // with visible_by filter
  void snippetForPartialUpdateObject1() throws Exception {
    // >SEPARATOR partialUpdateObject with visible_by filter
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("visible_by", Arrays.asList("Angela", "group/Finance", "group/Shareholders"));
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
    // >SEPARATOR replaceAllObjects call replaceAllObjects without error
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

  // Snippet for the replaceAllObjects method.
  //
  // call replaceAllObjects with partial scopes
  void snippetForReplaceAllObjects1() throws Exception {
    // >SEPARATOR replaceAllObjects call replaceAllObjects with partial scopes
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
        }
      ),
      77,
      Arrays.asList(ScopeType.SETTINGS, ScopeType.SYNONYMS)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the replaceAllObjects method.
  //
  // replaceAllObjects should cleanup on failure
  void snippetForReplaceAllObjects2() throws Exception {
    // >SEPARATOR replaceAllObjects replaceAllObjects should cleanup on failure
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.replaceAllObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "fine");
            put("body", "small obj");
          }
        },
        new HashMap() {
          {
            put("objectID", "toolarge");
            put("body", "something bigger than 10KB");
          }
        }
      )
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

  // Snippet for the saveObjects method.
  //
  // saveObjectsPlaylist
  void snippetForSaveObjects2() throws Exception {
    // >SEPARATOR saveObjects saveObjectsPlaylist
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("visibility", "public");
            put("name", "Hot 100 Billboard Charts");
            put("playlistId", "d3e8e8f3-0a4f-4b7d-9b6b-7e8f4e8e3a0f");
            put("createdAt", "1500240452");
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveObjects method.
  //
  // saveObjectsPublicUser
  void snippetForSaveObjects3() throws Exception {
    // >SEPARATOR saveObjects saveObjectsPublicUser
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObjects(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("visibility", "public");
            put("name", "Hot 100 Billboard Charts");
            put("playlistId", "d3e8e8f3-0a4f-4b7d-9b6b-7e8f4e8e3a0f");
            put("createdAt", "1500240452");
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // b2b catalog
  void snippetForSaveRule() throws Exception {
    // >SEPARATOR saveRule b2b catalog
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "article-rule",
      new Rule()
        .setObjectID("article-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("article").setAnchoring(Anchoring.STARTS_WITH)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("article"))))
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // merchandising and promoting
  void snippetForSaveRule1() throws Exception {
    // >SEPARATOR saveRule merchandising and promoting
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "director-rule",
      new Rule()
        .setObjectID("director-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("{facet:director} director").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
                .setAutomaticFacetFilters(
                  AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("director")))
                )
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("director"))))
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // harry potter
  void snippetForSaveRule2() throws Exception {
    // >SEPARATOR saveRule harry potter
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "harry-potter-rule",
      new Rule()
        .setObjectID("harry-potter-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("harry potter").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setUserData(
              new HashMap() {
                {
                  put("promo_content", "20% OFF on all Harry Potter books!");
                }
              }
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // merchandising empty query
  void snippetForSaveRule3() throws Exception {
    // >SEPARATOR saveRule merchandising empty query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "clearance-category-filter",
      new Rule()
        .setObjectID("clearance-category-filter")
        .setConditions(Arrays.asList(new Condition().setPattern("").setAnchoring(Anchoring.IS).setContext("landing")))
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setOptionalFilters(OptionalFilters.of("clearance:true"))))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // redirect
  void snippetForSaveRule4() throws Exception {
    // >SEPARATOR saveRule redirect
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "redirect-help-rule",
      new Rule()
        .setObjectID("redirect-help-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("help").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setUserData(
              new HashMap() {
                {
                  put("redirect", "https://www.algolia.com/support");
                }
              }
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // promote some results over others
  void snippetForSaveRule5() throws Exception {
    // >SEPARATOR saveRule promote some results over others
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "tomato-fruit",
      new Rule()
        .setObjectID("tomato-fruit")
        .setConditions(Arrays.asList(new Condition().setPattern("tomato").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setOptionalFilters(OptionalFilters.of("food_group:fruit"))))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // promote several hits
  void snippetForSaveRule6() throws Exception {
    // >SEPARATOR saveRule promote several hits
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "Promote-Apple-Newest",
      new Rule()
        .setObjectID("Promote-Apple-Newest")
        .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.IS)))
        .setConsequence(
          new Consequence()
            .setPromote(Arrays.asList(new PromoteObjectIDs().setObjectIDs(Arrays.asList("iPhone-12345", "watch-123")).setPosition(0)))
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // promote newest release
  void snippetForSaveRule7() throws Exception {
    // >SEPARATOR saveRule promote newest release
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "Promote-iPhone-X",
      new Rule()
        .setObjectID("Promote-iPhone-X")
        .setConditions(Arrays.asList(new Condition().setPattern("iPhone").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(new Consequence().setPromote(Arrays.asList(new PromoteObjectID().setObjectID("iPhone-12345").setPosition(0))))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // promote single item
  void snippetForSaveRule8() throws Exception {
    // >SEPARATOR saveRule promote single item
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "promote-harry-potter-box-set",
      new Rule()
        .setObjectID("promote-harry-potter-box-set")
        .setConditions(Arrays.asList(new Condition().setPattern("Harry Potter").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(new Consequence().setPromote(Arrays.asList(new PromoteObjectID().setObjectID("HP-12345").setPosition(0))))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // limit search results
  void snippetForSaveRule9() throws Exception {
    // >SEPARATOR saveRule limit search results
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "article-rule",
      new Rule()
        .setObjectID("article-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("article").setAnchoring(Anchoring.STARTS_WITH)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("article"))))
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // query match
  void snippetForSaveRule10() throws Exception {
    // >SEPARATOR saveRule query match
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "tagged-brand-rule",
      new Rule()
        .setConditions(
          Arrays.asList(new Condition().setPattern("brand: {facet:brand}").setAnchoring(Anchoring.CONTAINS).setAlternatives(false))
        )
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setAutomaticFacetFilters(
                  AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("brand")))
                )
                .setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("brand:", "{facet:brand}")))
            )
        )
        .setDescription("filter on brand: {brand}")
        .setObjectID("tagged-brand-rule")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // dynamic filtering
  void snippetForSaveRule11() throws Exception {
    // >SEPARATOR saveRule dynamic filtering
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "color-facets",
      new Rule()
        .setObjectID("color-facets")
        .setConditions(Arrays.asList(new Condition().setPattern("{facet:color}")))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setAutomaticFacetFilters(
                  AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("color")))
                )
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // hide hits
  void snippetForSaveRule12() throws Exception {
    // >SEPARATOR saveRule hide hits
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "hide-12345",
      new Rule()
        .setObjectID("hide-12345")
        .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(new Consequence().setHide(Arrays.asList(new ConsequenceHide().setObjectID("to-hide-12345"))))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // one rule per facet
  void snippetForSaveRule13() throws Exception {
    // >SEPARATOR saveRule one rule per facet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "red-color",
      new Rule()
        .setObjectID("red-color")
        .setConditions(Arrays.asList(new Condition().setPattern("red").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("red"))).setFilters("color:red")
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // numerical filters
  void snippetForSaveRule14() throws Exception {
    // >SEPARATOR saveRule numerical filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "cheap",
      new Rule()
        .setObjectID("cheap")
        .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("cheap"))).setFilters("price < 10")
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // negative filters
  void snippetForSaveRule15() throws Exception {
    // >SEPARATOR saveRule negative filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "gluten-free-rule",
      new Rule()
        .setObjectID("gluten-free-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("gluten-free").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setFilters("NOT allergens:gluten")
                .setQuery(
                  new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("gluten-free")))
                )
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // positive filters
  void snippetForSaveRule16() throws Exception {
    // >SEPARATOR saveRule positive filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "diet-rule",
      new Rule()
        .setObjectID("diet-rule")
        .setConditions(Arrays.asList(new Condition().setPattern("diet").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setFilters("'low-carb' OR 'low-fat'")
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("diet"))))
            )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // conditionless
  void snippetForSaveRule17() throws Exception {
    // >SEPARATOR saveRule conditionless
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "diet-rule",
      new Rule()
        .setObjectID("diet-rule")
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setFilters("'low-carb' OR 'low-fat'")
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("diet"))))
            )
        )
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
          .setConditions(Arrays.asList(new Condition().setPattern("smartphone").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:apple"))),
        new Rule()
          .setObjectID("a-second-rule-id")
          .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:samsung")))
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
  // search with searchParams
  void snippetForSearchSingleIndex() throws Exception {
    // >SEPARATOR searchSingleIndex search with searchParams
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("tags:algolia")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // query
  void snippetForSearchSingleIndex1() throws Exception {
    // >SEPARATOR searchSingleIndex query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("phone"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filters
  void snippetForSearchSingleIndex2() throws Exception {
    // >SEPARATOR searchSingleIndex filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFilters("country:US AND price.gross < 2.0"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // distinct
  void snippetForSearchSingleIndex3() throws Exception {
    // >SEPARATOR searchSingleIndex distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setDistinct(Distinct.of(true)), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersNumeric
  void snippetForSearchSingleIndex4() throws Exception {
    // >SEPARATOR searchSingleIndex filtersNumeric
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFilters("price < 10"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersTimestamp
  void snippetForSearchSingleIndex5() throws Exception {
    // >SEPARATOR searchSingleIndex filtersTimestamp
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setFilters("NOT date_timestamp:1514764800 TO 1546300799"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersSumOrFiltersScoresFalse
  void snippetForSearchSingleIndex6() throws Exception {
    // >SEPARATOR searchSingleIndex filtersSumOrFiltersScoresFalse
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFilters("(company:Google<score=3> OR company:Amazon<score=2> OR company:Facebook<score=1>)")
        .setSumOrFiltersScores(false),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersSumOrFiltersScoresTrue
  void snippetForSearchSingleIndex7() throws Exception {
    // >SEPARATOR searchSingleIndex filtersSumOrFiltersScoresTrue
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFilters("(company:Google<score=3> OR company:Amazon<score=2> OR company:Facebook<score=1>)")
        .setSumOrFiltersScores(true),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersStephenKing
  void snippetForSearchSingleIndex8() throws Exception {
    // >SEPARATOR searchSingleIndex filtersStephenKing
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFilters("author:\"Stephen King\""), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersNotTags
  void snippetForSearchSingleIndex9() throws Exception {
    // >SEPARATOR searchSingleIndex filtersNotTags
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFilters("NOT _tags:non-fiction"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersList
  void snippetForSearchSingleIndex10() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersList
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFacetFilters(
          FacetFilters.of(
            Arrays.asList(
              FacetFilters.of("publisher:Penguin"),
              FacetFilters.of(Arrays.asList(FacetFilters.of("author:Stephen King"), FacetFilters.of("genre:Horror")))
            )
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersNeg
  void snippetForSearchSingleIndex11() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersNeg
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFacetFilters(FacetFilters.of("category:-Ebook")), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filtersAndFacetFilters
  void snippetForSearchSingleIndex12() throws Exception {
    // >SEPARATOR searchSingleIndex filtersAndFacetFilters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFilters("(author:\"Stephen King\" OR genre:\"Horror\")")
        .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("publisher:Penguin")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // aroundLatLng
  void snippetForSearchSingleIndex13() throws Exception {
    // >SEPARATOR searchSingleIndex aroundLatLng
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setAroundLatLng("40.71, -74.01"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // aroundLatLngViaIP
  void snippetForSearchSingleIndex14() throws Exception {
    // >SEPARATOR searchSingleIndex aroundLatLngViaIP
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setAroundLatLngViaIP(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // aroundRadius
  void snippetForSearchSingleIndex15() throws Exception {
    // >SEPARATOR searchSingleIndex aroundRadius
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setAroundLatLng("40.71, -74.01").setAroundRadius(AroundRadius.of(1000000)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // insideBoundingBox
  void snippetForSearchSingleIndex16() throws Exception {
    // >SEPARATOR searchSingleIndex insideBoundingBox
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setInsideBoundingBox(
          InsideBoundingBox.of(Arrays.asList(Arrays.asList(49.067996905313834, 65.73828125, 25.905859247243498, 128.8046875)))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // insidePolygon
  void snippetForSearchSingleIndex17() throws Exception {
    // >SEPARATOR searchSingleIndex insidePolygon
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setInsidePolygon(
          Arrays.asList(
            Arrays.asList(
              42.01,
              -124.31,
              48.835509470063045,
              -124.40453125000005,
              45.01082951668149,
              -65.95726562500005,
              31.247243545293433,
              -81.06578125000004,
              25.924152577235226,
              -97.68234374999997,
              32.300311895879545,
              -117.54828125
            )
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // insidePolygon
  void snippetForSearchSingleIndex18() throws Exception {
    // >SEPARATOR searchSingleIndex insidePolygon
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setInsidePolygon(
          Arrays.asList(
            Arrays.asList(
              42.01,
              -124.31,
              48.835509470063045,
              -124.40453125000005,
              45.01082951668149,
              -65.95726562500005,
              31.247243545293433,
              -81.06578125000004,
              25.924152577235226,
              -97.68234374999997,
              32.300311895879545,
              -117.54828125
            )
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // optionalFilters
  void snippetForSearchSingleIndex19() throws Exception {
    // >SEPARATOR searchSingleIndex optionalFilters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("can_deliver_quickly:true")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // optionalFiltersMany
  void snippetForSearchSingleIndex20() throws Exception {
    // >SEPARATOR searchSingleIndex optionalFiltersMany
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setOptionalFilters(
          OptionalFilters.of(
            Arrays.asList(
              OptionalFilters.of("brand:Apple<score=3>"),
              OptionalFilters.of("brand:Samsung<score=2>"),
              OptionalFilters.of("brand:-Huawei")
            )
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // optionalFiltersSimple
  void snippetForSearchSingleIndex21() throws Exception {
    // >SEPARATOR searchSingleIndex optionalFiltersSimple
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setOptionalFilters(
          OptionalFilters.of(Arrays.asList(OptionalFilters.of("brand:Apple<score=2>"), OptionalFilters.of("type:tablet")))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // restrictSearchableAttributes
  void snippetForSearchSingleIndex22() throws Exception {
    // >SEPARATOR searchSingleIndex restrictSearchableAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setRestrictSearchableAttributes(Arrays.asList("title_fr")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // getRankingInfo
  void snippetForSearchSingleIndex23() throws Exception {
    // >SEPARATOR searchSingleIndex getRankingInfo
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setGetRankingInfo(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // clickAnalytics
  void snippetForSearchSingleIndex24() throws Exception {
    // >SEPARATOR searchSingleIndex clickAnalytics
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setClickAnalytics(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // clickAnalyticsUserToken
  void snippetForSearchSingleIndex25() throws Exception {
    // >SEPARATOR searchSingleIndex clickAnalyticsUserToken
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setClickAnalytics(true).setUserToken("user-1"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enablePersonalization
  void snippetForSearchSingleIndex26() throws Exception {
    // >SEPARATOR searchSingleIndex enablePersonalization
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setEnablePersonalization(true).setUserToken("user-1"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // userToken
  void snippetForSearchSingleIndex27() throws Exception {
    // >SEPARATOR searchSingleIndex userToken
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setUserToken("user-1"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // analyticsTag
  void snippetForSearchSingleIndex28() throws Exception {
    // >SEPARATOR searchSingleIndex analyticsTag
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setAnalyticsTags(Arrays.asList("YOUR_ANALYTICS_TAG")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersUsers
  void snippetForSearchSingleIndex29() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersUsers
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("user:user42"), FacetFilters.of("user:public")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // buildTheQuery
  void snippetForSearchSingleIndex30() throws Exception {
    // >SEPARATOR searchSingleIndex buildTheQuery
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setFilters("categoryPageId: Men's Clothing")
        .setHitsPerPage(50)
        .setAnalyticsTags(Arrays.asList("mens-clothing")),
      Hit.class
    );
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
  // removeStopWords boolean
  void snippetForSetSettings() throws Exception {
    // >SEPARATOR setSettings removeStopWords boolean
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setRemoveStopWords(RemoveStopWords.of(true)), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // removeStopWords list of string
  void snippetForSetSettings1() throws Exception {
    // >SEPARATOR setSettings removeStopWords list of string
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRemoveStopWords(RemoveStopWords.of(Arrays.asList(SupportedLanguage.FR))),
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // distinct company
  void snippetForSetSettings2() throws Exception {
    // >SEPARATOR setSettings distinct company
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributeForDistinct("company").setDistinct(Distinct.of(true)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // distinct design
  void snippetForSetSettings3() throws Exception {
    // >SEPARATOR setSettings distinct design
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributeForDistinct("design").setDistinct(Distinct.of(true)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // distinct true
  void snippetForSetSettings4() throws Exception {
    // >SEPARATOR setSettings distinct true
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDistinct(Distinct.of(true)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // distinct section
  void snippetForSetSettings5() throws Exception {
    // >SEPARATOR setSettings distinct section
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributeForDistinct("section").setDistinct(Distinct.of(true)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting allergens
  void snippetForSetSettings6() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting allergens
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("allergens")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting categoryPageId
  void snippetForSetSettings7() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting categoryPageId
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("searchable(categoryPageId)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // unretrievableAttributes
  void snippetForSetSettings8() throws Exception {
    // >SEPARATOR setSettings unretrievableAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setUnretrievableAttributes(Arrays.asList("visible_by")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting user restricted data
  void snippetForSetSettings9() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting user restricted data
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(visible_by)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting optional filters
  void snippetForSetSettings10() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting optional filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setAttributesForFaceting(Arrays.asList("can_deliver_quickly", "restaurant"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting redirect index
  void snippetForSetSettings11() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting redirect index
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("query_terms")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting multiple consequences
  void snippetForSetSettings12() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting multiple consequences
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("director")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting in-depth optional filters
  void snippetForSetSettings13() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting in-depth optional filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(brand)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // mode neuralSearch
  void snippetForSetSettings14() throws Exception {
    // >SEPARATOR setSettings mode neuralSearch
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMode(Mode.NEURAL_SEARCH));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // mode keywordSearch
  void snippetForSetSettings15() throws Exception {
    // >SEPARATOR setSettings mode keywordSearch
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMode(Mode.KEYWORD_SEARCH));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes same priority
  void snippetForSetSettings16() throws Exception {
    // >SEPARATOR setSettings searchableAttributes same priority
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("title,comments", "ingredients")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes higher priority
  void snippetForSetSettings17() throws Exception {
    // >SEPARATOR setSettings searchableAttributes higher priority
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("title", "ingredients")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking retweets
  void snippetForSetSettings18() throws Exception {
    // >SEPARATOR setSettings customRanking retweets
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(retweets)", "desc(likes)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking boosted
  void snippetForSetSettings19() throws Exception {
    // >SEPARATOR setSettings customRanking boosted
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(boosted)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking pageviews
  void snippetForSetSettings20() throws Exception {
    // >SEPARATOR setSettings customRanking pageviews
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(pageviews)", "desc(comments)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking applying search parameters for a specific query
  void snippetForSetSettings21() throws Exception {
    // >SEPARATOR setSettings customRanking applying search parameters for a specific query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setCustomRanking(Arrays.asList("desc(nb_airline_liaisons)"))
        .setAttributesForFaceting(Arrays.asList("city, country"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking rounded pageviews
  void snippetForSetSettings22() throws Exception {
    // >SEPARATOR setSettings customRanking rounded pageviews
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setCustomRanking(Arrays.asList("desc(rounded_pageviews)", "desc(comments)"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking price
  void snippetForSetSettings23() throws Exception {
    // >SEPARATOR setSettings customRanking price
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(price)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ranking exhaustive
  void snippetForSetSettings24() throws Exception {
    // >SEPARATOR setSettings ranking exhaustive
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setRanking(Arrays.asList("desc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ranking standard replica
  void snippetForSetSettings25() throws Exception {
    // >SEPARATOR setSettings ranking standard replica
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setRanking(Arrays.asList("desc(post_date_timestamp)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ranking virtual replica
  void snippetForSetSettings26() throws Exception {
    // >SEPARATOR setSettings ranking virtual replica
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(post_date_timestamp)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // customRanking and ranking sort alphabetically
  void snippetForSetSettings27() throws Exception {
    // >SEPARATOR setSettings customRanking and ranking sort alphabetically
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setCustomRanking(Arrays.asList("asc(textual_attribute)"))
        .setRanking(Arrays.asList("custom", "typo", "geo", "words", "filters", "proximity", "attribute", "exact"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // relevancyStrictness
  void snippetForSetSettings28() throws Exception {
    // >SEPARATOR setSettings relevancyStrictness
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setCustomRanking(Arrays.asList("asc(textual_attribute)")).setRelevancyStrictness(0)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // create replica index
  void snippetForSetSettings29() throws Exception {
    // >SEPARATOR setSettings create replica index
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setReplicas(Arrays.asList("products_price_desc")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // unlink replica index
  void snippetForSetSettings30() throws Exception {
    // >SEPARATOR setSettings unlink replica index
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setReplicas(Arrays.asList("")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // forwardToReplicas
  void snippetForSetSettings31() throws Exception {
    // >SEPARATOR setSettings forwardToReplicas
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("name", "description")), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // maxValuesPerFacet
  void snippetForSetSettings32() throws Exception {
    // >SEPARATOR setSettings maxValuesPerFacet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMaxValuesPerFacet(1000));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // maxFacetHits
  void snippetForSetSettings33() throws Exception {
    // >SEPARATOR setSettings maxFacetHits
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMaxFacetHits(1000));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting complex
  void snippetForSetSettings34() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting complex
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

  // Snippet for the setSettings method.
  //
  // ranking closest dates
  void snippetForSetSettings35() throws Exception {
    // >SEPARATOR setSettings ranking closest dates
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setRanking(Arrays.asList("asc(date_timestamp)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes item variation
  void snippetForSetSettings36() throws Exception {
    // >SEPARATOR setSettings searchableAttributes item variation
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("design", "type", "color")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes around location
  void snippetForSetSettings37() throws Exception {
    // >SEPARATOR setSettings searchableAttributes around location
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setSearchableAttributes(Arrays.asList("name", "country", "code", "iata_code"))
        .setCustomRanking(Arrays.asList("desc(links_count)"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes around location
  void snippetForSetSettings38() throws Exception {
    // >SEPARATOR setSettings searchableAttributes around location
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setSearchableAttributes(Arrays.asList("name", "country", "code", "iata_code"))
        .setCustomRanking(Arrays.asList("desc(links_count)"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disableTypoToleranceOnAttributes
  void snippetForSetSettings39() throws Exception {
    // >SEPARATOR setSettings disableTypoToleranceOnAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisableTypoToleranceOnAttributes(Arrays.asList("serial_number")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesWithCustomRankingsAndAttributesForFaceting
  void snippetForSetSettings40() throws Exception {
    // >SEPARATOR setSettings searchableAttributesWithCustomRankingsAndAttributesForFaceting
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setSearchableAttributes(Arrays.asList("brand", "name", "categories", "unordered(description)"))
        .setCustomRanking(Arrays.asList("desc(popularity)"))
        .setAttributesForFaceting(Arrays.asList("searchable(brand)", "type", "categories", "price"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesProductReferenceSuffixes
  void snippetForSetSettings41() throws Exception {
    // >SEPARATOR setSettings searchableAttributesProductReferenceSuffixes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setSearchableAttributes(Arrays.asList("name", "product_reference", "product_reference_suffixes"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // queryLanguageAndIgnorePlurals
  void snippetForSetSettings42() throws Exception {
    // >SEPARATOR setSettings queryLanguageAndIgnorePlurals
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.EN)).setIgnorePlurals(IgnorePlurals.of(true))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesInMovies
  void snippetForSetSettings43() throws Exception {
    // >SEPARATOR setSettings searchableAttributesInMovies
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setSearchableAttributes(Arrays.asList("title_eng", "title_fr", "title_es"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disablePrefixOnAttributes
  void snippetForSetSettings44() throws Exception {
    // >SEPARATOR setSettings disablePrefixOnAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisablePrefixOnAttributes(Arrays.asList("serial_number")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disableTypoToleranceOnAttributes
  void snippetForSetSettings45() throws Exception {
    // >SEPARATOR setSettings disableTypoToleranceOnAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisableTypoToleranceOnAttributes(Arrays.asList("serial_number")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesSimpleExample
  void snippetForSetSettings46() throws Exception {
    // >SEPARATOR setSettings searchableAttributesSimpleExample
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("serial_number")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesSimpleExampleAlt
  void snippetForSetSettings47() throws Exception {
    // >SEPARATOR setSettings searchableAttributesSimpleExampleAlt
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setSearchableAttributes(Arrays.asList("serial_number", "serial_number_suffixes"))
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

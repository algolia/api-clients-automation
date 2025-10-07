package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.SearchClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.search.*;
import java.util.*;

class SnippetSearchClient {

  // Snippet for the addApiKey method.
  //
  // minimal
  void snippetForAddApiKey() throws Exception {
    // >SEPARATOR addApiKey minimal
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.addApiKey(new ApiKey().setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT)).setDescription("my new api key"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the addApiKey method.
  //
  // all
  void snippetForAddApiKey1() throws Exception {
    // >SEPARATOR addApiKey all
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
    // >SEPARATOR assignUserId simple
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.assignUserId("user42", new AssignUserIdParams().setCluster("d4242-eu"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the assignUserId method.
  //
  // it should not encode the userID
  void snippetForAssignUserId1() throws Exception {
    // >SEPARATOR assignUserId it should not encode the userID
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.assignUserId("user id with spaces", new AssignUserIdParams().setCluster("cluster with spaces"));
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchWriteParams().setRequests(
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
      new BatchDictionaryEntriesParams().setRequests(
        Arrays.asList(
          new BatchDictionaryEntriesRequest()
            .setAction(DictionaryAction.ADD_ENTRY)
            .setBody(new DictionaryEntry().setObjectID("1").setLanguage(SupportedLanguage.EN).setAdditionalProperty("additional", "try me"))
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
    // >SEPARATOR browse browse with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.browse("<YOUR_INDEX_NAME>", Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the browse method.
  //
  // browse with search parameters
  void snippetForBrowse1() throws Exception {
    // >SEPARATOR browse browse with search parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.browse(
      "<YOUR_INDEX_NAME>",
      new BrowseParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("tags:algolia")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the browse method.
  //
  // browse allow a cursor in parameters
  void snippetForBrowse2() throws Exception {
    // >SEPARATOR browse browse allow a cursor in parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.browse("<YOUR_INDEX_NAME>", new BrowseParamsObject().setCursor("test"), Hit.class);
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
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "to be overriden");
        }
      },
      new RequestOptions()
        .addExtraQueryParameters("query", "parameters with space")
        .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
        .addExtraHeader("x-header-1", "spaces are left alone")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("isItWorking", true)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", 2)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList("b and c", "d"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(true, true, false))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(1, 2))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
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
    // >SEPARATOR deleteRule delete rule simple case
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteRule("<YOUR_INDEX_NAME>", "id1");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteRule method.
  //
  // delete rule with simple characters to encode in objectID
  void snippetForDeleteRule1() throws Exception {
    // >SEPARATOR deleteRule delete rule with simple characters to encode in objectID
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.deleteRule("<YOUR_INDEX_NAME>", "test/with/slash");
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

  // Snippet for the generateSecuredApiKey method.
  //
  // mcm with filters
  void snippetForGenerateSecuredApiKey5() throws Exception {
    // >SEPARATOR generateSecuredApiKey mcm with filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey("YourSearchOnlyApiKey", new SecuredApiKeyRestrictions().setFilters("user:user42 AND user:public"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the generateSecuredApiKey method.
  //
  // mcm with user token
  void snippetForGenerateSecuredApiKey6() throws Exception {
    // >SEPARATOR generateSecuredApiKey mcm with user token
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.generateSecuredApiKey("YourSearchOnlyApiKey", new SecuredApiKeyRestrictions().setUserToken("user42"));
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
    // >SEPARATOR getLogs getLogs with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getLogs();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getLogs method.
  //
  // getLogs with parameters
  void snippetForGetLogs1() throws Exception {
    // >SEPARATOR getLogs getLogs with parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getLogs(5, 10, "<YOUR_INDEX_NAME>", LogType.ALL);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObject method.
  //
  // getObject
  void snippetForGetObject() throws Exception {
    // >SEPARATOR getObject getObject
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObject("<YOUR_INDEX_NAME>", "uniqueID", Arrays.asList("attr1", "attr2"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObject method.
  //
  // search with a real object
  void snippetForGetObject1() throws Exception {
    // >SEPARATOR getObject search with a real object
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObject("<YOUR_INDEX_NAME>", "Batman and Robin");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // by ID
  void snippetForGetObjects() throws Exception {
    // >SEPARATOR getObjects by ID
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObjects(
      new GetObjectsParams().setRequests(Arrays.asList(new GetObjectsRequest().setObjectID("uniqueID").setIndexName("<YOUR_INDEX_NAME>"))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // multiple IDs
  void snippetForGetObjects1() throws Exception {
    // >SEPARATOR getObjects multiple IDs
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObjects(
      new GetObjectsParams().setRequests(
        Arrays.asList(
          new GetObjectsRequest().setObjectID("uniqueID1").setIndexName("<YOUR_INDEX_NAME>"),
          new GetObjectsRequest().setObjectID("uniqueID2").setIndexName("<YOUR_INDEX_NAME>")
        )
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getObjects method.
  //
  // with attributesToRetrieve
  void snippetForGetObjects2() throws Exception {
    // >SEPARATOR getObjects with attributesToRetrieve
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getObjects(
      new GetObjectsParams().setRequests(
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
    client.getSettings("<YOUR_INDEX_NAME>", 2);
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
    // >SEPARATOR hasPendingMappings hasPendingMappings with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.hasPendingMappings();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the hasPendingMappings method.
  //
  // hasPendingMappings with parameters
  void snippetForHasPendingMappings1() throws Exception {
    // >SEPARATOR hasPendingMappings hasPendingMappings with parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.hasPendingMappings(true);
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
    // >SEPARATOR listIndices listIndices with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listIndices();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listIndices method.
  //
  // listIndices with parameters
  void snippetForListIndices1() throws Exception {
    // >SEPARATOR listIndices listIndices with parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listIndices(8, 3);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with minimal parameters
  void snippetForListUserIds() throws Exception {
    // >SEPARATOR listUserIds listUserIds with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listUserIds();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the listUserIds method.
  //
  // listUserIds with parameters
  void snippetForListUserIds1() throws Exception {
    // >SEPARATOR listUserIds listUserIds with parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.listUserIds(8, 100);
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
      new BatchParams().setRequests(
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
    // >SEPARATOR partialUpdateObject Partial update with a new value for a string attribute
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

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for an integer attribute
  void snippetForPartialUpdateObject1() throws Exception {
    // >SEPARATOR partialUpdateObject Partial update with a new value for an integer attribute
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("attributeId", 1);
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for a boolean attribute
  void snippetForPartialUpdateObject2() throws Exception {
    // >SEPARATOR partialUpdateObject Partial update with a new value for a boolean attribute
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("attributeId", true);
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for an array attribute
  void snippetForPartialUpdateObject3() throws Exception {
    // >SEPARATOR partialUpdateObject Partial update with a new value for an array attribute
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "uniqueID",
      new HashMap() {
        {
          put("attributeId", Arrays.asList("one", "two", "three"));
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the partialUpdateObject method.
  //
  // Partial update with a new value for an object attribute
  void snippetForPartialUpdateObject4() throws Exception {
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
  void snippetForPartialUpdateObject5() throws Exception {
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

  // Snippet for the partialUpdateObject method.
  //
  // add men pant
  void snippetForPartialUpdateObject6() throws Exception {
    // >SEPARATOR partialUpdateObject add men pant
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "productId",
      new HashMap() {
        {
          put(
            "categoryPageId",
            new HashMap() {
              {
                put("_operation", "Add");
                put("value", "men-clothing-pants");
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
  // remove men pant
  void snippetForPartialUpdateObject7() throws Exception {
    // >SEPARATOR partialUpdateObject remove men pant
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObject(
      "<YOUR_INDEX_NAME>",
      "productId",
      new HashMap() {
        {
          put(
            "categoryPageId",
            new HashMap() {
              {
                put("_operation", "Remove");
                put("value", "men-clothing-pants");
              }
            }
          );
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

  // Snippet for the partialUpdateObjectsWithTransformation method.
  //
  // call partialUpdateObjectsWithTransformation with createIfNotExists=true
  void snippetForPartialUpdateObjectsWithTransformation() throws Exception {
    // >SEPARATOR partialUpdateObjectsWithTransformation default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.partialUpdateObjectsWithTransformation(
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
      true,
      true
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

  // Snippet for the replaceAllObjectsWithTransformation method.
  //
  // call replaceAllObjectsWithTransformation without error
  void snippetForReplaceAllObjectsWithTransformation() throws Exception {
    // >SEPARATOR replaceAllObjectsWithTransformation default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.replaceAllObjectsWithTransformation(
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
          put("name", "Black T-shirt");
          put("color", "#000000||black");
          put("availableIn", "https://source.unsplash.com/100x100/?paris||Paris");
          put("objectID", "myID");
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
      ),
      false,
      1000,
      new RequestOptions().addExtraHeader("X-Algolia-User-ID", "*")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveObjectsWithTransformation method.
  //
  // call saveObjectsWithTransformation without error
  void snippetForSaveObjectsWithTransformation() throws Exception {
    // >SEPARATOR saveObjectsWithTransformation default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveObjectsWithTransformation(
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

  // Snippet for the saveRule method.
  //
  // saveRule with minimal parameters
  void snippetForSaveRule() throws Exception {
    // >SEPARATOR saveRule saveRule with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "id1",
      new Rule()
        .setObjectID("id1")
        .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:xiaomi")))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // saveRule with all parameters
  void snippetForSaveRule1() throws Exception {
    // >SEPARATOR saveRule saveRule with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "id1",
      new Rule()
        .setObjectID("id1")
        .setConditions(
          Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS).setAlternatives(false).setContext("search"))
        )
        .setConsequence(
          new Consequence()
            .setParams(
              new ConsequenceParams()
                .setFilters("brand:apple")
                .setQuery(
                  new ConsequenceQueryObject()
                    .setRemove(Arrays.asList("algolia"))
                    .setEdits(
                      Arrays.asList(
                        new Edit().setType(EditType.REMOVE).setDelete("abc").setInsert("cde"),
                        new Edit().setType(EditType.REPLACE).setDelete("abc").setInsert("cde")
                      )
                    )
                )
            )
            .setHide(Arrays.asList(new ConsequenceHide().setObjectID("321")))
            .setFilterPromotes(false)
            .setUserData(
              new HashMap() {
                {
                  put("algolia", "aloglia");
                }
              }
            )
            .setPromote(
              Arrays.asList(
                new PromoteObjectID().setObjectID("abc").setPosition(3),
                new PromoteObjectIDs().setObjectIDs(Arrays.asList("abc", "def")).setPosition(1)
              )
            )
        )
        .setDescription("test")
        .setEnabled(true)
        .setValidity(Arrays.asList(new TimeRange().setFrom(1656670273L).setUntil(1656670277L))),
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // b2b catalog
  void snippetForSaveRule2() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule3() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule4() throws Exception {
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
          new Consequence().setUserData(
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
  void snippetForSaveRule5() throws Exception {
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
  void snippetForSaveRule6() throws Exception {
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
          new Consequence().setUserData(
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
  void snippetForSaveRule7() throws Exception {
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
  void snippetForSaveRule8() throws Exception {
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
          new Consequence().setPromote(
            Arrays.asList(new PromoteObjectIDs().setObjectIDs(Arrays.asList("iPhone-12345", "watch-123")).setPosition(0))
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // promote newest release
  void snippetForSaveRule9() throws Exception {
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
  void snippetForSaveRule10() throws Exception {
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
  void snippetForSaveRule11() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule12() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule13() throws Exception {
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
          new Consequence().setParams(
            new ConsequenceParams().setAutomaticFacetFilters(
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
  void snippetForSaveRule14() throws Exception {
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
  void snippetForSaveRule15() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule16() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule17() throws Exception {
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
          new Consequence().setParams(
            new ConsequenceParams()
              .setFilters("NOT allergens:gluten")
              .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("gluten-free"))))
          )
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // positive filters
  void snippetForSaveRule18() throws Exception {
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
          new Consequence().setParams(
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
  void snippetForSaveRule19() throws Exception {
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
          new Consequence().setParams(
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
  // contextual
  void snippetForSaveRule20() throws Exception {
    // >SEPARATOR saveRule contextual
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "a-rule-id",
      new Rule()
        .setObjectID("a-rule-id")
        .setConditions(Arrays.asList(new Condition().setContext("mobile")))
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("release_date >= 1577836800")))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // saveRule always active rule
  void snippetForSaveRule21() throws Exception {
    // >SEPARATOR saveRule saveRule always active rule
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "a-rule-id",
      new Rule()
        .setObjectID("a-rule-id")
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundRadius(AroundRadius.of(1000))))
        .setValidity(Arrays.asList(new TimeRange().setFrom(1577836800L).setUntil(1577836800L)))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRule method.
  //
  // one sided validity
  void snippetForSaveRule22() throws Exception {
    // >SEPARATOR saveRule one sided validity
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRule(
      "<YOUR_INDEX_NAME>",
      "a-rule-id",
      new Rule()
        .setObjectID("a-rule-id")
        .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundRadius(AroundRadius.of(1000))))
        .setValidity(Arrays.asList(new TimeRange().setFrom(1577836800L)))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules with minimal parameters
  void snippetForSaveRules() throws Exception {
    // >SEPARATOR saveRules saveRules with minimal parameters
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

  // Snippet for the saveRules method.
  //
  // saveRules with all parameters
  void snippetForSaveRules1() throws Exception {
    // >SEPARATOR saveRules saveRules with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRules(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new Rule()
          .setObjectID("id1")
          .setConditions(
            Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS).setAlternatives(false).setContext("search"))
          )
          .setConsequence(
            new Consequence()
              .setParams(
                new ConsequenceParams()
                  .setFilters("brand:apple")
                  .setQuery(
                    new ConsequenceQueryObject()
                      .setRemove(Arrays.asList("algolia"))
                      .setEdits(
                        Arrays.asList(
                          new Edit().setType(EditType.REMOVE).setDelete("abc").setInsert("cde"),
                          new Edit().setType(EditType.REPLACE).setDelete("abc").setInsert("cde")
                        )
                      )
                  )
              )
              .setHide(Arrays.asList(new ConsequenceHide().setObjectID("321")))
              .setFilterPromotes(false)
              .setUserData(
                new HashMap() {
                  {
                    put("algolia", "aloglia");
                  }
                }
              )
              .setPromote(
                Arrays.asList(
                  new PromoteObjectID().setObjectID("abc").setPosition(3),
                  new PromoteObjectIDs().setObjectIDs(Arrays.asList("abc", "def")).setPosition(1)
                )
              )
          )
          .setDescription("test")
          .setEnabled(true)
          .setValidity(Arrays.asList(new TimeRange().setFrom(1656670273L).setUntil(1656670277L)))
      ),
      true,
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // dynamic filtering
  void snippetForSaveRules2() throws Exception {
    // >SEPARATOR saveRules dynamic filtering
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRules(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new Rule()
          .setObjectID("toaster")
          .setConditions(Arrays.asList(new Condition().setPattern("toaster").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("toaster")))
                .setFilters("product_type:toaster")
            )
          ),
        new Rule()
          .setObjectID("cheap")
          .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("cheap"))).setFilters("price < 15")
            )
          )
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // enhance search results
  void snippetForSaveRules3() throws Exception {
    // >SEPARATOR saveRules enhance search results
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.saveRules(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new Rule()
          .setObjectID("country")
          .setConditions(Arrays.asList(new Condition().setPattern("{facet:country}").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundLatLngViaIP(false))),
        new Rule()
          .setObjectID("city")
          .setConditions(Arrays.asList(new Condition().setPattern("{facet:city}").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundLatLngViaIP(false)))
      )
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
      new SearchMethodParams().setRequests(
        Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))
      ),
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
      new SearchMethodParams().setRequests(
        Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("actor:Scarlett Johansson"))
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
      new SearchMethodParams().setRequests(
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
      new SearchMethodParams().setRequests(
        Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("NOT actor:Nicolas Cage"))
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for a single hits request with minimal parameters
  void snippetForSearch4() throws Exception {
    // >SEPARATOR search search for a single hits request with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(new SearchMethodParams().setRequests(Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>"))), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search with highlight and snippet results
  void snippetForSearch5() throws Exception {
    // >SEPARATOR search search with highlight and snippet results
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setQuery("vim")
            .setAttributesToSnippet(Arrays.asList("*:20"))
            .setAttributesToHighlight(Arrays.asList("*"))
            .setAttributesToRetrieve(Arrays.asList("*"))
        )
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // retrieveFacets
  void snippetForSearch6() throws Exception {
    // >SEPARATOR search retrieveFacets
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
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
  void snippetForSearch7() throws Exception {
    // >SEPARATOR search retrieveFacetsWildcard
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(Arrays.asList("*")))
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for a single facet request with minimal parameters
  void snippetForSearch8() throws Exception {
    // >SEPARATOR search search for a single facet request with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(new SearchForFacets().setIndexName("<YOUR_INDEX_NAME>").setType(SearchTypeFacet.FACET).setFacet("editor"))
        )
        .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for a single hits request with all parameters
  void snippetForSearch9() throws Exception {
    // >SEPARATOR search search for a single hits request with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("myQuery").setHitsPerPage(50).setType(SearchTypeDefault.DEFAULT)
        )
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for a single facet request with all parameters
  void snippetForSearch10() throws Exception {
    // >SEPARATOR search search for a single facet request with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForFacets()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setType(SearchTypeFacet.FACET)
              .setFacet("theFacet")
              .setFacetQuery("theFacetQuery")
              .setQuery("theQuery")
              .setMaxFacetHits(50)
          )
        )
        .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for multiple mixed requests in multiple indices with minimal parameters
  void snippetForSearch11() throws Exception {
    // >SEPARATOR search search for multiple mixed requests in multiple indices with minimal
    // parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForHits().setIndexName("<YOUR_INDEX_NAME>"),
            new SearchForFacets().setIndexName("<YOUR_INDEX_NAME>").setType(SearchTypeFacet.FACET).setFacet("theFacet"),
            new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setType(SearchTypeDefault.DEFAULT)
          )
        )
        .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search for multiple mixed requests in multiple indices with all parameters
  void snippetForSearch12() throws Exception {
    // >SEPARATOR search search for multiple mixed requests in multiple indices with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(
            new SearchForFacets()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setType(SearchTypeFacet.FACET)
              .setFacet("theFacet")
              .setFacetQuery("theFacetQuery")
              .setQuery("theQuery")
              .setMaxFacetHits(50),
            new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("myQuery").setHitsPerPage(50).setType(SearchTypeDefault.DEFAULT)
          )
        )
        .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search filters accept all of the possible shapes
  void snippetForSearch13() throws Exception {
    // >SEPARATOR search search filters accept all of the possible shapes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setFacetFilters(FacetFilters.of("mySearch:filters"))
            .setReRankingApplyFilter(ReRankingApplyFilter.of("mySearch:filters"))
            .setTagFilters(TagFilters.of("mySearch:filters"))
            .setNumericFilters(NumericFilters.of("mySearch:filters"))
            .setOptionalFilters(OptionalFilters.of("mySearch:filters")),
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setFacetFilters(
              FacetFilters.of(
                Arrays.asList(
                  FacetFilters.of("mySearch:filters"),
                  FacetFilters.of(
                    Arrays.asList(FacetFilters.of("mySearch:filters"), FacetFilters.of(Arrays.asList(FacetFilters.of("mySearch:filters"))))
                  )
                )
              )
            )
            .setReRankingApplyFilter(
              ReRankingApplyFilter.of(
                Arrays.asList(
                  ReRankingApplyFilter.of("mySearch:filters"),
                  ReRankingApplyFilter.of(Arrays.asList(ReRankingApplyFilter.of("mySearch:filters")))
                )
              )
            )
            .setTagFilters(
              TagFilters.of(
                Arrays.asList(TagFilters.of("mySearch:filters"), TagFilters.of(Arrays.asList(TagFilters.of("mySearch:filters"))))
              )
            )
            .setNumericFilters(
              NumericFilters.of(
                Arrays.asList(
                  NumericFilters.of("mySearch:filters"),
                  NumericFilters.of(Arrays.asList(NumericFilters.of("mySearch:filters")))
                )
              )
            )
            .setOptionalFilters(
              OptionalFilters.of(
                Arrays.asList(
                  OptionalFilters.of("mySearch:filters"),
                  OptionalFilters.of(Arrays.asList(OptionalFilters.of("mySearch:filters")))
                )
              )
            )
        )
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search filters end to end
  void snippetForSearch14() throws Exception {
    // >SEPARATOR search search filters end to end
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setFilters("editor:'visual studio' OR editor:neovim"),
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of("editor:neovim")))),
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setFacetFilters(
              FacetFilters.of(
                Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of(Arrays.asList(FacetFilters.of("editor:neovim"))))
              )
            ),
          new SearchForHits()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setFacetFilters(
              FacetFilters.of(
                Arrays.asList(
                  FacetFilters.of("editor:'visual studio'"),
                  FacetFilters.of(
                    Arrays.asList(FacetFilters.of("editor:neovim"), FacetFilters.of(Arrays.asList(FacetFilters.of("editor:goland"))))
                  )
                )
              )
            )
        )
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search with all search parameters
  void snippetForSearch15() throws Exception {
    // >SEPARATOR search search with all search parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits()
            .setAdvancedSyntax(true)
            .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE))
            .setAllowTyposOnNumericTokens(true)
            .setAlternativesAsExact(Arrays.asList(AlternativesAsExact.MULTI_WORDS_SYNONYM))
            .setAnalytics(true)
            .setAnalyticsTags(Arrays.asList(""))
            .setAroundLatLng("")
            .setAroundLatLngViaIP(true)
            .setAroundPrecision(AroundPrecision.of(0))
            .setAroundRadius(AroundRadiusAll.ALL)
            .setAttributeCriteriaComputedByMinProximity(true)
            .setAttributesToHighlight(Arrays.asList(""))
            .setAttributesToRetrieve(Arrays.asList(""))
            .setAttributesToSnippet(Arrays.asList(""))
            .setClickAnalytics(true)
            .setDecompoundQuery(true)
            .setDisableExactOnAttributes(Arrays.asList(""))
            .setDisableTypoToleranceOnAttributes(Arrays.asList(""))
            .setDistinct(Distinct.of(0))
            .setEnableABTest(true)
            .setEnablePersonalization(true)
            .setEnableReRanking(true)
            .setEnableRules(true)
            .setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE)
            .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of(""))))
            .setFacetingAfterDistinct(true)
            .setFacets(Arrays.asList(""))
            .setFilters("")
            .setGetRankingInfo(true)
            .setHighlightPostTag("")
            .setHighlightPreTag("")
            .setHitsPerPage(1)
            .setIgnorePlurals(IgnorePlurals.of(false))
            .setIndexName("<YOUR_INDEX_NAME>")
            .setInsideBoundingBox(
              InsideBoundingBox.of(
                Arrays.asList(Arrays.asList(47.3165, 4.9665, 47.3424, 5.0201), Arrays.asList(40.9234, 2.1185, 38.643, 1.9916))
              )
            )
            .setInsidePolygon(
              Arrays.asList(
                Arrays.asList(47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9),
                Arrays.asList(40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104)
              )
            )
            .setLength(1)
            .setMaxValuesPerFacet(0)
            .setMinProximity(1)
            .setMinWordSizefor1Typo(0)
            .setMinWordSizefor2Typos(0)
            .setMinimumAroundRadius(1)
            .setNaturalLanguages(Arrays.asList(SupportedLanguage.FR))
            .setNumericFilters(NumericFilters.of(Arrays.asList(NumericFilters.of(""))))
            .setOffset(0)
            .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of(""))))
            .setOptionalWords(OptionalWords.of(Arrays.asList("")))
            .setPage(0)
            .setPercentileComputation(true)
            .setPersonalizationImpact(0)
            .setQuery("")
            .setQueryLanguages(Arrays.asList(SupportedLanguage.FR))
            .setQueryType(QueryType.PREFIX_ALL)
            .setRanking(Arrays.asList(""))
            .setReRankingApplyFilter(ReRankingApplyFilter.of(Arrays.asList(ReRankingApplyFilter.of(""))))
            .setRelevancyStrictness(0)
            .setRemoveStopWords(RemoveStopWords.of(true))
            .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.ALL_OPTIONAL)
            .setRenderingContent(
              new RenderingContent().setFacetOrdering(
                new FacetOrdering()
                  .setFacets(new Facets().setOrder(Arrays.asList("a", "b")))
                  .setValues(
                    new HashMap() {
                      {
                        put("a", new Value().setOrder(Arrays.asList("b")).setSortRemainingBy(SortRemainingBy.COUNT));
                      }
                    }
                  )
              )
            )
            .setReplaceSynonymsInHighlight(true)
            .setResponseFields(Arrays.asList(""))
            .setRestrictHighlightAndSnippetArrays(true)
            .setRestrictSearchableAttributes(Arrays.asList(""))
            .setRuleContexts(Arrays.asList(""))
            .setSimilarQuery("")
            .setSnippetEllipsisText("")
            .setSortFacetValuesBy("")
            .setSumOrFiltersScores(true)
            .setSynonyms(true)
            .setTagFilters(TagFilters.of(Arrays.asList(TagFilters.of(""))))
            .setType(SearchTypeDefault.DEFAULT)
            .setTypoTolerance(TypoToleranceEnum.MIN)
            .setUserToken("")
        )
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
    // >SEPARATOR searchDictionaryEntries get searchDictionaryEntries results with minimal
    // parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchDictionaryEntries(DictionaryType.STOPWORDS, new SearchDictionaryEntriesParams().setQuery("about"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchDictionaryEntries method.
  //
  // get searchDictionaryEntries results with all parameters
  void snippetForSearchDictionaryEntries1() throws Exception {
    // >SEPARATOR searchDictionaryEntries get searchDictionaryEntries results with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchDictionaryEntries(
      DictionaryType.COMPOUNDS,
      new SearchDictionaryEntriesParams().setQuery("foo").setPage(4).setHitsPerPage(2).setLanguage(SupportedLanguage.FR)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with minimal parameters
  void snippetForSearchForFacetValues() throws Exception {
    // >SEPARATOR searchForFacetValues get searchForFacetValues results with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchForFacetValues("<YOUR_INDEX_NAME>", "facetName");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // get searchForFacetValues results with all parameters
  void snippetForSearchForFacetValues1() throws Exception {
    // >SEPARATOR searchForFacetValues get searchForFacetValues results with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchForFacetValues(
      "<YOUR_INDEX_NAME>",
      "facetName",
      new SearchForFacetValuesRequest().setParams("query=foo&facetFilters=['bar']").setFacetQuery("foo").setMaxFacetHits(42)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // facetName and facetQuery
  void snippetForSearchForFacetValues2() throws Exception {
    // >SEPARATOR searchForFacetValues facetName and facetQuery
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchForFacetValues("<YOUR_INDEX_NAME>", "author", new SearchForFacetValuesRequest().setFacetQuery("stephen"));
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
    // >SEPARATOR searchSingleIndex search with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with special characters in indexName
  void snippetForSearchSingleIndex1() throws Exception {
    // >SEPARATOR searchSingleIndex search with special characters in indexName
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search with searchParams
  void snippetForSearchSingleIndex2() throws Exception {
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
  // single search retrieve snippets
  void snippetForSearchSingleIndex3() throws Exception {
    // >SEPARATOR searchSingleIndex single search retrieve snippets
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("batman mask of the phantasm")
        .setAttributesToRetrieve(Arrays.asList("*"))
        .setAttributesToSnippet(Arrays.asList("*:20")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // query
  void snippetForSearchSingleIndex4() throws Exception {
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
  void snippetForSearchSingleIndex5() throws Exception {
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
  // filters for stores
  void snippetForSearchSingleIndex6() throws Exception {
    // >SEPARATOR searchSingleIndex filters for stores
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("ben").setFilters("categories:politics AND store:Gibert Joseph Saint-Michel"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // filters boolean
  void snippetForSearchSingleIndex7() throws Exception {
    // >SEPARATOR searchSingleIndex filters boolean
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFilters("is_available:true"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // distinct
  void snippetForSearchSingleIndex8() throws Exception {
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
  void snippetForSearchSingleIndex9() throws Exception {
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
  void snippetForSearchSingleIndex10() throws Exception {
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
  void snippetForSearchSingleIndex11() throws Exception {
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
  void snippetForSearchSingleIndex12() throws Exception {
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
  void snippetForSearchSingleIndex13() throws Exception {
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
  void snippetForSearchSingleIndex14() throws Exception {
    // >SEPARATOR searchSingleIndex filtersNotTags
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("harry").setFilters("_tags:non-fiction"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersList
  void snippetForSearchSingleIndex15() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersList
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setFacetFilters(
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
  // facetFiltersBook
  void snippetForSearchSingleIndex16() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersBook
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersAND
  void snippetForSearchSingleIndex17() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersAND
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("author:John Doe")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersOR
  void snippetForSearchSingleIndex18() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersOR
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setFacetFilters(
          FacetFilters.of(
            Arrays.asList(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("author:John Doe"))))
          )
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facetFiltersCombined
  void snippetForSearchSingleIndex19() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersCombined
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setFacetFilters(
          FacetFilters.of(
            Arrays.asList(
              FacetFilters.of("author:John Doe"),
              FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("category:Movie")))
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
  void snippetForSearchSingleIndex20() throws Exception {
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
  void snippetForSearchSingleIndex21() throws Exception {
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
  // facet author genre
  void snippetForSearchSingleIndex22() throws Exception {
    // >SEPARATOR searchSingleIndex facet author genre
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFacets(Arrays.asList("author", "genre")), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facet wildcard
  void snippetForSearchSingleIndex23() throws Exception {
    // >SEPARATOR searchSingleIndex facet wildcard
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setFacets(Arrays.asList("*")), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // maxValuesPerFacet
  void snippetForSearchSingleIndex24() throws Exception {
    // >SEPARATOR searchSingleIndex maxValuesPerFacet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setMaxValuesPerFacet(1000), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // aroundLatLng
  void snippetForSearchSingleIndex25() throws Exception {
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
  void snippetForSearchSingleIndex26() throws Exception {
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
  void snippetForSearchSingleIndex27() throws Exception {
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
  void snippetForSearchSingleIndex28() throws Exception {
    // >SEPARATOR searchSingleIndex insideBoundingBox
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setInsideBoundingBox(
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
  void snippetForSearchSingleIndex29() throws Exception {
    // >SEPARATOR searchSingleIndex insidePolygon
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setInsidePolygon(
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
  void snippetForSearchSingleIndex30() throws Exception {
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
  void snippetForSearchSingleIndex31() throws Exception {
    // >SEPARATOR searchSingleIndex optionalFiltersMany
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setOptionalFilters(
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
  void snippetForSearchSingleIndex32() throws Exception {
    // >SEPARATOR searchSingleIndex optionalFiltersSimple
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setOptionalFilters(
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
  void snippetForSearchSingleIndex33() throws Exception {
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
  void snippetForSearchSingleIndex34() throws Exception {
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
  void snippetForSearchSingleIndex35() throws Exception {
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
  void snippetForSearchSingleIndex36() throws Exception {
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
  void snippetForSearchSingleIndex37() throws Exception {
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
  void snippetForSearchSingleIndex38() throws Exception {
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
  // userToken1234
  void snippetForSearchSingleIndex39() throws Exception {
    // >SEPARATOR searchSingleIndex userToken1234
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setUserToken("user-1234"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // analyticsTag
  void snippetForSearchSingleIndex40() throws Exception {
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
  void snippetForSearchSingleIndex41() throws Exception {
    // >SEPARATOR searchSingleIndex facetFiltersUsers
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setFacetFilters(
        FacetFilters.of(Arrays.asList(FacetFilters.of("user:user42"), FacetFilters.of("user:public")))
      ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // buildTheQuery
  void snippetForSearchSingleIndex42() throws Exception {
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

  // Snippet for the searchSingleIndex method.
  //
  // attributesToHighlightOverride
  void snippetForSearchSingleIndex43() throws Exception {
    // >SEPARATOR searchSingleIndex attributesToHighlightOverride
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAttributesToHighlight(Arrays.asList("title", "content")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disableTypoToleranceOnAttributes
  void snippetForSearchSingleIndex44() throws Exception {
    // >SEPARATOR searchSingleIndex disableTypoToleranceOnAttributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setDisableTypoToleranceOnAttributes(Arrays.asList("serial_number")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // similarQuery
  void snippetForSearchSingleIndex45() throws Exception {
    // >SEPARATOR searchSingleIndex similarQuery
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("shirt"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_everything
  void snippetForSearchSingleIndex46() throws Exception {
    // >SEPARATOR searchSingleIndex search_everything
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery(""), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // api_filtering_range_example
  void snippetForSearchSingleIndex47() throws Exception {
    // >SEPARATOR searchSingleIndex api_filtering_range_example
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("books").setFilters("price:10 TO 20"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_a_query
  void snippetForSearchSingleIndex48() throws Exception {
    // >SEPARATOR searchSingleIndex search_a_query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("")
        .setSimilarQuery("Comedy Drama Crime McDormand Macy Buscemi Stormare Presnell Coen")
        .setFilters("year:1991 TO 2001"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_retrievable_attributes
  void snippetForSearchSingleIndex49() throws Exception {
    // >SEPARATOR searchSingleIndex override_retrievable_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAttributesToRetrieve(Arrays.asList("title", "content")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // restrict_searchable_attributes
  void snippetForSearchSingleIndex50() throws Exception {
    // >SEPARATOR searchSingleIndex restrict_searchable_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setRestrictSearchableAttributes(Arrays.asList("title", "author")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_relevancy
  void snippetForSearchSingleIndex51() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_relevancy
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setRelevancyStrictness(70), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_filters
  void snippetForSearchSingleIndex52() throws Exception {
    // >SEPARATOR searchSingleIndex apply_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFilters("(category:Book OR category:Ebook) AND _tags:published"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_all_filters
  void snippetForSearchSingleIndex53() throws Exception {
    // >SEPARATOR searchSingleIndex apply_all_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setFilters(
          "available = 1 AND (category:Book OR NOT category:Ebook) AND _tags:published AND" +
            " publication_date:1441745506 TO 1441755506 AND inStock > 0 AND author:\"John" +
            " Doe\""
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // escape_spaces
  void snippetForSearchSingleIndex54() throws Exception {
    // >SEPARATOR searchSingleIndex escape_spaces
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFilters("category:\"Books and Comics\""),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // escape_keywords
  void snippetForSearchSingleIndex55() throws Exception {
    // >SEPARATOR searchSingleIndex escape_keywords
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setFilters("keyword:\"OR\""), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // escape_single_quotes
  void snippetForSearchSingleIndex56() throws Exception {
    // >SEPARATOR searchSingleIndex escape_single_quotes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFilters("content:\"It's a wonderful day\""),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // escape_double_quotes
  void snippetForSearchSingleIndex57() throws Exception {
    // >SEPARATOR searchSingleIndex escape_double_quotes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFilters("content:\"She said \"Hello World\""),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_optional_filters
  void snippetForSearchSingleIndex58() throws Exception {
    // >SEPARATOR searchSingleIndex apply_optional_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("category:Book"), OptionalFilters.of("author:John Doe")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_negative_filters
  void snippetForSearchSingleIndex59() throws Exception {
    // >SEPARATOR searchSingleIndex apply_negative_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("category:Book"), OptionalFilters.of("author:-John Doe")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_negative_filters_restaurants
  void snippetForSearchSingleIndex60() throws Exception {
    // >SEPARATOR searchSingleIndex apply_negative_filters_restaurants
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("restaurant:-Bert's Inn")))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // apply_numeric_filters
  void snippetForSearchSingleIndex61() throws Exception {
    // >SEPARATOR searchSingleIndex apply_numeric_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setNumericFilters(
          NumericFilters.of(
            Arrays.asList(
              NumericFilters.of("price < 1000"),
              NumericFilters.of(Arrays.asList(NumericFilters.of("inStock = 1"), NumericFilters.of("deliveryDate < 1441755506")))
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
  // apply_tag_filters
  void snippetForSearchSingleIndex62() throws Exception {
    // >SEPARATOR searchSingleIndex apply_tag_filters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setTagFilters(
          TagFilters.of(Arrays.asList(TagFilters.of("SciFi"), TagFilters.of(Arrays.asList(TagFilters.of("Book"), TagFilters.of("Movie")))))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_sum_or_filters_scores
  void snippetForSearchSingleIndex63() throws Exception {
    // >SEPARATOR searchSingleIndex set_sum_or_filters_scores
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setSumOrFiltersScores(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // facets_all
  void snippetForSearchSingleIndex64() throws Exception {
    // >SEPARATOR searchSingleIndex facets_all
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setFacets(Arrays.asList("*")), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // retrieve_only_some_facets
  void snippetForSearchSingleIndex65() throws Exception {
    // >SEPARATOR searchSingleIndex retrieve_only_some_facets
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setFacets(Arrays.asList("category", "author")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_max_values_per_facet
  void snippetForSearchSingleIndex66() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_max_values_per_facet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setMaxValuesPerFacet(20), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_faceting_after_distinct
  void snippetForSearchSingleIndex67() throws Exception {
    // >SEPARATOR searchSingleIndex enable_faceting_after_distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setFacetingAfterDistinct(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // sort_facet_values_alphabetically
  void snippetForSearchSingleIndex68() throws Exception {
    // >SEPARATOR searchSingleIndex sort_facet_values_alphabetically
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setSortFacetValuesBy("count"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_attributes_to_snippet
  void snippetForSearchSingleIndex69() throws Exception {
    // >SEPARATOR searchSingleIndex override_attributes_to_snippet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAttributesToSnippet(Arrays.asList("title", "content:80")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_highlight_pre_tag
  void snippetForSearchSingleIndex70() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_highlight_pre_tag
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setHighlightPreTag("<strong>"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_highlight_post_tag
  void snippetForSearchSingleIndex71() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_highlight_post_tag
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setHighlightPostTag("</strong>"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_snippet_ellipsis_text
  void snippetForSearchSingleIndex72() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_snippet_ellipsis_text
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setSnippetEllipsisText(""), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_restrict_highlight_and_snippet_arrays
  void snippetForSearchSingleIndex73() throws Exception {
    // >SEPARATOR searchSingleIndex enable_restrict_highlight_and_snippet_arrays
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setRestrictHighlightAndSnippetArrays(false),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // access_page
  void snippetForSearchSingleIndex74() throws Exception {
    // >SEPARATOR searchSingleIndex access_page
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setPage(0), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_hits_per_page
  void snippetForSearchSingleIndex75() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_hits_per_page
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setHitsPerPage(10), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // get_nth_hit
  void snippetForSearchSingleIndex76() throws Exception {
    // >SEPARATOR searchSingleIndex get_nth_hit
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setOffset(4), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // get_n_results
  void snippetForSearchSingleIndex77() throws Exception {
    // >SEPARATOR searchSingleIndex get_n_results
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setLength(4), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_min_word_size_for_one_typo
  void snippetForSearchSingleIndex78() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_min_word_size_for_one_typo
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setMinWordSizefor1Typo(2), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_min_word_size_for_two_typos
  void snippetForSearchSingleIndex79() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_min_word_size_for_two_typos
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setMinWordSizefor2Typos(2), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_typo_tolerance_mode
  void snippetForSearchSingleIndex80() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_typo_tolerance_mode
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setTypoTolerance(TypoTolerance.of(false)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disable_typos_on_numeric_tokens_at_search_time
  void snippetForSearchSingleIndex81() throws Exception {
    // >SEPARATOR searchSingleIndex disable_typos_on_numeric_tokens_at_search_time
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAllowTyposOnNumericTokens(false),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_around_a_position
  void snippetForSearchSingleIndex82() throws Exception {
    // >SEPARATOR searchSingleIndex search_around_a_position
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setAroundLatLng("40.71, -74.01"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_around_server_ip
  void snippetForSearchSingleIndex83() throws Exception {
    // >SEPARATOR searchSingleIndex search_around_server_ip
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAroundLatLngViaIP(true),
      Hit.class,
      new RequestOptions().addExtraHeader(
        "x-forwarded-for",
        "94.228.178.246 // should be replaced with the actual IP you would like to search" + " around"
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_around_radius
  void snippetForSearchSingleIndex84() throws Exception {
    // >SEPARATOR searchSingleIndex set_around_radius
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAroundRadius(AroundRadius.of(1000)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disable_automatic_radius
  void snippetForSearchSingleIndex85() throws Exception {
    // >SEPARATOR searchSingleIndex disable_automatic_radius
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAroundRadius(AroundRadiusAll.ALL),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_geo_search_precision
  void snippetForSearchSingleIndex86() throws Exception {
    // >SEPARATOR searchSingleIndex set_geo_search_precision
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAroundPrecision(AroundPrecision.of(100)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_geo_search_precision_non_linear
  void snippetForSearchSingleIndex87() throws Exception {
    // >SEPARATOR searchSingleIndex set_geo_search_precision_non_linear
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setAroundPrecision(
          AroundPrecision.of(Arrays.asList(new Range().setFrom(0).setValue(25), new Range().setFrom(2000).setValue(1000)))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_minimum_geo_search_radius
  void snippetForSearchSingleIndex88() throws Exception {
    // >SEPARATOR searchSingleIndex set_minimum_geo_search_radius
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setMinimumAroundRadius(1000), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_inside_rectangular_area
  void snippetForSearchSingleIndex89() throws Exception {
    // >SEPARATOR searchSingleIndex search_inside_rectangular_area
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setInsideBoundingBox(
          InsideBoundingBox.of(Arrays.asList(Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625)))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_inside_multiple_rectangular_areas
  void snippetForSearchSingleIndex90() throws Exception {
    // >SEPARATOR searchSingleIndex search_inside_multiple_rectangular_areas
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setInsideBoundingBox(
          InsideBoundingBox.of(
            Arrays.asList(
              Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625),
              Arrays.asList(49.62625916704081, 4.6181640625, 47.715070300900194, 0.482421875)
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
  // search_inside_polygon_area
  void snippetForSearchSingleIndex91() throws Exception {
    // >SEPARATOR searchSingleIndex search_inside_polygon_area
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setInsidePolygon(
          Arrays.asList(Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625, 49.62625916704081, 4.6181640625))
        ),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // search_inside_multiple_polygon_areas
  void snippetForSearchSingleIndex92() throws Exception {
    // >SEPARATOR searchSingleIndex search_inside_multiple_polygon_areas
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setInsidePolygon(
          Arrays.asList(
            Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625, 49.62625916704081, 4.6181640625),
            Arrays.asList(
              49.62625916704081,
              4.6181640625,
              47.715070300900194,
              0.482421875,
              45.17210966999772,
              1.009765625,
              50.62626704081,
              4.6181640625
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
  // set_querylanguages_override
  void snippetForSearchSingleIndex93() throws Exception {
    // >SEPARATOR searchSingleIndex set_querylanguages_override
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setIgnorePlurals(IgnorePlurals.of(Arrays.asList(SupportedLanguage.CA, SupportedLanguage.ES))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_querylanguages_with_japanese_query
  void snippetForSearchSingleIndex94() throws Exception {
    // >SEPARATOR searchSingleIndex set_querylanguages_with_japanese_query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setQueryLanguages(Arrays.asList(SupportedLanguage.JA, SupportedLanguage.EN)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_natural_languages
  void snippetForSearchSingleIndex95() throws Exception {
    // >SEPARATOR searchSingleIndex set_natural_languages
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("").setNaturalLanguages(Arrays.asList(SupportedLanguage.FR)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_natural_languages_with_query
  void snippetForSearchSingleIndex96() throws Exception {
    // >SEPARATOR searchSingleIndex override_natural_languages_with_query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("")
        .setNaturalLanguages(Arrays.asList(SupportedLanguage.FR))
        .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.FIRST_WORDS),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_decompound_query_search_time
  void snippetForSearchSingleIndex97() throws Exception {
    // >SEPARATOR searchSingleIndex enable_decompound_query_search_time
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setDecompoundQuery(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_rules_search_time
  void snippetForSearchSingleIndex98() throws Exception {
    // >SEPARATOR searchSingleIndex enable_rules_search_time
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setEnableRules(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_rule_contexts
  void snippetForSearchSingleIndex99() throws Exception {
    // >SEPARATOR searchSingleIndex set_rule_contexts
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setRuleContexts(Arrays.asList("front_end", "website2")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_personalization
  void snippetForSearchSingleIndex100() throws Exception {
    // >SEPARATOR searchSingleIndex enable_personalization
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setEnablePersonalization(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_personalization_with_user_token
  void snippetForSearchSingleIndex101() throws Exception {
    // >SEPARATOR searchSingleIndex enable_personalization_with_user_token
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setEnablePersonalization(true).setUserToken("123456"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // personalization_impact
  void snippetForSearchSingleIndex102() throws Exception {
    // >SEPARATOR searchSingleIndex personalization_impact
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setPersonalizationImpact(20), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_user_token
  void snippetForSearchSingleIndex103() throws Exception {
    // >SEPARATOR searchSingleIndex set_user_token
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setUserToken("123456"), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_user_token_with_personalization
  void snippetForSearchSingleIndex104() throws Exception {
    // >SEPARATOR searchSingleIndex set_user_token_with_personalization
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setEnablePersonalization(true).setUserToken("123456"),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_query_type
  void snippetForSearchSingleIndex105() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_query_type
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setQueryType(QueryType.PREFIX_ALL), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_remove_words_if_no_results
  void snippetForSearchSingleIndex106() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_remove_words_if_no_results
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setRemoveWordsIfNoResults(RemoveWordsIfNoResults.LAST_WORDS),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_advanced_syntax_search_time
  void snippetForSearchSingleIndex107() throws Exception {
    // >SEPARATOR searchSingleIndex enable_advanced_syntax_search_time
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setAdvancedSyntax(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // overide_default_optional_words
  void snippetForSearchSingleIndex108() throws Exception {
    // >SEPARATOR searchSingleIndex overide_default_optional_words
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setOptionalWords(OptionalWords.of(Arrays.asList("toyota", "2020 2021"))),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disabling_exact_for_some_attributes_search_time
  void snippetForSearchSingleIndex109() throws Exception {
    // >SEPARATOR searchSingleIndex disabling_exact_for_some_attributes_search_time
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setDisableExactOnAttributes(Arrays.asList("description")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_exact_single_word_query
  void snippetForSearchSingleIndex110() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_exact_single_word_query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setExactOnSingleWordQuery(ExactOnSingleWordQuery.NONE),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_aternative_as_exact
  void snippetForSearchSingleIndex111() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_aternative_as_exact
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAlternativesAsExact(Arrays.asList(AlternativesAsExact.MULTI_WORDS_SYNONYM)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_advanced_syntax_exact_phrase
  void snippetForSearchSingleIndex112() throws Exception {
    // >SEPARATOR searchSingleIndex enable_advanced_syntax_exact_phrase
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setAdvancedSyntax(true)
        .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_advanced_syntax_exclude_words
  void snippetForSearchSingleIndex113() throws Exception {
    // >SEPARATOR searchSingleIndex enable_advanced_syntax_exclude_words
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject()
        .setQuery("query")
        .setAdvancedSyntax(true)
        .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXCLUDE_WORDS)),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_distinct
  void snippetForSearchSingleIndex114() throws Exception {
    // >SEPARATOR searchSingleIndex override_distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setDistinct(Distinct.of(0)), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // get_ranking_info
  void snippetForSearchSingleIndex115() throws Exception {
    // >SEPARATOR searchSingleIndex get_ranking_info
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setGetRankingInfo(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disable_click_analytics
  void snippetForSearchSingleIndex116() throws Exception {
    // >SEPARATOR searchSingleIndex disable_click_analytics
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setClickAnalytics(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // enable_click_analytics
  void snippetForSearchSingleIndex117() throws Exception {
    // >SEPARATOR searchSingleIndex enable_click_analytics
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setClickAnalytics(true), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disable_analytics
  void snippetForSearchSingleIndex118() throws Exception {
    // >SEPARATOR searchSingleIndex disable_analytics
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setAnalytics(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // add_analytics_tags
  void snippetForSearchSingleIndex119() throws Exception {
    // >SEPARATOR searchSingleIndex add_analytics_tags
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setAnalyticsTags(Arrays.asList("front_end", "website2")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // disable_synonyms
  void snippetForSearchSingleIndex120() throws Exception {
    // >SEPARATOR searchSingleIndex disable_synonyms
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setSynonyms(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_replace_synonyms_in_highlights
  void snippetForSearchSingleIndex121() throws Exception {
    // >SEPARATOR searchSingleIndex override_replace_synonyms_in_highlights
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setReplaceSynonymsInHighlight(true),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_min_proximity
  void snippetForSearchSingleIndex122() throws Exception {
    // >SEPARATOR searchSingleIndex override_min_proximity
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setMinProximity(2), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_default_field
  void snippetForSearchSingleIndex123() throws Exception {
    // >SEPARATOR searchSingleIndex override_default_field
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query").setResponseFields(Arrays.asList("hits", "facets")),
      Hit.class
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // override_percentile_computation
  void snippetForSearchSingleIndex124() throws Exception {
    // >SEPARATOR searchSingleIndex override_percentile_computation
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setPercentileComputation(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_ab_test
  void snippetForSearchSingleIndex125() throws Exception {
    // >SEPARATOR searchSingleIndex set_ab_test
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setEnableABTest(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // set_enable_re_ranking
  void snippetForSearchSingleIndex126() throws Exception {
    // >SEPARATOR searchSingleIndex set_enable_re_ranking
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("query").setEnableReRanking(false), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // with algolia user id
  void snippetForSearchSingleIndex127() throws Exception {
    // >SEPARATOR searchSingleIndex with algolia user id
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("query"),
      Hit.class,
      new RequestOptions().addExtraHeader("X-Algolia-User-ID", "user1234")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSingleIndex method.
  //
  // mcm with algolia user id
  void snippetForSearchSingleIndex128() throws Exception {
    // >SEPARATOR searchSingleIndex mcm with algolia user id
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSingleIndex(
      "<YOUR_INDEX_NAME>",
      new SearchParamsObject().setQuery("peace"),
      Hit.class,
      new RequestOptions().addExtraHeader("X-Algolia-User-ID", "user42")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with minimal parameters
  void snippetForSearchSynonyms() throws Exception {
    // >SEPARATOR searchSynonyms searchSynonyms with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSynonyms("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchSynonyms method.
  //
  // searchSynonyms with all parameters
  void snippetForSearchSynonyms1() throws Exception {
    // >SEPARATOR searchSynonyms searchSynonyms with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchSynonyms(
      "<YOUR_INDEX_NAME>",
      new SearchSynonymsParams().setQuery("myQuery").setType(SynonymType.ALTCORRECTION_1).setPage(10).setHitsPerPage(10)
    );
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
    // >SEPARATOR setDictionarySettings get setDictionarySettings results with minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setDictionarySettings(
      new DictionarySettingsParams().setDisableStandardEntries(
        new StandardEntries().setPlurals(
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

  // Snippet for the setDictionarySettings method.
  //
  // get setDictionarySettings results with all parameters
  void snippetForSetDictionarySettings1() throws Exception {
    // >SEPARATOR setDictionarySettings get setDictionarySettings results with all parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setDictionarySettings(
      new DictionarySettingsParams().setDisableStandardEntries(
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
          .setStopwords(
            new HashMap() {
              {
                put("fr", false);
              }
            }
          )
          .setCompounds(
            new HashMap() {
              {
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
  // minimal parameters
  void snippetForSetSettings() throws Exception {
    // >SEPARATOR setSettings minimal parameters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setPaginationLimitedTo(10).setTypoTolerance(TypoToleranceEnum.FALSE), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // boolean typoTolerance
  void snippetForSetSettings1() throws Exception {
    // >SEPARATOR setSettings boolean typoTolerance
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setTypoTolerance(TypoTolerance.of(true)), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enum typoTolerance
  void snippetForSetSettings2() throws Exception {
    // >SEPARATOR setSettings enum typoTolerance
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setTypoTolerance(TypoToleranceEnum.MIN), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ignorePlurals
  void snippetForSetSettings3() throws Exception {
    // >SEPARATOR setSettings ignorePlurals
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setIgnorePlurals(IgnorePlurals.of(true)), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // list of string ignorePlurals
  void snippetForSetSettings4() throws Exception {
    // >SEPARATOR setSettings list of string ignorePlurals
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setIgnorePlurals(IgnorePlurals.of(Arrays.asList(SupportedLanguage.FR))),
      true
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // removeStopWords boolean
  void snippetForSetSettings5() throws Exception {
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
  void snippetForSetSettings6() throws Exception {
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
  // boolean distinct
  void snippetForSetSettings7() throws Exception {
    // >SEPARATOR setSettings boolean distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDistinct(Distinct.of(true)), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // integer distinct
  void snippetForSetSettings8() throws Exception {
    // >SEPARATOR setSettings integer distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDistinct(Distinct.of(1)), true);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // distinct company
  void snippetForSetSettings9() throws Exception {
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
  void snippetForSetSettings10() throws Exception {
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
  void snippetForSetSettings11() throws Exception {
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
  void snippetForSetSettings12() throws Exception {
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
  void snippetForSetSettings13() throws Exception {
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
  // attributesForFaceting availableIn
  void snippetForSetSettings14() throws Exception {
    // >SEPARATOR setSettings attributesForFaceting availableIn
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("color", "availableIn")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // api_attributes_for_faceting
  void snippetForSetSettings15() throws Exception {
    // >SEPARATOR setSettings api_attributes_for_faceting
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("genre", "author")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // api_attributes_for_faceting_searchable
  void snippetForSetSettings16() throws Exception {
    // >SEPARATOR setSettings api_attributes_for_faceting_searchable
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("genre", "searchable(author)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // api_attributes_for_filter_only
  void snippetForSetSettings17() throws Exception {
    // >SEPARATOR setSettings api_attributes_for_filter_only
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(genre)", "author")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting categoryPageId
  void snippetForSetSettings18() throws Exception {
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
  void snippetForSetSettings19() throws Exception {
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
  void snippetForSetSettings20() throws Exception {
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
  void snippetForSetSettings21() throws Exception {
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
  void snippetForSetSettings22() throws Exception {
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
  void snippetForSetSettings23() throws Exception {
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
  void snippetForSetSettings24() throws Exception {
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
  void snippetForSetSettings25() throws Exception {
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
  void snippetForSetSettings26() throws Exception {
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
  void snippetForSetSettings27() throws Exception {
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
  void snippetForSetSettings28() throws Exception {
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
  void snippetForSetSettings29() throws Exception {
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
  void snippetForSetSettings30() throws Exception {
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
  void snippetForSetSettings31() throws Exception {
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
  void snippetForSetSettings32() throws Exception {
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
  void snippetForSetSettings33() throws Exception {
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
  void snippetForSetSettings34() throws Exception {
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
  // ranking exhaustive (price)
  void snippetForSetSettings35() throws Exception {
    // >SEPARATOR setSettings ranking exhaustive (price)
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(
        Arrays.asList("desc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ranking exhaustive (is_popular)
  void snippetForSetSettings36() throws Exception {
    // >SEPARATOR setSettings ranking exhaustive (is_popular)
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(
        Arrays.asList("desc(is_popular)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // ranking standard replica
  void snippetForSetSettings37() throws Exception {
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
  void snippetForSetSettings38() throws Exception {
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
  void snippetForSetSettings39() throws Exception {
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
  void snippetForSetSettings40() throws Exception {
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
  void snippetForSetSettings41() throws Exception {
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
  // create replica index articles
  void snippetForSetSettings42() throws Exception {
    // >SEPARATOR setSettings create replica index articles
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setReplicas(Arrays.asList("articles_date_desc")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // create virtual replica index
  void snippetForSetSettings43() throws Exception {
    // >SEPARATOR setSettings create virtual replica index
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setReplicas(Arrays.asList("virtual(products_price_desc)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // unlink replica index
  void snippetForSetSettings44() throws Exception {
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
  void snippetForSetSettings45() throws Exception {
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
  void snippetForSetSettings46() throws Exception {
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
  void snippetForSetSettings47() throws Exception {
    // >SEPARATOR setSettings maxFacetHits
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMaxFacetHits(100));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesForFaceting complex
  void snippetForSetSettings48() throws Exception {
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
  void snippetForSetSettings49() throws Exception {
    // >SEPARATOR setSettings ranking closest dates
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(
        Arrays.asList("asc(date_timestamp)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributes item variation
  void snippetForSetSettings50() throws Exception {
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
  void snippetForSetSettings51() throws Exception {
    // >SEPARATOR setSettings searchableAttributes around location
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setSearchableAttributes(Arrays.asList("name", "country", "city", "iata_code"))
        .setCustomRanking(Arrays.asList("desc(links_count)"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesToHighlight
  void snippetForSetSettings52() throws Exception {
    // >SEPARATOR setSettings attributesToHighlight
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToHighlight(Arrays.asList("author", "title", "content")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // attributesToHighlightStar
  void snippetForSetSettings53() throws Exception {
    // >SEPARATOR setSettings attributesToHighlightStar
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToHighlight(Arrays.asList("*")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // everything
  void snippetForSetSettings54() throws Exception {
    // >SEPARATOR setSettings everything
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setAdvancedSyntax(true)
        .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE))
        .setAllowCompressionOfIntegerArray(true)
        .setAllowTyposOnNumericTokens(true)
        .setAlternativesAsExact(Arrays.asList(AlternativesAsExact.SINGLE_WORD_SYNONYM))
        .setAttributeCriteriaComputedByMinProximity(true)
        .setAttributeForDistinct("test")
        .setAttributesForFaceting(Arrays.asList("algolia"))
        .setAttributesToHighlight(Arrays.asList("algolia"))
        .setAttributesToRetrieve(Arrays.asList("algolia"))
        .setAttributesToSnippet(Arrays.asList("algolia"))
        .setAttributesToTransliterate(Arrays.asList("algolia"))
        .setCamelCaseAttributes(Arrays.asList("algolia"))
        .setCustomNormalization(
          new HashMap() {
            {
              put(
                "algolia",
                new HashMap() {
                  {
                    put("aloglia", "aglolia");
                  }
                }
              );
            }
          }
        )
        .setCustomRanking(Arrays.asList("algolia"))
        .setDecompoundQuery(false)
        .setDecompoundedAttributes(
          new HashMap() {
            {
              put("algolia", "aloglia");
            }
          }
        )
        .setDisableExactOnAttributes(Arrays.asList("algolia"))
        .setDisablePrefixOnAttributes(Arrays.asList("algolia"))
        .setDisableTypoToleranceOnAttributes(Arrays.asList("algolia"))
        .setDisableTypoToleranceOnWords(Arrays.asList("algolia"))
        .setDistinct(Distinct.of(3))
        .setEnablePersonalization(true)
        .setEnableReRanking(false)
        .setEnableRules(true)
        .setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE)
        .setHighlightPreTag("<span>")
        .setHighlightPostTag("</span>")
        .setHitsPerPage(10)
        .setIgnorePlurals(IgnorePlurals.of(false))
        .setIndexLanguages(Arrays.asList(SupportedLanguage.FR))
        .setKeepDiacriticsOnCharacters("abc")
        .setMaxFacetHits(20)
        .setMaxValuesPerFacet(30)
        .setMinProximity(6)
        .setMinWordSizefor1Typo(5)
        .setMinWordSizefor2Typos(11)
        .setMode(Mode.NEURAL_SEARCH)
        .setNumericAttributesForFiltering(Arrays.asList("algolia"))
        .setOptionalWords(OptionalWords.of(Arrays.asList("myspace")))
        .setPaginationLimitedTo(0)
        .setQueryLanguages(Arrays.asList(SupportedLanguage.FR))
        .setQueryType(QueryType.PREFIX_LAST)
        .setRanking(Arrays.asList("geo"))
        .setReRankingApplyFilter(ReRankingApplyFilter.of("mySearch:filters"))
        .setRelevancyStrictness(10)
        .setRemoveStopWords(RemoveStopWords.of(false))
        .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.LAST_WORDS)
        .setRenderingContent(
          new RenderingContent().setFacetOrdering(
            new FacetOrdering()
              .setFacets(new Facets().setOrder(Arrays.asList("a", "b")))
              .setValues(
                new HashMap() {
                  {
                    put("a", new Value().setOrder(Arrays.asList("b")).setSortRemainingBy(SortRemainingBy.COUNT));
                  }
                }
              )
          )
        )
        .setReplaceSynonymsInHighlight(true)
        .setReplicas(Arrays.asList(""))
        .setResponseFields(Arrays.asList("algolia"))
        .setRestrictHighlightAndSnippetArrays(true)
        .setSearchableAttributes(Arrays.asList("foo"))
        .setSemanticSearch(new SemanticSearch().setEventSources(Arrays.asList("foo")))
        .setSeparatorsToIndex("bar")
        .setSnippetEllipsisText("---")
        .setSortFacetValuesBy("date")
        .setTypoTolerance(TypoTolerance.of(false))
        .setUnretrievableAttributes(Arrays.asList("foo"))
        .setUserData(
          new HashMap() {
            {
              put("user", "data");
            }
          }
        )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesWithCustomRankingsAndAttributesForFaceting
  void snippetForSetSettings55() throws Exception {
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
  // searchableAttributesOrdering
  void snippetForSetSettings56() throws Exception {
    // >SEPARATOR setSettings searchableAttributesOrdering
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSearchableAttributes(Arrays.asList("unordered(title)", "cast")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // searchableAttributesProductReferenceSuffixes
  void snippetForSetSettings57() throws Exception {
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
  void snippetForSetSettings58() throws Exception {
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
  void snippetForSetSettings59() throws Exception {
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
  void snippetForSetSettings60() throws Exception {
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
  void snippetForSetSettings61() throws Exception {
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
  void snippetForSetSettings62() throws Exception {
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
  void snippetForSetSettings63() throws Exception {
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

  // Snippet for the setSettings method.
  //
  // set_searchable_attributes
  void snippetForSetSettings64() throws Exception {
    // >SEPARATOR setSettings set_searchable_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setSearchableAttributes(Arrays.asList("title,alternative_title", "author", "unordered(text)", "emails.personal"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_attributes_for_faceting
  void snippetForSetSettings65() throws Exception {
    // >SEPARATOR setSettings set_attributes_for_faceting
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setAttributesForFaceting(
        Arrays.asList(
          "author",
          "filterOnly(isbn)",
          "searchable(edition)",
          "afterDistinct(category)",
          "afterDistinct(searchable(publisher))"
        )
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // unretrievable_attributes
  void snippetForSetSettings66() throws Exception {
    // >SEPARATOR setSettings unretrievable_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setUnretrievableAttributes(Arrays.asList("total_number_of_sales")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_retrievable_attributes
  void snippetForSetSettings67() throws Exception {
    // >SEPARATOR setSettings set_retrievable_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToRetrieve(Arrays.asList("author", "title", "content")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_all_attributes_as_retrievable
  void snippetForSetSettings68() throws Exception {
    // >SEPARATOR setSettings set_all_attributes_as_retrievable
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToRetrieve(Arrays.asList("*")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // specify_attributes_not_to_retrieve
  void snippetForSetSettings69() throws Exception {
    // >SEPARATOR setSettings specify_attributes_not_to_retrieve
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToRetrieve(Arrays.asList("*", "-SKU", "-internal_desc")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // neural_search
  void snippetForSetSettings70() throws Exception {
    // >SEPARATOR setSettings neural_search
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMode(Mode.NEURAL_SEARCH));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // keyword_search
  void snippetForSetSettings71() throws Exception {
    // >SEPARATOR setSettings keyword_search
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMode(Mode.KEYWORD_SEARCH));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_ranking
  void snippetForSetSettings72() throws Exception {
    // >SEPARATOR setSettings set_default_ranking
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(Arrays.asList("typo", "geo", "words", "filters", "attribute", "proximity", "exact", "custom"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_ranking_by_attribute_asc
  void snippetForSetSettings73() throws Exception {
    // >SEPARATOR setSettings set_ranking_by_attribute_asc
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(
        Arrays.asList("asc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_ranking_by_attribute_desc
  void snippetForSetSettings74() throws Exception {
    // >SEPARATOR setSettings set_ranking_by_attribute_desc
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRanking(
        Arrays.asList("desc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_custom_ranking
  void snippetForSetSettings75() throws Exception {
    // >SEPARATOR setSettings set_custom_ranking
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCustomRanking(Arrays.asList("desc(popularity)", "asc(price)")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_relevancy
  void snippetForSetSettings76() throws Exception {
    // >SEPARATOR setSettings set_default_relevancy
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setRelevancyStrictness(90));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_replicas
  void snippetForSetSettings77() throws Exception {
    // >SEPARATOR setSettings set_replicas
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setReplicas(Arrays.asList("name_of_replica_index1", "name_of_replica_index2"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_max_values_per_facet
  void snippetForSetSettings78() throws Exception {
    // >SEPARATOR setSettings set_default_max_values_per_facet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMaxValuesPerFacet(100));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_sort_facet_values_by
  void snippetForSetSettings79() throws Exception {
    // >SEPARATOR setSettings set_default_sort_facet_values_by
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSortFacetValuesBy("alpha"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_attributes_to_snippet
  void snippetForSetSettings80() throws Exception {
    // >SEPARATOR setSettings set_attributes_to_snippet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToSnippet(Arrays.asList("content:80", "description")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_all_attributes_to_snippet
  void snippetForSetSettings81() throws Exception {
    // >SEPARATOR setSettings set_all_attributes_to_snippet
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesToSnippet(Arrays.asList("*:80")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_highlight_pre_tag
  void snippetForSetSettings82() throws Exception {
    // >SEPARATOR setSettings set_default_highlight_pre_tag
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setHighlightPreTag("<em>"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_highlight_post_tag
  void snippetForSetSettings83() throws Exception {
    // >SEPARATOR setSettings set_default_highlight_post_tag
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setHighlightPostTag("</em>"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_snippet_ellipsis_text
  void snippetForSetSettings84() throws Exception {
    // >SEPARATOR setSettings set_default_snippet_ellipsis_text
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSnippetEllipsisText("…"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_restrict_highlight_and_snippet_arrays_by_default
  void snippetForSetSettings85() throws Exception {
    // >SEPARATOR setSettings enable_restrict_highlight_and_snippet_arrays_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setRestrictHighlightAndSnippetArrays(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_hits_per_page
  void snippetForSetSettings86() throws Exception {
    // >SEPARATOR setSettings set_default_hits_per_page
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setHitsPerPage(20));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_pagination_limit
  void snippetForSetSettings87() throws Exception {
    // >SEPARATOR setSettings set_pagination_limit
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setPaginationLimitedTo(1000));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_min_word_size_for_one_typo
  void snippetForSetSettings88() throws Exception {
    // >SEPARATOR setSettings set_default_min_word_size_for_one_typo
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMinWordSizefor1Typo(4));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_min_word_size_for_two_typos
  void snippetForSetSettings89() throws Exception {
    // >SEPARATOR setSettings set_default_min_word_size_for_two_typos
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMinWordSizefor2Typos(4));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_typo_tolerance_mode
  void snippetForSetSettings90() throws Exception {
    // >SEPARATOR setSettings set_default_typo_tolerance_mode
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setTypoTolerance(TypoTolerance.of(true)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disable_typos_on_numeric_tokens_by_default
  void snippetForSetSettings91() throws Exception {
    // >SEPARATOR setSettings disable_typos_on_numeric_tokens_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAllowTyposOnNumericTokens(false));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disable_typo_tolerance_for_words
  void snippetForSetSettings92() throws Exception {
    // >SEPARATOR setSettings disable_typo_tolerance_for_words
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisableTypoToleranceOnWords(Arrays.asList("wheel", "1X2BCD")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_separators_to_index
  void snippetForSetSettings93() throws Exception {
    // >SEPARATOR setSettings set_separators_to_index
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setSeparatorsToIndex("+#"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_querylanguage_ignoreplurals
  void snippetForSetSettings94() throws Exception {
    // >SEPARATOR setSettings set_querylanguage_ignoreplurals
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.ES)).setIgnorePlurals(IgnorePlurals.of(true))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_attributes_to_transliterate
  void snippetForSetSettings95() throws Exception {
    // >SEPARATOR setSettings set_attributes_to_transliterate
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setIndexLanguages(Arrays.asList(SupportedLanguage.JA))
        .setAttributesToTransliterate(Arrays.asList("name", "description"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_querylanguage_removestopwords
  void snippetForSetSettings96() throws Exception {
    // >SEPARATOR setSettings set_querylanguage_removestopwords
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.ES)).setRemoveStopWords(RemoveStopWords.of(true))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_camel_case_attributes
  void snippetForSetSettings97() throws Exception {
    // >SEPARATOR setSettings set_camel_case_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setCamelCaseAttributes(Arrays.asList("description")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_decompounded_attributes
  void snippetForSetSettings98() throws Exception {
    // >SEPARATOR setSettings set_decompounded_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setDecompoundedAttributes(
        new HashMap() {
          {
            put("de", Arrays.asList("name"));
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_decompounded_multiple_attributes
  void snippetForSetSettings99() throws Exception {
    // >SEPARATOR setSettings set_decompounded_multiple_attributes
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setDecompoundedAttributes(
        new HashMap() {
          {
            put("de", Arrays.asList("name_de", "description_de"));
            put("fi", Arrays.asList("name_fi", "description_fi"));
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_keep_diacritics_on_characters
  void snippetForSetSettings100() throws Exception {
    // >SEPARATOR setSettings set_keep_diacritics_on_characters
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setKeepDiacriticsOnCharacters("øé"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_custom_normalization
  void snippetForSetSettings101() throws Exception {
    // >SEPARATOR setSettings set_custom_normalization
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setCustomNormalization(
        new HashMap() {
          {
            put(
              "default",
              new HashMap() {
                {
                  put("ä", "ae");
                }
              }
            );
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_querylanguage_both
  void snippetForSetSettings102() throws Exception {
    // >SEPARATOR setSettings set_querylanguage_both
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings()
        .setQueryLanguages(Arrays.asList(SupportedLanguage.ES))
        .setRemoveStopWords(RemoveStopWords.of(true))
        .setIgnorePlurals(IgnorePlurals.of(true))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_indexlanguages
  void snippetForSetSettings103() throws Exception {
    // >SEPARATOR setSettings set_indexlanguages
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setIndexLanguages(Arrays.asList(SupportedLanguage.JA)));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_decompound_query_by_default
  void snippetForSetSettings104() throws Exception {
    // >SEPARATOR setSettings enable_decompound_query_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDecompoundQuery(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_rules_syntax_by_default
  void snippetForSetSettings105() throws Exception {
    // >SEPARATOR setSettings enable_rules_syntax_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setEnableRules(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_personalization_settings
  void snippetForSetSettings106() throws Exception {
    // >SEPARATOR setSettings enable_personalization_settings
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setEnablePersonalization(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_query_type
  void snippetForSetSettings107() throws Exception {
    // >SEPARATOR setSettings set_default_query_type
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setQueryType(QueryType.PREFIX_LAST));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_remove_words_if_no_result
  void snippetForSetSettings108() throws Exception {
    // >SEPARATOR setSettings set_default_remove_words_if_no_result
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setRemoveWordsIfNoResults(RemoveWordsIfNoResults.NONE));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_advanced_syntax_by_default
  void snippetForSetSettings109() throws Exception {
    // >SEPARATOR setSettings enable_advanced_syntax_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAdvancedSyntax(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_optional_words
  void snippetForSetSettings110() throws Exception {
    // >SEPARATOR setSettings set_default_optional_words
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setOptionalWords(OptionalWords.of(Arrays.asList("blue", "iphone case"))));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disabling_prefix_search_for_some_attributes_by_default
  void snippetForSetSettings111() throws Exception {
    // >SEPARATOR setSettings disabling_prefix_search_for_some_attributes_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisablePrefixOnAttributes(Arrays.asList("sku")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // disabling_exact_for_some_attributes_by_default
  void snippetForSetSettings112() throws Exception {
    // >SEPARATOR setSettings disabling_exact_for_some_attributes_by_default
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDisableExactOnAttributes(Arrays.asList("description")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_exact_single_word_query
  void snippetForSetSettings113() throws Exception {
    // >SEPARATOR setSettings set_default_exact_single_word_query
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_aternative_as_exact
  void snippetForSetSettings114() throws Exception {
    // >SEPARATOR setSettings set_default_aternative_as_exact
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setAlternativesAsExact(Arrays.asList(AlternativesAsExact.IGNORE_PLURALS, AlternativesAsExact.SINGLE_WORD_SYNONYM))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_numeric_attributes_for_filtering
  void snippetForSetSettings115() throws Exception {
    // >SEPARATOR setSettings set_numeric_attributes_for_filtering
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setNumericAttributesForFiltering(Arrays.asList("quantity", "popularity")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // enable_compression_of_integer_array
  void snippetForSetSettings116() throws Exception {
    // >SEPARATOR setSettings enable_compression_of_integer_array
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAllowCompressionOfIntegerArray(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_attributes_for_distinct
  void snippetForSetSettings117() throws Exception {
    // >SEPARATOR setSettings set_attributes_for_distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributeForDistinct("url"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_distinct
  void snippetForSetSettings118() throws Exception {
    // >SEPARATOR setSettings set_distinct
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setDistinct(Distinct.of(1)).setAttributeForDistinct("url"));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_replace_synonyms_in_highlights
  void snippetForSetSettings119() throws Exception {
    // >SEPARATOR setSettings set_replace_synonyms_in_highlights
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setReplaceSynonymsInHighlight(false));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_min_proximity
  void snippetForSetSettings120() throws Exception {
    // >SEPARATOR setSettings set_min_proximity
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMinProximity(1));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_default_field
  void snippetForSetSettings121() throws Exception {
    // >SEPARATOR setSettings set_default_field
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setResponseFields(Arrays.asList("hits", "hitsPerPage", "nbPages", "page")));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_max_facet_hits
  void snippetForSetSettings122() throws Exception {
    // >SEPARATOR setSettings set_max_facet_hits
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setMaxFacetHits(10));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_attribute_criteria_computed_by_min_proximity
  void snippetForSetSettings123() throws Exception {
    // >SEPARATOR setSettings set_attribute_criteria_computed_by_min_proximity
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributeCriteriaComputedByMinProximity(true));
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_user_data
  void snippetForSetSettings124() throws Exception {
    // >SEPARATOR setSettings set_user_data
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setUserData(
        new HashMap() {
          {
            put("extraData", "This is the custom data that you want to store in your index");
          }
        }
      )
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setSettings method.
  //
  // set_rendering_content
  void snippetForSetSettings125() throws Exception {
    // >SEPARATOR setSettings set_rendering_content
    // Initialize the client
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setSettings(
      "<YOUR_INDEX_NAME>",
      new IndexSettings().setRenderingContent(
        new RenderingContent().setFacetOrdering(
          new FacetOrdering()
            .setFacets(new Facets().setOrder(Arrays.asList("size", "brand")))
            .setValues(
              new HashMap() {
                {
                  put(
                    "brand",
                    new Value().setOrder(Arrays.asList("uniqlo")).setHide(Arrays.asList("muji")).setSortRemainingBy(SortRemainingBy.COUNT)
                  );
                  put("size", new Value().setOrder(Arrays.asList("S", "M", "L")).setSortRemainingBy(SortRemainingBy.HIDDEN));
                }
              }
            )
        )
      )
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

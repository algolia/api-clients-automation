package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.CompositionClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.composition.*;
import java.util.*;

class SnippetCompositionClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customDelete("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "to be overridden");
        }
      },
      new RequestOptions()
        .addExtraQueryParameters("query", "parameters with space")
        .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
        .addExtraHeader("x-header-1", "spaces are left alone")
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPut("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPut(
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
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteComposition method.
  //
  // deleteComposition
  void snippetForDeleteComposition() throws Exception {
    // >SEPARATOR deleteComposition default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.deleteComposition("1234");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteCompositionRule method.
  //
  // deleteCompositionRule
  void snippetForDeleteCompositionRule() throws Exception {
    // >SEPARATOR deleteCompositionRule default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.deleteCompositionRule("1234", "5678");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getComposition method.
  //
  // getComposition
  void snippetForGetComposition() throws Exception {
    // >SEPARATOR getComposition default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Composition response = client.getComposition("foo");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRule method.
  //
  // getRule
  void snippetForGetRule() throws Exception {
    // >SEPARATOR getRule default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    CompositionRule response = client.getRule("foo", "123");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getTask method.
  //
  // getTask
  void snippetForGetTask() throws Exception {
    // >SEPARATOR getTask default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetTaskResponse response = client.getTask("foo", 42L);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listCompositions method.
  //
  // listCompositions
  void snippetForListCompositions() throws Exception {
    // >SEPARATOR listCompositions listCompositions
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    ListCompositionsResponse response = client.listCompositions();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the listCompositions method.
  //
  // listCompositions
  void snippetForListCompositions1() throws Exception {
    // >SEPARATOR listCompositions listCompositions
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    ListCompositionsResponse response = client.listCompositions();
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch() throws Exception {
    // >SEPARATOR multipleBatch multipleBatch
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    MultipleBatchResponse response = client.multipleBatch(
      new BatchParams().setRequests(
        Arrays.asList(
          new MultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new Composition()
                .setObjectID("foo")
                .setName("my first composition")
                .setBehavior(
                  new CompositionInjectionBehavior().setInjection(
                    new Injection().setMain(
                      new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("bar")))
                    )
                  )
                )
            ),
          new MultipleBatchRequest().setAction(Action.DELETE).setBody(new DeleteCompositionAction().setObjectID("baz"))
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch1() throws Exception {
    // >SEPARATOR multipleBatch multipleBatch
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    MultipleBatchResponse response = client.multipleBatch(
      new BatchParams().setRequests(
        Arrays.asList(
          new MultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new Composition()
                .setObjectID("my-external-injection-compo")
                .setName("my first composition")
                .setBehavior(
                  new CompositionInjectionBehavior().setInjection(
                    new Injection()
                      .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
                      .setInjectedItems(
                        Arrays.asList(
                          new InjectedItem()
                            .setKey("my-unique-external-group-key")
                            .setSource(
                              new ExternalSource().setExternal(
                                new External()
                                  .setIndex("foo")
                                  .setOrdering(ExternalOrdering.USER_DEFINED)
                                  .setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                              )
                            )
                            .setPosition(2)
                            .setLength(1)
                        )
                      )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch2() throws Exception {
    // >SEPARATOR multipleBatch multipleBatch
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    MultipleBatchResponse response = client.multipleBatch(
      new BatchParams().setRequests(
        Arrays.asList(
          new MultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new Composition()
                .setObjectID("my-metadata-compo")
                .setName("my composition")
                .setBehavior(
                  new CompositionInjectionBehavior().setInjection(
                    new Injection()
                      .setMain(
                        new Main().setSource(
                          new CompositionSource().setSearch(
                            new CompositionSourceSearch()
                              .setIndex("foo")
                              .setParams(new MainInjectionQueryParameters().setFilters("brand:adidas"))
                          )
                        )
                      )
                      .setInjectedItems(
                        Arrays.asList(
                          new InjectedItem()
                            .setKey("my-unique-group-key")
                            .setSource(
                              new SearchSource().setSearch(
                                new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                              )
                            )
                            .setPosition(2)
                            .setLength(1)
                            .setMetadata(
                              new InjectedItemMetadata().setHits(
                                new InjectedItemHitsMetadata()
                                  .setAddItemKey(true)
                                  .setExtra(
                                    new HashMap() {
                                      {
                                        put("my-string", "string");
                                        put("my-bool", true);
                                        put("my-number", 42);
                                        put(
                                          "my-object",
                                          new HashMap() {
                                            {
                                              put("sub-key", "sub-value");
                                            }
                                          }
                                        );
                                      }
                                    }
                                  )
                              )
                            ),
                          new InjectedItem()
                            .setKey("my-unique-group-key")
                            .setSource(
                              new SearchSource().setSearch(
                                new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:puma"))
                              )
                            )
                            .setPosition(5)
                            .setLength(5)
                            .setMetadata(
                              new InjectedItemMetadata().setHits(
                                new InjectedItemHitsMetadata()
                                  .setAddItemKey(true)
                                  .setExtra(
                                    new HashMap() {
                                      {
                                        put("my-string", "string");
                                        put("my-bool", true);
                                        put("my-number", 42);
                                        put(
                                          "my-object",
                                          new HashMap() {
                                            {
                                              put("sub-key", "sub-value");
                                            }
                                          }
                                        );
                                      }
                                    }
                                  )
                              )
                            )
                        )
                      )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the multipleBatch method.
  //
  // multipleBatch
  void snippetForMultipleBatch3() throws Exception {
    // >SEPARATOR multipleBatch multipleBatch
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    MultipleBatchResponse response = client.multipleBatch(
      new BatchParams().setRequests(
        Arrays.asList(
          new MultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new Composition()
                .setObjectID("my-compo")
                .setName("my composition")
                .setBehavior(
                  new CompositionInjectionBehavior().setInjection(
                    new Injection()
                      .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
                      .setInjectedItems(
                        Arrays.asList(
                          new InjectedItem()
                            .setKey("my-unique-injected-item-key")
                            .setSource(new SearchSource().setSearch(new Search().setIndex("foo")))
                            .setPosition(2)
                            .setLength(1)
                        )
                      )
                      .setDeduplication(new Deduplication().setPositioning(DedupPositioning.HIGHEST))
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putComposition method.
  //
  // putComposition
  void snippetForPutComposition() throws Exception {
    // >SEPARATOR putComposition putComposition
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putComposition(
      "1234",
      new Composition()
        .setObjectID("1234")
        .setName("my first composition")
        .setBehavior(
          new CompositionInjectionBehavior().setInjection(
            new Injection()
              .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
              .setInjectedItems(
                Arrays.asList(
                  new InjectedItem()
                    .setKey("my-unique-group-key")
                    .setSource(new SearchSource().setSearch(new Search().setIndex("foo")))
                    .setPosition(2)
                    .setLength(1)
                )
              )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putComposition method.
  //
  // putComposition
  void snippetForPutComposition1() throws Exception {
    // >SEPARATOR putComposition putComposition
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putComposition(
      "my-external-injection-compo",
      new Composition()
        .setObjectID("my-external-injection-compo")
        .setName("my first composition")
        .setBehavior(
          new CompositionInjectionBehavior().setInjection(
            new Injection()
              .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
              .setInjectedItems(
                Arrays.asList(
                  new InjectedItem()
                    .setKey("my-unique-external-group-key")
                    .setSource(
                      new ExternalSource().setExternal(
                        new External()
                          .setIndex("foo")
                          .setOrdering(ExternalOrdering.USER_DEFINED)
                          .setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                      )
                    )
                    .setPosition(2)
                    .setLength(1)
                )
              )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putComposition method.
  //
  // putComposition
  void snippetForPutComposition2() throws Exception {
    // >SEPARATOR putComposition putComposition
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putComposition(
      "my-metadata-compo",
      new Composition()
        .setObjectID("my-metadata-compo")
        .setName("my composition")
        .setBehavior(
          new CompositionInjectionBehavior().setInjection(
            new Injection()
              .setMain(
                new Main().setSource(
                  new CompositionSource().setSearch(
                    new CompositionSourceSearch().setIndex("foo").setParams(new MainInjectionQueryParameters().setFilters("brand:adidas"))
                  )
                )
              )
              .setInjectedItems(
                Arrays.asList(
                  new InjectedItem()
                    .setKey("my-unique-group-key")
                    .setSource(
                      new SearchSource().setSearch(
                        new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                      )
                    )
                    .setPosition(2)
                    .setLength(1)
                    .setMetadata(
                      new InjectedItemMetadata().setHits(
                        new InjectedItemHitsMetadata()
                          .setAddItemKey(true)
                          .setExtra(
                            new HashMap() {
                              {
                                put("my-string", "string");
                                put("my-bool", true);
                                put("my-number", 42);
                                put(
                                  "my-object",
                                  new HashMap() {
                                    {
                                      put("sub-key", "sub-value");
                                    }
                                  }
                                );
                              }
                            }
                          )
                      )
                    ),
                  new InjectedItem()
                    .setKey("my-unique-group-key")
                    .setSource(
                      new SearchSource().setSearch(
                        new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:puma"))
                      )
                    )
                    .setPosition(5)
                    .setLength(5)
                    .setMetadata(
                      new InjectedItemMetadata().setHits(
                        new InjectedItemHitsMetadata()
                          .setAddItemKey(true)
                          .setExtra(
                            new HashMap() {
                              {
                                put("my-string", "string");
                                put("my-bool", true);
                                put("my-number", 42);
                                put(
                                  "my-object",
                                  new HashMap() {
                                    {
                                      put("sub-key", "sub-value");
                                    }
                                  }
                                );
                              }
                            }
                          )
                      )
                    )
                )
              )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putComposition method.
  //
  // putComposition
  void snippetForPutComposition3() throws Exception {
    // >SEPARATOR putComposition putComposition
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putComposition(
      "my-compo",
      new Composition()
        .setObjectID("my-compo")
        .setName("my composition")
        .setBehavior(
          new CompositionInjectionBehavior().setInjection(
            new Injection()
              .setMain(
                new Main().setSource(
                  new CompositionSource().setSearch(
                    new CompositionSourceSearch().setIndex("foo").setParams(new MainInjectionQueryParameters().setFilters("brand:adidas"))
                  )
                )
              )
              .setInjectedItems(
                Arrays.asList(
                  new InjectedItem()
                    .setKey("my-unique-injected-item-key")
                    .setSource(new SearchSource().setSearch(new Search().setIndex("foo")))
                    .setPosition(2)
                    .setLength(1)
                )
              )
              .setDeduplication(new Deduplication().setPositioning(DedupPositioning.HIGHEST))
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putComposition method.
  //
  // putComposition
  void snippetForPutComposition4() throws Exception {
    // >SEPARATOR putComposition putComposition
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putComposition(
      "my-compo",
      new Composition()
        .setObjectID("my-compo")
        .setName("my composition")
        .setSortingStrategy(
          new HashMap() {
            {
              put("Price-asc", "products-low-to-high");
              put("Price-desc", "products-high-to-low");
            }
          }
        )
        .setBehavior(
          new CompositionInjectionBehavior().setInjection(
            new Injection().setMain(
              new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("products")))
            )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putCompositionRule method.
  //
  // putCompositionRule
  void snippetForPutCompositionRule() throws Exception {
    // >SEPARATOR putCompositionRule putCompositionRule
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putCompositionRule(
      "compositionID",
      "ruleID",
      new CompositionRule()
        .setObjectID("ruleID")
        .setConditions(Arrays.asList(new Condition().setAnchoring(Anchoring.IS).setPattern("test")))
        .setConsequence(
          new CompositionRuleConsequence().setBehavior(
            new CompositionInjectionBehavior().setInjection(
              new Injection()
                .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
                .setInjectedItems(
                  Arrays.asList(
                    new InjectedItem()
                      .setKey("my-unique-group-from-rule-key")
                      .setSource(new SearchSource().setSearch(new Search().setIndex("foo")))
                      .setPosition(2)
                      .setLength(1)
                  )
                )
            )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putCompositionRule method.
  //
  // putCompositionRule
  void snippetForPutCompositionRule1() throws Exception {
    // >SEPARATOR putCompositionRule putCompositionRule
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putCompositionRule(
      "compositionID",
      "rule-with-metadata",
      new CompositionRule()
        .setObjectID("rule-with-metadata")
        .setConditions(Arrays.asList(new Condition().setAnchoring(Anchoring.IS).setPattern("test")))
        .setConsequence(
          new CompositionRuleConsequence().setBehavior(
            new CompositionInjectionBehavior().setInjection(
              new Injection()
                .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
                .setInjectedItems(
                  Arrays.asList(
                    new InjectedItem()
                      .setKey("my-unique-group-from-rule-key")
                      .setSource(
                        new SearchSource().setSearch(
                          new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                        )
                      )
                      .setPosition(2)
                      .setLength(1)
                      .setMetadata(
                        new InjectedItemMetadata().setHits(
                          new InjectedItemHitsMetadata()
                            .setAddItemKey(true)
                            .setExtra(
                              new HashMap() {
                                {
                                  put("my-string", "string");
                                  put("my-bool", true);
                                  put("my-number", 42);
                                  put(
                                    "my-object",
                                    new HashMap() {
                                      {
                                        put("sub-key", "sub-value");
                                      }
                                    }
                                  );
                                }
                              }
                            )
                        )
                      )
                  )
                )
            )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putCompositionRule method.
  //
  // putCompositionRule
  void snippetForPutCompositionRule2() throws Exception {
    // >SEPARATOR putCompositionRule putCompositionRule
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putCompositionRule(
      "compositionID",
      "rule-with-exernal-source",
      new CompositionRule()
        .setObjectID("rule-with-exernal-source")
        .setDescription("my description")
        .setTags(Arrays.asList("tag1", "tag2"))
        .setEnabled(true)
        .setValidity(Arrays.asList(new TimeRange().setFrom(1704063600L).setUntil(1704083600L)))
        .setConditions(
          Arrays.asList(
            new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("harry"),
            new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("potter")
          )
        )
        .setConsequence(
          new CompositionRuleConsequence().setBehavior(
            new CompositionInjectionBehavior().setInjection(
              new Injection()
                .setMain(
                  new Main().setSource(
                    new CompositionSource().setSearch(
                      new CompositionSourceSearch()
                        .setIndex("my-index")
                        .setParams(new MainInjectionQueryParameters().setFilters("brand:adidas"))
                    )
                  )
                )
                .setInjectedItems(
                  Arrays.asList(
                    new InjectedItem()
                      .setKey("my-unique-external-group-from-rule-key")
                      .setSource(
                        new ExternalSource().setExternal(
                          new External()
                            .setIndex("my-index")
                            .setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                            .setOrdering(ExternalOrdering.USER_DEFINED)
                        )
                      )
                      .setPosition(0)
                      .setLength(3)
                  )
                )
            )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the putCompositionRule method.
  //
  // putCompositionRule
  void snippetForPutCompositionRule3() throws Exception {
    // >SEPARATOR putCompositionRule putCompositionRule
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.putCompositionRule(
      "compositionID",
      "rule-with-deduplication",
      new CompositionRule()
        .setObjectID("rule-with-deduplication")
        .setDescription("my description")
        .setEnabled(true)
        .setConditions(Arrays.asList(new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("harry")))
        .setConsequence(
          new CompositionRuleConsequence().setBehavior(
            new CompositionInjectionBehavior().setInjection(
              new Injection()
                .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("my-index"))))
                .setInjectedItems(
                  Arrays.asList(
                    new InjectedItem()
                      .setKey("my-unique-injected-item-key")
                      .setSource(new SearchSource().setSearch(new Search().setIndex("my-index")))
                      .setPosition(0)
                      .setLength(3)
                  )
                )
                .setDeduplication(new Deduplication().setPositioning(DedupPositioning.HIGHEST_INJECTED))
            )
          )
        )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules
  void snippetForSaveRules() throws Exception {
    // >SEPARATOR saveRules saveRules
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RulesMultipleBatchResponse response = client.saveRules(
      "foo",
      new CompositionRulesBatchParams().setRequests(
        Arrays.asList(
          new RulesMultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new CompositionRule()
                .setObjectID("123")
                .setConditions(Arrays.asList(new Condition().setPattern("a")))
                .setConsequence(
                  new CompositionRuleConsequence().setBehavior(
                    new CompositionInjectionBehavior().setInjection(
                      new Injection().setMain(
                        new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("<YOUR_INDEX_NAME>")))
                      )
                    )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules
  void snippetForSaveRules1() throws Exception {
    // >SEPARATOR saveRules saveRules
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RulesMultipleBatchResponse response = client.saveRules(
      "rule-with-metadata",
      new CompositionRulesBatchParams().setRequests(
        Arrays.asList(
          new RulesMultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new CompositionRule()
                .setObjectID("rule-with-metadata")
                .setConditions(Arrays.asList(new Condition().setAnchoring(Anchoring.IS).setPattern("test")))
                .setConsequence(
                  new CompositionRuleConsequence().setBehavior(
                    new CompositionInjectionBehavior().setInjection(
                      new Injection()
                        .setMain(new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("foo"))))
                        .setInjectedItems(
                          Arrays.asList(
                            new InjectedItem()
                              .setKey("my-unique-group-from-rule-key")
                              .setSource(
                                new SearchSource().setSearch(
                                  new Search().setIndex("foo").setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                                )
                              )
                              .setPosition(2)
                              .setLength(1)
                              .setMetadata(
                                new InjectedItemMetadata().setHits(
                                  new InjectedItemHitsMetadata()
                                    .setAddItemKey(true)
                                    .setExtra(
                                      new HashMap() {
                                        {
                                          put("my-string", "string");
                                          put("my-bool", true);
                                          put("my-number", 42);
                                          put(
                                            "my-object",
                                            new HashMap() {
                                              {
                                                put("sub-key", "sub-value");
                                              }
                                            }
                                          );
                                        }
                                      }
                                    )
                                )
                              )
                          )
                        )
                    )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules
  void snippetForSaveRules2() throws Exception {
    // >SEPARATOR saveRules saveRules
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RulesMultipleBatchResponse response = client.saveRules(
      "rule-with-exernal-source",
      new CompositionRulesBatchParams().setRequests(
        Arrays.asList(
          new RulesMultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new CompositionRule()
                .setObjectID("rule-with-exernal-source")
                .setDescription("my description")
                .setTags(Arrays.asList("tag1", "tag2"))
                .setEnabled(true)
                .setValidity(Arrays.asList(new TimeRange().setFrom(1704063600L).setUntil(1704083600L)))
                .setConditions(
                  Arrays.asList(
                    new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("harry"),
                    new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("potter")
                  )
                )
                .setConsequence(
                  new CompositionRuleConsequence().setBehavior(
                    new CompositionInjectionBehavior().setInjection(
                      new Injection()
                        .setMain(
                          new Main().setSource(
                            new CompositionSource().setSearch(
                              new CompositionSourceSearch()
                                .setIndex("my-index")
                                .setParams(new MainInjectionQueryParameters().setFilters("brand:adidas"))
                            )
                          )
                        )
                        .setInjectedItems(
                          Arrays.asList(
                            new InjectedItem()
                              .setKey("my-unique-external-group-from-rule-key")
                              .setSource(
                                new ExternalSource().setExternal(
                                  new External()
                                    .setIndex("my-index")
                                    .setParams(new BaseInjectionQueryParameters().setFilters("brand:adidas"))
                                    .setOrdering(ExternalOrdering.USER_DEFINED)
                                )
                              )
                              .setPosition(0)
                              .setLength(3)
                          )
                        )
                    )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the saveRules method.
  //
  // saveRules
  void snippetForSaveRules3() throws Exception {
    // >SEPARATOR saveRules saveRules
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RulesMultipleBatchResponse response = client.saveRules(
      "my-compo",
      new CompositionRulesBatchParams().setRequests(
        Arrays.asList(
          new RulesMultipleBatchRequest()
            .setAction(Action.UPSERT)
            .setBody(
              new CompositionRule()
                .setObjectID("rule-with-deduplication")
                .setDescription("my description")
                .setEnabled(true)
                .setConditions(
                  Arrays.asList(
                    new Condition().setAnchoring(Anchoring.CONTAINS).setPattern("harry"),
                    new Condition().setSortBy("price-low-to-high")
                  )
                )
                .setConsequence(
                  new CompositionRuleConsequence().setBehavior(
                    new CompositionInjectionBehavior().setInjection(
                      new Injection()
                        .setMain(
                          new Main().setSource(new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("my-index")))
                        )
                        .setInjectedItems(
                          Arrays.asList(
                            new InjectedItem()
                              .setKey("my-unique-injected-item-key")
                              .setSource(new SearchSource().setSearch(new Search().setIndex("my-index")))
                              .setPosition(0)
                              .setLength(3)
                          )
                        )
                        .setDeduplication(new Deduplication().setPositioning(DedupPositioning.HIGHEST_INJECTED))
                    )
                  )
                )
            )
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search
  void snippetForSearch() throws Exception {
    // >SEPARATOR search search
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchResponse response = client.search("foo", new RequestBody().setParams(new Params().setQuery("batman")), Hit.class);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search
  void snippetForSearch1() throws Exception {
    // >SEPARATOR search search
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchResponse response = client.search(
      "foo",
      new RequestBody().setParams(
        new Params()
          .setQuery("batman")
          .setInjectedItems(
            new HashMap() {
              {
                put(
                  "my-unique-external-group-key",
                  new ExternalInjectedItem().setItems(
                    Arrays.asList(
                      new ExternalInjection().setObjectID("my-object-1"),
                      new ExternalInjection()
                        .setObjectID("my-object-2")
                        .setMetadata(
                          new HashMap() {
                            {
                              put("my-string", "string");
                              put("my-bool", true);
                              put("my-number", 42);
                              put(
                                "my-object",
                                new HashMap() {
                                  {
                                    put("sub-key", "sub-value");
                                  }
                                }
                              );
                            }
                          }
                        )
                    )
                  )
                );
              }
            }
          )
      ),
      Hit.class
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the search method.
  //
  // search
  void snippetForSearch2() throws Exception {
    // >SEPARATOR search search
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchResponse response = client.search(
      "foo",
      new RequestBody().setParams(new Params().setQuery("batman").setSortBy("Price (asc)")),
      Hit.class
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchCompositionRules method.
  //
  // searchCompositionRules
  void snippetForSearchCompositionRules() throws Exception {
    // >SEPARATOR searchCompositionRules default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchCompositionRulesResponse response = client.searchCompositionRules("foo", new SearchCompositionRulesParams().setQuery("batman"));
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // searchForFacetValues
  void snippetForSearchForFacetValues() throws Exception {
    // >SEPARATOR searchForFacetValues default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchForFacetValuesResponse response = client.searchForFacetValues(
      "foo",
      "brand",
      new SearchForFacetValuesRequest().setParams(new SearchForFacetValuesParams().setMaxFacetHits(10))
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateSortingStrategyComposition method.
  //
  // updateSortingStrategyComposition
  void snippetForUpdateSortingStrategyComposition() throws Exception {
    // >SEPARATOR updateSortingStrategyComposition default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    TaskIDResponse response = client.updateSortingStrategyComposition(
      "my-compo",
      new HashMap() {
        {
          put("Price-asc", "products-low-to-high");
          put("Price-desc", "products-high-to-low");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }
}

package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.CompositionClient;
import com.algolia.config.*;
import com.algolia.model.composition.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositionClientRequestsTests {

  private CompositionClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new CompositionClient("appId", "apiKey", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("allow del method for a custom path with minimal parameters")
  void customDeleteTest() {
    assertDoesNotThrow(() -> {
      client.customDelete("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    assertDoesNotThrow(() -> {
      client.customDelete(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow get method for a custom path with minimal parameters")
  void customGetTest() {
    assertDoesNotThrow(() -> {
      client.customGet("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    assertDoesNotThrow(() -> {
      client.customGet(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters with space");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions should be escaped too")
  void customGetTest2() {
    assertDoesNotThrow(() -> {
      client.customGet(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-header-1\":\"spaces are left alone\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("allow post method for a custom path with minimal parameters")
  void customPostTest() {
    assertDoesNotThrow(() -> {
      client.customPost("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default query parameters")
  void customPostTest2() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions merges query parameters with default ones")
  void customPostTest3() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default headers")
  void customPostTest4() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions merges headers with default ones")
  void customPostTest5() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts booleans")
  void customPostTest6() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"isItWorking\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts integers")
  void customPostTest7() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of string")
  void customPostTest8() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of booleans")
  void customPostTest9() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of integers")
  void customPostTest10() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow put method for a custom path with minimal parameters")
  void customPutTest() {
    assertDoesNotThrow(() -> {
      client.customPut("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    assertDoesNotThrow(() -> {
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("deleteComposition")
  void deleteCompositionTest() {
    assertDoesNotThrow(() -> {
      client.deleteComposition("1234");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/1234", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteCompositionRule")
  void deleteCompositionRuleTest() {
    assertDoesNotThrow(() -> {
      client.deleteCompositionRule("1234", "5678");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/1234/rules/5678", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getComposition")
  void getCompositionTest() {
    assertDoesNotThrow(() -> {
      client.getComposition("foo");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRule")
  void getRuleTest() {
    assertDoesNotThrow(() -> {
      client.getRule("foo", "123");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/rules/123", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest() {
    assertDoesNotThrow(() -> {
      client.getTask("foo", 42L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/task/42", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listCompositions")
  void listCompositionsTest() {
    assertDoesNotThrow(() -> {
      client.listCompositions();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listCompositions")
  void listCompositionsTest1() {
    assertDoesNotThrow(() -> {
      client.listCompositions();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/*/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"foo\",\"name\":\"my" +
          " first" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"bar\"}}}}}}},{\"action\":\"delete\",\"body\":{\"objectID\":\"baz\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest1() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/*/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"my-external-injection-compo\",\"name\":\"my" +
          " first" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-external-group-key\",\"source\":{\"external\":{\"index\":\"foo\",\"ordering\":\"userDefined\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1}]}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest2() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/*/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"my-metadata-compo\",\"name\":\"my" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}}},\"injectedItems\":[{\"key\":\"my-unique-group-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}},{\"key\":\"my-unique-group-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:puma\"}}},\"position\":5,\"length\":5,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}}]}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("multipleBatch")
  void multipleBatchTest3() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/*/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"my-compo\",\"name\":\"my" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-injected-item-key\",\"source\":{\"search\":{\"index\":\"foo\"}},\"position\":2,\"length\":1}],\"deduplication\":{\"positioning\":\"highest\"}}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putComposition")
  void putCompositionTest() {
    assertDoesNotThrow(() -> {
      client.putComposition(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/1234", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"1234\",\"name\":\"my first" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-group-key\",\"source\":{\"search\":{\"index\":\"foo\"}},\"position\":2,\"length\":1}]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putComposition")
  void putCompositionTest1() {
    assertDoesNotThrow(() -> {
      client.putComposition(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-external-injection-compo", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"my-external-injection-compo\",\"name\":\"my first" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-external-group-key\",\"source\":{\"external\":{\"index\":\"foo\",\"ordering\":\"userDefined\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1}]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putComposition")
  void putCompositionTest2() {
    assertDoesNotThrow(() -> {
      client.putComposition(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-metadata-compo", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"my-metadata-compo\",\"name\":\"my" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}}},\"injectedItems\":[{\"key\":\"my-unique-group-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}},{\"key\":\"my-unique-group-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:puma\"}}},\"position\":5,\"length\":5,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}}]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putComposition")
  void putCompositionTest3() {
    assertDoesNotThrow(() -> {
      client.putComposition(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-compo", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"my-compo\",\"name\":\"my" +
          " composition\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}}},\"injectedItems\":[{\"key\":\"my-unique-injected-item-key\",\"source\":{\"search\":{\"index\":\"foo\"}},\"position\":2,\"length\":1}],\"deduplication\":{\"positioning\":\"highest\"}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putComposition")
  void putCompositionTest4() {
    assertDoesNotThrow(() -> {
      client.putComposition(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-compo", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"my-compo\",\"name\":\"my" +
          " composition\",\"sortingStrategy\":{\"Price-asc\":\"products-low-to-high\",\"Price-desc\":\"products-high-to-low\"},\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"products\"}}}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putCompositionRule")
  void putCompositionRuleTest() {
    assertDoesNotThrow(() -> {
      client.putCompositionRule(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/compositionID/rules/ruleID", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"ruleID\",\"conditions\":[{\"anchoring\":\"is\",\"pattern\":\"test\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-group-from-rule-key\",\"source\":{\"search\":{\"index\":\"foo\"}},\"position\":2,\"length\":1}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putCompositionRule")
  void putCompositionRuleTest1() {
    assertDoesNotThrow(() -> {
      client.putCompositionRule(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/compositionID/rules/rule-with-metadata", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"rule-with-metadata\",\"conditions\":[{\"anchoring\":\"is\",\"pattern\":\"test\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-group-from-rule-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putCompositionRule")
  void putCompositionRuleTest2() {
    assertDoesNotThrow(() -> {
      client.putCompositionRule(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/compositionID/rules/rule-with-exernal-source", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"rule-with-exernal-source\",\"description\":\"my" +
          " description\",\"tags\":[\"tag1\",\"tag2\"],\"enabled\":true,\"validity\":[{\"from\":1704063600,\"until\":1704083600}],\"conditions\":[{\"anchoring\":\"contains\",\"pattern\":\"harry\"},{\"anchoring\":\"contains\",\"pattern\":\"potter\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"my-index\",\"params\":{\"filters\":\"brand:adidas\"}}}},\"injectedItems\":[{\"key\":\"my-unique-external-group-from-rule-key\",\"source\":{\"external\":{\"index\":\"my-index\",\"params\":{\"filters\":\"brand:adidas\"},\"ordering\":\"userDefined\"}},\"position\":0,\"length\":3}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("putCompositionRule")
  void putCompositionRuleTest3() {
    assertDoesNotThrow(() -> {
      client.putCompositionRule(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/compositionID/rules/rule-with-deduplication", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"rule-with-deduplication\",\"description\":\"my" +
          " description\",\"enabled\":true,\"conditions\":[{\"anchoring\":\"contains\",\"pattern\":\"harry\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"my-index\"}}},\"injectedItems\":[{\"key\":\"my-unique-injected-item-key\",\"source\":{\"search\":{\"index\":\"my-index\"}},\"position\":0,\"length\":3}],\"deduplication\":{\"positioning\":\"highestInjected\"}}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRules")
  void saveRulesTest() {
    assertDoesNotThrow(() -> {
      client.saveRules(
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
                          new Main().setSource(
                            new CompositionSource().setSearch(new CompositionSourceSearch().setIndex("<YOUR_INDEX_NAME>"))
                          )
                        )
                      )
                    )
                  )
              )
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"123\",\"conditions\":[{\"pattern\":\"a\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"<YOUR_INDEX_NAME>\"}}}}}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRules")
  void saveRulesTest1() {
    assertDoesNotThrow(() -> {
      client.saveRules(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/rule-with-metadata/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"rule-with-metadata\",\"conditions\":[{\"anchoring\":\"is\",\"pattern\":\"test\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"foo\"}}},\"injectedItems\":[{\"key\":\"my-unique-group-from-rule-key\",\"source\":{\"search\":{\"index\":\"foo\",\"params\":{\"filters\":\"brand:adidas\"}}},\"position\":2,\"length\":1,\"metadata\":{\"hits\":{\"addItemKey\":true,\"extra\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}}}]}}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRules")
  void saveRulesTest2() {
    assertDoesNotThrow(() -> {
      client.saveRules(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/rule-with-exernal-source/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"rule-with-exernal-source\",\"description\":\"my" +
          " description\",\"tags\":[\"tag1\",\"tag2\"],\"enabled\":true,\"validity\":[{\"from\":1704063600,\"until\":1704083600}],\"conditions\":[{\"anchoring\":\"contains\",\"pattern\":\"harry\"},{\"anchoring\":\"contains\",\"pattern\":\"potter\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"my-index\",\"params\":{\"filters\":\"brand:adidas\"}}}},\"injectedItems\":[{\"key\":\"my-unique-external-group-from-rule-key\",\"source\":{\"external\":{\"index\":\"my-index\",\"params\":{\"filters\":\"brand:adidas\"},\"ordering\":\"userDefined\"}},\"position\":0,\"length\":3}]}}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRules")
  void saveRulesTest3() {
    assertDoesNotThrow(() -> {
      client.saveRules(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-compo/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"upsert\",\"body\":{\"objectID\":\"rule-with-deduplication\",\"description\":\"my" +
          " description\",\"enabled\":true,\"conditions\":[{\"anchoring\":\"contains\",\"pattern\":\"harry\"},{\"sortBy\":\"price-low-to-high\"}],\"consequence\":{\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"my-index\"}}},\"injectedItems\":[{\"key\":\"my-unique-injected-item-key\",\"source\":{\"search\":{\"index\":\"my-index\"}},\"position\":0,\"length\":3}],\"deduplication\":{\"positioning\":\"highestInjected\"}}}}}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search")
  void searchTest() {
    assertDoesNotThrow(() -> {
      client.search("foo", new RequestBody().setParams(new Params().setQuery("batman")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"params\":{\"query\":\"batman\"}}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search")
  void searchTest1() {
    assertDoesNotThrow(() -> {
      client.search(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"params\":{\"query\":\"batman\",\"injectedItems\":{\"my-unique-external-group-key\":{\"items\":[{\"objectID\":\"my-object-1\"},{\"objectID\":\"my-object-2\",\"metadata\":{\"my-string\":\"string\",\"my-bool\":true,\"my-number\":42,\"my-object\":{\"sub-key\":\"sub-value\"}}}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search")
  void searchTest2() {
    assertDoesNotThrow(() -> {
      client.search("foo", new RequestBody().setParams(new Params().setQuery("batman").setSortBy("Price (asc)")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"params\":{\"query\":\"batman\",\"sortBy\":\"Price (asc)\"}}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchCompositionRules")
  void searchCompositionRulesTest() {
    assertDoesNotThrow(() -> {
      client.searchCompositionRules("foo", new SearchCompositionRulesParams().setQuery("batman"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/rules/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"batman\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("searchForFacetValues")
  void searchForFacetValuesTest() {
    assertDoesNotThrow(() -> {
      client.searchForFacetValues(
        "foo",
        "brand",
        new SearchForFacetValuesRequest().setParams(new SearchForFacetValuesParams().setMaxFacetHits(10))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/foo/facets/brand/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"params\":{\"maxFacetHits\":10}}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateSortingStrategyComposition")
  void updateSortingStrategyCompositionTest() {
    assertDoesNotThrow(() -> {
      client.updateSortingStrategyComposition(
        "my-compo",
        new HashMap() {
          {
            put("Price-asc", "products-low-to-high");
            put("Price-desc", "products-high-to-low");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/compositions/my-compo/sortingStrategy", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"Price-asc\":\"products-low-to-high\",\"Price-desc\":\"products-high-to-low\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }
}

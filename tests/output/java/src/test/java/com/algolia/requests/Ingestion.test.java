package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.IngestionClient;
import com.algolia.config.*;
import com.algolia.model.ingestion.*;
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
class IngestionClientRequestsTests {

  private IngestionClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new IngestionClient("appId", "apiKey", "us", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("createAuthenticationOAuth")
  void createAuthenticationTest() {
    assertDoesNotThrow(() -> {
      client.createAuthentication(
        new AuthenticationCreate()
          .setType(AuthenticationType.OAUTH)
          .setName("authName")
          .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createAuthenticationAlgolia")
  void createAuthenticationTest1() {
    assertDoesNotThrow(() -> {
      client.createAuthentication(
        new AuthenticationCreate()
          .setType(AuthenticationType.ALGOLIA)
          .setName("authName")
          .setInput(new AuthAlgolia().setAppID("ALGOLIA_APPLICATION_ID").setApiKey("ALGOLIA_API_KEY"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"algolia\",\"name\":\"authName\",\"input\":{\"appID\":\"ALGOLIA_APPLICATION_ID\",\"apiKey\":\"ALGOLIA_API_KEY\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createDestination")
  void createDestinationTest() {
    assertDoesNotThrow(() -> {
      client.createDestination(
        new DestinationCreate()
          .setType(DestinationType.SEARCH)
          .setName("destinationName")
          .setInput(new DestinationInput().setIndexName("full_name______"))
          .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexName\":\"full_name______\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("with transformationIDs")
  void createDestinationTest1() {
    assertDoesNotThrow(() -> {
      client.createDestination(
        new DestinationCreate()
          .setType(DestinationType.SEARCH)
          .setName("destinationName")
          .setInput(new DestinationInput().setIndexName("full_name______"))
          .setTransformationIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexName\":\"full_name______\"},\"transformationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createSource")
  void createSourceTest() {
    assertDoesNotThrow(() -> {
      client.createSource(
        new SourceCreate()
          .setType(SourceType.COMMERCETOOLS)
          .setName("sourceName")
          .setInput(
            new SourceCommercetools()
              .setStoreKeys(Arrays.asList("myStore"))
              .setLocales(Arrays.asList("de"))
              .setUrl("http://commercetools.com")
              .setProjectKey("keyID")
              .setProductQueryPredicate("masterVariant(attributes(name=\"Brand\" and value=\"Algolia\"))")
          )
          .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"commercetools\",\"name\":\"sourceName\",\"input\":{\"storeKeys\":[\"myStore\"],\"locales\":[\"de\"],\"url\":\"http://commercetools.com\",\"projectKey\":\"keyID\",\"productQueryPredicate\":\"masterVariant(attributes(name=\\\"Brand\\\"" +
        " and value=\\\"Algolia\\\"))\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("push")
  void createSourceTest1() {
    assertDoesNotThrow(() -> {
      client.createSource(new SourceCreate().setType(SourceType.PUSH).setName("pushezpourentrer"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"type\":\"push\",\"name\":\"pushezpourentrer\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("task without cron")
  void createTaskTest() {
    assertDoesNotThrow(() -> {
      client.createTask(new TaskCreate().setSourceID("search").setDestinationID("destinationID").setAction(ActionType.REPLACE));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationID\",\"action\":\"replace\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("task with cron")
  void createTaskTest1() {
    assertDoesNotThrow(() -> {
      client.createTask(
        new TaskCreate()
          .setSourceID("search")
          .setDestinationID("destinationID")
          .setCron("* * * * *")
          .setAction(ActionType.REPLACE)
          .setNotifications(new Notifications().setEmail(new EmailNotifications().setEnabled(true)))
          .setPolicies(new Policies().setCriticalThreshold(8))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationID\",\"cron\":\"* * * *" +
        " *\",\"action\":\"replace\",\"notifications\":{\"email\":{\"enabled\":true}},\"policies\":{\"criticalThreshold\":8}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("task shopify")
  void createTaskTest2() {
    assertDoesNotThrow(() -> {
      client.createTask(
        new TaskCreate()
          .setSourceID("search")
          .setDestinationID("destinationID")
          .setCron("* * * * *")
          .setAction(ActionType.REPLACE)
          .setInput(
            new DockerStreamsInput().setStreams(
              Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationID\",\"cron\":\"* * * *" +
        " *\",\"action\":\"replace\",\"input\":{\"streams\":[{\"name\":\"foo\",\"syncMode\":\"incremental\"}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createTaskOnDemand")
  void createTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.createTaskV1(
        new TaskCreateV1()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
          .setAction(ActionType.REPLACE)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createTaskSchedule")
  void createTaskV1Test1() {
    assertDoesNotThrow(() -> {
      client.createTaskV1(
        new TaskCreateV1()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new ScheduleTriggerInput().setType(ScheduleTriggerType.SCHEDULE).setCron("* * * * *"))
          .setAction(ActionType.REPLACE)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"schedule\",\"cron\":\"*" +
        " * * * *\"},\"action\":\"replace\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createTaskSubscription")
  void createTaskV1Test2() {
    assertDoesNotThrow(() -> {
      client.createTaskV1(
        new TaskCreateV1()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
          .setAction(ActionType.REPLACE)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("task shopify")
  void createTaskV1Test3() {
    assertDoesNotThrow(() -> {
      client.createTaskV1(
        new TaskCreateV1()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.ON_DEMAND))
          .setAction(ActionType.REPLACE)
          .setInput(
            new DockerStreamsInput().setStreams(
              Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\",\"input\":{\"streams\":[{\"name\":\"foo\",\"syncMode\":\"incremental\"}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createTransformation")
  void createTransformationTest() {
    assertDoesNotThrow(() -> {
      client.createTransformation(
        new TransformationCreate()
          .setInput(new TransformationCode().setCode("foo"))
          .setType(TransformationType.CODE)
          .setName("bar")
          .setDescription("baz")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"input\":{\"code\":\"foo\"},\"type\":\"code\",\"name\":\"bar\",\"description\":\"baz\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
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
            put("query", "to be overriden");
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
  @DisplayName("deleteAuthentication")
  void deleteAuthenticationTest() {
    assertDoesNotThrow(() -> {
      client.deleteAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteDestination")
  void deleteDestinationTest() {
    assertDoesNotThrow(() -> {
      client.deleteDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteSource")
  void deleteSourceTest() {
    assertDoesNotThrow(() -> {
      client.deleteSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteTask")
  void deleteTaskTest() {
    assertDoesNotThrow(() -> {
      client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteTaskV1")
  void deleteTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.deleteTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteTransformation")
  void deleteTransformationTest() {
    assertDoesNotThrow(() -> {
      client.deleteTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("disableTask")
  void disableTaskTest() {
    assertDoesNotThrow(() -> {
      client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("disableTaskV1")
  void disableTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.disableTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("enableTask")
  void enableTaskTest() {
    assertDoesNotThrow(() -> {
      client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("enableTaskV1")
  void enableTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.enableTaskV1("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("getAuthentication")
  void getAuthenticationTest() {
    assertDoesNotThrow(() -> {
      client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getDestination")
  void getDestinationTest() {
    assertDoesNotThrow(() -> {
      client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvent")
  void getEventTest() {
    assertDoesNotThrow(() -> {
      client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRun")
  void getRunTest() {
    assertDoesNotThrow(() -> {
      client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSource")
  void getSourceTest() {
    assertDoesNotThrow(() -> {
      client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest() {
    assertDoesNotThrow(() -> {
      client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTaskV1")
  void getTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.getTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTransformation")
  void getTransformationTest() {
    assertDoesNotThrow(() -> {
      client.getTransformation("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getAuthentications")
  void listAuthenticationsTest() {
    assertDoesNotThrow(() -> {
      client.listAuthentications();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getAuthentications with query params")
  void listAuthenticationsTest1() {
    assertDoesNotThrow(() -> {
      client.listAuthentications(
        2,
        1,
        Arrays.asList(AuthenticationType.BASIC, AuthenticationType.ALGOLIA),
        Arrays.asList(PlatformNone.NONE),
        AuthenticationSortKeys.CREATED_AT,
        OrderKeys.ASC
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"itemsPerPage\":\"2\",\"page\":\"1\",\"type\":\"basic%2Calgolia\",\"platform\":\"none\",\"sort\":\"createdAt\",\"order\":\"asc\"}",
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
  @DisplayName("getDestinations")
  void listDestinationsTest() {
    assertDoesNotThrow(() -> {
      client.listDestinations();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvents")
  void listEventsTest() {
    assertDoesNotThrow(() -> {
      client.listEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listRuns")
  void listRunsTest() {
    assertDoesNotThrow(() -> {
      client.listRuns();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listSources")
  void listSourcesTest() {
    assertDoesNotThrow(() -> {
      client.listSources();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listTasks")
  void listTasksTest() {
    assertDoesNotThrow(() -> {
      client.listTasks();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listTasksV1")
  void listTasksV1Test() {
    assertDoesNotThrow(() -> {
      client.listTasksV1();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listTransformations")
  void listTransformationsTest() {
    assertDoesNotThrow(() -> {
      client.listTransformations();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("list with every parameters")
  void listTransformationsTest1() {
    assertDoesNotThrow(() -> {
      client.listTransformations(2, 1, TransformationSortKeys.CREATED_AT, OrderKeys.ASC, TransformationType.NO_CODE);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"itemsPerPage\":\"2\",\"page\":\"1\",\"sort\":\"createdAt\",\"order\":\"asc\",\"type\":\"noCode\"}",
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
  @DisplayName("global push")
  void pushTest() {
    assertDoesNotThrow(() -> {
      client.push(
        "foo",
        new PushTaskPayload()
          .setAction(Action.ADD_OBJECT)
          .setRecords(
            Arrays.asList(
              new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
              new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/push/foo", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"action\":\"addObject\",\"records\":[{\"key\":\"bar\",\"foo\":\"1\",\"objectID\":\"o\"},{\"key\":\"baz\",\"foo\":\"2\",\"objectID\":\"k\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("global push with watch mode")
  void pushTest1() {
    assertDoesNotThrow(() -> {
      client.push(
        "bar",
        new PushTaskPayload()
          .setAction(Action.ADD_OBJECT)
          .setRecords(
            Arrays.asList(
              new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
              new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
            )
          ),
        true,
        "foo"
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/push/bar", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"action\":\"addObject\",\"records\":[{\"key\":\"bar\",\"foo\":\"1\",\"objectID\":\"o\"},{\"key\":\"baz\",\"foo\":\"2\",\"objectID\":\"k\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"watch\":\"true\",\"referenceIndexName\":\"foo\"}",
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
  @DisplayName("pushTask")
  void pushTaskTest() {
    assertDoesNotThrow(() -> {
      client.pushTask(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new PushTaskPayload()
          .setAction(Action.ADD_OBJECT)
          .setRecords(
            Arrays.asList(
              new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
              new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/push", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"action\":\"addObject\",\"records\":[{\"key\":\"bar\",\"foo\":\"1\",\"objectID\":\"o\"},{\"key\":\"baz\",\"foo\":\"2\",\"objectID\":\"k\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("allows for watch query parameter")
  void pushTaskTest1() {
    assertDoesNotThrow(() -> {
      client.pushTask(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new PushTaskPayload()
          .setAction(Action.ADD_OBJECT)
          .setRecords(
            Arrays.asList(
              new PushTaskRecords().setAdditionalProperty("key", "bar").setAdditionalProperty("foo", "1").setObjectID("o"),
              new PushTaskRecords().setAdditionalProperty("key", "baz").setAdditionalProperty("foo", "2").setObjectID("k")
            )
          ),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/push", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"action\":\"addObject\",\"records\":[{\"key\":\"bar\",\"foo\":\"1\",\"objectID\":\"o\"},{\"key\":\"baz\",\"foo\":\"2\",\"objectID\":\"k\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue("{\"watch\":\"true\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("fully replace task without cron")
  void replaceTaskTest() {
    assertDoesNotThrow(() -> {
      client.replaceTask(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TaskReplace().setDestinationID("destinationID").setAction(ActionType.REPLACE)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"destinationID\":\"destinationID\",\"action\":\"replace\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("fully replace task with cron")
  void replaceTaskTest1() {
    assertDoesNotThrow(() -> {
      client.replaceTask(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TaskReplace()
          .setDestinationID("destinationID")
          .setCron("* * * * *")
          .setAction(ActionType.REPLACE)
          .setNotifications(new Notifications().setEmail(new EmailNotifications().setEnabled(true)))
          .setPolicies(new Policies().setCriticalThreshold(8))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"destinationID\":\"destinationID\",\"cron\":\"* * * *" +
        " *\",\"action\":\"replace\",\"notifications\":{\"email\":{\"enabled\":true}},\"policies\":{\"criticalThreshold\":8}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("fully replace task shopify")
  void replaceTaskTest2() {
    assertDoesNotThrow(() -> {
      client.replaceTask(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TaskReplace()
          .setDestinationID("destinationID")
          .setCron("* * * * *")
          .setAction(ActionType.REPLACE)
          .setInput(
            new DockerStreamsInput().setStreams(
              Arrays.asList(new DockerStreams().setName("foo").setSyncMode(DockerStreamsSyncMode.INCREMENTAL))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"destinationID\":\"destinationID\",\"cron\":\"* * * *" +
        " *\",\"action\":\"replace\",\"input\":{\"streams\":[{\"name\":\"foo\",\"syncMode\":\"incremental\"}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("runSource")
  void runSourceTest() {
    assertDoesNotThrow(() -> {
      client.runSource(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new RunSourcePayload()
          .setIndexToInclude(Arrays.asList("products_us", "products eu"))
          .setEntityIDs(Arrays.asList("1234", "5678"))
          .setEntityType(EntityType.PRODUCT)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"indexToInclude\":[\"products_us\",\"products" + " eu\"],\"entityIDs\":[\"1234\",\"5678\"],\"entityType\":\"product\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("runTask")
  void runTaskTest() {
    assertDoesNotThrow(() -> {
      client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("runTaskV1")
  void runTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.runTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("searchAuthentications")
  void searchAuthenticationsTest() {
    assertDoesNotThrow(() -> {
      client.searchAuthentications(
        new AuthenticationSearch().setAuthenticationIDs(
          Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"authenticationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchDestinations")
  void searchDestinationsTest() {
    assertDoesNotThrow(() -> {
      client.searchDestinations(
        new DestinationSearch().setDestinationIDs(
          Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"destinationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchSources")
  void searchSourcesTest() {
    assertDoesNotThrow(() -> {
      client.searchSources(
        new SourceSearch().setSourceIDs(Arrays.asList("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchTasks")
  void searchTasksTest() {
    assertDoesNotThrow(() -> {
      client.searchTasks(
        new TaskSearch().setTaskIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\",\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchTasksV1")
  void searchTasksV1Test() {
    assertDoesNotThrow(() -> {
      client.searchTasksV1(
        new TaskSearch().setTaskIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\",\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchTransformations")
  void searchTransformationsTest() {
    assertDoesNotThrow(() -> {
      client.searchTransformations(
        new TransformationSearch().setTransformationIDs(
          Arrays.asList(
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"transformationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\",\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("triggerDockerSourceDiscover")
  void triggerDockerSourceDiscoverTest() {
    assertDoesNotThrow(() -> {
      client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("tryTransformation")
  void tryTransformationTest() {
    assertDoesNotThrow(() -> {
      client.tryTransformation(
        new TransformationTry()
          .setType(TransformationType.CODE)
          .setInput(new TransformationCode().setCode("foo"))
          .setSampleRecord(
            new HashMap() {
              {
                put("bar", "baz");
              }
            }
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/try", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"code\",\"input\":{\"code\":\"foo\"},\"sampleRecord\":{\"bar\":\"baz\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("with authentications")
  void tryTransformationTest1() {
    assertDoesNotThrow(() -> {
      client.tryTransformation(
        new TransformationTry()
          .setType(TransformationType.CODE)
          .setInput(new TransformationCode().setCode("foo"))
          .setSampleRecord(
            new HashMap() {
              {
                put("bar", "baz");
              }
            }
          )
          .setAuthentications(
            Arrays.asList(
              new AuthenticationCreate()
                .setType(AuthenticationType.OAUTH)
                .setName("authName")
                .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/try", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"code\",\"input\":{\"code\":\"foo\"},\"sampleRecord\":{\"bar\":\"baz\"},\"authentications\":[{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("tryTransformationBeforeUpdate")
  void tryTransformationBeforeUpdateTest() {
    assertDoesNotThrow(() -> {
      client.tryTransformationBeforeUpdate(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TransformationTry()
          .setType(TransformationType.CODE)
          .setInput(new TransformationCode().setCode("foo"))
          .setSampleRecord(
            new HashMap() {
              {
                put("bar", "baz");
              }
            }
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/6c02aeb1-775e-418e-870b-1faccd4b2c0f/try", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"code\",\"input\":{\"code\":\"foo\"},\"sampleRecord\":{\"bar\":\"baz\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("existing with authentications")
  void tryTransformationBeforeUpdateTest1() {
    assertDoesNotThrow(() -> {
      client.tryTransformationBeforeUpdate(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TransformationTry()
          .setType(TransformationType.CODE)
          .setInput(new TransformationCode().setCode("foo"))
          .setSampleRecord(
            new HashMap() {
              {
                put("bar", "baz");
              }
            }
          )
          .setAuthentications(
            Arrays.asList(
              new AuthenticationCreate()
                .setType(AuthenticationType.OAUTH)
                .setName("authName")
                .setInput(new AuthOAuth().setUrl("http://test.oauth").setClientId("myID").setClientSecret("mySecret"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/6c02aeb1-775e-418e-870b-1faccd4b2c0f/try", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"code\",\"input\":{\"code\":\"foo\"},\"sampleRecord\":{\"bar\":\"baz\"},\"authentications\":[{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("updateAuthentication")
  void updateAuthenticationTest() {
    assertDoesNotThrow(() -> {
      client.updateAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new AuthenticationUpdate().setName("newName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateDestination")
  void updateDestinationTest() {
    assertDoesNotThrow(() -> {
      client.updateDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new DestinationUpdate().setName("newName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateSource")
  void updateSourceTest() {
    assertDoesNotThrow(() -> {
      client.updateSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateTask")
  void updateTaskTest() {
    assertDoesNotThrow(() -> {
      client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false).setCron("* * * * *"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enabled\":false,\"cron\":\"* * * * *\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateTaskV1")
  void updateTaskV1Test() {
    assertDoesNotThrow(() -> {
      client.updateTaskV1("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdateV1().setEnabled(false));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enabled\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateTransformation")
  void updateTransformationTest() {
    assertDoesNotThrow(() -> {
      client.updateTransformation(
        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
        new TransformationCreate()
          .setInput(new TransformationCode().setCode("foo"))
          .setType(TransformationType.CODE)
          .setName("bar")
          .setDescription("baz")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/transformations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"input\":{\"code\":\"foo\"},\"type\":\"code\",\"name\":\"bar\",\"description\":\"baz\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("validateSource")
  void validateSourceTest() {
    assertDoesNotThrow(() -> {
      client.validateSource(
        new SourceCreate()
          .setType(SourceType.COMMERCETOOLS)
          .setName("sourceName")
          .setInput(
            new SourceCommercetools()
              .setStoreKeys(Arrays.asList("myStore"))
              .setLocales(Arrays.asList("de"))
              .setUrl("http://commercetools.com")
              .setProjectKey("keyID")
          )
          .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/validate", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"commercetools\",\"name\":\"sourceName\",\"input\":{\"storeKeys\":[\"myStore\"],\"locales\":[\"de\"],\"url\":\"http://commercetools.com\",\"projectKey\":\"keyID\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("validateSourceBeforeUpdate")
  void validateSourceBeforeUpdateTest() {
    assertDoesNotThrow(() -> {
      client.validateSourceBeforeUpdate("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/validate", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }
}

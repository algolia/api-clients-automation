package com.algolia.methods.requests;

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
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IngestionClientRequestsTests {

  private IngestionClient client;
  private IngestionClient clientE2E;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    var options = ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
    this.client = new IngestionClient("appId", "apiKey", "us", options);

    if ("true".equals(System.getenv("CI"))) {
      this.clientE2E = new IngestionClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      var dotenv = Dotenv.configure().directory("../../").load();
      this.clientE2E = new IngestionClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("createAuthenticationOAuth")
  void createAuthenticationTest0() {
    assertDoesNotThrow(() -> {
      client.createAuthentication(
        new AuthenticationCreate()
          .setType(AuthenticationType.fromValue("oauth"))
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
          .setType(AuthenticationType.fromValue("algolia"))
          .setName("authName")
          .setInput(new AuthAlgolia().setAppID("myappID").setApiKey("randomApiKey"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"algolia\",\"name\":\"authName\",\"input\":{\"appID\":\"myappID\",\"apiKey\":\"randomApiKey\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createDestination")
  void createDestinationTest0() {
    assertDoesNotThrow(() -> {
      client.createDestination(
        new DestinationCreate()
          .setType(DestinationType.fromValue("search"))
          .setName("destinationName")
          .setInput(new DestinationIndexPrefix().setIndexPrefix("prefix_"))
          .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexPrefix\":\"prefix_\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("createSource")
  void createSourceTest0() {
    assertDoesNotThrow(() -> {
      client.createSource(
        new SourceCreate()
          .setType(SourceType.fromValue("commercetools"))
          .setName("sourceName")
          .setInput(
            new SourceCommercetools()
              .setStoreKeys(List.of("myStore"))
              .setLocales(List.of("de"))
              .setUrl("http://commercetools.com")
              .setProjectKey("keyID")
          )
          .setAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources", req.path);
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
  @DisplayName("createTaskOnDemand")
  void createTaskTest0() {
    assertDoesNotThrow(() -> {
      client.createTask(
        new TaskCreate()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.fromValue("onDemand")))
          .setAction(ActionType.fromValue("replace"))
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
  void createTaskTest1() {
    assertDoesNotThrow(() -> {
      client.createTask(
        new TaskCreate()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new ScheduleTriggerInput().setType(ScheduleTriggerType.fromValue("schedule")).setCron("* * * * *"))
          .setAction(ActionType.fromValue("replace"))
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
  void createTaskTest2() {
    assertDoesNotThrow(() -> {
      client.createTask(
        new TaskCreate()
          .setSourceID("search")
          .setDestinationID("destinationName")
          .setTrigger(new OnDemandTriggerInput().setType(OnDemandTriggerType.fromValue("onDemand")))
          .setAction(ActionType.fromValue("replace"))
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
  @DisplayName("allow del method for a custom path with minimal parameters")
  void customDeleteTest0() {
    assertDoesNotThrow(() -> {
      client.customDelete("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    assertDoesNotThrow(() -> {
      client.customDelete("/test/all", Map.of("query", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
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
  void customGetTest0() {
    assertDoesNotThrow(() -> {
      client.customGet("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    assertDoesNotThrow(() -> {
      client.customGet("/test/all", Map.of("query", "parameters with space"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
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
        "/test/all",
        Map.of("query", "to be overriden"),
        new RequestOptions()
          .addExtraQueryParameters("query", "parameters with space")
          .addExtraQueryParameters("and an array", List.of("array", "with spaces"))
          .addExtraHeader("x-header-1", "spaces are left alone")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
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
  void customPostTest0() {
    assertDoesNotThrow(() -> {
      client.customPost("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    assertDoesNotThrow(() -> {
      client.customPost("/test/all", Map.of("query", "parameters"), Map.of("body", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraHeader("x-algolia-api-key", "myApiKey")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "{\"x-algolia-api-key\":\"myApiKey\"}",
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraHeader("x-algolia-api-key", "myApiKey")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "{\"x-algolia-api-key\":\"myApiKey\"}",
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("isItWorking", true)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", 2)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of("b and c", "d"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of(true, true, false))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of(1, 2))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
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
  void customPutTest0() {
    assertDoesNotThrow(() -> {
      client.customPut("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    assertDoesNotThrow(() -> {
      client.customPut("/test/all", Map.of("query", "parameters"), Map.of("body", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
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
  void deleteAuthenticationTest0() {
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
  void deleteDestinationTest0() {
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
  void deleteSourceTest0() {
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
  void deleteTaskTest0() {
    assertDoesNotThrow(() -> {
      client.deleteTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("disableTask")
  void disableTaskTest0() {
    assertDoesNotThrow(() -> {
      client.disableTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("enable task e2e")
  void enableTaskTest0() {
    assertDoesNotThrow(() -> {
      client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);

    var res = clientE2E.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getAuthentication")
  void getAuthenticationTest0() {
    assertDoesNotThrow(() -> {
      client.getAuthentication("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getAuthentications")
  void getAuthenticationsTest0() {
    assertDoesNotThrow(() -> {
      client.getAuthentications();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getAuthentications with query params")
  void getAuthenticationsTest1() {
    assertDoesNotThrow(() -> {
      client.getAuthentications(
        10,
        1,
        List.of(AuthenticationType.fromValue("basic"), AuthenticationType.fromValue("algolia")),
        List.of(PlatformNone.fromValue("none")),
        AuthenticationSortKeys.fromValue("createdAt"),
        OrderKeys.fromValue("desc")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"itemsPerPage\":\"10\",\"page\":\"1\",\"type\":\"basic%2Calgolia\",\"platform\":\"none\",\"sort\":\"createdAt\",\"order\":\"desc\"}",
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

    var res = clientE2E.getAuthentications(
      10,
      1,
      List.of(AuthenticationType.fromValue("basic"), AuthenticationType.fromValue("algolia")),
      List.of(PlatformNone.fromValue("none")),
      AuthenticationSortKeys.fromValue("createdAt"),
      OrderKeys.fromValue("desc")
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"pagination\":{\"page\":1,\"itemsPerPage\":10},\"authentications\":[{\"authenticationID\":\"b57a7ea5-8592-493b-b75b-6c66d77aee7f\",\"type\":\"algolia\",\"name\":\"Auto-generated" +
        " Authentication for T8JK9S7I7X -" +
        " 1704732447751\",\"input\":{},\"createdAt\":\"2024-01-08T16:47:31Z\",\"updatedAt\":\"2024-01-08T16:47:31Z\"},{},{},{},{},{},{},{}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getDestination")
  void getDestinationTest0() {
    assertDoesNotThrow(() -> {
      client.getDestination("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getDestinations")
  void getDestinationsTest0() {
    assertDoesNotThrow(() -> {
      client.getDestinations();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getDockerSourceStreams")
  void getDockerSourceStreamsTest0() {
    assertDoesNotThrow(() -> {
      client.getDockerSourceStreams("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvent")
  void getEventTest0() {
    assertDoesNotThrow(() -> {
      client.getEvent("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvents")
  void getEventsTest0() {
    assertDoesNotThrow(() -> {
      client.getEvents("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRun")
  void getRunTest0() {
    assertDoesNotThrow(() -> {
      client.getRun("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRuns")
  void getRunsTest0() {
    assertDoesNotThrow(() -> {
      client.getRuns();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSource")
  void getSourceTest0() {
    assertDoesNotThrow(() -> {
      client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    var res = clientE2E.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"name\":\"cts_e2e_browse\",\"type\":\"json\",\"input\":{\"url\":\"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json\"}}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getSources")
  void getSourcesTest0() {
    assertDoesNotThrow(() -> {
      client.getSources();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest0() {
    assertDoesNotThrow(() -> {
      client.getTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTasks")
  void getTasksTest0() {
    assertDoesNotThrow(() -> {
      client.getTasks();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("runTask")
  void runTaskTest0() {
    assertDoesNotThrow(() -> {
      client.runTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("searchAuthentications")
  void searchAuthenticationsTest0() {
    assertDoesNotThrow(() -> {
      client.searchAuthentications(
        new AuthenticationSearch()
          .setAuthenticationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
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
  void searchDestinationsTest0() {
    assertDoesNotThrow(() -> {
      client.searchDestinations(
        new DestinationSearch().setDestinationIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
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
  void searchSourcesTest0() {
    assertDoesNotThrow(() -> {
      client.searchSources(
        new SourceSearch().setSourceIDs(List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"))
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
  void searchTasksTest0() {
    assertDoesNotThrow(() -> {
      client.searchTasks(
        new TaskSearch()
          .setTaskIDs(
            List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
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

    var res = clientE2E.searchTasks(
      new TaskSearch()
        .setTaskIDs(
          List.of("6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        )
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\",\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"destinationID\":\"506d79fa-e29d-4bcf-907c-6b6a41172153\",\"trigger\":{\"type\":\"onDemand\"},\"enabled\":true,\"failureThreshold\":0,\"action\":\"replace\",\"createdAt\":\"2024-01-08T16:47:41Z\"}]",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("triggerDockerSourceDiscover")
  void triggerDockerSourceDiscoverTest0() {
    assertDoesNotThrow(() -> {
      client.triggerDockerSourceDiscover("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("updateAuthentication")
  void updateAuthenticationTest0() {
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
  void updateDestinationTest0() {
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
  void updateSourceTest0() {
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
  void updateTaskTest0() {
    assertDoesNotThrow(() -> {
      client.updateTask("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new TaskUpdate().setEnabled(false));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enabled\":false}", req.body, JSONCompareMode.STRICT));
  }
}

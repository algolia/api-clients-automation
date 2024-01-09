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
    var options = ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
    this.client = new IngestionClient("appId", "apiKey", "us", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("createAuthenticationOAuth")
  void createAuthenticationTest0() {
    AuthenticationCreate authenticationCreate0 = new AuthenticationCreate();
    {
      AuthenticationType type1 = AuthenticationType.fromValue("oauth");
      authenticationCreate0.setType(type1);
      String name1 = "authName";
      authenticationCreate0.setName(name1);
      AuthOAuth input1 = new AuthOAuth();
      {
        String url2 = "http://test.oauth";
        input1.setUrl(url2);
        String client_id2 = "myID";
        input1.setClientId(client_id2);
        String client_secret2 = "mySecret";
        input1.setClientSecret(client_secret2);
      }
      authenticationCreate0.setInput(input1);
    }

    assertDoesNotThrow(() -> {
      client.createAuthentication(authenticationCreate0);
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
    AuthenticationCreate authenticationCreate0 = new AuthenticationCreate();
    {
      AuthenticationType type1 = AuthenticationType.fromValue("algolia");
      authenticationCreate0.setType(type1);
      String name1 = "authName";
      authenticationCreate0.setName(name1);
      AuthAlgolia input1 = new AuthAlgolia();
      {
        String appID2 = "myappID";
        input1.setAppID(appID2);
        String apiKey2 = "randomApiKey";
        input1.setApiKey(apiKey2);
      }
      authenticationCreate0.setInput(input1);
    }

    assertDoesNotThrow(() -> {
      client.createAuthentication(authenticationCreate0);
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
    DestinationCreate destinationCreate0 = new DestinationCreate();
    {
      DestinationType type1 = DestinationType.fromValue("search");
      destinationCreate0.setType(type1);
      String name1 = "destinationName";
      destinationCreate0.setName(name1);
      DestinationIndexPrefix input1 = new DestinationIndexPrefix();
      {
        String indexPrefix2 = "prefix_";
        input1.setIndexPrefix(indexPrefix2);
      }
      destinationCreate0.setInput(input1);
      String authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      destinationCreate0.setAuthenticationID(authenticationID1);
    }

    assertDoesNotThrow(() -> {
      client.createDestination(destinationCreate0);
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
    SourceCreate sourceCreate0 = new SourceCreate();
    {
      SourceType type1 = SourceType.fromValue("commercetools");
      sourceCreate0.setType(type1);
      String name1 = "sourceName";
      sourceCreate0.setName(name1);
      SourceCommercetools input1 = new SourceCommercetools();
      {
        List<String> storeKeys2 = new ArrayList<>();
        {
          String storeKeys_03 = "myStore";
          storeKeys2.add(storeKeys_03);
        }
        input1.setStoreKeys(storeKeys2);
        List<String> locales2 = new ArrayList<>();
        {
          String locales_03 = "de";
          locales2.add(locales_03);
        }
        input1.setLocales(locales2);
        String url2 = "http://commercetools.com";
        input1.setUrl(url2);
        String projectKey2 = "keyID";
        input1.setProjectKey(projectKey2);
      }
      sourceCreate0.setInput(input1);
      String authenticationID1 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
      sourceCreate0.setAuthenticationID(authenticationID1);
    }

    assertDoesNotThrow(() -> {
      client.createSource(sourceCreate0);
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
    TaskCreate taskCreate0 = new TaskCreate();
    {
      String sourceID1 = "search";
      taskCreate0.setSourceID(sourceID1);
      String destinationID1 = "destinationName";
      taskCreate0.setDestinationID(destinationID1);
      OnDemandTriggerInput trigger1 = new OnDemandTriggerInput();
      {
        OnDemandTriggerType type2 = OnDemandTriggerType.fromValue("onDemand");
        trigger1.setType(type2);
      }
      taskCreate0.setTrigger(trigger1);
      ActionType action1 = ActionType.fromValue("replace");
      taskCreate0.setAction(action1);
    }

    assertDoesNotThrow(() -> {
      client.createTask(taskCreate0);
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
    TaskCreate taskCreate0 = new TaskCreate();
    {
      String sourceID1 = "search";
      taskCreate0.setSourceID(sourceID1);
      String destinationID1 = "destinationName";
      taskCreate0.setDestinationID(destinationID1);
      ScheduleTriggerInput trigger1 = new ScheduleTriggerInput();
      {
        ScheduleTriggerType type2 = ScheduleTriggerType.fromValue("schedule");
        trigger1.setType(type2);
        String cron2 = "* * * * *";
        trigger1.setCron(cron2);
      }
      taskCreate0.setTrigger(trigger1);
      ActionType action1 = ActionType.fromValue("replace");
      taskCreate0.setAction(action1);
    }

    assertDoesNotThrow(() -> {
      client.createTask(taskCreate0);
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
    TaskCreate taskCreate0 = new TaskCreate();
    {
      String sourceID1 = "search";
      taskCreate0.setSourceID(sourceID1);
      String destinationID1 = "destinationName";
      taskCreate0.setDestinationID(destinationID1);
      OnDemandTriggerInput trigger1 = new OnDemandTriggerInput();
      {
        OnDemandTriggerType type2 = OnDemandTriggerType.fromValue("onDemand");
        trigger1.setType(type2);
      }
      taskCreate0.setTrigger(trigger1);
      ActionType action1 = ActionType.fromValue("replace");
      taskCreate0.setAction(action1);
    }

    assertDoesNotThrow(() -> {
      client.createTask(taskCreate0);
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
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.customDelete(path0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }

    assertDoesNotThrow(() -> {
      client.customDelete(path0, parameters0);
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
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.customGet(path0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }

    assertDoesNotThrow(() -> {
      client.customGet(path0, parameters0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
    assertEquals("GET", req.method);
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
  @DisplayName("allow post method for a custom path with minimal parameters")
  void customPostTest0() {
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.customPost(path0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String body1 = "parameters";
      body0.put("body", body1);
    }

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("query", "myQueryParameter");

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("query2", "myQueryParameter");

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraHeader("x-algolia-api-key", "myApiKey");

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraHeader("x-algolia-api-key", "myApiKey");

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("isItWorking", true);

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("myParam", 2);

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("myParam", Arrays.asList("c", "d"));

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"c,d\"}",
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("myParam", Arrays.asList(true, true, false));

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}",
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
    String path0 = "/test/requestOptions";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String facet1 = "filters";
      body0.put("facet", facet1);
    }

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.addExtraQueryParameters("myParam", Arrays.asList(1, 2));

    assertDoesNotThrow(() -> {
      client.customPost(path0, parameters0, body0, requestOptions);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"1,2\"}",
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
    String path0 = "/test/minimal";

    assertDoesNotThrow(() -> {
      client.customPut(path0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    String path0 = "/test/all";
    Map<String, Object> parameters0 = new HashMap<>();
    {
      String query1 = "parameters";
      parameters0.put("query", query1);
    }
    Map<String, String> body0 = new HashMap<>();
    {
      String body1 = "parameters";
      body0.put("body", body1);
    }

    assertDoesNotThrow(() -> {
      client.customPut(path0, parameters0, body0);
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
    String authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.deleteAuthentication(authenticationID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteDestination")
  void deleteDestinationTest0() {
    String destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.deleteDestination(destinationID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteSource")
  void deleteSourceTest0() {
    String sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.deleteSource(sourceID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteTask")
  void deleteTaskTest0() {
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.deleteTask(taskID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("disableTask")
  void disableTaskTest0() {
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.disableTask(taskID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("enableTask")
  void enableTaskTest0() {
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.enableTask(taskID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/enable", req.path);
    assertEquals("PUT", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("getAuthentication")
  void getAuthenticationTest0() {
    String authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getAuthentication(authenticationID0);
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
  @DisplayName("getDestination")
  void getDestinationTest0() {
    String destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getDestination(destinationID0);
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
    String sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getDockerSourceStreams(sourceID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvent")
  void getEventTest0() {
    String runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    String eventID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0c";

    assertDoesNotThrow(() -> {
      client.getEvent(runID0, eventID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getEvents")
  void getEventsTest0() {
    String runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getEvents(runID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRun")
  void getRunTest0() {
    String runID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getRun(runID0);
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
    String sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getSource(sourceID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
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
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.getTask(taskID0);
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
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.runTask(taskID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("searchAuthentications")
  void searchAuthenticationsTest0() {
    AuthenticationSearch authenticationSearch0 = new AuthenticationSearch();
    {
      List<String> authenticationIDs1 = new ArrayList<>();
      {
        String authenticationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
        authenticationIDs1.add(authenticationIDs_02);
        String authenticationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
        authenticationIDs1.add(authenticationIDs_12);
      }
      authenticationSearch0.setAuthenticationIDs(authenticationIDs1);
    }

    assertDoesNotThrow(() -> {
      client.searchAuthentications(authenticationSearch0);
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
    DestinationSearch destinationSearch0 = new DestinationSearch();
    {
      List<String> destinationIDs1 = new ArrayList<>();
      {
        String destinationIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
        destinationIDs1.add(destinationIDs_02);
        String destinationIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
        destinationIDs1.add(destinationIDs_12);
      }
      destinationSearch0.setDestinationIDs(destinationIDs1);
    }

    assertDoesNotThrow(() -> {
      client.searchDestinations(destinationSearch0);
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
    SourceSearch sourceSearch0 = new SourceSearch();
    {
      List<String> sourceIDs1 = new ArrayList<>();
      {
        String sourceIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
        sourceIDs1.add(sourceIDs_02);
        String sourceIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
        sourceIDs1.add(sourceIDs_12);
      }
      sourceSearch0.setSourceIDs(sourceIDs1);
    }

    assertDoesNotThrow(() -> {
      client.searchSources(sourceSearch0);
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
    TaskSearch taskSearch0 = new TaskSearch();
    {
      List<String> taskIDs1 = new ArrayList<>();
      {
        String taskIDs_02 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
        taskIDs1.add(taskIDs_02);
        String taskIDs_12 = "947ac9c4-7e58-4c87-b1e7-14a68e99699a";
        taskIDs1.add(taskIDs_12);
      }
      taskSearch0.setTaskIDs(taskIDs1);
    }

    assertDoesNotThrow(() -> {
      client.searchTasks(taskSearch0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("triggerDockerSourceDiscover")
  void triggerDockerSourceDiscoverTest0() {
    String sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";

    assertDoesNotThrow(() -> {
      client.triggerDockerSourceDiscover(sourceID0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("updateAuthentication")
  void updateAuthenticationTest0() {
    String authenticationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    AuthenticationUpdate authenticationUpdate0 = new AuthenticationUpdate();
    {
      String name1 = "newName";
      authenticationUpdate0.setName(name1);
    }

    assertDoesNotThrow(() -> {
      client.updateAuthentication(authenticationID0, authenticationUpdate0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateDestination")
  void updateDestinationTest0() {
    String destinationID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    DestinationUpdate destinationUpdate0 = new DestinationUpdate();
    {
      String name1 = "newName";
      destinationUpdate0.setName(name1);
    }

    assertDoesNotThrow(() -> {
      client.updateDestination(destinationID0, destinationUpdate0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateSource")
  void updateSourceTest0() {
    String sourceID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    SourceUpdate sourceUpdate0 = new SourceUpdate();
    {
      String name1 = "newName";
      sourceUpdate0.setName(name1);
    }

    assertDoesNotThrow(() -> {
      client.updateSource(sourceID0, sourceUpdate0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"name\":\"newName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("updateTask")
  void updateTaskTest0() {
    String taskID0 = "6c02aeb1-775e-418e-870b-1faccd4b2c0f";
    TaskUpdate taskUpdate0 = new TaskUpdate();
    {
      boolean enabled1 = false;
      taskUpdate0.setEnabled(enabled1);
    }

    assertDoesNotThrow(() -> {
      client.updateTask(taskID0, taskUpdate0);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", req.path);
    assertEquals("PATCH", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enabled\":false}", req.body, JSONCompareMode.STRICT));
  }
}

package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .build();
  }

  SearchClient createClient() {
    return new SearchClient("appId", "apiKey", withEchoRequester());
  }

  private ClientOptions withEchoRequester() {
    return ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
  }

  private ClientOptions withCustomHosts(List<Host> hosts, boolean gzipEncoding) {
    return ClientOptions.builder().setHosts(hosts).setCompressionType(gzipEncoding ? CompressionType.GZIP : CompressionType.NONE).build();
  }

  @Test
  @DisplayName("calls api with correct read host")
  void apiTest0() {
    SearchClient client = new SearchClient("test-app-id", "test-api-key", withEchoRequester());
    client.customGet("test");
    EchoResponse result = echo.getLastResponse();
    assertEquals("test-app-id-dsn.algolia.net", result.host);
  }

  @Test
  @DisplayName("calls api with correct write host")
  void apiTest1() {
    SearchClient client = new SearchClient("test-app-id", "test-api-key", withEchoRequester());
    client.customPost("test");
    EchoResponse result = echo.getLastResponse();
    assertEquals("test-app-id.algolia.net", result.host);
  }

  @Test
  @DisplayName("tests the retry strategy")
  void apiTest2() {
    SearchClient client = new SearchClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(
        Arrays.asList(
          new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6676),
          new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6677),
          new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6678)
        ),
        false
      )
    );
    var res = client.customGet("1/test/retry/java");

    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"message\":\"ok test server response\"}", json.writeValueAsString(res), JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("tests the retry strategy error")
  void apiTest3() {
    SearchClient client = new SearchClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6676)), false)
    );
    {
      Exception exception = assertThrows(Exception.class, () -> {
        var res = client.customGet("1/test/hang/java");
      });
      assertEquals(
        "Error(s) while processing the retry strategy\n" + "Caused by: java.net.SocketTimeoutException: timeout",
        exception.getMessage()
      );
    }
  }

  @Test
  @DisplayName("test the compression strategy")
  void apiTest4() {
    SearchClient client = new SearchClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6678)), true)
    );
    var res = client.customPost("1/test/gzip", Map.of(), Map.of("message", "this is a compressed body"));

    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"message\":\"ok compression test server response\",\"body\":{\"message\":\"this" + " is a compressed body\"}}",
        json.writeValueAsString(res),
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    SearchClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp =
        "^Algolia for Java \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search" +
        " (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("the user agent contains the latest version")
  void commonApiTest1() {
    SearchClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp = "^Algolia for Java \\(4.2.5\\).*";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("calls api with default read timeouts")
  void commonApiTest2() {
    SearchClient client = createClient();

    client.customGet("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(2000, result.connectTimeout);
    assertEquals(5000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void commonApiTest3() {
    SearchClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(2000, result.connectTimeout);
    assertEquals(30000, result.responseTimeout);
  }

  @Test
  @DisplayName("call deleteObjects without error")
  void deleteObjectsTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6680)), false)
      );
      var res = client.deleteObjects("cts_e2e_deleteObjects_java", List.of("1", "2"));

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("[{\"taskID\":666,\"objectIDs\":[\"1\",\"2\"]}]", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
  }

  @Test
  @DisplayName("generate secured api key basic")
  void generateSecuredApiKeyTest0() {
    SearchClient client = createClient();

    assertDoesNotThrow(() -> {
      var res = client.generateSecuredApiKey(
        "2640659426d5107b6e47d75db9cbaef8",
        new SecuredApiKeyRestrictions().setValidUntil(2524604400L).setRestrictIndices(List.of("Movies"))
      );

      assertEquals(
        "NjFhZmE0OGEyMTI3OThiODc0OTlkOGM0YjcxYzljY2M2NmU2NDE5ZWY0NDZjMWJhNjA2NzBkMjAwOTI2YWQyZnJlc3RyaWN0SW5kaWNlcz1Nb3ZpZXMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
        res
      );
    });
  }

  @Test
  @DisplayName("generate secured api key with searchParams")
  void generateSecuredApiKeyTest1() {
    SearchClient client = createClient();

    assertDoesNotThrow(() -> {
      var res = client.generateSecuredApiKey(
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

      assertEquals(
        "MzAxMDUwYjYyODMxODQ3ZWM1ZDYzNTkxZmNjNDg2OGZjMjAzYjQyOTZhMGQ1NDJhMDFiNGMzYTYzODRhNmMxZWFyb3VuZFJhZGl1cz1hbGwmZmlsdGVycz1jYXRlZ29yeSUzQUJvb2slMjBPUiUyMGNhdGVnb3J5JTNBRWJvb2slMjBBTkQlMjBfdGFncyUzQXB1Ymxpc2hlZCZoaXRzUGVyUGFnZT0xMCZtb2RlPW5ldXJhbFNlYXJjaCZvcHRpb25hbFdvcmRzPW9uZSUyQ3R3byZxdWVyeT1iYXRtYW4mcmVzdHJpY3RJbmRpY2VzPU1vdmllcyUyQ2N0c19lMmVfc2V0dGluZ3MmcmVzdHJpY3RTb3VyY2VzPTE5Mi4xNjguMS4wJTJGMjQmdHlwb1RvbGVyYW5jZT1zdHJpY3QmdXNlclRva2VuPXVzZXIxMjMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
        res
      );
    });
  }

  @Test
  @DisplayName("indexExists")
  void indexExistsTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.indexExists("indexExistsYES");

      assertEquals(true, res);
    });
  }

  @Test
  @DisplayName("indexNotExists")
  void indexExistsTest1() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.indexExists("indexExistsNO");

      assertEquals(false, res);
    });
  }

  @Test
  @DisplayName("indexExistsWithError")
  void indexExistsTest2() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      {
        Exception exception = assertThrows(Exception.class, () -> {
          var res = client.indexExists("indexExistsERROR");
        });
        assertEquals("Status Code: 403 - {\"message\":\"Invalid API key\"}", exception.getMessage());
      }
    });
  }

  @Test
  @DisplayName("client throws with invalid parameters")
  void parametersTest0() {
    {
      Exception exception = assertThrows(Exception.class, () -> {
        SearchClient client = new SearchClient("", "", withEchoRequester());
      });
      assertEquals("`appId` is missing.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(Exception.class, () -> {
        SearchClient client = new SearchClient("", "my-api-key", withEchoRequester());
      });
      assertEquals("`appId` is missing.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(Exception.class, () -> {
        SearchClient client = new SearchClient("my-app-id", "", withEchoRequester());
      });
      assertEquals("`apiKey` is missing.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("`addApiKey` throws with invalid parameters")
  void parametersTest1() {
    SearchClient client = createClient();

    {
      Exception exception = assertThrows(Exception.class, () -> {
        client.addApiKey(null);
        EchoResponse result = echo.getLastResponse();
      });
      assertEquals("Parameter `apiKey` is required when calling `addApiKey`.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("`addOrUpdateObject` throws with invalid parameters")
  void parametersTest2() {
    SearchClient client = createClient();

    {
      Exception exception = assertThrows(Exception.class, () -> {
        client.addOrUpdateObject(null, "my-object-id", Map.of());
        EchoResponse result = echo.getLastResponse();
      });
      assertEquals("Parameter `indexName` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(Exception.class, () -> {
        client.addOrUpdateObject("my-index-name", null, Map.of());
        EchoResponse result = echo.getLastResponse();
      });
      assertEquals("Parameter `objectID` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(Exception.class, () -> {
        client.addOrUpdateObject("my-index-name", "my-object-id", null);
        EchoResponse result = echo.getLastResponse();
      });
      assertEquals("Parameter `body` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("call partialUpdateObjects with createIfNotExists=true")
  void partialUpdateObjectsTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6680)), false)
      );
      var res = client.partialUpdateObjects(
        "cts_e2e_partialUpdateObjects_java",
        List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit")),
        true
      );

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("[{\"taskID\":444,\"objectIDs\":[\"1\",\"2\"]}]", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
  }

  @Test
  @DisplayName("call partialUpdateObjects with createIfNotExists=false")
  void partialUpdateObjectsTest1() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6680)), false)
      );
      var res = client.partialUpdateObjects(
        "cts_e2e_partialUpdateObjects_java",
        List.of(Map.of("objectID", "3", "name", "Cyril"), Map.of("objectID", "4", "name", "David")),
        false
      );

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("[{\"taskID\":555,\"objectIDs\":[\"3\",\"4\"]}]", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
  }

  @Test
  @DisplayName("call replaceAllObjects without error")
  void replaceAllObjectsTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6679)), false)
      );
      var res = client.replaceAllObjects(
        "cts_e2e_replace_all_objects_java",
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

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals(
          "{\"copyOperationResponse\":{\"taskID\":125,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"},\"batchResponses\":[{\"taskID\":127,\"objectIDs\":[\"1\",\"2\",\"3\"]},{\"taskID\":130,\"objectIDs\":[\"4\",\"5\",\"6\"]},{\"taskID\":133,\"objectIDs\":[\"7\",\"8\",\"9\"]},{\"taskID\":134,\"objectIDs\":[\"10\"]}],\"moveOperationResponse\":{\"taskID\":777,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"}}",
          json.writeValueAsString(res),
          JSONCompareMode.STRICT
        )
      );
    });
  }

  @Test
  @DisplayName("call saveObjects without error")
  void saveObjectsTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6680)), false)
      );
      var res = client.saveObjects(
        "cts_e2e_saveObjects_java",
        List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit"))
      );

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("[{\"taskID\":333,\"objectIDs\":[\"1\",\"2\"]}]", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
  }

  @Test
  @DisplayName("saveObjects should report errors")
  void saveObjectsTest1() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "wrong-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6680)), false)
      );
      {
        Exception exception = assertThrows(Exception.class, () -> {
          var res = client.saveObjects(
            "cts_e2e_saveObjects_java",
            List.of(Map.of("objectID", "1", "name", "Adam"), Map.of("objectID", "2", "name", "Benoit"))
          );
        });
        assertEquals("Status Code: 403 - {\"message\":\"Invalid Application-ID or API" + " key\",\"status\":403}", exception.getMessage());
      }
    });
  }

  @Test
  @DisplayName("wait for api key helper - add")
  void waitForApiKeyTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.waitForApiKey("api-key-add-operation-test-java", ApiKeyOperation.ADD);

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals(
          "{\"value\":\"api-key-add-operation-test-java\",\"description\":\"my new api" +
          " key\",\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}",
          json.writeValueAsString(res),
          JSONCompareMode.STRICT
        )
      );
    });
  }

  @Test
  @DisplayName("wait for api key - update")
  void waitForApiKeyTest1() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.waitForApiKey(
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

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals(
          "{\"value\":\"api-key-update-operation-test-java\",\"description\":\"my" +
          " updated api" +
          " key\",\"acl\":[\"search\",\"addObject\",\"deleteObject\"],\"indexes\":[\"Movies\",\"Books\"],\"referers\":[\"*google.com\",\"*algolia.com\"],\"validity\":305,\"maxQueriesPerIPPerHour\":95,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}",
          json.writeValueAsString(res),
          JSONCompareMode.STRICT
        )
      );
    });
  }

  @Test
  @DisplayName("wait for api key - delete")
  void waitForApiKeyTest2() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.waitForApiKey("api-key-delete-operation-test-java", ApiKeyOperation.DELETE);

      assertEquals(null, res);
    });
  }

  @Test
  @DisplayName("wait for an application-level task")
  void waitForAppTaskTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.waitForAppTask(123L);

      assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"status\":\"published\"}", json.writeValueAsString(res), JSONCompareMode.STRICT));
    });
  }

  @Test
  @DisplayName("wait for task")
  void waitForTaskTest0() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient(
        "test-app-id",
        "test-api-key",
        withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6681)), false)
      );
      var res = client.waitForTask("wait-task-java", 123L);

      assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"status\":\"published\"}", json.writeValueAsString(res), JSONCompareMode.STRICT));
    });
  }
}

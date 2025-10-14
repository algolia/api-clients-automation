package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.AnalyticsClient;
import com.algolia.config.*;
import com.algolia.model.analytics.*;
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
class AnalyticsClientRequestsTests {

  private AnalyticsClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new AnalyticsClient("appId", "apiKey", "us", options);
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
  @DisplayName("get getAddToCartRate with minimal parameters")
  void getAddToCartRateTest() {
    assertDoesNotThrow(() -> {
      client.getAddToCartRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/addToCartRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getAddToCartRate with all parameters")
  void getAddToCartRateTest1() {
    assertDoesNotThrow(() -> {
      client.getAddToCartRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/addToCartRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getAverageClickPosition with minimal parameters")
  void getAverageClickPositionTest() {
    assertDoesNotThrow(() -> {
      client.getAverageClickPosition("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/averageClickPosition", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getAverageClickPosition with all parameters")
  void getAverageClickPositionTest1() {
    assertDoesNotThrow(() -> {
      client.getAverageClickPosition("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/averageClickPosition", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getClickPositions with minimal parameters")
  void getClickPositionsTest() {
    assertDoesNotThrow(() -> {
      client.getClickPositions("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/positions", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getClickPositions with all parameters")
  void getClickPositionsTest1() {
    assertDoesNotThrow(() -> {
      client.getClickPositions("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/positions", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getClickThroughRate with minimal parameters")
  void getClickThroughRateTest() {
    assertDoesNotThrow(() -> {
      client.getClickThroughRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/clickThroughRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getClickThroughRate with all parameters")
  void getClickThroughRateTest1() {
    assertDoesNotThrow(() -> {
      client.getClickThroughRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/clicks/clickThroughRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getConversationRate with minimal parameters")
  void getConversionRateTest() {
    assertDoesNotThrow(() -> {
      client.getConversionRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/conversionRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getConversationRate with all parameters")
  void getConversionRateTest1() {
    assertDoesNotThrow(() -> {
      client.getConversionRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/conversionRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getNoClickRate with minimal parameters")
  void getNoClickRateTest() {
    assertDoesNotThrow(() -> {
      client.getNoClickRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noClickRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getNoClickRate with all parameters")
  void getNoClickRateTest1() {
    assertDoesNotThrow(() -> {
      client.getNoClickRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noClickRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getNoResultsRate with minimal parameters")
  void getNoResultsRateTest() {
    assertDoesNotThrow(() -> {
      client.getNoResultsRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noResultRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getNoResultsRate with all parameters")
  void getNoResultsRateTest1() {
    assertDoesNotThrow(() -> {
      client.getNoResultsRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noResultRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getPurchaseRate with minimal parameters")
  void getPurchaseRateTest() {
    assertDoesNotThrow(() -> {
      client.getPurchaseRate("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/purchaseRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getPurchaseRate with all parameters")
  void getPurchaseRateTest1() {
    assertDoesNotThrow(() -> {
      client.getPurchaseRate("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/purchaseRate", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getRevenue with minimal parameters")
  void getRevenueTest() {
    assertDoesNotThrow(() -> {
      client.getRevenue("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/revenue", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getRevenue with all parameters")
  void getRevenueTest1() {
    assertDoesNotThrow(() -> {
      client.getRevenue("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/conversions/revenue", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getSearchesCount with minimal parameters")
  void getSearchesCountTest() {
    assertDoesNotThrow(() -> {
      client.getSearchesCount("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/count", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getSearchesCount with all parameters")
  void getSearchesCountTest1() {
    assertDoesNotThrow(() -> {
      client.getSearchesCount("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/count", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
  @DisplayName("get getSearchesNoClicks with minimal parameters")
  void getSearchesNoClicksTest() {
    assertDoesNotThrow(() -> {
      client.getSearchesNoClicks("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noClicks", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getSearchesNoClicks with all parameters")
  void getSearchesNoClicksTest1() {
    assertDoesNotThrow(() -> {
      client.getSearchesNoClicks("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noClicks", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getSearchesNoResults with minimal parameters")
  void getSearchesNoResultsTest() {
    assertDoesNotThrow(() -> {
      client.getSearchesNoResults("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noResults", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getSearchesNoResults with all parameters")
  void getSearchesNoResultsTest1() {
    assertDoesNotThrow(() -> {
      client.getSearchesNoResults("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches/noResults", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getStatus with minimal parameters")
  void getStatusTest() {
    assertDoesNotThrow(() -> {
      client.getStatus("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/status", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopCountries with minimal parameters")
  void getTopCountriesTest() {
    assertDoesNotThrow(() -> {
      client.getTopCountries("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/countries", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopCountries with all parameters")
  void getTopCountriesTest1() {
    assertDoesNotThrow(() -> {
      client.getTopCountries("index", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/countries", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopFilterAttributes with minimal parameters")
  void getTopFilterAttributesTest() {
    assertDoesNotThrow(() -> {
      client.getTopFilterAttributes("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopFilterAttributes with all parameters")
  void getTopFilterAttributesTest1() {
    assertDoesNotThrow(() -> {
      client.getTopFilterAttributes("index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopFilterForAttribute with minimal parameters")
  void getTopFilterForAttributeTest() {
    assertDoesNotThrow(() -> {
      client.getTopFilterForAttribute("myAttribute", "index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/myAttribute", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopFilterForAttribute with minimal parameters and multiple attributes")
  void getTopFilterForAttributeTest1() {
    assertDoesNotThrow(() -> {
      client.getTopFilterForAttribute("myAttribute1,myAttribute2", "index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/myAttribute1%2CmyAttribute2", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopFilterForAttribute with all parameters")
  void getTopFilterForAttributeTest2() {
    assertDoesNotThrow(() -> {
      client.getTopFilterForAttribute("myAttribute", "index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/myAttribute", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopFilterForAttribute with all parameters and multiple attributes")
  void getTopFilterForAttributeTest3() {
    assertDoesNotThrow(() -> {
      client.getTopFilterForAttribute("myAttribute1,myAttribute2", "index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/myAttribute1%2CmyAttribute2", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopFiltersNoResults with minimal parameters")
  void getTopFiltersNoResultsTest() {
    assertDoesNotThrow(() -> {
      client.getTopFiltersNoResults("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/noResults", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopFiltersNoResults with all parameters")
  void getTopFiltersNoResultsTest1() {
    assertDoesNotThrow(() -> {
      client.getTopFiltersNoResults("index", "mySearch", "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/filters/noResults", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopHits with minimal parameters")
  void getTopHitsTest() {
    assertDoesNotThrow(() -> {
      client.getTopHits("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/hits", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopHits with all parameters")
  void getTopHitsTest1() {
    assertDoesNotThrow(() -> {
      client.getTopHits("index", "mySearch", true, true, "1999-09-19", "2001-01-01", 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/hits", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"search\":\"mySearch\",\"clickAnalytics\":\"true\",\"revenueAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getTopSearches with minimal parameters")
  void getTopSearchesTest() {
    assertDoesNotThrow(() -> {
      client.getTopSearches("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getTopSearches with all parameters")
  void getTopSearchesTest1() {
    assertDoesNotThrow(() -> {
      client.getTopSearches("index", true, true, "1999-09-19", "2001-01-01", OrderBy.SEARCH_COUNT, Direction.ASC, 21, 42, "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/searches", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"clickAnalytics\":\"true\",\"revenueAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"orderBy\":\"searchCount\",\"direction\":\"asc\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}",
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
  @DisplayName("get getUsersCount with minimal parameters")
  void getUsersCountTest() {
    assertDoesNotThrow(() -> {
      client.getUsersCount("index");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/users/count", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"index\":\"index\"}", new TypeReference<HashMap<String, String>>() {});
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
  @DisplayName("get getUsersCount with all parameters")
  void getUsersCountTest1() {
    assertDoesNotThrow(() -> {
      client.getUsersCount("index", "1999-09-19", "2001-01-01", "tag");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/2/users/count", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}",
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
}

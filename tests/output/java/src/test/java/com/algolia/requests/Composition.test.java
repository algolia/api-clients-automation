package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.CompositionClient;
import com.algolia.config.*;
import com.algolia.model.composition.*;
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
}

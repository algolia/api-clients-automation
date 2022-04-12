package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.api.QuerySuggestionsApi;
import com.algolia.model.querySuggestions.*;
import com.algolia.utils.echo.*;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuerySuggestionsApiTests {

  private QuerySuggestionsApi client;

  @BeforeAll
  void init() {
    client = new QuerySuggestionsApi("appId", "apiKey", new EchoRequester());
  }

  @Test
  @DisplayName("createConfig")
  void createConfigTest0() {
    QuerySuggestionsIndexWithIndexParam querySuggestionsIndexWithIndexParam0 = new QuerySuggestionsIndexWithIndexParam();
    {
      String indexName1 = "theIndexName";

      querySuggestionsIndexWithIndexParam0.setIndexName(indexName1);

      List<SourceIndex> sourceIndices1 = new ArrayList<>();
      {
        SourceIndex sourceIndices_02 = new SourceIndex();
        {
          String indexName3 = "testIndex";

          sourceIndices_02.setIndexName(indexName3);

          List<Object> facets3 = new ArrayList<>();
          {
            Map<String, String> facets_04 = new HashMap<>();
            {
              String attributes5 = "test";

              facets_04.put("attributes", attributes5);
            }
            facets3.add(facets_04);
          }
          sourceIndices_02.setFacets(facets3);

          List<List<String>> generate3 = new ArrayList<>();
          {
            List<String> generate_04 = new ArrayList<>();
            {
              String generate_0_05 = "facetA";

              generate_04.add(generate_0_05);
              String generate_0_15 = "facetB";

              generate_04.add(generate_0_15);
            }
            generate3.add(generate_04);

            List<String> generate_14 = new ArrayList<>();
            {
              String generate_1_05 = "facetC";

              generate_14.add(generate_1_05);
            }
            generate3.add(generate_14);
          }
          sourceIndices_02.setGenerate(generate3);
        }
        sourceIndices1.add(sourceIndices_02);
      }
      querySuggestionsIndexWithIndexParam0.setSourceIndices(sourceIndices1);

      List<String> languages1 = new ArrayList<>();
      {
        String languages_02 = "french";

        languages1.add(languages_02);
      }
      querySuggestionsIndexWithIndexParam0.setLanguages(languages1);

      List<String> exclude1 = new ArrayList<>();
      {
        String exclude_02 = "test";

        exclude1.add(exclude_02);
      }
      querySuggestionsIndexWithIndexParam0.setExclude(exclude1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.createConfig(querySuggestionsIndexWithIndexParam0);
      }
    );

    assertEquals(req.getPath(), "/1/configs");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"indexName\":\"theIndexName\",\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attributes\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("deleteConfig")
  void deleteConfigTest0() {
    String indexName0 = "theIndexName";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.deleteConfig(indexName0);
      }
    );

    assertEquals(req.getPath(), "/1/configs/theIndexName");
    assertEquals(req.getMethod(), "DELETE");
  }

  @Test
  @DisplayName("getAllConfigs")
  void getAllConfigsTest0() {
    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getAllConfigs();
      }
    );

    assertEquals(req.getPath(), "/1/configs");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getConfig")
  void getConfigTest0() {
    String indexName0 = "theIndexName";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getConfig(indexName0);
      }
    );

    assertEquals(req.getPath(), "/1/configs/theIndexName");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getConfigStatus")
  void getConfigStatusTest0() {
    String indexName0 = "theIndexName";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getConfigStatus(indexName0);
      }
    );

    assertEquals(req.getPath(), "/1/configs/theIndexName/status");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("getLogFile")
  void getLogFileTest0() {
    String indexName0 = "theIndexName";

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getLogFile(indexName0);
      }
    );

    assertEquals(req.getPath(), "/1/logs/theIndexName");
    assertEquals(req.getMethod(), "GET");
  }

  @Test
  @DisplayName("updateConfig")
  void updateConfigTest0() {
    String indexName0 = "theIndexName";

    QuerySuggestionsIndexParam querySuggestionsIndexParam0 = new QuerySuggestionsIndexParam();
    {
      List<SourceIndex> sourceIndices1 = new ArrayList<>();
      {
        SourceIndex sourceIndices_02 = new SourceIndex();
        {
          String indexName3 = "testIndex";

          sourceIndices_02.setIndexName(indexName3);

          List<Object> facets3 = new ArrayList<>();
          {
            Map<String, String> facets_04 = new HashMap<>();
            {
              String attributes5 = "test";

              facets_04.put("attributes", attributes5);
            }
            facets3.add(facets_04);
          }
          sourceIndices_02.setFacets(facets3);

          List<List<String>> generate3 = new ArrayList<>();
          {
            List<String> generate_04 = new ArrayList<>();
            {
              String generate_0_05 = "facetA";

              generate_04.add(generate_0_05);
              String generate_0_15 = "facetB";

              generate_04.add(generate_0_15);
            }
            generate3.add(generate_04);

            List<String> generate_14 = new ArrayList<>();
            {
              String generate_1_05 = "facetC";

              generate_14.add(generate_1_05);
            }
            generate3.add(generate_14);
          }
          sourceIndices_02.setGenerate(generate3);
        }
        sourceIndices1.add(sourceIndices_02);
      }
      querySuggestionsIndexParam0.setSourceIndices(sourceIndices1);

      List<String> languages1 = new ArrayList<>();
      {
        String languages_02 = "french";

        languages1.add(languages_02);
      }
      querySuggestionsIndexParam0.setLanguages(languages1);

      List<String> exclude1 = new ArrayList<>();
      {
        String exclude_02 = "test";

        exclude1.add(exclude_02);
      }
      querySuggestionsIndexParam0.setExclude(exclude1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.updateConfig(indexName0, querySuggestionsIndexParam0);
      }
    );

    assertEquals(req.getPath(), "/1/configs/theIndexName");
    assertEquals(req.getMethod(), "PUT");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attributes\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }
}

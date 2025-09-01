package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchClientRequestsTestsE2E {

  private SearchClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new SearchClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"));
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new SearchClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"));
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("browse with minimal parameters")
  void browseTest() {
    BrowseResponse res = client.browse("cts_e2e_browse", Hit.class);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"page\":0,\"nbHits\":33191,\"nbPages\":34,\"hitsPerPage\":1000,\"query\":\"\",\"params\":\"\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search with a real object")
  void getObjectTest1() {
    Object res = client.getObject("cts_e2e_browse", "Batman and Robin");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"Batman and Robin\",\"title\":\"Batman and" +
        " Robin\",\"year\":1949,\"cast\":[\"Robert Lowery\",\"Johnny Duncan\",\"Jane" +
        " Adams\"]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getRule")
  void getRuleTest() {
    Rule res = client.getRule("cts_e2e_browse", "qr-1725004648916");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\",\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"Æon" +
        " Flux\"],\"position\":0}]}}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getSettings")
  void getSettingsTest() {
    SettingsResponse res = client.getSettings("cts_e2e_settings", 2);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"minWordSizefor1Typo\":4,\"minWordSizefor2Typos\":8,\"hitsPerPage\":100,\"maxValuesPerFacet\":100,\"paginationLimitedTo\":10,\"exactOnSingleWordQuery\":\"attribute\",\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"],\"separatorsToIndex\":\"\",\"removeWordsIfNoResults\":\"none\",\"queryType\":\"prefixLast\",\"highlightPreTag\":\"<em>\",\"highlightPostTag\":\"</em>\",\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"],\"typoTolerance\":\"false\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search for a single hits request with minimal parameters")
  void searchTest4() {
    SearchResponses res = client.search(
      new SearchMethodParams().setRequests(Arrays.asList(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))),
      Hit.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"hits\":[],\"page\":0,\"nbHits\":0,\"nbPages\":0,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"\",\"params\":\"\",\"index\":\"cts_e2e_search_empty_index\",\"renderingContent\":{}}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search with highlight and snippet results")
  void searchTest5() {
    SearchResponses res = client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits()
            .setIndexName("cts_e2e_highlight_snippet_results")
            .setQuery("vim")
            .setAttributesToSnippet(Arrays.asList("*:20"))
            .setAttributesToHighlight(Arrays.asList("*"))
            .setAttributesToRetrieve(Arrays.asList("*"))
        )
      ),
      Hit.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"hits\":[{\"editor\":{\"name\":\"vim\",\"type\":\"beforeneovim\"},\"names\":[\"vim\",\":q\"],\"_snippetResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\"}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},{\"value\":\":q\",\"matchLevel\":\"none\"}]},\"_highlightResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\",\"matchedWords\":[]}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},{\"value\":\":q\",\"matchLevel\":\"none\",\"matchedWords\":[]}]}}],\"nbHits\":1,\"page\":0,\"nbPages\":1,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"vim\",\"index\":\"cts_e2e_highlight_snippet_results\",\"renderingContent\":{}}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search for a single facet request with minimal parameters")
  void searchTest8() {
    SearchResponses res = client.search(
      new SearchMethodParams()
        .setRequests(
          Arrays.asList(new SearchForFacets().setIndexName("cts_e2e_search_facet").setType(SearchTypeFacet.FACET).setFacet("editor"))
        )
        .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
      Hit.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"exhaustiveFacetsCount\":true,\"facetHits\":[{\"count\":1,\"highlighted\":\"goland\",\"value\":\"goland\"},{\"count\":1,\"highlighted\":\"neovim\",\"value\":\"neovim\"},{\"count\":1,\"highlighted\":\"visual" +
        " studio\",\"value\":\"visual" +
        " studio\"},{\"count\":1,\"highlighted\":\"vscode\",\"value\":\"vscode\"}]}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search filters end to end")
  void searchTest14() {
    SearchResponses res = client.search(
      new SearchMethodParams().setRequests(
        Arrays.asList(
          new SearchForHits().setIndexName("cts_e2e_search_facet").setFilters("editor:'visual studio' OR editor:neovim"),
          new SearchForHits()
            .setIndexName("cts_e2e_search_facet")
            .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of("editor:neovim")))),
          new SearchForHits()
            .setIndexName("cts_e2e_search_facet")
            .setFacetFilters(
              FacetFilters.of(
                Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of(Arrays.asList(FacetFilters.of("editor:neovim"))))
              )
            ),
          new SearchForHits()
            .setIndexName("cts_e2e_search_facet")
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
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":2,\"nbPages\":1,\"page\":0,\"hits\":[{\"editor\":\"visual" +
        " studio\",\"_highlightResult\":{\"editor\":{\"value\":\"visual" +
        " studio\",\"matchLevel\":\"none\"}}},{\"editor\":\"neovim\",\"_highlightResult\":{\"editor\":{\"value\":\"neovim\",\"matchLevel\":\"none\"}}}],\"query\":\"\",\"params\":\"filters=editor%3A%27visual+studio%27+OR+editor%3Aneovim\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%22editor%3Aneovim%22%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%5D%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%2C%5B%22editor%3Agoland%22%5D%5D%5D\"}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with minimal parameters")
  void searchDictionaryEntriesTest() {
    SearchDictionaryEntriesResponse res = client.searchDictionaryEntries(
      DictionaryType.STOPWORDS,
      new SearchDictionaryEntriesParams().setQuery("about")
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"hits\":[{\"objectID\":\"86ef58032f47d976ca7130a896086783\",\"language\":\"en\",\"word\":\"about\"}],\"page\":0,\"nbHits\":1,\"nbPages\":1}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("searchRules")
  void searchRulesTest() {
    SearchRulesResponse res = client.searchRules("cts_e2e_browse", new SearchRulesParams().setQuery("zorro"));
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"hits\":[{\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"Æon" +
        " Flux\"],\"position\":0}]},\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\"}],\"nbHits\":1,\"nbPages\":1,\"page\":0}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search with special characters in indexName")
  void searchSingleIndexTest1() {
    SearchResponse res = client.searchSingleIndex("cts_e2e_space in index", Hit.class);
  }

  @Test
  @DisplayName("single search retrieve snippets")
  void searchSingleIndexTest3() {
    SearchResponse res = client.searchSingleIndex(
      "cts_e2e_browse",
      new SearchParamsObject()
        .setQuery("batman mask of the phantasm")
        .setAttributesToRetrieve(Arrays.asList("*"))
        .setAttributesToSnippet(Arrays.asList("*:20")),
      Hit.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"nbHits\":1,\"hits\":[{\"_snippetResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\"},{\"value\":\"Superhero\",\"matchLevel\":\"none\"},{\"value\":\"Romance\",\"matchLevel\":\"none\"}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\"}},\"_highlightResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Superhero\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Romance\",\"matchLevel\":\"none\",\"matchedWords\":[]}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\",\"matchedWords\":[]}}}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("minimal parameters")
  void setSettingsTest() {
    UpdatedAtResponse res = client.setSettings(
      "cts_e2e_settings",
      new IndexSettings().setPaginationLimitedTo(10).setTypoTolerance(TypoToleranceEnum.FALSE),
      true
    );
  }
}

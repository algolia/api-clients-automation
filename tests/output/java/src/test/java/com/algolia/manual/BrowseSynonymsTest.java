package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.config.HttpRequest;
import com.algolia.config.RequestOptions;
import com.algolia.config.Requester;
import com.algolia.model.search.SearchSynonymsParams;
import com.algolia.model.search.SearchSynonymsResponse;
import com.algolia.model.search.SynonymHit;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Regression test for CR-11727: `browseSynonyms` used to keep requesting `page=0` because the
 * incremented page was never written back to the params, so a full first page made the iterator
 * loop forever and duplicate hits. This test drives a full page followed by a partial page and
 * asserts the iterator walks page 0 then page 1 and stops.
 */
class BrowseSynonymsTest {

  static final int HITS_PER_PAGE = 1000;

  /**
   * Requester stub that returns a full page for `page=0` and a partial page afterwards, recording
   * the `page` sent on each `searchSynonyms` request. No real HTTP is performed.
   */
  static class PaginatingRequester implements Requester {

    final List<Integer> pagesRequested = new ArrayList<>();

    private SearchSynonymsResponse handle(HttpRequest httpRequest) {
      SearchSynonymsParams params = (SearchSynonymsParams) httpRequest.getBody();
      int page = params.getPage() == null ? 0 : params.getPage();
      pagesRequested.add(page);

      int count = page == 0 ? HITS_PER_PAGE : 3;
      List<SynonymHit> hits = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        hits.add(new SynonymHit().setObjectID("page" + page + "-hit" + i));
      }

      return new SearchSynonymsResponse().setHits(hits).setNbHits(HITS_PER_PAGE + 3);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, Class<?> returnType, Class<?> innerType) {
      return (T) handle(httpRequest);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, TypeReference<?> returnType) {
      return (T) handle(httpRequest);
    }

    @Override
    public void close() {}
  }

  @Test
  @Timeout(10)
  @DisplayName("browseSynonyms increments the page and terminates (CR-11727)")
  void browseSynonymsPaginatesAndStops() throws Exception {
    PaginatingRequester requester = new PaginatingRequester();

    try (
      SearchClient client = new SearchClient("app-id", "api-key", ClientOptions.builder().setRequester(requester).build())
    ) {
      List<SynonymHit> aggregated = new ArrayList<>();
      for (SynonymHit hit : client.browseSynonyms("my-index", new SearchSynonymsParams())) {
        aggregated.add(hit);
        // Fail fast instead of looping forever / OOMing if the page is never advanced.
        if (aggregated.size() > HITS_PER_PAGE + 100) {
          fail("browseSynonyms never advanced past page 0 and kept re-fetching the same page (CR-11727)");
        }
      }

      assertEquals(List.of(0, 1), requester.pagesRequested, "browseSynonyms must request page 0 then page 1");
      assertEquals(HITS_PER_PAGE + 3, aggregated.size(), "browseSynonyms must aggregate every hit from both pages exactly once");

      long distinctObjectIDs = aggregated.stream().map(SynonymHit::getObjectID).distinct().count();
      assertEquals(aggregated.size(), distinctObjectIDs, "browseSynonyms must not return duplicate hits (CR-11727)");
    }
  }
}

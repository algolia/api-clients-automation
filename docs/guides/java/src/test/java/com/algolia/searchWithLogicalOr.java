package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class searchWithLogicalOr {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      String query = "the query";

      OptionalWords optionalWords = OptionalWords.of(List.of("the", "query"));

      SearchParams searchParams = new SearchParamsObject().setQuery(query).setOptionalWords(optionalWords);

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

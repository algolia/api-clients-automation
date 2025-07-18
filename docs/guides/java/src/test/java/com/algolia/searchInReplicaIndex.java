package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class searchInReplicaIndex {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      String query = "query";

      // 1. Change the sort dynamically based on the UI events
      boolean sortByPrice = false;

      // 2. Get the index name based on sortByPrice
      String indexName = sortByPrice ? "products_price_desc" : "products";

      // 3. Search on dynamic index name (primary or replica)
      client.searchSingleIndex(indexName, new SearchParamsObject().setQuery("query"), Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

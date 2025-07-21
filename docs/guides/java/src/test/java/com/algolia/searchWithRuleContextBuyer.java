package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class searchWithRuleContextBuyer {

  private static String getBuyerAccountId() {
    return ""; // Implement your logic here
  }

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      // get the buyer account information
      String buyer = getBuyerAccountId();
      SearchParams searchParams = new SearchParamsObject().setQuery("<YOUR_SEARCH_QUERY>").setRuleContexts(List.of(buyer));

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class searchWithRuleContexts {

  private static String getPlatformTag() {
    return ""; // Implement your logic here
  }

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      String platformTag = getPlatformTag();
      SearchParams searchParams = new SearchParamsObject().setQuery("<YOUR_SEARCH_QUERY>").setRuleContexts(List.of(platformTag));

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class mcmSearchWithout {

  private static String getAppIDFor(String user) {
    return ""; // Implement your own logic here
  }

  private static String getIndexingApiKeyFor(String user) {
    return ""; // Implement your own logic here
  }

  public static void main(String[] args) throws Exception {
    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    String appID = getAppIDFor("user42");
    String apiKey = getIndexingApiKeyFor("user42");

    try (SearchClient client = new SearchClient(appID, apiKey)) {
      SearchParams searchParams = new SearchParamsObject()
        .setQuery("<YOUR_SEARCH_QUERY>")
        .setFacetFilters(FacetFilters.of(List.of(FacetFilters.of("user:user42"), FacetFilters.of("user:public"))));

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

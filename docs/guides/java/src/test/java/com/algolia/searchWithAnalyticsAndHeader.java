package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class searchWithAnalyticsAndHeader {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      /*
      '94.228.178.246' should be replaced with your user's IP address.
      Depending on your stack there are multiple ways to get this information.
      */
      String ip = "94.228.178.246";
      String query = "query";

      SearchParams searchParams = new SearchParamsObject().setQuery(query).setAnalytics(true);

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class, new RequestOptions().addExtraHeader("X-Forwarded-For", ip));
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

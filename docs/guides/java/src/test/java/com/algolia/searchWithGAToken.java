package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class searchWithGAToken {

  private static String getGoogleAnalyticsUserIdFromBrowserCookie(String cookieName) {
    return ""; // Implement your logic here
  }

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      String userToken = getGoogleAnalyticsUserIdFromBrowserCookie("_ga");
      SearchParamsObject searchParams = new SearchParamsObject().setQuery("<YOUR_SEARCH_QUERY>").setUserToken(userToken);

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);

      String loggedInUser = null;
      searchParams.setUserToken(loggedInUser != null ? loggedInUser : userToken);

      client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

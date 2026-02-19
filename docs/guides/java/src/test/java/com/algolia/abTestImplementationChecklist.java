package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class abTestImplementationChecklist {

  private static String getUserToken() {
    // Implement your logic here
    return "";
  }

  public static void main(String[] args) throws Exception {
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Set the searchParams and get the current user token
    SearchParamsObject searchParams = new SearchParamsObject().setQuery("User search query").setEnableABTest(true);

    String userToken = getUserToken();

    // Is the user token anonymous?
    if (userToken == null || userToken.isEmpty() || userToken.equals("YOUR_ANONYMOUS_USER_TOKEN")) {
      // Disable A/B testing for this request
      searchParams.setEnableABTest(false);
    } else {
      // Set the user token to the current user token
      searchParams.setUserToken(userToken);
    }

    try {
      // Perform the searchSingleIndex
      SearchResponse result = client.searchSingleIndex("<YOUR_INDEX_NAME>", searchParams, Hit.class);
      // SearchSingleIndex results
      System.out.println(result);
    } catch (Exception err) {
      // SearchSingleIndex errors
      System.err.println(err);
    }
  }
}

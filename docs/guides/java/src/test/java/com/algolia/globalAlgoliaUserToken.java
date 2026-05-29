package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class globalAlgoliaUserToken {

  public static void main(String[] args) throws Exception {
    SearchClient client = new SearchClient(
      "ALGOLIA_APPLICATION_ID",
      "ALGOLIA_API_KEY",
      ClientOptions.builder().addDefaultHeader("X-Algolia-UserToken", "test-user-123").build()
    );
    client.close();
  }
}

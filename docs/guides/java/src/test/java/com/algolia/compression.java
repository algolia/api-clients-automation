package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;

public class compression {

  public static void main(String[] args) throws Exception {
    // Initialize the client with gzip compression enabled
    // Compression reduces the size of request bodies sent to Algolia
    SearchClient client = new SearchClient(
      "ALGOLIA_APPLICATION_ID",
      "ALGOLIA_API_KEY",
      ClientOptions.builder().setCompressionType(CompressionType.GZIP).build()
    );

    // Search with compressed request body
    var result = client.searchSingleIndex("<YOUR_INDEX_NAME>", new SearchParamsObject().setQuery("comedy"), Hit.class);
    System.out.println(result.getHits());
    client.close();
  }
}

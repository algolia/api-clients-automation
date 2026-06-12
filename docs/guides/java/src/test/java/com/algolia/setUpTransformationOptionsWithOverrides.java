package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class setUpTransformationOptionsWithOverrides {

  public static void main(String[] args) throws Exception {
    // Override the Ingestion API defaults. Any option you don't set keeps its default.
    // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
    ClientOptions ingestionOptions = ClientOptions.builder()
      .setConnectTimeout(Duration.ofSeconds(5))
      .setReadTimeout(Duration.ofSeconds(30))
      .build();
    SearchClient client = SearchClient.withTransformation(
      "ALGOLIA_APPLICATION_ID",
      "ALGOLIA_API_KEY",
      new TransformationOptions("us", ingestionOptions)
    );

    // Save records, transforming them through the Push connector
    client.saveObjectsWithTransformation(
      "<YOUR_INDEX_NAME>",
      Arrays.asList(
        new HashMap() {
          {
            put("objectID", "1");
            put("name", "Adam");
          }
        },
        new HashMap() {
          {
            put("objectID", "2");
            put("name", "Benoit");
          }
        }
      ),
      true
    );
    client.close();
  }
}

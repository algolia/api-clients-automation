package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.Arrays;
import java.util.HashMap;

public class setUpTransformationOptions {

  public static void main(String[] args) throws Exception {
    // Set `transformationOptions` with your transformation region to use the `WithTransformation`
    // helper methods.
    // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
    SearchClient client = SearchClient.withTransformation("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", new TransformationOptions("us"));

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

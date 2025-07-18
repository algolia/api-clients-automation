package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class savePopularRecords {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      List<Map<String, Object>> records = new ArrayList<>();

      client
        .browseObjects("<YOUR_INDEX_NAME>", Hit.class)
        .forEach(hit -> {
          Map<String, Object> props = hit.getAdditionalProperties();
          int nbFollowers = (int) props.get("nbFollowers");

          Map<String, Object> record = new HashMap<>();
          record.put("twitterHandle", props.get("twitterHandle"));
          record.put("nbFollowers", nbFollowers);
          record.put("isPopular", nbFollowers >= 1_000_000);

          records.add(record);
        });

      client.saveObjects("<YOUR_INDEX_NAME>", records);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

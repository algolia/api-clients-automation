package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;
import java.util.Map;

public class saveObjectsMCM {

  private static final List<Map<String, Object>> playlists = List.of(
    /* Your records */
  );

  private static List<Map<String, String>> getAllAppIDConfigurations() {
    return List.of(
      /* A list of your MCM AppID/ApiKey pairs */
    );
  }

  public static void main(String[] args) throws Exception {
    // Fetch from your own data storage and with your own code
    // the list of application IDs and API keys to target each cluster
    var configurations = getAllAppIDConfigurations();

    // Send the records to each cluster
    configurations.forEach(config -> {
      try (SearchClient client = new SearchClient(config.get("appID"), config.get("apiKey"))) {
        client.saveObjects("<YOUR_INDEX_NAME>", playlists);
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
      }
    });
  }
}

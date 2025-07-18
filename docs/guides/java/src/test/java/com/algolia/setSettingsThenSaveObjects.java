package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;
import java.util.Map;

public class setSettingsThenSaveObjects {

  private static final List<Map<String, Object>> playlists = List.of(
    /* Your records */
  );

  private static String getAppIDFor(String user) {
    return ""; // Implement your own logic here
  }

  private static String getIndexingApiKeyFor(String user) {
    return ""; // Implement your own logic here
  }

  public static void main(String[] args) throws Exception {
    playlists.forEach(playlist -> {
      // Fetch from your own data storage and with your own code
      // the associated application ID and API key for this user
      String appID = getAppIDFor((String) playlist.get("user"));
      String apiKey = getIndexingApiKeyFor((String) playlist.get("user"));

      try (SearchClient client = new SearchClient(appID, apiKey)) {
        IndexSettings settings = new IndexSettings().setAttributesForFaceting(List.of("searchable(playlistName)"));
        client.setSettings("<YOUR_INDEX_NAME>", settings);

        client.saveObjects("<YOUR_INDEX_NAME>", playlists);
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
      }
    });
  }
}

package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;
import java.util.Map;

public class setHeaderUserIDThenSaveObjects {

  private static final List<Map<String, Object>> playlists = List.of(/* Your records */);

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");) {
      playlists.forEach(playlist -> {
        String playlistUserID = (String) playlist.get("userID");
        client.saveObjects(
          "<YOUR_INDEX_NAME>",
          playlists,
          false,
          1000,
          new RequestOptions().addExtraHeader("X-Algolia-User-ID", playlistUserID)
        );
      });
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

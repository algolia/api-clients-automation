package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class saveObjectsChunks {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");) {
      JsonNode content = new ObjectMapper().readTree(new File("actors.json"));
      List<Map<String, Object>> records = new ObjectMapper().readerForListOf(Map.class).readValue(content);

      int chunkSize = 10000;

      for (var beginIndex = 0; beginIndex < records.size(); beginIndex += chunkSize) {
        List<Map<String, Object>> chunk = records.subList(beginIndex, Math.min(beginIndex + chunkSize, records.size()));
        client.saveObjects("<YOUR_INDEX_NAME>", chunk);
      }
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

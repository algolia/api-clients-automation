package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class saveObjectsModified {

  public static void main(String[] args) throws Exception {
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      JsonNode content = new ObjectMapper().readTree(new File("products.json"));
      List<Map<String, Object>> products = new ObjectMapper().readerForListOf(Map.class).readValue(content);

      List<Map<String, Object>> records = products
        .stream()
        .map(product -> {
          String reference = (String) product.get("product_reference");
          List<String> suffixes = new ArrayList<>();

          for (int i = reference.length(); i > 1; i--) {
            suffixes.add(reference.substring(i));
          }

          Map<String, Object> record = new HashMap<>(Map.copyOf(product));
          record.put("product_reference_suffixes", suffixes);
          return record;
        })
        .toList();

      client.saveObjects("<YOUR_INDEX_NAME>", records);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

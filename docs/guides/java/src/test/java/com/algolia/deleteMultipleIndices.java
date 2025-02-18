package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class deleteMultipleIndices {

  public static void main(String[] args) throws Exception {
    // You need an API key with `deleteIndex`
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");) {
      // List all indices
      ListIndicesResponse indices = client.listIndices();

      // Primary indices don't have a `primary` key
      List<FetchedIndex> primaryIndices = indices.getItems().stream().filter(item -> item.getPrimary() == null).toList();
      List<FetchedIndex> replicaIndices = indices.getItems().stream().filter(item -> item.getPrimary() != null).toList();

      // Delete primary indices first
      if (!primaryIndices.isEmpty()) {
        List<MultipleBatchRequest> requests = primaryIndices
          .stream()
          .map(index -> new MultipleBatchRequest().setAction(Action.DELETE).setIndexName(index.getName()))
          .toList();
        client.multipleBatch(new BatchParams().setRequests(requests));
        System.out.println("Deleted primary indices.");
      }

      // Now, delete replica indices
      if (!replicaIndices.isEmpty()) {
        List<MultipleBatchRequest> requests = replicaIndices
          .stream()
          .map(index -> new MultipleBatchRequest().setAction(Action.DELETE).setIndexName(index.getName()))
          .toList();
        client.multipleBatch(new BatchParams().setRequests(requests));
        System.out.println("Deleted replica indices.");
      }
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }
}

package com.algolia.methods.snippets;

import com.algolia.api.UsageClient;
import com.algolia.model.usage.*;

class SnippetUsageClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the getIndexUsage method.
  //
  // getIndexUsage with minimal parameters
  void snippetForGetIndexUsage() {
    // >SEPARATOR getIndexUsage
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIndexUsage(Statistic.fromValue("queries_operations"), "myIndexName", "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z");
    // SEPARATOR<
  }

  // Snippet for the getUsage method.
  //
  // getUsage with minimal parameters
  void snippetForGetUsage() {
    // >SEPARATOR getUsage
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getUsage(Statistic.fromValue("queries_operations"), "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z");
    // SEPARATOR<
  }
}

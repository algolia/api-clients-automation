package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.UsageClient;
import com.algolia.model.usage.*;

// IMPORT<

class SnippetUsageClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getIndexUsage method.
  //
  // getIndexUsage with minimal parameters
  void snippetForGetIndexUsage() {
    // >SEPARATOR getIndexUsage default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIndexUsage(Statistic.QUERIES_OPERATIONS, "<YOUR_INDEX_NAME>", "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getUsage method.
  //
  // getUsage with minimal parameters
  void snippetForGetUsage() {
    // >SEPARATOR getUsage default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getUsage(Statistic.QUERIES_OPERATIONS, "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    UsageClient client = new UsageClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}

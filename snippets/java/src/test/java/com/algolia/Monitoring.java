package com.algolia.methods.snippets;

import com.algolia.api.MonitoringClient;
import com.algolia.model.monitoring.*;

class SnippetMonitoringClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the getClusterIncidents method.
  //
  // getClusterIncidents
  void snippetForGetClusterIncidents() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterIncidents("c1-de");
  }

  // Snippet for the getClusterStatus method.
  //
  // getClusterStatus
  void snippetForGetClusterStatus() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterStatus("c1-de");
  }

  // Snippet for the getIncidents method.
  //
  // getIncidents
  void snippetForGetIncidents() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIncidents();
  }

  // Snippet for the getIndexingTime method.
  //
  // getIndexingTime
  void snippetForGetIndexingTime() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIndexingTime("c1-de");
  }

  // Snippet for the getInventory method.
  //
  // getInventory
  void snippetForGetInventory() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getInventory();
  }

  // Snippet for the getLatency method.
  //
  // getLatency
  void snippetForGetLatency() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLatency("c1-de");
  }

  // Snippet for the getMetrics method.
  //
  // getMetrics
  void snippetForGetMetrics() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getMetrics(Metric.fromValue("avg_build_time"), Period.fromValue("minute"));
  }

  // Snippet for the getReachability method.
  //
  // getReachability
  void snippetForGetReachability() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getReachability("c1-de");
  }

  // Snippet for the getStatus method.
  //
  // getStatus
  void snippetForGetStatus() {
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getStatus();
  }
}

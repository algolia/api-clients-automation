package com.algolia.methods.snippets;

import com.algolia.api.MonitoringClient;
import com.algolia.model.monitoring.*;

class SnippetMonitoringClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the getClusterIncidents method.
  //
  // getClusterIncidents
  void snippetForGetClusterIncidents() {
    // >SEPARATOR getClusterIncidents
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterIncidents("c1-de");
    // SEPARATOR<
  }

  // Snippet for the getClusterStatus method.
  //
  // getClusterStatus
  void snippetForGetClusterStatus() {
    // >SEPARATOR getClusterStatus
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterStatus("c1-de");
    // SEPARATOR<
  }

  // Snippet for the getIncidents method.
  //
  // getIncidents
  void snippetForGetIncidents() {
    // >SEPARATOR getIncidents
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIncidents();
    // SEPARATOR<
  }

  // Snippet for the getIndexingTime method.
  //
  // getIndexingTime
  void snippetForGetIndexingTime() {
    // >SEPARATOR getIndexingTime
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIndexingTime("c1-de");
    // SEPARATOR<
  }

  // Snippet for the getInventory method.
  //
  // getInventory
  void snippetForGetInventory() {
    // >SEPARATOR getInventory
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getInventory();
    // SEPARATOR<
  }

  // Snippet for the getLatency method.
  //
  // getLatency
  void snippetForGetLatency() {
    // >SEPARATOR getLatency
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLatency("c1-de");
    // SEPARATOR<
  }

  // Snippet for the getMetrics method.
  //
  // getMetrics
  void snippetForGetMetrics() {
    // >SEPARATOR getMetrics
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getMetrics(Metric.fromValue("avg_build_time"), Period.fromValue("minute"));
    // SEPARATOR<
  }

  // Snippet for the getReachability method.
  //
  // getReachability
  void snippetForGetReachability() {
    // >SEPARATOR getReachability
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getReachability("c1-de");
    // SEPARATOR<
  }

  // Snippet for the getStatus method.
  //
  // getStatus
  void snippetForGetStatus() {
    // >SEPARATOR getStatus
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getStatus();
    // SEPARATOR<
  }
}

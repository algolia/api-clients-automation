package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.MonitoringClient;
import com.algolia.model.monitoring.*;

// IMPORT<

class SnippetMonitoringClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

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
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

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
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

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
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClusterIncidents method.
  //
  // getClusterIncidents
  void snippetForGetClusterIncidents() {
    // >SEPARATOR getClusterIncidents default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterIncidents("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClusterStatus method.
  //
  // getClusterStatus
  void snippetForGetClusterStatus() {
    // >SEPARATOR getClusterStatus default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getClusterStatus("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getIncidents method.
  //
  // getIncidents
  void snippetForGetIncidents() {
    // >SEPARATOR getIncidents default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIncidents();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getIndexingTime method.
  //
  // getIndexingTime
  void snippetForGetIndexingTime() {
    // >SEPARATOR getIndexingTime default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getIndexingTime("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getLatency method.
  //
  // getLatency
  void snippetForGetLatency() {
    // >SEPARATOR getLatency default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getLatency("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getMetrics method.
  //
  // getMetrics
  void snippetForGetMetrics() {
    // >SEPARATOR getMetrics default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getMetrics(Metric.AVG_BUILD_TIME, Period.MINUTE);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getReachability method.
  //
  // getReachability
  void snippetForGetReachability() {
    // >SEPARATOR getReachability default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getReachability("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getServers method.
  //
  // getInventory
  void snippetForGetServers() {
    // >SEPARATOR getServers default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getServers();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getStatus method.
  //
  // getStatus
  void snippetForGetStatus() {
    // >SEPARATOR getStatus default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getStatus();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}

package com.algolia.methods.snippets;

import com.algolia.api.MonitoringClient;
import com.algolia.model.monitoring.*;

class SnippetMonitoringClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPut("/test/minimal");
  }

  // Snippet for the getClusterIncidents method.
  //
  // getClusterIncidents
  void SnippetForGetClusterIncidents() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getClusterIncidents("c1-de");
  }

  // Snippet for the getClusterStatus method.
  //
  // getClusterStatus
  void SnippetForGetClusterStatus() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getClusterStatus("c1-de");
  }

  // Snippet for the getIncidents method.
  //
  // getIncidents
  void SnippetForGetIncidents() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getIncidents();
  }

  // Snippet for the getIndexingTime method.
  //
  // getIndexingTime
  void SnippetForGetIndexingTime() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getIndexingTime("c1-de");
  }

  // Snippet for the getInventory method.
  //
  // getInventory
  void SnippetForGetInventory() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getInventory();
  }

  // Snippet for the getLatency method.
  //
  // getLatency
  void SnippetForGetLatency() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getLatency("c1-de");
  }

  // Snippet for the getMetrics method.
  //
  // getMetrics
  void SnippetForGetMetrics() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getMetrics(Metric.fromValue("avg_build_time"), Period.fromValue("minute"));
  }

  // Snippet for the getReachability method.
  //
  // getReachability
  void SnippetForGetReachability() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getReachability("c1-de");
  }

  // Snippet for the getStatus method.
  //
  // getStatus
  void SnippetForGetStatus() {
    MonitoringClient client = new MonitoringClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getStatus();
  }
}

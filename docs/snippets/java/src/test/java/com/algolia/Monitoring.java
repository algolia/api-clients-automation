package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.MonitoringClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.monitoring.*;
import java.util.*;

class SnippetMonitoringClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "to be overridden");
        }
      },
      new RequestOptions()
        .addExtraQueryParameters("query", "parameters with space")
        .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
        .addExtraHeader("x-header-1", "spaces are left alone")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("isItWorking", true)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", 2)
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList("b and c", "d"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(true, true, false))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost(
      "test/requestOptions",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("facet", "filters");
        }
      },
      new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(1, 2))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      },
      new HashMap() {
        {
          put("body", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClusterIncidents method.
  //
  // getClusterIncidents
  void snippetForGetClusterIncidents() throws Exception {
    // >SEPARATOR getClusterIncidents default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getClusterIncidents("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getClusterStatus method.
  //
  // getClusterStatus
  void snippetForGetClusterStatus() throws Exception {
    // >SEPARATOR getClusterStatus default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getClusterStatus("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getIncidents method.
  //
  // getIncidents
  void snippetForGetIncidents() throws Exception {
    // >SEPARATOR getIncidents default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getIncidents();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getIndexingTime method.
  //
  // getIndexingTime
  void snippetForGetIndexingTime() throws Exception {
    // >SEPARATOR getIndexingTime default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getIndexingTime("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getLatency method.
  //
  // getLatency
  void snippetForGetLatency() throws Exception {
    // >SEPARATOR getLatency default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getLatency("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getMetrics method.
  //
  // getMetrics
  void snippetForGetMetrics() throws Exception {
    // >SEPARATOR getMetrics default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getMetrics(Metric.AVG_BUILD_TIME, Period.MINUTE);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getReachability method.
  //
  // getReachability
  void snippetForGetReachability() throws Exception {
    // >SEPARATOR getReachability default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getReachability("c1-de");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getServers method.
  //
  // getInventory
  void snippetForGetServers() throws Exception {
    // >SEPARATOR getServers default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getServers();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getStatus method.
  //
  // getStatus
  void snippetForGetStatus() throws Exception {
    // >SEPARATOR getStatus default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getStatus();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    MonitoringClient client = new MonitoringClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}

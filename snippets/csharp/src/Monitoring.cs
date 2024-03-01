using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Monitoring;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetMonitoringClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClusterIncidents method.
  ///
  /// getClusterIncidents
  /// </summary>
  public async Task SnippetForMonitoringClientGetClusterIncidents()
  {
    // >SEPARATOR getClusterIncidents
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetClusterIncidentsAsync("c1-de");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClusterStatus method.
  ///
  /// getClusterStatus
  /// </summary>
  public async Task SnippetForMonitoringClientGetClusterStatus()
  {
    // >SEPARATOR getClusterStatus
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetClusterStatusAsync("c1-de");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetIncidents method.
  ///
  /// getIncidents
  /// </summary>
  public async Task SnippetForMonitoringClientGetIncidents()
  {
    // >SEPARATOR getIncidents
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetIncidentsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetIndexingTime method.
  ///
  /// getIndexingTime
  /// </summary>
  public async Task SnippetForMonitoringClientGetIndexingTime()
  {
    // >SEPARATOR getIndexingTime
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetIndexingTimeAsync("c1-de");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetInventory method.
  ///
  /// getInventory
  /// </summary>
  public async Task SnippetForMonitoringClientGetInventory()
  {
    // >SEPARATOR getInventory
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetInventoryAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetLatency method.
  ///
  /// getLatency
  /// </summary>
  public async Task SnippetForMonitoringClientGetLatency()
  {
    // >SEPARATOR getLatency
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetLatencyAsync("c1-de");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetMetrics method.
  ///
  /// getMetrics
  /// </summary>
  public async Task SnippetForMonitoringClientGetMetrics()
  {
    // >SEPARATOR getMetrics
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetMetricsAsync(
      Enum.Parse<Metric>("AvgBuildTime"),
      Enum.Parse<Period>("Minute")
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetReachability method.
  ///
  /// getReachability
  /// </summary>
  public async Task SnippetForMonitoringClientGetReachability()
  {
    // >SEPARATOR getReachability
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetReachabilityAsync("c1-de");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetStatus method.
  ///
  /// getStatus
  /// </summary>
  public async Task SnippetForMonitoringClientGetStatus()
  {
    // >SEPARATOR getStatus
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetStatusAsync();
    // SEPARATOR<
  }
}

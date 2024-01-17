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
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomGet()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomPost()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForMonitoringClientCustomPut()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the GetClusterIncidents method.
  ///
  /// getClusterIncidents
  /// </summary>
  public async Task SnippetForMonitoringClientGetClusterIncidents()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetClusterIncidentsAsync("c1-de");
  }

  /// <summary>
  /// Snippet for the GetClusterStatus method.
  ///
  /// getClusterStatus
  /// </summary>
  public async Task SnippetForMonitoringClientGetClusterStatus()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetClusterStatusAsync("c1-de");
  }

  /// <summary>
  /// Snippet for the GetIncidents method.
  ///
  /// getIncidents
  /// </summary>
  public async Task SnippetForMonitoringClientGetIncidents()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetIncidentsAsync();
  }

  /// <summary>
  /// Snippet for the GetIndexingTime method.
  ///
  /// getIndexingTime
  /// </summary>
  public async Task SnippetForMonitoringClientGetIndexingTime()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetIndexingTimeAsync("c1-de");
  }

  /// <summary>
  /// Snippet for the GetInventory method.
  ///
  /// getInventory
  /// </summary>
  public async Task SnippetForMonitoringClientGetInventory()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetInventoryAsync();
  }

  /// <summary>
  /// Snippet for the GetLatency method.
  ///
  /// getLatency
  /// </summary>
  public async Task SnippetForMonitoringClientGetLatency()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetLatencyAsync("c1-de");
  }

  /// <summary>
  /// Snippet for the GetMetrics method.
  ///
  /// getMetrics
  /// </summary>
  public async Task SnippetForMonitoringClientGetMetrics()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetMetricsAsync(
      Enum.Parse<Metric>("AvgBuildTime"),
      Enum.Parse<Period>("Minute")
    );
  }

  /// <summary>
  /// Snippet for the GetReachability method.
  ///
  /// getReachability
  /// </summary>
  public async Task SnippetForMonitoringClientGetReachability()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetReachabilityAsync("c1-de");
  }

  /// <summary>
  /// Snippet for the GetStatus method.
  ///
  /// getStatus
  /// </summary>
  public async Task SnippetForMonitoringClientGetStatus()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetStatusAsync();
  }
}

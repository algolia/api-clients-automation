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
  public async Task SnippetForCustomDelete0()
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
  public async Task SnippetForCustomGet0()
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
  public async Task SnippetForCustomPost0()
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
  public async Task SnippetForCustomPut0()
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
  public async Task SnippetForGetClusterIncidents0()
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
  public async Task SnippetForGetClusterStatus0()
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
  public async Task SnippetForGetIncidents0()
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
  public async Task SnippetForGetIndexingTime0()
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
  public async Task SnippetForGetInventory0()
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
  public async Task SnippetForGetLatency0()
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
  public async Task SnippetForGetMetrics0()
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
  public async Task SnippetForGetReachability0()
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
  public async Task SnippetForGetStatus0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetStatusAsync();
  }
}

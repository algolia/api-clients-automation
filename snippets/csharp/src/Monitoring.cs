using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Monitoring;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetMonitoringClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomDeleteAsync(path0);
  }

  /// <summary>
  /// Snippet for the customGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomGetAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPostAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the getClusterIncidents method.
  ///
  /// getClusterIncidents
  /// </summary>
  public async Task SnippetForGetClusterIncidents0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string clusters0 = "c1-de";


    var response = await _client.GetClusterIncidentsAsync(clusters0);
  }

  /// <summary>
  /// Snippet for the getClusterStatus method.
  ///
  /// getClusterStatus
  /// </summary>
  public async Task SnippetForGetClusterStatus0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string clusters0 = "c1-de";


    var response = await _client.GetClusterStatusAsync(clusters0);
  }

  /// <summary>
  /// Snippet for the getIncidents method.
  ///
  /// getIncidents
  /// </summary>
  public async Task SnippetForGetIncidents0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetIncidentsAsync();
  }

  /// <summary>
  /// Snippet for the getIndexingTime method.
  ///
  /// getIndexingTime
  /// </summary>
  public async Task SnippetForGetIndexingTime0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string clusters0 = "c1-de";


    var response = await _client.GetIndexingTimeAsync(clusters0);
  }

  /// <summary>
  /// Snippet for the getInventory method.
  ///
  /// getInventory
  /// </summary>
  public async Task SnippetForGetInventory0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetInventoryAsync();
  }

  /// <summary>
  /// Snippet for the getLatency method.
  ///
  /// getLatency
  /// </summary>
  public async Task SnippetForGetLatency0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string clusters0 = "c1-de";


    var response = await _client.GetLatencyAsync(clusters0);
  }

  /// <summary>
  /// Snippet for the getMetrics method.
  ///
  /// getMetrics
  /// </summary>
  public async Task SnippetForGetMetrics0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var metric0 = (Metric)Enum.Parse(typeof(Metric), "AvgBuildTime");
    var period0 = (Period)Enum.Parse(typeof(Period), "Minute");


    var response = await _client.GetMetricsAsync(metric0, period0);
  }

  /// <summary>
  /// Snippet for the getReachability method.
  ///
  /// getReachability
  /// </summary>
  public async Task SnippetForGetReachability0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string clusters0 = "c1-de";


    var response = await _client.GetReachabilityAsync(clusters0);
  }

  /// <summary>
  /// Snippet for the getStatus method.
  ///
  /// getStatus
  /// </summary>
  public async Task SnippetForGetStatus0()
  {
    // Initialize the client
    var client = new MonitoringClient(new MonitoringConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetStatusAsync();
  }

}

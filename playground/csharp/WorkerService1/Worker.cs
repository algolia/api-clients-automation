using Algolia.Search.Clients;
using Algolia.Search.Models.Search;

namespace WorkerService1;

public class Worker : BackgroundService
{
  private readonly ILogger<Worker> _logger;
  private readonly SearchClient _searchClient;

  public Worker(ILogger<Worker> logger)
  {
    _logger = logger;
    _searchClient = new SearchClient("test-app-id", "test-api-key");
  }

  protected override async Task ExecuteAsync(CancellationToken stoppingToken)
  {
    await _searchClient.SearchSingleIndexAsync<object>("test", new SearchParams(new SearchParamsObject() { Query = "" }), cancellationToken: stoppingToken);

    while (!stoppingToken.IsCancellationRequested)
    {
      if (_logger.IsEnabled(LogLevel.Information))
      {
        _logger.LogInformation("Worker running at: {time}", DateTimeOffset.Now);
      }

      await Task.Delay(1000, stoppingToken);
    }
  }
}

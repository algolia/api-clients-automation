using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Monitoring;
using Xunit;

public class MonitoringClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public MonitoringClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new MonitoringClient(new MonitoringConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Monitoring (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new MonitoringClient(new MonitoringConfig("appId", "apiKey"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new MonitoringClient(new MonitoringConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "use the correct host")]
  public async Task ParametersTest0()
  {
    var client = new MonitoringClient(new MonitoringConfig("my-app-id", "my-api-key"), _echo);
    await client.CustomDeleteAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("status.algolia.com", result.Host);
  }
}

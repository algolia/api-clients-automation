using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Analytics;
using Xunit;

public class AnalyticsClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public AnalyticsClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Analytics (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "fallbacks to the alias when region is not given")]
  public async Task ParametersTest0()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("my-app-id", "my-api-key"), _echo);
    await client.GetAverageClickPositionAsync("my-index");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("analytics.algolia.com", result.Host);
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest1()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("my-app-id", "my-api-key", "de"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("analytics.de.algolia.com", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest2()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new AnalyticsClient(
        new AnalyticsConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` must be one of the following: de, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "getAverageClickPosition throws without index")]
  public async Task ParametersTest3()
  {
    var client = new AnalyticsClient(new AnalyticsConfig("appId", "apiKey", "us"), _echo);
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.GetClickPositionsAsync(null);
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `index` is required when calling `getClickPositions`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }
}

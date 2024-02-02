using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Ingestion;
using Xunit;

public class IngestionClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public IngestionClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Ingestion (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new IngestionClient(new IngestionConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest0()
  {
    var client = new IngestionClient(new IngestionConfig("my-app-id", "my-api-key", "us"), _echo);
    await client.GetSourceAsync("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("data.us.algolia.com", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest1()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new IngestionClient(
        new IngestionConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }
}

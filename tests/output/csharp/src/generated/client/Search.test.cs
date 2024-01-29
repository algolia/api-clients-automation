using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Xunit;

public class SearchClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public SearchClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct read host")]
  public async Task ApiTest0()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("test-app-id-dsn.algolia.net", result.Host);
  }

  [Fact(DisplayName = "calls api with correct write host")]
  public async Task ApiTest1()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("test-app-id.algolia.net", result.Host);
  }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomGetAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "client throws with invalid parameters")]
  public async Task ParametersTest0()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("", ""), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("", "my-api-key"), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("my-app-id", ""), _echo);
    });
    Assert.Equal("`apiKey` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());
  }

  [Fact(DisplayName = "`addApiKey` throws with invalid parameters")]
  public async Task ParametersTest1()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddApiKeyAsync(null);
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `apiKey` is required when calling `addApiKey`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "`addOrUpdateObject` throws with invalid parameters")]
  public async Task ParametersTest2()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync(null, "my-object-id", new Dictionary<string, object> { });
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `indexName` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync(
        "my-index-name",
        null,
        new Dictionary<string, object> { }
      );
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `objectID` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync("my-index-name", "my-object-id", null);
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `body` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }
}

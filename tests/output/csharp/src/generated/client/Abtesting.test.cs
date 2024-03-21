using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Abtesting;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

public class AbtestingClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public AbtestingClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new AbtestingClient(new AbtestingConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest1()
  {
    var client = new AbtestingClient(new AbtestingConfig("appId", "apiKey", "us"), _echo);
    await client.CustomGetAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new AbtestingClient(new AbtestingConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "fallbacks to the alias when region is not given")]
  public async Task ParametersTest0()
  {
    var client = new AbtestingClient(new AbtestingConfig("my-app-id", "my-api-key"), _echo);
    await client.GetABTestAsync(123);
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("analytics.algolia.com", result.Host);
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest1()
  {
    var client = new AbtestingClient(new AbtestingConfig("my-app-id", "my-api-key", "us"), _echo);
    await client.GetABTestAsync(123);
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("analytics.us.algolia.com", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest2()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new AbtestingClient(
        new AbtestingConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` must be one of the following: de, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }
}

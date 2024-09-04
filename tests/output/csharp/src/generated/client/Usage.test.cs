// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Usage;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.client;

public class UsageClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public UsageClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct read host")]
  public async Task ApiTest0()
  {
    var client = new UsageClient(new UsageConfig("test-app-id", "test-api-key"), _echo);

    await client.CustomGetAsync("test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("usage.algolia.com", result.Host);
  }

  [Fact(DisplayName = "calls api with correct write host")]
  public async Task ApiTest1()
  {
    var client = new UsageClient(new UsageConfig("test-app-id", "test-api-key"), _echo);

    await client.CustomPostAsync("test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("usage.algolia.com", result.Host);
  }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new UsageClient(new UsageConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Usage (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "the user agent contains the latest version")]
  public async Task CommonApiTest1()
  {
    var client = new UsageClient(new UsageConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex("^Algolia for Csharp \\(7.2.4\\).*");
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new UsageClient(new UsageConfig("appId", "apiKey"), _echo);
    await client.CustomGetAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest3()
  {
    var client = new UsageClient(new UsageConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "client throws with invalid parameters")]
  public async Task ParametersTest0()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new UsageClient(new UsageConfig("", ""), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new UsageClient(new UsageConfig("", "my-api-key"), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new UsageClient(new UsageConfig("my-app-id", ""), _echo);
    });
    Assert.Equal("`apiKey` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());
  }
}

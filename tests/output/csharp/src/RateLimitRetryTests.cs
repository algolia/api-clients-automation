using System.Text;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Transport;
using Moq;
using Xunit;

namespace Algolia.Search.Tests;

public class RateLimitRetryTests
{
  [Theory]
  [InlineData(null, 1)]
  [InlineData("", 1)]
  [InlineData("   ", 1)]
  [InlineData("0", 1)]
  [InlineData("-1", 1)]
  [InlineData("1.5", 1)]
  [InlineData("Wed, 21 Oct 2015 07:28:00 GMT", 1)]
  [InlineData("abc", 1)]
  [InlineData("2", 2)]
  [InlineData(" 3 ", 3)]
  public void ParseRetryAfter_UsesPositiveWholeSecondsOrFallsBackToOne(
    string header,
    int expectedSeconds
  )
  {
    var headers = new Dictionary<string, string>();
    if (header != null)
    {
      headers["Retry-After"] = header;
    }

    Assert.Equal(TimeSpan.FromSeconds(expectedSeconds), RetryAfter.Parse(headers));
  }

  [Fact]
  public void ParseRetryAfter_IsCaseInsensitive()
  {
    var headers = new Dictionary<string, string> { { "retry-after", "4" } };
    Assert.Equal(TimeSpan.FromSeconds(4), RetryAfter.Parse(headers));
  }

  [Fact]
  public async Task RateLimitedRequest_WaitsUsingRetryAfter_AndStaysOnSameHost()
  {
    var delays = new List<TimeSpan>();
    var hosts = new List<string>();
    var (client, _) = CreateClient(
      responses: new[] { RateLimited("2"), Success() },
      onDelay: delay => delays.Add(delay),
      onRequest: request => hosts.Add(request.Uri.Host)
    );

    await client.CustomGetAsync("1/test/retry");

    Assert.Equal(new[] { "test-host-1", "test-host-1" }, hosts);
    Assert.Equal(new[] { TimeSpan.FromSeconds(2) }, delays);
  }

  [Fact]
  public async Task RateLimitedRequest_WithoutRetryAfter_WaitsOneSecond()
  {
    var delays = new List<TimeSpan>();
    var (client, _) = CreateClient(
      responses: new[] { RateLimited(null), Success() },
      onDelay: delay => delays.Add(delay)
    );

    await client.CustomGetAsync("1/test/retry");

    Assert.Equal(new[] { TimeSpan.FromSeconds(1) }, delays);
  }

  [Fact]
  public async Task RateLimitedRequest_ExhaustsRetriesThenThrows()
  {
    var hosts = new List<string>();
    var (client, _) = CreateClient(
      responses: new[]
      {
        RateLimited("1"),
        RateLimited("1"),
        RateLimited("1"),
        RateLimited("1"),
      },
      onRequest: request => hosts.Add(request.Uri.Host)
    );

    var exception = await Assert.ThrowsAsync<AlgoliaApiException>(
      () => client.CustomGetAsync("1/test/retry")
    );

    Assert.Equal(429, exception.HttpErrorCode);
    Assert.Equal(4, hosts.Count);
    Assert.All(hosts, host => Assert.Equal("test-host-1", host));
  }

  [Fact]
  public async Task RateLimitedRequest_ZeroRetries_FailsOnFirst429()
  {
    var delays = new List<TimeSpan>();
    var hosts = new List<string>();
    var (client, _) = CreateClient(
      responses: new[] { RateLimited("2") },
      maxRateLimitRetries: 0,
      onDelay: delay => delays.Add(delay),
      onRequest: request => hosts.Add(request.Uri.Host)
    );

    var exception = await Assert.ThrowsAsync<AlgoliaApiException>(
      () => client.CustomGetAsync("1/test/retry")
    );

    Assert.Equal(429, exception.HttpErrorCode);
    Assert.Equal(new[] { "test-host-1" }, hosts);
    Assert.Empty(delays);
  }

  [Fact]
  public async Task ServerError_StillFailsOverToTheNextHost()
  {
    var hosts = new List<string>();
    var (client, _) = CreateClient(
      responses: new[] { ServerError(), Success() },
      onRequest: request => hosts.Add(request.Uri.Host)
    );

    await client.CustomGetAsync("1/test/retry");

    Assert.Equal(new[] { "test-host-1", "test-host-2" }, hosts);
  }

  private static (SearchClient Client, Mock<IHttpRequester> Mock) CreateClient(
    AlgoliaHttpResponse[] responses,
    int maxRateLimitRetries = 3,
    Action<TimeSpan> onDelay = null,
    Action<Request> onRequest = null
  )
  {
    var mock = new Mock<IHttpRequester>();
    var call = 0;
    mock.Setup(http =>
        http.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(
        (Request request, TimeSpan _, TimeSpan _, CancellationToken _) =>
        {
          onRequest?.Invoke(request);
          var response = responses[Math.Min(call++, responses.Length - 1)];
          return Task.FromResult(response);
        }
      );

    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>
      {
        new()
        {
          Url = "test-host-1",
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
        new()
        {
          Url = "test-host-2",
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
      MaxRateLimitRetries = maxRateLimitRetries,
      RateLimitDelayAsync = (delay, _) =>
      {
        onDelay?.Invoke(delay);
        return Task.CompletedTask;
      },
    };

    return (new SearchClient(config, mock.Object), mock);
  }

  private static AlgoliaHttpResponse RateLimited(string retryAfter)
  {
    var headers = new Dictionary<string, string>();
    if (retryAfter != null)
    {
      headers["Retry-After"] = retryAfter;
    }

    const string body = "{\"message\":\"Too many requests\"}";
    return new AlgoliaHttpResponse
    {
      HttpStatusCode = 429,
      ResponseHeaders = headers,
      Error = body,
      Body = new MemoryStream(Encoding.UTF8.GetBytes(body)),
    };
  }

  private static AlgoliaHttpResponse Success() =>
    new()
    {
      HttpStatusCode = 200,
      Body = new MemoryStream(Encoding.UTF8.GetBytes("{}")),
    };

  private static AlgoliaHttpResponse ServerError() =>
    new()
    {
      HttpStatusCode = 500,
      Error = "{\"message\":\"Internal Server Error\"}",
      Body = new MemoryStream(Encoding.UTF8.GetBytes("{\"message\":\"Internal Server Error\"}")),
    };
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Serializer;
using Algolia.Search.Transport;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;
using Moq;
using Xunit;

namespace Algolia.Search.Tests;

public class LoggingTests
{
  private const string NonRoutableIp = "10.255.255.1";
  private const string NonRoutableIp2 = "10.255.255.2";
  private const int ConnectTimeoutSeconds = 2;

  private readonly List<TestLogEntry> _logs = new();
  private readonly TestLoggerFactory _loggerFactory;

  public LoggingTests()
  {
    _loggerFactory = new TestLoggerFactory(_logs);
  }

  // ── Helpers ─────────────────────────────────────────────────────────────────

  private static StatefulHost GetTestServerHost()
  {
    var host =
      Environment.GetEnvironmentVariable("CI") == "true" ? "localhost" : "host.docker.internal";
    return new StatefulHost
    {
      Url = host,
      Port = 6676,
      Scheme = HttpScheme.Http,
      Accept = CallType.Read | CallType.Write,
    };
  }

  private HttpTransport CreateTransportWithServerHost()
  {
    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost> { GetTestServerHost() },
      ConnectTimeout = TimeSpan.FromSeconds(ConnectTimeoutSeconds),
    };
    return new HttpTransport(config, new AlgoliaHttpRequester(_loggerFactory), _loggerFactory);
  }

  private HttpTransport CreateTransportWithHosts(params string[] hosts)
  {
    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = hosts
        .Select(h => new StatefulHost { Url = h, Accept = CallType.Read | CallType.Write, Up = true })
        .ToList(),
      ConnectTimeout = TimeSpan.FromSeconds(ConnectTimeoutSeconds),
    };
    return new HttpTransport(config, new AlgoliaHttpRequester(_loggerFactory), _loggerFactory);
  }

  private HttpTransport CreateTransportWithMockHttp(IHttpRequester mockHttp)
  {
    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>
      {
        new() { Url = "localhost", Accept = CallType.Read | CallType.Write, Up = true },
      },
    };
    return new HttpTransport(config, mockHttp, _loggerFactory);
  }

  private IEnumerable<TestLogEntry> GetLogsByLevel(LogLevel level) =>
    _logs.Where(l => l.Level == level);

  private string AssertLogMatches(LogLevel level, string pattern, string description = "")
  {
    var match = GetLogsByLevel(level).FirstOrDefault(l => Regex.IsMatch(l.Message, pattern));
    if (match != null)
      return match.Message;

    var captured =
      _logs.Count > 0
        ? string.Join("\n  ", _logs.Select(l => $"[{l.Level}] {l.Message}"))
        : "(no logs captured)";

    throw new Xunit.Sdk.XunitException(
      $"{description}\nExpected [{level}] log matching: {pattern}\nCaptured logs:\n  {captured}"
    );
  }

  private static AlgoliaHttpResponse OkResponse(string body = "{}") =>
    new()
    {
      HttpStatusCode = 200,
      Body = new MemoryStream(Encoding.UTF8.GetBytes(body)),
      ResponseHeaders = new Dictionary<string, string> { { "content-type", "application/json" } },
    };

  // ── Tests ────────────────────────────────────────────────────────────────────

  [Fact]
  public async Task InfoRequestSummaryFormat()
  {
    var transport = CreateTransportWithServerHost();
    await transport.ExecuteRequestAsync(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions { UseReadTransporter = true }
    );

    AssertLogMatches(
      LogLevel.Information,
      @"GET .+ - \d{3} \(\d+ms\)",
      @"INFO log should match ""{METHOD} {URL} - {STATUS} ({DURATION}ms)"""
    );
  }

  [Fact]
  public async Task DebugRequestResponseDetails()
  {
    var transport = CreateTransportWithServerHost();
    await transport.ExecuteRequestAsync(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions { UseReadTransporter = true }
    );

    var debugMessages = GetLogsByLevel(LogLevel.Debug).Select(l => l.Message).ToList();
    Assert.Contains(debugMessages, m => m.Contains("Header:"));
    Assert.Contains(debugMessages, m => m.Contains("Response header:"));
    Assert.Contains(debugMessages, m => m.Contains("Response body:"));
  }

  [Fact]
  public async Task ApiKeyFilteredFromHeadersAndUrls()
  {
    var transport = CreateTransportWithServerHost();
    await transport.ExecuteRequestAsync(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions
      {
        UseReadTransporter = true,
        QueryParameters = new Dictionary<string, string> { ["apiKey"] = "secret-in-url" },
      }
    );

    foreach (var log in _logs)
    {
      Assert.DoesNotContain("test-api-key", log.Message);
      Assert.DoesNotContain("secret-in-url", log.Message);
    }

    var headerLog = AssertLogMatches(LogLevel.Debug, "Header:", "Should have request header debug log");
    Assert.Contains("[FILTERED]", headerLog);
  }

  [Fact]
  public async Task RetryLogFormats()
  {
    try
    {
      await CreateTransportWithHosts(NonRoutableIp, NonRoutableIp2).ExecuteRequestAsync(
        HttpMethod.Get,
        "/1/test",
        new InternalRequestOptions { UseReadTransporter = true }
      );
    }
    catch (AlgoliaUnreachableHostException) { }

    AssertLogMatches(
      LogLevel.Information,
      @"Retry attempt \d+/\d+ for GET",
      @"INFO log should match ""Retry attempt {N}/{MAX} for {METHOD} {PATH}"""
    );

    AssertLogMatches(
      LogLevel.Debug,
      @"Retrying .+ HTTP \d+",
      "DEBUG log should include retry details"
    );
  }

  [Fact]
  public async Task RetryExhaustionLogsError()
  {
    try
    {
      await CreateTransportWithHosts(NonRoutableIp).ExecuteRequestAsync(
        HttpMethod.Get,
        "/1/test",
        new InternalRequestOptions { UseReadTransporter = true }
      );
    }
    catch (AlgoliaUnreachableHostException) { }

    AssertLogMatches(
      LogLevel.Error,
      @"Request failed after \d+ retries",
      @"ERROR log should match ""Request failed after {MAX} retries: ..."""
    );
  }

  [Fact]
  public async Task RetryCompletionLogsInfo()
  {
    var badHost = new StatefulHost
    {
      Url = NonRoutableIp,
      Accept = CallType.Read | CallType.Write,
      Up = true,
    };
    var goodHost = GetTestServerHost();

    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost> { badHost, goodHost },
      ConnectTimeout = TimeSpan.FromSeconds(ConnectTimeoutSeconds),
    };

    var transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(_loggerFactory),
      _loggerFactory
    );

    await transport.ExecuteRequestAsync(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions { UseReadTransporter = true }
    );

    AssertLogMatches(
      LogLevel.Information,
      @"Request completed after \d+ retries \(total: \d+ms\)",
      @"INFO log should match ""Request completed after {N} retries (total: {DURATION}ms)"""
    );
  }

  [Fact]
  public async Task FailureOutcomeLogsError()
  {
    var mockHttp = new Mock<IHttpRequester>();
    mockHttp
      .Setup(h =>
        h.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .ReturnsAsync(
        new AlgoliaHttpResponse
        {
          HttpStatusCode = 403,
          Error = "Invalid API key",
        }
      );

    try
    {
      await CreateTransportWithMockHttp(mockHttp.Object).ExecuteRequestAsync(
        HttpMethod.Get,
        "/1/test",
        new InternalRequestOptions { UseReadTransporter = true }
      );
    }
    catch (AlgoliaApiException) { }

    AssertLogMatches(
      LogLevel.Error,
      @"Retry strategy with failure outcome",
      "ERROR log should be emitted on 4xx failure outcome"
    );
  }

  [Fact]
  public async Task DefaultLoggerProducesNoOutput()
  {
    var mockHttp = new Mock<IHttpRequester>();
    mockHttp
      .Setup(h =>
        h.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .ReturnsAsync(OkResponse());

    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>
      {
        new() { Url = "localhost", Accept = CallType.Read | CallType.Write, Up = true },
      },
    };
    var transport = new HttpTransport(config, mockHttp.Object, NullLoggerFactory.Instance);

    await transport.ExecuteRequestAsync(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions { UseReadTransporter = true }
    );

    // No logger was provided → NullLoggerFactory is used → nothing goes to _logs
    Assert.Empty(_logs);
  }

  [Fact]
  public async Task BatchOperationLogging()
  {
    var mockHttp = new Mock<IHttpRequester>();
    mockHttp
      .Setup(h =>
        h.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .ReturnsAsync(
        OkResponse(
          JsonSerializer.Serialize(
            new { taskID = 1, objectIDs = new[] { "1", "2" } },
            JsonConfig.Options
          )
        )
      );

    var config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>
      {
        new() { Url = "localhost", Accept = CallType.Read | CallType.Write, Up = true },
      },
    };

    var client = new SearchClient(config, mockHttp.Object, _loggerFactory);

    _logs.Clear();
    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "1" }, new { objectID = "2" } }
    );

    AssertLogMatches(
      LogLevel.Information,
      @"Batch operation started: AddObject on test-index",
      @"INFO log should match ""Batch operation started: {ACTION} on {INDEX}"""
    );
    AssertLogMatches(
      LogLevel.Information,
      @"Batch progress: 2/2 objects processed",
      @"INFO log should match ""Batch progress: {N}/{TOTAL} objects processed"""
    );
    AssertLogMatches(
      LogLevel.Information,
      @"Batch operation completed: 2 objects in \d+ms",
      @"INFO log should match ""Batch operation completed: {TOTAL} objects in {DURATION}ms"""
    );
  }

  [Fact]
  public void ClientInitLogging()
  {
    var loggerFactory = new TestLoggerFactory(_logs);
    _ = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), loggerFactory);

    AssertLogMatches(
      LogLevel.Information,
      @"Algolia Search client initialized \(appId: test-app-id\)",
      @"INFO log should match ""Algolia {ClientName} initialized (appId: {appId})"""
    );
    AssertLogMatches(
      LogLevel.Debug,
      @"WARNING: DEBUG level logging is enabled",
      "DEBUG log should warn about DEBUG level logging"
    );
  }

  [Fact]
  public async Task DeserializationErrorLogsError()
  {
    var mockHttp = new Mock<IHttpRequester>();
    mockHttp
      .Setup(h =>
        h.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .ReturnsAsync(OkResponse("not valid json {{{{"));

    try
    {
      await CreateTransportWithMockHttp(mockHttp.Object).ExecuteRequestAsync<SearchClient>(
        HttpMethod.Get,
        "/1/test",
        new InternalRequestOptions { UseReadTransporter = true }
      );
    }
    catch (AlgoliaException) { }

    AssertLogMatches(
      LogLevel.Error,
      @"Failed to deserialize response",
      @"ERROR log should match ""Failed to deserialize response: {ERROR}"""
    );
  }

  [Fact]
  public async Task SerializationErrorLogsError()
  {
    var mockHttp = new Mock<IHttpRequester>();
    mockHttp
      .Setup(h =>
        h.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .ReturnsAsync(OkResponse());

    try
    {
      // double.NaN cannot be serialized to JSON by System.Text.Json
      await CreateTransportWithMockHttp(mockHttp.Object).ExecuteRequestAsync<object>(
        HttpMethod.Post,
        "/1/test",
        new InternalRequestOptions { Data = new { value = double.NaN } }
      );
    }
    catch (AlgoliaException) { }

    AssertLogMatches(
      LogLevel.Error,
      @"Serialization error",
      @"ERROR log should match ""Serialization error: {ERROR}"""
    );
  }

  [Fact]
  public void DebugWarningLoggedOnlyOnce()
  {
    var loggerFactory = new TestLoggerFactory(_logs);

    _ = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), loggerFactory);
    _ = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), loggerFactory);

    var debugWarnings = _logs.Where(l =>
      l.Level == LogLevel.Debug && l.Message.Contains("WARNING: DEBUG level logging is enabled")
    );

    Assert.Single(debugWarnings);
  }
}

// ── Test Logger Infrastructure ────────────────────────────────────────────────

public class TestLogEntry
{
  public LogLevel Level { get; set; }
  public string Message { get; set; }
}

public class TestLogger(string categoryName, List<TestLogEntry> logs) : ILogger
{
  public void Log<TState>(
    LogLevel logLevel,
    EventId eventId,
    TState state,
    Exception exception,
    Func<TState, Exception, string> formatter
  ) => logs.Add(new TestLogEntry { Level = logLevel, Message = formatter(state, exception) });

  public bool IsEnabled(LogLevel logLevel) => true;

  public IDisposable BeginScope<TState>(TState state) => NullScope.Instance;

  private sealed class NullScope : IDisposable
  {
    public static readonly NullScope Instance = new();
    public void Dispose() { }
  }
}

public class TestLoggerFactory(List<TestLogEntry> logs) : ILoggerFactory
{
  public ILogger CreateLogger(string categoryName) => new TestLogger(categoryName, logs);

  public void AddProvider(ILoggerProvider provider) { }

  public void Dispose() { }
}

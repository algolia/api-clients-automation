using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Transport;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;
using Xunit;

namespace Algolia.Search.client;

public class TimeoutIntegrationTests
{
  private static (AlgoliaConfig, StatefulHost) CreateConfigWithHost(string hostUrl)
  {
    var config = new SearchConfig("test-app", "test-key");
    // keep ReadTimeout small so connect scaling stays measurable
    config.ReadTimeout = TimeSpan.FromMilliseconds(500);
    var host = new StatefulHost { Url = hostUrl, Accept = CallType.Read | CallType.Write };
    config.CustomHosts = new List<StatefulHost> { host };
    return (config, host);
  }

  private static StatefulHost CreateServerHost()
  {
    var serverHost =
      Environment.GetEnvironmentVariable("CI") == "true" ? "localhost" : "host.docker.internal";

    return new StatefulHost
    {
      Url = serverHost,
      Port = 6676,
      Scheme = HttpScheme.Http,
      Accept = CallType.Read | CallType.Write,
    };
  }

  private static AlgoliaConfig CreateServerConfig(TimeSpan connectTimeout, TimeSpan readTimeout)
  {
    var config = new SearchConfig("test-app", "test-key");
    config.ConnectTimeout = connectTimeout;
    config.ReadTimeout = readTimeout;
    config.CustomHosts = new List<StatefulHost> { CreateServerHost() };
    return config;
  }

  [Fact]
  public async Task RetryCountStateful()
  {
    // connect timeout scales with retryCount, plus 0.5s ReadTimeout: 2.5s -> 4.5s -> 6.5s
    var (config, _) = CreateConfigWithHost("10.255.255.1");
    var transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(NullLoggerFactory.Instance),
      NullLoggerFactory.Instance
    );

    var times = new List<double>();
    for (int i = 0; i < 3; i++)
    {
      var sw = Stopwatch.StartNew();
      try
      {
        await transport.ExecuteRequestAsync(
          HttpMethod.Get,
          "/test",
          new InternalRequestOptions { UseReadTransporter = true }
        );
      }
      catch (Exception)
      {
        sw.Stop();
        times.Add(sw.Elapsed.TotalSeconds);
      }
    }

    // Request 1: 2s * 1 + 0.5s = 2.5s
    // Request 2: 2s * 2 + 0.5s = 4.5s
    // Request 3: 2s * 3 + 0.5s = 6.5s
    Assert.True(times[0] > 2.0 && times[0] < 3.2, $"Request 1 should be ~2.5s, got {times[0]:F2}s");
    Assert.True(times[1] > 4.0 && times[1] < 5.2, $"Request 2 should be ~4.5s, got {times[1]:F2}s");
    Assert.True(times[2] > 6.0 && times[2] < 7.7, $"Request 3 should be ~6.5s, got {times[2]:F2}s");
  }

  [Fact]
  public async Task RetryCountResets()
  {
    // retry_count resets to 0 after successful request
    var (config, badHost) = CreateConfigWithHost("10.255.255.1");
    var goodHost = CreateServerHost();
    var transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(NullLoggerFactory.Instance),
      NullLoggerFactory.Instance
    );

    // fail twice to increment retry_count
    for (int i = 0; i < 2; i++)
    {
      try
      {
        await transport.ExecuteRequestAsync(
          HttpMethod.Get,
          "/test",
          new InternalRequestOptions { UseReadTransporter = true }
        );
      }
      catch (Exception)
      {
        // expected to fail
      }
    }

    // switch to good host and succeed
    config.CustomHosts = new List<StatefulHost> { goodHost };
    goodHost.RetryCount = badHost.RetryCount;
    transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(NullLoggerFactory.Instance),
      NullLoggerFactory.Instance
    );

    var response = await transport.ExecuteRequestAsync<AlgoliaHttpResponse>(
      HttpMethod.Get,
      "/1/test/instant",
      new InternalRequestOptions { UseReadTransporter = true }
    );

    Assert.Equal(200, response.HttpStatusCode);
    Assert.True(
      goodHost.RetryCount == 0,
      $"retry_count should reset to 0, got {goodHost.RetryCount}"
    );

    // point to bad host again, should timeout at ~2.5s, not ~6.5s
    goodHost.Url = "10.255.255.1";
    goodHost.Port = null;
    goodHost.Scheme = HttpScheme.Https;

    var sw = Stopwatch.StartNew();
    try
    {
      await transport.ExecuteRequestAsync(
        HttpMethod.Get,
        "/test",
        new InternalRequestOptions { UseReadTransporter = true }
      );
      Assert.Fail("Request should have timed out");
    }
    catch (Exception)
    {
      sw.Stop();
      var elapsed = sw.Elapsed.TotalSeconds;
      Assert.True(
        elapsed > 2.0 && elapsed < 3.2,
        $"After reset should be ~2.5s, got {elapsed:F2}s"
      );
    }
  }

  [Fact]
  public async Task ReadTimeoutHonoredForSlowResponses()
  {
    var config = CreateServerConfig(TimeSpan.FromMilliseconds(100), TimeSpan.FromSeconds(2));
    var transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(NullLoggerFactory.Instance),
      NullLoggerFactory.Instance
    );

    var sw = Stopwatch.StartNew();
    var response = await transport.ExecuteRequestAsync<AlgoliaHttpResponse>(
      HttpMethod.Get,
      "/1/test/delayed-headers/700",
      new InternalRequestOptions { UseReadTransporter = true }
    );
    sw.Stop();

    Assert.Equal(200, response.HttpStatusCode);
    Assert.True(
      sw.Elapsed.TotalSeconds >= 0.6,
      $"Response should have taken ~0.7s, got {sw.Elapsed.TotalSeconds:F2}s"
    );
  }

  [Fact]
  public async Task ReadTimeoutEnforcedWhenResponseTooSlow()
  {
    var config = CreateServerConfig(TimeSpan.FromMilliseconds(200), TimeSpan.FromMilliseconds(300));
    var transport = new HttpTransport(
      config,
      new AlgoliaHttpRequester(NullLoggerFactory.Instance),
      NullLoggerFactory.Instance
    );

    var sw = Stopwatch.StartNew();
    var exception = await Assert.ThrowsAnyAsync<Exception>(() =>
      transport.ExecuteRequestAsync(
        HttpMethod.Get,
        "/1/test/delayed-headers/5000",
        new InternalRequestOptions { UseReadTransporter = true }
      )
    );
    sw.Stop();

    Assert.Contains("timed out", exception.Message);
    Assert.True(
      sw.Elapsed.TotalSeconds < 1.5,
      $"Timeout should fire at ~0.5s, got {sw.Elapsed.TotalSeconds:F2}s"
    );
  }
}

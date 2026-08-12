using System.Text;
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Moq;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

namespace Algolia.Search.Tests;

public class RequestIdTests
{
  private static readonly Regex RequestIdFormat = new("^[0-9A-Za-z]{11}$");

  private static string ObservedRequestId(Request request) =>
    request
      .Headers.Where(h => h.Key.Equals("request-id", StringComparison.OrdinalIgnoreCase))
      .Select(h => h.Value)
      .SingleOrDefault();

  private static AlgoliaHttpResponse JsonResponse(string json, int statusCode = 200) =>
    new()
    {
      HttpStatusCode = statusCode,
      Body = json == null ? null : new MemoryStream(Encoding.UTF8.GetBytes(json)),
    };

  private static Mock<IHttpRequester> RecordingMock(
    List<string> observedIds,
    Func<Request, AlgoliaHttpResponse> respond
  )
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, _, _, _) =>
        {
          observedIds.Add(ObservedRequestId(rq));
          return Task.FromResult(respond(rq));
        }
      );
    return httpMock;
  }

  [Fact]
  public async Task ShouldMintFreshRequestIdPerCall()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");
    await client.CustomGetAsync("1/test");

    Assert.Equal(2, observedIds.Count);
    Assert.All(observedIds, id => Assert.Matches(RequestIdFormat, id));
    Assert.NotEqual(observedIds[0], observedIds[1]);
  }

  [Fact]
  public async Task ShouldNotMutateDefaultHeadersWhenMinting()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");

    Assert.DoesNotContain(
      config.DefaultHeaders.Keys,
      k => k.Equals("request-id", StringComparison.OrdinalIgnoreCase)
    );
  }

  [Fact]
  public async Task ShouldReuseRequestIdAcrossRetries()
  {
    var observedIds = new List<string>();
    var attempts = 0;
    var httpMock = RecordingMock(
      observedIds,
      _ => ++attempts < 3 ? JsonResponse(null, 500) : JsonResponse("{}")
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");

    Assert.Equal(3, observedIds.Count);
    Assert.Matches(RequestIdFormat, observedIds[0]);
    Assert.All(observedIds, id => Assert.Equal(observedIds[0], id));
  }

  [Fact]
  public async Task ShouldKeepCallerSuppliedRequestId()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync(
      "1/test",
      options: new RequestOptions
      {
        Headers = new Dictionary<string, string> { { "ReQuEsT-iD", "CallerOwnedId" } },
      }
    );

    Assert.Equal(new List<string> { "CallerOwnedId" }, observedIds);
  }

  [Fact]
  public async Task ShouldKeepCallerSuppliedQueryParameterRequestId()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    // The server consults the query parameter only when the header is absent,
    // so minting a header would silently override the caller's ID.
    Uri observedUri = null;
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, _, _, _) =>
        {
          observedIds.Add(ObservedRequestId(rq));
          observedUri = rq.Uri;
          return Task.FromResult(JsonResponse("{}"));
        }
      );

    await client.CustomGetAsync(
      "1/test",
      options: new RequestOptions
      {
        QueryParameters = new Dictionary<string, object>
        {
          { "X-Algolia-Request-Id", "QueryOwned" },
        },
      }
    );

    // The URI check keeps this from passing vacuously when minting is off.
    Assert.Contains("QueryOwned", observedUri.Query);
    Assert.Equal(new List<string> { null }, observedIds);
  }

  [Fact]
  public async Task ShouldKeepDefaultHeadersRequestId()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    config.DefaultHeaders["REQUEST-ID"] = "DefaultOwned";
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");

    Assert.Equal(new List<string> { "DefaultOwned" }, observedIds);
  }

  [Fact]
  public async Task ShouldAllowCallersToDisableMinting()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");
    config.RequestIdEnabled = false;
    await client.CustomGetAsync("1/test");

    // The first call guards against a vacuous pass with minting off entirely.
    Assert.Equal(2, observedIds.Count);
    Assert.Matches(RequestIdFormat, observedIds[0]);
    Assert.Null(observedIds[1]);
  }

  [Fact]
  public async Task ShouldNeverMintForIngestion()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(observedIds, _ => JsonResponse("{}"));
    var config = new IngestionConfig("test-app-id", "test-api-key", "us");
    var client = new IngestionClient(config, httpMock.Object);

    await client.CustomGetAsync("1/test");

    Assert.Equal(new List<string> { null }, observedIds);
  }

  [Fact]
  public async Task ShouldShareOneRequestIdPerHelperInvocation()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(
      observedIds,
      rq =>
        rq.Uri.AbsolutePath.EndsWith("/batch")
          ? JsonResponse("{\"taskID\":42,\"objectIDs\":[\"1\"]}")
          : JsonResponse("{\"status\":\"published\",\"pendingTask\":false}")
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    // batchSize 1 over two objects: 2 batch calls + 2 task polls.
    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "1" }, new { objectID = "2" } },
      Action.AddObject,
      waitForTasks: true,
      batchSize: 1
    );

    Assert.Equal(4, observedIds.Count);
    Assert.Matches(RequestIdFormat, observedIds[0]);
    Assert.All(observedIds, id => Assert.Equal(observedIds[0], id));

    // A second helper invocation mints a fresh ID.
    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "3" } },
      Action.AddObject
    );

    Assert.Equal(5, observedIds.Count);
    Assert.Matches(RequestIdFormat, observedIds[4]);
    Assert.NotEqual(observedIds[0], observedIds[4]);
  }

  [Fact]
  public async Task ShouldKeepCallerRequestIdInHelpers()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(
      observedIds,
      _ => JsonResponse("{\"taskID\":42,\"objectIDs\":[\"1\"]}")
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "1" } },
      Action.AddObject,
      options: new RequestOptions
      {
        Headers = new Dictionary<string, string> { { "Request-ID", "HelperCaller" } },
      }
    );

    Assert.Equal(new List<string> { "HelperCaller" }, observedIds);
  }

  [Fact]
  public async Task ShouldExposeLastCorrelationIdOnExhaustion()
  {
    var observedIds = new List<string>();
    var attempts = 0;
    var httpMock = RecordingMock(
      observedIds,
      _ => new AlgoliaHttpResponse
      {
        HttpStatusCode = 500,
        Error = "unavailable",
        ResponseHeaders = new Dictionary<string, string>
        {
          { "Correlation-ID", $"CorrAttempt{++attempts}" },
        },
      }
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaUnreachableHostException>(async () =>
      await client.CustomGetAsync("1/test")
    );

    Assert.True(attempts > 1, "last-wins needs more than one attempt to prove anything");
    Assert.Equal($"CorrAttempt{attempts}", ex.CorrelationId);
    Assert.EndsWith($"(Correlation-ID: CorrAttempt{attempts})", ex.Message);
  }

  [Fact]
  public async Task ShouldLeaveExhaustionUntouchedWithoutCorrelationId()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(
      observedIds,
      _ => new AlgoliaHttpResponse { HttpStatusCode = 500, Error = "unavailable" }
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaUnreachableHostException>(async () =>
      await client.CustomGetAsync("1/test")
    );

    Assert.Null(ex.CorrelationId);
    Assert.DoesNotContain("Correlation-ID", ex.Message);
  }

  [Fact]
  public async Task ShouldExposeCorrelationIdOnApiErrors()
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(() =>
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 400,
            Error = "{\"message\":\"boom\"}",
            ResponseHeaders = new Dictionary<string, string>
            {
              { "cOrReLaTiOn-Id", "CorrTest123" },
              // The unrelated edge header must never be surfaced instead.
              { "X-Algolia-RequestID", "EdgePopValue" },
            },
          }
        )
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaApiException>(async () =>
      await client.CustomGetAsync("1/test")
    );

    Assert.Equal("CorrTest123", ex.CorrelationId);
    Assert.Equal(400, ex.HttpErrorCode);
    Assert.Equal("{\"message\":\"boom\"} (Correlation-ID: CorrTest123)", ex.Message);
  }

  [Fact]
  public async Task ShouldExposeRawResponseBodyOnApiErrors()
  {
    const string rawBody = "{\"message\":\"boom\",\"status\":400}";
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(() =>
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 400,
            Error = rawBody,
            ResponseHeaders = new Dictionary<string, string>
            {
              { "Correlation-ID", "CorrTest123" },
            },
          }
        )
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaApiException>(async () =>
      await client.CustomGetAsync("1/test")
    );

    // Message carries the Correlation-ID suffix; ResponseBody stays the exact raw body.
    Assert.EndsWith(" (Correlation-ID: CorrTest123)", ex.Message);
    Assert.Equal(rawBody, ex.ResponseBody);
    var parsed = JsonSerializer.Deserialize<Dictionary<string, JsonElement>>(ex.ResponseBody);
    Assert.Equal("boom", parsed["message"].GetString());
    Assert.Equal(400, parsed["status"].GetInt32());
  }

  [Fact]
  public async Task ShouldExposeCorrelationIdOnDeserializationErrors()
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(() =>
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(Encoding.UTF8.GetBytes("{not json")),
            ResponseHeaders = new Dictionary<string, string>
            {
              { "Correlation-ID", "CorrDeser123" },
            },
          }
        )
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaException>(async () =>
      await client.GetSettingsAsync("test-index")
    );

    Assert.Equal("CorrDeser123", ex.CorrelationId);
    Assert.EndsWith(" (Correlation-ID: CorrDeser123)", ex.Message);
  }

  [Fact]
  public async Task ShouldPreserveAllRequestOptionsWhenHelperMintsRequestId()
  {
    var recorded = new List<(Request Request, TimeSpan RequestTimeout, TimeSpan ConnectTimeout)>();
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, requestTimeout, connectTimeout, _) =>
        {
          recorded.Add((rq, requestTimeout, connectTimeout));
          return Task.FromResult(
            rq.Uri.AbsolutePath.EndsWith("/batch")
              ? JsonResponse("{\"taskID\":42,\"objectIDs\":[\"1\"]}")
              : JsonResponse("{\"status\":\"published\",\"pendingTask\":false}")
          );
        }
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    // All five RequestOptions properties set, no request-id: WithRequestId
    // takes the copy branch and must not drop any of them.
    var options = new RequestOptions
    {
      Headers = new Dictionary<string, string> { { "X-Caller-Header", "kept" } },
      QueryParameters = new Dictionary<string, object> { { "callerParam", "kept" } },
      ReadTimeout = TimeSpan.FromSeconds(41),
      WriteTimeout = TimeSpan.FromSeconds(42),
      ConnectTimeout = TimeSpan.FromSeconds(43),
    };

    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "1" } },
      Action.AddObject,
      waitForTasks: true,
      options: options
    );

    // One batch write plus one task poll, both built from the copied options.
    Assert.Equal(2, recorded.Count);
    var mintedId = ObservedRequestId(recorded[0].Request);
    Assert.Matches(RequestIdFormat, mintedId);
    foreach (var (request, _, connectTimeout) in recorded)
    {
      Assert.Equal(mintedId, ObservedRequestId(request));
      Assert.Equal(
        "kept",
        request
          .Headers.Where(h => h.Key.Equals("X-Caller-Header", StringComparison.OrdinalIgnoreCase))
          .Select(h => h.Value)
          .Single()
      );
      Assert.Contains("callerParam=kept", request.Uri.Query);
      Assert.Equal(TimeSpan.FromSeconds(43), connectTimeout);
    }

    // The batch is a write call, the task poll a read call.
    Assert.Equal(TimeSpan.FromSeconds(42), recorded[0].RequestTimeout);
    Assert.Equal(TimeSpan.FromSeconds(41), recorded[1].RequestTimeout);
  }

  [Fact]
  public async Task ShouldLeaveApiErrorsUntouchedWithoutCorrelationId()
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(() =>
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 400,
            Error = "{\"message\":\"boom\"}",
            // Timeout and network paths leave ResponseHeaders null.
            ResponseHeaders = null,
          }
        )
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var ex = await Assert.ThrowsAsync<AlgoliaApiException>(async () =>
      await client.CustomGetAsync("1/test")
    );

    Assert.Null(ex.CorrelationId);
    Assert.Equal("{\"message\":\"boom\"}", ex.Message);
    Assert.Equal(ex.Message, ex.ResponseBody);
    Assert.DoesNotContain("Correlation-ID", ex.ToString());
  }

  [Fact]
  public async Task ShouldForwardRequestOptionsFromIndexExists()
  {
    Request observed = null;
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, _, _, _) =>
        {
          observed = rq;
          return Task.FromResult(JsonResponse("{}"));
        }
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    var exists = await client.IndexExistsAsync(
      "test-index",
      new RequestOptions
      {
        Headers = new Dictionary<string, string> { { "X-Caller-Header", "kept" } },
      }
    );

    Assert.True(exists);
    Assert.Equal(
      "kept",
      observed
        .Headers.Where(h => h.Key.Equals("X-Caller-Header", StringComparison.OrdinalIgnoreCase))
        .Select(h => h.Value)
        .Single()
    );

    // The sync twin is a RunSync delegate; smoke it end to end as well.
    observed = null;
    Assert.True(
      client.IndexExists(
        "test-index",
        new RequestOptions
        {
          Headers = new Dictionary<string, string> { { "X-Caller-Header", "kept" } },
        }
      )
    );
    Assert.Contains(
      observed.Headers,
      h => h.Key.Equals("X-Caller-Header", StringComparison.OrdinalIgnoreCase) && h.Value == "kept"
    );
  }

  [Fact]
  public async Task ShouldCleanUpTmpIndexWhenCallerCancels()
  {
    var deletes = new List<string>();
    using var cts = new CancellationTokenSource();
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, _, _, ct) =>
        {
          // A real requester observes the token before sending.
          ct.ThrowIfCancellationRequested();
          if (rq.Method == HttpMethod.Delete)
          {
            deletes.Add(rq.Uri.AbsolutePath);
            return Task.FromResult(
              JsonResponse("{\"taskID\":42,\"deletedAt\":\"2021-01-01T00:00:00Z\"}")
            );
          }
          if (rq.Uri.AbsolutePath.EndsWith("/batch"))
          {
            cts.Cancel();
            ct.ThrowIfCancellationRequested();
          }
          if (rq.Uri.AbsolutePath.Contains("/task/"))
          {
            return Task.FromResult(
              JsonResponse("{\"status\":\"published\",\"pendingTask\":false}")
            );
          }
          return Task.FromResult(
            JsonResponse("{\"taskID\":42,\"updatedAt\":\"2021-01-01T00:00:00Z\"}")
          );
        }
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    await Assert.ThrowsAnyAsync<OperationCanceledException>(async () =>
      await client.ReplaceAllObjectsAsync(
        "test-index",
        new List<object> { new { objectID = "1" } },
        cancellationToken: cts.Token
      )
    );

    // The cleanup delete must go through even though the caller's token is canceled.
    var deletedPath = Assert.Single(deletes);
    Assert.StartsWith("/1/indexes/test-index_tmp_", deletedPath);
  }

  [Fact]
  public async Task ShouldKeepRootCauseWhenCleanupDeleteFails()
  {
    var deletes = new List<string>();
    using var cts = new CancellationTokenSource();
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.IsAny<Request>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns<Request, TimeSpan, TimeSpan, CancellationToken>(
        (rq, _, _, ct) =>
        {
          ct.ThrowIfCancellationRequested();
          if (rq.Method == HttpMethod.Delete)
          {
            deletes.Add(rq.Uri.AbsolutePath);
            return Task.FromResult(
              new AlgoliaHttpResponse
              {
                HttpStatusCode = 403,
                Error = "{\"message\":\"forbidden\"}",
              }
            );
          }
          if (rq.Uri.AbsolutePath.EndsWith("/batch"))
          {
            cts.Cancel();
            ct.ThrowIfCancellationRequested();
          }
          if (rq.Uri.AbsolutePath.Contains("/task/"))
          {
            return Task.FromResult(
              JsonResponse("{\"status\":\"published\",\"pendingTask\":false}")
            );
          }
          return Task.FromResult(
            JsonResponse("{\"taskID\":42,\"updatedAt\":\"2021-01-01T00:00:00Z\"}")
          );
        }
      );
    var config = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(config, httpMock.Object);

    // The forbidden cleanup delete must not replace the caller's cancellation.
    await Assert.ThrowsAnyAsync<OperationCanceledException>(async () =>
      await client.ReplaceAllObjectsAsync(
        "test-index",
        new List<object> { new { objectID = "1" } },
        cancellationToken: cts.Token
      )
    );

    Assert.Single(deletes);
  }

  [Fact]
  public async Task ShouldKeepDefaultHeadersRequestIdInHelpers()
  {
    var observedIds = new List<string>();
    var httpMock = RecordingMock(
      observedIds,
      rq =>
        rq.Uri.AbsolutePath.EndsWith("/batch")
          ? JsonResponse("{\"taskID\":42,\"objectIDs\":[\"1\"]}")
          : JsonResponse("{\"status\":\"published\",\"pendingTask\":false}")
    );
    var config = new SearchConfig("test-app-id", "test-api-key");
    config.DefaultHeaders["REQUEST-ID"] = "DefaultOwned";
    var client = new SearchClient(config, httpMock.Object);

    // A helper mint into request options would override DefaultHeaders in the
    // merge, so WithRequestId must not mint at all here.
    await client.ChunkedBatchAsync(
      "test-index",
      new List<object> { new { objectID = "1" } },
      Action.AddObject,
      waitForTasks: true
    );

    Assert.Equal(2, observedIds.Count);
    Assert.All(observedIds, id => Assert.Equal("DefaultOwned", id));
  }
}

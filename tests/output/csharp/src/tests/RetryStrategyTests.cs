using System.Text;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Algolia.Search.Transport;
using Moq;
using Newtonsoft.Json;
using Xunit;

namespace Algolia.Search.Tests.tests;

public class RetryStrategyTests
{
  [Fact]
  public async Task ShouldRetryOnAllEligibleHostFailed()
  {
    var httpMock = new Mock<IHttpRequester>();
    var searchConfig = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(searchConfig, httpMock.Object);

    // The `SearchSingleIndexAsync` use Host with CallType = Read
    var eligibleHosts = searchConfig
      .DefaultHosts.Where(x => x.Accept.HasFlag(CallType.Read))
      .Select(x => x.Url);

    IList<string> actualHosts = new List<string>();

    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/test-index/query")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // Always return a 500 from Algolia server
      .Returns(Task.FromResult(new AlgoliaHttpResponse { HttpStatusCode = 500, Body = null }))
      .Callback(
        (Request rq, TimeSpan _, TimeSpan _, CancellationToken _) => actualHosts.Add(rq.Uri.Host)
      );

    // Do a simple search
    await Assert.ThrowsAsync<AlgoliaUnreachableHostException>(
      async () =>
        await client.SearchSingleIndexAsync<object>(
          "test-index",
          new SearchParams(new SearchParamsObject { Query = "" })
        )
    );

    Assert.Equal(eligibleHosts, actualHosts);
  }

  [Fact]
  public async Task ShouldThrowsWhenAllRetriesFailed()
  {
    var httpMock = new Mock<IHttpRequester>();
    var searchConfig = new SearchConfig("test-app-id", "test-api-key");
    var client = new SearchClient(searchConfig, httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/test-index/query")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call return a 500 from Algolia server
      .Returns(Task.FromResult(new AlgoliaHttpResponse { HttpStatusCode = 500, Body = null }))
      // Second call return a 300 from Algolia server
      .Returns(Task.FromResult(new AlgoliaHttpResponse { HttpStatusCode = 300, Body = null }))
      .Returns(Task.FromResult(new AlgoliaHttpResponse { IsTimedOut = true, Body = null }))
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            IsNetworkError = true,
            Error = "DNS server not responding",
            Body = null
          }
        )
      );

    // Do a simple search and expect a AlgoliaUnreachableHostException after 4 retries
    var exception = await Assert.ThrowsAsync<AlgoliaUnreachableHostException>(
      async () =>
        await client.SearchSingleIndexAsync<object>(
          "test-index",
          new SearchParams(new SearchParamsObject { Query = "" })
        )
    );

    Assert.Equal(
      "RetryStrategy failed to connect to Algolia. Reason: DNS server not responding",
      exception.Message
    );

    // Verify that the request has been called 4 times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/test-index/query")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(4)
    );
  }

  [Fact]
  public async Task CanOverrideHost()
  {
    var httpMock = new Mock<IHttpRequester>();
    var searchConfig = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>()
      {
        new()
        {
          Url = "myhost.com",
          Accept = CallType.Read,
          Up = true
        }
      }
    };

    var client = new SearchClient(searchConfig, httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r =>
            r.Uri.AbsoluteUri.Equals("https://myhost.com/1/indexes/test-index/query")
          ),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                JsonConvert.SerializeObject(
                  new SearchResponse<object>()
                  {
                    HitsPerPage = 10,
                    NbHits = 1,
                    NbPages = 1,
                    Page = 1,
                    ProcessingTimeMS = 1,
                    Hits = new List<object>(),
                    Query = "",
                    VarParams = ""
                  }
                )
              )
            )
          }
        )
      );

    // Do a simple search and expect a AlgoliaUnreachableHostException after 4 retries
    await client.SearchSingleIndexAsync<object>(
      "test-index",
      new SearchParams(new SearchParamsObject { Query = "" })
    );

    // Verify that the request has been called 1 times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r =>
            r.Uri.AbsoluteUri.Equals("https://myhost.com/1/indexes/test-index/query")
          ),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(1)
    );
  }
}

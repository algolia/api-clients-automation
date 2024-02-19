using System.Text;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Serializer;
using Algolia.Search.Utils;
using Microsoft.Extensions.Logging.Abstractions;
using Moq;
using Xunit;
using TaskStatus = Algolia.Search.Models.Search.TaskStatus;

namespace Algolia.Search.Tests;

public class ClientExtensionsTests
{
  private DefaultJsonSerializer serializer = new(new NullLoggerFactory());

  [Fact]
  public async Task ShouldWaitForTask()
  {
    var httpMock = new Mock<IHttpRequester>();
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/test/task/12345")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call return a task that is not published
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(new GetTaskResponse { Status = TaskStatus.NotPublished })
              )
            )
          }
        )
      )
      // Second call return a task that is published
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(new GetTaskResponse { Status = TaskStatus.Published })
              )
            )
          }
        )
      );

    // Wait for the task to be published
    await client.WaitForTaskAsync("test", 12345);

    // Verify that the request has been called twice
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/test/task/12345")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(2)
    );
  }

  [Fact]
  public async Task ShouldWaitForApiKey()
  {
    var httpMock = new Mock<IHttpRequester>();
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/keys/my-key")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call throw an exception
      .Throws(new AlgoliaApiException("Oupss", 0))
      // Next call return a 404
      .Returns(Task.FromResult(new AlgoliaHttpResponse { HttpStatusCode = 404 }))
      // Third call return a Http 200
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new GetApiKeyResponse() { CreatedAt = 12, Acl = new List<Acl>() }
                )
              )
            )
          }
        )
      );

    await client.WaitForApiKeyAsync(ApiKeyOperation.Add, "my-key");

    // Verify that the request has been called three times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/keys/my-key")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(3)
    );
  }

  [Fact]
  public async Task ShouldBrowseObjects()
  {
    var httpMock = new Mock<IHttpRequester>();
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/browse")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call return two Hits with a cursor
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new BrowseResponse<object>()
                  {
                    Hits = new List<object> { new(), new() },
                    Cursor = "A cursor ...",
                    HitsPerPage = 1,
                    NbHits = 2,
                    NbPages = 3,
                    Page = 0,
                    ProcessingTimeMS = 1,
                    Query = "",
                    VarParams = ""
                  }
                )
              )
            )
          }
        )
      )
      // Second call return two Hits with a cursor
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new BrowseResponse<object>()
                  {
                    Hits = new List<object> { new(), new() },
                    Cursor = "Another cursor ...",
                    HitsPerPage = 1,
                    NbHits = 2,
                    NbPages = 3,
                    Page = 0,
                    ProcessingTimeMS = 1,
                    Query = "",
                    VarParams = ""
                  }
                )
              )
            )
          }
        )
      )
      // Third call return one hit with no cursor
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new BrowseResponse<object>()
                  {
                    Hits = new List<object> { new() },
                    Cursor = null,
                    HitsPerPage = 1,
                    NbHits = 2,
                    NbPages = 3,
                    Page = 0,
                    ProcessingTimeMS = 1,
                    Query = "",
                    VarParams = ""
                  }
                )
              )
            )
          }
        )
      );

    var browseObjectsAsync = await client.BrowseObjectsAsync<object>(
      "my-test-index",
      new BrowseParamsObject()
    );

    // Verify that the request has been called three times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/browse")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(3)
    );

    Assert.Equal(5, browseObjectsAsync.Count());
  }

  [Fact]
  public async Task ShouldBrowseSynonyms()
  {
    var httpMock = new Mock<IHttpRequester>();
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r =>
            r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/synonyms/search")
          ),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call return 1000 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchSynonymsResponse()
                  {
                    Hits = new List<SynonymHit>()
                    {
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 },
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 1000,
                  }
                )
              )
            )
          }
        )
      )
      // Second call return again 1000 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchSynonymsResponse()
                  {
                    Hits = new List<SynonymHit>()
                    {
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 },
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 1000,
                  }
                )
              )
            )
          }
        )
      )
      // Third call return 999 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchSynonymsResponse
                  {
                    Hits = new List<SynonymHit>
                    {
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 },
                      new() { ObjectID = "XXX", Type = SynonymType.Altcorrection1 }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 999,
                  }
                )
              )
            )
          }
        )
      );

    var browseSynonymsAsync = await client.BrowseSynonymsAsync(
      "my-test-index",
      new SearchSynonymsParams()
    );

    // Verify that the request has been called three times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r =>
            r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/synonyms/search")
          ),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(3)
    );

    Assert.Equal(6, browseSynonymsAsync.Count());
  }

  [Fact]
  public async Task ShouldBrowseRules()
  {
    var httpMock = new Mock<IHttpRequester>();
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    httpMock
      .SetupSequence(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/rules/search")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        )
      )
      // First call return 1000 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchRulesResponse
                  {
                    Page = 0,
                    NbPages = 2,
                    Hits = new List<Rule>
                    {
                      new() { ObjectID = "XXX" },
                      new() { ObjectID = "XXX" }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 1000,
                  }
                )
              )
            )
          }
        )
      )
      // Second call return again 1000 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchRulesResponse
                  {
                    Page = 0,
                    NbPages = 2,
                    Hits = new List<Rule>
                    {
                      new() { ObjectID = "XXX" },
                      new() { ObjectID = "XXX" }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 1000,
                  }
                )
              )
            )
          }
        )
      )
      // Third call return 999 Hits
      .Returns(
        Task.FromResult(
          new AlgoliaHttpResponse
          {
            HttpStatusCode = 200,
            Body = new MemoryStream(
              Encoding.UTF8.GetBytes(
                serializer.Serialize(
                  new SearchRulesResponse
                  {
                    Page = 0,
                    NbPages = 2,
                    Hits = new List<Rule>
                    {
                      new() { ObjectID = "XXX" },
                      new() { ObjectID = "XXX" }
                    }, // Not 1000 but it doesn't matter
                    NbHits = 999,
                  }
                )
              )
            )
          }
        )
      );

    var browseSynonymsAsync = await client.BrowseRulesAsync(
      "my-test-index",
      new SearchRulesParams()
    );

    // Verify that the request has been called three times
    httpMock.Verify(
      m =>
        m.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/my-test-index/rules/search")),
          It.IsAny<TimeSpan>(),
          It.IsAny<TimeSpan>(),
          It.IsAny<CancellationToken>()
        ),
      Times.Exactly(3)
    );

    Assert.Equal(6, browseSynonymsAsync.Count());
  }

  [Fact]
  public async Task ShouldSearchForHits()
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/*/queries")),
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
                serializer.Serialize(
                  new SearchResponses<object>(
                    [
                      new(new SearchForFacetValuesResponse() { FacetHits = new List<FacetHits>() }),
                      new(new SearchResponse<object> { Hits = [new { ObjectID = "12345" }] }),
                      new(new SearchResponse<object> { Hits = [new { ObjectID = "678910" }] })
                    ]
                  )
                )
              )
            )
          }
        )
      );

    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    var hits = await client.SearchForHitsAsync<Hit>(
      new List<SearchForHits>
      {
        new() { IndexName = "my-test-index", Query = " " }
      },
      SearchStrategy.None
    );

    Assert.Equal(2, hits.Count);
  }

  [Fact]
  public async Task ShouldSearchForFacets()
  {
    var httpMock = new Mock<IHttpRequester>();
    httpMock
      .Setup(c =>
        c.SendRequestAsync(
          It.Is<Request>(r => r.Uri.AbsolutePath.EndsWith("/1/indexes/*/queries")),
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
                serializer.Serialize(
                  new SearchResponses<object>(
                    [
                      new(new SearchForFacetValuesResponse { FacetHits = [] }),
                      new(new SearchResponse<object> { Hits = [new { ObjectID = "12345" }] }),
                      new(new SearchResponse<object> { Hits = [new { ObjectID = "678910" }] })
                    ]
                  )
                )
              )
            )
          }
        )
      );

    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), httpMock.Object);

    var hits = await client.SearchForFacetsAsync(
      new List<SearchForFacets>
      {
        new() { IndexName = "my-test-index", Query = " " }
      },
      SearchStrategy.None
    );

    Assert.Single(hits);
  }

  [Fact]
  public void ShouldGenerateSecuredApiKey()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"));
    var securedApiKey = client.GenerateSecuredApiKeys("parent-api-key", new SecuredApiKeyRestriction
    {
      Query = new IndexSettingsAsSearchParams
      {
        Mode = Mode.NeuralSearch,
        HitsPerPage = 10,
        OptionalWords = ["one", "two"],
        QueryType = QueryType.PrefixNone,
        EnableRules = true,
        AlternativesAsExact = [AlternativesAsExact.IgnorePlurals, AlternativesAsExact.SingleWordSynonym],
        AttributeCriteriaComputedByMinProximity = false
      },
      RestrictIndices = ["index1", "index2"],
      RestrictSources = ["source1", "source2"],
      UserToken = "my-user-token",
      ValidUntil = 1
    });

    const string expectedQueryParams = "optionalWords=one%2Ctwo&alternativesAsExact=ignorePlurals%2CsingleWordSynonym&queryType=prefixNone&mode=neuralSearch&hitsPerPage=10&enableRules=true&attributeCriteriaComputedByMinProximity=false&restrictIndices=index1%2Cindex2&restrictSources=source1%2Csource2&validUntil=1&userToken=my-user-token";
    var hash = HmacShaHelper.GetHash("parent-api-key", expectedQueryParams);
    var expectedKey = HmacShaHelper.Base64Encode($"{hash}{expectedQueryParams}");

    Assert.Equal(expectedKey, securedApiKey);
  }
}

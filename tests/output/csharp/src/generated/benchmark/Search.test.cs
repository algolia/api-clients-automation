// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.benchmark;

public class SearchClientBenchmark
{
  private Exception _ex;

  public SearchClientBenchmark() { }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "benchmark the search method")]
  public async Task BenchmarkTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
    {
      CustomHosts = new List<StatefulHost>
      {
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6682,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    for (int i = 0; i < 2000; i++)
    {
      var res = await client.SearchAsync<Hit>(
        new SearchMethodParams
        {
          Requests = new List<SearchQuery>
          {
            new SearchQuery(
              new SearchForHits
              {
                IndexName = "cts_e2e_benchmark_search_csharp",
                Query = "iphone 15 pro max 512gb",
                HitsPerPage = 50,
              }
            ),
          },
        }
      );
    }
  }
}

namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchWithOptionalFilters
{
  private static readonly List<string> labels =
  [ /* Your labels */
  ];

  private static OptionalFilters ReduceLabelsToFilters(List<string> labels)
  {
    return new OptionalFilters([]); // Implement your logic here
  }

  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
    var optionalFilters = ReduceLabelsToFilters(labels);
    var searchParams = new SearchParams(
      new SearchParamsObject { Query = "<YOUR_SEARCH_QUERY>", OptionalFilters = optionalFilters }
    );

    await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
  }
}

namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchFuturePublishedBooks
{
  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
    var dateTimestamp = DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();
    var searchParams = new SearchParams(
      new SearchParamsObject
      {
        Query = "<YOUR_SEARCH_QUERY>",
        Filters = $"date_timestamp > {dateTimestamp}",
      }
    );

    await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
  }
}

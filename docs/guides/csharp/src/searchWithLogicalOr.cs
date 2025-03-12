namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchWithLogicalOr
{
  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

    var query = "the query";

    var optionalWords = new OptionalWords(["the", "query"]);

    var searchParams = new SearchParams(
      new SearchParamsObject { Query = query, OptionalWords = optionalWords }
    );

    await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
  }
}

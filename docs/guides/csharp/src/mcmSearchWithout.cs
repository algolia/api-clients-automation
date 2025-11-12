namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class McmSearchWithout
{
  private static string GetAppIdFor(string user)
  {
    return ""; // Implement your own logic here
  }

  private static string GetIndexingApiKeyFor(string user)
  {
    return ""; // Implement your own logic here
  }

  async Task Main(string[] args)
  {
    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    var appId = GetAppIdFor("user42");
    var apiKey = GetIndexingApiKeyFor("user42");

    var client = new SearchClient(new SearchConfig(appId, apiKey));
    var searchParams = new SearchParams(
      new SearchParamsObject
      {
        Query = "<YOUR_SEARCH_QUERY>",
        FacetFilters = new FacetFilters([
          new FacetFilters("user:user42"),
          new FacetFilters("user:public"),
        ]),
      }
    );

    await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
  }
}

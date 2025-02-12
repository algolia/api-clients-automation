namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchInReplicaIndex
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

      var query = "query";

      // 1. Change the sort dynamically based on the UI events
      var sortByPrice = false;

      // 2. Get the index name based on sortByPrice
      var indexName = sortByPrice ? "products_price_desc" : "products";

      // 3. Search on dynamic index name (primary or replica)
      await client.SearchSingleIndexAsync<Hit>(
        indexName,
        new SearchParams(new SearchParamsObject { Query = "query" })
      );
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchRecentlyPublishedBooks
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      var date = DateTime.UtcNow.AddYears(-1);
      var sTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
      var unixTime = (long)(date - sTime).TotalSeconds;
      var searchParams = new SearchParams(
        new SearchParamsObject
        {
          Query = "<YOUR_SEARCH_QUERY>",
          Filters = $"date_timestamp > {unixTime}",
        }
      );

      await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

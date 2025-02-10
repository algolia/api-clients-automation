namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchWithGAToken
{
  private static string GetGoogleAnalyticsUserIdFromBrowserCookie(string cookieName)
  {
    return ""; // Implement your logic here
  }

  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      var userToken = GetGoogleAnalyticsUserIdFromBrowserCookie("_ga");
      var searchParams = new SearchParams(
        new SearchParamsObject { Query = "<YOUR_SEARCH_QUERY>", UserToken = userToken }
      );

      await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);

      string? loggedInUser = null;
      searchParams.AsSearchParamsObject().UserToken = loggedInUser ?? userToken;

      await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

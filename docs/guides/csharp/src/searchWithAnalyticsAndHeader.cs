namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchWithAnalyticsAndHeader
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

      /*
      '94.228.178.246' should be replaced with your user's IP address.
      Depending on your stack there are multiple ways to get this information.
      */
      var ip = "94.228.178.246";
      var query = "query";

      var searchParams = new SearchParams(
        new SearchParamsObject { Query = query, Analytics = true }
      );

      await client.SearchSingleIndexAsync<Hit>(
        "<YOUR_INDEX_NAME>",
        searchParams,
        new RequestOptionBuilder().AddExtraHeader("X-Forwarded-For", ip).Build()
      );
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

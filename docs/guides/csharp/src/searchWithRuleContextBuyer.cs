namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SearchWithRuleContextBuyer
{
  private static string GetBuyerAccountId()
  {
    return ""; // Implement your logic here
  }

  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      // get the buyer account information
      var buyer = GetBuyerAccountId();
      var searchParams = new SearchParams(
        new SearchParamsObject { Query = "<YOUR_SEARCH_QUERY>", RuleContexts = [buyer] }
      );

      await client.SearchSingleIndexAsync<Hit>("<YOUR_INDEX_NAME>", searchParams);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

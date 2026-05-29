namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class GlobalAlgoliaUserToken
{
  async Task Main(string[] args)
  {
    var client = new SearchClient(
      new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
      {
        DefaultHeaders = new Dictionary<string, string>
        {
          { "X-Algolia-UserToken", "test-user-123" },
        },
      }
    );
    Console.WriteLine(client);
  }
}

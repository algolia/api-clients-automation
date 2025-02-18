namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveObjectsPublicUser
{
  private static readonly List<Dictionary<string, object>> playlists = []; // Your records

  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      await client.SaveObjectsAsync(
        "<YOUR_INDEX_NAME>",
        playlists,
        false,
        1000,
        new RequestOptionBuilder().AddExtraHeader("X-Algolia-User-ID", "*").Build()
      );
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

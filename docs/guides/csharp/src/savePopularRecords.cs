namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SavePopularRecords
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      var records = new List<Dictionary<string, object>>();

      var hits = await client.BrowseObjectsAsync<Hit>(
        "<YOUR_INDEX_NAME>",
        new BrowseParamsObject()
      );

      foreach (var hit in hits)
      {
        var props = hit.AdditionalProperties ?? new Dictionary<string, object>();
        var nbFollowers = props["nbFollowers"] as int? ?? 0;
        records.Add(
          new Dictionary<string, object>
          {
            ["twitterHandle"] = props["twitterHandle"],
            ["nbFollowers"] = nbFollowers,
            ["isPopular"] = nbFollowers >= 1_000_000,
          }
        );
      }

      await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", records);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveObjectsMcm
{
  private readonly List<Dictionary<string, object>> playlists = []; // Your records

  private static List<Dictionary<string, string>> GetAllAppIdConfigurations()
  {
    return
    [ /* A list of your MCM AppID/ApiKey pairs */
    ];
  }

  async Task Main(string[] args)
  {
    // Fetch from your own data storage and with your own code
    // the list of application IDs and API keys to target each cluster
    var configurations = GetAllAppIdConfigurations();

    // Send the records to each cluster
    foreach (var config in configurations)
    {
      try
      {
        var client = new SearchClient(
          new SearchConfig(
            config.GetValueOrDefault("appID", ""),
            config.GetValueOrDefault("apiKey", "")
          )
        );
        await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", playlists);
      }
      catch (Exception e)
      {
        Console.WriteLine(e.Message);
      }
    }
  }
}

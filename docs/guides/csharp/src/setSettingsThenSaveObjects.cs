namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SetSettingsThenSaveObjects
{
  private static readonly List<Dictionary<string, object>> playlists = []; // Your records

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
    foreach (var playlist in playlists)
    {
      // Fetch from your own data storage and with your own code
      // the associated application ID and API key for this user
      var appId = GetAppIdFor((playlist.GetValueOrDefault("user", "") as string)!);
      var apiKey = GetIndexingApiKeyFor((playlist.GetValueOrDefault("user", "") as string)!);

      try
      {
        var client = new SearchClient(new SearchConfig(appId, apiKey));
        var settings = new IndexSettings { AttributesForFaceting = ["searchable(playlistName)"] };
        await client.SetSettingsAsync("<YOUR_INDEX_NAME>", settings);

        await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", playlists);
      }
      catch (Exception e)
      {
        Console.WriteLine(e.Message);
      }
    }
  }
}

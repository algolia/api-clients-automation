namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveObjectsChunks
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));
      var jsonContent = await File.ReadAllTextAsync("actors.json");
      var records = JsonSerializer.Deserialize<List<Dictionary<string, object>>>(jsonContent);

      const int chunkSize = 10000;

      for (var beginIndex = 0; beginIndex < records?.Count; beginIndex += chunkSize)
      {
        var chunk = records.Slice(beginIndex, Math.Min(beginIndex + chunkSize, records.Count));
        await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", chunk);
      }
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

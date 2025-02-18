namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveObjectsModified
{
  async Task Main(string[] args)
  {
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

      var jsonContent = await File.ReadAllTextAsync("products.json");
      var products = JsonSerializer.Deserialize<List<Dictionary<string, object>>>(jsonContent);

      var records = products
        ?.Select(product =>
        {
          var reference = product.GetValueOrDefault("product_reference", "") as string;
          var suffixes = new List<string>();

          for (var i = reference!.Length; i > 1; i--)
          {
            suffixes.Add(reference[i..]);
          }

          return new Dictionary<string, object>(product) { ["suffixes"] = suffixes };
        })
        .ToList();

      await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", records);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

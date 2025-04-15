namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveImageClassifications
{
  class Image
  {
    public required string ImageUrl { get; set; }
    public required string ObjectId { get; set; }
    public required List<Dictionary<string, object>> Objects { get; set; }
  }

  // Retrieve labels
  async Task<Image> GetImageLabels(string imageURL, string objectID, float scoreLimit)
  {
    // Implement your image classification logic here
    return await Task.Run(
      () =>
        new Image
        {
          ImageUrl = "",
          ObjectId = "",
          Objects = [],
        }
    );
  }

  async Task Main(string[] args)
  {
    try
    {
      // API key ACL should include editSettings / addObject
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

      var hits = await client.BrowseObjectsAsync<Image>(
        "<YOUR_INDEX_NAME>",
        new BrowseParamsObject()
      );

      var records = hits.Select(hit => GetImageLabels(hit.ImageUrl, hit.ObjectId, 0.5f))
        .Select(src => src.Result)
        .ToList();

      // Update records with image classifications
      await client.PartialUpdateObjectsAsync("<YOUR_INDEX_NAME>", records, true);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SaveImageClassificationsAndSettings
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

      var images = hits.ToList();
      var records = images
        .Select(hit => GetImageLabels(hit.ImageUrl, hit.ObjectId, 0.5f))
        .Select(src => src.Result)
        .ToList();

      // Update records with image classifications
      await client.PartialUpdateObjectsAsync("<YOUR_INDEX_NAME>", records, true);

      List<string> facets = [];
      List<string> attributes = [];

      foreach (var image in images)
      {
        foreach (var obj in image.Objects)
        {
          foreach (var key in obj.Keys)
          {
            if (obj[key] is IEnumerable<object>)
            {
              facets.Add($"searchable(objects.{key}.label)");
              facets.Add($"searchable(objects.{key}.score)");
              attributes.Add($"objects.{key}.label");
            }
          }
        }
      }

      var currentSettings = await client.GetSettingsAsync("<YOUR_INDEX_NAME>");

      var settings = new IndexSettings
      {
        SearchableAttributes = currentSettings.SearchableAttributes.Concat(attributes).ToList(),
        AttributesForFaceting = currentSettings.AttributesForFaceting.Concat(facets).ToList(),
      };

      await client.SetSettingsAsync("<YOUR_INDEX_NAME>", settings);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

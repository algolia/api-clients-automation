namespace Algolia;

using System;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SetUpTransformationOptionsWithOverrides
{
  async Task Main(string[] args)
  {
    // Override the Ingestion API defaults. Any option you don't set keeps its default.
    // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
    var transformationOptions = new TransformationOptions("us")
    {
      ConnectTimeout = TimeSpan.FromMilliseconds(5000),
      ReadTimeout = TimeSpan.FromMilliseconds(30000),
    };
    var client = SearchClient.WithTransformation(
      "ALGOLIA_APPLICATION_ID",
      "ALGOLIA_API_KEY",
      transformationOptions
    );

    // Save records, transforming them through the Push connector
    try
    {
      var result = await client.SaveObjectsWithTransformationAsync(
        "<YOUR_INDEX_NAME>",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "1" }, { "name", "Adam" } },
          new Dictionary<string, string> { { "objectID", "2" }, { "name", "Benoit" } },
        },
        true
      );
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

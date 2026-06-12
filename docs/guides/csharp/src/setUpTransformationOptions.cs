namespace Algolia;

using System;
using System.Collections.Generic;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SetUpTransformationOptions
{
  async Task Main(string[] args)
  {
    // Set TransformationOptions with your transformation region to use the `WithTransformation` helper methods.
    // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
    var client = SearchClient.WithTransformation(
      "ALGOLIA_APPLICATION_ID",
      "ALGOLIA_API_KEY",
      new TransformationOptions("us")
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

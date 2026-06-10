namespace Algolia;

using System;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;

class Compression
{
  async Task Main(string[] args)
  {
    // Initialize the client with gzip compression enabled
    // Compression reduces the size of request bodies sent to Algolia
    var client = new SearchClient(
      new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")
      {
        Compression = CompressionType.Gzip,
      }
    );

    // Search with compressed request body
    try
    {
      var result = await client.SearchSingleIndexAsync<Hit>(
        "<YOUR_INDEX_NAME>",
        new SearchParams(new SearchParamsObject { Query = "comedy" })
      );
      Console.WriteLine(result);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

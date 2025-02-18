namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class DeleteMultipleIndices
{
  async Task Main(string[] args)
  {
    // You need an API key with `deleteIndex`
    try
    {
      var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

      // List all indices
      var indices = await client.ListIndicesAsync();

      // Primary indices don't have a `primary` key
      var primaryIndices = indices.Items.Where(item => item.Primary == null).ToList();
      var replicaIndices = indices.Items.Where(item => item.Primary != null).ToList();

      // Delete primary indices first
      if (primaryIndices.Count > 0)
      {
        var requests = primaryIndices
          .Select(index => new MultipleBatchRequest(Search.Models.Search.Action.Delete, index.Name))
          .ToList();
        await client.MultipleBatchAsync(new BatchParams { Requests = requests });
        Console.WriteLine("Deleted primary indices.");
      }

      // Now, delete replica indices
      if (replicaIndices.Count > 0)
      {
        var requests = replicaIndices
          .Select(index => new MultipleBatchRequest(Search.Models.Search.Action.Delete, index.Name))
          .ToList();
        await client.MultipleBatchAsync(new BatchParams { Requests = requests });
        Console.WriteLine("Deleted replica indices.");
      }
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

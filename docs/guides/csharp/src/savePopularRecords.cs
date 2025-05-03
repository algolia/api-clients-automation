namespace Algolia;

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;

class SavePopularRecords
{
  class Record
  {
    public int NbFollowers { get; set; }
    public required string TwitterHandle { get; set; }
    public bool IsPopular { get; set; }
  }

  async Task Main(string[] args)
  {
    var client = new SearchClient(new SearchConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY"));

    var hits = await client.BrowseObjectsAsync<Record>(
      "<YOUR_INDEX_NAME>",
      new BrowseParamsObject()
    );

    var records = hits.Select(hit => new Record
      {
        TwitterHandle = hit.TwitterHandle,
        NbFollowers = hit.NbFollowers,
        IsPopular = hit.NbFollowers >= 1_000_000,
      })
      .ToList();

    await client.SaveObjectsAsync("<YOUR_INDEX_NAME>", records);
  }
}

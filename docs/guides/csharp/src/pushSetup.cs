namespace Algolia;

using System;
using System.Collections.Generic;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Ingestion;
using Action = Algolia.Search.Models.Ingestion.Action;

class PushSetup
{
  async Task Main(string[] args)
  {
    try
    {
      var jsonContent = await File.ReadAllTextAsync("records.json");

      var records = JsonSerializer.Deserialize<List<PushTaskRecords>>(jsonContent);

      // use the region matching your applicationID
      var client = new IngestionClient(
        new IngestionConfig(
          "ALGOLIA_APPLICATION_ID",
          "ALGOLIA_API_KEY",
          "ALGOLIA_APPLICATION_REGION"
        )
      );

      // setting `watch` to `true` will make the call synchronous
      var resp = await client.PushTaskAsync(
        "YOUR_TASK_ID",
        new PushTaskPayload { Action = Enum.Parse<Action>("AddObject"), Records = records },
        true
      );

      Console.WriteLine(resp);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

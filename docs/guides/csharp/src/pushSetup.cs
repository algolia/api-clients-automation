using System;
using System.Collections.Generic;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;
using static Algolia.Search.Models.Ingestion.PushTaskRecords;
using Action = Algolia.Search.Models.Ingestion.Action;

class PushSetup
{
  public static async Task Main(string[] args)
  {
    string jsonContent = File.ReadAllText("records.json");

    var records = JsonSerializer.Deserialize<List<PushTaskRecords>>(jsonContent);

    // use the region matching your applicationID
    var client = new IngestionClient(
      new IngestionConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    try
    {
      var run = await client.PushTaskAsync(
        "YOUR_TASK_ID",
        new PushTaskPayload { Action = Enum.Parse<Action>("AddObject"), Records = records }
      );
      Console.WriteLine(run.RunID);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}

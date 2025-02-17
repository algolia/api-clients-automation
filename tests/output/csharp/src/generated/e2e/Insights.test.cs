// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Insights;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Ingestion.Action;

namespace Algolia.Search.e2e;

public class InsightsClientRequestTestsE2E
{
  private readonly InsightsClient client;

  public InsightsClientRequestTestsE2E()
  {
    DotEnv.Load(
      options: new DotEnvOptions(
        ignoreExceptions: true,
        probeForEnv: true,
        probeLevelsToSearch: 8,
        envFilePaths: new[] { ".env" }
      )
    );

    var appId = Environment.GetEnvironmentVariable("ALGOLIA_APPLICATION_ID");
    if (appId == null)
    {
      throw new Exception("please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests");
    }

    var apiKey = Environment.GetEnvironmentVariable("ALGOLIA_ADMIN_KEY");
    if (apiKey == null)
    {
      throw new Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests");
    }

    client = new InsightsClient(new InsightsConfig(appId, apiKey, "us"));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "Many events type")]
  public async Task PushEventsTest1()
  {
    try
    {
      var resp = await client.PushEventsAsync(
        new InsightsEvents
        {
          Events = new List<EventsItems>
          {
            new EventsItems(
              new ConvertedObjectIDsAfterSearch
              {
                EventType = Enum.Parse<ConversionEvent>("Conversion"),
                EventName = "Product Purchased",
                Index = "products",
                UserToken = "user-123456",
                AuthenticatedUserToken = "user-123456",
                Timestamp = 1739750400000L,
                ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
                QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              }
            ),
            new EventsItems(
              new ViewedObjectIDs
              {
                EventType = Enum.Parse<ViewEvent>("View"),
                EventName = "Product Detail Page Viewed",
                Index = "products",
                UserToken = "user-123456",
                AuthenticatedUserToken = "user-123456",
                Timestamp = 1739750400000L,
                ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              }
            ),
          },
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"message\":\"OK\",\"status\":200}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }
}

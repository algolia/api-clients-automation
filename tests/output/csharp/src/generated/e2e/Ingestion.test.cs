// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Ingestion;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using dotenv.net;
using Quibble.Xunit;
using Xunit;
using Action = Algolia.Search.Models.Search.Action;

namespace Algolia.Search.e2e;

public class IngestionClientRequestTestsE2E
{
  private readonly IngestionClient client;

  public IngestionClientRequestTestsE2E()
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

    client = new IngestionClient(new IngestionConfig(appId, apiKey, "us"));
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "enable task e2e")]
  public async Task EnableTaskTest()
  {
    try
    {
      var resp = await client.EnableTaskAsync("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getAuthentications with query params")]
  public async Task GetAuthenticationsTest1()
  {
    try
    {
      var resp = await client.GetAuthenticationsAsync(
        2,
        1,
        new List<AuthenticationType>
        {
          Enum.Parse<AuthenticationType>("Basic"),
          Enum.Parse<AuthenticationType>("Algolia")
        },
        new List<PlatformWithNone> { new PlatformWithNone(Enum.Parse<PlatformNone>("None")) },
        Enum.Parse<AuthenticationSortKeys>("CreatedAt"),
        Enum.Parse<OrderKeys>("Asc")
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"pagination\":{\"page\":1,\"itemsPerPage\":2},\"authentications\":[{\"authenticationID\":\"474f050f-a771-464c-a016-323538029f5f\",\"type\":\"algolia\",\"name\":\"algolia-auth-1677060483885\",\"input\":{},\"createdAt\":\"2023-02-22T10:08:04Z\",\"updatedAt\":\"2023-10-25T08:41:56Z\"},{}]}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "getSource")]
  public async Task GetSourceTest()
  {
    try
    {
      var resp = await client.GetSourceAsync("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "{\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"name\":\"cts_e2e_browse\",\"type\":\"json\",\"input\":{\"url\":\"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json\"}}",
        JsonSerializer.Serialize(resp, JsonConfig.Options),
        new JsonDiffConfig(true)
      );
    }
    catch (Exception e)
    {
      Assert.Fail("An exception was thrown: " + e.Message);
    }
  }

  [Fact(DisplayName = "searchTasks")]
  public async Task SearchTasksTest()
  {
    try
    {
      var resp = await client.SearchTasksAsync(
        new TaskSearch
        {
          TaskIDs = new List<string>
          {
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
          },
        }
      );
      // Check status code 200
      Assert.NotNull(resp);

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\",\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"destinationID\":\"506d79fa-e29d-4bcf-907c-6b6a41172153\",\"trigger\":{\"type\":\"onDemand\"},\"enabled\":true,\"failureThreshold\":0,\"action\":\"replace\",\"createdAt\":\"2024-01-08T16:47:41Z\"}]",
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

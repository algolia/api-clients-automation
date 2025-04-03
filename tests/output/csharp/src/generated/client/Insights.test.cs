// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Insights;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.client;

public class InsightsClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public InsightsClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Insights (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "the user agent contains the latest version")]
  public async Task CommonApiTest1()
  {
    var client = new InsightsClient(new InsightsConfig("appId", "apiKey", "us"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex("^Algolia for Csharp \\(7.16.2\\).*");
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "fallbacks to the alias when region is not given")]
  public async Task ParametersTest0()
  {
    var client = new InsightsClient(new InsightsConfig("my-app-id", "my-api-key"), _echo);

    await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ClickedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ClickEvent>("Click"),
              EventName = "Product Clicked",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              Positions = new List<int> { 7, 6 },
            }
          ),
        },
      }
    );
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("insights.algolia.io", result.Host);
  }

  [Fact(DisplayName = "uses the correct region")]
  public async Task ParametersTest1()
  {
    var client = new InsightsClient(new InsightsConfig("my-app-id", "my-api-key", "us"), _echo);

    await client.CustomDeleteAsync("test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("insights.us.algolia.io", result.Host);
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest2()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new InsightsClient(
        new InsightsConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` must be one of the following: de, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "switch API key")]
  public async Task SetClientApiKeyTest0()
  {
    InsightsConfig _config = new InsightsConfig("test-app-id", "test-api-key", "us")
    {
      CustomHosts = new List<StatefulHost>
      {
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6683,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new InsightsClient(_config);

    {
      var res = await client.CustomGetAsync("check-api-key/1");

      JsonAssert.EqualOverrideDefault(
        "{\"headerAPIKeyValue\":\"test-api-key\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
    {
      client.SetClientApiKey("updated-api-key");
    }
    {
      var res = await client.CustomGetAsync("check-api-key/2");

      JsonAssert.EqualOverrideDefault(
        "{\"headerAPIKeyValue\":\"updated-api-key\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }
}

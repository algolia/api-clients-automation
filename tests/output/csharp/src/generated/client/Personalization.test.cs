// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Personalization;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.client;

public class PersonalizationClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public PersonalizationClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("appId", "apiKey", "us"),
      _echo
    );
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "the user agent contains the latest version")]
  public async Task CommonApiTest1()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("appId", "apiKey", "us"),
      _echo
    );
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex("^Algolia for Csharp \\(7.16.1\\).*");
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "throws when region is not given")]
  public async Task ParametersTest0()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new PersonalizationClient(
        new PersonalizationConfig("my-app-id", "my-api-key", ""),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "throws when incorrect region is given")]
  public async Task ParametersTest1()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new PersonalizationClient(
        new PersonalizationConfig("my-app-id", "my-api-key", "not_a_region"),
        _echo
      );
    });
    Assert.Equal(
      "`region` is required and must be one of the following: eu, us".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "does not throw when region is given")]
  public async Task ParametersTest2()
  {
    var client = new PersonalizationClient(
      new PersonalizationConfig("my-app-id", "my-api-key", "us"),
      _echo
    );
  }

  [Fact(DisplayName = "switch API key")]
  public async Task SetClientApiKeyTest0()
  {
    PersonalizationConfig _config = new PersonalizationConfig("test-app-id", "test-api-key", "us")
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
    var client = new PersonalizationClient(_config);

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

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
using System.Text.Json;
using System.Text.RegularExpressions;
using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Serializer;
using Algolia.Search.Tests.Utils;
using Algolia.Search.Transport;
using Quibble.Xunit;
using Xunit;

namespace Algolia.Search.client;

public class SearchClientTests
{
  private readonly EchoHttpRequester _echo;
  private Exception _ex;

  public SearchClientTests()
  {
    _echo = new EchoHttpRequester();
  }

  [Fact]
  public void Dispose() { }

  [Fact(DisplayName = "calls api with correct read host")]
  public async Task ApiTest0()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), _echo);

    await client.CustomGetAsync("test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("test-app-id-dsn.algolia.net", result.Host);
  }

  [Fact(DisplayName = "read transporter with POST method")]
  public async Task ApiTest1()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), _echo);

    await client.SearchSingleIndexAsync<Hit>("indexName");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("test-app-id-dsn.algolia.net", result.Host);
  }

  [Fact(DisplayName = "calls api with correct write host")]
  public async Task ApiTest2()
  {
    var client = new SearchClient(new SearchConfig("test-app-id", "test-api-key"), _echo);

    await client.CustomPostAsync("test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal("test-app-id.algolia.net", result.Host);
  }

  [Fact(DisplayName = "tests the retry strategy")]
  public async Task ApiTest3()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6676,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6677,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
        new()
        {
          Scheme = HttpScheme.Http,
          Url =
            Environment.GetEnvironmentVariable("CI") == "true"
              ? "localhost"
              : "host.docker.internal",
          Port = 6678,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    var res = await client.CustomGetAsync("1/test/retry/csharp");

    JsonAssert.EqualOverrideDefault(
      "{\"message\":\"ok test server response\"}",
      JsonSerializer.Serialize(res, JsonConfig.Options),
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "tests the retry strategy error")]
  public async Task ApiTest4()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6676,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var res = await client.CustomGetAsync("1/test/hang/csharp");
    });
    Assert.Equal(
      "RetryStrategy failed to connect to Algolia. Reason: The operation has timed out.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "test the compression strategy")]
  public async Task ApiTest5()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6678,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
      Compression = CompressionType.Gzip,
    };
    var client = new SearchClient(_config);

    var res = await client.CustomPostAsync(
      "1/test/gzip",
      new Dictionary<string, object> { },
      new Dictionary<string, string> { { "message", "this is a compressed body" } }
    );

    JsonAssert.EqualOverrideDefault(
      "{\"message\":\"ok compression test server response\",\"body\":{\"message\":\"this is a compressed body\"}}",
      JsonSerializer.Serialize(res, JsonConfig.Options),
      new JsonDiffConfig(false)
    );
  }

  [Fact(DisplayName = "calls api with correct user agent")]
  public async Task CommonApiTest0()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex(
        "^Algolia for Csharp \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
      );
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "the user agent contains the latest version")]
  public async Task CommonApiTest1()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;
    {
      var regexp = new Regex("^Algolia for Csharp \\(7.5.0\\).*");
      Assert.Matches(regexp, result.Headers["user-agent"]);
    }
  }

  [Fact(DisplayName = "calls api with default read timeouts")]
  public async Task CommonApiTest2()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomGetAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(5000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "calls api with default write timeouts")]
  public async Task CommonApiTest3()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    await client.CustomPostAsync("1/test");
    EchoResponse result = _echo.LastResponse;

    Assert.Equal(2000, result.ConnectTimeout.TotalMilliseconds);
    Assert.Equal(30000, result.ResponseTimeout.TotalMilliseconds);
  }

  [Fact(DisplayName = "call deleteObjects without error")]
  public async Task DeleteObjectsTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6680,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.DeleteObjectsAsync(
        "cts_e2e_deleteObjects_csharp",
        new List<string> { "1", "2" }
      );

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":666,\"objectIDs\":[\"1\",\"2\"]}]",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "generate secured api key basic")]
  public async Task GenerateSecuredApiKeyTest0()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    {
      var res = client.GenerateSecuredApiKey(
        "2640659426d5107b6e47d75db9cbaef8",
        new SecuredApiKeyRestrictions
        {
          ValidUntil = 2524604400L,
          RestrictIndices = new List<string> { "Movies" },
        }
      );

      Assert.Equal(
        "NjFhZmE0OGEyMTI3OThiODc0OTlkOGM0YjcxYzljY2M2NmU2NDE5ZWY0NDZjMWJhNjA2NzBkMjAwOTI2YWQyZnJlc3RyaWN0SW5kaWNlcz1Nb3ZpZXMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
        res
      );
    }
  }

  [Fact(DisplayName = "generate secured api key with searchParams")]
  public async Task GenerateSecuredApiKeyTest1()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    {
      var res = client.GenerateSecuredApiKey(
        "2640659426d5107b6e47d75db9cbaef8",
        new SecuredApiKeyRestrictions
        {
          ValidUntil = 2524604400L,
          RestrictIndices = new List<string> { "Movies", "cts_e2e_settings" },
          RestrictSources = "192.168.1.0/24",
          Filters = "category:Book OR category:Ebook AND _tags:published",
          UserToken = "user123",
          SearchParams = new SearchParamsObject
          {
            Query = "batman",
            TypoTolerance = new TypoTolerance(Enum.Parse<TypoToleranceEnum>("Strict")),
            AroundRadius = new AroundRadius(Enum.Parse<AroundRadiusAll>("All")),
            Mode = Enum.Parse<Mode>("NeuralSearch"),
            HitsPerPage = 10,
            OptionalWords = new List<string> { "one", "two" },
          },
        }
      );

      Assert.Equal(
        "MzAxMDUwYjYyODMxODQ3ZWM1ZDYzNTkxZmNjNDg2OGZjMjAzYjQyOTZhMGQ1NDJhMDFiNGMzYTYzODRhNmMxZWFyb3VuZFJhZGl1cz1hbGwmZmlsdGVycz1jYXRlZ29yeSUzQUJvb2slMjBPUiUyMGNhdGVnb3J5JTNBRWJvb2slMjBBTkQlMjBfdGFncyUzQXB1Ymxpc2hlZCZoaXRzUGVyUGFnZT0xMCZtb2RlPW5ldXJhbFNlYXJjaCZvcHRpb25hbFdvcmRzPW9uZSUyQ3R3byZxdWVyeT1iYXRtYW4mcmVzdHJpY3RJbmRpY2VzPU1vdmllcyUyQ2N0c19lMmVfc2V0dGluZ3MmcmVzdHJpY3RTb3VyY2VzPTE5Mi4xNjguMS4wJTJGMjQmdHlwb1RvbGVyYW5jZT1zdHJpY3QmdXNlclRva2VuPXVzZXIxMjMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
        res
      );
    }
  }

  [Fact(DisplayName = "indexExists")]
  public async Task IndexExistsTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.IndexExistsAsync("indexExistsYES");

      Assert.Equal(true, res);
    }
  }

  [Fact(DisplayName = "indexNotExists")]
  public async Task IndexExistsTest1()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.IndexExistsAsync("indexExistsNO");

      Assert.Equal(false, res);
    }
  }

  [Fact(DisplayName = "indexExistsWithError")]
  public async Task IndexExistsTest2()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var res = await client.IndexExistsAsync("indexExistsERROR");
    });
    Assert.Equal(
      "{\"message\":\"Invalid API key\"}".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "client throws with invalid parameters")]
  public async Task ParametersTest0()
  {
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("", ""), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("", "my-api-key"), _echo);
    });
    Assert.Equal("`appId` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var client = new SearchClient(new SearchConfig("my-app-id", ""), _echo);
    });
    Assert.Equal("`apiKey` is missing.".ToLowerInvariant(), _ex.Message.ToLowerInvariant());
  }

  [Fact(DisplayName = "`addApiKey` throws with invalid parameters")]
  public async Task ParametersTest1()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddApiKeyAsync(null);
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `apiKey` is required when calling `addApiKey`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "`addOrUpdateObject` throws with invalid parameters")]
  public async Task ParametersTest2()
  {
    var client = new SearchClient(new SearchConfig("appId", "apiKey"), _echo);
    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync(null, "my-object-id", new Dictionary<string, object> { });
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `indexName` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync(
        "my-index-name",
        null,
        new Dictionary<string, object> { }
      );
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `objectID` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      await client.AddOrUpdateObjectAsync("my-index-name", "my-object-id", null);
      EchoResponse result = _echo.LastResponse;
    });
    Assert.Equal(
      "Parameter `body` is required when calling `addOrUpdateObject`.".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "call partialUpdateObjects with createIfNotExists=true")]
  public async Task PartialUpdateObjectsTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6680,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.PartialUpdateObjectsAsync(
        "cts_e2e_partialUpdateObjects_csharp",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "1" }, { "name", "Adam" } },
          new Dictionary<string, string> { { "objectID", "2" }, { "name", "Benoit" } },
        },
        true
      );

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":444,\"objectIDs\":[\"1\",\"2\"]}]",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "call partialUpdateObjects with createIfNotExists=false")]
  public async Task PartialUpdateObjectsTest1()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6680,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.PartialUpdateObjectsAsync(
        "cts_e2e_partialUpdateObjects_csharp",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "3" }, { "name", "Cyril" } },
          new Dictionary<string, string> { { "objectID", "4" }, { "name", "David" } },
        },
        false
      );

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":555,\"objectIDs\":[\"3\",\"4\"]}]",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "call replaceAllObjects without error")]
  public async Task ReplaceAllObjectsTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6679,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.ReplaceAllObjectsAsync(
        "cts_e2e_replace_all_objects_csharp",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "1" }, { "name", "Adam" } },
          new Dictionary<string, string> { { "objectID", "2" }, { "name", "Benoit" } },
          new Dictionary<string, string> { { "objectID", "3" }, { "name", "Cyril" } },
          new Dictionary<string, string> { { "objectID", "4" }, { "name", "David" } },
          new Dictionary<string, string> { { "objectID", "5" }, { "name", "Eva" } },
          new Dictionary<string, string> { { "objectID", "6" }, { "name", "Fiona" } },
          new Dictionary<string, string> { { "objectID", "7" }, { "name", "Gael" } },
          new Dictionary<string, string> { { "objectID", "8" }, { "name", "Hugo" } },
          new Dictionary<string, string> { { "objectID", "9" }, { "name", "Igor" } },
          new Dictionary<string, string> { { "objectID", "10" }, { "name", "Julia" } },
        },
        3
      );

      JsonAssert.EqualOverrideDefault(
        "{\"copyOperationResponse\":{\"taskID\":125,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"},\"batchResponses\":[{\"taskID\":127,\"objectIDs\":[\"1\",\"2\",\"3\"]},{\"taskID\":130,\"objectIDs\":[\"4\",\"5\",\"6\"]},{\"taskID\":133,\"objectIDs\":[\"7\",\"8\",\"9\"]},{\"taskID\":134,\"objectIDs\":[\"10\"]}],\"moveOperationResponse\":{\"taskID\":777,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"}}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "call saveObjects without error")]
  public async Task SaveObjectsTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6680,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.SaveObjectsAsync(
        "cts_e2e_saveObjects_csharp",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "1" }, { "name", "Adam" } },
          new Dictionary<string, string> { { "objectID", "2" }, { "name", "Benoit" } },
        }
      );

      JsonAssert.EqualOverrideDefault(
        "[{\"taskID\":333,\"objectIDs\":[\"1\",\"2\"]}]",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "saveObjects should report errors")]
  public async Task SaveObjectsTest1()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "wrong-api-key")
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
          Port = 6680,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    _ex = await Assert.ThrowsAnyAsync<Exception>(async () =>
    {
      var res = await client.SaveObjectsAsync(
        "cts_e2e_saveObjects_csharp",
        new List<Object>
        {
          new Dictionary<string, string> { { "objectID", "1" }, { "name", "Adam" } },
          new Dictionary<string, string> { { "objectID", "2" }, { "name", "Benoit" } },
        }
      );
    });
    Assert.Equal(
      "{\"message\":\"Invalid Application-ID or API key\",\"status\":403}".ToLowerInvariant(),
      _ex.Message.ToLowerInvariant()
    );
  }

  [Fact(DisplayName = "switch API key")]
  public async Task SetClientApiKeyTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
    var client = new SearchClient(_config);

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

  [Fact(DisplayName = "wait for api key helper - add")]
  public async Task WaitForApiKeyTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.WaitForApiKeyAsync(
        "api-key-add-operation-test-csharp",
        Enum.Parse<ApiKeyOperation>("Add")
      );

      JsonAssert.EqualOverrideDefault(
        "{\"value\":\"api-key-add-operation-test-csharp\",\"description\":\"my new api key\",\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "wait for api key - update")]
  public async Task WaitForApiKeyTest1()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.WaitForApiKeyAsync(
        "api-key-update-operation-test-csharp",
        Enum.Parse<ApiKeyOperation>("Update"),
        new ApiKey
        {
          Description = "my updated api key",
          Acl = new List<Acl>
          {
            Enum.Parse<Acl>("Search"),
            Enum.Parse<Acl>("AddObject"),
            Enum.Parse<Acl>("DeleteObject"),
          },
          Indexes = new List<string> { "Movies", "Books" },
          Referers = new List<string> { "*google.com", "*algolia.com" },
          Validity = 305,
          MaxQueriesPerIPPerHour = 95,
          MaxHitsPerQuery = 20,
        }
      );

      JsonAssert.EqualOverrideDefault(
        "{\"value\":\"api-key-update-operation-test-csharp\",\"description\":\"my updated api key\",\"acl\":[\"search\",\"addObject\",\"deleteObject\"],\"indexes\":[\"Movies\",\"Books\"],\"referers\":[\"*google.com\",\"*algolia.com\"],\"validity\":305,\"maxQueriesPerIPPerHour\":95,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "wait for api key - delete")]
  public async Task WaitForApiKeyTest2()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.WaitForApiKeyAsync(
        "api-key-delete-operation-test-csharp",
        Enum.Parse<ApiKeyOperation>("Delete")
      );

      Assert.Equal(null, res);
    }
  }

  [Fact(DisplayName = "wait for an application-level task")]
  public async Task WaitForAppTaskTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.WaitForAppTaskAsync(123L);

      JsonAssert.EqualOverrideDefault(
        "{\"status\":\"published\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }

  [Fact(DisplayName = "wait for task")]
  public async Task WaitForTaskTest0()
  {
    SearchConfig _config = new SearchConfig("test-app-id", "test-api-key")
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
          Port = 6681,
          Up = true,
          LastUse = DateTime.UtcNow,
          Accept = CallType.Read | CallType.Write,
        },
      },
    };
    var client = new SearchClient(_config);

    {
      var res = await client.WaitForTaskAsync("wait-task-csharp", 123L);

      JsonAssert.EqualOverrideDefault(
        "{\"status\":\"published\"}",
        JsonSerializer.Serialize(res, JsonConfig.Options),
        new JsonDiffConfig(false)
      );
    }
  }
}

/*
* Recommend API
*
* The Recommend API lets you generate recommendations with several AI models.  > **Note**: You should use Algolia's [libraries and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with the Recommend API. Using the HTTP endpoints directly is not covered by the [SLA](https://www.algolia.com/policies/sla/).
*
* The version of the OpenAPI document: 1.0.0
* Generated by: https://github.com/openapitools/openapi-generator.git
*/


using System;
using System.Collections.Generic;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Algolia.Search.Transport;
using Algolia.Search.Utils;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Algolia.Search.Clients;

/// <summary>
/// Recommend client configuration
/// </summary>
public sealed class RecommendConfig : AlgoliaConfig
{
  /// <summary>
  /// The configuration of the Recommend client
  /// A client should have it's own configuration ie on configuration per client instance
  /// </summary>
  /// <param name="appId">Your application ID</param>
  /// <param name="apiKey">Your API Key</param>
  public RecommendConfig(string appId, string apiKey) : base(appId, apiKey, "Recommend")
  {
    DefaultHosts = GetDefaultHosts(appId);
    Compression = CompressionType.NONE;
  }
  private static List<StatefulHost> GetDefaultHosts(string appId)
  {
    List<StatefulHost> hosts = new List<StatefulHost>
  {
    new StatefulHost
    {
      Url = $"{appId}-dsn.algolia.net",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read
    },
    new StatefulHost
    {
      Url = $"{appId}.algolia.net", Up = true, LastUse = DateTime.UtcNow, Accept = CallType.Write,
    }
  };

    var commonHosts = new List<StatefulHost>
  {
    new StatefulHost
    {
      Url = $"{appId}-1.algolianet.com",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read | CallType.Write,
    },
    new StatefulHost
    {
      Url = $"{appId}-2.algolianet.com",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read | CallType.Write,
    },
    new StatefulHost
    {
      Url = $"{appId}-3.algolianet.com",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read | CallType.Write,
    }
  }.Shuffle();

    hosts.AddRange(commonHosts);
    return hosts;
  }
}


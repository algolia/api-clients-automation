/*
* Usage API
*
* The Usage API gives you access to statistics about all requests made to your Algolia applications.  ## Base URL  The base URL for requests to the Usage API is:  - `https://usage.algolia.com`  **All requests must use HTTPS.**  ## Authentication  To authenticate your API requests, add these headers:  - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. The Usage API key.  You can find your application ID and Usage API key in the [Algolia dashboard](https://dashboard.algolia.com/account).  ## Response status and errors  The Usage API returns JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API response.  Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more information.  ## Version  The current version of the Usage API is version 1, as indicated by the `/1/` in each endpoint's URL. 
*
* The version of the OpenAPI document: 1.0.0
* Generated by: https://github.com/openapitools/openapi-generator.git
*/


using System;
using System.Collections.Generic;
using Algolia.Search.Models.Common;
using Algolia.Search.Transport;
using Algolia.Search.Utils;

namespace Algolia.Search.Clients;

/// <summary>
/// Usage client configuration
/// </summary>
public sealed class UsageConfig : AlgoliaConfig
{
  /// <summary>
  /// The configuration of the Usage client
  /// A client should have it's own configuration ie on configuration per client instance
  /// </summary>
  /// <param name="appId">Your application ID</param>
  /// <param name="apiKey">Your API Key</param>
  public UsageConfig(string appId, string apiKey) : base(appId, apiKey, "Usage")
  {
    DefaultHosts = GetDefaultHosts(appId);
    Compression = CompressionType.None;
  }
  private static List<StatefulHost> GetDefaultHosts(string appId)
  {
    var hosts = new List<StatefulHost>
  {
    new()
    {
      Url = $"{appId}-dsn.algolia.net",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read
    },
    new()
    {
      Url = $"{appId}.algolia.net", Up = true, LastUse = DateTime.UtcNow, Accept = CallType.Write,
    }
  };

    var commonHosts = new List<StatefulHost>
  {
    new()
    {
      Url = $"{appId}-1.algolianet.com",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read | CallType.Write,
    },
    new()
    {
      Url = $"{appId}-2.algolianet.com",
      Up = true,
      LastUse = DateTime.UtcNow,
      Accept = CallType.Read | CallType.Write,
    },
    new()
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


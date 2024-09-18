/*
* Analytics API
*
* The Analytics API gives you access to metrics related to your Algolia search experience.  ## Base URLs  The base URLs for requests to the Analytics API are:  - `https://analytics.us.algolia.com` - `https://analytics.de.algolia.com` - `https://analytics.algolia.com` (routes requests to the closest of the above servers, based on your geographical location)  Use the URL that matches your [analytics region](https://dashboard.algolia.com/account/infrastructure/analytics).  **All requests must use HTTPS.**  ## Availability and authentication  Access to the Analytics API is available as part of the [Premium or Elevate plans](https://www.algolia.com/pricing).  To authenticate your API requests, add these headers:  - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the necessary permissions to make the request.   The required access control list (ACL) to make a request is listed in each endpoint's reference.  You can find your application ID and API key in the [Algolia dashboard](https://dashboard.algolia.com/account).  ## Rate limits  You can make up to **100 requests per minute per app** to the Analytics API. The response includes headers with information about the limits.  ## Parameters  Query parameters must be [URL-encoded](https://developer.mozilla.org/en-US/docs/Glossary/Percent-encoding). Non-ASCII characters must be UTF-8 encoded. Plus characters (`+`) are interpreted as spaces.  ## Response status and errors  The Analytics API returns JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API response.  Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more information.  ## Version  The current version of the Analytics API is version 2, as indicated by the `/2/` in each endpoint's URL. 
*
* The version of the OpenAPI document: 2.0.0
* Generated by: https://github.com/openapitools/openapi-generator.git
*/


using System;
using System.Collections.Generic;
using Algolia.Search.Models.Common;
using Algolia.Search.Transport;
using Algolia.Search.Utils;

namespace Algolia.Search.Clients;

/// <summary>
/// Analytics client configuration
/// </summary>
public sealed class AnalyticsConfig : AlgoliaConfig
{
  /// <summary>
  /// The configuration of the Analytics client
  /// A client should have it's own configuration ie on configuration per client instance
  /// </summary>
  /// <param name="appId">Your application ID</param>
  /// <param name="apiKey">Your API Key</param>
  /// <param name="region">Targeted region (optional)</param>
  public AnalyticsConfig(string appId, string apiKey, string region = null) : base(appId, apiKey, "Analytics", "7.4.0")
  {
    DefaultHosts = GetDefaultHosts(region);
    Compression = CompressionType.None;
  }
  private static List<StatefulHost> GetDefaultHosts(string region)
  {
    var regions = new List<string> { "de", "us" };
    if (region != null && !regions.Contains(region))
    {
      throw new ArgumentException($"`region` must be one of the following: {string.Join(", ", regions)}");
    }

    var selectedRegion = region == null ? "analytics.algolia.com" : "analytics.{region}.algolia.com".Replace("{region}", region);

    var hosts = new List<StatefulHost>
  {
    new()
    {
      Url = selectedRegion, Accept = CallType.Read | CallType.Write
    }
  };
    return hosts;
  }
}

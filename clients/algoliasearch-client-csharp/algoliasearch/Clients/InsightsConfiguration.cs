/*
* Insights API
*
* The Insights API lets you collect events related to your search and discovery experience. Events represent user interactions with your app or website. They unlock powerful features, such as recommendations, personalization, smarter search results, and analytics that help you optimize your user experience.  ## Client libraries  Use Algolia's API clients, libraries, and integrations to collect events from your UI and send them to the Insights API. See: [Algolia's ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/)  ## Base URLs  The base URLs for making requests to the Insights API are:  - `https://insights.us.algolia.io` - `https://insights.de.algolia.io` - `https//insights.algolia.io` (routes requests to the closest of the above servers, based on your geographical location)  **All requests must use HTTPS.**  ## Authentication  To authenticate your API requests, add these headers:  - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the necessary permissions to make the request.   The required access control list (ACL) to make a request is listed in each endpoint's reference.  You can find your application ID and API key in the [Algolia dashboard](https://dashboard.algolia.com/account).  ## Request format  Request bodies must be JSON objects.  ## Response status and errors  Response bodies are JSON objects. Deleting a user token returns an empty response body with rate-limiting information as headers.  Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more information.  The Insights API doesn't validate if the event parameters such as `indexName`, `objectIDs`, or `userToken`, correspond to anything in the Search API. It justs checks if they're formatted correctly. Check the [Events](https://dashboard.algolia.com/events/health) health section, whether your events can be used for Algolia features such as Analytics, or Dynamic Re-Ranking.  ## Version  The current version of the Insights API is version 1, as indicated by the `/1/` in each endpoint's URL. 
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
/// Insights client configuration
/// </summary>
public sealed class InsightsConfig : AlgoliaConfig
{
  /// <summary>
  /// The configuration of the Insights client
  /// A client should have it's own configuration ie on configuration per client instance
  /// </summary>
  /// <param name="appId">Your application ID</param>
  /// <param name="apiKey">Your API Key</param>
  /// <param name="region">Targeted region (optional)</param>
  public InsightsConfig(string appId, string apiKey, string region = null) : base(appId, apiKey, "Insights", "7.3.0")
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

    var selectedRegion = region == null ? "insights.algolia.io" : "insights.{region}.algolia.io".Replace("{region}", region);

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

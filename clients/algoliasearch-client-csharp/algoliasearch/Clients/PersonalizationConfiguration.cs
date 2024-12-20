/*
* Personalization API
*
* The Personalization API lets you access user profiles built from the personalization strategy.  ## Base URLs  The base URLs for requests to the Personalization API are:  - `https://personalization.us.algolia.com` - `https://personalization.eu.algolia.com`  Use the URL that matches your [analytics region](https://dashboard.algolia.com/account/infrastructure/analytics).  **All requests must use HTTPS.**  ## Authentication  To authenticate your API requests, add these headers:  - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the necessary permissions to make the request.   The required access control list (ACL) to make a request is listed in each endpoint's reference.  You can find your application ID and API key in the [Algolia dashboard](https://dashboard.algolia.com/account).  ## Request format  Request bodies must be JSON objects.  ## Response status and errors  The Personalization API returns JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API response.  Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more information.  ## Version  The current version of the Personalization API is version 1, as indicated by the `/1/` in each endpoint's URL. 
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
/// Personalization client configuration
/// </summary>
public sealed class PersonalizationConfig : AlgoliaConfig
{
  /// <summary>
  /// The configuration of the Personalization client
  /// A client should have it's own configuration ie on configuration per client instance
  /// </summary>
  /// <param name="appId">Your application ID</param>
  /// <param name="apiKey">Your API Key</param>
  /// <param name="region">Targeted region </param>
  public PersonalizationConfig(string appId, string apiKey, string region) : base(appId, apiKey, "Personalization", "7.11.2")
  {
    DefaultHosts = GetDefaultHosts(region);
    Compression = CompressionType.None;
    ReadTimeout = TimeSpan.FromSeconds(5);
    WriteTimeout = TimeSpan.FromSeconds(30);
    ConnectTimeout = TimeSpan.FromSeconds(2);
  }
  private static List<StatefulHost> GetDefaultHosts(string region)
  {
    var regions = new List<string> { "eu", "us" };
    if (region == null || !regions.Contains(region))
    {
      throw new ArgumentException($"`region` is required and must be one of the following: {string.Join(", ", regions)}");
    }

    var selectedRegion = "personalization.{region}.algolia.com".Replace("{region}", region);

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

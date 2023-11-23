/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;

namespace Org.OpenAPITools.Client
{
  /// <summary>
  /// Represents configuration aspects required to interact with the API endpoints.
  /// </summary>
  public interface IApiAccessor
  {
    /// <summary>
    /// Gets or sets the configuration object
    /// </summary>
    /// <value>An instance of the Configuration</value>
    IReadableConfiguration Configuration { get; set; }

    /// <summary>
    /// Gets the base path of the API client.
    /// </summary>
    /// <value>The base path</value>
    string GetBasePath();

    /// <summary>
    /// Provides a factory method hook for the creation of exceptions.
    /// </summary>
    ExceptionFactory ExceptionFactory { get; set; }
  }
}

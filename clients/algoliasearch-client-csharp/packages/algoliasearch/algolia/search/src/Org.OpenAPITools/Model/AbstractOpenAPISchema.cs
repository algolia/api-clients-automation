/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  ///  Abstract base class for oneOf, anyOf schemas in the OpenAPI specification
  /// </summary>
  public abstract partial class AbstractOpenAPISchema
  {
    /// <summary>
    ///  Custom JSON serializer
    /// </summary>
    static public readonly JsonSerializerSettings SerializerSettings = new JsonSerializerSettings
    {
      // OpenAPI generated types generally hide default constructors.
      ConstructorHandling = ConstructorHandling.AllowNonPublicDefaultConstructor,
      MissingMemberHandling = MissingMemberHandling.Error,
      ContractResolver = new DefaultContractResolver
      {
        NamingStrategy = new CamelCaseNamingStrategy
        {
          OverrideSpecifiedNames = false
        }
      }
    };

    /// <summary>
    ///  Custom JSON serializer for objects with additional properties
    /// </summary>
    static public readonly JsonSerializerSettings AdditionalPropertiesSerializerSettings = new JsonSerializerSettings
    {
      // OpenAPI generated types generally hide default constructors.
      ConstructorHandling = ConstructorHandling.AllowNonPublicDefaultConstructor,
      MissingMemberHandling = MissingMemberHandling.Ignore,
      ContractResolver = new DefaultContractResolver
      {
        NamingStrategy = new CamelCaseNamingStrategy
        {
          OverrideSpecifiedNames = false
        }
      }
    };

    /// <summary>
    /// Gets or Sets the actual instance
    /// </summary>
    public abstract Object ActualInstance { get; set; }

    /// <summary>
    /// Gets or Sets IsNullable to indicate whether the instance is nullable
    /// </summary>
    public bool IsNullable { get; protected set; }

    /// <summary>
    /// Gets or Sets the schema type, which can be either `oneOf` or `anyOf`
    /// </summary>
    public string SchemaType { get; protected set; }

    /// <summary>
    /// Converts the instance into JSON string.
    /// </summary>
    public abstract string ToJson();
  }
}

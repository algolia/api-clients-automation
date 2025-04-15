//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Record type for ecommerce sources.
/// </summary>
/// <value>Record type for ecommerce sources.</value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<RecordType>))]
public enum RecordType
{
  /// <summary>
  /// Enum Product for value: product
  /// </summary>
  [JsonPropertyName("product")]
  Product = 1,

  /// <summary>
  /// Enum Variant for value: variant
  /// </summary>
  [JsonPropertyName("variant")]
  Variant = 2,

  /// <summary>
  /// Enum Collection for value: collection
  /// </summary>
  [JsonPropertyName("collection")]
  Collection = 3
}


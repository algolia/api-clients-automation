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
/// Defines EventType
/// </summary>
public enum EventType
{
  /// <summary>
  /// Enum Fetch for value: fetch
  /// </summary>
  [JsonPropertyName("fetch")]
  Fetch = 1,

  /// <summary>
  /// Enum Record for value: record
  /// </summary>
  [JsonPropertyName("record")]
  Record = 2,

  /// <summary>
  /// Enum Log for value: log
  /// </summary>
  [JsonPropertyName("log")]
  Log = 3,

  /// <summary>
  /// Enum Transform for value: transform
  /// </summary>
  [JsonPropertyName("transform")]
  Transform = 4
}


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
/// An identifier that pairs with the outcome reason.
/// </summary>
/// <value>An identifier that pairs with the outcome reason.</value>
public enum RunReasonCode
{
  /// <summary>
  /// Enum Internal for value: internal
  /// </summary>
  [JsonPropertyName("internal")]
  Internal = 1,

  /// <summary>
  /// Enum Critical for value: critical
  /// </summary>
  [JsonPropertyName("critical")]
  Critical = 2,

  /// <summary>
  /// Enum NoEvents for value: no_events
  /// </summary>
  [JsonPropertyName("no_events")]
  NoEvents = 3,

  /// <summary>
  /// Enum TooManyErrors for value: too_many_errors
  /// </summary>
  [JsonPropertyName("too_many_errors")]
  TooManyErrors = 4,

  /// <summary>
  /// Enum Ok for value: ok
  /// </summary>
  [JsonPropertyName("ok")]
  Ok = 5,

  /// <summary>
  /// Enum Discarded for value: discarded
  /// </summary>
  [JsonPropertyName("discarded")]
  Discarded = 6,

  /// <summary>
  /// Enum Blocking for value: blocking
  /// </summary>
  [JsonPropertyName("blocking")]
  Blocking = 7
}


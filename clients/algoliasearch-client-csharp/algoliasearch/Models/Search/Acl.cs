//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Access control list permissions.
/// </summary>
/// <value>Access control list permissions.</value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<Acl>))]
public enum Acl
{
  /// <summary>
  /// Enum AddObject for value: addObject
  /// </summary>
  [JsonPropertyName("addObject")]
  AddObject = 1,

  /// <summary>
  /// Enum Analytics for value: analytics
  /// </summary>
  [JsonPropertyName("analytics")]
  Analytics = 2,

  /// <summary>
  /// Enum Browse for value: browse
  /// </summary>
  [JsonPropertyName("browse")]
  Browse = 3,

  /// <summary>
  /// Enum DeleteObject for value: deleteObject
  /// </summary>
  [JsonPropertyName("deleteObject")]
  DeleteObject = 4,

  /// <summary>
  /// Enum DeleteIndex for value: deleteIndex
  /// </summary>
  [JsonPropertyName("deleteIndex")]
  DeleteIndex = 5,

  /// <summary>
  /// Enum EditSettings for value: editSettings
  /// </summary>
  [JsonPropertyName("editSettings")]
  EditSettings = 6,

  /// <summary>
  /// Enum Inference for value: inference
  /// </summary>
  [JsonPropertyName("inference")]
  Inference = 7,

  /// <summary>
  /// Enum ListIndexes for value: listIndexes
  /// </summary>
  [JsonPropertyName("listIndexes")]
  ListIndexes = 8,

  /// <summary>
  /// Enum Logs for value: logs
  /// </summary>
  [JsonPropertyName("logs")]
  Logs = 9,

  /// <summary>
  /// Enum Personalization for value: personalization
  /// </summary>
  [JsonPropertyName("personalization")]
  Personalization = 10,

  /// <summary>
  /// Enum Recommendation for value: recommendation
  /// </summary>
  [JsonPropertyName("recommendation")]
  Recommendation = 11,

  /// <summary>
  /// Enum Search for value: search
  /// </summary>
  [JsonPropertyName("search")]
  Search = 12,

  /// <summary>
  /// Enum SeeUnretrievableAttributes for value: seeUnretrievableAttributes
  /// </summary>
  [JsonPropertyName("seeUnretrievableAttributes")]
  SeeUnretrievableAttributes = 13,

  /// <summary>
  /// Enum Settings for value: settings
  /// </summary>
  [JsonPropertyName("settings")]
  Settings = 14,

  /// <summary>
  /// Enum Usage for value: usage
  /// </summary>
  [JsonPropertyName("usage")]
  Usage = 15,
}

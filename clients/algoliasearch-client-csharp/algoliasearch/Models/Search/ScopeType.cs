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

namespace Algolia.Search.Models.Search;

/// <summary>
/// Defines scopeType
/// </summary>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<ScopeType>))]
public enum ScopeType
{
  /// <summary>
  /// Enum Settings for value: settings
  /// </summary>
  [JsonPropertyName("settings")]
  Settings = 1,

  /// <summary>
  /// Enum Synonyms for value: synonyms
  /// </summary>
  [JsonPropertyName("synonyms")]
  Synonyms = 2,

  /// <summary>
  /// Enum Rules for value: rules
  /// </summary>
  [JsonPropertyName("rules")]
  Rules = 3
}


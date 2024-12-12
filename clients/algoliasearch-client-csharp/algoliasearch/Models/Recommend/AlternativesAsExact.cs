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

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// Defines alternativesAsExact
/// </summary>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<AlternativesAsExact>))]
public enum AlternativesAsExact
{
  /// <summary>
  /// Enum IgnorePlurals for value: ignorePlurals
  /// </summary>
  [JsonPropertyName("ignorePlurals")]
  IgnorePlurals = 1,

  /// <summary>
  /// Enum SingleWordSynonym for value: singleWordSynonym
  /// </summary>
  [JsonPropertyName("singleWordSynonym")]
  SingleWordSynonym = 2,

  /// <summary>
  /// Enum MultiWordsSynonym for value: multiWordsSynonym
  /// </summary>
  [JsonPropertyName("multiWordsSynonym")]
  MultiWordsSynonym = 3,

  /// <summary>
  /// Enum IgnoreConjugations for value: ignoreConjugations
  /// </summary>
  [JsonPropertyName("ignoreConjugations")]
  IgnoreConjugations = 4
}


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
/// Which part of the search query the pattern should match:  - `startsWith`. The pattern must match the begginning of the query. - `endsWith`. The pattern must match the end of the query. - `is`. The pattern must match the query exactly. - `contains`. The pattern must match anywhere in the query.  Empty queries are only allowed as pattern with `anchoring: is`. 
/// </summary>
/// <value>Which part of the search query the pattern should match:  - `startsWith`. The pattern must match the begginning of the query. - `endsWith`. The pattern must match the end of the query. - `is`. The pattern must match the query exactly. - `contains`. The pattern must match anywhere in the query.  Empty queries are only allowed as pattern with `anchoring: is`. </value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<Anchoring>))]
public enum Anchoring
{
  /// <summary>
  /// Enum Is for value: is
  /// </summary>
  [JsonPropertyName("is")]
  Is = 1,

  /// <summary>
  /// Enum StartsWith for value: startsWith
  /// </summary>
  [JsonPropertyName("startsWith")]
  StartsWith = 2,

  /// <summary>
  /// Enum EndsWith for value: endsWith
  /// </summary>
  [JsonPropertyName("endsWith")]
  EndsWith = 3,

  /// <summary>
  /// Enum Contains for value: contains
  /// </summary>
  [JsonPropertyName("contains")]
  Contains = 4
}


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
/// Determines how query words are [interpreted as prefixes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).
/// </summary>
/// <value>Determines how query words are [interpreted as prefixes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).</value>
public enum QueryType
{
  /// <summary>
  /// Enum PrefixLast for value: prefixLast
  /// </summary>
  [JsonPropertyName("prefixLast")]
  PrefixLast = 1,

  /// <summary>
  /// Enum PrefixAll for value: prefixAll
  /// </summary>
  [JsonPropertyName("prefixAll")]
  PrefixAll = 2,

  /// <summary>
  /// Enum PrefixNone for value: prefixNone
  /// </summary>
  [JsonPropertyName("prefixNone")]
  PrefixNone = 3
}


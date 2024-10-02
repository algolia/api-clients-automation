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
/// Order of facet values that aren't explicitly positioned with the `order` setting.  - `count`.   Order remaining facet values by decreasing count.   The count is the number of matching records containing this facet value.  - `alpha`.   Sort facet values alphabetically.  - `hidden`.   Don't show facet values that aren't explicitly positioned. 
/// </summary>
/// <value>Order of facet values that aren't explicitly positioned with the `order` setting.  - `count`.   Order remaining facet values by decreasing count.   The count is the number of matching records containing this facet value.  - `alpha`.   Sort facet values alphabetically.  - `hidden`.   Don't show facet values that aren't explicitly positioned. </value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<SortRemainingBy>))]
public enum SortRemainingBy
{
  /// <summary>
  /// Enum Count for value: count
  /// </summary>
  [JsonPropertyName("count")]
  Count = 1,

  /// <summary>
  /// Enum Alpha for value: alpha
  /// </summary>
  [JsonPropertyName("alpha")]
  Alpha = 2,

  /// <summary>
  /// Enum Hidden for value: hidden
  /// </summary>
  [JsonPropertyName("hidden")]
  Hidden = 3
}


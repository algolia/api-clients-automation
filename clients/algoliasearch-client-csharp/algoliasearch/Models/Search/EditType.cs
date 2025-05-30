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
/// Type of edit.
/// </summary>
/// <value>Type of edit.</value>
[JsonConverter(typeof(Serializer.JsonStringEnumConverter<EditType>))]
public enum EditType
{
  /// <summary>
  /// Enum Remove for value: remove
  /// </summary>
  [JsonPropertyName("remove")]
  Remove = 1,

  /// <summary>
  /// Enum Replace for value: replace
  /// </summary>
  [JsonPropertyName("replace")]
  Replace = 2,
}

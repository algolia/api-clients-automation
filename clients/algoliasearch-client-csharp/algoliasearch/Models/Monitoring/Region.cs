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

namespace Algolia.Search.Models.Monitoring;

/// <summary>
/// Region where the cluster is located.
/// </summary>
/// <value>Region where the cluster is located.</value>
public enum Region
{
  /// <summary>
  /// Enum Au for value: au
  /// </summary>
  [JsonPropertyName("au")]
  Au = 1,

  /// <summary>
  /// Enum Br for value: br
  /// </summary>
  [JsonPropertyName("br")]
  Br = 2,

  /// <summary>
  /// Enum Ca for value: ca
  /// </summary>
  [JsonPropertyName("ca")]
  Ca = 3,

  /// <summary>
  /// Enum De for value: de
  /// </summary>
  [JsonPropertyName("de")]
  De = 4,

  /// <summary>
  /// Enum Eu for value: eu
  /// </summary>
  [JsonPropertyName("eu")]
  Eu = 5,

  /// <summary>
  /// Enum Hk for value: hk
  /// </summary>
  [JsonPropertyName("hk")]
  Hk = 6,

  /// <summary>
  /// Enum In for value: in
  /// </summary>
  [JsonPropertyName("in")]
  In = 7,

  /// <summary>
  /// Enum Jp for value: jp
  /// </summary>
  [JsonPropertyName("jp")]
  Jp = 8,

  /// <summary>
  /// Enum Sg for value: sg
  /// </summary>
  [JsonPropertyName("sg")]
  Sg = 9,

  /// <summary>
  /// Enum Uae for value: uae
  /// </summary>
  [JsonPropertyName("uae")]
  Uae = 10,

  /// <summary>
  /// Enum Uk for value: uk
  /// </summary>
  [JsonPropertyName("uk")]
  Uk = 11,

  /// <summary>
  /// Enum Usc for value: usc
  /// </summary>
  [JsonPropertyName("usc")]
  Usc = 12,

  /// <summary>
  /// Enum Use for value: use
  /// </summary>
  [JsonPropertyName("use")]
  Use = 13,

  /// <summary>
  /// Enum Usw for value: usw
  /// </summary>
  [JsonPropertyName("usw")]
  Usw = 14,

  /// <summary>
  /// Enum Za for value: za
  /// </summary>
  [JsonPropertyName("za")]
  Za = 15
}


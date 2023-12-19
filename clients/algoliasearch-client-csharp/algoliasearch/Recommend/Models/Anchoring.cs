//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// Whether the pattern parameter matches the beginning (&#x60;startsWith&#x60;) or end (&#x60;endsWith&#x60;) of the query string, is an exact match (&#x60;is&#x60;), or a partial match (&#x60;contains&#x60;).
  /// </summary>
  /// <value>Whether the pattern parameter matches the beginning (&#x60;startsWith&#x60;) or end (&#x60;endsWith&#x60;) of the query string, is an exact match (&#x60;is&#x60;), or a partial match (&#x60;contains&#x60;).</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum Anchoring
  {
    /// <summary>
    /// Enum Is for value: is
    /// </summary>
    [EnumMember(Value = "is")]
    Is = 1,

    /// <summary>
    /// Enum StartsWith for value: startsWith
    /// </summary>
    [EnumMember(Value = "startsWith")]
    StartsWith = 2,

    /// <summary>
    /// Enum EndsWith for value: endsWith
    /// </summary>
    [EnumMember(Value = "endsWith")]
    EndsWith = 3,

    /// <summary>
    /// Enum Contains for value: contains
    /// </summary>
    [EnumMember(Value = "contains")]
    Contains = 4
  }

}

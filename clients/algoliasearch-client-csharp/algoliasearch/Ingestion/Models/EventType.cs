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

namespace Algolia.Search.Models.Ingestion
{
  /// <summary>
  /// Defines EventType
  /// </summary>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum EventType
  {
    /// <summary>
    /// Enum Fetch for value: fetch
    /// </summary>
    [EnumMember(Value = "fetch")]
    Fetch = 1,

    /// <summary>
    /// Enum Record for value: record
    /// </summary>
    [EnumMember(Value = "record")]
    Record = 2,

    /// <summary>
    /// Enum Log for value: log
    /// </summary>
    [EnumMember(Value = "log")]
    Log = 3,

    /// <summary>
    /// Enum Transform for value: transform
    /// </summary>
    [EnumMember(Value = "transform")]
    Transform = 4
  }

}

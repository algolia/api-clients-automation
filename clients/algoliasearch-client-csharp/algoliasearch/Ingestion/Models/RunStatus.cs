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

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// Defines RunStatus
  /// </summary>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum RunStatus
  {
    /// <summary>
    /// Enum Created for value: created
    /// </summary>
    [EnumMember(Value = "created")]
    Created = 1,

    /// <summary>
    /// Enum Started for value: started
    /// </summary>
    [EnumMember(Value = "started")]
    Started = 2,

    /// <summary>
    /// Enum Idled for value: idled
    /// </summary>
    [EnumMember(Value = "idled")]
    Idled = 3,

    /// <summary>
    /// Enum Finished for value: finished
    /// </summary>
    [EnumMember(Value = "finished")]
    Finished = 4,

    /// <summary>
    /// Enum Skipped for value: skipped
    /// </summary>
    [EnumMember(Value = "skipped")]
    Skipped = 5
  }

}

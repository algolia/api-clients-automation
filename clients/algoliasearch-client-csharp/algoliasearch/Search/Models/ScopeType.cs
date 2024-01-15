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

namespace Algolia.Search.Models.Search
{
  /// <summary>
  /// Defines scopeType
  /// </summary>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum ScopeType
  {
    /// <summary>
    /// Enum Settings for value: settings
    /// </summary>
    [EnumMember(Value = "settings")]
    Settings = 1,

    /// <summary>
    /// Enum Synonyms for value: synonyms
    /// </summary>
    [EnumMember(Value = "synonyms")]
    Synonyms = 2,

    /// <summary>
    /// Enum Rules for value: rules
    /// </summary>
    [EnumMember(Value = "rules")]
    Rules = 3
  }

}

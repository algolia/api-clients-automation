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
  /// Determines how query words are [interpreted as prefixes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).
  /// </summary>
  /// <value>Determines how query words are [interpreted as prefixes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum QueryType
  {
    /// <summary>
    /// Enum PrefixLast for value: prefixLast
    /// </summary>
    [EnumMember(Value = "prefixLast")]
    PrefixLast = 1,

    /// <summary>
    /// Enum PrefixAll for value: prefixAll
    /// </summary>
    [EnumMember(Value = "prefixAll")]
    PrefixAll = 2,

    /// <summary>
    /// Enum PrefixNone for value: prefixNone
    /// </summary>
    [EnumMember(Value = "prefixNone")]
    PrefixNone = 3
  }

}

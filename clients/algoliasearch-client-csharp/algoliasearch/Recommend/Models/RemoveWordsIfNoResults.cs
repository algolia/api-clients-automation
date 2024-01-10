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

namespace Algolia.Search.Models.Recommend
{
  /// <summary>
  /// Strategy to [remove words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/) from the query when it doesn&#39;t match any hits.
  /// </summary>
  /// <value>Strategy to [remove words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/) from the query when it doesn&#39;t match any hits.</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum RemoveWordsIfNoResults
  {
    /// <summary>
    /// Enum None for value: none
    /// </summary>
    [EnumMember(Value = "none")]
    None = 1,

    /// <summary>
    /// Enum LastWords for value: lastWords
    /// </summary>
    [EnumMember(Value = "lastWords")]
    LastWords = 2,

    /// <summary>
    /// Enum FirstWords for value: firstWords
    /// </summary>
    [EnumMember(Value = "firstWords")]
    FirstWords = 3,

    /// <summary>
    /// Enum AllOptional for value: allOptional
    /// </summary>
    [EnumMember(Value = "allOptional")]
    AllOptional = 4
  }

}

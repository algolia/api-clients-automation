/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
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

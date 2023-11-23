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
  /// Defines dictionaryType
  /// </summary>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum DictionaryType
  {
    /// <summary>
    /// Enum Plurals for value: plurals
    /// </summary>
    [EnumMember(Value = "plurals")]
    Plurals = 1,

    /// <summary>
    /// Enum Stopwords for value: stopwords
    /// </summary>
    [EnumMember(Value = "stopwords")]
    Stopwords = 2,

    /// <summary>
    /// Enum Compounds for value: compounds
    /// </summary>
    [EnumMember(Value = "compounds")]
    Compounds = 3
  }

}

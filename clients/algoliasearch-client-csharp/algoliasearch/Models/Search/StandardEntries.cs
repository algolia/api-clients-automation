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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Key-value pairs of [supported language ISO codes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) and boolean values. 
/// </summary>
[DataContract(Name = "standardEntries")]
public partial class StandardEntries
{
  /// <summary>
  /// Initializes a new instance of the StandardEntries class.
  /// </summary>
  public StandardEntries()
  {
  }

  /// <summary>
  /// Key-value pair of a language ISO code and a boolean value.
  /// </summary>
  /// <value>Key-value pair of a language ISO code and a boolean value.</value>
  [DataMember(Name = "plurals")]
  public Dictionary<string, bool> Plurals { get; set; }

  /// <summary>
  /// Key-value pair of a language ISO code and a boolean value.
  /// </summary>
  /// <value>Key-value pair of a language ISO code and a boolean value.</value>
  [DataMember(Name = "stopwords")]
  public Dictionary<string, bool> Stopwords { get; set; }

  /// <summary>
  /// Key-value pair of a language ISO code and a boolean value.
  /// </summary>
  /// <value>Key-value pair of a language ISO code and a boolean value.</value>
  [DataMember(Name = "compounds")]
  public Dictionary<string, bool> Compounds { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class StandardEntries {\n");
    sb.Append("  Plurals: ").Append(Plurals).Append("\n");
    sb.Append("  Stopwords: ").Append(Stopwords).Append("\n");
    sb.Append("  Compounds: ").Append(Compounds).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}


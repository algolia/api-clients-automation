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
/// Dictionary language.
/// </summary>
[DataContract(Name = "languages")]
[JsonObject(MemberSerialization.OptOut)]
public partial class Languages
{
  /// <summary>
  /// Initializes a new instance of the Languages class.
  /// </summary>
  [JsonConstructor]
  public Languages() { }
  /// <summary>
  /// Initializes a new instance of the Languages class.
  /// </summary>
  /// <param name="plurals">plurals (required).</param>
  /// <param name="stopwords">stopwords (required).</param>
  /// <param name="compounds">compounds (required).</param>
  public Languages(DictionaryLanguage plurals, DictionaryLanguage stopwords, DictionaryLanguage compounds)
  {
    Plurals = plurals ?? throw new ArgumentNullException(nameof(plurals));
    Stopwords = stopwords ?? throw new ArgumentNullException(nameof(stopwords));
    Compounds = compounds ?? throw new ArgumentNullException(nameof(compounds));
  }

  /// <summary>
  /// Gets or Sets Plurals
  /// </summary>
  [DataMember(Name = "plurals")]
  public DictionaryLanguage Plurals { get; set; }

  /// <summary>
  /// Gets or Sets Stopwords
  /// </summary>
  [DataMember(Name = "stopwords")]
  public DictionaryLanguage Stopwords { get; set; }

  /// <summary>
  /// Gets or Sets Compounds
  /// </summary>
  [DataMember(Name = "compounds")]
  public DictionaryLanguage Compounds { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Languages {\n");
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


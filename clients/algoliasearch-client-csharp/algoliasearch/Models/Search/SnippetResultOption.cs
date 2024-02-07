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
/// Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
/// </summary>
[DataContract(Name = "snippetResultOption")]
[JsonObject(MemberSerialization.OptOut)]
public partial class SnippetResultOption
{

  /// <summary>
  /// Gets or Sets MatchLevel
  /// </summary>
  [DataMember(Name = "matchLevel")]
  public MatchLevel MatchLevel { get; set; }
  /// <summary>
  /// Initializes a new instance of the SnippetResultOption class.
  /// </summary>
  [JsonConstructor]
  public SnippetResultOption() { }
  /// <summary>
  /// Initializes a new instance of the SnippetResultOption class.
  /// </summary>
  /// <param name="value">Markup text with &#x60;facetQuery&#x60; matches highlighted. (required).</param>
  /// <param name="matchLevel">matchLevel (required).</param>
  public SnippetResultOption(string value, MatchLevel matchLevel)
  {
    Value = value ?? throw new ArgumentNullException(nameof(value));
    MatchLevel = matchLevel;
  }

  /// <summary>
  /// Markup text with `facetQuery` matches highlighted.
  /// </summary>
  /// <value>Markup text with `facetQuery` matches highlighted.</value>
  [DataMember(Name = "value")]
  public string Value { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SnippetResultOption {\n");
    sb.Append("  Value: ").Append(Value).Append("\n");
    sb.Append("  MatchLevel: ").Append(MatchLevel).Append("\n");
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


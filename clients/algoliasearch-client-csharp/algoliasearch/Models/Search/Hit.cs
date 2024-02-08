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
/// A single hit.
/// </summary>
[DataContract(Name = "hit")]
public partial class Hit
{
  /// <summary>
  /// Initializes a new instance of the Hit class.
  /// </summary>
  [JsonConstructor]
  public Hit()
  {
    AdditionalProperties = new Dictionary<string, object>();
  }
  /// <summary>
  /// Initializes a new instance of the Hit class.
  /// </summary>
  /// <param name="objectID">Unique object identifier. (required).</param>
  public Hit(string objectID)
  {
    ObjectID = objectID ?? throw new ArgumentNullException(nameof(objectID));
    AdditionalProperties = new Dictionary<string, object>();
  }

  /// <summary>
  /// Unique object identifier.
  /// </summary>
  /// <value>Unique object identifier.</value>
  [DataMember(Name = "objectID")]
  public string ObjectID { get; set; }

  /// <summary>
  /// Show highlighted section and words matched on a query.
  /// </summary>
  /// <value>Show highlighted section and words matched on a query.</value>
  [DataMember(Name = "_highlightResult")]
  public Dictionary<string, HighlightResult> HighlightResult { get; set; }

  /// <summary>
  /// Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
  /// </summary>
  /// <value>Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.</value>
  [DataMember(Name = "_snippetResult")]
  public Dictionary<string, SnippetResult> SnippetResult { get; set; }

  /// <summary>
  /// Gets or Sets RankingInfo
  /// </summary>
  [DataMember(Name = "_rankingInfo")]
  public RankingInfo RankingInfo { get; set; }

  /// <summary>
  /// Gets or Sets DistinctSeqID
  /// </summary>
  [DataMember(Name = "_distinctSeqID")]
  public int? DistinctSeqID { get; set; }

  /// <summary>
  /// Gets or Sets additional properties
  /// </summary>
  [JsonExtensionData]
  public IDictionary<string, object> AdditionalProperties { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Hit {\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
    sb.Append("  HighlightResult: ").Append(HighlightResult).Append("\n");
    sb.Append("  SnippetResult: ").Append(SnippetResult).Append("\n");
    sb.Append("  RankingInfo: ").Append(RankingInfo).Append("\n");
    sb.Append("  DistinctSeqID: ").Append(DistinctSeqID).Append("\n");
    sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
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


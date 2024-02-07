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

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// RecommendationsHits
/// </summary>
[DataContract(Name = "recommendationsHits")]
[JsonObject(MemberSerialization.OptOut)]
public partial class RecommendationsHits
{
  /// <summary>
  /// Initializes a new instance of the RecommendationsHits class.
  /// </summary>
  [JsonConstructor]
  public RecommendationsHits() { }
  /// <summary>
  /// Initializes a new instance of the RecommendationsHits class.
  /// </summary>
  /// <param name="hits">hits (required).</param>
  public RecommendationsHits(List<RecommendationsHit> hits)
  {
    Hits = hits ?? throw new ArgumentNullException(nameof(hits));
  }

  /// <summary>
  /// Gets or Sets Hits
  /// </summary>
  [DataMember(Name = "hits")]
  public List<RecommendationsHit> Hits { get; set; }

  /// <summary>
  /// Text to search for in an index.
  /// </summary>
  /// <value>Text to search for in an index.</value>
  [DataMember(Name = "query")]
  public string Query { get; set; }

  /// <summary>
  /// URL-encoded string of all search parameters.
  /// </summary>
  /// <value>URL-encoded string of all search parameters.</value>
  [DataMember(Name = "params")]
  public string VarParams { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RecommendationsHits {\n");
    sb.Append("  Hits: ").Append(Hits).Append("\n");
    sb.Append("  Query: ").Append(Query).Append("\n");
    sb.Append("  VarParams: ").Append(VarParams).Append("\n");
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


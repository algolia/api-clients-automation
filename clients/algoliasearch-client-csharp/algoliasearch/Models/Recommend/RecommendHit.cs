//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// Recommend hit.
/// </summary>
public partial class RecommendHit
{
  /// <summary>
  /// Initializes a new instance of the RecommendHit class.
  /// </summary>
  [JsonConstructor]
  public RecommendHit()
  {
    AdditionalProperties = new Dictionary<string, object>();
  }

  /// <summary>
  /// Initializes a new instance of the RecommendHit class.
  /// </summary>
  /// <param name="objectID">Unique record identifier. (required).</param>
  public RecommendHit(string objectID)
  {
    ObjectID = objectID ?? throw new ArgumentNullException(nameof(objectID));
    AdditionalProperties = new Dictionary<string, object>();
  }

  /// <summary>
  /// Unique record identifier.
  /// </summary>
  /// <value>Unique record identifier.</value>
  [JsonPropertyName("objectID")]
  public string ObjectID { get; set; }

  /// <summary>
  /// Surround words that match the query with HTML tags for highlighting.
  /// </summary>
  /// <value>Surround words that match the query with HTML tags for highlighting.</value>
  [JsonPropertyName("_highlightResult")]
  public Dictionary<string, HighlightResult> HighlightResult { get; set; }

  /// <summary>
  /// Snippets that show the context around a matching search query.
  /// </summary>
  /// <value>Snippets that show the context around a matching search query.</value>
  [JsonPropertyName("_snippetResult")]
  public Dictionary<string, SnippetResult> SnippetResult { get; set; }

  /// <summary>
  /// Gets or Sets RankingInfo
  /// </summary>
  [JsonPropertyName("_rankingInfo")]
  public RankingInfo RankingInfo { get; set; }

  /// <summary>
  /// Gets or Sets DistinctSeqID
  /// </summary>
  [JsonPropertyName("_distinctSeqID")]
  public int? DistinctSeqID { get; set; }

  /// <summary>
  /// Recommendation score.
  /// </summary>
  /// <value>Recommendation score.</value>
  [JsonPropertyName("_score")]
  public double? Score { get; set; }

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
    sb.Append("class RecommendHit {\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
    sb.Append("  HighlightResult: ").Append(HighlightResult).Append("\n");
    sb.Append("  SnippetResult: ").Append(SnippetResult).Append("\n");
    sb.Append("  RankingInfo: ").Append(RankingInfo).Append("\n");
    sb.Append("  DistinctSeqID: ").Append(DistinctSeqID).Append("\n");
    sb.Append("  Score: ").Append(Score).Append("\n");
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
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not RecommendHit input)
    {
      return false;
    }

    return (ObjectID == input.ObjectID || (ObjectID != null && ObjectID.Equals(input.ObjectID)))
      && (
        HighlightResult == input.HighlightResult
        || HighlightResult != null
          && input.HighlightResult != null
          && HighlightResult.SequenceEqual(input.HighlightResult)
      )
      && (
        SnippetResult == input.SnippetResult
        || SnippetResult != null
          && input.SnippetResult != null
          && SnippetResult.SequenceEqual(input.SnippetResult)
      )
      && (
        RankingInfo == input.RankingInfo
        || (RankingInfo != null && RankingInfo.Equals(input.RankingInfo))
      )
      && (DistinctSeqID == input.DistinctSeqID || DistinctSeqID.Equals(input.DistinctSeqID))
      && (Score == input.Score || Score.Equals(input.Score))
      && (
        AdditionalProperties.Count == input.AdditionalProperties.Count
        && !AdditionalProperties.Except(input.AdditionalProperties).Any()
      );
  }

  /// <summary>
  /// Gets the hash code
  /// </summary>
  /// <returns>Hash code</returns>
  public override int GetHashCode()
  {
    unchecked // Overflow is fine, just wrap
    {
      int hashCode = 41;
      if (ObjectID != null)
      {
        hashCode = (hashCode * 59) + ObjectID.GetHashCode();
      }
      if (HighlightResult != null)
      {
        hashCode = (hashCode * 59) + HighlightResult.GetHashCode();
      }
      if (SnippetResult != null)
      {
        hashCode = (hashCode * 59) + SnippetResult.GetHashCode();
      }
      if (RankingInfo != null)
      {
        hashCode = (hashCode * 59) + RankingInfo.GetHashCode();
      }
      hashCode = (hashCode * 59) + DistinctSeqID.GetHashCode();
      hashCode = (hashCode * 59) + Score.GetHashCode();
      if (AdditionalProperties != null)
      {
        hashCode = (hashCode * 59) + AdditionalProperties.GetHashCode();
      }
      return hashCode;
    }
  }
}

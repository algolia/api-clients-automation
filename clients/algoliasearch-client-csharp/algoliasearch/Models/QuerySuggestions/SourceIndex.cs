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

namespace Algolia.Search.Models.QuerySuggestions;

/// <summary>
/// Configuration of an Algolia index for Query Suggestions.
/// </summary>
public partial class SourceIndex
{
  /// <summary>
  /// Initializes a new instance of the SourceIndex class.
  /// </summary>
  [JsonConstructor]
  public SourceIndex() { }

  /// <summary>
  /// Initializes a new instance of the SourceIndex class.
  /// </summary>
  /// <param name="indexName">Name of the Algolia index (case-sensitive) to use as source for query suggestions. (required).</param>
  public SourceIndex(string indexName)
  {
    IndexName = indexName ?? throw new ArgumentNullException(nameof(indexName));
  }

  /// <summary>
  /// Name of the Algolia index (case-sensitive) to use as source for query suggestions.
  /// </summary>
  /// <value>Name of the Algolia index (case-sensitive) to use as source for query suggestions.</value>
  [JsonPropertyName("indexName")]
  public string IndexName { get; set; }

  /// <summary>
  /// If true, Query Suggestions uses all replica indices to find popular searches. If false, only the primary index is used.
  /// </summary>
  /// <value>If true, Query Suggestions uses all replica indices to find popular searches. If false, only the primary index is used. </value>
  [JsonPropertyName("replicas")]
  public bool? Replicas { get; set; }

  /// <summary>
  /// Gets or Sets AnalyticsTags
  /// </summary>
  [JsonPropertyName("analyticsTags")]
  public List<string> AnalyticsTags { get; set; }

  /// <summary>
  /// Gets or Sets Facets
  /// </summary>
  [JsonPropertyName("facets")]
  public List<Facet> Facets { get; set; }

  /// <summary>
  /// Minimum number of hits required to be included as a suggestion.  A search query must at least generate `minHits` search results to be included in the Query Suggestions index.
  /// </summary>
  /// <value>Minimum number of hits required to be included as a suggestion.  A search query must at least generate `minHits` search results to be included in the Query Suggestions index. </value>
  [JsonPropertyName("minHits")]
  public int? MinHits { get; set; }

  /// <summary>
  /// Minimum letters required to be included as a suggestion.  A search query must be at least `minLetters` long to be included in the Query Suggestions index.
  /// </summary>
  /// <value>Minimum letters required to be included as a suggestion.  A search query must be at least `minLetters` long to be included in the Query Suggestions index. </value>
  [JsonPropertyName("minLetters")]
  public int? MinLetters { get; set; }

  /// <summary>
  /// Gets or Sets Generate
  /// </summary>
  [JsonPropertyName("generate")]
  public List<List<string>> Generate { get; set; }

  /// <summary>
  /// Gets or Sets External
  /// </summary>
  [JsonPropertyName("external")]
  public List<string> External { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SourceIndex {\n");
    sb.Append("  IndexName: ").Append(IndexName).Append("\n");
    sb.Append("  Replicas: ").Append(Replicas).Append("\n");
    sb.Append("  AnalyticsTags: ").Append(AnalyticsTags).Append("\n");
    sb.Append("  Facets: ").Append(Facets).Append("\n");
    sb.Append("  MinHits: ").Append(MinHits).Append("\n");
    sb.Append("  MinLetters: ").Append(MinLetters).Append("\n");
    sb.Append("  Generate: ").Append(Generate).Append("\n");
    sb.Append("  External: ").Append(External).Append("\n");
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
    if (obj is not SourceIndex input)
    {
      return false;
    }

    return (
        IndexName == input.IndexName || (IndexName != null && IndexName.Equals(input.IndexName))
      )
      && (Replicas == input.Replicas || Replicas.Equals(input.Replicas))
      && (
        AnalyticsTags == input.AnalyticsTags
        || AnalyticsTags != null
          && input.AnalyticsTags != null
          && AnalyticsTags.SequenceEqual(input.AnalyticsTags)
      )
      && (
        Facets == input.Facets
        || Facets != null && input.Facets != null && Facets.SequenceEqual(input.Facets)
      )
      && (MinHits == input.MinHits || MinHits.Equals(input.MinHits))
      && (MinLetters == input.MinLetters || MinLetters.Equals(input.MinLetters))
      && (
        Generate == input.Generate
        || Generate != null && input.Generate != null && Generate.SequenceEqual(input.Generate)
      )
      && (
        External == input.External
        || External != null && input.External != null && External.SequenceEqual(input.External)
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
      if (IndexName != null)
      {
        hashCode = (hashCode * 59) + IndexName.GetHashCode();
      }
      hashCode = (hashCode * 59) + Replicas.GetHashCode();
      if (AnalyticsTags != null)
      {
        hashCode = (hashCode * 59) + AnalyticsTags.GetHashCode();
      }
      if (Facets != null)
      {
        hashCode = (hashCode * 59) + Facets.GetHashCode();
      }
      hashCode = (hashCode * 59) + MinHits.GetHashCode();
      hashCode = (hashCode * 59) + MinLetters.GetHashCode();
      if (Generate != null)
      {
        hashCode = (hashCode * 59) + Generate.GetHashCode();
      }
      if (External != null)
      {
        hashCode = (hashCode * 59) + External.GetHashCode();
      }
      return hashCode;
    }
  }
}

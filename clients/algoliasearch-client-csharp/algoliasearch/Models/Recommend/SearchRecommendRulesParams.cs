//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// Recommend rules parameters.
/// </summary>
public partial class SearchRecommendRulesParams
{
  /// <summary>
  /// Initializes a new instance of the SearchRecommendRulesParams class.
  /// </summary>
  public SearchRecommendRulesParams()
  {
  }

  /// <summary>
  /// Search query.
  /// </summary>
  /// <value>Search query.</value>
  [JsonPropertyName("query")]
  public string Query { get; set; }

  /// <summary>
  /// Only search for rules with matching context.
  /// </summary>
  /// <value>Only search for rules with matching context.</value>
  [JsonPropertyName("context")]
  public string Context { get; set; }

  /// <summary>
  /// Requested page of the API response.
  /// </summary>
  /// <value>Requested page of the API response.</value>
  [JsonPropertyName("page")]
  public int? Page { get; set; }

  /// <summary>
  /// Maximum number of hits per page.
  /// </summary>
  /// <value>Maximum number of hits per page.</value>
  [JsonPropertyName("hitsPerPage")]
  public int? HitsPerPage { get; set; }

  /// <summary>
  /// Whether to only show rules where the value of their `enabled` property matches this parameter. If absent, show all rules, regardless of their `enabled` property. 
  /// </summary>
  /// <value>Whether to only show rules where the value of their `enabled` property matches this parameter. If absent, show all rules, regardless of their `enabled` property. </value>
  [JsonPropertyName("enabled")]
  public bool? Enabled { get; set; }

  /// <summary>
  /// Filter expression. This only searches for rules matching the filter expression.
  /// </summary>
  /// <value>Filter expression. This only searches for rules matching the filter expression.</value>
  [JsonPropertyName("filters")]
  public string Filters { get; set; }

  /// <summary>
  /// Include facets and facet values in the response. Use `['*']` to include all facets.
  /// </summary>
  /// <value>Include facets and facet values in the response. Use `['*']` to include all facets.</value>
  [JsonPropertyName("facets")]
  public List<string> Facets { get; set; }

  /// <summary>
  /// Maximum number of values to return for each facet.
  /// </summary>
  /// <value>Maximum number of values to return for each facet.</value>
  [JsonPropertyName("maxValuesPerFacet")]
  public int? MaxValuesPerFacet { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SearchRecommendRulesParams {\n");
    sb.Append("  Query: ").Append(Query).Append("\n");
    sb.Append("  Context: ").Append(Context).Append("\n");
    sb.Append("  Page: ").Append(Page).Append("\n");
    sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
    sb.Append("  Enabled: ").Append(Enabled).Append("\n");
    sb.Append("  Filters: ").Append(Filters).Append("\n");
    sb.Append("  Facets: ").Append(Facets).Append("\n");
    sb.Append("  MaxValuesPerFacet: ").Append(MaxValuesPerFacet).Append("\n");
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
    if (obj is not SearchRecommendRulesParams input)
    {
      return false;
    }

    return
        (Query == input.Query || (Query != null && Query.Equals(input.Query))) &&
        (Context == input.Context || (Context != null && Context.Equals(input.Context))) &&
        (Page == input.Page || Page.Equals(input.Page)) &&
        (HitsPerPage == input.HitsPerPage || HitsPerPage.Equals(input.HitsPerPage)) &&
        (Enabled == input.Enabled || Enabled.Equals(input.Enabled)) &&
        (Filters == input.Filters || (Filters != null && Filters.Equals(input.Filters))) &&
        (Facets == input.Facets || Facets != null && input.Facets != null && Facets.SequenceEqual(input.Facets)) &&
        (MaxValuesPerFacet == input.MaxValuesPerFacet || MaxValuesPerFacet.Equals(input.MaxValuesPerFacet));
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
      if (Query != null)
      {
        hashCode = (hashCode * 59) + Query.GetHashCode();
      }
      if (Context != null)
      {
        hashCode = (hashCode * 59) + Context.GetHashCode();
      }
      hashCode = (hashCode * 59) + Page.GetHashCode();
      hashCode = (hashCode * 59) + HitsPerPage.GetHashCode();
      hashCode = (hashCode * 59) + Enabled.GetHashCode();
      if (Filters != null)
      {
        hashCode = (hashCode * 59) + Filters.GetHashCode();
      }
      if (Facets != null)
      {
        hashCode = (hashCode * 59) + Facets.GetHashCode();
      }
      hashCode = (hashCode * 59) + MaxValuesPerFacet.GetHashCode();
      return hashCode;
    }
  }

}


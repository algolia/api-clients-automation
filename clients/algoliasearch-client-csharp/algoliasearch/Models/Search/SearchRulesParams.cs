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

namespace Algolia.Search.Models.Search;

/// <summary>
/// Rules search parameters.
/// </summary>
public partial class SearchRulesParams
{

  /// <summary>
  /// Gets or Sets Anchoring
  /// </summary>
  [JsonPropertyName("anchoring")]
  public Anchoring? Anchoring { get; set; }
  /// <summary>
  /// Initializes a new instance of the SearchRulesParams class.
  /// </summary>
  public SearchRulesParams()
  {
  }

  /// <summary>
  /// Search query for rules.
  /// </summary>
  /// <value>Search query for rules.</value>
  [JsonPropertyName("query")]
  public string Query { get; set; }

  /// <summary>
  /// Only return rules that match the context (exact match).
  /// </summary>
  /// <value>Only return rules that match the context (exact match).</value>
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
  /// If `true`, return only enabled rules. If `false`, return only inactive rules. By default, _all_ rules are returned. 
  /// </summary>
  /// <value>If `true`, return only enabled rules. If `false`, return only inactive rules. By default, _all_ rules are returned. </value>
  [JsonPropertyName("enabled")]
  public bool? Enabled { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SearchRulesParams {\n");
    sb.Append("  Query: ").Append(Query).Append("\n");
    sb.Append("  Anchoring: ").Append(Anchoring).Append("\n");
    sb.Append("  Context: ").Append(Context).Append("\n");
    sb.Append("  Page: ").Append(Page).Append("\n");
    sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
    sb.Append("  Enabled: ").Append(Enabled).Append("\n");
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
    if (obj is not SearchRulesParams input)
    {
      return false;
    }

    return
        (Query == input.Query || (Query != null && Query.Equals(input.Query))) &&
        (Anchoring == input.Anchoring || Anchoring.Equals(input.Anchoring)) &&
        (Context == input.Context || (Context != null && Context.Equals(input.Context))) &&
        (Page == input.Page || Page.Equals(input.Page)) &&
        (HitsPerPage == input.HitsPerPage || HitsPerPage.Equals(input.HitsPerPage)) &&
        (Enabled == input.Enabled || (Enabled != null && Enabled.Equals(input.Enabled)));
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
      hashCode = (hashCode * 59) + Anchoring.GetHashCode();
      if (Context != null)
      {
        hashCode = (hashCode * 59) + Context.GetHashCode();
      }
      hashCode = (hashCode * 59) + Page.GetHashCode();
      hashCode = (hashCode * 59) + HitsPerPage.GetHashCode();
      if (Enabled != null)
      {
        hashCode = (hashCode * 59) + Enabled.GetHashCode();
      }
      return hashCode;
    }
  }

}


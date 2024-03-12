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
/// Condition
/// </summary>
public partial class Condition
{

  /// <summary>
  /// Gets or Sets Anchoring
  /// </summary>
  [JsonPropertyName("anchoring")]
  public Anchoring? Anchoring { get; set; }
  /// <summary>
  /// Initializes a new instance of the Condition class.
  /// </summary>
  public Condition()
  {
  }

  /// <summary>
  /// Query pattern that triggers the rule.  You can use either a literal string, or a special pattern `{facet:ATTRIBUTE}`, where `ATTRIBUTE` is a facet name. The rule is triggered if the query matches the literal string or a value of the specified facet. For example, with `pattern: {facet:genre}`, the rule is triggered when users search for a genre, such as \"comedy\". 
  /// </summary>
  /// <value>Query pattern that triggers the rule.  You can use either a literal string, or a special pattern `{facet:ATTRIBUTE}`, where `ATTRIBUTE` is a facet name. The rule is triggered if the query matches the literal string or a value of the specified facet. For example, with `pattern: {facet:genre}`, the rule is triggered when users search for a genre, such as \"comedy\". </value>
  [JsonPropertyName("pattern")]
  public string Pattern { get; set; }

  /// <summary>
  /// Whether the pattern should match plurals, synonyms, and typos.
  /// </summary>
  /// <value>Whether the pattern should match plurals, synonyms, and typos.</value>
  [JsonPropertyName("alternatives")]
  public bool? Alternatives { get; set; }

  /// <summary>
  /// An additional restriction that only triggers the rule, when the search has the same value as `ruleContexts` parameter. For example, if `context: mobile`, the rule is only triggered when the search request has a matching `ruleContexts: mobile`. A rule context must only contain alphanumeric characters. 
  /// </summary>
  /// <value>An additional restriction that only triggers the rule, when the search has the same value as `ruleContexts` parameter. For example, if `context: mobile`, the rule is only triggered when the search request has a matching `ruleContexts: mobile`. A rule context must only contain alphanumeric characters. </value>
  [JsonPropertyName("context")]
  public string Context { get; set; }

  /// <summary>
  /// Filters that trigger the rule.  You can add add filters using the syntax `facet:value` so that the rule is triggered, when the specific filter is selected. You can use `filters` on its own or combine it with the `pattern` parameter. 
  /// </summary>
  /// <value>Filters that trigger the rule.  You can add add filters using the syntax `facet:value` so that the rule is triggered, when the specific filter is selected. You can use `filters` on its own or combine it with the `pattern` parameter. </value>
  [JsonPropertyName("filters")]
  public string Filters { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Condition {\n");
    sb.Append("  Pattern: ").Append(Pattern).Append("\n");
    sb.Append("  Anchoring: ").Append(Anchoring).Append("\n");
    sb.Append("  Alternatives: ").Append(Alternatives).Append("\n");
    sb.Append("  Context: ").Append(Context).Append("\n");
    sb.Append("  Filters: ").Append(Filters).Append("\n");
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
    if (obj is not Condition input)
    {
      return false;
    }

    return
        (Pattern == input.Pattern || (Pattern != null && Pattern.Equals(input.Pattern))) &&
        (Anchoring == input.Anchoring || Anchoring.Equals(input.Anchoring)) &&
        (Alternatives == input.Alternatives || Alternatives.Equals(input.Alternatives)) &&
        (Context == input.Context || (Context != null && Context.Equals(input.Context))) &&
        (Filters == input.Filters || (Filters != null && Filters.Equals(input.Filters)));
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
      if (Pattern != null)
      {
        hashCode = (hashCode * 59) + Pattern.GetHashCode();
      }
      hashCode = (hashCode * 59) + Anchoring.GetHashCode();
      hashCode = (hashCode * 59) + Alternatives.GetHashCode();
      if (Context != null)
      {
        hashCode = (hashCode * 59) + Context.GetHashCode();
      }
      if (Filters != null)
      {
        hashCode = (hashCode * 59) + Filters.GetHashCode();
      }
      return hashCode;
    }
  }

}


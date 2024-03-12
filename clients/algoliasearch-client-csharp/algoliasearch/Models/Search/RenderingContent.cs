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
/// Extra data that can be used in the search UI.  You can use this to control aspects of your search UI, such as, the order of facet names and values without changing your frontend code. 
/// </summary>
public partial class RenderingContent
{
  /// <summary>
  /// Initializes a new instance of the RenderingContent class.
  /// </summary>
  public RenderingContent()
  {
  }

  /// <summary>
  /// Gets or Sets FacetOrdering
  /// </summary>
  [JsonPropertyName("facetOrdering")]
  public FacetOrdering FacetOrdering { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RenderingContent {\n");
    sb.Append("  FacetOrdering: ").Append(FacetOrdering).Append("\n");
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
    if (obj is not RenderingContent input)
    {
      return false;
    }

    return
        (FacetOrdering == input.FacetOrdering || (FacetOrdering != null && FacetOrdering.Equals(input.FacetOrdering)));
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
      if (FacetOrdering != null)
      {
        hashCode = (hashCode * 59) + FacetOrdering.GetHashCode();
      }
      return hashCode;
    }
  }

}


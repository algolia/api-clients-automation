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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// Configuration for handling empty searches.
/// </summary>
public partial class EmptySearch
{
  /// <summary>
  /// Initializes a new instance of the EmptySearch class.
  /// </summary>
  public EmptySearch()
  {
  }

  /// <summary>
  /// Whether to exclude empty searches when calculating A/B test results.
  /// </summary>
  /// <value>Whether to exclude empty searches when calculating A/B test results.</value>
  [JsonPropertyName("exclude")]
  public bool? Exclude { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class EmptySearch {\n");
    sb.Append("  Exclude: ").Append(Exclude).Append("\n");
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
    if (obj is not EmptySearch input)
    {
      return false;
    }

    return
        (Exclude == input.Exclude || Exclude.Equals(input.Exclude));
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
      hashCode = (hashCode * 59) + Exclude.GetHashCode();
      return hashCode;
    }
  }

}


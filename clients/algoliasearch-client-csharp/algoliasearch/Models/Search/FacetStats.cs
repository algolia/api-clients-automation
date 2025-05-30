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

namespace Algolia.Search.Models.Search;

/// <summary>
/// FacetStats
/// </summary>
public partial class FacetStats
{
  /// <summary>
  /// Initializes a new instance of the FacetStats class.
  /// </summary>
  public FacetStats() { }

  /// <summary>
  /// Minimum value in the results.
  /// </summary>
  /// <value>Minimum value in the results.</value>
  [JsonPropertyName("min")]
  public double? Min { get; set; }

  /// <summary>
  /// Maximum value in the results.
  /// </summary>
  /// <value>Maximum value in the results.</value>
  [JsonPropertyName("max")]
  public double? Max { get; set; }

  /// <summary>
  /// Average facet value in the results.
  /// </summary>
  /// <value>Average facet value in the results.</value>
  [JsonPropertyName("avg")]
  public double? Avg { get; set; }

  /// <summary>
  /// Sum of all values in the results.
  /// </summary>
  /// <value>Sum of all values in the results.</value>
  [JsonPropertyName("sum")]
  public double? Sum { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class FacetStats {\n");
    sb.Append("  Min: ").Append(Min).Append("\n");
    sb.Append("  Max: ").Append(Max).Append("\n");
    sb.Append("  Avg: ").Append(Avg).Append("\n");
    sb.Append("  Sum: ").Append(Sum).Append("\n");
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
    if (obj is not FacetStats input)
    {
      return false;
    }

    return (Min == input.Min || Min.Equals(input.Min))
      && (Max == input.Max || Max.Equals(input.Max))
      && (Avg == input.Avg || Avg.Equals(input.Avg))
      && (Sum == input.Sum || Sum.Equals(input.Sum));
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
      hashCode = (hashCode * 59) + Min.GetHashCode();
      hashCode = (hashCode * 59) + Max.GetHashCode();
      hashCode = (hashCode * 59) + Avg.GetHashCode();
      hashCode = (hashCode * 59) + Sum.GetHashCode();
      return hashCode;
    }
  }
}

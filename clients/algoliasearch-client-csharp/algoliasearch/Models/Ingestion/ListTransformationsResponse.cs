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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Configured transformations and pagination information.
/// </summary>
public partial class ListTransformationsResponse
{
  /// <summary>
  /// Initializes a new instance of the ListTransformationsResponse class.
  /// </summary>
  [JsonConstructor]
  public ListTransformationsResponse() { }

  /// <summary>
  /// Initializes a new instance of the ListTransformationsResponse class.
  /// </summary>
  /// <param name="transformations">transformations (required).</param>
  /// <param name="pagination">pagination (required).</param>
  public ListTransformationsResponse(List<Transformation> transformations, Pagination pagination)
  {
    Transformations = transformations ?? throw new ArgumentNullException(nameof(transformations));
    Pagination = pagination ?? throw new ArgumentNullException(nameof(pagination));
  }

  /// <summary>
  /// Gets or Sets Transformations
  /// </summary>
  [JsonPropertyName("transformations")]
  public List<Transformation> Transformations { get; set; }

  /// <summary>
  /// Gets or Sets Pagination
  /// </summary>
  [JsonPropertyName("pagination")]
  public Pagination Pagination { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ListTransformationsResponse {\n");
    sb.Append("  Transformations: ").Append(Transformations).Append("\n");
    sb.Append("  Pagination: ").Append(Pagination).Append("\n");
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
    if (obj is not ListTransformationsResponse input)
    {
      return false;
    }

    return (
        Transformations == input.Transformations
        || Transformations != null
          && input.Transformations != null
          && Transformations.SequenceEqual(input.Transformations)
      )
      && (
        Pagination == input.Pagination
        || (Pagination != null && Pagination.Equals(input.Pagination))
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
      if (Transformations != null)
      {
        hashCode = (hashCode * 59) + Transformations.GetHashCode();
      }
      if (Pagination != null)
      {
        hashCode = (hashCode * 59) + Pagination.GetHashCode();
      }
      return hashCode;
    }
  }
}

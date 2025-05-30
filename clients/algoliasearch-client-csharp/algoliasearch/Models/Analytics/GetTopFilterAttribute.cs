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

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// GetTopFilterAttribute
/// </summary>
public partial class GetTopFilterAttribute
{
  /// <summary>
  /// Initializes a new instance of the GetTopFilterAttribute class.
  /// </summary>
  [JsonConstructor]
  public GetTopFilterAttribute() { }

  /// <summary>
  /// Initializes a new instance of the GetTopFilterAttribute class.
  /// </summary>
  /// <param name="attribute">Attribute name. (required).</param>
  /// <param name="count">Number of occurrences. (required).</param>
  public GetTopFilterAttribute(string attribute, int count)
  {
    Attribute = attribute ?? throw new ArgumentNullException(nameof(attribute));
    Count = count;
  }

  /// <summary>
  /// Attribute name.
  /// </summary>
  /// <value>Attribute name.</value>
  [JsonPropertyName("attribute")]
  public string Attribute { get; set; }

  /// <summary>
  /// Number of occurrences.
  /// </summary>
  /// <value>Number of occurrences.</value>
  [JsonPropertyName("count")]
  public int Count { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetTopFilterAttribute {\n");
    sb.Append("  Attribute: ").Append(Attribute).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
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
    if (obj is not GetTopFilterAttribute input)
    {
      return false;
    }

    return (
        Attribute == input.Attribute || (Attribute != null && Attribute.Equals(input.Attribute))
      ) && (Count == input.Count || Count.Equals(input.Count));
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
      if (Attribute != null)
      {
        hashCode = (hashCode * 59) + Attribute.GetHashCode();
      }
      hashCode = (hashCode * 59) + Count.GetHashCode();
      return hashCode;
    }
  }
}

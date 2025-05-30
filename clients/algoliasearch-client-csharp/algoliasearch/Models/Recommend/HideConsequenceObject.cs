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
/// Object ID of the recommendation you want to exclude.
/// </summary>
public partial class HideConsequenceObject
{
  /// <summary>
  /// Initializes a new instance of the HideConsequenceObject class.
  /// </summary>
  public HideConsequenceObject() { }

  /// <summary>
  /// Unique record identifier.
  /// </summary>
  /// <value>Unique record identifier.</value>
  [JsonPropertyName("objectID")]
  public string ObjectID { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class HideConsequenceObject {\n");
    sb.Append("  ObjectID: ").Append(ObjectID).Append("\n");
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
    if (obj is not HideConsequenceObject input)
    {
      return false;
    }

    return (ObjectID == input.ObjectID || (ObjectID != null && ObjectID.Equals(input.ObjectID)));
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
      return hashCode;
    }
  }
}

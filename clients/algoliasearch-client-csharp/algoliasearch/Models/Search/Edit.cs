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
/// Edit
/// </summary>
public partial class Edit
{
  /// <summary>
  /// Gets or Sets Type
  /// </summary>
  [JsonPropertyName("type")]
  public EditType? Type { get; set; }

  /// <summary>
  /// Initializes a new instance of the Edit class.
  /// </summary>
  public Edit() { }

  /// <summary>
  /// Text or patterns to remove from the query string.
  /// </summary>
  /// <value>Text or patterns to remove from the query string.</value>
  [JsonPropertyName("delete")]
  public string Delete { get; set; }

  /// <summary>
  /// Text to be added in place of the deleted text inside the query string.
  /// </summary>
  /// <value>Text to be added in place of the deleted text inside the query string.</value>
  [JsonPropertyName("insert")]
  public string Insert { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class Edit {\n");
    sb.Append("  Type: ").Append(Type).Append("\n");
    sb.Append("  Delete: ").Append(Delete).Append("\n");
    sb.Append("  Insert: ").Append(Insert).Append("\n");
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
    if (obj is not Edit input)
    {
      return false;
    }

    return (Type == input.Type || Type.Equals(input.Type))
      && (Delete == input.Delete || (Delete != null && Delete.Equals(input.Delete)))
      && (Insert == input.Insert || (Insert != null && Insert.Equals(input.Insert)));
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
      hashCode = (hashCode * 59) + Type.GetHashCode();
      if (Delete != null)
      {
        hashCode = (hashCode * 59) + Delete.GetHashCode();
      }
      if (Insert != null)
      {
        hashCode = (hashCode * 59) + Insert.GetHashCode();
      }
      return hashCode;
    }
  }
}

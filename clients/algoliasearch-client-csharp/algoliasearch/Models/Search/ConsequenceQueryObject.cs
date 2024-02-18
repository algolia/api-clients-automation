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
/// ConsequenceQueryObject
/// </summary>
public partial class ConsequenceQueryObject
{
  /// <summary>
  /// Initializes a new instance of the ConsequenceQueryObject class.
  /// </summary>
  public ConsequenceQueryObject()
  {
  }

  /// <summary>
  /// Words to remove.
  /// </summary>
  /// <value>Words to remove.</value>
  [JsonPropertyName("remove")]
  public List<string> Remove { get; set; }

  /// <summary>
  /// Edits to apply.
  /// </summary>
  /// <value>Edits to apply.</value>
  [JsonPropertyName("edits")]
  public List<Edit> Edits { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ConsequenceQueryObject {\n");
    sb.Append("  Remove: ").Append(Remove).Append("\n");
    sb.Append("  Edits: ").Append(Edits).Append("\n");
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
    if (obj is not ConsequenceQueryObject input)
    {
      return false;
    }

    return
        (Remove == input.Remove || Remove != null && input.Remove != null && Remove.SequenceEqual(input.Remove)) &&
        (Edits == input.Edits || Edits != null && input.Edits != null && Edits.SequenceEqual(input.Edits));
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
      if (Remove != null)
      {
        hashCode = (hashCode * 59) + Remove.GetHashCode();
      }
      if (Edits != null)
      {
        hashCode = (hashCode * 59) + Edits.GetHashCode();
      }
      return hashCode;
    }
  }

}


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
/// Records to promote.
/// </summary>
public partial class PromoteObjectIDs
{
  /// <summary>
  /// Initializes a new instance of the PromoteObjectIDs class.
  /// </summary>
  [JsonConstructor]
  public PromoteObjectIDs() { }
  /// <summary>
  /// Initializes a new instance of the PromoteObjectIDs class.
  /// </summary>
  /// <param name="objectIDs">Object IDs of the records you want to promote.  The records are placed as a group at the `position`. For example, if you want to promote four records to position `0`, they will be the first four search results.  (required).</param>
  /// <param name="position">Position in the search results where you want to show the promoted records. (required).</param>
  public PromoteObjectIDs(List<string> objectIDs, int position)
  {
    ObjectIDs = objectIDs ?? throw new ArgumentNullException(nameof(objectIDs));
    Position = position;
  }

  /// <summary>
  /// Object IDs of the records you want to promote.  The records are placed as a group at the `position`. For example, if you want to promote four records to position `0`, they will be the first four search results. 
  /// </summary>
  /// <value>Object IDs of the records you want to promote.  The records are placed as a group at the `position`. For example, if you want to promote four records to position `0`, they will be the first four search results. </value>
  [JsonPropertyName("objectIDs")]
  public List<string> ObjectIDs { get; set; }

  /// <summary>
  /// Position in the search results where you want to show the promoted records.
  /// </summary>
  /// <value>Position in the search results where you want to show the promoted records.</value>
  [JsonPropertyName("position")]
  public int Position { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class PromoteObjectIDs {\n");
    sb.Append("  ObjectIDs: ").Append(ObjectIDs).Append("\n");
    sb.Append("  Position: ").Append(Position).Append("\n");
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
    if (obj is not PromoteObjectIDs input)
    {
      return false;
    }

    return
        (ObjectIDs == input.ObjectIDs || ObjectIDs != null && input.ObjectIDs != null && ObjectIDs.SequenceEqual(input.ObjectIDs)) &&
        (Position == input.Position || Position.Equals(input.Position));
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
      if (ObjectIDs != null)
      {
        hashCode = (hashCode * 59) + ObjectIDs.GetHashCode();
      }
      hashCode = (hashCode * 59) + Position.GetHashCode();
      return hashCode;
    }
  }

}


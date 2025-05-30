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
/// Assign userID parameters.
/// </summary>
public partial class BatchAssignUserIdsParams
{
  /// <summary>
  /// Initializes a new instance of the BatchAssignUserIdsParams class.
  /// </summary>
  [JsonConstructor]
  public BatchAssignUserIdsParams() { }

  /// <summary>
  /// Initializes a new instance of the BatchAssignUserIdsParams class.
  /// </summary>
  /// <param name="cluster">Cluster name. (required).</param>
  /// <param name="users">User IDs to assign. (required).</param>
  public BatchAssignUserIdsParams(string cluster, List<string> users)
  {
    Cluster = cluster ?? throw new ArgumentNullException(nameof(cluster));
    Users = users ?? throw new ArgumentNullException(nameof(users));
  }

  /// <summary>
  /// Cluster name.
  /// </summary>
  /// <value>Cluster name.</value>
  [JsonPropertyName("cluster")]
  public string Cluster { get; set; }

  /// <summary>
  /// User IDs to assign.
  /// </summary>
  /// <value>User IDs to assign.</value>
  [JsonPropertyName("users")]
  public List<string> Users { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class BatchAssignUserIdsParams {\n");
    sb.Append("  Cluster: ").Append(Cluster).Append("\n");
    sb.Append("  Users: ").Append(Users).Append("\n");
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
    if (obj is not BatchAssignUserIdsParams input)
    {
      return false;
    }

    return (Cluster == input.Cluster || (Cluster != null && Cluster.Equals(input.Cluster)))
      && (
        Users == input.Users
        || Users != null && input.Users != null && Users.SequenceEqual(input.Users)
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
      if (Cluster != null)
      {
        hashCode = (hashCode * 59) + Cluster.GetHashCode();
      }
      if (Users != null)
      {
        hashCode = (hashCode * 59) + Users.GetHashCode();
      }
      return hashCode;
    }
  }
}

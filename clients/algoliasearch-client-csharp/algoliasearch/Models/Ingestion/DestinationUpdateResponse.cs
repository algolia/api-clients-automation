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
/// API response for updating a destination.
/// </summary>
public partial class DestinationUpdateResponse
{
  /// <summary>
  /// Initializes a new instance of the DestinationUpdateResponse class.
  /// </summary>
  [JsonConstructor]
  public DestinationUpdateResponse() { }

  /// <summary>
  /// Initializes a new instance of the DestinationUpdateResponse class.
  /// </summary>
  /// <param name="destinationID">Universally unique identifier (UUID) of a destination resource. (required).</param>
  /// <param name="name">Descriptive name for the resource. (required).</param>
  /// <param name="updatedAt">Date of last update in RFC 3339 format. (required).</param>
  public DestinationUpdateResponse(string destinationID, string name, string updatedAt)
  {
    DestinationID = destinationID ?? throw new ArgumentNullException(nameof(destinationID));
    Name = name ?? throw new ArgumentNullException(nameof(name));
    UpdatedAt = updatedAt ?? throw new ArgumentNullException(nameof(updatedAt));
  }

  /// <summary>
  /// Universally unique identifier (UUID) of a destination resource.
  /// </summary>
  /// <value>Universally unique identifier (UUID) of a destination resource.</value>
  [JsonPropertyName("destinationID")]
  public string DestinationID { get; set; }

  /// <summary>
  /// Descriptive name for the resource.
  /// </summary>
  /// <value>Descriptive name for the resource.</value>
  [JsonPropertyName("name")]
  public string Name { get; set; }

  /// <summary>
  /// Date of last update in RFC 3339 format.
  /// </summary>
  /// <value>Date of last update in RFC 3339 format.</value>
  [JsonPropertyName("updatedAt")]
  public string UpdatedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class DestinationUpdateResponse {\n");
    sb.Append("  DestinationID: ").Append(DestinationID).Append("\n");
    sb.Append("  Name: ").Append(Name).Append("\n");
    sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
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
    if (obj is not DestinationUpdateResponse input)
    {
      return false;
    }

    return (
        DestinationID == input.DestinationID
        || (DestinationID != null && DestinationID.Equals(input.DestinationID))
      )
      && (Name == input.Name || (Name != null && Name.Equals(input.Name)))
      && (UpdatedAt == input.UpdatedAt || (UpdatedAt != null && UpdatedAt.Equals(input.UpdatedAt)));
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
      if (DestinationID != null)
      {
        hashCode = (hashCode * 59) + DestinationID.GetHashCode();
      }
      if (Name != null)
      {
        hashCode = (hashCode * 59) + Name.GetHashCode();
      }
      if (UpdatedAt != null)
      {
        hashCode = (hashCode * 59) + UpdatedAt.GetHashCode();
      }
      return hashCode;
    }
  }
}

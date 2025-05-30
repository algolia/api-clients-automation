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
/// SourceUpdate
/// </summary>
public partial class SourceUpdate
{
  /// <summary>
  /// Initializes a new instance of the SourceUpdate class.
  /// </summary>
  public SourceUpdate() { }

  /// <summary>
  /// Descriptive name of the source.
  /// </summary>
  /// <value>Descriptive name of the source.</value>
  [JsonPropertyName("name")]
  public string Name { get; set; }

  /// <summary>
  /// Gets or Sets Input
  /// </summary>
  [JsonPropertyName("input")]
  public SourceUpdateInput Input { get; set; }

  /// <summary>
  /// Universally unique identifier (UUID) of an authentication resource.
  /// </summary>
  /// <value>Universally unique identifier (UUID) of an authentication resource.</value>
  [JsonPropertyName("authenticationID")]
  public string AuthenticationID { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SourceUpdate {\n");
    sb.Append("  Name: ").Append(Name).Append("\n");
    sb.Append("  Input: ").Append(Input).Append("\n");
    sb.Append("  AuthenticationID: ").Append(AuthenticationID).Append("\n");
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
    if (obj is not SourceUpdate input)
    {
      return false;
    }

    return (Name == input.Name || (Name != null && Name.Equals(input.Name)))
      && (Input == input.Input || (Input != null && Input.Equals(input.Input)))
      && (
        AuthenticationID == input.AuthenticationID
        || (AuthenticationID != null && AuthenticationID.Equals(input.AuthenticationID))
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
      if (Name != null)
      {
        hashCode = (hashCode * 59) + Name.GetHashCode();
      }
      if (Input != null)
      {
        hashCode = (hashCode * 59) + Input.GetHashCode();
      }
      if (AuthenticationID != null)
      {
        hashCode = (hashCode * 59) + AuthenticationID.GetHashCode();
      }
      return hashCode;
    }
  }
}

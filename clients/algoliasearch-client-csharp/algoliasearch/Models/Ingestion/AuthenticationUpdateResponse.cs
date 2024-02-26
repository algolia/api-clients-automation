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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// Response from the API when the Authentication is successfully updated.
/// </summary>
public partial class AuthenticationUpdateResponse
{
  /// <summary>
  /// Initializes a new instance of the AuthenticationUpdateResponse class.
  /// </summary>
  [JsonConstructor]
  public AuthenticationUpdateResponse() { }
  /// <summary>
  /// Initializes a new instance of the AuthenticationUpdateResponse class.
  /// </summary>
  /// <param name="authenticationID">The authentication UUID. (required).</param>
  /// <param name="name">An human readable name describing the object. (required).</param>
  /// <param name="updatedAt">Date of last update (RFC3339 format). (required).</param>
  public AuthenticationUpdateResponse(string authenticationID, string name, string updatedAt)
  {
    AuthenticationID = authenticationID ?? throw new ArgumentNullException(nameof(authenticationID));
    Name = name ?? throw new ArgumentNullException(nameof(name));
    UpdatedAt = updatedAt ?? throw new ArgumentNullException(nameof(updatedAt));
  }

  /// <summary>
  /// The authentication UUID.
  /// </summary>
  /// <value>The authentication UUID.</value>
  [JsonPropertyName("authenticationID")]
  public string AuthenticationID { get; set; }

  /// <summary>
  /// An human readable name describing the object.
  /// </summary>
  /// <value>An human readable name describing the object.</value>
  [JsonPropertyName("name")]
  public string Name { get; set; }

  /// <summary>
  /// Date of last update (RFC3339 format).
  /// </summary>
  /// <value>Date of last update (RFC3339 format).</value>
  [JsonPropertyName("updatedAt")]
  public string UpdatedAt { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AuthenticationUpdateResponse {\n");
    sb.Append("  AuthenticationID: ").Append(AuthenticationID).Append("\n");
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
    if (obj is not AuthenticationUpdateResponse input)
    {
      return false;
    }

    return
        (AuthenticationID == input.AuthenticationID || (AuthenticationID != null && AuthenticationID.Equals(input.AuthenticationID))) &&
        (Name == input.Name || (Name != null && Name.Equals(input.Name))) &&
        (UpdatedAt == input.UpdatedAt || (UpdatedAt != null && UpdatedAt.Equals(input.UpdatedAt)));
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
      if (AuthenticationID != null)
      {
        hashCode = (hashCode * 59) + AuthenticationID.GetHashCode();
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


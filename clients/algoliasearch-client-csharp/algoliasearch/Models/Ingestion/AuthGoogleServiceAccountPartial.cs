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
/// Credentials for authenticating with a Google service account, such as BigQuery.
/// </summary>
public partial class AuthGoogleServiceAccountPartial
{
  /// <summary>
  /// Initializes a new instance of the AuthGoogleServiceAccountPartial class.
  /// </summary>
  public AuthGoogleServiceAccountPartial() { }

  /// <summary>
  /// Email address of the Google service account.
  /// </summary>
  /// <value>Email address of the Google service account.</value>
  [JsonPropertyName("clientEmail")]
  public string ClientEmail { get; set; }

  /// <summary>
  /// Private key of the Google service account. This field is `null` in the API response.
  /// </summary>
  /// <value>Private key of the Google service account. This field is `null` in the API response.</value>
  [JsonPropertyName("privateKey")]
  public string PrivateKey { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AuthGoogleServiceAccountPartial {\n");
    sb.Append("  ClientEmail: ").Append(ClientEmail).Append("\n");
    sb.Append("  PrivateKey: ").Append(PrivateKey).Append("\n");
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
    if (obj is not AuthGoogleServiceAccountPartial input)
    {
      return false;
    }

    return (
        ClientEmail == input.ClientEmail
        || (ClientEmail != null && ClientEmail.Equals(input.ClientEmail))
      )
      && (
        PrivateKey == input.PrivateKey
        || (PrivateKey != null && PrivateKey.Equals(input.PrivateKey))
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
      if (ClientEmail != null)
      {
        hashCode = (hashCode * 59) + ClientEmail.GetHashCode();
      }
      if (PrivateKey != null)
      {
        hashCode = (hashCode * 59) + PrivateKey.GetHashCode();
      }
      return hashCode;
    }
  }
}

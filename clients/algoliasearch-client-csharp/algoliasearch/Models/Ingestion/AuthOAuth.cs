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
/// Credentials for authenticating with OAuth 2.0.
/// </summary>
public partial class AuthOAuth
{
  /// <summary>
  /// Initializes a new instance of the AuthOAuth class.
  /// </summary>
  [JsonConstructor]
  public AuthOAuth() { }

  /// <summary>
  /// Initializes a new instance of the AuthOAuth class.
  /// </summary>
  /// <param name="url">URL for the OAuth endpoint. (required).</param>
  /// <param name="clientId">Client ID. (required).</param>
  /// <param name="clientSecret">Client secret. This field is `null` in the API response. (required).</param>
  public AuthOAuth(string url, string clientId, string clientSecret)
  {
    Url = url ?? throw new ArgumentNullException(nameof(url));
    ClientId = clientId ?? throw new ArgumentNullException(nameof(clientId));
    ClientSecret = clientSecret ?? throw new ArgumentNullException(nameof(clientSecret));
  }

  /// <summary>
  /// URL for the OAuth endpoint.
  /// </summary>
  /// <value>URL for the OAuth endpoint.</value>
  [JsonPropertyName("url")]
  public string Url { get; set; }

  /// <summary>
  /// Client ID.
  /// </summary>
  /// <value>Client ID.</value>
  [JsonPropertyName("client_id")]
  public string ClientId { get; set; }

  /// <summary>
  /// Client secret. This field is `null` in the API response.
  /// </summary>
  /// <value>Client secret. This field is `null` in the API response.</value>
  [JsonPropertyName("client_secret")]
  public string ClientSecret { get; set; }

  /// <summary>
  /// OAuth scope.
  /// </summary>
  /// <value>OAuth scope.</value>
  [JsonPropertyName("scope")]
  public string Scope { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class AuthOAuth {\n");
    sb.Append("  Url: ").Append(Url).Append("\n");
    sb.Append("  ClientId: ").Append(ClientId).Append("\n");
    sb.Append("  ClientSecret: ").Append(ClientSecret).Append("\n");
    sb.Append("  Scope: ").Append(Scope).Append("\n");
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
    if (obj is not AuthOAuth input)
    {
      return false;
    }

    return (Url == input.Url || (Url != null && Url.Equals(input.Url)))
      && (ClientId == input.ClientId || (ClientId != null && ClientId.Equals(input.ClientId)))
      && (
        ClientSecret == input.ClientSecret
        || (ClientSecret != null && ClientSecret.Equals(input.ClientSecret))
      )
      && (Scope == input.Scope || (Scope != null && Scope.Equals(input.Scope)));
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
      if (Url != null)
      {
        hashCode = (hashCode * 59) + Url.GetHashCode();
      }
      if (ClientId != null)
      {
        hashCode = (hashCode * 59) + ClientId.GetHashCode();
      }
      if (ClientSecret != null)
      {
        hashCode = (hashCode * 59) + ClientSecret.GetHashCode();
      }
      if (Scope != null)
      {
        hashCode = (hashCode * 59) + Scope.GetHashCode();
      }
      return hashCode;
    }
  }
}

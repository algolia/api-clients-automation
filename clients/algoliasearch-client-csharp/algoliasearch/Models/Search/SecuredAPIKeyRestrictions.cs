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
/// SecuredAPIKeyRestrictions
/// </summary>
public partial class SecuredAPIKeyRestrictions
{
  /// <summary>
  /// Initializes a new instance of the SecuredAPIKeyRestrictions class.
  /// </summary>
  public SecuredAPIKeyRestrictions()
  {
  }

  /// <summary>
  /// Gets or Sets SearchParams
  /// </summary>
  [JsonPropertyName("searchParams")]
  public SearchParamsObject SearchParams { get; set; }

  /// <summary>
  /// Filters that apply to every search made with the secured API key. Extra filters added at search time will be combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`. 
  /// </summary>
  /// <value>Filters that apply to every search made with the secured API key. Extra filters added at search time will be combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`. </value>
  [JsonPropertyName("filters")]
  public string Filters { get; set; }

  /// <summary>
  /// Timestamp in [Unix epoch time](https://en.wikipedia.org/wiki/Unix_time) when the API key should expire.
  /// </summary>
  /// <value>Timestamp in [Unix epoch time](https://en.wikipedia.org/wiki/Unix_time) when the API key should expire.</value>
  [JsonPropertyName("validUntil")]
  public long? ValidUntil { get; set; }

  /// <summary>
  /// Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\". 
  /// </summary>
  /// <value>Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\". </value>
  [JsonPropertyName("restrictIndices")]
  public List<string> RestrictIndices { get; set; }

  /// <summary>
  /// IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of IP addresses. Use this to protect against API key leaking and reuse. 
  /// </summary>
  /// <value>IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of IP addresses. Use this to protect against API key leaking and reuse. </value>
  [JsonPropertyName("restrictSources")]
  public string RestrictSources { get; set; }

  /// <summary>
  /// Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this, add a user token to each generated API key. 
  /// </summary>
  /// <value>Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this, add a user token to each generated API key. </value>
  [JsonPropertyName("userToken")]
  public string UserToken { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SecuredAPIKeyRestrictions {\n");
    sb.Append("  SearchParams: ").Append(SearchParams).Append("\n");
    sb.Append("  Filters: ").Append(Filters).Append("\n");
    sb.Append("  ValidUntil: ").Append(ValidUntil).Append("\n");
    sb.Append("  RestrictIndices: ").Append(RestrictIndices).Append("\n");
    sb.Append("  RestrictSources: ").Append(RestrictSources).Append("\n");
    sb.Append("  UserToken: ").Append(UserToken).Append("\n");
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
    if (obj is not SecuredAPIKeyRestrictions input)
    {
      return false;
    }

    return
        (SearchParams == input.SearchParams || (SearchParams != null && SearchParams.Equals(input.SearchParams))) &&
        (Filters == input.Filters || (Filters != null && Filters.Equals(input.Filters))) &&
        (ValidUntil == input.ValidUntil || ValidUntil.Equals(input.ValidUntil)) &&
        (RestrictIndices == input.RestrictIndices || RestrictIndices != null && input.RestrictIndices != null && RestrictIndices.SequenceEqual(input.RestrictIndices)) &&
        (RestrictSources == input.RestrictSources || (RestrictSources != null && RestrictSources.Equals(input.RestrictSources))) &&
        (UserToken == input.UserToken || (UserToken != null && UserToken.Equals(input.UserToken)));
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
      if (SearchParams != null)
      {
        hashCode = (hashCode * 59) + SearchParams.GetHashCode();
      }
      if (Filters != null)
      {
        hashCode = (hashCode * 59) + Filters.GetHashCode();
      }
      hashCode = (hashCode * 59) + ValidUntil.GetHashCode();
      if (RestrictIndices != null)
      {
        hashCode = (hashCode * 59) + RestrictIndices.GetHashCode();
      }
      if (RestrictSources != null)
      {
        hashCode = (hashCode * 59) + RestrictSources.GetHashCode();
      }
      if (UserToken != null)
      {
        hashCode = (hashCode * 59) + UserToken.GetHashCode();
      }
      return hashCode;
    }
  }

}


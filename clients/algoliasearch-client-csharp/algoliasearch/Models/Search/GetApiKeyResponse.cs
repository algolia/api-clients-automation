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
/// GetApiKeyResponse
/// </summary>
public partial class GetApiKeyResponse
{
  /// <summary>
  /// Initializes a new instance of the GetApiKeyResponse class.
  /// </summary>
  [JsonConstructor]
  public GetApiKeyResponse() { }
  /// <summary>
  /// Initializes a new instance of the GetApiKeyResponse class.
  /// </summary>
  /// <param name="createdAt">Timestamp when the object was created, in milliseconds since the Unix epoch. (required).</param>
  /// <param name="acl">Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint&#39;s reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl).  (required).</param>
  public GetApiKeyResponse(long createdAt, List<Acl> acl)
  {
    CreatedAt = createdAt;
    Acl = acl ?? throw new ArgumentNullException(nameof(acl));
  }

  /// <summary>
  /// API key.
  /// </summary>
  /// <value>API key.</value>
  [JsonPropertyName("value")]
  public string Value { get; set; }

  /// <summary>
  /// Timestamp when the object was created, in milliseconds since the Unix epoch.
  /// </summary>
  /// <value>Timestamp when the object was created, in milliseconds since the Unix epoch.</value>
  [JsonPropertyName("createdAt")]
  public long CreatedAt { get; set; }

  /// <summary>
  /// Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint's reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl). 
  /// </summary>
  /// <value>Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint's reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl). </value>
  [JsonPropertyName("acl")]
  public List<Acl> Acl { get; set; }

  /// <summary>
  /// Description of an API key to help you identify this API key.
  /// </summary>
  /// <value>Description of an API key to help you identify this API key.</value>
  [JsonPropertyName("description")]
  public string Description { get; set; }

  /// <summary>
  /// Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\". 
  /// </summary>
  /// <value>Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\". </value>
  [JsonPropertyName("indexes")]
  public List<string> Indexes { get; set; }

  /// <summary>
  /// Maximum number of results this API key can retrieve in one query. By default, there's no limit. 
  /// </summary>
  /// <value>Maximum number of results this API key can retrieve in one query. By default, there's no limit. </value>
  [JsonPropertyName("maxHitsPerQuery")]
  public int? MaxHitsPerQuery { get; set; }

  /// <summary>
  /// Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there's no limit. 
  /// </summary>
  /// <value>Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there's no limit. </value>
  [JsonPropertyName("maxQueriesPerIPPerHour")]
  public int? MaxQueriesPerIPPerHour { get; set; }

  /// <summary>
  /// Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that's outside the restricted range. 
  /// </summary>
  /// <value>Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that's outside the restricted range. </value>
  [JsonPropertyName("queryParameters")]
  public string QueryParameters { get; set; }

  /// <summary>
  /// Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/_*` allows all referrers starting with \"https://algolia.com/\" - `*.algolia.com` allows all referrers ending with \".algolia.com\" - `*algolia.com*` allows all referrers in the domain \"algolia.com\".  Like all HTTP headers, referrers can be spoofed. Don't rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions). 
  /// </summary>
  /// <value>Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/_*` allows all referrers starting with \"https://algolia.com/\" - `*.algolia.com` allows all referrers ending with \".algolia.com\" - `*algolia.com*` allows all referrers in the domain \"algolia.com\".  Like all HTTP headers, referrers can be spoofed. Don't rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions). </value>
  [JsonPropertyName("referers")]
  public List<string> Referers { get; set; }

  /// <summary>
  /// Duration (in seconds) after which the API key expires. By default, API keys don't expire. 
  /// </summary>
  /// <value>Duration (in seconds) after which the API key expires. By default, API keys don't expire. </value>
  [JsonPropertyName("validity")]
  public int? Validity { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetApiKeyResponse {\n");
    sb.Append("  Value: ").Append(Value).Append("\n");
    sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
    sb.Append("  Acl: ").Append(Acl).Append("\n");
    sb.Append("  Description: ").Append(Description).Append("\n");
    sb.Append("  Indexes: ").Append(Indexes).Append("\n");
    sb.Append("  MaxHitsPerQuery: ").Append(MaxHitsPerQuery).Append("\n");
    sb.Append("  MaxQueriesPerIPPerHour: ").Append(MaxQueriesPerIPPerHour).Append("\n");
    sb.Append("  QueryParameters: ").Append(QueryParameters).Append("\n");
    sb.Append("  Referers: ").Append(Referers).Append("\n");
    sb.Append("  Validity: ").Append(Validity).Append("\n");
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
    if (obj is not GetApiKeyResponse input)
    {
      return false;
    }

    return
        (Value == input.Value || (Value != null && Value.Equals(input.Value))) &&
        (CreatedAt == input.CreatedAt || CreatedAt.Equals(input.CreatedAt)) &&
        (Acl == input.Acl || Acl != null && input.Acl != null && Acl.SequenceEqual(input.Acl)) &&
        (Description == input.Description || (Description != null && Description.Equals(input.Description))) &&
        (Indexes == input.Indexes || Indexes != null && input.Indexes != null && Indexes.SequenceEqual(input.Indexes)) &&
        (MaxHitsPerQuery == input.MaxHitsPerQuery || MaxHitsPerQuery.Equals(input.MaxHitsPerQuery)) &&
        (MaxQueriesPerIPPerHour == input.MaxQueriesPerIPPerHour || MaxQueriesPerIPPerHour.Equals(input.MaxQueriesPerIPPerHour)) &&
        (QueryParameters == input.QueryParameters || (QueryParameters != null && QueryParameters.Equals(input.QueryParameters))) &&
        (Referers == input.Referers || Referers != null && input.Referers != null && Referers.SequenceEqual(input.Referers)) &&
        (Validity == input.Validity || Validity.Equals(input.Validity));
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
      if (Value != null)
      {
        hashCode = (hashCode * 59) + Value.GetHashCode();
      }
      hashCode = (hashCode * 59) + CreatedAt.GetHashCode();
      if (Acl != null)
      {
        hashCode = (hashCode * 59) + Acl.GetHashCode();
      }
      if (Description != null)
      {
        hashCode = (hashCode * 59) + Description.GetHashCode();
      }
      if (Indexes != null)
      {
        hashCode = (hashCode * 59) + Indexes.GetHashCode();
      }
      hashCode = (hashCode * 59) + MaxHitsPerQuery.GetHashCode();
      hashCode = (hashCode * 59) + MaxQueriesPerIPPerHour.GetHashCode();
      if (QueryParameters != null)
      {
        hashCode = (hashCode * 59) + QueryParameters.GetHashCode();
      }
      if (Referers != null)
      {
        hashCode = (hashCode * 59) + Referers.GetHashCode();
      }
      hashCode = (hashCode * 59) + Validity.GetHashCode();
      return hashCode;
    }
  }

}


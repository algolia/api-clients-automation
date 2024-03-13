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

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// BaseRecommendedForYouQueryParameters
/// </summary>
public partial class BaseRecommendedForYouQueryParameters
{
  /// <summary>
  /// Initializes a new instance of the BaseRecommendedForYouQueryParameters class.
  /// </summary>
  [JsonConstructor]
  public BaseRecommendedForYouQueryParameters() { }
  /// <summary>
  /// Initializes a new instance of the BaseRecommendedForYouQueryParameters class.
  /// </summary>
  /// <param name="userToken">Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  (required).</param>
  public BaseRecommendedForYouQueryParameters(string userToken)
  {
    UserToken = userToken ?? throw new ArgumentNullException(nameof(userToken));
  }

  /// <summary>
  /// Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). 
  /// </summary>
  /// <value>Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). </value>
  [JsonPropertyName("userToken")]
  public string UserToken { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class BaseRecommendedForYouQueryParameters {\n");
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
    if (obj is not BaseRecommendedForYouQueryParameters input)
    {
      return false;
    }

    return
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
      if (UserToken != null)
      {
        hashCode = (hashCode * 59) + UserToken.GetHashCode();
      }
      return hashCode;
    }
  }

}


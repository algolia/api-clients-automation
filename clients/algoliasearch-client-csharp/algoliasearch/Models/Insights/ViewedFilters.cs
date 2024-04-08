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

namespace Algolia.Search.Models.Insights;

/// <summary>
/// Use this method to capture active filters. For example, when browsing a category page, users see content filtered on that specific category. 
/// </summary>
public partial class ViewedFilters
{

  /// <summary>
  /// Gets or Sets EventType
  /// </summary>
  [JsonPropertyName("eventType")]
  public ViewEvent? EventType { get; set; }
  /// <summary>
  /// Initializes a new instance of the ViewedFilters class.
  /// </summary>
  [JsonConstructor]
  public ViewedFilters() { }
  /// <summary>
  /// Initializes a new instance of the ViewedFilters class.
  /// </summary>
  /// <param name="eventName">Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  (required).</param>
  /// <param name="eventType">eventType (required).</param>
  /// <param name="index">Index name to which the event&#39;s items belong. (required).</param>
  /// <param name="filters">Applied facet filters.  Facet filters are &#x60;facet:value&#x60; pairs. Facet values must be URL-encoded, such as, &#x60;discount:10%25&#x60;.  (required).</param>
  /// <param name="userToken">Anonymous or pseudonymous user identifier.  Don&#39;t use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  (required).</param>
  public ViewedFilters(string eventName, ViewEvent? eventType, string index, List<string> filters, string userToken)
  {
    EventName = eventName ?? throw new ArgumentNullException(nameof(eventName));
    EventType = eventType;
    Index = index ?? throw new ArgumentNullException(nameof(index));
    Filters = filters ?? throw new ArgumentNullException(nameof(filters));
    UserToken = userToken ?? throw new ArgumentNullException(nameof(userToken));
  }

  /// <summary>
  /// Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
  /// </summary>
  /// <value>Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. </value>
  [JsonPropertyName("eventName")]
  public string EventName { get; set; }

  /// <summary>
  /// Index name to which the event's items belong.
  /// </summary>
  /// <value>Index name to which the event's items belong.</value>
  [JsonPropertyName("index")]
  public string Index { get; set; }

  /// <summary>
  /// Applied facet filters.  Facet filters are `facet:value` pairs. Facet values must be URL-encoded, such as, `discount:10%25`. 
  /// </summary>
  /// <value>Applied facet filters.  Facet filters are `facet:value` pairs. Facet values must be URL-encoded, such as, `discount:10%25`. </value>
  [JsonPropertyName("filters")]
  public List<string> Filters { get; set; }

  /// <summary>
  /// Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). 
  /// </summary>
  /// <value>Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). </value>
  [JsonPropertyName("userToken")]
  public string UserToken { get; set; }

  /// <summary>
  /// Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). 
  /// </summary>
  /// <value>Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). </value>
  [JsonPropertyName("authenticatedUserToken")]
  public string AuthenticatedUserToken { get; set; }

  /// <summary>
  /// Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp. 
  /// </summary>
  /// <value>Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp. </value>
  [JsonPropertyName("timestamp")]
  public long? Timestamp { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ViewedFilters {\n");
    sb.Append("  EventName: ").Append(EventName).Append("\n");
    sb.Append("  EventType: ").Append(EventType).Append("\n");
    sb.Append("  Index: ").Append(Index).Append("\n");
    sb.Append("  Filters: ").Append(Filters).Append("\n");
    sb.Append("  UserToken: ").Append(UserToken).Append("\n");
    sb.Append("  AuthenticatedUserToken: ").Append(AuthenticatedUserToken).Append("\n");
    sb.Append("  Timestamp: ").Append(Timestamp).Append("\n");
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
    if (obj is not ViewedFilters input)
    {
      return false;
    }

    return
        (EventName == input.EventName || (EventName != null && EventName.Equals(input.EventName))) &&
        (EventType == input.EventType || EventType.Equals(input.EventType)) &&
        (Index == input.Index || (Index != null && Index.Equals(input.Index))) &&
        (Filters == input.Filters || Filters != null && input.Filters != null && Filters.SequenceEqual(input.Filters)) &&
        (UserToken == input.UserToken || (UserToken != null && UserToken.Equals(input.UserToken))) &&
        (AuthenticatedUserToken == input.AuthenticatedUserToken || (AuthenticatedUserToken != null && AuthenticatedUserToken.Equals(input.AuthenticatedUserToken))) &&
        (Timestamp == input.Timestamp || Timestamp.Equals(input.Timestamp));
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
      if (EventName != null)
      {
        hashCode = (hashCode * 59) + EventName.GetHashCode();
      }
      hashCode = (hashCode * 59) + EventType.GetHashCode();
      if (Index != null)
      {
        hashCode = (hashCode * 59) + Index.GetHashCode();
      }
      if (Filters != null)
      {
        hashCode = (hashCode * 59) + Filters.GetHashCode();
      }
      if (UserToken != null)
      {
        hashCode = (hashCode * 59) + UserToken.GetHashCode();
      }
      if (AuthenticatedUserToken != null)
      {
        hashCode = (hashCode * 59) + AuthenticatedUserToken.GetHashCode();
      }
      hashCode = (hashCode * 59) + Timestamp.GetHashCode();
      return hashCode;
    }
  }

}


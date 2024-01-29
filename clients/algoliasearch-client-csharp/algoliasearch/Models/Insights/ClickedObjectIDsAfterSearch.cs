//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Insights;

/// <summary>
/// Click event after an Algolia request.  Use this event to track when users click items in the search results. If you're building your category pages with Algolia, you'll also use this event. 
/// </summary>
[DataContract(Name = "ClickedObjectIDsAfterSearch")]
[JsonObject(MemberSerialization.OptOut)]
public partial class ClickedObjectIDsAfterSearch
{

  /// <summary>
  /// Gets or Sets EventType
  /// </summary>
  [DataMember(Name = "eventType", IsRequired = true, EmitDefaultValue = false)]
  public ClickEvent EventType { get; set; }
  /// <summary>
  /// Initializes a new instance of the ClickedObjectIDsAfterSearch class.
  /// </summary>
  [JsonConstructor]
  public ClickedObjectIDsAfterSearch() { }
  /// <summary>
  /// Initializes a new instance of the ClickedObjectIDsAfterSearch class.
  /// </summary>
  /// <param name="eventName">The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  (required).</param>
  /// <param name="eventType">eventType (required).</param>
  /// <param name="index">The name of an Algolia index. (required).</param>
  /// <param name="objectIDs">The object IDs of the records that are part of the event. (required).</param>
  /// <param name="positions">The position of the clicked item the search results.  The first search result has a position of 1 (not 0). You must provide 1 &#x60;position&#x60; for each &#x60;objectID&#x60;.  (required).</param>
  /// <param name="queryID">Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add &#x60;clickAnalytics: true&#x60; as a search request parameter, the query ID is included in the API response.  (required).</param>
  /// <param name="userToken">An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens.  (required).</param>
  public ClickedObjectIDsAfterSearch(string eventName, ClickEvent eventType, string index, List<string> objectIDs, List<int> positions, string queryID, string userToken)
  {
    EventName = eventName ?? throw new ArgumentNullException(nameof(eventName));
    EventType = eventType;
    Index = index ?? throw new ArgumentNullException(nameof(index));
    ObjectIDs = objectIDs ?? throw new ArgumentNullException(nameof(objectIDs));
    Positions = positions ?? throw new ArgumentNullException(nameof(positions));
    QueryID = queryID ?? throw new ArgumentNullException(nameof(queryID));
    UserToken = userToken ?? throw new ArgumentNullException(nameof(userToken));
  }

  /// <summary>
  /// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
  /// </summary>
  /// <value>The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. </value>
  [DataMember(Name = "eventName", IsRequired = true, EmitDefaultValue = false)]
  public string EventName { get; set; }

  /// <summary>
  /// The name of an Algolia index.
  /// </summary>
  /// <value>The name of an Algolia index.</value>
  [DataMember(Name = "index", IsRequired = true, EmitDefaultValue = false)]
  public string Index { get; set; }

  /// <summary>
  /// The object IDs of the records that are part of the event.
  /// </summary>
  /// <value>The object IDs of the records that are part of the event.</value>
  [DataMember(Name = "objectIDs", IsRequired = true, EmitDefaultValue = false)]
  public List<string> ObjectIDs { get; set; }

  /// <summary>
  /// The position of the clicked item the search results.  The first search result has a position of 1 (not 0). You must provide 1 `position` for each `objectID`. 
  /// </summary>
  /// <value>The position of the clicked item the search results.  The first search result has a position of 1 (not 0). You must provide 1 `position` for each `objectID`. </value>
  [DataMember(Name = "positions", IsRequired = true, EmitDefaultValue = false)]
  public List<int> Positions { get; set; }

  /// <summary>
  /// Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response. 
  /// </summary>
  /// <value>Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response. </value>
  [DataMember(Name = "queryID", IsRequired = true, EmitDefaultValue = false)]
  public string QueryID { get; set; }

  /// <summary>
  /// An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens. 
  /// </summary>
  /// <value>An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens. </value>
  [DataMember(Name = "userToken", IsRequired = true, EmitDefaultValue = false)]
  public string UserToken { get; set; }

  /// <summary>
  /// An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens. 
  /// </summary>
  /// <value>An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens. </value>
  [DataMember(Name = "authenticatedUserToken", EmitDefaultValue = false)]
  public string AuthenticatedUserToken { get; set; }

  /// <summary>
  /// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. 
  /// </summary>
  /// <value>The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. </value>
  [DataMember(Name = "timestamp", EmitDefaultValue = false)]
  public long Timestamp { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ClickedObjectIDsAfterSearch {\n");
    sb.Append("  EventName: ").Append(EventName).Append("\n");
    sb.Append("  EventType: ").Append(EventType).Append("\n");
    sb.Append("  Index: ").Append(Index).Append("\n");
    sb.Append("  ObjectIDs: ").Append(ObjectIDs).Append("\n");
    sb.Append("  Positions: ").Append(Positions).Append("\n");
    sb.Append("  QueryID: ").Append(QueryID).Append("\n");
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
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}


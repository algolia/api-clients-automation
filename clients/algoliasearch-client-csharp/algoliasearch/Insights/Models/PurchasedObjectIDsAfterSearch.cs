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

namespace Algolia.Search.Models.Insights
{
  /// <summary>
  /// Use this event to track when users make a purchase after a previous Algolia request. If you&#39;re building your category pages with Algolia, you&#39;ll also use this event. 
  /// </summary>
  [DataContract(Name = "PurchasedObjectIDsAfterSearch")]
  public partial class PurchasedObjectIDsAfterSearch
  {

    /// <summary>
    /// Gets or Sets EventType
    /// </summary>
    [DataMember(Name = "eventType", IsRequired = true, EmitDefaultValue = true)]
    public ConversionEvent EventType { get; set; }

    /// <summary>
    /// Gets or Sets EventSubtype
    /// </summary>
    [DataMember(Name = "eventSubtype", IsRequired = true, EmitDefaultValue = true)]
    public PurchaseEvent EventSubtype { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="PurchasedObjectIDsAfterSearch" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public PurchasedObjectIDsAfterSearch() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="PurchasedObjectIDsAfterSearch" /> class.
    /// </summary>
    /// <param name="eventName">Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  (required).</param>
    /// <param name="eventType">eventType (required).</param>
    /// <param name="eventSubtype">eventSubtype (required).</param>
    /// <param name="index">Name of the Algolia index. (required).</param>
    /// <param name="queryID">Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add &#x60;clickAnalytics: true&#x60; as a search request parameter, the query ID is included in the API response.  (required).</param>
    /// <param name="objectIDs">List of object identifiers for items of an Algolia index. (required).</param>
    /// <param name="userToken">Anonymous or pseudonymous user identifier.   &gt; **Note**: Never include personally identifiable information in user tokens.  (required).</param>
    public PurchasedObjectIDsAfterSearch(string eventName, ConversionEvent eventType, PurchaseEvent eventSubtype, string index, string queryID, List<string> objectIDs, string userToken)
    {
      this.EventName = eventName ?? throw new ArgumentNullException("eventName is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.EventType = eventType;
      this.EventSubtype = eventSubtype;
      this.Index = index ?? throw new ArgumentNullException("index is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.QueryID = queryID ?? throw new ArgumentNullException("queryID is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.ObjectIDs = objectIDs ?? throw new ArgumentNullException("objectIDs is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.UserToken = userToken ?? throw new ArgumentNullException("userToken is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
    }

    /// <summary>
    /// Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
    /// </summary>
    /// <value>Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. </value>
    [DataMember(Name = "eventName", IsRequired = true, EmitDefaultValue = true)]
    public string EventName { get; set; }

    /// <summary>
    /// Name of the Algolia index.
    /// </summary>
    /// <value>Name of the Algolia index.</value>
    [DataMember(Name = "index", IsRequired = true, EmitDefaultValue = true)]
    public string Index { get; set; }

    /// <summary>
    /// Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add &#x60;clickAnalytics: true&#x60; as a search request parameter, the query ID is included in the API response. 
    /// </summary>
    /// <value>Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add &#x60;clickAnalytics: true&#x60; as a search request parameter, the query ID is included in the API response. </value>
    [DataMember(Name = "queryID", IsRequired = true, EmitDefaultValue = true)]
    public string QueryID { get; set; }

    /// <summary>
    /// List of object identifiers for items of an Algolia index.
    /// </summary>
    /// <value>List of object identifiers for items of an Algolia index.</value>
    [DataMember(Name = "objectIDs", IsRequired = true, EmitDefaultValue = true)]
    public List<string> ObjectIDs { get; set; }

    /// <summary>
    /// Extra information about the records involved in the event—for example, to add price and quantities of purchased products.  If provided, must be the same length as &#x60;objectIDs&#x60;. 
    /// </summary>
    /// <value>Extra information about the records involved in the event—for example, to add price and quantities of purchased products.  If provided, must be the same length as &#x60;objectIDs&#x60;. </value>
    [DataMember(Name = "objectData", EmitDefaultValue = false)]
    public List<ObjectDataAfterSearch> ObjectData { get; set; }

    /// <summary>
    /// If you include pricing information in the &#x60;objectData&#x60; parameter, you must also specify the currency as ISO-4217 currency code, such as USD or EUR.
    /// </summary>
    /// <value>If you include pricing information in the &#x60;objectData&#x60; parameter, you must also specify the currency as ISO-4217 currency code, such as USD or EUR.</value>
    [DataMember(Name = "currency", EmitDefaultValue = false)]
    public string Currency { get; set; }

    /// <summary>
    /// Anonymous or pseudonymous user identifier.   &gt; **Note**: Never include personally identifiable information in user tokens. 
    /// </summary>
    /// <value>Anonymous or pseudonymous user identifier.   &gt; **Note**: Never include personally identifiable information in user tokens. </value>
    [DataMember(Name = "userToken", IsRequired = true, EmitDefaultValue = true)]
    public string UserToken { get; set; }

    /// <summary>
    /// Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. 
    /// </summary>
    /// <value>Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. </value>
    [DataMember(Name = "timestamp", EmitDefaultValue = false)]
    public long Timestamp { get; set; }

    /// <summary>
    /// User token for authenticated users.
    /// </summary>
    /// <value>User token for authenticated users.</value>
    [DataMember(Name = "authenticatedUserToken", EmitDefaultValue = false)]
    public string AuthenticatedUserToken { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class PurchasedObjectIDsAfterSearch {\n");
      sb.Append("  EventName: ").Append(EventName).Append("\n");
      sb.Append("  EventType: ").Append(EventType).Append("\n");
      sb.Append("  EventSubtype: ").Append(EventSubtype).Append("\n");
      sb.Append("  Index: ").Append(Index).Append("\n");
      sb.Append("  QueryID: ").Append(QueryID).Append("\n");
      sb.Append("  ObjectIDs: ").Append(ObjectIDs).Append("\n");
      sb.Append("  ObjectData: ").Append(ObjectData).Append("\n");
      sb.Append("  Currency: ").Append(Currency).Append("\n");
      sb.Append("  UserToken: ").Append(UserToken).Append("\n");
      sb.Append("  Timestamp: ").Append(Timestamp).Append("\n");
      sb.Append("  AuthenticatedUserToken: ").Append(AuthenticatedUserToken).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}

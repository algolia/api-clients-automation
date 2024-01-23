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
  [JsonObject(MemberSerialization.OptOut)]
  public partial class PurchasedObjectIDsAfterSearch
  {

    /// <summary>
    /// Gets or Sets EventType
    /// </summary>
    [DataMember(Name = "eventType", IsRequired = true, EmitDefaultValue = false)]
    public ConversionEvent EventType { get; set; }

    /// <summary>
    /// Gets or Sets EventSubtype
    /// </summary>
    [DataMember(Name = "eventSubtype", IsRequired = true, EmitDefaultValue = false)]
    public PurchaseEvent EventSubtype { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="PurchasedObjectIDsAfterSearch" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public PurchasedObjectIDsAfterSearch() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="PurchasedObjectIDsAfterSearch" /> class.
    /// </summary>
    /// <param name="eventName">The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  (required).</param>
    /// <param name="eventType">eventType (required).</param>
    /// <param name="eventSubtype">eventSubtype (required).</param>
    /// <param name="index">The name of an Algolia index. (required).</param>
    /// <param name="objectIDs">The object IDs of the records that are part of the event. (required).</param>
    /// <param name="userToken">An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens.  (required).</param>
    public PurchasedObjectIDsAfterSearch(string eventName, ConversionEvent eventType, PurchaseEvent eventSubtype, string index, List<string> objectIDs, string userToken)
    {
      this.EventName = eventName ?? throw new ArgumentNullException("eventName is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.EventType = eventType;
      this.EventSubtype = eventSubtype;
      this.Index = index ?? throw new ArgumentNullException("index is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.ObjectIDs = objectIDs ?? throw new ArgumentNullException("objectIDs is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
      this.UserToken = userToken ?? throw new ArgumentNullException("userToken is a required property for PurchasedObjectIDsAfterSearch and cannot be null");
    }

    /// <summary>
    /// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
    /// </summary>
    /// <value>The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment&#39;s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. </value>
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
    /// An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens. 
    /// </summary>
    /// <value>An anonymous or pseudonymous user identifier.  &gt; **Note**: Never include personally identifiable information in user tokens. </value>
    [DataMember(Name = "userToken", IsRequired = true, EmitDefaultValue = false)]
    public string UserToken { get; set; }

    /// <summary>
    /// An identifier for authenticated users.  &gt; **Note**: Never include personally identifiable information in user tokens. 
    /// </summary>
    /// <value>An identifier for authenticated users.  &gt; **Note**: Never include personally identifiable information in user tokens. </value>
    [DataMember(Name = "authenticatedUserToken", EmitDefaultValue = false)]
    public string AuthenticatedUserToken { get; set; }

    /// <summary>
    /// Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
    /// </summary>
    /// <value>Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).</value>
    [DataMember(Name = "currency", EmitDefaultValue = false)]
    public string Currency { get; set; }

    /// <summary>
    /// Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as &#x60;objectIDs&#x60;. 
    /// </summary>
    /// <value>Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as &#x60;objectIDs&#x60;. </value>
    [DataMember(Name = "objectData", EmitDefaultValue = false)]
    public List<ObjectDataAfterSearch> ObjectData { get; set; }

    /// <summary>
    /// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. 
    /// </summary>
    /// <value>The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. </value>
    [DataMember(Name = "timestamp", EmitDefaultValue = false)]
    public long Timestamp { get; set; }

    /// <summary>
    /// Gets or Sets Value
    /// </summary>
    [DataMember(Name = "value", EmitDefaultValue = false)]
    public Value Value { get; set; }

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
      sb.Append("  ObjectIDs: ").Append(ObjectIDs).Append("\n");
      sb.Append("  UserToken: ").Append(UserToken).Append("\n");
      sb.Append("  AuthenticatedUserToken: ").Append(AuthenticatedUserToken).Append("\n");
      sb.Append("  Currency: ").Append(Currency).Append("\n");
      sb.Append("  ObjectData: ").Append(ObjectData).Append("\n");
      sb.Append("  Timestamp: ").Append(Timestamp).Append("\n");
      sb.Append("  Value: ").Append(Value).Append("\n");
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

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Use this event to track when users make a purchase after a previous Algolia request. If you&#39;re building your category pages with Algolia, you&#39;ll also use this event.
@objcMembers public class PurchasedObjectIDsAfterSearch: NSObject, Codable, JSONEncodable {

  static let eventNameRule = StringRule(minLength: 1, maxLength: 64, pattern: "[\\x20-\\x7E]{1,64}")
  static let queryIDRule = StringRule(minLength: 32, maxLength: 32, pattern: "[0-9a-f]{32}")
  static let userTokenRule = StringRule(
    minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
  /** Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  public var eventName: String
  public var eventType: ConversionEvent
  public var eventSubtype: PurchaseEvent
  /** Name of the Algolia index. */
  public var index: String
  /** Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.  */
  public var queryID: String
  /** List of object identifiers for items of an Algolia index. */
  public var objectIDs: [String]
  /** Extra information about the records involved in the event—for example, to add price and quantities of purchased products.  If provided, must be the same length as `objectIDs`.  */
  public var objectData: [ObjectDataAfterSearch]?
  /** If you include pricing information in the `objectData` parameter, you must also specify the currency as ISO-4217 currency code, such as USD or EUR. */
  public var currency: String?
  /** Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens.  */
  public var userToken: String
  /** Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.  */
  public var timestamp: Int64?
  public var timestampNum: NSNumber? {
    return timestamp as NSNumber?
  }
  /** User token for authenticated users. */
  public var authenticatedUserToken: String?

  public init(
    eventName: String, eventType: ConversionEvent, eventSubtype: PurchaseEvent, index: String,
    queryID: String, objectIDs: [String], objectData: [ObjectDataAfterSearch]? = nil,
    currency: String? = nil, userToken: String, timestamp: Int64? = nil,
    authenticatedUserToken: String? = nil
  ) {
    self.eventName = eventName
    self.eventType = eventType
    self.eventSubtype = eventSubtype
    self.index = index
    self.queryID = queryID
    self.objectIDs = objectIDs
    self.objectData = objectData
    self.currency = currency
    self.userToken = userToken
    self.timestamp = timestamp
    self.authenticatedUserToken = authenticatedUserToken
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case eventName
    case eventType
    case eventSubtype
    case index
    case queryID
    case objectIDs
    case objectData
    case currency
    case userToken
    case timestamp
    case authenticatedUserToken
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(eventName, forKey: .eventName)
    try container.encode(eventType, forKey: .eventType)
    try container.encode(eventSubtype, forKey: .eventSubtype)
    try container.encode(index, forKey: .index)
    try container.encode(queryID, forKey: .queryID)
    try container.encode(objectIDs, forKey: .objectIDs)
    try container.encodeIfPresent(objectData, forKey: .objectData)
    try container.encodeIfPresent(currency, forKey: .currency)
    try container.encode(userToken, forKey: .userToken)
    try container.encodeIfPresent(timestamp, forKey: .timestamp)
    try container.encodeIfPresent(authenticatedUserToken, forKey: .authenticatedUserToken)
  }
}

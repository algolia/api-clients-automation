// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Use this event to track when users add items to their shopping cart unrelated to a previous Algolia request. For example, if you don&#39;t use Algolia to build your category pages, use this event.  To track add-to-cart events related to Algolia requests, use the \&quot;Added to cart object IDs after search\&quot; event.
public struct AddedToCartObjectIDs: Codable, JSONEncodable, Hashable {

  static let eventNameRule = StringRule(minLength: 1, maxLength: 64, pattern: "[\\x20-\\x7E]{1,64}")
  static let userTokenRule = StringRule(
    minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
  static let authenticatedUserTokenRule = StringRule(
    minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
  /** The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  public var eventName: String
  public var eventType: ConversionEvent
  public var eventSubtype: AddToCartEvent
  /** The name of an Algolia index. */
  public var index: String
  /** The object IDs of the records that are part of the event. */
  public var objectIDs: [String]
  /** An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.  */
  public var userToken: String
  /** An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.  */
  public var authenticatedUserToken: String?
  /** Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html). */
  public var currency: String?
  /** Extra information about the records involved in a purchase or add-to-cart event.  If specified, it must have the same length as `objectIDs`.  */
  public var objectData: [ObjectData]?
  /** The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.  */
  public var timestamp: Int64?
  public var value: Value?

  public init(
    eventName: String, eventType: ConversionEvent, eventSubtype: AddToCartEvent, index: String,
    objectIDs: [String], userToken: String, authenticatedUserToken: String? = nil,
    currency: String? = nil, objectData: [ObjectData]? = nil, timestamp: Int64? = nil,
    value: Value? = nil
  ) {
    self.eventName = eventName
    self.eventType = eventType
    self.eventSubtype = eventSubtype
    self.index = index
    self.objectIDs = objectIDs
    self.userToken = userToken
    self.authenticatedUserToken = authenticatedUserToken
    self.currency = currency
    self.objectData = objectData
    self.timestamp = timestamp
    self.value = value
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case eventName
    case eventType
    case eventSubtype
    case index
    case objectIDs
    case userToken
    case authenticatedUserToken
    case currency
    case objectData
    case timestamp
    case value
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(eventName, forKey: .eventName)
    try container.encode(eventType, forKey: .eventType)
    try container.encode(eventSubtype, forKey: .eventSubtype)
    try container.encode(index, forKey: .index)
    try container.encode(objectIDs, forKey: .objectIDs)
    try container.encode(userToken, forKey: .userToken)
    try container.encodeIfPresent(authenticatedUserToken, forKey: .authenticatedUserToken)
    try container.encodeIfPresent(currency, forKey: .currency)
    try container.encodeIfPresent(objectData, forKey: .objectData)
    try container.encodeIfPresent(timestamp, forKey: .timestamp)
    try container.encodeIfPresent(value, forKey: .value)
  }
}

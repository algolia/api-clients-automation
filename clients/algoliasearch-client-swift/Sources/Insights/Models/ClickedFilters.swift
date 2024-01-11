// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Use this event to track when users click facet filters in your user interface.
@objcMembers public class ClickedFilters: NSObject, Codable, JSONEncodable {

  static let eventNameRule = StringRule(minLength: 1, maxLength: 64, pattern: "[\\x20-\\x7E]{1,64}")
  static let userTokenRule = StringRule(
    minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
  /** Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.  */
  public var eventName: String
  public var eventType: ClickEvent
  /** Name of the Algolia index. */
  public var index: String
  /** Facet filters.  Each facet filter string must be URL-encoded, such as, `discount:10%25`.  */
  public var filters: [String]
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
    eventName: String, eventType: ClickEvent, index: String, filters: [String], userToken: String,
    timestamp: Int64? = nil, authenticatedUserToken: String? = nil
  ) {
    self.eventName = eventName
    self.eventType = eventType
    self.index = index
    self.filters = filters
    self.userToken = userToken
    self.timestamp = timestamp
    self.authenticatedUserToken = authenticatedUserToken
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case eventName
    case eventType
    case index
    case filters
    case userToken
    case timestamp
    case authenticatedUserToken
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(eventName, forKey: .eventName)
    try container.encode(eventType, forKey: .eventType)
    try container.encode(index, forKey: .index)
    try container.encode(filters, forKey: .filters)
    try container.encode(userToken, forKey: .userToken)
    try container.encodeIfPresent(timestamp, forKey: .timestamp)
    try container.encodeIfPresent(authenticatedUserToken, forKey: .authenticatedUserToken)
  }
}

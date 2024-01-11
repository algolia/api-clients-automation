// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// The response of the Insights API.
@objcMembers public class EventsResponse: NSObject, Codable, JSONEncodable {

  /** Details about the response, such as error messages. */
  public var message: String?
  /** The HTTP status code of the response. */
  public var status: Int?
  public var statusNum: NSNumber? {
    return status as NSNumber?
  }

  public init(message: String? = nil, status: Int? = nil) {
    self.message = message
    self.status = status
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case message
    case status
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(message, forKey: .message)
    try container.encodeIfPresent(status, forKey: .status)
  }
}

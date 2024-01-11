// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class SourceUpdateResponse: NSObject, Codable, JSONEncodable {

  /** The source UUID. */
  public var sourceID: String
  public var name: String
  /** Date of last update (RFC3339 format). */
  public var updatedAt: String

  public init(sourceID: String, name: String, updatedAt: String) {
    self.sourceID = sourceID
    self.name = name
    self.updatedAt = updatedAt
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case sourceID
    case name
    case updatedAt
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(sourceID, forKey: .sourceID)
    try container.encode(name, forKey: .name)
    try container.encode(updatedAt, forKey: .updatedAt)
  }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class TopHit: NSObject, Codable, JSONEncodable {

  /** Hit. */
  public var hit: String
  /** Number of occurrences. */
  public var count: Int

  public init(hit: String, count: Int) {
    self.hit = hit
    self.count = count
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case hit
    case count
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(hit, forKey: .hit)
    try container.encode(count, forKey: .count)
  }
}

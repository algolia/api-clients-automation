// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct AddABTestsRequest: Codable, JSONEncodable, Hashable {

  /** A/B test name. */
  public var name: String
  /** A/B test variants. */
  public var variants: [AddABTestsVariant]
  /** End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. */
  public var endAt: String

  public init(name: String, variants: [AddABTestsVariant], endAt: String) {
    self.name = name
    self.variants = variants
    self.endAt = endAt
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case name
    case variants
    case endAt
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(name, forKey: .name)
    try container.encode(variants, forKey: .variants)
    try container.encode(endAt, forKey: .endAt)
  }
}

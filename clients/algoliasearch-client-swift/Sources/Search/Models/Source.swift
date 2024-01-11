// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Source.
@objcMembers public class Source: NSObject, Codable, JSONEncodable {

  /** IP address range of the source. */
  public var source: String
  /** Source description. */
  public var _description: String?

  public init(source: String, _description: String? = nil) {
    self.source = source
    self._description = _description
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case source
    case _description = "description"
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(source, forKey: .source)
    try container.encodeIfPresent(_description, forKey: ._description)
  }
}

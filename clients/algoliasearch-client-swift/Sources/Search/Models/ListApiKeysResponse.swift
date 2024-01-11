// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class ListApiKeysResponse: NSObject, Codable, JSONEncodable {

  /** API keys. */
  public var keys: [GetApiKeyResponse]

  public init(keys: [GetApiKeyResponse]) {
    self.keys = keys
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case keys
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(keys, forKey: .keys)
  }
}

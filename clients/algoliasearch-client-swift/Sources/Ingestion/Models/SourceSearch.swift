// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class SourceSearch: NSObject, Codable, JSONEncodable {

  public var sourceIDs: [String]

  public init(sourceIDs: [String]) {
    self.sourceIDs = sourceIDs
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case sourceIDs
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(sourceIDs, forKey: .sourceIDs)
  }
}

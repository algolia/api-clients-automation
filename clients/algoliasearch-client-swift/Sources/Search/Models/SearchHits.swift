// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class SearchHits: NSObject, Codable, JSONEncodable {

  public var hits: [Hit]
  /** Text to search for in an index. */
  public var query: String = ""
  /** URL-encoded string of all search parameters. */
  public var params: String

  public init(hits: [Hit], query: String = "", params: String) {
    self.hits = hits
    self.query = query
    self.params = params
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case hits
    case query
    case params
  }

  public var additionalProperties: [String: AnyCodable] = [:]

  public subscript(key: String) -> AnyCodable? {
    get {
      if let value = additionalProperties[key] {
        return value
      }
      return nil
    }

    set {
      additionalProperties[key] = newValue
    }
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(hits, forKey: .hits)
    try container.encode(query, forKey: .query)
    try container.encode(params, forKey: .params)
    var additionalPropertiesContainer = encoder.container(keyedBy: String.self)
    try additionalPropertiesContainer.encodeMap(additionalProperties)
  }

  // Decodable protocol methods

  public required init(from decoder: Decoder) throws {
    let container = try decoder.container(keyedBy: CodingKeys.self)

    hits = try container.decode([Hit].self, forKey: .hits)
    query = try container.decode(String.self, forKey: .query)
    params = try container.decode(String.self, forKey: .params)
    var nonAdditionalPropertyKeys = Set<String>()
    nonAdditionalPropertyKeys.insert("hits")
    nonAdditionalPropertyKeys.insert("query")
    nonAdditionalPropertyKeys.insert("params")
    let additionalPropertiesContainer = try decoder.container(keyedBy: String.self)
    additionalProperties = try additionalPropertiesContainer.decodeMap(
      AnyCodable.self, excludedKeys: nonAdditionalPropertyKeys)
  }
}

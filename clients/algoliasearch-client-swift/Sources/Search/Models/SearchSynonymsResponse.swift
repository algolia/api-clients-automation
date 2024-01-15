// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct SearchSynonymsResponse: Codable, JSONEncodable, Hashable {

  /** Synonym objects. */
  public var hits: [SynonymHit]
  /** Number of hits the search query matched. */
  public var nbHits: Int

  public init(hits: [SynonymHit], nbHits: Int) {
    self.hits = hits
    self.nbHits = nbHits
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case hits
    case nbHits
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
    try container.encode(nbHits, forKey: .nbHits)
    var additionalPropertiesContainer = encoder.container(keyedBy: String.self)
    try additionalPropertiesContainer.encodeMap(additionalProperties)
  }

  // Decodable protocol methods

  public init(from decoder: Decoder) throws {
    let container = try decoder.container(keyedBy: CodingKeys.self)

    hits = try container.decode([SynonymHit].self, forKey: .hits)
    nbHits = try container.decode(Int.self, forKey: .nbHits)
    var nonAdditionalPropertyKeys = Set<String>()
    nonAdditionalPropertyKeys.insert("hits")
    nonAdditionalPropertyKeys.insert("nbHits")
    let additionalPropertiesContainer = try decoder.container(keyedBy: String.self)
    additionalProperties = try additionalPropertiesContainer.decodeMap(
      AnyCodable.self, excludedKeys: nonAdditionalPropertyKeys)
  }
}

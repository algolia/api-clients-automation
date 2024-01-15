// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Custom entries for a dictionary.
public struct DictionaryLanguage: Codable, JSONEncodable, Hashable {

  /** If `0`, the dictionary hasn't been customized and only contains standard entries provided by Algolia. If `null`, that feature isn't available or isn't supported for that language.  */
  public var nbCustomEntries: Int?

  public init(nbCustomEntries: Int? = nil) {
    self.nbCustomEntries = nbCustomEntries
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case nbCustomEntries
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(nbCustomEntries, forKey: .nbCustomEntries)
  }
}

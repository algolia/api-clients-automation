// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Names of facets to which automatic filtering must be applied; they must match the facet name of a facet value placeholder in the query pattern.
public enum AutomaticFacetFilters: Codable, JSONEncodable, Hashable {
  case arrayOfAutomaticFacetFilter([AutomaticFacetFilter])
  case arrayOfString([String])

  public func encode(to encoder: Encoder) throws {
    var container = encoder.singleValueContainer()
    switch self {
    case .arrayOfAutomaticFacetFilter(let value):
      try container.encode(value)
    case .arrayOfString(let value):
      try container.encode(value)
    }
  }

  public init(from decoder: Decoder) throws {
    let container = try decoder.singleValueContainer()
    if let value = try? container.decode([AutomaticFacetFilter].self) {
      self = .arrayOfAutomaticFacetFilter(value)
    } else if let value = try? container.decode([String].self) {
      self = .arrayOfString(value)
    } else {
      throw DecodingError.typeMismatch(
        Self.Type.self,
        .init(
          codingPath: decoder.codingPath,
          debugDescription: "Unable to decode instance of AutomaticFacetFilters"))
    }
  }
}

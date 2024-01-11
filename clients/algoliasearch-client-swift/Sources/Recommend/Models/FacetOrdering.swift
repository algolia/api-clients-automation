// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Defines the ordering of facets (widgets).
@objcMembers public class FacetOrdering: NSObject, Codable, JSONEncodable {

  public var facets: Facets?
  /** Ordering of facet values within an individual facet. */
  public var values: [String: Value]?

  public init(facets: Facets? = nil, values: [String: Value]? = nil) {
    self.facets = facets
    self.values = values
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case facets
    case values
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(facets, forKey: .facets)
    try container.encodeIfPresent(values, forKey: .values)
  }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Additional search parameters.
public struct Params: Codable, JSONEncodable, Hashable {

  public var query: ConsequenceQuery?
  public var automaticFacetFilters: AutomaticFacetFilters?
  public var automaticOptionalFacetFilters: AutomaticFacetFilters?
  public var renderingContent: RenderingContent?

  public init(
    query: ConsequenceQuery? = nil, automaticFacetFilters: AutomaticFacetFilters? = nil,
    automaticOptionalFacetFilters: AutomaticFacetFilters? = nil,
    renderingContent: RenderingContent? = nil
  ) {
    self.query = query
    self.automaticFacetFilters = automaticFacetFilters
    self.automaticOptionalFacetFilters = automaticOptionalFacetFilters
    self.renderingContent = renderingContent
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case query
    case automaticFacetFilters
    case automaticOptionalFacetFilters
    case renderingContent
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(query, forKey: .query)
    try container.encodeIfPresent(automaticFacetFilters, forKey: .automaticFacetFilters)
    try container.encodeIfPresent(
      automaticOptionalFacetFilters, forKey: .automaticOptionalFacetFilters)
    try container.encodeIfPresent(renderingContent, forKey: .renderingContent)
  }
}

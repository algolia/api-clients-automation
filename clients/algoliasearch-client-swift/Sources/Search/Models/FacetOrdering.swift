// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Order of facet names and facet values in your UI.
public struct FacetOrdering: Codable, JSONEncodable, Hashable {
    public var facets: Facets?
    /// Order of facet values. One object for each facet.
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
        try container.encodeIfPresent(self.facets, forKey: .facets)
        try container.encodeIfPresent(self.values, forKey: .values)
    }
}

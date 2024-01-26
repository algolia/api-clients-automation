// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct SearchForFacetValuesRequest: Codable, JSONEncodable, Hashable {
    static let maxFacetHitsRule = NumericRule<Int>(minimum: nil, exclusiveMinimum: false, maximum: 100, exclusiveMaximum: false, multipleOf: nil)
    /** Search parameters as a URL-encoded query string. */
    public var params: String?
    /** Text to search inside the facet's values. */
    public var facetQuery: String?
    /** Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values). */
    public var maxFacetHits: Int?

    public init(params: String? = nil, facetQuery: String? = nil, maxFacetHits: Int? = nil) {
        self.params = params
        self.facetQuery = facetQuery
        self.maxFacetHits = maxFacetHits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case params
        case facetQuery
        case maxFacetHits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(params, forKey: .params)
        try container.encodeIfPresent(facetQuery, forKey: .facetQuery)
        try container.encodeIfPresent(maxFacetHits, forKey: .maxFacetHits)
    }
}

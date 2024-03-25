// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Trending facet hit.
public struct TrendingFacetHit: Codable, JSONEncodable {
    /// Recommendation score.
    public var score: Double
    /// Facet name for trending models.
    public var facetName: String
    /// Facet value for trending models.
    public var facetValue: String

    public init(score: Double, facetName: String, facetValue: String) {
        self.score = score
        self.facetName = facetName
        self.facetValue = facetValue
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case score = "_score"
        case facetName
        case facetValue
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.score, forKey: .score)
        try container.encode(self.facetName, forKey: .facetName)
        try container.encode(self.facetValue, forKey: .facetValue)
    }
}

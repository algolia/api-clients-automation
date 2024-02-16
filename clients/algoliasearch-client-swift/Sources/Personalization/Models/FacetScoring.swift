// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct FacetScoring: Codable, JSONEncodable, Hashable {
    /// The score for the event.
    public var score: Int
    /// The name of the facet.
    public var facetName: String

    public init(score: Int, facetName: String) {
        self.score = score
        self.facetName = facetName
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case score
        case facetName
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.score, forKey: .score)
        try container.encode(self.facetName, forKey: .facetName)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - BaseTrendingFacetsQuery

public struct BaseTrendingFacetsQuery: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(facetName: String, model: TrendingFacetsModel? = nil) {
        self.facetName = facetName
        self.model = model
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case facetName
        case model
    }

    /// Facet name for trending models.
    public var facetName: String
    public var model: TrendingFacetsModel?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.facetName, forKey: .facetName)
        try container.encodeIfPresent(self.model, forKey: .model)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TrendingFacets: Codable, JSONEncodable {
    /// Facet attribute for which to retrieve trending facet values.
    public var facetName: String
    public var model: TrendingFacetsModel
    public var fallbackParameters: FallbackParams?

    public init(facetName: String, model: TrendingFacetsModel, fallbackParameters: FallbackParams? = nil) {
        self.facetName = facetName
        self.model = model
        self.fallbackParameters = fallbackParameters
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case facetName
        case model
        case fallbackParameters
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.facetName, forKey: .facetName)
        try container.encode(self.model, forKey: .model)
        try container.encodeIfPresent(self.fallbackParameters, forKey: .fallbackParameters)
    }
}

extension TrendingFacets: Equatable {
    public static func ==(lhs: TrendingFacets, rhs: TrendingFacets) -> Bool {
        lhs.facetName == rhs.facetName &&
            lhs.model == rhs.model &&
            lhs.fallbackParameters == rhs.fallbackParameters
    }
}

extension TrendingFacets: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.facetName.hashValue)
        hasher.combine(self.model.hashValue)
        hasher.combine(self.fallbackParameters?.hashValue)
    }
}

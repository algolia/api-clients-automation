// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct BaseTrendingItemsQuery: Codable, JSONEncodable, Hashable {
    /// Facet name for trending models.
    public var facetName: String?
    /// Facet value for trending models.
    public var facetValue: String?
    public var model: TrendingItemsModel?
    public var queryParameters: RecommendSearchParamsObject?
    public var fallbackParameters: RecommendSearchParamsObject?

    public init(
        facetName: String? = nil,
        facetValue: String? = nil,
        model: TrendingItemsModel? = nil,
        queryParameters: RecommendSearchParamsObject? = nil,
        fallbackParameters: RecommendSearchParamsObject? = nil
    ) {
        self.facetName = facetName
        self.facetValue = facetValue
        self.model = model
        self.queryParameters = queryParameters
        self.fallbackParameters = fallbackParameters
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case facetName
        case facetValue
        case model
        case queryParameters
        case fallbackParameters
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.facetName, forKey: .facetName)
        try container.encodeIfPresent(self.facetValue, forKey: .facetValue)
        try container.encodeIfPresent(self.model, forKey: .model)
        try container.encodeIfPresent(self.queryParameters, forKey: .queryParameters)
        try container.encodeIfPresent(self.fallbackParameters, forKey: .fallbackParameters)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum RecommendationsRequest: Codable, JSONEncodable, AbstractEncodable {
    case boughtTogetherQuery(BoughtTogetherQuery)
    case relatedQuery(RelatedQuery)
    case trendingItemsQuery(TrendingItemsQuery)
    case trendingFacetsQuery(TrendingFacetsQuery)
    case lookingSimilarQuery(LookingSimilarQuery)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .boughtTogetherQuery(value):
            try container.encode(value)
        case let .relatedQuery(value):
            try container.encode(value)
        case let .trendingItemsQuery(value):
            try container.encode(value)
        case let .trendingFacetsQuery(value):
            try container.encode(value)
        case let .lookingSimilarQuery(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(BoughtTogetherQuery.self) {
            self = .boughtTogetherQuery(value)
        } else if let value = try? container.decode(RelatedQuery.self) {
            self = .relatedQuery(value)
        } else if let value = try? container.decode(TrendingItemsQuery.self) {
            self = .trendingItemsQuery(value)
        } else if let value = try? container.decode(TrendingFacetsQuery.self) {
            self = .trendingFacetsQuery(value)
        } else if let value = try? container.decode(LookingSimilarQuery.self) {
            self = .lookingSimilarQuery(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of RecommendationsRequest"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .boughtTogetherQuery(value):
            value as BoughtTogetherQuery
        case let .relatedQuery(value):
            value as RelatedQuery
        case let .trendingItemsQuery(value):
            value as TrendingItemsQuery
        case let .trendingFacetsQuery(value):
            value as TrendingFacetsQuery
        case let .lookingSimilarQuery(value):
            value as LookingSimilarQuery
        }
    }
}

extension RecommendationsRequest: Equatable {}
extension RecommendationsRequest: Hashable {}

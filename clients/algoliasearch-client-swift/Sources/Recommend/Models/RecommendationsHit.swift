// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public enum RecommendationsHit: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case recommendHit(RecommendHit)
    case trendingFacetHit(TrendingFacetHit)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .recommendHit(value):
            try container.encode(value)
        case let .trendingFacetHit(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(RecommendHit.self) {
            self = .recommendHit(value)
        } else if let value = try? container.decode(TrendingFacetHit.self) {
            self = .trendingFacetHit(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of RecommendationsHit"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .recommendHit(value):
            value as RecommendHit
        case let .trendingFacetHit(value):
            value as TrendingFacetHit
        }
    }
}

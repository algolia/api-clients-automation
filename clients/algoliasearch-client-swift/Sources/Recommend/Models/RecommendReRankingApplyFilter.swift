// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Restrict [Dynamic Re-ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) to records that match these
/// filters.
public enum RecommendReRankingApplyFilter: Codable, JSONEncodable, AbstractEncodable {
    case arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters])
    case string(String)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .arrayOfRecommendMixedSearchFilters(value):
            try container.encode(value)
        case let .string(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode([RecommendMixedSearchFilters].self) {
            self = .arrayOfRecommendMixedSearchFilters(value)
        } else if let value = try? container.decode(String.self) {
            self = .string(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of RecommendReRankingApplyFilter"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .arrayOfRecommendMixedSearchFilters(value):
            value as [RecommendMixedSearchFilters]
        case let .string(value):
            value as String
        }
    }
}

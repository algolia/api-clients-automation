// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - Personalization

public struct Personalization: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(filtersScore: Int? = nil, rankingScore: Int? = nil, score: Int? = nil) {
        self.filtersScore = filtersScore
        self.rankingScore = rankingScore
        self.score = score
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case filtersScore
        case rankingScore
        case score
    }

    /// The score of the filters.
    public var filtersScore: Int?
    /// The score of the ranking.
    public var rankingScore: Int?
    /// The score of the event.
    public var score: Int?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.filtersScore, forKey: .filtersScore)
        try container.encodeIfPresent(self.rankingScore, forKey: .rankingScore)
        try container.encodeIfPresent(self.score, forKey: .score)
    }
}

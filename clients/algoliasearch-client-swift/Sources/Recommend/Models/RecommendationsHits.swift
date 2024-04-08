// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct RecommendationsHits: Codable, JSONEncodable {
    public var hits: [RecommendationsHit]

    public init(hits: [RecommendationsHit]) {
        self.hits = hits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hits, forKey: .hits)
    }
}

extension RecommendationsHits: Equatable {
    public static func ==(lhs: RecommendationsHits, rhs: RecommendationsHits) -> Bool {
        lhs.hits == rhs.hits
    }
}

extension RecommendationsHits: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.hits.hashValue)
    }
}

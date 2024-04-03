// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TopHit: Codable, JSONEncodable {
    /// Object ID of a record that's returned as a search result.
    public var hit: String
    /// Number of occurrences.
    public var count: Int

    public init(hit: String, count: Int) {
        self.hit = hit
        self.count = count
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hit
        case count
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hit, forKey: .hit)
        try container.encode(self.count, forKey: .count)
    }
}

extension TopHit: Equatable {
    public static func ==(lhs: TopHit, rhs: TopHit) -> Bool {
        lhs.hit == rhs.hit &&
            lhs.count == rhs.count
    }
}

extension TopHit: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.hit.hashValue)
        hasher.combine(self.count.hashValue)
    }
}

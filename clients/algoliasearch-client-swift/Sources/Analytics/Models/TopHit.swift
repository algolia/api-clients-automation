// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct TopHit: Codable, JSONEncodable, Hashable {
    /// Hit.
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

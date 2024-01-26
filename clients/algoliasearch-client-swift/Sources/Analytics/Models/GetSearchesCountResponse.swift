// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct GetSearchesCountResponse: Codable, JSONEncodable, Hashable {
    /** Number of occurrences. */
    public var count: Int
    /** Search events with their associated dates and hit counts. */
    public var dates: [SearchEvent]

    public init(count: Int, dates: [SearchEvent]) {
        self.count = count
        self.dates = dates
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case count
        case dates
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(count, forKey: .count)
        try container.encode(dates, forKey: .dates)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct GetNoResultsRateResponse: Codable, JSONEncodable, Hashable {
    static let rateRule = NumericRule<Double>(
        minimum: 0,
        exclusiveMinimum: false,
        maximum: 1,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    /// [Click-through rate
    /// (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
    public var rate: Double
    /// Number of occurrences.
    public var count: Int
    /// Number of occurrences.
    public var noResultCount: Int
    /// Overall count of searches without results plus a daily breakdown.
    public var dates: [NoResultsRateEvent]

    public init(rate: Double, count: Int, noResultCount: Int, dates: [NoResultsRateEvent]) {
        self.rate = rate
        self.count = count
        self.noResultCount = noResultCount
        self.dates = dates
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case rate
        case count
        case noResultCount
        case dates
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.rate, forKey: .rate)
        try container.encode(self.count, forKey: .count)
        try container.encode(self.noResultCount, forKey: .noResultCount)
        try container.encode(self.dates, forKey: .dates)
    }
}

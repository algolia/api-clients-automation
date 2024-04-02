// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct DailyNoResultsRates: Codable, JSONEncodable {
    /// Date in the format YYYY-MM-DD.
    public var date: String
    /// Number of searches without any results.
    public var noResultCount: Int
    /// Number of searches.
    public var count: Int
    /// No results rate, calculated as number of searches with zero results divided by the total number of searches.
    public var rate: Double

    public init(date: String, noResultCount: Int, count: Int, rate: Double) {
        self.date = date
        self.noResultCount = noResultCount
        self.count = count
        self.rate = rate
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case date
        case noResultCount
        case count
        case rate
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.date, forKey: .date)
        try container.encode(self.noResultCount, forKey: .noResultCount)
        try container.encode(self.count, forKey: .count)
        try container.encode(self.rate, forKey: .rate)
    }
}

extension DailyNoResultsRates: Equatable {
    public static func ==(lhs: DailyNoResultsRates, rhs: DailyNoResultsRates) -> Bool {
        lhs.date == rhs.date &&
            lhs.noResultCount == rhs.noResultCount &&
            lhs.count == rhs.count &&
            lhs.rate == rhs.rate
    }
}

extension DailyNoResultsRates: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.date.hashValue)
        hasher.combine(self.noResultCount.hashValue)
        hasher.combine(self.count.hashValue)
        hasher.combine(self.rate.hashValue)
    }
}

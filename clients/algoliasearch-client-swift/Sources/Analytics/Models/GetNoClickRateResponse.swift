// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetNoClickRateResponse: Codable, JSONEncodable {
    /// No click rate, calculated as number of tracked searches without any click divided by the number of tracked
    /// searches.
    public var rate: Double
    /// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
    public var count: Int
    /// Number of times this search was returned as a result without any click.
    public var noClickCount: Int
    /// Daily no click rates.
    public var dates: [DailyNoClickRates]

    public init(rate: Double, count: Int, noClickCount: Int, dates: [DailyNoClickRates]) {
        self.rate = rate
        self.count = count
        self.noClickCount = noClickCount
        self.dates = dates
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case rate
        case count
        case noClickCount
        case dates
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.rate, forKey: .rate)
        try container.encode(self.count, forKey: .count)
        try container.encode(self.noClickCount, forKey: .noClickCount)
        try container.encode(self.dates, forKey: .dates)
    }
}

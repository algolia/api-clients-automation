// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct GetConversationRateResponse: Codable, JSONEncodable, Hashable {
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
    /// Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is
    /// `true`.
    public var trackedSearchCount: Int?
    /// Number of converted clicks.
    public var conversionCount: Int
    /// Conversion events.
    public var dates: [ConversionRateEvent]

    public init(rate: Double, trackedSearchCount: Int?, conversionCount: Int, dates: [ConversionRateEvent]) {
        self.rate = rate
        self.trackedSearchCount = trackedSearchCount
        self.conversionCount = conversionCount
        self.dates = dates
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case rate
        case trackedSearchCount
        case conversionCount
        case dates
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.rate, forKey: .rate)
        try container.encode(self.trackedSearchCount, forKey: .trackedSearchCount)
        try container.encode(self.conversionCount, forKey: .conversionCount)
        try container.encode(self.dates, forKey: .dates)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct TopSearchWithAnalytics: Codable, JSONEncodable, Hashable {
    static let clickThroughRateRule = NumericRule<Double>(minimum: 0, exclusiveMinimum: false, maximum: 1, exclusiveMaximum: false, multipleOf: nil)
    /** User query. */
    public var search: String
    /** Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`). */
    public var count: Int
    /** [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  */
    public var clickThroughRate: Double
    /** Average [position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) of clicked search result. */
    public var averageClickPosition: Int
    /** [Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).  */
    public var conversionRate: Double
    /** Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`. */
    public var trackedSearchCount: Int
    /** Number of click events. */
    public var clickCount: Int
    /** Number of converted clicks. */
    public var conversionCount: Int
    /** Number of hits the search query matched. */
    public var nbHits: Int

    public init(search: String, count: Int, clickThroughRate: Double, averageClickPosition: Int, conversionRate: Double, trackedSearchCount: Int, clickCount: Int, conversionCount: Int, nbHits: Int) {
        self.search = search
        self.count = count
        self.clickThroughRate = clickThroughRate
        self.averageClickPosition = averageClickPosition
        self.conversionRate = conversionRate
        self.trackedSearchCount = trackedSearchCount
        self.clickCount = clickCount
        self.conversionCount = conversionCount
        self.nbHits = nbHits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case search
        case count
        case clickThroughRate
        case averageClickPosition
        case conversionRate
        case trackedSearchCount
        case clickCount
        case conversionCount
        case nbHits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(search, forKey: .search)
        try container.encode(count, forKey: .count)
        try container.encode(clickThroughRate, forKey: .clickThroughRate)
        try container.encode(averageClickPosition, forKey: .averageClickPosition)
        try container.encode(conversionRate, forKey: .conversionRate)
        try container.encode(trackedSearchCount, forKey: .trackedSearchCount)
        try container.encode(clickCount, forKey: .clickCount)
        try container.encode(conversionCount, forKey: .conversionCount)
        try container.encode(nbHits, forKey: .nbHits)
    }
}

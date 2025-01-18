// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TopSearchWithAnalytics: Codable, JSONEncodable {
    /// Search query.
    public var search: String
    /// Number of searches.
    public var count: Int
    /// Click-through rate: calculated as the number of tracked searches with at least one click event divided by the
    /// number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to
    /// true.
    public var clickThroughRate: Double?
    /// Average position of a clicked search result in the list of search results. If null, Algolia didn't receive any
    /// search requests with `clickAnalytics` set to true.
    public var averageClickPosition: Double?
    /// List of positions in the search results and clicks associated with this search.
    public var clickPositions: [ClickPosition]
    /// Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the
    /// number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to
    /// true.
    public var conversionRate: Double?
    /// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
    public var trackedSearchCount: Int
    /// Number of clicks associated with this search.
    public var clickCount: Int
    /// Number of conversions from this search.
    public var conversionCount: Int
    /// Number of results (hits).
    public var nbHits: Int

    public init(
        search: String,
        count: Int,
        clickThroughRate: Double?,
        averageClickPosition: Double?,
        clickPositions: [ClickPosition],
        conversionRate: Double?,
        trackedSearchCount: Int,
        clickCount: Int,
        conversionCount: Int,
        nbHits: Int
    ) {
        self.search = search
        self.count = count
        self.clickThroughRate = clickThroughRate
        self.averageClickPosition = averageClickPosition
        self.clickPositions = clickPositions
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
        case clickPositions
        case conversionRate
        case trackedSearchCount
        case clickCount
        case conversionCount
        case nbHits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.search, forKey: .search)
        try container.encode(self.count, forKey: .count)
        try container.encode(self.clickThroughRate, forKey: .clickThroughRate)
        try container.encode(self.averageClickPosition, forKey: .averageClickPosition)
        try container.encode(self.clickPositions, forKey: .clickPositions)
        try container.encode(self.conversionRate, forKey: .conversionRate)
        try container.encode(self.trackedSearchCount, forKey: .trackedSearchCount)
        try container.encode(self.clickCount, forKey: .clickCount)
        try container.encode(self.conversionCount, forKey: .conversionCount)
        try container.encode(self.nbHits, forKey: .nbHits)
    }
}

extension TopSearchWithAnalytics: Equatable {
    public static func ==(lhs: TopSearchWithAnalytics, rhs: TopSearchWithAnalytics) -> Bool {
        lhs.search == rhs.search &&
            lhs.count == rhs.count &&
            lhs.clickThroughRate == rhs.clickThroughRate &&
            lhs.averageClickPosition == rhs.averageClickPosition &&
            lhs.clickPositions == rhs.clickPositions &&
            lhs.conversionRate == rhs.conversionRate &&
            lhs.trackedSearchCount == rhs.trackedSearchCount &&
            lhs.clickCount == rhs.clickCount &&
            lhs.conversionCount == rhs.conversionCount &&
            lhs.nbHits == rhs.nbHits
    }
}

extension TopSearchWithAnalytics: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.search.hashValue)
        hasher.combine(self.count.hashValue)
        hasher.combine(self.clickThroughRate.hashValue)
        hasher.combine(self.averageClickPosition.hashValue)
        hasher.combine(self.clickPositions.hashValue)
        hasher.combine(self.conversionRate.hashValue)
        hasher.combine(self.trackedSearchCount.hashValue)
        hasher.combine(self.clickCount.hashValue)
        hasher.combine(self.conversionCount.hashValue)
        hasher.combine(self.nbHits.hashValue)
    }
}

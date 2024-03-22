// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TopSearchWithRevenueAnalytics: Codable, JSONEncodable {
    /// Search query.
    public var search: String
    /// Number of searches.
    public var count: Int
    /// Click-through rate, calculated as number of tracked searches with at least one click event divided by the number
    /// of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
    public var clickThroughRate: Double?
    /// Average position of a clicked search result in the list of search results. If null, Algolia didn't receive any
    /// search requests with `clickAnalytics` set to true.
    public var averageClickPosition: Double?
    /// List of positions in the search results and clicks associated with this search.
    public var clickPositions: [ClickPositionsInner]
    /// Conversion rate, calculated as number of tracked searches with at least one conversion event divided by the
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
    /// Revenue associated with this search, broken-down by currencies.
    public var currencies: [String: CurrenciesValue]
    /// Add-to-cart rate, calculated as number of tracked searches with at least one add-to-cart event divided by the
    /// number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to
    /// true.
    public var addToCartRate: Double?
    /// Number of add-to-cart events from this search.
    public var addToCartCount: Int
    /// Purchase rate, calculated as number of tracked searches with at least one purchase event divided by the number
    /// of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
    public var purchaseRate: Double?
    /// Number of purchase events from this search.
    public var purchaseCount: Int

    public init(
        search: String,
        count: Int,
        clickThroughRate: Double?,
        averageClickPosition: Double?,
        clickPositions: [ClickPositionsInner],
        conversionRate: Double?,
        trackedSearchCount: Int,
        clickCount: Int,
        conversionCount: Int,
        nbHits: Int,
        currencies: [String: CurrenciesValue],
        addToCartRate: Double?,
        addToCartCount: Int,
        purchaseRate: Double?,
        purchaseCount: Int
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
        self.currencies = currencies
        self.addToCartRate = addToCartRate
        self.addToCartCount = addToCartCount
        self.purchaseRate = purchaseRate
        self.purchaseCount = purchaseCount
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
        case currencies
        case addToCartRate
        case addToCartCount
        case purchaseRate
        case purchaseCount
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
        try container.encode(self.currencies, forKey: .currencies)
        try container.encode(self.addToCartRate, forKey: .addToCartRate)
        try container.encode(self.addToCartCount, forKey: .addToCartCount)
        try container.encode(self.purchaseRate, forKey: .purchaseRate)
        try container.encode(self.purchaseCount, forKey: .purchaseCount)
    }
}

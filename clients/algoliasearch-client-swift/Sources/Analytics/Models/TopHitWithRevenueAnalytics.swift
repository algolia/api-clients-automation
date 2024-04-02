// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TopHitWithRevenueAnalytics: Codable, JSONEncodable {
    /// Object ID of a record that's returned as a search result.
    public var hit: String
    /// Number of occurrences.
    public var count: Int
    /// Click-through rate, calculated as number of tracked searches with at least one click event divided by the number
    /// of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
    public var clickThroughRate: Double?
    /// Conversion rate, calculated as number of tracked searches with at least one conversion event divided by the
    /// number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to
    /// true.
    public var conversionRate: Double?
    /// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
    public var trackedHitCount: Int
    /// Number of clicks associated with this search.
    public var clickCount: Int
    /// Number of conversions from this search.
    public var conversionCount: Int
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
    /// Revenue associated with this search, broken-down by currencies.
    public var currencies: [String: CurrenciesValue]

    public init(
        hit: String,
        count: Int,
        clickThroughRate: Double?,
        conversionRate: Double?,
        trackedHitCount: Int,
        clickCount: Int,
        conversionCount: Int,
        addToCartRate: Double?,
        addToCartCount: Int,
        purchaseRate: Double?,
        purchaseCount: Int,
        currencies: [String: CurrenciesValue]
    ) {
        self.hit = hit
        self.count = count
        self.clickThroughRate = clickThroughRate
        self.conversionRate = conversionRate
        self.trackedHitCount = trackedHitCount
        self.clickCount = clickCount
        self.conversionCount = conversionCount
        self.addToCartRate = addToCartRate
        self.addToCartCount = addToCartCount
        self.purchaseRate = purchaseRate
        self.purchaseCount = purchaseCount
        self.currencies = currencies
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hit
        case count
        case clickThroughRate
        case conversionRate
        case trackedHitCount
        case clickCount
        case conversionCount
        case addToCartRate
        case addToCartCount
        case purchaseRate
        case purchaseCount
        case currencies
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hit, forKey: .hit)
        try container.encode(self.count, forKey: .count)
        try container.encode(self.clickThroughRate, forKey: .clickThroughRate)
        try container.encode(self.conversionRate, forKey: .conversionRate)
        try container.encode(self.trackedHitCount, forKey: .trackedHitCount)
        try container.encode(self.clickCount, forKey: .clickCount)
        try container.encode(self.conversionCount, forKey: .conversionCount)
        try container.encode(self.addToCartRate, forKey: .addToCartRate)
        try container.encode(self.addToCartCount, forKey: .addToCartCount)
        try container.encode(self.purchaseRate, forKey: .purchaseRate)
        try container.encode(self.purchaseCount, forKey: .purchaseCount)
        try container.encode(self.currencies, forKey: .currencies)
    }
}

extension TopHitWithRevenueAnalytics: Equatable {
    public static func ==(lhs: TopHitWithRevenueAnalytics, rhs: TopHitWithRevenueAnalytics) -> Bool {
        lhs.hit == rhs.hit &&
            lhs.count == rhs.count &&
            lhs.clickThroughRate == rhs.clickThroughRate &&
            lhs.conversionRate == rhs.conversionRate &&
            lhs.trackedHitCount == rhs.trackedHitCount &&
            lhs.clickCount == rhs.clickCount &&
            lhs.conversionCount == rhs.conversionCount &&
            lhs.addToCartRate == rhs.addToCartRate &&
            lhs.addToCartCount == rhs.addToCartCount &&
            lhs.purchaseRate == rhs.purchaseRate &&
            lhs.purchaseCount == rhs.purchaseCount &&
            lhs.currencies == rhs.currencies
    }
}

extension TopHitWithRevenueAnalytics: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.hit.hashValue)
        hasher.combine(self.count.hashValue)
        hasher.combine(self.clickThroughRate.hashValue)
        hasher.combine(self.conversionRate.hashValue)
        hasher.combine(self.trackedHitCount.hashValue)
        hasher.combine(self.clickCount.hashValue)
        hasher.combine(self.conversionCount.hashValue)
        hasher.combine(self.addToCartRate.hashValue)
        hasher.combine(self.addToCartCount.hashValue)
        hasher.combine(self.purchaseRate.hashValue)
        hasher.combine(self.purchaseCount.hashValue)
        hasher.combine(self.currencies.hashValue)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct CurrenciesValue: Codable, JSONEncodable, Hashable {
    /// Currency code.
    public var currency: String?
    /// Revenue for this currency.
    public var revenue: Double?
    /// Mean for this currency.
    public var mean: Double?
    /// Standard deviation for this currency.
    public var standardDeviation: Double?

    public init(
        currency: String? = nil,
        revenue: Double? = nil,
        mean: Double? = nil,
        standardDeviation: Double? = nil
    ) {
        self.currency = currency
        self.revenue = revenue
        self.mean = mean
        self.standardDeviation = standardDeviation
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case currency
        case revenue
        case mean
        case standardDeviation
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.currency, forKey: .currency)
        try container.encodeIfPresent(self.revenue, forKey: .revenue)
        try container.encodeIfPresent(self.mean, forKey: .mean)
        try container.encodeIfPresent(self.standardDeviation, forKey: .standardDeviation)
    }
}

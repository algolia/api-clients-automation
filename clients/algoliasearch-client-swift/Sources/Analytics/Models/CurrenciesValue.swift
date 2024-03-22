// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Currency code.
public struct CurrenciesValue: Codable, JSONEncodable {
    /// Currency code.
    public var currency: String?
    /// Revenue associated with this search in this currency.
    public var revenue: Float?

    public init(currency: String? = nil, revenue: Float? = nil) {
        self.currency = currency
        self.revenue = revenue
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case currency
        case revenue
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.currency, forKey: .currency)
        try container.encodeIfPresent(self.revenue, forKey: .revenue)
    }
}

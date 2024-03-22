// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct BigCommerceChannel: Codable, JSONEncodable {
    /// The ID of the bigcommerce channel.
    public var id: Int
    /// An array of currencies for the given channel `ID`, a currency is a trigram string that represents the currency
    /// code.
    public var currencies: [String]?

    public init(id: Int, currencies: [String]? = nil) {
        self.id = id
        self.currencies = currencies
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case currencies
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.id, forKey: .id)
        try container.encodeIfPresent(self.currencies, forKey: .currencies)
    }
}

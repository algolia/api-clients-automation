// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Facet to use as category.
public struct Facet: Codable, JSONEncodable, Hashable {
    /// Facet name.
    public var attribute: String?
    /// Number of suggestions.
    public var amount: Int?

    public init(attribute: String? = nil, amount: Int? = nil) {
        self.attribute = attribute
        self.amount = amount
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case attribute
        case amount
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.attribute, forKey: .attribute)
        try container.encodeIfPresent(self.amount, forKey: .amount)
    }
}

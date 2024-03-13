// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Order of facet names.
public struct Facets: Codable, JSONEncodable, Hashable {
    /// Explicit order of facets or facet values.  This setting lets you always show specific facets or facet values at
    /// the top of the list.
    public var order: [String]?

    public init(order: [String]? = nil) {
        self.order = order
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case order
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.order, forKey: .order)
    }
}

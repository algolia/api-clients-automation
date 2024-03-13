// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct SearchParamsQuery: Codable, JSONEncodable, Hashable {
    /// Search query.
    public var query: String?

    public init(query: String? = nil) {
        self.query = query
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case query
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.query, forKey: .query)
    }
}

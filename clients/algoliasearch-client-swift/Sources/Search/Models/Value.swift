// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct Value: Codable, JSONEncodable, Hashable {
    /** Pinned order of facet lists. */
    public var order: [String]?
    public var sortRemainingBy: SortRemainingBy?

    public init(order: [String]? = nil, sortRemainingBy: SortRemainingBy? = nil) {
        self.order = order
        self.sortRemainingBy = sortRemainingBy
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case order
        case sortRemainingBy
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(order, forKey: .order)
        try container.encodeIfPresent(sortRemainingBy, forKey: .sortRemainingBy)
    }
}

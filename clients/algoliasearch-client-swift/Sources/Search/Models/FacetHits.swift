// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - FacetHits

public struct FacetHits: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(value: String, highlighted: String, count: Int) {
        self.value = value
        self.highlighted = highlighted
        self.count = count
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case value
        case highlighted
        case count
    }

    /// Facet value.
    public var value: String
    /// Markup text with `facetQuery` matches highlighted.
    public var highlighted: String
    /// Number of records containing this facet value. This takes into account the extra search parameters specified in
    /// the query. Like for a regular search query, the [counts may not be exhaustive](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
    public var count: Int

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.value, forKey: .value)
        try container.encode(self.highlighted, forKey: .highlighted)
        try container.encode(self.count, forKey: .count)
    }
}

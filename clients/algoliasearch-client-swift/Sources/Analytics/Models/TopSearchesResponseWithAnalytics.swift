// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct TopSearchesResponseWithAnalytics: Codable, JSONEncodable, Hashable {
    /// Most popular searches and their associated click and conversion metrics.
    public var searches: [TopSearchWithAnalytics]

    public init(searches: [TopSearchWithAnalytics]) {
        self.searches = searches
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case searches
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.searches, forKey: .searches)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - IndexingTimeResponseMetrics

public struct IndexingTimeResponseMetrics: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(indexing: [String: [TimeInner]]? = nil) {
        self.indexing = indexing
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case indexing
    }

    public var indexing: [String: [TimeInner]]?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.indexing, forKey: .indexing)
    }
}

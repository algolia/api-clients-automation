// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct HasPendingMappingsResponse: Codable, JSONEncodable, Hashable {
    /** Indicates whether there are clusters undergoing migration, creation, or deletion. */
    public var pending: Bool
    /** Cluster pending mapping state: migrating, creating, deleting.  */
    public var clusters: [String: [String]]?

    public init(pending: Bool, clusters: [String: [String]]? = nil) {
        self.pending = pending
        self.clusters = clusters
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case pending
        case clusters
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(pending, forKey: .pending)
        try container.encodeIfPresent(clusters, forKey: .clusters)
    }
}

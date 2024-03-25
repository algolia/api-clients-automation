// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// User IDs and clusters.
public struct GetTopUserIdsResponse: Codable, JSONEncodable {
    /// Key-value pairs with cluster names as keys and lists of users with the highest number of records per cluster as
    /// values.
    public var topUsers: [[String: [UserId]]]

    public init(topUsers: [[String: [UserId]]]) {
        self.topUsers = topUsers
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case topUsers
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.topUsers, forKey: .topUsers)
    }
}

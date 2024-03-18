// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Empty searches removed from the A/B test as a result of configuration settings.
public struct FilterEffectsEmptySearch: Codable, JSONEncodable, Hashable {
    /// Number of users removed from the A/B test.
    public var usersCount: Int?
    /// Number of tracked searches removed from the A/B test.
    public var trackedSearchesCount: Int?

    public init(usersCount: Int? = nil, trackedSearchesCount: Int? = nil) {
        self.usersCount = usersCount
        self.trackedSearchesCount = trackedSearchesCount
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case usersCount
        case trackedSearchesCount
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.usersCount, forKey: .usersCount)
        try container.encodeIfPresent(self.trackedSearchesCount, forKey: .trackedSearchesCount)
    }
}

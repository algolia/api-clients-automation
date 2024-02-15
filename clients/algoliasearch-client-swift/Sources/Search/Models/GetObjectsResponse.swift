// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - GetObjectsResponse

public struct GetObjectsResponse: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(results: [AnyCodable]) {
        self.results = results
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case results
    }

    /// Retrieved results.
    public var results: [AnyCodable]

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.results, forKey: .results)
    }
}

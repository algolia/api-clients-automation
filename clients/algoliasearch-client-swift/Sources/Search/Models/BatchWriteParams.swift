// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - BatchWriteParams

/// Batch parameters.
public struct BatchWriteParams: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(requests: [BatchRequest]) {
        self.requests = requests
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case requests
    }

    public var requests: [BatchRequest]

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.requests, forKey: .requests)
    }
}

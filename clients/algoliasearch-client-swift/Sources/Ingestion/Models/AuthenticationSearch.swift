// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - AuthenticationSearch

/// Payload to search for multiple authentications, based on the given &#x60;authenticationIDs&#x60;.
public struct AuthenticationSearch: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(authenticationIDs: [String]) {
        self.authenticationIDs = authenticationIDs
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case authenticationIDs
    }

    public var authenticationIDs: [String]

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.authenticationIDs, forKey: .authenticationIDs)
    }
}

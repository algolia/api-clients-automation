// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** Payload to search for multiple authentications, based on the given &#x60;authenticationIDs&#x60;. */
public struct AuthenticationSearch: Codable, JSONEncodable, Hashable {
    public var authenticationIDs: [String]

    public init(authenticationIDs: [String]) {
        self.authenticationIDs = authenticationIDs
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case authenticationIDs
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(authenticationIDs, forKey: .authenticationIDs)
    }
}

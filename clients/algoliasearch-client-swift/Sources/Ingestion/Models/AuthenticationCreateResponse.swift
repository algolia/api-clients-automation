// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// API response for the successful creation of an authentication resource.
public struct AuthenticationCreateResponse: Codable, JSONEncodable {
    /// Universally unique identifier (UUID) of an authentication resource.
    public var authenticationID: String
    /// Descriptive name for the resource.
    public var name: String
    /// Date of creation in RFC 3339 format.
    public var createdAt: String

    public init(authenticationID: String, name: String, createdAt: String) {
        self.authenticationID = authenticationID
        self.name = name
        self.createdAt = createdAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case authenticationID
        case name
        case createdAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.authenticationID, forKey: .authenticationID)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.createdAt, forKey: .createdAt)
    }
}

extension AuthenticationCreateResponse: Equatable {
    public static func ==(lhs: AuthenticationCreateResponse, rhs: AuthenticationCreateResponse) -> Bool {
        lhs.authenticationID == rhs.authenticationID &&
            lhs.name == rhs.name &&
            lhs.createdAt == rhs.createdAt
    }
}

extension AuthenticationCreateResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.authenticationID.hashValue)
        hasher.combine(self.name.hashValue)
        hasher.combine(self.createdAt.hashValue)
    }
}

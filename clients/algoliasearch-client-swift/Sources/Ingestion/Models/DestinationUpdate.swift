// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// API request body for updating a destination.
public struct DestinationUpdate: Codable, JSONEncodable {
    public var type: DestinationType?
    /// Descriptive name for the resource.
    public var name: String?
    public var input: DestinationInput?
    /// Universally unique identifier (UUID) of an authentication resource.
    public var authenticationID: String?

    public init(
        type: DestinationType? = nil,
        name: String? = nil,
        input: DestinationInput? = nil,
        authenticationID: String? = nil
    ) {
        self.type = type
        self.name = name
        self.input = input
        self.authenticationID = authenticationID
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
        case name
        case input
        case authenticationID
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.type, forKey: .type)
        try container.encodeIfPresent(self.name, forKey: .name)
        try container.encodeIfPresent(self.input, forKey: .input)
        try container.encodeIfPresent(self.authenticationID, forKey: .authenticationID)
    }
}

extension DestinationUpdate: Equatable {
    public static func ==(lhs: DestinationUpdate, rhs: DestinationUpdate) -> Bool {
        lhs.type == rhs.type &&
            lhs.name == rhs.name &&
            lhs.input == rhs.input &&
            lhs.authenticationID == rhs.authenticationID
    }
}

extension DestinationUpdate: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.type?.hashValue)
        hasher.combine(self.name?.hashValue)
        hasher.combine(self.input?.hashValue)
        hasher.combine(self.authenticationID?.hashValue)
    }
}

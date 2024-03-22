// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Response from the API when the Destination is successfully created.
public struct DestinationCreateResponse: Codable, JSONEncodable {
    /// The destination UUID.
    public var destinationID: String
    /// An human readable name describing the object.
    public var name: String
    /// Date of creation (RFC3339 format).
    public var createdAt: String

    public init(destinationID: String, name: String, createdAt: String) {
        self.destinationID = destinationID
        self.name = name
        self.createdAt = createdAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case destinationID
        case name
        case createdAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.destinationID, forKey: .destinationID)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.createdAt, forKey: .createdAt)
    }
}

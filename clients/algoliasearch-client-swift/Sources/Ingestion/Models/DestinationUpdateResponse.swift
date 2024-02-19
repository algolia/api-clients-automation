// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

/// Response from the API when the Destination is successfully updated.
public struct DestinationUpdateResponse: Codable, JSONEncodable, Hashable {
    /// The destination UUID.
    public var destinationID: String
    /// An human readable name describing the object.
    public var name: String
    /// Date of last update (RFC3339 format).
    public var updatedAt: String

    public init(destinationID: String, name: String, updatedAt: String) {
        self.destinationID = destinationID
        self.name = name
        self.updatedAt = updatedAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case destinationID
        case name
        case updatedAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.destinationID, forKey: .destinationID)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.updatedAt, forKey: .updatedAt)
    }
}

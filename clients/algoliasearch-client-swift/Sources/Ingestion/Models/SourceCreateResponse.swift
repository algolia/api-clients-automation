// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct SourceCreateResponse: Codable, JSONEncodable, Hashable {
    /// The source UUID.
    public var sourceID: String
    public var name: String
    /// Date of creation (RFC3339 format).
    public var createdAt: String

    public init(sourceID: String, name: String, createdAt: String) {
        self.sourceID = sourceID
        self.name = name
        self.createdAt = createdAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case sourceID
        case name
        case createdAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.sourceID, forKey: .sourceID)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.createdAt, forKey: .createdAt)
    }
}

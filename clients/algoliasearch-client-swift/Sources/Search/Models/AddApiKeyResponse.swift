// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct AddApiKeyResponse: Codable, JSONEncodable, Hashable {
    /// API key.
    public var key: String
    /// Timestamp of creation in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
    public var createdAt: String

    public init(key: String, createdAt: String) {
        self.key = key
        self.createdAt = createdAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case key
        case createdAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.key, forKey: .key)
        try container.encode(self.createdAt, forKey: .createdAt)
    }
}

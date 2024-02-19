// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct Edit: Codable, JSONEncodable, Hashable {
    public var type: EditType?
    /// Text or patterns to remove from the query string.
    public var delete: String?
    /// Text that should be inserted in place of the removed text inside the query string.
    public var insert: String?

    public init(type: EditType? = nil, delete: String? = nil, insert: String? = nil) {
        self.type = type
        self.delete = delete
        self.insert = insert
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
        case delete
        case insert
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.type, forKey: .type)
        try container.encodeIfPresent(self.delete, forKey: .delete)
        try container.encodeIfPresent(self.insert, forKey: .insert)
    }
}

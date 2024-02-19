// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct SourceUpdateCommercetools: Codable, JSONEncodable, Hashable {
    /// Unique and immutable key of the referenced Store.
    public var storeKeys: [String]?
    /// Array of locales that must match the following pattern: ^[a-z]{2}(-[A-Z]{2})?$. For example [\"fr-FR\", \"en\"].
    public var locales: [String]?

    public init(storeKeys: [String]? = nil, locales: [String]? = nil) {
        self.storeKeys = storeKeys
        self.locales = locales
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case storeKeys
        case locales
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.storeKeys, forKey: .storeKeys)
        try container.encodeIfPresent(self.locales, forKey: .locales)
    }
}

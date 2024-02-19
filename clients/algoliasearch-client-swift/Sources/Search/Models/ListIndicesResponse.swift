// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct ListIndicesResponse: Codable, JSONEncodable, Hashable {
    /// All indices in your Algolia application.
    public var items: [FetchedIndex]
    /// Number of pages.
    public var nbPages: Int?

    public init(items: [FetchedIndex], nbPages: Int? = nil) {
        self.items = items
        self.nbPages = nbPages
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case items
        case nbPages
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.items, forKey: .items)
        try container.encodeIfPresent(self.nbPages, forKey: .nbPages)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct Cursor: Codable, JSONEncodable, Hashable {
    /// Cursor indicating the location to resume browsing from. Must match the value returned by the previous call. Pass
    /// this value to the subsequent browse call to get the next page of results. When the end of the index has been
    /// reached, `cursor` is absent from the response.
    public var cursor: String?

    public init(cursor: String? = nil) {
        self.cursor = cursor
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case cursor
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.cursor, forKey: .cursor)
    }
}

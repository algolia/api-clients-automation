// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct GetObjectsResponse: Codable, JSONEncodable, Hashable {
    /// Retrieved results.
    public var results: [AnyCodable]

    public init(results: [AnyCodable]) {
        self.results = results
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case results
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.results, forKey: .results)
    }
}

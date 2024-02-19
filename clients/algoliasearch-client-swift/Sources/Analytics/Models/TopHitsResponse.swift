// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct TopHitsResponse: Codable, JSONEncodable, Hashable {
    /// Top hits.
    public var hits: [TopHit]

    public init(hits: [TopHit]) {
        self.hits = hits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hits, forKey: .hits)
    }
}

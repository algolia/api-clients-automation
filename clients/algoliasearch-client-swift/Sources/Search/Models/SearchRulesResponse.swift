// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct SearchRulesResponse: Codable, JSONEncodable, Hashable {
    /// Fetched rules.
    public var hits: [Rule]
    /// Number of fetched rules.
    public var nbHits: Int
    /// Current page.
    public var page: Int
    /// Number of pages.
    public var nbPages: Int

    public init(hits: [Rule], nbHits: Int, page: Int, nbPages: Int) {
        self.hits = hits
        self.nbHits = nbHits
        self.page = page
        self.nbPages = nbPages
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hits
        case nbHits
        case page
        case nbPages
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hits, forKey: .hits)
        try container.encode(self.nbHits, forKey: .nbHits)
        try container.encode(self.page, forKey: .page)
        try container.encode(self.nbPages, forKey: .nbPages)
    }
}

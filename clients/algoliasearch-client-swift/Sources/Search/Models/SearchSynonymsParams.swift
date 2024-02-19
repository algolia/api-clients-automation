// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct SearchSynonymsParams: Codable, JSONEncodable, Hashable {
    static let hitsPerPageRule = NumericRule<Int>(
        minimum: 1,
        exclusiveMinimum: false,
        maximum: 1000,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    /// Text to search for in an index.
    public var query: String?
    public var type: SynonymType?
    /// Page to retrieve (the first page is `0`, not `1`).
    public var page: Int?
    /// Number of hits per page.
    public var hitsPerPage: Int?

    public init(query: String? = nil, type: SynonymType? = nil, page: Int? = nil, hitsPerPage: Int? = nil) {
        self.query = query
        self.type = type
        self.page = page
        self.hitsPerPage = hitsPerPage
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case query
        case type
        case page
        case hitsPerPage
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.query, forKey: .query)
        try container.encodeIfPresent(self.type, forKey: .type)
        try container.encodeIfPresent(self.page, forKey: .page)
        try container.encodeIfPresent(self.hitsPerPage, forKey: .hitsPerPage)
    }
}

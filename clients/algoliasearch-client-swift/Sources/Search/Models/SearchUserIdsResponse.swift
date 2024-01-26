// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// userIDs data.
public struct SearchUserIdsResponse: Codable, JSONEncodable, Hashable {

  static let hitsPerPageRule = NumericRule<Int>(
    minimum: 1, exclusiveMinimum: false, maximum: 1000, exclusiveMaximum: false, multipleOf: nil)
  /** User objects that match the query. */
  public var hits: [UserHit]
  /** Number of hits the search query matched. */
  public var nbHits: Int
  /** Page to retrieve (the first page is `0`, not `1`). */
  public var page: Int
  /** Maximum number of hits per page. */
  public var hitsPerPage: Int
  /** Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. */
  public var updatedAt: String

  public init(hits: [UserHit], nbHits: Int, page: Int, hitsPerPage: Int, updatedAt: String) {
    self.hits = hits
    self.nbHits = nbHits
    self.page = page
    self.hitsPerPage = hitsPerPage
    self.updatedAt = updatedAt
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case hits
    case nbHits
    case page
    case hitsPerPage
    case updatedAt
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(hits, forKey: .hits)
    try container.encode(nbHits, forKey: .nbHits)
    try container.encode(page, forKey: .page)
    try container.encode(hitsPerPage, forKey: .hitsPerPage)
    try container.encode(updatedAt, forKey: .updatedAt)
  }
}

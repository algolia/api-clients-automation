// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// OK
@objcMembers public class SearchUserIdsParams: NSObject, Codable, JSONEncodable {

  static let hitsPerPageRule = NumericRule<Int>(
    minimum: 1, exclusiveMinimum: false, maximum: 1000, exclusiveMaximum: false, multipleOf: nil)
  /** Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users. */
  public var query: String
  /** Cluster name. */
  public var clusterName: String?
  /** Page to retrieve (the first page is `0`, not `1`). */
  public var page: Int? = 0
  public var pageNum: NSNumber? {
    return page as NSNumber?
  }
  /** Number of hits per page. */
  public var hitsPerPage: Int? = 20
  public var hitsPerPageNum: NSNumber? {
    return hitsPerPage as NSNumber?
  }

  public init(query: String, clusterName: String? = nil, page: Int? = 0, hitsPerPage: Int? = 20) {
    self.query = query
    self.clusterName = clusterName
    self.page = page
    self.hitsPerPage = hitsPerPage
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case query
    case clusterName
    case page
    case hitsPerPage
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(query, forKey: .query)
    try container.encodeIfPresent(clusterName, forKey: .clusterName)
    try container.encodeIfPresent(page, forKey: .page)
    try container.encodeIfPresent(hitsPerPage, forKey: .hitsPerPage)
  }
}

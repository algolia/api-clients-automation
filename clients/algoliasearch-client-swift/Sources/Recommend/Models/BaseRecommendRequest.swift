// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct BaseRecommendRequest: Codable, JSONEncodable, Hashable {

  static let thresholdRule = NumericRule<Int>(
    minimum: 0, exclusiveMinimum: false, maximum: 100, exclusiveMaximum: false, multipleOf: nil)
  /** Algolia index name. */
  public var indexName: String
  /** Recommendations with a confidence score lower than `threshold` won't appear in results. > **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are.  */
  public var threshold: Int?
  /** Maximum number of recommendations to retrieve. If 0, all recommendations will be returned. */
  public var maxRecommendations: Int?

  public init(indexName: String, threshold: Int? = nil, maxRecommendations: Int? = nil) {
    self.indexName = indexName
    self.threshold = threshold
    self.maxRecommendations = maxRecommendations
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case indexName
    case threshold
    case maxRecommendations
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(indexName, forKey: .indexName)
    try container.encodeIfPresent(threshold, forKey: .threshold)
    try container.encodeIfPresent(maxRecommendations, forKey: .maxRecommendations)
  }
}

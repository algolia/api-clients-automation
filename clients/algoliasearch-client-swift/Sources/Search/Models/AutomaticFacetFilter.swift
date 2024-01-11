// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Automatic facet Filter.
@objcMembers public class AutomaticFacetFilter: NSObject, Codable, JSONEncodable {

  /** Attribute to filter on. This must match a facet placeholder in the Rule's pattern. */
  public var facet: String
  /** Score for the filter. Typically used for optional or disjunctive filters. */
  public var score: Int? = 1
  public var scoreNum: NSNumber? {
    return score as NSNumber?
  }
  /** Whether the filter is disjunctive (true) or conjunctive (false). */
  public var disjunctive: Bool? = false
  public var disjunctiveNum: NSNumber? {
    return disjunctive as NSNumber?
  }

  public init(facet: String, score: Int? = 1, disjunctive: Bool? = false) {
    self.facet = facet
    self.score = score
    self.disjunctive = disjunctive
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case facet
    case score
    case disjunctive
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(facet, forKey: .facet)
    try container.encodeIfPresent(score, forKey: .score)
    try container.encodeIfPresent(disjunctive, forKey: .disjunctive)
  }
}

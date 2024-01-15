// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct NoClickRateEvent: Codable, JSONEncodable, Hashable {

  static let rateRule = NumericRule<Double>(
    minimum: 0, exclusiveMinimum: false, maximum: 1, exclusiveMaximum: false, multipleOf: nil)
  /** [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  */
  public var rate: Double
  /** Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`). */
  public var count: Int
  /** Number of click events. */
  public var noClickCount: Int
  /** Date of the event in the format YYYY-MM-DD. */
  public var date: String

  public init(rate: Double, count: Int, noClickCount: Int, date: String) {
    self.rate = rate
    self.count = count
    self.noClickCount = noClickCount
    self.date = date
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case rate
    case count
    case noClickCount
    case date
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(rate, forKey: .rate)
    try container.encode(count, forKey: .count)
    try container.encode(noClickCount, forKey: .noClickCount)
    try container.encode(date, forKey: .date)
  }
}

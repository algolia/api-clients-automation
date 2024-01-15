// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct BaseRecommendedForYouQueryParameters: Codable, JSONEncodable, Hashable {

  /** Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search. */
  public var userToken: String

  public init(userToken: String) {
    self.userToken = userToken
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case userToken
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(userToken, forKey: .userToken)
  }
}

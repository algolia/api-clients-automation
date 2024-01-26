// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct SourceCommercetools: Codable, JSONEncodable, Hashable {

  public var storeKeys: [String]?
  /** Array of locales that must match the following pattern: ^[a-z]{2}(-[A-Z]{2})?$. For example [\"fr-FR\", \"en\"].  */
  public var locales: [String]?
  public var url: String
  public var projectKey: String
  /** Determines the value that will be stored in the Algolia record if there's no inventory information on the product.  */
  public var fallbackIsInStockValue: Bool?

  public init(
    storeKeys: [String]? = nil, locales: [String]? = nil, url: String, projectKey: String,
    fallbackIsInStockValue: Bool? = nil
  ) {
    self.storeKeys = storeKeys
    self.locales = locales
    self.url = url
    self.projectKey = projectKey
    self.fallbackIsInStockValue = fallbackIsInStockValue
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case storeKeys
    case locales
    case url
    case projectKey
    case fallbackIsInStockValue
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(storeKeys, forKey: .storeKeys)
    try container.encodeIfPresent(locales, forKey: .locales)
    try container.encode(url, forKey: .url)
    try container.encode(projectKey, forKey: .projectKey)
    try container.encodeIfPresent(fallbackIsInStockValue, forKey: .fallbackIsInStockValue)
  }
}

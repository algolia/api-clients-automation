// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct QuerySuggestionsConfigurationResponse: Codable, JSONEncodable, Hashable {

  /** Your Algolia application ID. */
  public var appId: String?
  /** API key used to read from your source index. */
  public var sourceIndicesAPIKey: String?
  /** API key used to write and configure your Query Suggestions index. */
  public var suggestionsIndicesAPIKey: String?
  /** API key used to read from external Algolia indices. */
  public var externalIndicesAPIKey: String? = ""
  /** Query Suggestions index name. */
  public var indexName: String
  /** Algolia indices from which to get the popular searches for query suggestions. */
  public var sourceIndices: [SourceIndex]
  public var languages: Languages?
  /** Patterns to exclude from query suggestions. */
  public var exclude: [String]?
  /** Turn on personalized query suggestions. */
  public var enablePersonalization: Bool? = false
  /** Allow suggestions with special characters. */
  public var allowSpecialCharacters: Bool? = false

  public init(
    appId: String? = nil, sourceIndicesAPIKey: String? = nil,
    suggestionsIndicesAPIKey: String? = nil, externalIndicesAPIKey: String? = "", indexName: String,
    sourceIndices: [SourceIndex], languages: Languages? = nil, exclude: [String]? = nil,
    enablePersonalization: Bool? = false, allowSpecialCharacters: Bool? = false
  ) {
    self.appId = appId
    self.sourceIndicesAPIKey = sourceIndicesAPIKey
    self.suggestionsIndicesAPIKey = suggestionsIndicesAPIKey
    self.externalIndicesAPIKey = externalIndicesAPIKey
    self.indexName = indexName
    self.sourceIndices = sourceIndices
    self.languages = languages
    self.exclude = exclude
    self.enablePersonalization = enablePersonalization
    self.allowSpecialCharacters = allowSpecialCharacters
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case appId
    case sourceIndicesAPIKey
    case suggestionsIndicesAPIKey
    case externalIndicesAPIKey
    case indexName
    case sourceIndices
    case languages
    case exclude
    case enablePersonalization
    case allowSpecialCharacters
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(appId, forKey: .appId)
    try container.encodeIfPresent(sourceIndicesAPIKey, forKey: .sourceIndicesAPIKey)
    try container.encodeIfPresent(suggestionsIndicesAPIKey, forKey: .suggestionsIndicesAPIKey)
    try container.encodeIfPresent(externalIndicesAPIKey, forKey: .externalIndicesAPIKey)
    try container.encode(indexName, forKey: .indexName)
    try container.encode(sourceIndices, forKey: .sourceIndices)
    try container.encodeIfPresent(languages, forKey: .languages)
    try container.encodeIfPresent(exclude, forKey: .exclude)
    try container.encodeIfPresent(enablePersonalization, forKey: .enablePersonalization)
    try container.encodeIfPresent(allowSpecialCharacters, forKey: .allowSpecialCharacters)
  }
}

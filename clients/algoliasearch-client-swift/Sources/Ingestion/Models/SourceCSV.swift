// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct SourceCSV: Codable, JSONEncodable, Hashable {

  static let delimiterRule = StringRule(minLength: 1, maxLength: 1, pattern: nil)
  /** The URL of the file. */
  public var url: String
  /** The name of the column that contains the unique ID, used as `objectID` in Algolia. */
  public var uniqueIDColumn: String?
  /** Mapping of type for every column. For example {\"myColumn\": \"boolean\", \"myOtherColumn\": \"json\"}.  */
  public var mapping: [String: MappingTypeCSV]?
  public var method: MethodType?
  /** The character used to split the value on each line, default to a comma (\\r, \\n, 0xFFFD, and space are forbidden). */
  public var delimiter: String? = ","

  public init(
    url: String, uniqueIDColumn: String? = nil, mapping: [String: MappingTypeCSV]? = nil,
    method: MethodType? = nil, delimiter: String? = ","
  ) {
    self.url = url
    self.uniqueIDColumn = uniqueIDColumn
    self.mapping = mapping
    self.method = method
    self.delimiter = delimiter
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case url
    case uniqueIDColumn
    case mapping
    case method
    case delimiter
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(url, forKey: .url)
    try container.encodeIfPresent(uniqueIDColumn, forKey: .uniqueIDColumn)
    try container.encodeIfPresent(mapping, forKey: .mapping)
    try container.encodeIfPresent(method, forKey: .method)
    try container.encodeIfPresent(delimiter, forKey: .delimiter)
  }
}

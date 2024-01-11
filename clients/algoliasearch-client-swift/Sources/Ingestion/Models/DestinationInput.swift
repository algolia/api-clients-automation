// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public enum DestinationInput: Codable, JSONEncodable, Hashable {
  case destinationIndexName(DestinationIndexName)
  case destinationIndexPrefix(DestinationIndexPrefix)

  public func encode(to encoder: Encoder) throws {
    var container = encoder.singleValueContainer()
    switch self {
    case .destinationIndexName(let value):
      try container.encode(value)
    case .destinationIndexPrefix(let value):
      try container.encode(value)
    }
  }

  public init(from decoder: Decoder) throws {
    let container = try decoder.singleValueContainer()
    if let value = try? container.decode(DestinationIndexName.self) {
      self = .destinationIndexName(value)
    } else if let value = try? container.decode(DestinationIndexPrefix.self) {
      self = .destinationIndexPrefix(value)
    } else {
      throw DecodingError.typeMismatch(
        Self.Type.self,
        .init(
          codingPath: decoder.codingPath,
          debugDescription: "Unable to decode instance of DestinationInput"))
    }
  }
}

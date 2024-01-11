// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public enum PlatformWithNone: Codable, JSONEncodable, Hashable {
  case platform(Platform)
  case platformNone(PlatformNone)

  public func encode(to encoder: Encoder) throws {
    var container = encoder.singleValueContainer()
    switch self {
    case .platform(let value):
      try container.encode(value)
    case .platformNone(let value):
      try container.encode(value)
    }
  }

  public init(from decoder: Decoder) throws {
    let container = try decoder.singleValueContainer()
    if let value = try? container.decode(Platform.self) {
      self = .platform(value)
    } else if let value = try? container.decode(PlatformNone.self) {
      self = .platformNone(value)
    } else {
      throw DecodingError.typeMismatch(
        Self.Type.self,
        .init(
          codingPath: decoder.codingPath,
          debugDescription: "Unable to decode instance of PlatformWithNone"))
    }
  }
}

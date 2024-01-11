// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

@objcMembers public class DockerSourceStreams: NSObject, Codable, JSONEncodable {

  public var streams: [AnyCodable]

  public init(streams: [AnyCodable]) {
    self.streams = streams
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case streams
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(streams, forKey: .streams)
  }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct Server: Codable, JSONEncodable, Hashable {

  /** Server name. */
  public var name: String?
  public var region: Region?
  /** Included to support legacy applications. Do not rely on this attribute being present in the response. Use `is_replica` instead.  */
  @available(*, deprecated, message: "This property is deprecated.")
  public var isSlave: Bool? = false
  /** Indicates whether this server is a replica of another server. */
  public var isReplica: Bool? = false
  /** Name of the cluster to which this server belongs. */
  public var cluster: String?
  public var status: ServerStatus?
  public var type: ModelType?

  public init(
    name: String? = nil, region: Region? = nil, isSlave: Bool? = false, isReplica: Bool? = false,
    cluster: String? = nil, status: ServerStatus? = nil, type: ModelType? = nil
  ) {
    self.name = name
    self.region = region
    self.isSlave = isSlave
    self.isReplica = isReplica
    self.cluster = cluster
    self.status = status
    self.type = type
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case name
    case region
    case isSlave = "is_slave"
    case isReplica = "is_replica"
    case cluster
    case status
    case type
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(name, forKey: .name)
    try container.encodeIfPresent(region, forKey: .region)
    try container.encodeIfPresent(isSlave, forKey: .isSlave)
    try container.encodeIfPresent(isReplica, forKey: .isReplica)
    try container.encodeIfPresent(cluster, forKey: .cluster)
    try container.encodeIfPresent(status, forKey: .status)
    try container.encodeIfPresent(type, forKey: .type)
  }
}

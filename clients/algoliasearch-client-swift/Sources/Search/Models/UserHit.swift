// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct UserHit: Codable, JSONEncodable, Hashable {

  static let userIDRule = StringRule(
    minLength: nil, maxLength: nil, pattern: "^[a-zA-Z0-9 \\-*.]+$")
  /** userID of the user. */
  public var userID: String
  /** Cluster name. */
  public var clusterName: String
  /** Number of records in the cluster. */
  public var nbRecords: Int
  /** Data size taken by all the users assigned to the cluster. */
  public var dataSize: Int
  /** userID of the requested user. Same as userID. */
  public var objectID: String
  public var highlightResult: UserHighlightResult

  public init(
    userID: String, clusterName: String, nbRecords: Int, dataSize: Int, objectID: String,
    highlightResult: UserHighlightResult
  ) {
    self.userID = userID
    self.clusterName = clusterName
    self.nbRecords = nbRecords
    self.dataSize = dataSize
    self.objectID = objectID
    self.highlightResult = highlightResult
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case userID
    case clusterName
    case nbRecords
    case dataSize
    case objectID
    case highlightResult = "_highlightResult"
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(userID, forKey: .userID)
    try container.encode(clusterName, forKey: .clusterName)
    try container.encode(nbRecords, forKey: .nbRecords)
    try container.encode(dataSize, forKey: .dataSize)
    try container.encode(objectID, forKey: .objectID)
    try container.encode(highlightResult, forKey: .highlightResult)
  }
}

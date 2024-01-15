// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct ABTestResponse: Codable, JSONEncodable, Hashable {

  /** A/B test index. */
  public var index: String
  /** Unique A/B test ID. */
  public var abTestID: Int
  /** Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`.  */
  public var taskID: Int64

  public init(index: String, abTestID: Int, taskID: Int64) {
    self.index = index
    self.abTestID = abTestID
    self.taskID = taskID
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case index
    case abTestID
    case taskID
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encode(index, forKey: .index)
    try container.encode(abTestID, forKey: .abTestID)
    try container.encode(taskID, forKey: .taskID)
  }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct UpdatedRuleResponse: Codable, JSONEncodable, Hashable {
    /// Unique identifier of a rule object.
    public var objectID: String
    /// Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    public var updatedAt: String
    /// Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run
    /// immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and
    /// this `taskID`.
    public var taskID: Int64

    public init(objectID: String, updatedAt: String, taskID: Int64) {
        self.objectID = objectID
        self.updatedAt = updatedAt
        self.taskID = taskID
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case objectID
        case updatedAt
        case taskID
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.objectID, forKey: .objectID)
        try container.encode(self.updatedAt, forKey: .updatedAt)
        try container.encode(self.taskID, forKey: .taskID)
    }
}

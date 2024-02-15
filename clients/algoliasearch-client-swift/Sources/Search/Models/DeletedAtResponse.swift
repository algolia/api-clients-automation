// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// Response, taskID, and deletion timestamp.
public struct DeletedAtResponse: Codable, JSONEncodable, Hashable {
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run
    /// immediately. You can check the task's progress with the `task` operation and this `taskID`.
    public var taskID: Int64
    /// Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    public var deletedAt: String

    public init(taskID: Int64, deletedAt: String) {
        self.taskID = taskID
        self.deletedAt = deletedAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case taskID
        case deletedAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.taskID, forKey: .taskID)
        try container.encode(self.deletedAt, forKey: .deletedAt)
    }
}

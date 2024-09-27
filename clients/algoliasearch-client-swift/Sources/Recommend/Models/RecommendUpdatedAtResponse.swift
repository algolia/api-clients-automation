// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Response, taskID, and update timestamp.
public struct RecommendUpdatedAtResponse: Codable, JSONEncodable {
    /// Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run
    /// immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and
    /// this `taskID`.
    public var taskID: Int64
    /// Date and time when the object was updated, in RFC 3339 format.
    public var updatedAt: String

    public init(taskID: Int64, updatedAt: String) {
        self.taskID = taskID
        self.updatedAt = updatedAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case taskID
        case updatedAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.taskID, forKey: .taskID)
        try container.encode(self.updatedAt, forKey: .updatedAt)
    }
}

extension RecommendUpdatedAtResponse: Equatable {
    public static func ==(lhs: RecommendUpdatedAtResponse, rhs: RecommendUpdatedAtResponse) -> Bool {
        lhs.taskID == rhs.taskID &&
            lhs.updatedAt == rhs.updatedAt
    }
}

extension RecommendUpdatedAtResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.taskID.hashValue)
        hasher.combine(self.updatedAt.hashValue)
    }
}
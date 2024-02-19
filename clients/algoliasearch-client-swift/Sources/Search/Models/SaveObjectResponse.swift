// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct SaveObjectResponse: Codable, JSONEncodable, Hashable {
    /// Date of creation (ISO-8601 format).
    public var createdAt: String
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run
    /// immediately. You can check the task's progress with the `task` operation and this `taskID`.
    public var taskID: Int64
    /// Unique object identifier.
    public var objectID: String?

    public init(createdAt: String, taskID: Int64, objectID: String? = nil) {
        self.createdAt = createdAt
        self.taskID = taskID
        self.objectID = objectID
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case createdAt
        case taskID
        case objectID
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.createdAt, forKey: .createdAt)
        try container.encode(self.taskID, forKey: .taskID)
        try container.encodeIfPresent(self.objectID, forKey: .objectID)
    }
}

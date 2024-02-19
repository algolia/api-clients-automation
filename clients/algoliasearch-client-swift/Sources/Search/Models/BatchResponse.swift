// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct BatchResponse: Codable, JSONEncodable, Hashable {
    /// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run
    /// immediately. You can check the task's progress with the `task` operation and this `taskID`.
    public var taskID: Int64
    /// Unique object (record) identifiers.
    public var objectIDs: [String]

    public init(taskID: Int64, objectIDs: [String]) {
        self.taskID = taskID
        self.objectIDs = objectIDs
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case taskID
        case objectIDs
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.taskID, forKey: .taskID)
        try container.encode(self.objectIDs, forKey: .objectIDs)
    }
}

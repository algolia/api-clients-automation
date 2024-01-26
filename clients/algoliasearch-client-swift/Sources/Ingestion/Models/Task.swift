// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct Task: Codable, JSONEncodable, Hashable {
    static let failureThresholdRule = NumericRule<Int>(minimum: 0, exclusiveMinimum: false, maximum: 100, exclusiveMaximum: false, multipleOf: nil)
    /** The task UUID. */
    public var taskID: String
    /** The source UUID. */
    public var sourceID: String
    /** The destination UUID. */
    public var destinationID: String
    public var trigger: Trigger
    public var input: TaskInput?
    /** Whether the task is enabled or not. */
    public var enabled: Bool
    /** A percentage representing the accepted failure threshold to determine if a `run` succeeded or not. */
    public var failureThreshold: Int?
    public var action: ActionType
    /** Date of creation (RFC3339 format). */
    public var createdAt: String
    /** Date of last update (RFC3339 format). */
    public var updatedAt: String?

    public init(taskID: String, sourceID: String, destinationID: String, trigger: Trigger, input: TaskInput? = nil, enabled: Bool, failureThreshold: Int? = nil, action: ActionType, createdAt: String, updatedAt: String? = nil) {
        self.taskID = taskID
        self.sourceID = sourceID
        self.destinationID = destinationID
        self.trigger = trigger
        self.input = input
        self.enabled = enabled
        self.failureThreshold = failureThreshold
        self.action = action
        self.createdAt = createdAt
        self.updatedAt = updatedAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case taskID
        case sourceID
        case destinationID
        case trigger
        case input
        case enabled
        case failureThreshold
        case action
        case createdAt
        case updatedAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(taskID, forKey: .taskID)
        try container.encode(sourceID, forKey: .sourceID)
        try container.encode(destinationID, forKey: .destinationID)
        try container.encode(trigger, forKey: .trigger)
        try container.encodeIfPresent(input, forKey: .input)
        try container.encode(enabled, forKey: .enabled)
        try container.encodeIfPresent(failureThreshold, forKey: .failureThreshold)
        try container.encode(action, forKey: .action)
        try container.encode(createdAt, forKey: .createdAt)
        try container.encodeIfPresent(updatedAt, forKey: .updatedAt)
    }
}

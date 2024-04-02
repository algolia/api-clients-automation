// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// API request body for creating a task.
public struct TaskCreate: Codable, JSONEncodable {
    /// Universally uniqud identifier (UUID) of a source.
    public var sourceID: String
    /// Universally unique identifier (UUID) of a destination resource.
    public var destinationID: String
    public var trigger: TaskCreateTrigger
    public var action: ActionType
    /// Whether the task is enabled.
    public var enabled: Bool?
    /// Maximum accepted percentage of failures for a task run to finish successfully.
    public var failureThreshold: Int?
    public var input: TaskInput?

    public init(
        sourceID: String,
        destinationID: String,
        trigger: TaskCreateTrigger,
        action: ActionType,
        enabled: Bool? = nil,
        failureThreshold: Int? = nil,
        input: TaskInput? = nil
    ) {
        self.sourceID = sourceID
        self.destinationID = destinationID
        self.trigger = trigger
        self.action = action
        self.enabled = enabled
        self.failureThreshold = failureThreshold
        self.input = input
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case sourceID
        case destinationID
        case trigger
        case action
        case enabled
        case failureThreshold
        case input
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.sourceID, forKey: .sourceID)
        try container.encode(self.destinationID, forKey: .destinationID)
        try container.encode(self.trigger, forKey: .trigger)
        try container.encode(self.action, forKey: .action)
        try container.encodeIfPresent(self.enabled, forKey: .enabled)
        try container.encodeIfPresent(self.failureThreshold, forKey: .failureThreshold)
        try container.encodeIfPresent(self.input, forKey: .input)
    }
}

extension TaskCreate: Equatable {
    public static func ==(lhs: TaskCreate, rhs: TaskCreate) -> Bool {
        lhs.sourceID == rhs.sourceID &&
            lhs.destinationID == rhs.destinationID &&
            lhs.trigger == rhs.trigger &&
            lhs.action == rhs.action &&
            lhs.enabled == rhs.enabled &&
            lhs.failureThreshold == rhs.failureThreshold &&
            lhs.input == rhs.input
    }
}

extension TaskCreate: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.sourceID.hashValue)
        hasher.combine(self.destinationID.hashValue)
        hasher.combine(self.trigger.hashValue)
        hasher.combine(self.action.hashValue)
        hasher.combine(self.enabled?.hashValue)
        hasher.combine(self.failureThreshold?.hashValue)
        hasher.combine(self.input?.hashValue)
    }
}

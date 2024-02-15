// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - Run

public struct Run: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(
        runID: String,
        appID: String,
        taskID: String,
        status: RunStatus,
        progress: RunProgress? = nil,
        outcome: RunOutcome? = nil,
        failureThreshold: Int? = nil,
        reason: String? = nil,
        reasonCode: RunReasonCode? = nil,
        type: RunType,
        createdAt: String,
        startedAt: String? = nil,
        finishedAt: String? = nil
    ) {
        self.runID = runID
        self.appID = appID
        self.taskID = taskID
        self.status = status
        self.progress = progress
        self.outcome = outcome
        self.failureThreshold = failureThreshold
        self.reason = reason
        self.reasonCode = reasonCode
        self.type = type
        self.createdAt = createdAt
        self.startedAt = startedAt
        self.finishedAt = finishedAt
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case runID
        case appID
        case taskID
        case status
        case progress
        case outcome
        case failureThreshold
        case reason
        case reasonCode
        case type
        case createdAt
        case startedAt
        case finishedAt
    }

    /// The run UUID.
    public var runID: String
    public var appID: String
    /// The task UUID.
    public var taskID: String
    public var status: RunStatus
    public var progress: RunProgress?
    public var outcome: RunOutcome?
    /// A percentage representing the accepted failure threshold to determine if a `run` succeeded or not.
    public var failureThreshold: Int?
    /// Explains the result of outcome.
    public var reason: String?
    public var reasonCode: RunReasonCode?
    public var type: RunType
    /// Date of creation (RFC3339 format).
    public var createdAt: String
    /// Date of start (RFC3339 format).
    public var startedAt: String?
    /// Date of finish (RFC3339 format).
    public var finishedAt: String?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.runID, forKey: .runID)
        try container.encode(self.appID, forKey: .appID)
        try container.encode(self.taskID, forKey: .taskID)
        try container.encode(self.status, forKey: .status)
        try container.encodeIfPresent(self.progress, forKey: .progress)
        try container.encodeIfPresent(self.outcome, forKey: .outcome)
        try container.encodeIfPresent(self.failureThreshold, forKey: .failureThreshold)
        try container.encodeIfPresent(self.reason, forKey: .reason)
        try container.encodeIfPresent(self.reasonCode, forKey: .reasonCode)
        try container.encode(self.type, forKey: .type)
        try container.encode(self.createdAt, forKey: .createdAt)
        try container.encodeIfPresent(self.startedAt, forKey: .startedAt)
        try container.encodeIfPresent(self.finishedAt, forKey: .finishedAt)
    }

    // MARK: Internal

    static let failureThresholdRule = NumericRule<Int>(
        minimum: 0,
        exclusiveMinimum: false,
        maximum: 100,
        exclusiveMaximum: false,
        multipleOf: nil
    )
}

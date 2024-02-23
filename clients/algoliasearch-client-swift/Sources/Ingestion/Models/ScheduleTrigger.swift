// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// The trigger information for a task of type &#39;schedule&#39;.
public struct ScheduleTrigger: Codable, JSONEncodable, Hashable {
    public var type: ScheduleTriggerType
    /// A cron expression that represent at which regularity the task should run.
    public var cron: String
    /// The last time the scheduled task ran (RFC3339 format).
    public var lastRun: String?
    /// The next scheduled run of the task (RFC3339 format).
    public var nextRun: String

    public init(type: ScheduleTriggerType, cron: String, lastRun: String? = nil, nextRun: String) {
        self.type = type
        self.cron = cron
        self.lastRun = lastRun
        self.nextRun = nextRun
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
        case cron
        case lastRun
        case nextRun
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.type, forKey: .type)
        try container.encode(self.cron, forKey: .cron)
        try container.encodeIfPresent(self.lastRun, forKey: .lastRun)
        try container.encode(self.nextRun, forKey: .nextRun)
    }
}

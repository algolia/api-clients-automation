// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// The trigger information of a task of type &#x60;onDemand&#x60;.
public struct OnDemandTrigger: Codable, JSONEncodable, Hashable {
    public var type: OnDemandTriggerType
    /// The last time the scheduled task ran (RFC3339 format).
    public var lastRun: String?

    public init(type: OnDemandTriggerType, lastRun: String? = nil) {
        self.type = type
        self.lastRun = lastRun
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
        case lastRun
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.type, forKey: .type)
        try container.encodeIfPresent(self.lastRun, forKey: .lastRun)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct ScheduleABTestsRequest: Codable, JSONEncodable {
    /// A/B test name.
    public var name: String
    /// A/B test variants.
    public var variants: [AddABTestsVariant]
    /// Date and time when the A/B test is scheduled to start, in RFC 3339 format.
    public var scheduledAt: String
    /// End date and time of the A/B test, in RFC 3339 format.
    public var endAt: String

    public init(name: String, variants: [AddABTestsVariant], scheduledAt: String, endAt: String) {
        self.name = name
        self.variants = variants
        self.scheduledAt = scheduledAt
        self.endAt = endAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case name
        case variants
        case scheduledAt
        case endAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.variants, forKey: .variants)
        try container.encode(self.scheduledAt, forKey: .scheduledAt)
        try container.encode(self.endAt, forKey: .endAt)
    }
}

extension ScheduleABTestsRequest: Equatable {
    public static func ==(lhs: ScheduleABTestsRequest, rhs: ScheduleABTestsRequest) -> Bool {
        lhs.name == rhs.name &&
            lhs.variants == rhs.variants &&
            lhs.scheduledAt == rhs.scheduledAt &&
            lhs.endAt == rhs.endAt
    }
}

extension ScheduleABTestsRequest: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.name.hashValue)
        hasher.combine(self.variants.hashValue)
        hasher.combine(self.scheduledAt.hashValue)
        hasher.combine(self.endAt.hashValue)
    }
}

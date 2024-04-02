// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Input for a manually-triggered task whose source is of type &#x60;bigquery&#x60; and for which extracted data spans
/// a given time range.
public struct OnDemandDateUtilsInput: Codable, JSONEncodable {
    /// Earliest date in RFC3339 format of the extracted data from Big Query.
    public var startDate: String
    /// Latest date in RFC3339 format of the extracted data from Big Query.
    public var endDate: String
    public var mapping: MappingInput?

    public init(startDate: String, endDate: String, mapping: MappingInput? = nil) {
        self.startDate = startDate
        self.endDate = endDate
        self.mapping = mapping
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case startDate
        case endDate
        case mapping
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.startDate, forKey: .startDate)
        try container.encode(self.endDate, forKey: .endDate)
        try container.encodeIfPresent(self.mapping, forKey: .mapping)
    }
}

extension OnDemandDateUtilsInput: Equatable {
    public static func ==(lhs: OnDemandDateUtilsInput, rhs: OnDemandDateUtilsInput) -> Bool {
        lhs.startDate == rhs.startDate &&
            lhs.endDate == rhs.endDate &&
            lhs.mapping == rhs.mapping
    }
}

extension OnDemandDateUtilsInput: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.startDate.hashValue)
        hasher.combine(self.endDate.hashValue)
        hasher.combine(self.mapping?.hashValue)
    }
}

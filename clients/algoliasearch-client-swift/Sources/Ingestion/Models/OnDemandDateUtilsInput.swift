// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// The input for an &#x60;onDemand&#x60; task whose source is of type &#x60;bigquery&#x60; and for which extracted data
/// spans a given time range.
public struct OnDemandDateUtilsInput: Codable, JSONEncodable {
    /// The start date of the extraction (RFC3339 format).
    public var startDate: String
    /// The end date of the extraction (RFC3339 format).
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

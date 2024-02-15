// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - IncidentsResponse

public struct IncidentsResponse: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(incidents: [String: [IncidentsInner]]? = nil) {
        self.incidents = incidents
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case incidents
    }

    public var incidents: [String: [IncidentsInner]]?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.incidents, forKey: .incidents)
    }
}

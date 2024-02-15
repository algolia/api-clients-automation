// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - Incident

/// Incident details.
public struct Incident: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(title: String? = nil, status: Status? = nil) {
        self.title = title
        self.status = status
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case title
        case status
    }

    /// Description of the incident.
    public var title: String?
    public var status: Status?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.title, forKey: .title)
        try container.encodeIfPresent(self.status, forKey: .status)
    }
}

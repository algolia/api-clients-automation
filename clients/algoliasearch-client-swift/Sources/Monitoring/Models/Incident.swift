// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Incident details.
public struct Incident: Codable, JSONEncodable {
    /// Description of the incident.
    public var title: String?
    public var status: Status?

    public init(title: String? = nil, status: Status? = nil) {
        self.title = title
        self.status = status
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case title
        case status
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.title, forKey: .title)
        try container.encodeIfPresent(self.status, forKey: .status)
    }
}

extension Incident: Equatable {
    public static func ==(lhs: Incident, rhs: Incident) -> Bool {
        lhs.title == rhs.title &&
            lhs.status == rhs.status
    }
}

extension Incident: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.title?.hashValue)
        hasher.combine(self.status?.hashValue)
    }
}

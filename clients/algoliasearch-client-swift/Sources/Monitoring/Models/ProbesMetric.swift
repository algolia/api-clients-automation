// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct ProbesMetric: Codable, JSONEncodable {
    /// Timestamp, measured in milliseconds since the Unix epoch.
    public var t: Int64?
    /// Value of the metric.
    public var v: Int?

    public init(t: Int64? = nil, v: Int? = nil) {
        self.t = t
        self.v = v
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case t
        case v
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.t, forKey: .t)
        try container.encodeIfPresent(self.v, forKey: .v)
    }
}

extension ProbesMetric: Equatable {
    public static func ==(lhs: ProbesMetric, rhs: ProbesMetric) -> Bool {
        lhs.t == rhs.t &&
            lhs.v == rhs.v
    }
}

extension ProbesMetric: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.t?.hashValue)
        hasher.combine(self.v?.hashValue)
    }
}

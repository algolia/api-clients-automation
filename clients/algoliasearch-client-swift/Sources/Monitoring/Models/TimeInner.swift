// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct TimeInner: Codable, JSONEncodable, Hashable {
    /** Timestamp in [Unix epoch time](https://wikipedia.org/wiki/Unix_time) in milliseconds. */
    public var t: Int64?
    /** Time in ms. */
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
        try container.encodeIfPresent(t, forKey: .t)
        try container.encodeIfPresent(v, forKey: .v)
    }
}

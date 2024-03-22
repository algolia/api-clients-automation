// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SearchFacetsStats: Codable, JSONEncodable {
    /// Minimum value in the results.
    public var min: Double?
    /// Maximum value in the results.
    public var max: Double?
    /// Average facet value in the results.
    public var avg: Double?
    /// Sum of all values in the results.
    public var sum: Double?

    public init(min: Double? = nil, max: Double? = nil, avg: Double? = nil, sum: Double? = nil) {
        self.min = min
        self.max = max
        self.avg = avg
        self.sum = sum
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case min
        case max
        case avg
        case sum
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.min, forKey: .min)
        try container.encodeIfPresent(self.max, forKey: .max)
        try container.encodeIfPresent(self.avg, forKey: .avg)
        try container.encodeIfPresent(self.sum, forKey: .sum)
    }
}

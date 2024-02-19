// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct GetTopFiltersNoResultsResponse: Codable, JSONEncodable, Hashable {
    /// Filters with no results.
    public var values: [GetTopFiltersNoResultsValues]

    public init(values: [GetTopFiltersNoResultsValues]) {
        self.values = values
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case values
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.values, forKey: .values)
    }
}

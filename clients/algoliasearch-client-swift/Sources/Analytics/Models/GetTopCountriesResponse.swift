// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetTopCountriesResponse: Codable, JSONEncodable, Hashable {
    /// Countries
    public var countries: [TopCountry]

    public init(countries: [TopCountry]) {
        self.countries = countries
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case countries
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.countries, forKey: .countries)
    }
}

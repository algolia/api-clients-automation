// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetSearchesNoClicksResponse: Codable, JSONEncodable {
    /// Searches without any clicks.
    public var searches: [DailySearchesNoClicks]

    public init(searches: [DailySearchesNoClicks]) {
        self.searches = searches
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case searches
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.searches, forKey: .searches)
    }
}

extension GetSearchesNoClicksResponse: Equatable {
    public static func ==(lhs: GetSearchesNoClicksResponse, rhs: GetSearchesNoClicksResponse) -> Bool {
        lhs.searches == rhs.searches
    }
}

extension GetSearchesNoClicksResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.searches.hashValue)
    }
}

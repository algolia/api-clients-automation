// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetObjectsResponse<T: Codable>: Codable, JSONEncodable {
    /// Retrieved records.
    public var results: [T]?

    public init(results: [T]? = nil) {
        self.results = results
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case results
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.results, forKey: .results)
    }
}

extension GetObjectsResponse: Equatable where T: Equatable {
    public static func ==(lhs: GetObjectsResponse<T>, rhs: GetObjectsResponse<T>) -> Bool {
        lhs.results == rhs.results
    }
}

extension GetObjectsResponse: Hashable where T: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.results?.hashValue)
    }
}

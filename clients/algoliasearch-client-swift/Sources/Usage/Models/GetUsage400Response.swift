// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetUsage400Response: Codable, JSONEncodable {
    public var error: GetUsage400ResponseError

    public init(error: GetUsage400ResponseError) {
        self.error = error
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case error
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.error, forKey: .error)
    }
}

extension GetUsage400Response: Equatable {
    public static func ==(lhs: GetUsage400Response, rhs: GetUsage400Response) -> Bool {
        lhs.error == rhs.error
    }
}

extension GetUsage400Response: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.error.hashValue)
    }
}

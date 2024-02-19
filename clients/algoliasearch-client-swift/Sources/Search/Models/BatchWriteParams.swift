// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

/// Batch parameters.
public struct BatchWriteParams: Codable, JSONEncodable, Hashable {
    public var requests: [BatchRequest]

    public init(requests: [BatchRequest]) {
        self.requests = requests
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case requests
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.requests, forKey: .requests)
    }
}

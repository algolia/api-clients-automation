// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Authentication input used for token credentials.
public struct AuthAPIKeyPartial: Codable, JSONEncodable, Hashable {
    public var key: String?

    public init(key: String? = nil) {
        self.key = key
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case key
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.key, forKey: .key)
    }
}

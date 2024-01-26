// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct SearchParamsString: Codable, JSONEncodable, Hashable {
    /** Search parameters as a URL-encoded query string. */
    public var params: String?

    public init(params: String? = nil) {
        self.params = params
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case params
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(params, forKey: .params)
    }
}

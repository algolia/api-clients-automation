// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct BaseResponse: Codable, JSONEncodable, Hashable {
    /// HTTP status code.
    public var status: Int?
    /// Details about the response, such as error messages.
    public var message: String?

    public init(status: Int? = nil, message: String? = nil) {
        self.status = status
        self.message = message
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case status
        case message
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.status, forKey: .status)
        try container.encodeIfPresent(self.message, forKey: .message)
    }
}

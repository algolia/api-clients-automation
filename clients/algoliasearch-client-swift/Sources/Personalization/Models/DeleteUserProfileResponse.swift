// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct DeleteUserProfileResponse: Codable, JSONEncodable, Hashable {
    /** userToken representing the user for which to fetch the Personalization profile. */
    public var userToken: String
    /** A date until which the data can safely be considered as deleted for the given user. Any data received after the `deletedUntil` date will start building a new user profile. */
    public var deletedUntil: String

    public init(userToken: String, deletedUntil: String) {
        self.userToken = userToken
        self.deletedUntil = deletedUntil
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case userToken
        case deletedUntil
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(userToken, forKey: .userToken)
        try container.encode(deletedUntil, forKey: .deletedUntil)
    }
}

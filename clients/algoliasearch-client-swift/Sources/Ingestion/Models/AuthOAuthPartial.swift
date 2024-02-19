// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Authentication input for OAuth login.
public struct AuthOAuthPartial: Codable, JSONEncodable, Hashable {
    /// The OAuth endpoint URL.
    public var url: String?
    /// The clientID.
    public var clientId: String?
    /// The secret.
    public var clientSecret: String?

    public init(url: String? = nil, clientId: String? = nil, clientSecret: String? = nil) {
        self.url = url
        self.clientId = clientId
        self.clientSecret = clientSecret
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case url
        case clientId = "client_id"
        case clientSecret = "client_secret"
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.url, forKey: .url)
        try container.encodeIfPresent(self.clientId, forKey: .clientId)
        try container.encodeIfPresent(self.clientSecret, forKey: .clientSecret)
    }
}

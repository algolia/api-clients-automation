// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Authentication input to connect to a Google service (e.g. BigQuery).
public struct AuthGoogleServiceAccount: Codable, JSONEncodable, Hashable {
    /// Email address of the Service Account.
    public var clientEmail: String
    /// Private key of the Service Account.
    public var privateKey: String

    public init(clientEmail: String, privateKey: String) {
        self.clientEmail = clientEmail
        self.privateKey = privateKey
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case clientEmail
        case privateKey
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.clientEmail, forKey: .clientEmail)
        try container.encode(self.privateKey, forKey: .privateKey)
    }
}

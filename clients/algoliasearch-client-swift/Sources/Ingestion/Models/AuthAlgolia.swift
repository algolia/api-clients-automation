// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct AuthAlgolia: Codable, JSONEncodable, Hashable {
    /// Algolia Application ID.
    public var appID: String
    /// Algolia API Key, with the correct rights to push to an index and change settings.
    public var apiKey: String

    public init(appID: String, apiKey: String) {
        self.appID = appID
        self.apiKey = apiKey
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case appID
        case apiKey
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.appID, forKey: .appID)
        try container.encode(self.apiKey, forKey: .apiKey)
    }
}

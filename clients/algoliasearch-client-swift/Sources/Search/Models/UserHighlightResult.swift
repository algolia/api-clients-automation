// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct UserHighlightResult: Codable, JSONEncodable, Hashable {
    public var userID: HighlightResult
    public var clusterName: HighlightResult

    public init(userID: HighlightResult, clusterName: HighlightResult) {
        self.userID = userID
        self.clusterName = clusterName
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case userID
        case clusterName
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(userID, forKey: .userID)
        try container.encode(clusterName, forKey: .clusterName)
    }
}

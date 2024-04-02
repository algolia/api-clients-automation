// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Record to promote.
public struct RecommendPromoteObjectID: Codable, JSONEncodable {
    /// Unique record identifier.
    public var objectID: String
    /// Position in the search results where you want to show the promoted records.
    public var position: Int

    public init(objectID: String, position: Int) {
        self.objectID = objectID
        self.position = position
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case objectID
        case position
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.objectID, forKey: .objectID)
        try container.encode(self.position, forKey: .position)
    }
}

extension RecommendPromoteObjectID: Equatable {
    public static func ==(lhs: RecommendPromoteObjectID, rhs: RecommendPromoteObjectID) -> Bool {
        lhs.objectID == rhs.objectID &&
            lhs.position == rhs.position
    }
}

extension RecommendPromoteObjectID: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.objectID.hashValue)
        hasher.combine(self.position.hashValue)
    }
}

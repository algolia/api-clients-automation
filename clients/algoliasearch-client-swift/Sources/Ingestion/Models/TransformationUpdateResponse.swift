// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// API response for updating a transformation.
public struct TransformationUpdateResponse: Codable, JSONEncodable {
    /// Universally unique identifier (UUID) of a transformation.
    public var transformationID: String
    /// Date of last update in RFC 3339 format.
    public var updatedAt: String

    public init(transformationID: String, updatedAt: String) {
        self.transformationID = transformationID
        self.updatedAt = updatedAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case transformationID
        case updatedAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.transformationID, forKey: .transformationID)
        try container.encode(self.updatedAt, forKey: .updatedAt)
    }
}

extension TransformationUpdateResponse: Equatable {
    public static func ==(lhs: TransformationUpdateResponse, rhs: TransformationUpdateResponse) -> Bool {
        lhs.transformationID == rhs.transformationID &&
            lhs.updatedAt == rhs.updatedAt
    }
}

extension TransformationUpdateResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.transformationID.hashValue)
        hasher.combine(self.updatedAt.hashValue)
    }
}

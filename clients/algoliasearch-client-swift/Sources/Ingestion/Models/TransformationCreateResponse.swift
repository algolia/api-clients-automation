// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// API response for creating a transformation.
public struct TransformationCreateResponse: Codable, JSONEncodable {
    /// Universally unique identifier (UUID) of a transformation.
    public var transformationID: String
    /// Date of creation in RFC 3339 format.
    public var createdAt: String

    public init(transformationID: String, createdAt: String) {
        self.transformationID = transformationID
        self.createdAt = createdAt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case transformationID
        case createdAt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.transformationID, forKey: .transformationID)
        try container.encode(self.createdAt, forKey: .createdAt)
    }
}

extension TransformationCreateResponse: Equatable {
    public static func ==(lhs: TransformationCreateResponse, rhs: TransformationCreateResponse) -> Bool {
        lhs.transformationID == rhs.transformationID &&
            lhs.createdAt == rhs.createdAt
    }
}

extension TransformationCreateResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.transformationID.hashValue)
        hasher.combine(self.createdAt.hashValue)
    }
}

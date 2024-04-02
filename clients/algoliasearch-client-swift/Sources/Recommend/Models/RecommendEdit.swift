// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct RecommendEdit: Codable, JSONEncodable {
    public var type: RecommendEditType?
    /// Text or patterns to remove from the query string.
    public var delete: String?
    /// Text to be added in place of the deleted text inside the query string.
    public var insert: String?

    public init(type: RecommendEditType? = nil, delete: String? = nil, insert: String? = nil) {
        self.type = type
        self.delete = delete
        self.insert = insert
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
        case delete
        case insert
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.type, forKey: .type)
        try container.encodeIfPresent(self.delete, forKey: .delete)
        try container.encodeIfPresent(self.insert, forKey: .insert)
    }
}

extension RecommendEdit: Equatable {
    public static func ==(lhs: RecommendEdit, rhs: RecommendEdit) -> Bool {
        lhs.type == rhs.type &&
            lhs.delete == rhs.delete &&
            lhs.insert == rhs.insert
    }
}

extension RecommendEdit: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.type?.hashValue)
        hasher.combine(self.delete?.hashValue)
        hasher.combine(self.insert?.hashValue)
    }
}

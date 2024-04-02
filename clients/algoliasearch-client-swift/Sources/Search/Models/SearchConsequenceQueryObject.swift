// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SearchConsequenceQueryObject: Codable, JSONEncodable {
    /// Words to remove from the search query.
    public var remove: [String]?
    /// Changes to make to the search query.
    public var edits: [SearchEdit]?

    public init(remove: [String]? = nil, edits: [SearchEdit]? = nil) {
        self.remove = remove
        self.edits = edits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case remove
        case edits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.remove, forKey: .remove)
        try container.encodeIfPresent(self.edits, forKey: .edits)
    }
}

extension SearchConsequenceQueryObject: Equatable {
    public static func ==(lhs: SearchConsequenceQueryObject, rhs: SearchConsequenceQueryObject) -> Bool {
        lhs.remove == rhs.remove &&
            lhs.edits == rhs.edits
    }
}

extension SearchConsequenceQueryObject: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.remove?.hashValue)
        hasher.combine(self.edits?.hashValue)
    }
}

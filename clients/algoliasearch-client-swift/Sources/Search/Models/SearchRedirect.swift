// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// [Redirect results to a
/// URL](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/redirects/).
public struct SearchRedirect: Codable, JSONEncodable {
    public var index: [SearchRedirectRuleIndexMetadata]?

    public init(index: [SearchRedirectRuleIndexMetadata]? = nil) {
        self.index = index
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case index
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.index, forKey: .index)
    }
}

extension SearchRedirect: Equatable {
    public static func ==(lhs: SearchRedirect, rhs: SearchRedirect) -> Bool {
        lhs.index == rhs.index
    }
}

extension SearchRedirect: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.index?.hashValue)
    }
}

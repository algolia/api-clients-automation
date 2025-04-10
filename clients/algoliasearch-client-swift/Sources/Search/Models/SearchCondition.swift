// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SearchCondition: Codable, JSONEncodable {
    /// Query pattern that triggers the rule.  You can use either a literal string, or a special pattern
    /// `{facet:ATTRIBUTE}`, where `ATTRIBUTE` is a facet name. The rule is triggered if the query matches the literal
    /// string or a value of the specified facet. For example, with `pattern: {facet:genre}`, the rule is triggered when
    /// users search for a genre, such as \"comedy\".
    public var pattern: String?
    public var anchoring: SearchAnchoring?
    /// Whether the pattern should match plurals, synonyms, and typos.
    public var alternatives: Bool?
    /// An additional restriction that only triggers the rule, when the search has the same value as `ruleContexts`
    /// parameter. For example, if `context: mobile`, the rule is only triggered when the search request has a matching
    /// `ruleContexts: mobile`. A rule context must only contain alphanumeric characters.
    public var context: String?
    /// Filters that trigger the rule.  You can add filters using the syntax `facet:value` so that the rule is
    /// triggered, when the specific filter is selected. You can use `filters` on its own or combine it with the
    /// `pattern` parameter. You can't combine multiple filters with `OR` and you can't use numeric filters.
    public var filters: String?

    public init(
        pattern: String? = nil,
        anchoring: SearchAnchoring? = nil,
        alternatives: Bool? = nil,
        context: String? = nil,
        filters: String? = nil
    ) {
        self.pattern = pattern
        self.anchoring = anchoring
        self.alternatives = alternatives
        self.context = context
        self.filters = filters
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case pattern
        case anchoring
        case alternatives
        case context
        case filters
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.pattern, forKey: .pattern)
        try container.encodeIfPresent(self.anchoring, forKey: .anchoring)
        try container.encodeIfPresent(self.alternatives, forKey: .alternatives)
        try container.encodeIfPresent(self.context, forKey: .context)
        try container.encodeIfPresent(self.filters, forKey: .filters)
    }
}

extension SearchCondition: Equatable {
    public static func ==(lhs: SearchCondition, rhs: SearchCondition) -> Bool {
        lhs.pattern == rhs.pattern &&
            lhs.anchoring == rhs.anchoring &&
            lhs.alternatives == rhs.alternatives &&
            lhs.context == rhs.context &&
            lhs.filters == rhs.filters
    }
}

extension SearchCondition: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.pattern?.hashValue)
        hasher.combine(self.anchoring?.hashValue)
        hasher.combine(self.alternatives?.hashValue)
        hasher.combine(self.context?.hashValue)
        hasher.combine(self.filters?.hashValue)
    }
}

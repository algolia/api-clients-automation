// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Query Suggestions configuration.
public struct QuerySuggestionsConfiguration: Codable, JSONEncodable {
    /// Algolia indices from which to get the popular searches for query suggestions.
    public var sourceIndices: [SourceIndex]
    public var languages: QuerySuggestionsLanguages?
    public var exclude: [String]?
    /// Whether to turn on personalized query suggestions.
    public var enablePersonalization: Bool?
    /// Whether to include suggestions with special characters.
    public var allowSpecialCharacters: Bool?

    public init(
        sourceIndices: [SourceIndex],
        languages: QuerySuggestionsLanguages? = nil,
        exclude: [String]? = nil,
        enablePersonalization: Bool? = nil,
        allowSpecialCharacters: Bool? = nil
    ) {
        self.sourceIndices = sourceIndices
        self.languages = languages
        self.exclude = exclude
        self.enablePersonalization = enablePersonalization
        self.allowSpecialCharacters = allowSpecialCharacters
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case sourceIndices
        case languages
        case exclude
        case enablePersonalization
        case allowSpecialCharacters
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.sourceIndices, forKey: .sourceIndices)
        try container.encodeIfPresent(self.languages, forKey: .languages)
        try container.encodeIfPresent(self.exclude, forKey: .exclude)
        try container.encodeIfPresent(self.enablePersonalization, forKey: .enablePersonalization)
        try container.encodeIfPresent(self.allowSpecialCharacters, forKey: .allowSpecialCharacters)
    }
}

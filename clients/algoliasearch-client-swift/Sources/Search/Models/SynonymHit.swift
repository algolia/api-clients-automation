// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// Synonym object.
public struct SynonymHit: Codable, JSONEncodable, Hashable {
    /// Unique identifier of a synonym object.
    public var objectID: String
    public var type: SynonymType
    /// Words or phrases considered equivalent.
    public var synonyms: [String]?
    /// Word or phrase to appear in query strings (for [`onewaysynonym`s](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/one-way-synonyms/)).
    public var input: String?
    /// Word or phrase to appear in query strings (for [`altcorrection1` and `altcorrection2`](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-alternative-corrections/)).
    public var word: String?
    /// Words to be matched in records.
    public var corrections: [String]?
    /// [Placeholder token](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-placeholders/)
    /// to be put inside records.
    public var placeholder: String?
    /// Query words that will match the [placeholder token](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/in-depth/synonyms-placeholders/).
    public var replacements: [String]?

    public init(
        objectID: String,
        type: SynonymType,
        synonyms: [String]? = nil,
        input: String? = nil,
        word: String? = nil,
        corrections: [String]? = nil,
        placeholder: String? = nil,
        replacements: [String]? = nil
    ) {
        self.objectID = objectID
        self.type = type
        self.synonyms = synonyms
        self.input = input
        self.word = word
        self.corrections = corrections
        self.placeholder = placeholder
        self.replacements = replacements
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case objectID
        case type
        case synonyms
        case input
        case word
        case corrections
        case placeholder
        case replacements
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.objectID, forKey: .objectID)
        try container.encode(self.type, forKey: .type)
        try container.encodeIfPresent(self.synonyms, forKey: .synonyms)
        try container.encodeIfPresent(self.input, forKey: .input)
        try container.encodeIfPresent(self.word, forKey: .word)
        try container.encodeIfPresent(self.corrections, forKey: .corrections)
        try container.encodeIfPresent(self.placeholder, forKey: .placeholder)
        try container.encodeIfPresent(self.replacements, forKey: .replacements)
    }
}

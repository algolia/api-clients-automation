// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct RecommendBaseIndexSettings: Codable, JSONEncodable {
    /// Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/). 
    /// Facets are attributes that let you categorize search results. They can be used for filtering search results. By
    /// default, no attribute is used for faceting. Attribute names are case-sensitive.  **Modifiers**  -
    /// `filterOnly(\"ATTRIBUTE\")`.   Allows the attribute to be used as a filter but doesn't evaluate the facet
    /// values.  - `searchable(\"ATTRIBUTE\")`.   Allows searching for facet values.  - `afterDistinct(\"ATTRIBUTE\")`. 
    ///  Evaluates the facet count _after_ deduplication with `distinct`.   This ensures accurate facet counts.   You
    /// can apply this modifier to searchable facets: `afterDistinct(searchable(ATTRIBUTE))`.
    public var attributesForFaceting: [String]?
    /// Creates [replica
    /// indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/). 
    /// Replicas are copies of a primary index with the same records but different settings, synonyms, or rules. If you
    /// want to offer a different ranking or sorting of your search results, you'll use replica indices. All index
    /// operations on a primary index are automatically forwarded to its replicas. To add a replica index, you must
    /// provide the complete set of replicas to this parameter. If you omit a replica from this list, the replica turns
    /// into a regular, standalone index that will no longer be synced with the primary index.  **Modifier**  -
    /// `virtual(\"REPLICA\")`.   Create a virtual replica,   Virtual replicas don't increase the number of records and
    /// are optimized for [Relevant
    /// sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/relevant-sort/).
    public var replicas: [String]?
    /// Maximum number of search results that can be obtained through pagination.  Higher pagination limits might slow
    /// down your search. For pagination limits above 1,000, the sorting of results beyond the 1,000th hit can't be
    /// guaranteed.
    public var paginationLimitedTo: Int?
    /// Attributes that can't be retrieved at query time.  This can be useful if you want to use an attribute for
    /// ranking or to [restrict
    /// access](https://www.algolia.com/doc/guides/security/api-keys/how-to/user-restricted-access-to-data/), but don't
    /// want to include it in the search results. Attribute names are case-sensitive.
    public var unretrievableAttributes: [String]?
    /// Creates a list of [words which require exact matches](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#turn-off-typo-tolerance-for-certain-words).
    /// This also turns off [word splitting and concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/)
    /// for the specified words.
    public var disableTypoToleranceOnWords: [String]?
    /// Attributes, for which you want to support [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead).
    ///  Transliteration supports searching in any of the Japanese writing systems. To support transliteration, you must
    /// set the indexing language to Japanese. Attribute names are case-sensitive.
    public var attributesToTransliterate: [String]?
    /// Attributes for which to split [camel case](https://wikipedia.org/wiki/Camel_case) words. Attribute names are
    /// case-sensitive.
    public var camelCaseAttributes: [String]?
    /// Searchable attributes to which Algolia should apply [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/)
    /// (decompounding). Attribute names are case-sensitive.  Compound words are formed by combining two or more
    /// individual words, and are particularly prevalent in Germanic languages—for example, \"firefighter\". With
    /// decompounding, the individual components are indexed separately.  You can specify different lists for different
    /// languages. Decompounding is supported for these languages: Dutch (`nl`), German (`de`), Finnish (`fi`), Danish
    /// (`da`), Swedish (`sv`), and Norwegian (`no`). Decompounding doesn't work for words with [non-spacing mark
    /// Unicode characters](https://www.charactercodes.net/category/non-spacing_mark). For example, `Gartenstühle` won't
    /// be decompounded if the `ü` consists of `u` (U+0075) and `◌̈` (U+0308).
    public var decompoundedAttributes: AnyCodable?
    /// Languages for language-specific processing steps, such as word detection and dictionary settings.  **You should
    /// always specify an indexing language.** If you don't specify an indexing language, the search engine uses all
    /// [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/),
    /// or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to
    /// unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
    public var indexLanguages: [RecommendSupportedLanguage]?
    /// Searchable attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search).
    /// Attribute names are case-sensitive.
    public var disablePrefixOnAttributes: [String]?
    /// Whether arrays with exclusively non-negative integers should be compressed for better performance. If true, the
    /// compressed arrays may be reordered.
    public var allowCompressionOfIntegerArray: Bool?
    /// Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters).
    /// Attribute names are case-sensitive.  By default, all numeric attributes are available as numerical filters. For
    /// faster indexing, reduce the number of numeric attributes.  To turn off filtering for all numeric attributes,
    /// specify an attribute that doesn't exist in your index, such as `NO_NUMERIC_FILTERING`.  **Modifier**  -
    /// `equalOnly(\"ATTRIBUTE\")`.   Support only filtering based on equality comparisons `=` and `!=`.
    public var numericAttributesForFiltering: [String]?
    /// Control which non-alphanumeric characters are indexed.  By default, Algolia ignores [non-alphanumeric characters](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/#handling-non-alphanumeric-characters)
    /// like hyphen (`-`), plus (`+`), and parentheses (`(`,`)`). To include such characters, define them with
    /// `separatorsToIndex`.  Separators are all non-letter characters except spaces and currency characters, such as
    /// $€£¥.  With `separatorsToIndex`, Algolia treats separator characters as separate words. For example, in a search
    /// for \"Disney+\", Algolia considers \"Disney\" and \"+\" as two separate words.
    public var separatorsToIndex: String?
    /// Attributes used for searching. Attribute names are case-sensitive.  By default, all attributes are searchable
    /// and the [Attribute](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute)
    /// ranking criterion is turned off. With a non-empty list, Algolia only returns results with matches in the
    /// selected attributes. In addition, the Attribute ranking criterion is turned on: matches in attributes that are
    /// higher in the list of `searchableAttributes` rank first. To make matches in two attributes rank equally, include
    /// them in a comma-separated string, such as `\"title,alternate_title\"`. Attributes with the same priority are
    /// always unordered.  For more information, see [Searchable attributes](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/setting-searchable-attributes/).
    ///  **Modifier**  - `unordered(\"ATTRIBUTE\")`.   Ignore the position of a match within the attribute.  Without a
    /// modifier, matches at the beginning of an attribute rank higher than matches at the end.
    public var searchableAttributes: [String]?
    /// An object with custom data.  You can store up to 32kB as custom data.
    public var userData: AnyCodable?
    /// Characters and their normalized replacements. This overrides Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
    public var customNormalization: [String: [String: String]]?
    /// Attribute that should be used to establish groups of results. Attribute names are case-sensitive.  All records
    /// with the same value for this attribute are considered a group. You can combine `attributeForDistinct` with the
    /// `distinct` search parameter to control how many items per group are included in the search results.  If you want
    /// to use the same attribute also for faceting, use the `afterDistinct` modifier of the `attributesForFaceting`
    /// setting. This applies faceting _after_ deduplication, which will result in accurate facet counts.
    public var attributeForDistinct: String?
    /// Maximum number of facet values to return when [searching for facet
    /// values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
    public var maxFacetHits: Int?

    public init(
        attributesForFaceting: [String]? = nil,
        replicas: [String]? = nil,
        paginationLimitedTo: Int? = nil,
        unretrievableAttributes: [String]? = nil,
        disableTypoToleranceOnWords: [String]? = nil,
        attributesToTransliterate: [String]? = nil,
        camelCaseAttributes: [String]? = nil,
        decompoundedAttributes: AnyCodable? = nil,
        indexLanguages: [RecommendSupportedLanguage]? = nil,
        disablePrefixOnAttributes: [String]? = nil,
        allowCompressionOfIntegerArray: Bool? = nil,
        numericAttributesForFiltering: [String]? = nil,
        separatorsToIndex: String? = nil,
        searchableAttributes: [String]? = nil,
        userData: AnyCodable? = nil,
        customNormalization: [String: [String: String]]? = nil,
        attributeForDistinct: String? = nil,
        maxFacetHits: Int? = nil
    ) {
        self.attributesForFaceting = attributesForFaceting
        self.replicas = replicas
        self.paginationLimitedTo = paginationLimitedTo
        self.unretrievableAttributes = unretrievableAttributes
        self.disableTypoToleranceOnWords = disableTypoToleranceOnWords
        self.attributesToTransliterate = attributesToTransliterate
        self.camelCaseAttributes = camelCaseAttributes
        self.decompoundedAttributes = decompoundedAttributes
        self.indexLanguages = indexLanguages
        self.disablePrefixOnAttributes = disablePrefixOnAttributes
        self.allowCompressionOfIntegerArray = allowCompressionOfIntegerArray
        self.numericAttributesForFiltering = numericAttributesForFiltering
        self.separatorsToIndex = separatorsToIndex
        self.searchableAttributes = searchableAttributes
        self.userData = userData
        self.customNormalization = customNormalization
        self.attributeForDistinct = attributeForDistinct
        self.maxFacetHits = maxFacetHits
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case attributesForFaceting
        case replicas
        case paginationLimitedTo
        case unretrievableAttributes
        case disableTypoToleranceOnWords
        case attributesToTransliterate
        case camelCaseAttributes
        case decompoundedAttributes
        case indexLanguages
        case disablePrefixOnAttributes
        case allowCompressionOfIntegerArray
        case numericAttributesForFiltering
        case separatorsToIndex
        case searchableAttributes
        case userData
        case customNormalization
        case attributeForDistinct
        case maxFacetHits
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.attributesForFaceting, forKey: .attributesForFaceting)
        try container.encodeIfPresent(self.replicas, forKey: .replicas)
        try container.encodeIfPresent(self.paginationLimitedTo, forKey: .paginationLimitedTo)
        try container.encodeIfPresent(self.unretrievableAttributes, forKey: .unretrievableAttributes)
        try container.encodeIfPresent(self.disableTypoToleranceOnWords, forKey: .disableTypoToleranceOnWords)
        try container.encodeIfPresent(self.attributesToTransliterate, forKey: .attributesToTransliterate)
        try container.encodeIfPresent(self.camelCaseAttributes, forKey: .camelCaseAttributes)
        try container.encodeIfPresent(self.decompoundedAttributes, forKey: .decompoundedAttributes)
        try container.encodeIfPresent(self.indexLanguages, forKey: .indexLanguages)
        try container.encodeIfPresent(self.disablePrefixOnAttributes, forKey: .disablePrefixOnAttributes)
        try container.encodeIfPresent(self.allowCompressionOfIntegerArray, forKey: .allowCompressionOfIntegerArray)
        try container.encodeIfPresent(self.numericAttributesForFiltering, forKey: .numericAttributesForFiltering)
        try container.encodeIfPresent(self.separatorsToIndex, forKey: .separatorsToIndex)
        try container.encodeIfPresent(self.searchableAttributes, forKey: .searchableAttributes)
        try container.encodeIfPresent(self.userData, forKey: .userData)
        try container.encodeIfPresent(self.customNormalization, forKey: .customNormalization)
        try container.encodeIfPresent(self.attributeForDistinct, forKey: .attributeForDistinct)
        try container.encodeIfPresent(self.maxFacetHits, forKey: .maxFacetHits)
    }
}

extension RecommendBaseIndexSettings: Equatable {
    public static func ==(lhs: RecommendBaseIndexSettings, rhs: RecommendBaseIndexSettings) -> Bool {
        lhs.attributesForFaceting == rhs.attributesForFaceting &&
            lhs.replicas == rhs.replicas &&
            lhs.paginationLimitedTo == rhs.paginationLimitedTo &&
            lhs.unretrievableAttributes == rhs.unretrievableAttributes &&
            lhs.disableTypoToleranceOnWords == rhs.disableTypoToleranceOnWords &&
            lhs.attributesToTransliterate == rhs.attributesToTransliterate &&
            lhs.camelCaseAttributes == rhs.camelCaseAttributes &&
            lhs.decompoundedAttributes == rhs.decompoundedAttributes &&
            lhs.indexLanguages == rhs.indexLanguages &&
            lhs.disablePrefixOnAttributes == rhs.disablePrefixOnAttributes &&
            lhs.allowCompressionOfIntegerArray == rhs.allowCompressionOfIntegerArray &&
            lhs.numericAttributesForFiltering == rhs.numericAttributesForFiltering &&
            lhs.separatorsToIndex == rhs.separatorsToIndex &&
            lhs.searchableAttributes == rhs.searchableAttributes &&
            lhs.userData == rhs.userData &&
            lhs.customNormalization == rhs.customNormalization &&
            lhs.attributeForDistinct == rhs.attributeForDistinct &&
            lhs.maxFacetHits == rhs.maxFacetHits
    }
}

extension RecommendBaseIndexSettings: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.attributesForFaceting?.hashValue)
        hasher.combine(self.replicas?.hashValue)
        hasher.combine(self.paginationLimitedTo?.hashValue)
        hasher.combine(self.unretrievableAttributes?.hashValue)
        hasher.combine(self.disableTypoToleranceOnWords?.hashValue)
        hasher.combine(self.attributesToTransliterate?.hashValue)
        hasher.combine(self.camelCaseAttributes?.hashValue)
        hasher.combine(self.decompoundedAttributes?.hashValue)
        hasher.combine(self.indexLanguages?.hashValue)
        hasher.combine(self.disablePrefixOnAttributes?.hashValue)
        hasher.combine(self.allowCompressionOfIntegerArray?.hashValue)
        hasher.combine(self.numericAttributesForFiltering?.hashValue)
        hasher.combine(self.separatorsToIndex?.hashValue)
        hasher.combine(self.searchableAttributes?.hashValue)
        hasher.combine(self.userData?.hashValue)
        hasher.combine(self.customNormalization?.hashValue)
        hasher.combine(self.attributeForDistinct?.hashValue)
        hasher.combine(self.maxFacetHits?.hashValue)
    }
}

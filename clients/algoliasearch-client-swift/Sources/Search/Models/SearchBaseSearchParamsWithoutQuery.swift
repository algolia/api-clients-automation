// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SearchBaseSearchParamsWithoutQuery: Codable, JSONEncodable {
    /// Keywords to be used instead of the search query to conduct a more broader search.  Using the `similarQuery`
    /// parameter changes other settings:  - `queryType` is set to `prefixNone`. - `removeStopWords` is set to true. -
    /// `words` is set as the first ranking criterion. - All remaining words are treated as `optionalWords`.  Since the
    /// `similarQuery` is supposed to do a broad search, they usually return many results. Combine it with `filters` to
    /// narrow down the list of results.
    public var similarQuery: String?
    /// Filter expression to only include items that match the filter criteria in the response.  You can use these
    /// filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`,
    /// `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and
    /// upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet
    /// attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>`
    /// (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and
    /// `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.  
    /// **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not
    /// supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not
    /// supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet
    /// attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an
    /// array, the filter matches if it matches at least one element of the array.  For more information, see
    /// [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
    public var filters: String?
    public var facetFilters: SearchFacetFilters?
    public var optionalFilters: SearchOptionalFilters?
    public var numericFilters: SearchNumericFilters?
    public var tagFilters: SearchTagFilters?
    /// Whether to sum all filter scores.  If true, all filter scores are summed. Otherwise, the maximum filter score is
    /// kept. For more information, see [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
    public var sumOrFiltersScores: Bool?
    /// Restricts a search to a subset of your searchable attributes. Attribute names are case-sensitive.
    public var restrictSearchableAttributes: [String]?
    /// Facets for which to retrieve facet values that match the search criteria and the number of matching facet
    /// values.  To retrieve all facets, use the wildcard character `*`. For more information, see [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).
    public var facets: [String]?
    /// Whether faceting should be applied after deduplication with `distinct`.  This leads to accurate facet counts
    /// when using faceting in combination with `distinct`. It's usually better to use `afterDistinct` modifiers in the
    /// `attributesForFaceting` setting, as `facetingAfterDistinct` only computes correct facet counts if all records
    /// have the same facet values for the `attributeForDistinct`.
    public var facetingAfterDistinct: Bool?
    /// Page of search results to retrieve.
    public var page: Int?
    /// Position of the first hit to retrieve.
    public var offset: Int?
    /// Number of hits to retrieve (used in combination with `offset`).
    public var length: Int?
    /// Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only
    /// records included within a circle around this central location are included in the results. The radius of the
    /// circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you
    /// also specify `insidePolygon` or `insideBoundingBox`.
    public var aroundLatLng: String?
    /// Whether to obtain the coordinates from the request's IP address.
    public var aroundLatLngViaIP: Bool?
    public var aroundRadius: SearchAroundRadius?
    public var aroundPrecision: SearchAroundPrecision?
    /// Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
    public var minimumAroundRadius: Int?
    public var insideBoundingBox: SearchInsideBoundingBox?
    /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is
    /// represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see
    /// [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
    /// This parameter is ignored if you also specify `insideBoundingBox`.
    public var insidePolygon: [[Double]]?
    /// ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to
    /// keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets
    /// `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and
    /// `analyticsTags`.
    public var naturalLanguages: [SearchSupportedLanguage]?
    /// Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context)
    /// are strings that you can use to trigger matching rules.
    public var ruleContexts: [String]?
    /// Impact that Personalization should have on this search.  The higher this value is, the more Personalization
    /// determines the ranking compared to other factors. For more information, see [Understanding Personalization impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
    public var personalizationImpact: Int?
    /// Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events.
    /// For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
    public var userToken: String?
    /// Whether the search response should include detailed ranking information.
    public var getRankingInfo: Bool?
    /// Whether to take into account an index's synonyms for this search.
    public var synonyms: Bool?
    /// Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search
    /// query and is required for tracking [click and conversion
    /// events](https://www.algolia.com/guides/sending-events/getting-started/).
    public var clickAnalytics: Bool?
    /// Whether this search will be included in Analytics.
    public var analytics: Bool?
    /// Tags to apply to the query for [segmenting analytics
    /// data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
    public var analyticsTags: [String]?
    /// Whether to include this search when calculating processing-time percentiles.
    public var percentileComputation: Bool?
    /// Whether to enable A/B testing for this search.
    public var enableABTest: Bool?

    public init(
        similarQuery: String? = nil,
        filters: String? = nil,
        facetFilters: SearchFacetFilters? = nil,
        optionalFilters: SearchOptionalFilters? = nil,
        numericFilters: SearchNumericFilters? = nil,
        tagFilters: SearchTagFilters? = nil,
        sumOrFiltersScores: Bool? = nil,
        restrictSearchableAttributes: [String]? = nil,
        facets: [String]? = nil,
        facetingAfterDistinct: Bool? = nil,
        page: Int? = nil,
        offset: Int? = nil,
        length: Int? = nil,
        aroundLatLng: String? = nil,
        aroundLatLngViaIP: Bool? = nil,
        aroundRadius: SearchAroundRadius? = nil,
        aroundPrecision: SearchAroundPrecision? = nil,
        minimumAroundRadius: Int? = nil,
        insideBoundingBox: SearchInsideBoundingBox? = nil,
        insidePolygon: [[Double]]? = nil,
        naturalLanguages: [SearchSupportedLanguage]? = nil,
        ruleContexts: [String]? = nil,
        personalizationImpact: Int? = nil,
        userToken: String? = nil,
        getRankingInfo: Bool? = nil,
        synonyms: Bool? = nil,
        clickAnalytics: Bool? = nil,
        analytics: Bool? = nil,
        analyticsTags: [String]? = nil,
        percentileComputation: Bool? = nil,
        enableABTest: Bool? = nil
    ) {
        self.similarQuery = similarQuery
        self.filters = filters
        self.facetFilters = facetFilters
        self.optionalFilters = optionalFilters
        self.numericFilters = numericFilters
        self.tagFilters = tagFilters
        self.sumOrFiltersScores = sumOrFiltersScores
        self.restrictSearchableAttributes = restrictSearchableAttributes
        self.facets = facets
        self.facetingAfterDistinct = facetingAfterDistinct
        self.page = page
        self.offset = offset
        self.length = length
        self.aroundLatLng = aroundLatLng
        self.aroundLatLngViaIP = aroundLatLngViaIP
        self.aroundRadius = aroundRadius
        self.aroundPrecision = aroundPrecision
        self.minimumAroundRadius = minimumAroundRadius
        self.insideBoundingBox = insideBoundingBox
        self.insidePolygon = insidePolygon
        self.naturalLanguages = naturalLanguages
        self.ruleContexts = ruleContexts
        self.personalizationImpact = personalizationImpact
        self.userToken = userToken
        self.getRankingInfo = getRankingInfo
        self.synonyms = synonyms
        self.clickAnalytics = clickAnalytics
        self.analytics = analytics
        self.analyticsTags = analyticsTags
        self.percentileComputation = percentileComputation
        self.enableABTest = enableABTest
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case similarQuery
        case filters
        case facetFilters
        case optionalFilters
        case numericFilters
        case tagFilters
        case sumOrFiltersScores
        case restrictSearchableAttributes
        case facets
        case facetingAfterDistinct
        case page
        case offset
        case length
        case aroundLatLng
        case aroundLatLngViaIP
        case aroundRadius
        case aroundPrecision
        case minimumAroundRadius
        case insideBoundingBox
        case insidePolygon
        case naturalLanguages
        case ruleContexts
        case personalizationImpact
        case userToken
        case getRankingInfo
        case synonyms
        case clickAnalytics
        case analytics
        case analyticsTags
        case percentileComputation
        case enableABTest
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.similarQuery, forKey: .similarQuery)
        try container.encodeIfPresent(self.filters, forKey: .filters)
        try container.encodeIfPresent(self.facetFilters, forKey: .facetFilters)
        try container.encodeIfPresent(self.optionalFilters, forKey: .optionalFilters)
        try container.encodeIfPresent(self.numericFilters, forKey: .numericFilters)
        try container.encodeIfPresent(self.tagFilters, forKey: .tagFilters)
        try container.encodeIfPresent(self.sumOrFiltersScores, forKey: .sumOrFiltersScores)
        try container.encodeIfPresent(self.restrictSearchableAttributes, forKey: .restrictSearchableAttributes)
        try container.encodeIfPresent(self.facets, forKey: .facets)
        try container.encodeIfPresent(self.facetingAfterDistinct, forKey: .facetingAfterDistinct)
        try container.encodeIfPresent(self.page, forKey: .page)
        try container.encodeIfPresent(self.offset, forKey: .offset)
        try container.encodeIfPresent(self.length, forKey: .length)
        try container.encodeIfPresent(self.aroundLatLng, forKey: .aroundLatLng)
        try container.encodeIfPresent(self.aroundLatLngViaIP, forKey: .aroundLatLngViaIP)
        try container.encodeIfPresent(self.aroundRadius, forKey: .aroundRadius)
        try container.encodeIfPresent(self.aroundPrecision, forKey: .aroundPrecision)
        try container.encodeIfPresent(self.minimumAroundRadius, forKey: .minimumAroundRadius)
        try container.encodeIfPresent(self.insideBoundingBox, forKey: .insideBoundingBox)
        try container.encodeIfPresent(self.insidePolygon, forKey: .insidePolygon)
        try container.encodeIfPresent(self.naturalLanguages, forKey: .naturalLanguages)
        try container.encodeIfPresent(self.ruleContexts, forKey: .ruleContexts)
        try container.encodeIfPresent(self.personalizationImpact, forKey: .personalizationImpact)
        try container.encodeIfPresent(self.userToken, forKey: .userToken)
        try container.encodeIfPresent(self.getRankingInfo, forKey: .getRankingInfo)
        try container.encodeIfPresent(self.synonyms, forKey: .synonyms)
        try container.encodeIfPresent(self.clickAnalytics, forKey: .clickAnalytics)
        try container.encodeIfPresent(self.analytics, forKey: .analytics)
        try container.encodeIfPresent(self.analyticsTags, forKey: .analyticsTags)
        try container.encodeIfPresent(self.percentileComputation, forKey: .percentileComputation)
        try container.encodeIfPresent(self.enableABTest, forKey: .enableABTest)
    }
}

extension SearchBaseSearchParamsWithoutQuery: Equatable {
    public static func ==(lhs: SearchBaseSearchParamsWithoutQuery, rhs: SearchBaseSearchParamsWithoutQuery) -> Bool {
        lhs.similarQuery == rhs.similarQuery &&
            lhs.filters == rhs.filters &&
            lhs.facetFilters == rhs.facetFilters &&
            lhs.optionalFilters == rhs.optionalFilters &&
            lhs.numericFilters == rhs.numericFilters &&
            lhs.tagFilters == rhs.tagFilters &&
            lhs.sumOrFiltersScores == rhs.sumOrFiltersScores &&
            lhs.restrictSearchableAttributes == rhs.restrictSearchableAttributes &&
            lhs.facets == rhs.facets &&
            lhs.facetingAfterDistinct == rhs.facetingAfterDistinct &&
            lhs.page == rhs.page &&
            lhs.offset == rhs.offset &&
            lhs.length == rhs.length &&
            lhs.aroundLatLng == rhs.aroundLatLng &&
            lhs.aroundLatLngViaIP == rhs.aroundLatLngViaIP &&
            lhs.aroundRadius == rhs.aroundRadius &&
            lhs.aroundPrecision == rhs.aroundPrecision &&
            lhs.minimumAroundRadius == rhs.minimumAroundRadius &&
            lhs.insideBoundingBox == rhs.insideBoundingBox &&
            lhs.insidePolygon == rhs.insidePolygon &&
            lhs.naturalLanguages == rhs.naturalLanguages &&
            lhs.ruleContexts == rhs.ruleContexts &&
            lhs.personalizationImpact == rhs.personalizationImpact &&
            lhs.userToken == rhs.userToken &&
            lhs.getRankingInfo == rhs.getRankingInfo &&
            lhs.synonyms == rhs.synonyms &&
            lhs.clickAnalytics == rhs.clickAnalytics &&
            lhs.analytics == rhs.analytics &&
            lhs.analyticsTags == rhs.analyticsTags &&
            lhs.percentileComputation == rhs.percentileComputation &&
            lhs.enableABTest == rhs.enableABTest
    }
}

extension SearchBaseSearchParamsWithoutQuery: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.similarQuery?.hashValue)
        hasher.combine(self.filters?.hashValue)
        hasher.combine(self.facetFilters?.hashValue)
        hasher.combine(self.optionalFilters?.hashValue)
        hasher.combine(self.numericFilters?.hashValue)
        hasher.combine(self.tagFilters?.hashValue)
        hasher.combine(self.sumOrFiltersScores?.hashValue)
        hasher.combine(self.restrictSearchableAttributes?.hashValue)
        hasher.combine(self.facets?.hashValue)
        hasher.combine(self.facetingAfterDistinct?.hashValue)
        hasher.combine(self.page?.hashValue)
        hasher.combine(self.offset?.hashValue)
        hasher.combine(self.length?.hashValue)
        hasher.combine(self.aroundLatLng?.hashValue)
        hasher.combine(self.aroundLatLngViaIP?.hashValue)
        hasher.combine(self.aroundRadius?.hashValue)
        hasher.combine(self.aroundPrecision?.hashValue)
        hasher.combine(self.minimumAroundRadius?.hashValue)
        hasher.combine(self.insideBoundingBox?.hashValue)
        hasher.combine(self.insidePolygon?.hashValue)
        hasher.combine(self.naturalLanguages?.hashValue)
        hasher.combine(self.ruleContexts?.hashValue)
        hasher.combine(self.personalizationImpact?.hashValue)
        hasher.combine(self.userToken?.hashValue)
        hasher.combine(self.getRankingInfo?.hashValue)
        hasher.combine(self.synonyms?.hashValue)
        hasher.combine(self.clickAnalytics?.hashValue)
        hasher.combine(self.analytics?.hashValue)
        hasher.combine(self.analyticsTags?.hashValue)
        hasher.combine(self.percentileComputation?.hashValue)
        hasher.combine(self.enableABTest?.hashValue)
    }
}

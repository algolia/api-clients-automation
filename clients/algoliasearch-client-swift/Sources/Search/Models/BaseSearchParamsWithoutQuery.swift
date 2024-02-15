// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct BaseSearchParamsWithoutQuery: Codable, JSONEncodable, Hashable {
    static let lengthRule = NumericRule<Int>(
        minimum: 1,
        exclusiveMinimum: false,
        maximum: 1000,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    static let minimumAroundRadiusRule = NumericRule<Int>(
        minimum: 1,
        exclusiveMinimum: false,
        maximum: nil,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    /// Overrides the query parameter and performs a more generic search.
    public var similarQuery: String?
    /// [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric,
    /// facet, or tag filters.
    public var filters: String?
    public var facetFilters: FacetFilters?
    public var optionalFilters: OptionalFilters?
    public var numericFilters: NumericFilters?
    public var tagFilters: TagFilters?
    /// Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
    /// If `false`, maximum score is kept. If `true`, score is summed.
    public var sumOrFiltersScores: Bool?
    /// Restricts a query to only look at a subset of your [searchable
    /// attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/).
    public var restrictSearchableAttributes: [String]?
    /// Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts),
    /// their facet values, and the number of matching facet values.
    public var facets: [String]?
    /// Forces faceting to be applied after
    /// [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the
    /// distinct feature). Alternatively, the `afterDistinct`
    /// [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of
    /// `attributesForFaceting` allows for more granular control.
    public var facetingAfterDistinct: Bool?
    /// Page to retrieve (the first page is `0`, not `1`).
    public var page: Int?
    /// Specifies the offset of the first hit to return. > **Note**: Using `page` and `hitsPerPage` is the recommended
    /// method for [paging
    /// results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you
    /// can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).
    public var offset: Int?
    /// Sets the number of hits to retrieve (for use with `offset`). > **Note**: Using `page` and `hitsPerPage` is the
    /// recommended method for [paging
    /// results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you
    /// can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).
    public var length: Int?
    /// Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point),
    /// enabling a geographical search within a circular area.
    public var aroundLatLng: String?
    /// Search for entries around a location. The location is automatically computed from the requester's IP address.
    public var aroundLatLngViaIP: Bool?
    public var aroundRadius: AroundRadius?
    public var aroundPrecision: AroundPrecision?
    /// Minimum radius (in meters) used for a geographical search when `aroundRadius` isn't set.
    public var minimumAroundRadius: Int?
    /// Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas)
    /// (in geographical coordinates).
    public var insideBoundingBox: [[Double]]?
    /// Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas)
    /// (in geographical coordinates).
    public var insidePolygon: [[Double]]?
    /// Changes the default values of parameters that work best for a natural language query, such as `ignorePlurals`,
    /// `removeStopWords`, `removeWordsIfNoResults`, `analyticsTags`, and `ruleContexts`. These parameters work well
    /// together when the query consists of fuller natural language strings instead of keywords, for example when
    /// processing voice search queries.
    public var naturalLanguages: [String]?
    /// Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context)
    /// to search queries.
    public var ruleContexts: [String]?
    /// Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
    public var personalizationImpact: Int?
    /// Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the
    /// current search.
    public var userToken: String?
    /// Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information).
    public var getRankingInfo: Bool?
    /// Enriches the API's response with information about how the query was processed.
    public var explain: [String]?
    /// Whether to take into account an index's synonyms for a particular search.
    public var synonyms: Bool?
    /// Indicates whether a query ID parameter is included in the search response. This is required for [tracking click
    /// and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests).
    public var clickAnalytics: Bool?
    /// Indicates whether this query will be included in
    /// [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/).
    public var analytics: Bool?
    /// Tags to apply to the query for [segmenting analytics
    /// data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
    public var analyticsTags: [String]?
    /// Whether to include or exclude a query from the processing-time percentile computation.
    public var percentileComputation: Bool?
    /// Incidates whether this search will be considered in A/B testing.
    public var enableABTest: Bool?

    public init(
        similarQuery: String? = nil,
        filters: String? = nil,
        facetFilters: FacetFilters? = nil,
        optionalFilters: OptionalFilters? = nil,
        numericFilters: NumericFilters? = nil,
        tagFilters: TagFilters? = nil,
        sumOrFiltersScores: Bool? = nil,
        restrictSearchableAttributes: [String]? = nil,
        facets: [String]? = nil,
        facetingAfterDistinct: Bool? = nil,
        page: Int? = nil,
        offset: Int? = nil,
        length: Int? = nil,
        aroundLatLng: String? = nil,
        aroundLatLngViaIP: Bool? = nil,
        aroundRadius: AroundRadius? = nil,
        aroundPrecision: AroundPrecision? = nil,
        minimumAroundRadius: Int? = nil,
        insideBoundingBox: [[Double]]? = nil,
        insidePolygon: [[Double]]? = nil,
        naturalLanguages: [String]? = nil,
        ruleContexts: [String]? = nil,
        personalizationImpact: Int? = nil,
        userToken: String? = nil,
        getRankingInfo: Bool? = nil,
        explain: [String]? = nil,
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
        self.explain = explain
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
        case explain
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
        try container.encodeIfPresent(self.explain, forKey: .explain)
        try container.encodeIfPresent(self.synonyms, forKey: .synonyms)
        try container.encodeIfPresent(self.clickAnalytics, forKey: .clickAnalytics)
        try container.encodeIfPresent(self.analytics, forKey: .analytics)
        try container.encodeIfPresent(self.analyticsTags, forKey: .analyticsTags)
        try container.encodeIfPresent(self.percentileComputation, forKey: .percentileComputation)
        try container.encodeIfPresent(self.enableABTest, forKey: .enableABTest)
    }
}

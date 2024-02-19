// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct SearchResponse: Codable, JSONEncodable, Hashable {
    static let abTestVariantIDRule = NumericRule<Int>(
        minimum: 1,
        exclusiveMinimum: false,
        maximum: nil,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    static let aroundLatLngRule = StringRule(
        minLength: nil,
        maxLength: nil,
        pattern: "^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$"
    )
    static let hitsPerPageRule = NumericRule<Int>(
        minimum: 1,
        exclusiveMinimum: false,
        maximum: 1000,
        exclusiveMaximum: false,
        multipleOf: nil
    )
    /// A/B test ID. This is only included in the response for indices that are part of an A/B test.
    public var abTestID: Int?
    /// Variant ID. This is only included in the response for indices that are part of an A/B test.
    public var abTestVariantID: Int?
    /// Computed geographical location.
    public var aroundLatLng: String?
    /// Automatically-computed radius.
    public var automaticRadius: String?
    public var exhaustive: Exhaustive?
    /// See the `facetsCount` field of the `exhaustive` object in the response.
    @available(*, deprecated, message: "This property is deprecated.")
    public var exhaustiveFacetsCount: Bool?
    /// See the `nbHits` field of the `exhaustive` object in the response.
    @available(*, deprecated, message: "This property is deprecated.")
    public var exhaustiveNbHits: Bool?
    /// See the `typo` field of the `exhaustive` object in the response.
    @available(*, deprecated, message: "This property is deprecated.")
    public var exhaustiveTypo: Bool?
    /// Mapping of each facet name to the corresponding facet counts.
    public var facets: [String: [String: Int]]?
    /// Statistics for numerical facets.
    public var facetsStats: [String: FacetsStats]?
    /// Number of hits per page.
    public var hitsPerPage: Int
    /// Index name used for the query.
    public var index: String?
    /// Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
    public var indexUsed: String?
    /// Warnings about the query.
    public var message: String?
    /// Number of hits the search query matched.
    public var nbHits: Int
    /// Number of pages of results for the current query.
    public var nbPages: Int
    /// Number of hits selected and sorted by the relevant sort algorithm.
    public var nbSortedHits: Int?
    /// Page to retrieve (the first page is `0`, not `1`).
    public var page: Int
    /// Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean)
    /// query string that will be searched.
    public var parsedQuery: String?
    /// Time the server took to process the request, in milliseconds.
    public var processingTimeMS: Int
    /// Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate
    /// performance issues.
    public var processingTimingsMS: AnyCodable?
    /// Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
    public var queryAfterRemoval: String?
    public var redirect: Redirect?
    public var renderingContent: RenderingContent?
    /// Time the server took to process the request, in milliseconds.
    public var serverTimeMS: Int?
    /// Host name of the server that processed the request.
    public var serverUsed: String?
    /// Lets you store custom data in your indices.
    public var userData: AnyCodable?
    public var hits: [Hit]
    /// Text to search for in an index.
    public var query: String
    /// URL-encoded string of all search parameters.
    public var params: String

    public init(
        abTestID: Int? = nil,
        abTestVariantID: Int? = nil,
        aroundLatLng: String? = nil,
        automaticRadius: String? = nil,
        exhaustive: Exhaustive? = nil,
        exhaustiveFacetsCount: Bool? = nil,
        exhaustiveNbHits: Bool? = nil,
        exhaustiveTypo: Bool? = nil,
        facets: [String: [String: Int]]? = nil,
        facetsStats: [String: FacetsStats]? = nil,
        hitsPerPage: Int,
        index: String? = nil,
        indexUsed: String? = nil,
        message: String? = nil,
        nbHits: Int,
        nbPages: Int,
        nbSortedHits: Int? = nil,
        page: Int,
        parsedQuery: String? = nil,
        processingTimeMS: Int,
        processingTimingsMS: AnyCodable? = nil,
        queryAfterRemoval: String? = nil,
        redirect: Redirect? = nil,
        renderingContent: RenderingContent? = nil,
        serverTimeMS: Int? = nil,
        serverUsed: String? = nil,
        userData: AnyCodable? = nil,
        hits: [Hit],
        query: String,
        params: String
    ) {
        self.abTestID = abTestID
        self.abTestVariantID = abTestVariantID
        self.aroundLatLng = aroundLatLng
        self.automaticRadius = automaticRadius
        self.exhaustive = exhaustive
        self.exhaustiveFacetsCount = exhaustiveFacetsCount
        self.exhaustiveNbHits = exhaustiveNbHits
        self.exhaustiveTypo = exhaustiveTypo
        self.facets = facets
        self.facetsStats = facetsStats
        self.hitsPerPage = hitsPerPage
        self.index = index
        self.indexUsed = indexUsed
        self.message = message
        self.nbHits = nbHits
        self.nbPages = nbPages
        self.nbSortedHits = nbSortedHits
        self.page = page
        self.parsedQuery = parsedQuery
        self.processingTimeMS = processingTimeMS
        self.processingTimingsMS = processingTimingsMS
        self.queryAfterRemoval = queryAfterRemoval
        self.redirect = redirect
        self.renderingContent = renderingContent
        self.serverTimeMS = serverTimeMS
        self.serverUsed = serverUsed
        self.userData = userData
        self.hits = hits
        self.query = query
        self.params = params
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case abTestID
        case abTestVariantID
        case aroundLatLng
        case automaticRadius
        case exhaustive
        case exhaustiveFacetsCount
        case exhaustiveNbHits
        case exhaustiveTypo
        case facets
        case facetsStats = "facets_stats"
        case hitsPerPage
        case index
        case indexUsed
        case message
        case nbHits
        case nbPages
        case nbSortedHits
        case page
        case parsedQuery
        case processingTimeMS
        case processingTimingsMS
        case queryAfterRemoval
        case redirect
        case renderingContent
        case serverTimeMS
        case serverUsed
        case userData
        case hits
        case query
        case params
    }

    public var additionalProperties: [String: AnyCodable] = [:]

    public subscript(key: String) -> AnyCodable? {
        get {
            if let value = additionalProperties[key] {
                return value
            }
            return nil
        }

        set {
            self.additionalProperties[key] = newValue
        }
    }

    public init(from dictionary: [String: AnyCodable]) throws {
        self.abTestID = dictionary["abTestID"]?.value as? Int

        self.abTestVariantID = dictionary["abTestVariantID"]?.value as? Int

        self.aroundLatLng = dictionary["aroundLatLng"]?.value as? String

        self.automaticRadius = dictionary["automaticRadius"]?.value as? String

        self.exhaustive = dictionary["exhaustive"]?.value as? Exhaustive

        self.exhaustiveFacetsCount = dictionary["exhaustiveFacetsCount"]?.value as? Bool

        self.exhaustiveNbHits = dictionary["exhaustiveNbHits"]?.value as? Bool

        self.exhaustiveTypo = dictionary["exhaustiveTypo"]?.value as? Bool

        self.facets = dictionary["facets"]?.value as? [String: [String: Int]]

        self.facetsStats = dictionary["facetsStats"]?.value as? [String: FacetsStats]

        guard let hitsPerPage = dictionary["hitsPerPage"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.hitsPerPage = hitsPerPage
        self.index = dictionary["index"]?.value as? String

        self.indexUsed = dictionary["indexUsed"]?.value as? String

        self.message = dictionary["message"]?.value as? String

        guard let nbHits = dictionary["nbHits"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.nbHits = nbHits
        guard let nbPages = dictionary["nbPages"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.nbPages = nbPages
        self.nbSortedHits = dictionary["nbSortedHits"]?.value as? Int

        guard let page = dictionary["page"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.page = page
        self.parsedQuery = dictionary["parsedQuery"]?.value as? String

        guard let processingTimeMS = dictionary["processingTimeMS"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.processingTimeMS = processingTimeMS
        self.processingTimingsMS = dictionary["processingTimingsMS"]?.value as? AnyCodable

        self.queryAfterRemoval = dictionary["queryAfterRemoval"]?.value as? String

        self.redirect = dictionary["redirect"]?.value as? Redirect

        self.renderingContent = dictionary["renderingContent"]?.value as? RenderingContent

        self.serverTimeMS = dictionary["serverTimeMS"]?.value as? Int

        self.serverUsed = dictionary["serverUsed"]?.value as? String

        self.userData = dictionary["userData"]?.value as? AnyCodable

        guard let hits = dictionary["hits"]?.value as? [Hit] else {
            throw GenericError(description: "Failed to cast")
        }
        self.hits = hits
        guard let query = dictionary["query"]?.value as? String else {
            throw GenericError(description: "Failed to cast")
        }
        self.query = query
        guard let params = dictionary["params"]?.value as? String else {
            throw GenericError(description: "Failed to cast")
        }
        self.params = params
        for (key, value) in dictionary {
            switch key {
            case "abTestID", "abTestVariantID", "aroundLatLng", "automaticRadius", "exhaustive",
                 "exhaustiveFacetsCount", "exhaustiveNbHits", "exhaustiveTypo", "facets", "facetsStats", "hitsPerPage",
                 "index", "indexUsed", "message", "nbHits", "nbPages", "nbSortedHits", "page", "parsedQuery",
                 "processingTimeMS", "processingTimingsMS", "queryAfterRemoval", "redirect", "renderingContent",
                 "serverTimeMS", "serverUsed", "userData", "hits", "query", "params":
                continue
            default:
                self.additionalProperties[key] = value
            }
        }
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.abTestID, forKey: .abTestID)
        try container.encodeIfPresent(self.abTestVariantID, forKey: .abTestVariantID)
        try container.encodeIfPresent(self.aroundLatLng, forKey: .aroundLatLng)
        try container.encodeIfPresent(self.automaticRadius, forKey: .automaticRadius)
        try container.encodeIfPresent(self.exhaustive, forKey: .exhaustive)
        try container.encodeIfPresent(self.exhaustiveFacetsCount, forKey: .exhaustiveFacetsCount)
        try container.encodeIfPresent(self.exhaustiveNbHits, forKey: .exhaustiveNbHits)
        try container.encodeIfPresent(self.exhaustiveTypo, forKey: .exhaustiveTypo)
        try container.encodeIfPresent(self.facets, forKey: .facets)
        try container.encodeIfPresent(self.facetsStats, forKey: .facetsStats)
        try container.encode(self.hitsPerPage, forKey: .hitsPerPage)
        try container.encodeIfPresent(self.index, forKey: .index)
        try container.encodeIfPresent(self.indexUsed, forKey: .indexUsed)
        try container.encodeIfPresent(self.message, forKey: .message)
        try container.encode(self.nbHits, forKey: .nbHits)
        try container.encode(self.nbPages, forKey: .nbPages)
        try container.encodeIfPresent(self.nbSortedHits, forKey: .nbSortedHits)
        try container.encode(self.page, forKey: .page)
        try container.encodeIfPresent(self.parsedQuery, forKey: .parsedQuery)
        try container.encode(self.processingTimeMS, forKey: .processingTimeMS)
        try container.encodeIfPresent(self.processingTimingsMS, forKey: .processingTimingsMS)
        try container.encodeIfPresent(self.queryAfterRemoval, forKey: .queryAfterRemoval)
        try container.encodeIfPresent(self.redirect, forKey: .redirect)
        try container.encodeIfPresent(self.renderingContent, forKey: .renderingContent)
        try container.encodeIfPresent(self.serverTimeMS, forKey: .serverTimeMS)
        try container.encodeIfPresent(self.serverUsed, forKey: .serverUsed)
        try container.encodeIfPresent(self.userData, forKey: .userData)
        try container.encode(self.hits, forKey: .hits)
        try container.encode(self.query, forKey: .query)
        try container.encode(self.params, forKey: .params)
        var additionalPropertiesContainer = encoder.container(keyedBy: String.self)
        try additionalPropertiesContainer.encodeMap(self.additionalProperties)
    }

    // Decodable protocol methods

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)

        self.abTestID = try container.decodeIfPresent(Int.self, forKey: .abTestID)
        self.abTestVariantID = try container.decodeIfPresent(Int.self, forKey: .abTestVariantID)
        self.aroundLatLng = try container.decodeIfPresent(String.self, forKey: .aroundLatLng)
        self.automaticRadius = try container.decodeIfPresent(String.self, forKey: .automaticRadius)
        self.exhaustive = try container.decodeIfPresent(Exhaustive.self, forKey: .exhaustive)
        self.exhaustiveFacetsCount = try container.decodeIfPresent(Bool.self, forKey: .exhaustiveFacetsCount)
        self.exhaustiveNbHits = try container.decodeIfPresent(Bool.self, forKey: .exhaustiveNbHits)
        self.exhaustiveTypo = try container.decodeIfPresent(Bool.self, forKey: .exhaustiveTypo)
        self.facets = try container.decodeIfPresent([String: [String: Int]].self, forKey: .facets)
        self.facetsStats = try container.decodeIfPresent([String: FacetsStats].self, forKey: .facetsStats)
        self.hitsPerPage = try container.decode(Int.self, forKey: .hitsPerPage)
        self.index = try container.decodeIfPresent(String.self, forKey: .index)
        self.indexUsed = try container.decodeIfPresent(String.self, forKey: .indexUsed)
        self.message = try container.decodeIfPresent(String.self, forKey: .message)
        self.nbHits = try container.decode(Int.self, forKey: .nbHits)
        self.nbPages = try container.decode(Int.self, forKey: .nbPages)
        self.nbSortedHits = try container.decodeIfPresent(Int.self, forKey: .nbSortedHits)
        self.page = try container.decode(Int.self, forKey: .page)
        self.parsedQuery = try container.decodeIfPresent(String.self, forKey: .parsedQuery)
        self.processingTimeMS = try container.decode(Int.self, forKey: .processingTimeMS)
        self.processingTimingsMS = try container.decodeIfPresent(AnyCodable.self, forKey: .processingTimingsMS)
        self.queryAfterRemoval = try container.decodeIfPresent(String.self, forKey: .queryAfterRemoval)
        self.redirect = try container.decodeIfPresent(Redirect.self, forKey: .redirect)
        self.renderingContent = try container.decodeIfPresent(RenderingContent.self, forKey: .renderingContent)
        self.serverTimeMS = try container.decodeIfPresent(Int.self, forKey: .serverTimeMS)
        self.serverUsed = try container.decodeIfPresent(String.self, forKey: .serverUsed)
        self.userData = try container.decodeIfPresent(AnyCodable.self, forKey: .userData)
        self.hits = try container.decode([Hit].self, forKey: .hits)
        self.query = try container.decode(String.self, forKey: .query)
        self.params = try container.decode(String.self, forKey: .params)
        var nonAdditionalPropertyKeys = Set<String>()
        nonAdditionalPropertyKeys.insert("abTestID")
        nonAdditionalPropertyKeys.insert("abTestVariantID")
        nonAdditionalPropertyKeys.insert("aroundLatLng")
        nonAdditionalPropertyKeys.insert("automaticRadius")
        nonAdditionalPropertyKeys.insert("exhaustive")
        nonAdditionalPropertyKeys.insert("exhaustiveFacetsCount")
        nonAdditionalPropertyKeys.insert("exhaustiveNbHits")
        nonAdditionalPropertyKeys.insert("exhaustiveTypo")
        nonAdditionalPropertyKeys.insert("facets")
        nonAdditionalPropertyKeys.insert("facets_stats")
        nonAdditionalPropertyKeys.insert("hitsPerPage")
        nonAdditionalPropertyKeys.insert("index")
        nonAdditionalPropertyKeys.insert("indexUsed")
        nonAdditionalPropertyKeys.insert("message")
        nonAdditionalPropertyKeys.insert("nbHits")
        nonAdditionalPropertyKeys.insert("nbPages")
        nonAdditionalPropertyKeys.insert("nbSortedHits")
        nonAdditionalPropertyKeys.insert("page")
        nonAdditionalPropertyKeys.insert("parsedQuery")
        nonAdditionalPropertyKeys.insert("processingTimeMS")
        nonAdditionalPropertyKeys.insert("processingTimingsMS")
        nonAdditionalPropertyKeys.insert("queryAfterRemoval")
        nonAdditionalPropertyKeys.insert("redirect")
        nonAdditionalPropertyKeys.insert("renderingContent")
        nonAdditionalPropertyKeys.insert("serverTimeMS")
        nonAdditionalPropertyKeys.insert("serverUsed")
        nonAdditionalPropertyKeys.insert("userData")
        nonAdditionalPropertyKeys.insert("hits")
        nonAdditionalPropertyKeys.insert("query")
        nonAdditionalPropertyKeys.insert("params")
        let additionalPropertiesContainer = try decoder.container(keyedBy: String.self)
        self.additionalProperties = try additionalPropertiesContainer.decodeMap(
            AnyCodable.self,
            excludedKeys: nonAdditionalPropertyKeys
        )
    }
}

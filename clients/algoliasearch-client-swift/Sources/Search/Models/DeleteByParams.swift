// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct DeleteByParams: Codable, JSONEncodable, Hashable {
    public var facetFilters: FacetFilters?
    /// Filter the search so that only records with matching values are included in the results.  These filters are
    /// supported:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`,
    /// `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of
    /// the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute
    /// (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>`
    /// (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and
    /// `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.
    /// **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not
    /// supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not
    /// supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet
    /// attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an
    /// array, the filter matches if it matches at least one element of the array.  For more information, see
    /// [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
    public var filters: String?
    public var numericFilters: NumericFilters?
    public var tagFilters: TagFilters?
    /// Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only
    /// records included within circle around this central location are included in the results. The radius of the
    /// circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you
    /// also specify `insidePolygon` or `insideBoundingBox`.
    public var aroundLatLng: String?
    public var aroundRadius: AroundRadius?
    /// Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points
    /// of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide
    /// multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
    public var insideBoundingBox: [[Double]]?
    /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is
    /// represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see
    /// [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
    /// This parameter is ignored, if you also specify `insideBoundingBox`.
    public var insidePolygon: [[Double]]?

    public init(
        facetFilters: FacetFilters? = nil,
        filters: String? = nil,
        numericFilters: NumericFilters? = nil,
        tagFilters: TagFilters? = nil,
        aroundLatLng: String? = nil,
        aroundRadius: AroundRadius? = nil,
        insideBoundingBox: [[Double]]? = nil,
        insidePolygon: [[Double]]? = nil
    ) {
        self.facetFilters = facetFilters
        self.filters = filters
        self.numericFilters = numericFilters
        self.tagFilters = tagFilters
        self.aroundLatLng = aroundLatLng
        self.aroundRadius = aroundRadius
        self.insideBoundingBox = insideBoundingBox
        self.insidePolygon = insidePolygon
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case facetFilters
        case filters
        case numericFilters
        case tagFilters
        case aroundLatLng
        case aroundRadius
        case insideBoundingBox
        case insidePolygon
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.facetFilters, forKey: .facetFilters)
        try container.encodeIfPresent(self.filters, forKey: .filters)
        try container.encodeIfPresent(self.numericFilters, forKey: .numericFilters)
        try container.encodeIfPresent(self.tagFilters, forKey: .tagFilters)
        try container.encodeIfPresent(self.aroundLatLng, forKey: .aroundLatLng)
        try container.encodeIfPresent(self.aroundRadius, forKey: .aroundRadius)
        try container.encodeIfPresent(self.insideBoundingBox, forKey: .insideBoundingBox)
        try container.encodeIfPresent(self.insidePolygon, forKey: .insidePolygon)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SearchForFacetValuesResponse: Codable, JSONEncodable {
    /// Matching facet values.
    public var facetHits: [FacetHits]
    /// See the `facetsCount` field of the `exhaustive` object in the response.
    @available(*, deprecated, message: "This property is deprecated.")
    public var exhaustiveFacetsCount: Bool
    /// Time the server took to process the request, in milliseconds.
    public var processingTimeMS: Int?

    public init(facetHits: [FacetHits], exhaustiveFacetsCount: Bool, processingTimeMS: Int? = nil) {
        self.facetHits = facetHits
        self.exhaustiveFacetsCount = exhaustiveFacetsCount
        self.processingTimeMS = processingTimeMS
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case facetHits
        case exhaustiveFacetsCount
        case processingTimeMS
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.facetHits, forKey: .facetHits)
        try container.encode(self.exhaustiveFacetsCount, forKey: .exhaustiveFacetsCount)
        try container.encodeIfPresent(self.processingTimeMS, forKey: .processingTimeMS)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - FilterEffects

/// A/B test filter effects resulting from configuration settings.
public struct FilterEffects: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(outliers: FilterEffectsOutliers? = nil, emptySearch: FilterEffectsEmptySearch? = nil) {
        self.outliers = outliers
        self.emptySearch = emptySearch
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case outliers
        case emptySearch
    }

    public var outliers: FilterEffectsOutliers?
    public var emptySearch: FilterEffectsEmptySearch?

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.outliers, forKey: .outliers)
        try container.encodeIfPresent(self.emptySearch, forKey: .emptySearch)
    }
}

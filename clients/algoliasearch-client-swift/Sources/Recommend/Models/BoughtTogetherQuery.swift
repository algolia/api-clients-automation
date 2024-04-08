// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct BoughtTogetherQuery: Codable, JSONEncodable {
    /// Index name.
    public var indexName: String
    /// Minimum score a recommendation must have to be included in the response.
    public var threshold: Double
    /// Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback
    /// request is made. Depending on the available recommendations and the other request parameters, the actual number
    /// of recommendations may be lower than this value.
    public var maxRecommendations: Int?
    public var queryParameters: RecommendSearchParams?
    public var model: FbtModel
    /// Unique record identifier.
    public var objectID: String

    public init(
        indexName: String,
        threshold: Double,
        maxRecommendations: Int? = nil,
        queryParameters: RecommendSearchParams? = nil,
        model: FbtModel,
        objectID: String
    ) {
        self.indexName = indexName
        self.threshold = threshold
        self.maxRecommendations = maxRecommendations
        self.queryParameters = queryParameters
        self.model = model
        self.objectID = objectID
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case indexName
        case threshold
        case maxRecommendations
        case queryParameters
        case model
        case objectID
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.indexName, forKey: .indexName)
        try container.encode(self.threshold, forKey: .threshold)
        try container.encodeIfPresent(self.maxRecommendations, forKey: .maxRecommendations)
        try container.encodeIfPresent(self.queryParameters, forKey: .queryParameters)
        try container.encode(self.model, forKey: .model)
        try container.encode(self.objectID, forKey: .objectID)
    }
}

extension BoughtTogetherQuery: Equatable {
    public static func ==(lhs: BoughtTogetherQuery, rhs: BoughtTogetherQuery) -> Bool {
        lhs.indexName == rhs.indexName &&
            lhs.threshold == rhs.threshold &&
            lhs.maxRecommendations == rhs.maxRecommendations &&
            lhs.queryParameters == rhs.queryParameters &&
            lhs.model == rhs.model &&
            lhs.objectID == rhs.objectID
    }
}

extension BoughtTogetherQuery: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.indexName.hashValue)
        hasher.combine(self.threshold.hashValue)
        hasher.combine(self.maxRecommendations?.hashValue)
        hasher.combine(self.queryParameters?.hashValue)
        hasher.combine(self.model.hashValue)
        hasher.combine(self.objectID.hashValue)
    }
}

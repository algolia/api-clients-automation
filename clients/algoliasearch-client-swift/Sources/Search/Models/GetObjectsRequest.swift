// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// Record retrieval operation.
public struct GetObjectsRequest: Codable, JSONEncodable, Hashable {
    /// Attributes to retrieve. If not specified, all retrievable attributes are returned.
    public var attributesToRetrieve: [String]?
    /// Record's objectID.
    public var objectID: String
    /// Name of the index containing the required records.
    public var indexName: String

    public init(attributesToRetrieve: [String]? = nil, objectID: String, indexName: String) {
        self.attributesToRetrieve = attributesToRetrieve
        self.objectID = objectID
        self.indexName = indexName
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case attributesToRetrieve
        case objectID
        case indexName
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.attributesToRetrieve, forKey: .attributesToRetrieve)
        try container.encode(self.objectID, forKey: .objectID)
        try container.encode(self.indexName, forKey: .indexName)
    }
}

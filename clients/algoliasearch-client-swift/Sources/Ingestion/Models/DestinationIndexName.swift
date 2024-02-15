// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct DestinationIndexName: Codable, JSONEncodable, Hashable {
    /// The index name to store data in.
    public var indexName: String
    public var recordType: RecordType?
    /// Determines the attributes to exclude from an Algolia record. To remove nested element, you can separate the path
    /// to the element with dots (`.`):   - \"foo.bar\": will remove `bar` from `foo`. To remove elements from an array,
    /// you can use the following:   - \"foo.[0].bar\": will only remove `bar` from the first element of `foo`.   -
    /// \"foo.[*].bar\": will remove `bar` from every elements of `foo`.
    public var attributesToExclude: [String]?

    public init(indexName: String, recordType: RecordType? = nil, attributesToExclude: [String]? = nil) {
        self.indexName = indexName
        self.recordType = recordType
        self.attributesToExclude = attributesToExclude
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case indexName
        case recordType
        case attributesToExclude
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.indexName, forKey: .indexName)
        try container.encodeIfPresent(self.recordType, forKey: .recordType)
        try container.encodeIfPresent(self.attributesToExclude, forKey: .attributesToExclude)
    }
}

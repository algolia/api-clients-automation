// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** Settings for the semantic search part of NeuralSearch. Only used when &#x60;mode&#x60; is _neuralSearch_.  */
public struct SemanticSearch: Codable, JSONEncodable, Hashable {
    /** Indices from which to collect click and conversion events. If null, the current index and replica group will be used as the event source. */
    public var eventSources: [String]?

    public init(eventSources: [String]? = nil) {
        self.eventSources = eventSources
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case eventSources
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(eventSources, forKey: .eventSources)
    }
}

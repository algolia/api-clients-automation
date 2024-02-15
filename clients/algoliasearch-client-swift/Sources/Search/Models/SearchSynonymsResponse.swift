// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - SearchSynonymsResponse

public struct SearchSynonymsResponse: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(hits: [SynonymHit], nbHits: Int) {
        self.hits = hits
        self.nbHits = nbHits
    }

    public init(from dictionary: [String: AnyCodable]) throws {
        guard let hits = dictionary["hits"]?.value as? [SynonymHit] else {
            throw GenericError(description: "Failed to cast")
        }
        self.hits = hits
        guard let nbHits = dictionary["nbHits"]?.value as? Int else {
            throw GenericError(description: "Failed to cast")
        }
        self.nbHits = nbHits
        for (key, value) in dictionary {
            switch key {
            case "hits", "nbHits":
                continue
            default:
                self.additionalProperties[key] = value
            }
        }
    }

    // Decodable protocol methods

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)

        self.hits = try container.decode([SynonymHit].self, forKey: .hits)
        self.nbHits = try container.decode(Int.self, forKey: .nbHits)
        var nonAdditionalPropertyKeys = Set<String>()
        nonAdditionalPropertyKeys.insert("hits")
        nonAdditionalPropertyKeys.insert("nbHits")
        let additionalPropertiesContainer = try decoder.container(keyedBy: String.self)
        self.additionalProperties = try additionalPropertiesContainer.decodeMap(
            AnyCodable.self,
            excludedKeys: nonAdditionalPropertyKeys
        )
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case hits
        case nbHits
    }

    /// Synonym objects.
    public var hits: [SynonymHit]
    /// Number of hits the search query matched.
    public var nbHits: Int

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

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.hits, forKey: .hits)
        try container.encode(self.nbHits, forKey: .nbHits)
        var additionalPropertiesContainer = encoder.container(keyedBy: String.self)
        try additionalPropertiesContainer.encodeMap(self.additionalProperties)
    }
}

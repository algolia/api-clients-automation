// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - ErrorBase

/// Error.
public struct ErrorBase: Codable, JSONEncodable, Hashable {
    // MARK: Lifecycle

    public init(message: String? = nil) {
        self.message = message
    }

    public init(from dictionary: [String: AnyCodable]) throws {
        self.message = dictionary["message"]?.value as? String

        for (key, value) in dictionary {
            switch key {
            case "message":
                continue
            default:
                self.additionalProperties[key] = value
            }
        }
    }

    // Decodable protocol methods

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)

        self.message = try container.decodeIfPresent(String.self, forKey: .message)
        var nonAdditionalPropertyKeys = Set<String>()
        nonAdditionalPropertyKeys.insert("message")
        let additionalPropertiesContainer = try decoder.container(keyedBy: String.self)
        self.additionalProperties = try additionalPropertiesContainer.decodeMap(
            AnyCodable.self,
            excludedKeys: nonAdditionalPropertyKeys
        )
    }

    // MARK: Public

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case message
    }

    public var message: String?

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
        try container.encodeIfPresent(self.message, forKey: .message)
        var additionalPropertiesContainer = encoder.container(keyedBy: String.self)
        try additionalPropertiesContainer.encodeMap(self.additionalProperties)
    }
}

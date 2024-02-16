// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// When providing a string, it replaces the entire query string. When providing an object, it describes incremental
/// edits to be made to the query string (but you can&#39;t do both).
public enum ConsequenceQuery: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case consequenceQueryObject(ConsequenceQueryObject)
    case string(String)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .consequenceQueryObject(value):
            try container.encode(value)
        case let .string(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(ConsequenceQueryObject.self) {
            self = .consequenceQueryObject(value)
        } else if let value = try? container.decode(String.self) {
            self = .string(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of ConsequenceQuery")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .consequenceQueryObject(value):
            value as ConsequenceQueryObject
        case let .string(value):
            value as String
        }
    }
}

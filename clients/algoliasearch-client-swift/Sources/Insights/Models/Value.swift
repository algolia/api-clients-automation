// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - Value

/// Total monetary value of this event in units of &#x60;currency&#x60;.
public enum Value: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case double(Double)
    case string(String)

    // MARK: Lifecycle

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(Double.self) {
            self = .double(value)
        } else if let value = try? container.decode(String.self) {
            self = .string(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of Value")
            )
        }
    }

    // MARK: Public

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .double(value):
            try container.encode(value)
        case let .string(value):
            try container.encode(value)
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .double(value):
            value as Double
        case let .string(value):
            value as String
        }
    }
}

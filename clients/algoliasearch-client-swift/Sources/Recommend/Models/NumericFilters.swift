// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// [Filter on numeric attributes](https://www.algolia.com/doc/api-reference/api-parameters/numericFilters/).
public enum NumericFilters: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case string(String)
    case arrayOfMixedSearchFilters([MixedSearchFilters])

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .string(value):
            try container.encode(value)
        case let .arrayOfMixedSearchFilters(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(String.self) {
            self = .string(value)
        } else if let value = try? container.decode([MixedSearchFilters].self) {
            self = .arrayOfMixedSearchFilters(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of NumericFilters")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .string(value):
            value as String
        case let .arrayOfMixedSearchFilters(value):
            value as [MixedSearchFilters]
        }
    }
}

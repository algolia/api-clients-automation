// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** [Maximum radius](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#increase-the-search-radius) for a geographical search (in meters).  */
public enum AroundRadius: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case aroundRadiusAll(AroundRadiusAll)
    case int(Int)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .aroundRadiusAll(value):
            try container.encode(value)
        case let .int(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(AroundRadiusAll.self) {
            self = .aroundRadiusAll(value)
        } else if let value = try? container.decode(Int.self) {
            self = .int(value)
        } else {
            throw DecodingError.typeMismatch(Self.Type.self, .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of AroundRadius"))
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .aroundRadiusAll(value):
            return value as AroundRadiusAll
        case let .int(value):
            return value as Int
        }
    }
}

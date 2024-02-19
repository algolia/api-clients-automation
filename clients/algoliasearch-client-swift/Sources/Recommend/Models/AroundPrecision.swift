// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

/// Precision of a geographical search (in meters), to [group results that are more or less the same distance from a
/// central point](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/in-depth/geo-ranking-precision/).
public enum AroundPrecision: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case int(Int)
    case arrayOfAroundPrecisionFromValueInner([AroundPrecisionFromValueInner])

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .int(value):
            try container.encode(value)
        case let .arrayOfAroundPrecisionFromValueInner(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(Int.self) {
            self = .int(value)
        } else if let value = try? container.decode([AroundPrecisionFromValueInner].self) {
            self = .arrayOfAroundPrecisionFromValueInner(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of AroundPrecision")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .int(value):
            value as Int
        case let .arrayOfAroundPrecisionFromValueInner(value):
            value as [AroundPrecisionFromValueInner]
        }
    }
}

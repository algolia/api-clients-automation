// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public enum SearchParams: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case searchParamsObject(SearchParamsObject)
    case searchParamsString(SearchParamsString)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .searchParamsObject(value):
            try container.encode(value)
        case let .searchParamsString(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(SearchParamsObject.self) {
            self = .searchParamsObject(value)
        } else if let value = try? container.decode(SearchParamsString.self) {
            self = .searchParamsString(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of SearchParams")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .searchParamsObject(value):
            value as SearchParamsObject
        case let .searchParamsString(value):
            value as SearchParamsString
        }
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public enum SourceInput: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case sourceBigCommerce(SourceBigCommerce)
    case sourceBigQuery(SourceBigQuery)
    case sourceCSV(SourceCSV)
    case sourceCommercetools(SourceCommercetools)
    case sourceDocker(SourceDocker)
    case sourceJSON(SourceJSON)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .sourceBigCommerce(value):
            try container.encode(value)
        case let .sourceBigQuery(value):
            try container.encode(value)
        case let .sourceCSV(value):
            try container.encode(value)
        case let .sourceCommercetools(value):
            try container.encode(value)
        case let .sourceDocker(value):
            try container.encode(value)
        case let .sourceJSON(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(SourceBigCommerce.self) {
            self = .sourceBigCommerce(value)
        } else if let value = try? container.decode(SourceBigQuery.self) {
            self = .sourceBigQuery(value)
        } else if let value = try? container.decode(SourceCSV.self) {
            self = .sourceCSV(value)
        } else if let value = try? container.decode(SourceCommercetools.self) {
            self = .sourceCommercetools(value)
        } else if let value = try? container.decode(SourceDocker.self) {
            self = .sourceDocker(value)
        } else if let value = try? container.decode(SourceJSON.self) {
            self = .sourceJSON(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of SourceInput")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .sourceBigCommerce(value):
            value as SourceBigCommerce
        case let .sourceBigQuery(value):
            value as SourceBigQuery
        case let .sourceCSV(value):
            value as SourceCSV
        case let .sourceCommercetools(value):
            value as SourceCommercetools
        case let .sourceDocker(value):
            value as SourceDocker
        case let .sourceJSON(value):
            value as SourceJSON
        }
    }
}

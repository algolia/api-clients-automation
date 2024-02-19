// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public enum SourceUpdateInput: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case sourceBigQuery(SourceBigQuery)
    case sourceCSV(SourceCSV)
    case sourceJSON(SourceJSON)
    case sourceUpdateCommercetools(SourceUpdateCommercetools)
    case sourceUpdateDocker(SourceUpdateDocker)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .sourceBigQuery(value):
            try container.encode(value)
        case let .sourceCSV(value):
            try container.encode(value)
        case let .sourceJSON(value):
            try container.encode(value)
        case let .sourceUpdateCommercetools(value):
            try container.encode(value)
        case let .sourceUpdateDocker(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(SourceBigQuery.self) {
            self = .sourceBigQuery(value)
        } else if let value = try? container.decode(SourceCSV.self) {
            self = .sourceCSV(value)
        } else if let value = try? container.decode(SourceJSON.self) {
            self = .sourceJSON(value)
        } else if let value = try? container.decode(SourceUpdateCommercetools.self) {
            self = .sourceUpdateCommercetools(value)
        } else if let value = try? container.decode(SourceUpdateDocker.self) {
            self = .sourceUpdateDocker(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of SourceUpdateInput"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .sourceBigQuery(value):
            value as SourceBigQuery
        case let .sourceCSV(value):
            value as SourceCSV
        case let .sourceJSON(value):
            value as SourceJSON
        case let .sourceUpdateCommercetools(value):
            value as SourceUpdateCommercetools
        case let .sourceUpdateDocker(value):
            value as SourceUpdateDocker
        }
    }
}

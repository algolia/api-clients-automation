// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public enum PlatformWithNone: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case platform(Platform)
    case platformNone(PlatformNone)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .platform(value):
            try container.encode(value)
        case let .platformNone(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(Platform.self) {
            self = .platform(value)
        } else if let value = try? container.decode(PlatformNone.self) {
            self = .platformNone(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of PlatformWithNone")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .platform(value):
            value as Platform
        case let .platformNone(value):
            value as PlatformNone
        }
    }
}

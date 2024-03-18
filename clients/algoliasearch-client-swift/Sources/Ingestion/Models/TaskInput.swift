// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum TaskInput: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case onDemandDateUtilsInput(OnDemandDateUtilsInput)
    case scheduleDateUtilsInput(ScheduleDateUtilsInput)
    case streamingUtilsInput(StreamingUtilsInput)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .onDemandDateUtilsInput(value):
            try container.encode(value)
        case let .scheduleDateUtilsInput(value):
            try container.encode(value)
        case let .streamingUtilsInput(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(OnDemandDateUtilsInput.self) {
            self = .onDemandDateUtilsInput(value)
        } else if let value = try? container.decode(ScheduleDateUtilsInput.self) {
            self = .scheduleDateUtilsInput(value)
        } else if let value = try? container.decode(StreamingUtilsInput.self) {
            self = .streamingUtilsInput(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of TaskInput")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .onDemandDateUtilsInput(value):
            value as OnDemandDateUtilsInput
        case let .scheduleDateUtilsInput(value):
            value as ScheduleDateUtilsInput
        case let .streamingUtilsInput(value):
            value as StreamingUtilsInput
        }
    }
}

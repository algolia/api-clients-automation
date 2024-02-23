// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public enum GetTopHitsResponse: Codable, JSONEncodable, AbstractEncodable, Hashable {
    case topHitsResponse(TopHitsResponse)
    case topHitsResponseWithAnalytics(TopHitsResponseWithAnalytics)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .topHitsResponse(value):
            try container.encode(value)
        case let .topHitsResponseWithAnalytics(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(TopHitsResponse.self) {
            self = .topHitsResponse(value)
        } else if let value = try? container.decode(TopHitsResponseWithAnalytics.self) {
            self = .topHitsResponseWithAnalytics(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of GetTopHitsResponse"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .topHitsResponse(value):
            value as TopHitsResponse
        case let .topHitsResponseWithAnalytics(value):
            value as TopHitsResponseWithAnalytics
        }
    }
}

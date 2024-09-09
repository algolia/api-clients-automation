// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum SearchHighlightResult: Codable, JSONEncodable, AbstractEncodable {
    case searchHighlightResultOption(SearchHighlightResultOption)
    case dictionaryOfStringToSearchHighlightResult([String: SearchHighlightResult])
    case dictionaryOfStringToSearchHighlightResultOption([String: SearchHighlightResultOption])
    case arrayOfSearchHighlightResultOption([SearchHighlightResultOption])

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .searchHighlightResultOption(value):
            try container.encode(value)
        case let .dictionaryOfStringToSearchHighlightResult(value):
            try container.encode(value)
        case let .dictionaryOfStringToSearchHighlightResultOption(value):
            try container.encode(value)
        case let .arrayOfSearchHighlightResultOption(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(SearchHighlightResultOption.self) {
            self = .searchHighlightResultOption(value)
        } else if let value = try? container.decode([String: SearchHighlightResult].self) {
            self = .dictionaryOfStringToSearchHighlightResult(value)
        } else if let value = try? container.decode([String: SearchHighlightResultOption].self) {
            self = .dictionaryOfStringToSearchHighlightResultOption(value)
        } else if let value = try? container.decode([SearchHighlightResultOption].self) {
            self = .arrayOfSearchHighlightResultOption(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of SearchHighlightResult"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .searchHighlightResultOption(value):
            value as SearchHighlightResultOption
        case let .dictionaryOfStringToSearchHighlightResult(value):
            value as [String: SearchHighlightResult]
        case let .dictionaryOfStringToSearchHighlightResultOption(value):
            value as [String: SearchHighlightResultOption]
        case let .arrayOfSearchHighlightResultOption(value):
            value as [SearchHighlightResultOption]
        }
    }
}

extension SearchHighlightResult: Equatable {}
extension SearchHighlightResult: Hashable {}

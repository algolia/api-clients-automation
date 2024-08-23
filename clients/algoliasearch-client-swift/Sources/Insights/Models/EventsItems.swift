// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum EventsItems: Codable, JSONEncodable, AbstractEncodable {
    case addedToCartObjectIDsAfterSearch(AddedToCartObjectIDsAfterSearch)
    case purchasedObjectIDsAfterSearch(PurchasedObjectIDsAfterSearch)
    case clickedObjectIDsAfterSearch(ClickedObjectIDsAfterSearch)
    case purchasedObjectIDs(PurchasedObjectIDs)
    case addedToCartObjectIDs(AddedToCartObjectIDs)
    case convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch)
    case clickedObjectIDs(ClickedObjectIDs)
    case convertedObjectIDs(ConvertedObjectIDs)
    case clickedFilters(ClickedFilters)
    case convertedFilters(ConvertedFilters)
    case viewedObjectIDs(ViewedObjectIDs)
    case viewedFilters(ViewedFilters)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .addedToCartObjectIDsAfterSearch(value):
            try container.encode(value)
        case let .purchasedObjectIDsAfterSearch(value):
            try container.encode(value)
        case let .clickedObjectIDsAfterSearch(value):
            try container.encode(value)
        case let .purchasedObjectIDs(value):
            try container.encode(value)
        case let .addedToCartObjectIDs(value):
            try container.encode(value)
        case let .convertedObjectIDsAfterSearch(value):
            try container.encode(value)
        case let .clickedObjectIDs(value):
            try container.encode(value)
        case let .convertedObjectIDs(value):
            try container.encode(value)
        case let .clickedFilters(value):
            try container.encode(value)
        case let .convertedFilters(value):
            try container.encode(value)
        case let .viewedObjectIDs(value):
            try container.encode(value)
        case let .viewedFilters(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(AddedToCartObjectIDsAfterSearch.self) {
            self = .addedToCartObjectIDsAfterSearch(value)
        } else if let value = try? container.decode(PurchasedObjectIDsAfterSearch.self) {
            self = .purchasedObjectIDsAfterSearch(value)
        } else if let value = try? container.decode(ClickedObjectIDsAfterSearch.self) {
            self = .clickedObjectIDsAfterSearch(value)
        } else if let value = try? container.decode(PurchasedObjectIDs.self) {
            self = .purchasedObjectIDs(value)
        } else if let value = try? container.decode(AddedToCartObjectIDs.self) {
            self = .addedToCartObjectIDs(value)
        } else if let value = try? container.decode(ConvertedObjectIDsAfterSearch.self) {
            self = .convertedObjectIDsAfterSearch(value)
        } else if let value = try? container.decode(ClickedObjectIDs.self) {
            self = .clickedObjectIDs(value)
        } else if let value = try? container.decode(ConvertedObjectIDs.self) {
            self = .convertedObjectIDs(value)
        } else if let value = try? container.decode(ClickedFilters.self) {
            self = .clickedFilters(value)
        } else if let value = try? container.decode(ConvertedFilters.self) {
            self = .convertedFilters(value)
        } else if let value = try? container.decode(ViewedObjectIDs.self) {
            self = .viewedObjectIDs(value)
        } else if let value = try? container.decode(ViewedFilters.self) {
            self = .viewedFilters(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of EventsItems")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .addedToCartObjectIDsAfterSearch(value):
            value as AddedToCartObjectIDsAfterSearch
        case let .purchasedObjectIDsAfterSearch(value):
            value as PurchasedObjectIDsAfterSearch
        case let .clickedObjectIDsAfterSearch(value):
            value as ClickedObjectIDsAfterSearch
        case let .purchasedObjectIDs(value):
            value as PurchasedObjectIDs
        case let .addedToCartObjectIDs(value):
            value as AddedToCartObjectIDs
        case let .convertedObjectIDsAfterSearch(value):
            value as ConvertedObjectIDsAfterSearch
        case let .clickedObjectIDs(value):
            value as ClickedObjectIDs
        case let .convertedObjectIDs(value):
            value as ConvertedObjectIDs
        case let .clickedFilters(value):
            value as ClickedFilters
        case let .convertedFilters(value):
            value as ConvertedFilters
        case let .viewedObjectIDs(value):
            value as ViewedObjectIDs
        case let .viewedFilters(value):
            value as ViewedFilters
        }
    }
}

extension EventsItems: Equatable {}
extension EventsItems: Hashable {}

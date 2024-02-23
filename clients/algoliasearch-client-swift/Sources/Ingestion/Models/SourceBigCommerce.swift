// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct SourceBigCommerce: Codable, JSONEncodable, Hashable {
    /// The store hash identifying the store the shopper is signing in to.
    public var storeHash: String
    public var channel: BigCommerceChannel?
    public var customFields: [String]?
    public var productMetafields: [BigCommerceMetafield]?
    public var variantMetafields: [BigCommerceMetafield]?

    public init(
        storeHash: String,
        channel: BigCommerceChannel? = nil,
        customFields: [String]? = nil,
        productMetafields: [BigCommerceMetafield]? = nil,
        variantMetafields: [BigCommerceMetafield]? = nil
    ) {
        self.storeHash = storeHash
        self.channel = channel
        self.customFields = customFields
        self.productMetafields = productMetafields
        self.variantMetafields = variantMetafields
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case storeHash
        case channel
        case customFields
        case productMetafields
        case variantMetafields
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.storeHash, forKey: .storeHash)
        try container.encodeIfPresent(self.channel, forKey: .channel)
        try container.encodeIfPresent(self.customFields, forKey: .customFields)
        try container.encodeIfPresent(self.productMetafields, forKey: .productMetafields)
        try container.encodeIfPresent(self.variantMetafields, forKey: .variantMetafields)
    }
}

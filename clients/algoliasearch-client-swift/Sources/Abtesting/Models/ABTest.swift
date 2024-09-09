// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct ABTest: Codable, JSONEncodable {
    /// Unique A/B test identifier.
    public var abTestID: Int
    public var clickSignificance: Double?
    public var conversionSignificance: Double?
    public var addToCartSignificance: Double?
    public var purchaseSignificance: Double?
    public var revenueSignificance: [String: Double]?
    /// Date and time when the A/B test was last updated, in RFC 3339 format.
    public var updatedAt: String
    /// Date and time when the A/B test was created, in RFC 3339 format.
    public var createdAt: String
    /// End date and time of the A/B test, in RFC 3339 format.
    public var endAt: String
    /// A/B test name.
    public var name: String
    public var status: AbtestingStatus
    /// A/B test variants.  The first variant is your _control_ index, typically your production index. The second
    /// variant is an index with changed settings that you want to test against the control.
    public var variants: [Variant]
    public var configuration: ABTestConfiguration?

    public init(
        abTestID: Int,
        clickSignificance: Double? = nil,
        conversionSignificance: Double? = nil,
        addToCartSignificance: Double? = nil,
        purchaseSignificance: Double? = nil,
        revenueSignificance: [String: Double]? = nil,
        updatedAt: String,
        createdAt: String,
        endAt: String,
        name: String,
        status: AbtestingStatus,
        variants: [Variant],
        configuration: ABTestConfiguration? = nil
    ) {
        self.abTestID = abTestID
        self.clickSignificance = clickSignificance
        self.conversionSignificance = conversionSignificance
        self.addToCartSignificance = addToCartSignificance
        self.purchaseSignificance = purchaseSignificance
        self.revenueSignificance = revenueSignificance
        self.updatedAt = updatedAt
        self.createdAt = createdAt
        self.endAt = endAt
        self.name = name
        self.status = status
        self.variants = variants
        self.configuration = configuration
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case abTestID
        case clickSignificance
        case conversionSignificance
        case addToCartSignificance
        case purchaseSignificance
        case revenueSignificance
        case updatedAt
        case createdAt
        case endAt
        case name
        case status
        case variants
        case configuration
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.abTestID, forKey: .abTestID)
        try container.encodeIfPresent(self.clickSignificance, forKey: .clickSignificance)
        try container.encodeIfPresent(self.conversionSignificance, forKey: .conversionSignificance)
        try container.encodeIfPresent(self.addToCartSignificance, forKey: .addToCartSignificance)
        try container.encodeIfPresent(self.purchaseSignificance, forKey: .purchaseSignificance)
        try container.encodeIfPresent(self.revenueSignificance, forKey: .revenueSignificance)
        try container.encode(self.updatedAt, forKey: .updatedAt)
        try container.encode(self.createdAt, forKey: .createdAt)
        try container.encode(self.endAt, forKey: .endAt)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.status, forKey: .status)
        try container.encode(self.variants, forKey: .variants)
        try container.encodeIfPresent(self.configuration, forKey: .configuration)
    }
}

extension ABTest: Equatable {
    public static func ==(lhs: ABTest, rhs: ABTest) -> Bool {
        lhs.abTestID == rhs.abTestID &&
            lhs.clickSignificance == rhs.clickSignificance &&
            lhs.conversionSignificance == rhs.conversionSignificance &&
            lhs.addToCartSignificance == rhs.addToCartSignificance &&
            lhs.purchaseSignificance == rhs.purchaseSignificance &&
            lhs.revenueSignificance == rhs.revenueSignificance &&
            lhs.updatedAt == rhs.updatedAt &&
            lhs.createdAt == rhs.createdAt &&
            lhs.endAt == rhs.endAt &&
            lhs.name == rhs.name &&
            lhs.status == rhs.status &&
            lhs.variants == rhs.variants &&
            lhs.configuration == rhs.configuration
    }
}

extension ABTest: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.abTestID.hashValue)
        hasher.combine(self.clickSignificance?.hashValue)
        hasher.combine(self.conversionSignificance?.hashValue)
        hasher.combine(self.addToCartSignificance?.hashValue)
        hasher.combine(self.purchaseSignificance?.hashValue)
        hasher.combine(self.revenueSignificance?.hashValue)
        hasher.combine(self.updatedAt.hashValue)
        hasher.combine(self.createdAt.hashValue)
        hasher.combine(self.endAt.hashValue)
        hasher.combine(self.name.hashValue)
        hasher.combine(self.status.hashValue)
        hasher.combine(self.variants.hashValue)
        hasher.combine(self.configuration?.hashValue)
    }
}

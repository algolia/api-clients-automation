// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct ABTest: Codable, JSONEncodable, Hashable {
    /** Unique A/B test ID. */
    public var abTestID: Int
    /** [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on click data. A value of 0.95 or over is considered to be _significant_.  */
    public var clickSignificance: Double
    /** [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on conversion. A value of 0.95 or over is considered to be _significant_.  */
    public var conversionSignificance: Double
    /** [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on add-to-cart data. A value of 0.95 or over is considered to be _significant_.  */
    public var addToCartSignificance: Double
    /** [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on purchase data. A value of 0.95 or over is considered to be _significant_.  */
    public var purchaseSignificance: Double
    /** [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on revenue data. A value of 0.95 or over is considered to be _significant_.  */
    public var revenueSignificance: [String: Double]
    /** Update date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. */
    public var updatedAt: String
    /** Creation date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. */
    public var createdAt: String
    /** End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. */
    public var endAt: String
    /** A/B test name. */
    public var name: String
    /** A/B test status. */
    public var status: String
    /** A/B test variants. */
    public var variants: [Variant]

    public init(abTestID: Int, clickSignificance: Double, conversionSignificance: Double, addToCartSignificance: Double, purchaseSignificance: Double, revenueSignificance: [String: Double], updatedAt: String, createdAt: String, endAt: String, name: String, status: String, variants: [Variant]) {
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
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(abTestID, forKey: .abTestID)
        try container.encode(clickSignificance, forKey: .clickSignificance)
        try container.encode(conversionSignificance, forKey: .conversionSignificance)
        try container.encode(addToCartSignificance, forKey: .addToCartSignificance)
        try container.encode(purchaseSignificance, forKey: .purchaseSignificance)
        try container.encode(revenueSignificance, forKey: .revenueSignificance)
        try container.encode(updatedAt, forKey: .updatedAt)
        try container.encode(createdAt, forKey: .createdAt)
        try container.encode(endAt, forKey: .endAt)
        try container.encode(name, forKey: .name)
        try container.encode(status, forKey: .status)
        try container.encode(variants, forKey: .variants)
    }
}

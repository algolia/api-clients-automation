// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct EstimateABTestRequest: Codable, JSONEncodable {
    public var configuration: EstimateConfiguration
    /// A/B test variants.
    public var variants: [AddABTestsVariant]

    public init(configuration: EstimateConfiguration, variants: [AddABTestsVariant]) {
        self.configuration = configuration
        self.variants = variants
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case configuration
        case variants
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.configuration, forKey: .configuration)
        try container.encode(self.variants, forKey: .variants)
    }
}

extension EstimateABTestRequest: Equatable {
    public static func ==(lhs: EstimateABTestRequest, rhs: EstimateABTestRequest) -> Bool {
        lhs.configuration == rhs.configuration &&
            lhs.variants == rhs.variants
    }
}

extension EstimateABTestRequest: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.configuration.hashValue)
        hasher.combine(self.variants.hashValue)
    }
}
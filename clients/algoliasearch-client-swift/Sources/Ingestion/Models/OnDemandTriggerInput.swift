// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

/// The trigger information of a task of type &#x60;onDemand&#x60;.
public struct OnDemandTriggerInput: Codable, JSONEncodable, Hashable {
    public var type: OnDemandTriggerType

    public init(type: OnDemandTriggerType) {
        self.type = type
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case type
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.type, forKey: .type)
    }
}

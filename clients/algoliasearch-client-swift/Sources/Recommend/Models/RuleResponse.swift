// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Rule object.
public struct RuleResponse: Codable, JSONEncodable, Hashable {
    public var metadata: RuleResponseMetadata?
    /// Unique identifier for a rule object.
    public var objectID: String
    /// [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to
    /// activate a rule. You can use up to 25 conditions per rule.
    public var conditions: [Condition]?
    public var consequence: Consequence?
    /// Description of the rule's purpose. This can be helpful for display in the Algolia dashboard.
    public var description: String?
    /// Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time.
    public var enabled: Bool?

    public init(
        metadata: RuleResponseMetadata? = nil,
        objectID: String,
        conditions: [Condition]? = nil,
        consequence: Consequence? = nil,
        description: String? = nil,
        enabled: Bool? = nil
    ) {
        self.metadata = metadata
        self.objectID = objectID
        self.conditions = conditions
        self.consequence = consequence
        self.description = description
        self.enabled = enabled
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case metadata = "_metadata"
        case objectID
        case conditions
        case consequence
        case description
        case enabled
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.metadata, forKey: .metadata)
        try container.encode(self.objectID, forKey: .objectID)
        try container.encodeIfPresent(self.conditions, forKey: .conditions)
        try container.encodeIfPresent(self.consequence, forKey: .consequence)
        try container.encodeIfPresent(self.description, forKey: .description)
        try container.encodeIfPresent(self.enabled, forKey: .enabled)
    }
}

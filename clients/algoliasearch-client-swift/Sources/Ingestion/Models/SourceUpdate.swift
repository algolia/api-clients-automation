// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SourceUpdate: Codable, JSONEncodable, Hashable {
    public var name: String?
    public var input: SourceUpdateInput?
    /// The authentication UUID.
    public var authenticationID: String?

    public init(name: String? = nil, input: SourceUpdateInput? = nil, authenticationID: String? = nil) {
        self.name = name
        self.input = input
        self.authenticationID = authenticationID
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case name
        case input
        case authenticationID
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.name, forKey: .name)
        try container.encodeIfPresent(self.input, forKey: .input)
        try container.encodeIfPresent(self.authenticationID, forKey: .authenticationID)
    }
}

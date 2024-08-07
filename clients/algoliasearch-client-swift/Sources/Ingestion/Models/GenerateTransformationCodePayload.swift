// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GenerateTransformationCodePayload: Codable, JSONEncodable {
    public var id: String
    public var systemPrompt: String?
    public var userPrompt: String

    public init(id: String, systemPrompt: String? = nil, userPrompt: String) {
        self.id = id
        self.systemPrompt = systemPrompt
        self.userPrompt = userPrompt
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id
        case systemPrompt
        case userPrompt
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.id, forKey: .id)
        try container.encodeIfPresent(self.systemPrompt, forKey: .systemPrompt)
        try container.encode(self.userPrompt, forKey: .userPrompt)
    }
}

extension GenerateTransformationCodePayload: Equatable {
    public static func ==(lhs: GenerateTransformationCodePayload, rhs: GenerateTransformationCodePayload) -> Bool {
        lhs.id == rhs.id &&
            lhs.systemPrompt == rhs.systemPrompt &&
            lhs.userPrompt == rhs.userPrompt
    }
}

extension GenerateTransformationCodePayload: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.id.hashValue)
        hasher.combine(self.systemPrompt?.hashValue)
        hasher.combine(self.userPrompt.hashValue)
    }
}

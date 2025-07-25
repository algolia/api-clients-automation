// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Input for a no-code transformation that contains a series of steps.
public struct TransformationNoCode: Codable, JSONEncodable {
    public var steps: [AnyCodable]

    public init(steps: [AnyCodable]) {
        self.steps = steps
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case steps
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.steps, forKey: .steps)
    }
}

extension TransformationNoCode: Equatable {
    public static func ==(lhs: TransformationNoCode, rhs: TransformationNoCode) -> Bool {
        lhs.steps == rhs.steps
    }
}

extension TransformationNoCode: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.steps.hashValue)
    }
}

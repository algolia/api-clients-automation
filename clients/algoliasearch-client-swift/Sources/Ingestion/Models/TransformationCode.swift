// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Input for a transformation that contains the source code of the transformation.
public struct TransformationCode: Codable, JSONEncodable {
    /// The source code of the transformation.
    public var code: String

    public init(code: String) {
        self.code = code
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case code
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.code, forKey: .code)
    }
}

extension TransformationCode: Equatable {
    public static func ==(lhs: TransformationCode, rhs: TransformationCode) -> Bool {
        lhs.code == rhs.code
    }
}

extension TransformationCode: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.code.hashValue)
    }
}

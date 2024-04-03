// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum AuthInputPartial: Codable, JSONEncodable, AbstractEncodable {
    case authGoogleServiceAccountPartial(AuthGoogleServiceAccountPartial)
    case authBasicPartial(AuthBasicPartial)
    case authAPIKeyPartial(AuthAPIKeyPartial)
    case authOAuthPartial(AuthOAuthPartial)
    case authAlgoliaPartial(AuthAlgoliaPartial)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .authGoogleServiceAccountPartial(value):
            try container.encode(value)
        case let .authBasicPartial(value):
            try container.encode(value)
        case let .authAPIKeyPartial(value):
            try container.encode(value)
        case let .authOAuthPartial(value):
            try container.encode(value)
        case let .authAlgoliaPartial(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(AuthGoogleServiceAccountPartial.self) {
            self = .authGoogleServiceAccountPartial(value)
        } else if let value = try? container.decode(AuthBasicPartial.self) {
            self = .authBasicPartial(value)
        } else if let value = try? container.decode(AuthAPIKeyPartial.self) {
            self = .authAPIKeyPartial(value)
        } else if let value = try? container.decode(AuthOAuthPartial.self) {
            self = .authOAuthPartial(value)
        } else if let value = try? container.decode(AuthAlgoliaPartial.self) {
            self = .authAlgoliaPartial(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of AuthInputPartial")
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .authGoogleServiceAccountPartial(value):
            value as AuthGoogleServiceAccountPartial
        case let .authBasicPartial(value):
            value as AuthBasicPartial
        case let .authAPIKeyPartial(value):
            value as AuthAPIKeyPartial
        case let .authOAuthPartial(value):
            value as AuthOAuthPartial
        case let .authAlgoliaPartial(value):
            value as AuthAlgoliaPartial
        }
    }
}

extension AuthInputPartial: Equatable {}
extension AuthInputPartial: Hashable {}

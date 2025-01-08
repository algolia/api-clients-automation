// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SourceDocker: Codable, JSONEncodable {
    /// Shortname of the image, as returned by the referential.
    public var image: String
    /// Configuration of the spec.
    public var configuration: AnyCodable

    public init(image: String, configuration: AnyCodable) {
        self.image = image
        self.configuration = configuration
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case image
        case configuration
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.image, forKey: .image)
        try container.encode(self.configuration, forKey: .configuration)
    }
}

extension SourceDocker: Equatable {
    public static func ==(lhs: SourceDocker, rhs: SourceDocker) -> Bool {
        lhs.image == rhs.image &&
            lhs.configuration == rhs.configuration
    }
}

extension SourceDocker: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.image.hashValue)
        hasher.combine(self.configuration.hashValue)
    }
}

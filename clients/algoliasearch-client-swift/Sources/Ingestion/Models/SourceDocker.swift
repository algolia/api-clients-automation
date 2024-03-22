// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SourceDocker: Codable, JSONEncodable {
    public var imageType: DockerImageType
    public var registry: DockerRegistry
    /// The name of the image to pull.
    public var image: String
    /// The version of the image, defaults to `latest`.
    public var version: String?
    /// The configuration of the spec.
    public var configuration: AnyCodable

    public init(
        imageType: DockerImageType,
        registry: DockerRegistry,
        image: String,
        version: String? = nil,
        configuration: AnyCodable
    ) {
        self.imageType = imageType
        self.registry = registry
        self.image = image
        self.version = version
        self.configuration = configuration
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case imageType
        case registry
        case image
        case version
        case configuration
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.imageType, forKey: .imageType)
        try container.encode(self.registry, forKey: .registry)
        try container.encode(self.image, forKey: .image)
        try container.encodeIfPresent(self.version, forKey: .version)
        try container.encode(self.configuration, forKey: .configuration)
    }
}

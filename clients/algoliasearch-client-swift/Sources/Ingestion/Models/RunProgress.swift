// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct RunProgress: Codable, JSONEncodable, Hashable {
    public var expectedNbOfEvents: Int?
    public var receivedNbOfEvents: Int?

    public init(expectedNbOfEvents: Int? = nil, receivedNbOfEvents: Int? = nil) {
        self.expectedNbOfEvents = expectedNbOfEvents
        self.receivedNbOfEvents = receivedNbOfEvents
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case expectedNbOfEvents
        case receivedNbOfEvents
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(expectedNbOfEvents, forKey: .expectedNbOfEvents)
        try container.encodeIfPresent(receivedNbOfEvents, forKey: .receivedNbOfEvents)
    }
}

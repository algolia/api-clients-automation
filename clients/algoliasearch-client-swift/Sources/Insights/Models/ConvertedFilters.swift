// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

public struct ConvertedFilters: Codable, JSONEncodable, Hashable {
    static let eventNameRule = StringRule(minLength: 1, maxLength: 64, pattern: "[\\x20-\\x7E]{1,64}")
    static let userTokenRule = StringRule(minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
    static let authenticatedUserTokenRule = StringRule(minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
    /// Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
    /// framework.
    public var eventName: String
    public var eventType: ConversionEvent
    /// Index name to which the event's items belong.
    public var index: String
    /// Applied facet filters.  Facet filters are `facet:value` pairs. Facet values must be URL-encoded, such as,
    /// `discount:10%25`.
    public var filters: [String]
    /// Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For
    /// more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
    public var userToken: String
    /// Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send
    /// it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while
    /// providing a reliable way to identify users across sessions. Don't use personally identifiable information in
    /// user tokens. For more information, see [User
    /// token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
    public var authenticatedUserToken: String?
    /// Timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default,
    /// the Insights API uses the time it receives an event as its timestamp.
    public var timestamp: Int64?

    public init(
        eventName: String,
        eventType: ConversionEvent,
        index: String,
        filters: [String],
        userToken: String,
        authenticatedUserToken: String? = nil,
        timestamp: Int64? = nil
    ) {
        self.eventName = eventName
        self.eventType = eventType
        self.index = index
        self.filters = filters
        self.userToken = userToken
        self.authenticatedUserToken = authenticatedUserToken
        self.timestamp = timestamp
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case eventName
        case eventType
        case index
        case filters
        case userToken
        case authenticatedUserToken
        case timestamp
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.eventName, forKey: .eventName)
        try container.encode(self.eventType, forKey: .eventType)
        try container.encode(self.index, forKey: .index)
        try container.encode(self.filters, forKey: .filters)
        try container.encode(self.userToken, forKey: .userToken)
        try container.encodeIfPresent(self.authenticatedUserToken, forKey: .authenticatedUserToken)
        try container.encodeIfPresent(self.timestamp, forKey: .timestamp)
    }
}

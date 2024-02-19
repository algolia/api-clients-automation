// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Use this event to track when users click items unrelated to a previous Algolia request. For example, if you
/// don&#39;t use Algolia to build your category pages, use this event.  To track click events related to Algolia
/// requests, use the \&quot;Clicked object IDs after search\&quot; event.
public struct ClickedObjectIDs: Codable, JSONEncodable, Hashable {
    static let eventNameRule = StringRule(minLength: 1, maxLength: 64, pattern: "[\\x20-\\x7E]{1,64}")
    static let userTokenRule = StringRule(minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
    static let authenticatedUserTokenRule = StringRule(minLength: 1, maxLength: 129, pattern: "[a-zA-Z0-9_=/+-]{1,129}")
    /// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting
    /// Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
    /// framework.
    public var eventName: String
    public var eventType: ClickEvent
    /// The name of an Algolia index.
    public var index: String
    /// The object IDs of the records that are part of the event.
    public var objectIDs: [String]
    /// An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in
    /// user tokens.
    public var userToken: String
    /// An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user
    /// tokens.
    public var authenticatedUserToken: String?
    /// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By
    /// default, the Insights API uses the time it receives an event as its timestamp.
    public var timestamp: Int64?

    public init(
        eventName: String,
        eventType: ClickEvent,
        index: String,
        objectIDs: [String],
        userToken: String,
        authenticatedUserToken: String? = nil,
        timestamp: Int64? = nil
    ) {
        self.eventName = eventName
        self.eventType = eventType
        self.index = index
        self.objectIDs = objectIDs
        self.userToken = userToken
        self.authenticatedUserToken = authenticatedUserToken
        self.timestamp = timestamp
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case eventName
        case eventType
        case index
        case objectIDs
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
        try container.encode(self.objectIDs, forKey: .objectIDs)
        try container.encode(self.userToken, forKey: .userToken)
        try container.encodeIfPresent(self.authenticatedUserToken, forKey: .authenticatedUserToken)
        try container.encodeIfPresent(self.timestamp, forKey: .timestamp)
    }
}

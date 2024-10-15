// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Use this event to track when users convert after a previous Algolia request. For example, a user clicks on an item
/// in the search results to view the product detail page. Then, the user adds the item to their shopping cart.  If
/// you're building your category pages with Algolia, you'll also use this event.
public struct ConvertedObjectIDsAfterSearch: Codable, JSONEncodable {
    /// Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
    /// framework.
    public var eventName: String
    public var eventType: ConversionEvent
    /// Index name (case-sensitive) to which the event's items belong.
    public var index: String
    /// Object IDs of the records that are part of the event.
    public var objectIDs: [String]
    /// Unique identifier for a search query.  The query ID is required for events related to search or browse requests.
    /// If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.
    public var queryID: String
    /// Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For
    /// more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
    public var userToken: String
    /// Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send
    /// it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while
    /// providing a reliable way to identify users across sessions. Don't use personally identifiable information in
    /// user tokens. For more information, see [User
    /// token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
    public var authenticatedUserToken: String?
    /// Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the
    /// time it receives an event as its timestamp.
    public var timestamp: Int64?

    public init(
        eventName: String,
        eventType: ConversionEvent,
        index: String,
        objectIDs: [String],
        queryID: String,
        userToken: String,
        authenticatedUserToken: String? = nil,
        timestamp: Int64? = nil
    ) {
        self.eventName = eventName
        self.eventType = eventType
        self.index = index
        self.objectIDs = objectIDs
        self.queryID = queryID
        self.userToken = userToken
        self.authenticatedUserToken = authenticatedUserToken
        self.timestamp = timestamp
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case eventName
        case eventType
        case index
        case objectIDs
        case queryID
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
        try container.encode(self.queryID, forKey: .queryID)
        try container.encode(self.userToken, forKey: .userToken)
        try container.encodeIfPresent(self.authenticatedUserToken, forKey: .authenticatedUserToken)
        try container.encodeIfPresent(self.timestamp, forKey: .timestamp)
    }
}

extension ConvertedObjectIDsAfterSearch: Equatable {
    public static func ==(lhs: ConvertedObjectIDsAfterSearch, rhs: ConvertedObjectIDsAfterSearch) -> Bool {
        lhs.eventName == rhs.eventName &&
            lhs.eventType == rhs.eventType &&
            lhs.index == rhs.index &&
            lhs.objectIDs == rhs.objectIDs &&
            lhs.queryID == rhs.queryID &&
            lhs.userToken == rhs.userToken &&
            lhs.authenticatedUserToken == rhs.authenticatedUserToken &&
            lhs.timestamp == rhs.timestamp
    }
}

extension ConvertedObjectIDsAfterSearch: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.eventName.hashValue)
        hasher.combine(self.eventType.hashValue)
        hasher.combine(self.index.hashValue)
        hasher.combine(self.objectIDs.hashValue)
        hasher.combine(self.queryID.hashValue)
        hasher.combine(self.userToken.hashValue)
        hasher.combine(self.authenticatedUserToken?.hashValue)
        hasher.combine(self.timestamp?.hashValue)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct SecuredAPIKeyRestrictions: Codable, JSONEncodable {
    public var searchParams: SearchSearchParamsObject?
    /// Filters that apply to every search made with the secured API key. Extra filters added at search time will be
    /// combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add
    /// `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`.
    public var filters: String?
    /// Timestamp when the secured API key expires, measured in seconds since the Unix epoch.
    public var validUntil: Int64?
    /// Index names or patterns that this API key can access. By default, an API key can access all indices in the same
    /// application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices
    /// starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices
    /// containing \"_products_\".
    public var restrictIndices: [String]?
    /// IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of
    /// IP addresses. Use this to protect against API key leaking and reuse.
    public var restrictSources: String?
    /// Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are
    /// set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this,
    /// add a user token to each generated API key.
    public var userToken: String?

    public init(
        searchParams: SearchSearchParamsObject? = nil,
        filters: String? = nil,
        validUntil: Int64? = nil,
        restrictIndices: [String]? = nil,
        restrictSources: String? = nil,
        userToken: String? = nil
    ) {
        self.searchParams = searchParams
        self.filters = filters
        self.validUntil = validUntil
        self.restrictIndices = restrictIndices
        self.restrictSources = restrictSources
        self.userToken = userToken
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case searchParams
        case filters
        case validUntil
        case restrictIndices
        case restrictSources
        case userToken
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.searchParams, forKey: .searchParams)
        try container.encodeIfPresent(self.filters, forKey: .filters)
        try container.encodeIfPresent(self.validUntil, forKey: .validUntil)
        try container.encodeIfPresent(self.restrictIndices, forKey: .restrictIndices)
        try container.encodeIfPresent(self.restrictSources, forKey: .restrictSources)
        try container.encodeIfPresent(self.userToken, forKey: .userToken)
    }
}

extension SecuredAPIKeyRestrictions: Equatable {
    public static func ==(lhs: SecuredAPIKeyRestrictions, rhs: SecuredAPIKeyRestrictions) -> Bool {
        lhs.searchParams == rhs.searchParams &&
            lhs.filters == rhs.filters &&
            lhs.validUntil == rhs.validUntil &&
            lhs.restrictIndices == rhs.restrictIndices &&
            lhs.restrictSources == rhs.restrictSources &&
            lhs.userToken == rhs.userToken
    }
}

extension SecuredAPIKeyRestrictions: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.searchParams?.hashValue)
        hasher.combine(self.filters?.hashValue)
        hasher.combine(self.validUntil?.hashValue)
        hasher.combine(self.restrictIndices?.hashValue)
        hasher.combine(self.restrictSources?.hashValue)
        hasher.combine(self.userToken?.hashValue)
    }
}

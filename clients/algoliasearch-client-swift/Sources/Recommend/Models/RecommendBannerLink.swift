// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// link for a banner defined in merchandising studio.
public struct RecommendBannerLink: Codable, JSONEncodable {
    public var url: String?

    public init(url: String? = nil) {
        self.url = url
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case url
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.url, forKey: .url)
    }
}

extension RecommendBannerLink: Equatable {
    public static func ==(lhs: RecommendBannerLink, rhs: RecommendBannerLink) -> Bool {
        lhs.url == rhs.url
    }
}

extension RecommendBannerLink: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.url?.hashValue)
    }
}

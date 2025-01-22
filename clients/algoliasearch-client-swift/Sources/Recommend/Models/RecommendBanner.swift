// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Banner with image and link to redirect users.
public struct RecommendBanner: Codable, JSONEncodable {
    public var image: RecommendBannerImage?
    public var link: RecommendBannerLink?

    public init(image: RecommendBannerImage? = nil, link: RecommendBannerLink? = nil) {
        self.image = image
        self.link = link
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case image
        case link
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(self.image, forKey: .image)
        try container.encodeIfPresent(self.link, forKey: .link)
    }
}

extension RecommendBanner: Equatable {
    public static func ==(lhs: RecommendBanner, rhs: RecommendBanner) -> Bool {
        lhs.image == rhs.image &&
            lhs.link == rhs.link
    }
}

extension RecommendBanner: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.image?.hashValue)
        hasher.combine(self.link?.hashValue)
    }
}

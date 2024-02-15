// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - OrderBy

/// Method for ordering results. &#x60;clickThroughRate&#x60;, &#x60;conversionRate&#x60; and
/// &#x60;averageClickPosition&#x60; are only available if the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;.
public enum OrderBy: String, Codable, CaseIterable {
    case searchCount
    case clickThroughRate
    case conversionRate
    case averageClickPosition
}

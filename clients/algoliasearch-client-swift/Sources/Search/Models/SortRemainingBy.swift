// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

/// How to display the remaining items:    - &#x60;count&#x60;: facet count (descending).   - &#x60;alpha&#x60;:
/// alphabetical (ascending).   - &#x60;hidden&#x60;: show only pinned values.
public enum SortRemainingBy: String, Codable, CaseIterable {
    case count
    case alpha
    case hidden
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** Strategy to [remove words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/) from the query when it doesn&#39;t match any hits. */
public enum RemoveWordsIfNoResults: String, Codable, CaseIterable {
    case none
    case lastWords
    case firstWords
    case allOptional
}

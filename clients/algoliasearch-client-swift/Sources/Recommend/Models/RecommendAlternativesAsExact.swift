// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public enum RecommendAlternativesAsExact: String, Codable, CaseIterable {
    case ignorePlurals
    case singleWordSynonym
    case multiWordsSynonym
    case ignoreConjugations
}

extension RecommendAlternativesAsExact: Hashable {}

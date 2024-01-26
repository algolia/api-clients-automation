// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** - &#x60;none&#x60;: executes all queries. - &#x60;stopIfEnoughMatches&#x60;: executes queries one by one, stopping further query execution as soon as a query matches at least the &#x60;hitsPerPage&#x60; number of results.   */
public enum SearchStrategy: String, Codable, CaseIterable {
    case none
    case stopIfEnoughMatches
}

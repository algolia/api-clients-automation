// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

/// Indicates how well the attribute matched the search query.
public enum MatchLevel: String, Codable, CaseIterable {
    case `none`
    case partial
    case full
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Indicates how well the attribute matched the search query.
public enum MatchLevel: String, Codable, CaseIterable {
  case _none = "none"
  case partial = "partial"
  case full = "full"
}

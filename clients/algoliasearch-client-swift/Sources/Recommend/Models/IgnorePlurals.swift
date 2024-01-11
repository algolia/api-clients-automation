// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Treats singular, plurals, and other forms of declensions as matching terms. &#x60;ignorePlurals&#x60; is used in conjunction with the &#x60;queryLanguages&#x60; setting. _list_: language ISO codes for which ignoring plurals should be enabled. This list will override any values that you may have set in &#x60;queryLanguages&#x60;. _true_: enables the ignore plurals feature, where singulars and plurals are considered equivalent (\&quot;foot\&quot; &#x3D; \&quot;feet\&quot;). The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by &#x60;queryLanguages&#x60;. _false_: turns off the ignore plurals feature, so that singulars and plurals aren&#39;t considered to be the same (\&quot;foot\&quot; will not find \&quot;feet\&quot;).
public enum IgnorePlurals: Codable, JSONEncodable, Hashable {
  case bool(Bool)
  case arrayOfString([String])

  public func encode(to encoder: Encoder) throws {
    var container = encoder.singleValueContainer()
    switch self {
    case .bool(let value):
      try container.encode(value)
    case .arrayOfString(let value):
      try container.encode(value)
    }
  }

  public init(from decoder: Decoder) throws {
    let container = try decoder.singleValueContainer()
    if let value = try? container.decode(Bool.self) {
      self = .bool(value)
    } else if let value = try? container.decode([String].self) {
      self = .arrayOfString(value)
    } else {
      throw DecodingError.typeMismatch(
        Self.Type.self,
        .init(
          codingPath: decoder.codingPath,
          debugDescription: "Unable to decode instance of IgnorePlurals"))
    }
  }
}

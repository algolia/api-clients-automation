// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Filter by numeric facets.  **Prefer using the &#x60;filters&#x60; parameter, which supports all filter types and
/// combinations with boolean operators.**  You can use numeric comparison operators: &#x60;&lt;&#x60;,
/// &#x60;&lt;&#x3D;&#x60;, &#x60;&#x3D;&#x60;, &#x60;!&#x3D;&#x60;, &#x60;&gt;&#x60;, &#x60;&gt;&#x3D;&#x60;.
/// Comparisons are precise up to 3 decimals. You can also provide ranges: &#x60;facet:&lt;lower&gt; TO
/// &lt;upper&gt;&#x60;. The range includes the lower and upper boundaries. The same combination rules apply as for
/// &#x60;facetFilters&#x60;.
public enum SearchNumericFilters: Codable, JSONEncodable, AbstractEncodable {
    case arrayOfSearchNumericFilters([SearchNumericFilters])
    case string(String)

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case let .arrayOfSearchNumericFilters(value):
            try container.encode(value)
        case let .string(value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode([SearchNumericFilters].self) {
            self = .arrayOfSearchNumericFilters(value)
        } else if let value = try? container.decode(String.self) {
            self = .string(value)
        } else {
            throw DecodingError.typeMismatch(
                Self.Type.self,
                .init(
                    codingPath: decoder.codingPath,
                    debugDescription: "Unable to decode instance of SearchNumericFilters"
                )
            )
        }
    }

    public func GetActualInstance() -> Encodable {
        switch self {
        case let .arrayOfSearchNumericFilters(value):
            value as [SearchNumericFilters]
        case let .string(value):
            value as String
        }
    }
}

extension SearchNumericFilters: Equatable {}
extension SearchNumericFilters: Hashable {}

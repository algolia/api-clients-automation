// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// The input for a &#x60;streaming&#x60; task whose source is of type &#x60;ga4BigqueryExport&#x60; and for which
/// extracted data is continuously streamed.
public struct StreamingUtilsInput: Codable, JSONEncodable {
    public var mapping: MappingInput

    public init(mapping: MappingInput) {
        self.mapping = mapping
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case mapping
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.mapping, forKey: .mapping)
    }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// The type of transformation, which can be either 'code' or 'noCode'.
public enum TransformationType: String, Codable, CaseIterable {
    case code
    case noCode
}

extension TransformationType: Hashable {}

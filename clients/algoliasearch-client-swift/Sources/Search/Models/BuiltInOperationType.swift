// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - BuiltInOperationType

/// Operation to apply to the attribute.
public enum BuiltInOperationType: String, Codable, CaseIterable {
    case increment = "Increment"
    case decrement = "Decrement"
    case add = "Add"
    case remove = "Remove"
    case addUnique = "AddUnique"
    case incrementFrom = "IncrementFrom"
    case incrementSet = "IncrementSet"
}

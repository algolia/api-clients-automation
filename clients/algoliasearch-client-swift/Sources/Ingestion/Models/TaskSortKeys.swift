// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/// Used to sort the Task list endpoint.
public enum TaskSortKeys: String, Codable, CaseIterable {
    case enabled
    case triggerType
    case action
    case updatedAt
    case createdAt
}

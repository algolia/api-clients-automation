// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

// MARK: - TaskStatus

/// _published_ if the task has been processed, _notPublished_ otherwise.
public enum TaskStatus: String, Codable, CaseIterable {
    case published
    case notPublished
}

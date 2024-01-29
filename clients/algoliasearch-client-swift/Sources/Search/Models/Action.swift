// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

/** Type of batch operation. */
public enum Action: String, Codable, CaseIterable {
    case addObject
    case updateObject
    case partialUpdateObject
    case partialUpdateObjectNoCreate
    case deleteObject
    case delete
    case clear
}

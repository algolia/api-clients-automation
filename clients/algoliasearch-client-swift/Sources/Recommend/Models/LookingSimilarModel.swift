// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

/// Looking similar model.  This model recommends items that look similar to the item with the ID `objectID` based on
/// image attributes in your index.
public enum LookingSimilarModel: String, Codable, CaseIterable {
    case lookingSimilar = "looking-similar"
}

extension LookingSimilarModel: Hashable {}

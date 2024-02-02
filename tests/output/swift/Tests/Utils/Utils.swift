//
//  Utils.swift
//
//
//  Created by Algolia on 26/01/2024.
//

import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

#if canImport(AnyCodable)
    public typealias TestNullObject = [String: AnyCodable]
#else
    public typealias TestNullObject = [String: Any]
#endif

public typealias TestNullString = String

public typealias StringMapObject = [String: String?]

public extension Data {
    var jsonString: String? {
        return (try? JSONSerialization.jsonObject(with: self, options: .allowFragments))
            .flatMap {
                try? JSONSerialization.data(withJSONObject: $0, options: [.prettyPrinted, .fragmentsAllowed, .sortedKeys])
            }
            .flatMap { String(data: $0, encoding: .utf8) }
    }
}

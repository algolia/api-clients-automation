//
//  Data.swift
//
//
//  Created by Algolia on 26/01/2024.
//

import Foundation

extension Data {
    var jsonString: String? {
        return (try? JSONSerialization.jsonObject(with: self, options: .allowFragments))
            .flatMap {
                try? JSONSerialization.data(withJSONObject: $0, options: [.prettyPrinted, .fragmentsAllowed, .sortedKeys])
            }
            .flatMap { String(data: $0, encoding: .utf8) }
    }
}

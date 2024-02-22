//
//  Random.swift
//
//
//  Created by Algolia on 22/02/2024.
//

import Foundation

public func randomString(length: Int = 10) throws -> String {
    let characterSet = String(describing: CharacterSet.alphanumerics)

    return try String(describing: (0 ..< length).map { _ in characterSet.randomElement() })
}

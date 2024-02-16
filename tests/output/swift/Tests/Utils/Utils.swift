//
//  Utils.swift
//
//
//  Created by Algolia on 26/01/2024.
//

import Foundation
import XCTest
#if canImport(AnyCodable)
    import AnyCodable
#endif

#if canImport(AnyCodable)
    public typealias TestNullObject = [String: AnyCodable]
#else
    public typealias TestNullObject = [String: Any]
#endif

public typealias TestNullString = String

public extension Data {
    var jsonString: String? {
        (try? JSONSerialization.jsonObject(
            with: self,
            options: .allowFragments
        ))
        .flatMap {
            try? JSONSerialization.data(
                withJSONObject: $0,
                options: [.prettyPrinted, .fragmentsAllowed, .sortedKeys]
            )
        }
        .flatMap { String(data: $0, encoding: .utf8) }
    }
}

public func XCTLenientAssertEqual(received: Data?, expected: Data?, path: String = "$") throws {
    guard
        let expected,
        let received,
        let receivedFragment = try? JSONSerialization.jsonObject(with: received, options: [.fragmentsAllowed]),
        let expectedFragment = try? JSONSerialization.jsonObject(with: expected, options: [.fragmentsAllowed])
    else {
        XCTAssertEqual(expected?.jsonString, received?.jsonString, "Key: `\(path)`; Message: expected values to be equal")
        return
    }
    
    if let expectedDict = expectedFragment as? [String: Any?] {
        guard let receivedDict = receivedFragment as? [String: Any?] else {
            XCTFail("Key: `\(path)`; Message: expected a dictionary and received something else")
            return
        }
        
        for (key, value) in expectedDict {
            guard let receivedValue = receivedDict[key] else {
                XCTFail("Key: `\(path)`; Message: expected to have key `\(key)` but couldn't find it in received dictionary")
                return
            }
            
            if let expectedValue = value {
                guard let receivedValue else {
                    XCTFail("Key: `\(path)`; Message: expected to have some value at `\(key)` but received dictionary value was `nil`")
                    return
                }
                 
                try? XCTLenientAssertEqual(
                    received: JSONSerialization.data(withJSONObject: receivedValue, options: .fragmentsAllowed),
                    expected: JSONSerialization.data(withJSONObject: expectedValue, options: .fragmentsAllowed),
                    path: path + ".\(key)"
                )
            }
        }
    } else if let expectedArray = expectedFragment as? [Any] {
        guard let receivedArray = receivedFragment as? [Any] else {
            XCTFail("Key: `\(path)`; Message: expected an array and received something else")
            return
        }

        for (index, (nestedReceived, nestedExpected)) in zip(receivedArray, expectedArray).enumerated() {
            try? XCTLenientAssertEqual(
                received: JSONSerialization.data(withJSONObject: nestedReceived, options: .fragmentsAllowed),
                expected: JSONSerialization.data(withJSONObject: nestedExpected, options: .fragmentsAllowed),
                path: path + ".\(index)"
            )
        }
    } else {
        XCTAssertEqual(expected.jsonString, received.jsonString, "Key: `\(path)`; Message: expected values to be equal")
        return
    }
}

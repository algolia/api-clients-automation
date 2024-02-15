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

public func XCTLenientAssertEqual(received: Data?, expected: Data?) throws {
    guard
        let expected,
        let received,
        let received = try? JSONSerialization.jsonObject(with: received, options: []),
        let expected = try? JSONSerialization.jsonObject(with: expected, options: []),
        let receivedDict = received as? [String: Any],
        let expectedDict = expected as? [String: Any]
    else {
        XCTAssertEqual(expected, received)
        return
    }

    for (key, value) in expectedDict {
        if let receivedValue = receivedDict[key] {
            if let nestedExpected = value as? [String: Any] {
                guard let nestedReceivedDict = receivedValue as? [String: Any] else {
                    XCTFail("Expected a dictionary")
                    return
                }
                try XCTLenientAssertEqual(
                    received: JSONSerialization.data(withJSONObject: nestedReceivedDict),
                    expected: JSONSerialization.data(withJSONObject: nestedExpected)
                )
            } else if let arrayExpected = value as? [[String: Any]] {
                guard let receivedArray = receivedValue as? [[String: Any]] else {
                    XCTFail("Expected an array of dictionaries")
                    return
                }
                zip(arrayExpected, receivedArray).forEach { expected, received in
                    try? XCTLenientAssertEqual(
                        received: JSONSerialization.data(withJSONObject: received),
                        expected: JSONSerialization.data(withJSONObject: expected)
                    )
                }
            } else {
                XCTAssertEqual(
                    convertAnyToString(receivedValue),
                    convertAnyToString(value),
                    "Expected \(key) to be \(value) but got \(receivedValue)"
                )
            }
        }
    }
}

private func convertAnyToString(_ value: Any?) -> String? {
    guard let value else {
        return nil
    }
    if let value = value as? any RawRepresentable {
        return "\(value.rawValue)"
    } else {
        return "\(value)"
    }
}

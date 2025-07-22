//
//  Utils.swift
//
//
//  Created by Algolia on 26/01/2024.
//

import Core
import Foundation
import XCTest

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

struct TestError: Error {
    let message: String
}

public func XTCJSONEquals(received: some Encodable, expected: String) {
    let expectedData = expected.data(using: .utf8)!
    let receivedJSON = try! JSONEncoder().encode(received)

    let dictReceived = try! JSONSerialization.jsonObject(with: receivedJSON) as! NSDictionary
    let dictExpected = try! JSONSerialization.jsonObject(with: expectedData) as! NSDictionary

    XCTAssertEqual(
        dictReceived,
        dictExpected,
        """
        Received JSON: \(String(data: receivedJSON, encoding: .utf8) ?? "nil")
        Expected JSON: \(expected)
        """
    )
}

public func XCTLenientAssertEqual(received: some Encodable, expected: String) {
    let receivedData = try! JSONEncoder().encode(received)
    guard let unionizedObject = try? union(
        expected: JSONSerialization.jsonObject(with: expected.data(using: .utf8)!, options: [.fragmentsAllowed]),
        received: JSONSerialization.jsonObject(with: receivedData, options: [.fragmentsAllowed])
    ) else {
        if let receivedString = String(data: receivedData, encoding: .utf8) {
            XCTAssertEqual(receivedString, expected)
        } else {
            XCTFail("Unable to unionize received and expected objects")
        }
        return
    }

    guard let unionizedData = try? JSONSerialization.data(withJSONObject: unionizedObject, options: .fragmentsAllowed),
          let unionizedJSON = unionizedData.jsonString?.data(using: .utf8),
          let unionizedString = String(data: unionizedJSON, encoding: .utf8),
          let expectedJSON = try? JSONSerialization.jsonObject(
              with: expected.data(using: .utf8)!,
              options: .fragmentsAllowed
          ),
          let expectedData = try? JSONSerialization.data(withJSONObject: expectedJSON, options: .fragmentsAllowed),
          let expectedMinifiedJSON = expectedData.jsonString?.data(using: .utf8),
          let expectedString = String(data: expectedMinifiedJSON, encoding: .utf8)
    else {
        XCTFail("Unable to serialize JSON strings")
        return
    }

    XCTAssertEqual(
        unionizedString,
        expectedString
    )
}

public func union(expected: Any?, received: Any?) -> Any? {
    guard let expected else {
        return received
    }

    guard let received else {
        return received
    }

    if let expectedArray = expected as? [Any?] {
        if let receivedArray = received as? [Any?] {
            var res = [Any?]()
            for (index, element) in expectedArray.enumerated() {
                res.append(union(expected: element, received: receivedArray[index]))
            }
            return res as Any?
        }
        return received
    }

    if let expectedDict = expected as? [String: Any?] {
        if let receivedDict = received as? [String: Any?] {
            var res = [String: Any?]()
            for (key, value) in expectedDict {
                if let receivedValue = receivedDict[key] {
                    res[key] = union(expected: value, received: receivedValue)
                }
            }
            return res
        }
    }

    return received
}

public func regexMatch(_ received: String, against: String) -> Bool {
    let matches = try! NSRegularExpression(pattern: against).matches(
        in: received,
        range: .init(location: 0, length: received.utf16.count)
    )
    return !matches.isEmpty
}

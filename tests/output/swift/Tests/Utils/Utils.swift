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

public func XCTLenientAssertEqual(received: Data, expected: Data) {
    guard let unionizedObject = try? union(
        expected: JSONSerialization.jsonObject(with: expected, options: [.fragmentsAllowed]),
        received: JSONSerialization.jsonObject(with: received, options: [.fragmentsAllowed])
    ) else {
        if let receivedString = String(data: received, encoding: .utf8),
           let expectedString = String(data: expected, encoding: .utf8) {
            XCTAssertEqual(receivedString, expectedString)
        } else {
            XCTFail("Unable to unionize received and expected objects")
        }
        return
    }

    guard let unionizedData = try? JSONSerialization.data(withJSONObject: unionizedObject, options: .fragmentsAllowed),
          let unionizedJSON = unionizedData.jsonString?.data(using: .utf8),
          let expectedJSON = expected.jsonString?.data(using: .utf8),
          let unionizedString = String(data: unionizedJSON, encoding: .utf8),
          let expectedString = String(data: expectedJSON, encoding: .utf8)
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
    let regex = try! NSRegularExpression(pattern: against)
    let range = NSRange(received.startIndex ..< received.endIndex, in: received)
    return regex.firstMatch(in: received, options: [], range: range) != nil
}

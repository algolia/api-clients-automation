//
//  SecuredApiKeyHelpers.swift
//
//
//  Created by Algolia on 23/02/2024.
//

import Foundation
import XCTest
@testable import Core
@testable import Search

class SecuredApiKeyHelpersTests: XCTestCase {
    func testGenerateSecuredApiKeySuccess() async throws {
        let client = try SearchClient(appID: "my-app-id", apiKey: "my-api-key")

        let securedApiKey = try client.generateSecuredApiKey(
            parentApiKey: "parent-api-key"
        )

        guard let securedApiKey else {
            XCTFail("Unable to generate secured API key")
            return
        }

        XCTAssertEqual(
            securedApiKey,
            "MGQ3NWNhMDc5ZTIwOTk0NGMzMTg5MjRhNDlhNGNkOWMzODI5ODM2NDUxNzg5ODg4YzBhMDg3YmQxMzAwYmRhNw=="
        )
    }

    func testGetSecuredApiKeyRemainingValiditySuccess() async throws {
        let now = Date().timeIntervalSince1970
        let waitDuration: TimeInterval = .seconds(3)
        let client = try SearchClient(appID: "my-app-id", apiKey: "my-api-key")

        let securedApiKey = try client.generateSecuredApiKey(
            parentApiKey: "parent-api-key",
            with: SecuredApiKeyRestrictions(
                searchParams: SearchParamsObject(hitsPerPage: 2),
                validUntil: Int64(now + .seconds(13)),
                restrictIndices: ["index1", "index2"]
            )
        )

        try await Task.sleep(nanoseconds: UInt64(waitDuration) * 1_000_000_000)

        guard let securedApiKey else {
            XCTFail("Unable to generate secured API key")
            return
        }

        let remainingValidity = client.getSecuredApiKeyRemainingValidity(for: securedApiKey)
        guard let remainingValidity else {
            XCTFail("Unable to retrieve validity from secured API key")
            return
        }

        XCTAssertGreaterThan(remainingValidity, 0)
        XCTAssertLessThan(remainingValidity, now + waitDuration)
    }
}

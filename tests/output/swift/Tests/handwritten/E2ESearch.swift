//
//  E2ESearch.swift
//
//
//  Created by Algolia on 23/02/2024.
//

import DotEnv
import Foundation
import XCTest
@testable import Core
@testable import Search

struct Company: Codable {
    let objectID: String
    let name: String
    let value: Int
    let timestamp: Int64
}

class E2ESearchTests: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var e2eClient: SearchClient?

    override class func setUp() {
        if !(Bool(ProcessInfo.processInfo.environment["CI"] ?? "false") ?? false) {
            do {
                let currentFileURL = try XCTUnwrap(URL(string: #file))

                let packageDirectoryURL = currentFileURL
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()

                let dotEnvURL = packageDirectoryURL
                    .appendingPathComponent(".env")
                dump(dotEnvURL.absoluteString)
                try DotEnv.load(path: dotEnvURL.absoluteString, encoding: .utf8, overwrite: true)
            } catch {
                XCTFail("Unable to load .env file")
            }
        }

        do {
            self.APPLICATION_ID = try XCTUnwrap(ProcessInfo.processInfo.environment["ALGOLIA_APPLICATION_ID"])
        } catch {
            XCTFail("Please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests")
        }

        do {
            self.API_KEY = try XCTUnwrap(ProcessInfo.processInfo.environment["ALGOLIA_ADMIN_KEY"])
        } catch {
            XCTFail("Please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")
        }

        self.e2eClient = try? SearchClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY)
    }

    func testReplaceAllObjectsSuccess() async throws {
        guard let e2eClient = E2ESearchTests.e2eClient else {
            XCTFail("Couldn't initialize the E2E client")
            return
        }

        let indexName = "swift_e2e_test_replace_all_objects"
        let now = Int64(Date().timeIntervalSince1970)
        var records: [Company] = []

        for i in 0 ... Int.random(in: 250 ... 3500) {
            try records.append(
                .init(
                    objectID: randomString(),
                    name: randomString(length: (i % 5) + 1),
                    value: Int.random(in: 1 ... 9_999_999),
                    timestamp: now
                )
            )
        }

        let response = try await e2eClient.replaceAllObjects(with: records, in: indexName)

        let expectedBatches = stride(from: 0, to: records.count, by: e2eClient.configuration.batchSize).map {
            Array(records[$0 ..< min($0 + e2eClient.configuration.batchSize, records.count)])
        }

        XCTAssertEqual(response.batchResponses.count, expectedBatches.count)
        for (index, batchResponse) in response.batchResponses.enumerated() {
            XCTAssertEqual(batchResponse.objectIDs.count, expectedBatches[index].count)
        }
    }
}

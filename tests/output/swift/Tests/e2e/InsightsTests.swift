// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import DotEnv
import Utils

@testable import Core
@testable import Insights

final class InsightsClientRequestsTestsE2E: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var client: InsightsClient?

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

        self.client = try? InsightsClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY, region: .us)
    }

    /// Many events type
    func testPushEventsTest1() async throws {
        guard let client = InsightsClientRequestsTestsE2E.client else {
            XCTFail("E2E client is not initialized")
            return
        }

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [
            EventsItems.convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch(
                eventName: "Product Purchased",
                eventType: ConversionEvent.conversion,
                index: "products",
                objectIDs: ["9780545139700", "9780439784542"],
                queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                userToken: "user-123456",
                authenticatedUserToken: "user-123456",
                timestamp: Int64(1_740_528_000_000)
            )),
            EventsItems.viewedObjectIDs(ViewedObjectIDs(
                eventName: "Product Detail Page Viewed",
                eventType: ViewEvent.view,
                index: "products",
                objectIDs: ["9780545139700", "9780439784542"],
                userToken: "user-123456",
                authenticatedUserToken: "user-123456",
                timestamp: Int64(1_740_528_000_000)
            )),
        ]))
        let responseBody = try XCTUnwrap(response.body)
        let responseBodyData = try CodableHelper.jsonEncoder.encode(responseBody)

        let expectedBodyData = try XCTUnwrap("{\"message\":\"OK\",\"status\":200}".data(using: .utf8))

        XCTLenientAssertEqual(received: responseBodyData, expected: expectedBodyData)

        XCTAssertEqual(response.statusCode, 200)
    }
}

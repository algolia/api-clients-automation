import XCTest

import Utils

@testable import Abtesting
@testable import Core

final class AbtestingClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try AbtestingClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        let rule = StringRule(pattern: pattern)
        let userAgent = try XCTUnwrap(echoResponse.headers?["User-Agent"])
        guard let userAgent else {
            XCTFail("Expected user-agent header")
            return
        }

        XCTAssertNoThrow(
            try Validator.validate(userAgent, against: rule),
            "Expected " + userAgent + " to match the following regex: " + pattern
        )
    }

    /// calls api with default read timeouts
    func testCommonApiTest1() async throws {
        let configuration = try AbtestingClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest2() async throws {
        let configuration = try AbtestingClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// fallbacks to the alias when region is not given
    func testParametersTest0() async throws {
        let configuration = try AbtestingClientConfiguration(appID: "my-app-id", apiKey: "my-api-key", region: nil)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)
        let response = try await client.getABTestWithHTTPInfo(
            id: 123
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("analytics.algolia.com", echoResponse.host)
    }

    /// uses the correct region
    func testParametersTest1() async throws {
        let configuration = try AbtestingClientConfiguration(
            appID: "my-app-id",
            apiKey: "my-api-key",
            region: Region(rawValue: "us")
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)
        let response = try await client.getABTestWithHTTPInfo(
            id: 123
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("analytics.us.algolia.com", echoResponse.host)
    }

    /// throws when incorrect region is given
    func testParametersTest2() async throws {
        do {
            let configuration = try AbtestingClientConfiguration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "not_a_region")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = AbtestingClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` must be one of the following: de, us")
        }
    }
}

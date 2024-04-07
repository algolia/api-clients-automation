// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Core
@testable import Usage

final class UsageClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct read host
    func testApiTest0() async throws {
        let configuration = try UsageClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = UsageClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(
            path: "test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }

    /// calls api with correct write host
    func testApiTest1() async throws {
        let configuration = try UsageClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = UsageClient(configuration: configuration, transporter: transporter)
        let response = try await client.customPostWithHTTPInfo(
            path: "test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id.algolia.net", echoResponse.host)
    }

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try UsageClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = UsageClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "1/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Usage (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        let configuration = try UsageClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = UsageClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "1/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest2() async throws {
        let configuration = try UsageClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = UsageClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "1/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// client throws with invalid parameters
    func testParametersTest0() async throws {
        do {
            let configuration = try UsageClientConfiguration(appID: "", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = UsageClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try UsageClientConfiguration(appID: "", apiKey: "my-api-key")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = UsageClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try UsageClientConfiguration(appID: "my-app-id", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = UsageClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`apiKey` is missing.")
        }
    }
}

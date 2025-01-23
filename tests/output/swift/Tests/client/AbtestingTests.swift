// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
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

        let response = try await client.customPostWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// the user agent contains the latest version
    func testCommonApiTest1() async throws {
        let configuration = try AbtestingClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern = "^Algolia for Swift \\(9.14.0\\).*"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// fallbacks to the alias when region is not given
    func testParametersTest0() async throws {
        let configuration = try AbtestingClientConfiguration(appID: "my-app-id", apiKey: "my-api-key", region: nil)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)
        let response = try await client.getABTestWithHTTPInfo(id: 123)

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
        let response = try await client.getABTestWithHTTPInfo(id: 123)

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

    /// switch API key
    func testSetClientApiKeyTest0() async throws {
        let configuration = try AbtestingClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            region: Region(rawValue: "us"),
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6683"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = AbtestingClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.customGetWithHTTPInfo(path: "check-api-key/1")

            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            let comparableData = "{\"headerAPIKeyValue\":\"test-api-key\"}".data(using: .utf8)
            let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
            XCTAssertEqual(comparableJSON, responseBodyJSON)
        }
        do {
            let _ = try client.setClientApiKey(apiKey: "updated-api-key")
        }
        do {
            let response = try await client.customGetWithHTTPInfo(path: "check-api-key/2")

            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            let comparableData = "{\"headerAPIKeyValue\":\"updated-api-key\"}".data(using: .utf8)
            let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
            XCTAssertEqual(comparableJSON, responseBodyJSON)
        }
    }
}

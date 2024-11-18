// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Core
@testable import Personalization

final class PersonalizationClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try PersonalizationClientConfiguration(
            appID: APPLICATION_ID,
            apiKey: API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// the user agent contains the latest version
    func testCommonApiTest1() async throws {
        let configuration = try PersonalizationClientConfiguration(
            appID: APPLICATION_ID,
            apiKey: API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern = "^Algolia for Swift \\(9.10.1\\).*"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// calls api with default read timeouts
    func testCommonApiTest2() async throws {
        let configuration = try PersonalizationClientConfiguration(
            appID: APPLICATION_ID,
            apiKey: API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest3() async throws {
        let configuration = try PersonalizationClientConfiguration(
            appID: APPLICATION_ID,
            apiKey: API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// throws when region is not given
    func testParametersTest0() async throws {
        do {
            let configuration = try PersonalizationClientConfiguration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = PersonalizationClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` is required and must be one of the following: eu, us")
        }
    }

    /// throws when incorrect region is given
    func testParametersTest1() async throws {
        do {
            let configuration = try PersonalizationClientConfiguration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "not_a_region")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = PersonalizationClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` is required and must be one of the following: eu, us")
        }
    }

    /// does not throw when region is given
    func testParametersTest2() async throws {
        let configuration = try PersonalizationClientConfiguration(
            appID: "my-app-id",
            apiKey: "my-api-key",
            region: Region(rawValue: "us")
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)
    }

    /// switch API key
    func testSetClientApiKeyTest0() async throws {
        let configuration = try PersonalizationClientConfiguration(
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
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.customGetWithHTTPInfo(path: "check-api-key/1")
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            let comparableData = "{\"headerAPIKeyValue\":\"test-api-key\"}".data(using: .utf8)
            let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
            XCTAssertEqual(comparableJSON, responseBodyJSON)
        }
        do {
            try client.setClientApiKey(apiKey: "updated-api-key")
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

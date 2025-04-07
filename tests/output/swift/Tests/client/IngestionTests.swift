// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Core
@testable import Ingestion

final class IngestionClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// can handle HTML error
    func testApiTest0() async throws {
        let configuration = try IngestionClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            region: Region(rawValue: "us"),
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6676"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = IngestionClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.customGetWithHTTPInfo(path: "1/html-error")

            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "HTTP error: Status code: 429 Message: No message")
        }
    }

    /// calls api with default read timeouts
    func testApiTest1() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(25000) / 1000, echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testApiTest2() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(25000) / 1000, echoResponse.timeout)
    }

    /// can leave call opened for a long time
    func testApiTest3() async throws {
        let configuration = try IngestionClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            region: Region(rawValue: "us"),
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6676"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = IngestionClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(path: "1/long-wait")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

        let comparableData = "{\"message\":\"OK\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
        XCTAssertEqual(comparableJSON, responseBodyJSON)
    }

    /// endpoint level timeout
    func testApiTest4() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.validateSourceBeforeUpdateWithHTTPInfo(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName")
        )

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(180_000) / 1000, echoResponse.timeout)
    }

    /// can override endpoint level timeout
    func testApiTest5() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.validateSourceBeforeUpdateWithHTTPInfo(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName"),
            requestOptions: RequestOptions(
                writeTimeout: TimeInterval(3456) / 1000
            )
        )

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(3456) / 1000, echoResponse.timeout)
    }

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Ingestion (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// the user agent contains the latest version
    func testCommonApiTest1() async throws {
        let configuration = try IngestionClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern = "^Algolia for Swift \\(9.18.3\\).*"
        XCTAssertNoThrow(
            try regexMatch(echoResponse.algoliaAgent, against: pattern),
            "Expected " + echoResponse.algoliaAgent + " to match the following regex: " + pattern
        )
    }

    /// uses the correct region
    func testParametersTest0() async throws {
        let configuration = try IngestionClientConfiguration(
            appID: "my-app-id",
            apiKey: "my-api-key",
            region: Region(rawValue: "us")
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)
        let response = try await client.getSourceWithHTTPInfo(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")

        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("data.us.algolia.com", echoResponse.host)
    }

    /// throws when incorrect region is given
    func testParametersTest1() async throws {
        do {
            let configuration = try IngestionClientConfiguration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "not_a_region")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = IngestionClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` is required and must be one of the following: eu, us")
        }
    }

    /// switch API key
    func testSetClientApiKeyTest0() async throws {
        let configuration = try IngestionClientConfiguration(
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
        let client = IngestionClient(configuration: configuration, transporter: transporter)
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

import XCTest

import Utils

@testable import Core
@testable import Search

final class SearchClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct read host
    func testApiTest0() async throws {
        let configuration = try SearchClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }

    /// calls api with correct write host
    func testApiTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id.algolia.net", echoResponse.host)
    }

    /// tests the retry strategy
    func testApiTest2() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [
                RetryableHost(url: URL(string: "http://localhost:6677")!),
                RetryableHost(url: URL(string: "http://localhost:6678")!),
            ]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(
            path: "/test/retry"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)
        let comparableData = "{\"message\":\"ok test server response\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(comparableJSON, responseBodyJSON)
    }

    /// test the compression strategy
    func testApiTest3() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(string: "http://localhost:6678")!)],
            compression: .gzip
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customPostWithHTTPInfo(
            path: "/test/gzip",
            parameters: [:],
            body: ["message": "this is a compressed body"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)
        let comparableData =
            "{\"message\":\"ok compression test server response\",\"body\":{\"message\":\"this is a compressed body\"}}"
                .data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(comparableJSON, responseBodyJSON)
    }

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
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
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest2() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// client throws with invalid parameters
    func testParametersTest0() async throws {
        do {
            let configuration = try SearchClientConfiguration(appID: "", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try SearchClientConfiguration(appID: "", apiKey: "my-api-key")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try SearchClientConfiguration(appID: "my-app-id", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`apiKey` is missing.")
        }
    }

    /// &#x60;addApiKey&#x60; throws with invalid parameters
    func testParametersTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
    }

    /// &#x60;addOrUpdateObject&#x60; throws with invalid parameters
    func testParametersTest2() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        do {
            let response = try await client.addOrUpdateObjectWithHTTPInfo(
                indexName: TestNullString(),
                objectID: "my-object-id",
                body: [:]
            )
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(
                error.localizedDescription,
                "Parameter `indexName` is required when calling `addOrUpdateObject`."
            )
        }
        do {
            let response = try await client.addOrUpdateObjectWithHTTPInfo(
                indexName: "my-index-name",
                objectID: TestNullString(),
                body: [:]
            )
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(
                error.localizedDescription,
                "Parameter `objectID` is required when calling `addOrUpdateObject`."
            )
        }
        do {
            let response = try await client.addOrUpdateObjectWithHTTPInfo(
                indexName: "my-index-name",
                objectID: "my-object-id",
                body: TestNullObject()
            )
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "Parameter `body` is required when calling `addOrUpdateObject`.")
        }
    }
}

import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import DotEnv
import Utils

@testable import Analytics
@testable import Core

final class AnalyticsClientRequestsTests: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var e2eClient: AnalyticsClient?

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

        self.e2eClient = try? AnalyticsClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY, region: .us)
    }

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(
            path: "/test/minimal"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with all parameters
    func testCustomDeleteTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(
            path: "/test/all",
            parameters: [
                "query": AnyCodable("parameters"),
            ]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// allow get method for a custom path with minimal parameters
    func testCustomGetTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test/minimal"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow get method for a custom path with all parameters
    func testCustomGetTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test/all",
            parameters: [
                "query": AnyCodable("parameters with space"),
            ]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters%20with%20space\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions should be escaped too
    func testCustomGetTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-header-1": "spaces are left alone",
            ],

            queryParameters: [
                "query": "parameters with space",
                "and an array": ["array",
                                 "with spaces",
                ],
            ]
        )

        let response = try await client.customGetWithHTTPInfo(
            path: "/test/all",
            parameters: [
                "query": AnyCodable("to be overriden"),
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-header-1\":\"spaces are left alone\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// allow post method for a custom path with minimal parameters
    func testCustomPostTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/minimal"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow post method for a custom path with all parameters
    func testCustomPostTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/all",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "body": "parameters",
            ]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions can override default query parameters
    func testCustomPostTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "query": "myQueryParameter",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"myQueryParameter\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions merges query parameters with default ones
    func testCustomPostTest3() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "query2": "myQueryParameter",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions can override default headers
    func testCustomPostTest4() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// requestOptions merges headers with default ones
    func testCustomPostTest5() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// requestOptions queryParameters accepts booleans
    func testCustomPostTest6() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "isItWorking": true,
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"isItWorking\":\"true\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts integers
    func testCustomPostTest7() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "myParam": 2,
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"2\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of string
    func testCustomPostTest8() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "myParam": ["b and c",
                            "d",
                ],
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of booleans
    func testCustomPostTest9() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "myParam": [true,
                            true,
                            false,
                ],
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of integers
    func testCustomPostTest10() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "myParam": [1,
                            2,
                ],
            ]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "facet": "filters",
            ],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// allow put method for a custom path with minimal parameters
    func testCustomPutTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(
            path: "/test/minimal"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow put method for a custom path with all parameters
    func testCustomPutTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(
            path: "/test/all",
            parameters: [
                "query": AnyCodable("parameters"),
            ],
            body: [
                "body": "parameters",
            ]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getAverageClickPosition with minimal parameters
    func testGetAverageClickPositionTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAverageClickPositionWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/averageClickPosition")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getAverageClickPosition with all parameters
    func testGetAverageClickPositionTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAverageClickPositionWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/averageClickPosition")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getClickPositions with minimal parameters
    func testGetClickPositionsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickPositionsWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/positions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getClickPositions with all parameters
    func testGetClickPositionsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickPositionsWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/positions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getClickThroughRate with minimal parameters
    func testGetClickThroughRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickThroughRateWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/clickThroughRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getClickThroughRate with all parameters
    func testGetClickThroughRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickThroughRateWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/clickThroughRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getConversationRate with minimal parameters
    func testGetConversationRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConversationRateWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/conversions/conversionRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getConversationRate with all parameters
    func testGetConversationRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConversationRateWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/conversions/conversionRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getNoClickRate with minimal parameters
    func testGetNoClickRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoClickRateWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClickRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getNoClickRate with all parameters
    func testGetNoClickRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoClickRateWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClickRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getNoResultsRate with minimal parameters
    func testGetNoResultsRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoResultsRateWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResultRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getNoResultsRate with all parameters
    func testGetNoResultsRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoResultsRateWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResultRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesCount with minimal parameters
    func testGetSearchesCountTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesCountWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesCount with all parameters
    func testGetSearchesCountTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesCountWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesNoClicks with minimal parameters
    func testGetSearchesNoClicksTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoClicksWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClicks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesNoClicks with all parameters
    func testGetSearchesNoClicksTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoClicksWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClicks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesNoResults with minimal parameters
    func testGetSearchesNoResultsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoResultsWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getSearchesNoResults with all parameters
    func testGetSearchesNoResultsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoResultsWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getStatus with minimal parameters
    func testGetStatusTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getStatusWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/status")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopCountries with minimal parameters
    func testGetTopCountriesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopCountriesWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/countries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopCountries with all parameters
    func testGetTopCountriesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopCountriesWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/countries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterAttributes with minimal parameters
    func testGetTopFilterAttributesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterAttributesWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterAttributes with all parameters
    func testGetTopFilterAttributesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterAttributesWithHTTPInfo(
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterForAttribute with minimal parameters
    func testGetTopFilterForAttributeTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(
            attribute: "myAttribute",
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterForAttribute with minimal parameters and multiple attributes
    func testGetTopFilterForAttributeTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(
            attribute: "myAttribute1,myAttribute2",
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute1%2CmyAttribute2")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterForAttribute with all parameters
    func testGetTopFilterForAttributeTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(
            attribute: "myAttribute",
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFilterForAttribute with all parameters and multiple attributes
    func testGetTopFilterForAttributeTest3() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(
            attribute: "myAttribute1,myAttribute2",
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute1%2CmyAttribute2")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFiltersNoResults with minimal parameters
    func testGetTopFiltersNoResultsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFiltersNoResultsWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopFiltersNoResults with all parameters
    func testGetTopFiltersNoResultsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFiltersNoResultsWithHTTPInfo(
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopHits with minimal parameters
    func testGetTopHitsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopHitsWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/hits")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopHits with all parameters
    func testGetTopHitsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopHitsWithHTTPInfo(
            index: "index",
            search: "mySearch",
            clickAnalytics: true,
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/hits")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"search\":\"mySearch\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopSearches with minimal parameters
    func testGetTopSearchesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopSearchesWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getTopSearches with all parameters
    func testGetTopSearchesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopSearchesWithHTTPInfo(
            index: "index",
            clickAnalytics: true,
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            orderBy: OrderBy.searchCount,
            direction: Direction.asc,
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"orderBy\":\"searchCount\",\"direction\":\"asc\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// e2e with complex query params
    func testGetTopSearchesTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopSearchesWithHTTPInfo(
            index: "cts_e2e_space in index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"cts_e2e_space%20in%20index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        guard let e2eClient = AnalyticsClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.getTopSearchesWithHTTPInfo(
            index: "cts_e2e_space in index"
        )
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData = try XCTUnwrap(
            "{\"searches\":[{\"search\":\"\",\"nbHits\":0}]}"
                .data(using: .utf8)
        )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// get getUsersCount with minimal parameters
    func testGetUsersCountTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUsersCountWithHTTPInfo(
            index: "index"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/users/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// get getUsersCount with all parameters
    func testGetUsersCountTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(
            appID: AnalyticsClientRequestsTests.APPLICATION_ID,
            apiKey: AnalyticsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUsersCountWithHTTPInfo(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/users/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }
}

import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Utils

@testable import Core
@testable import Insights

// MARK: - InsightsClientRequestsTests

final class InsightsClientRequestsTests: XCTestCase {
    static let APPLICATION_ID = "my_application_id"
    static let API_KEY = "my_api_key"

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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

    /// allow post method for a custom path with minimal parameters
    func testCustomPostTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: [
                "myParam": ["c",
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
            "{\"query\":\"parameters\",\"myParam\":\"c%2Cd\"}"
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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

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

    /// deleteUserToken0
    func testDeleteUserTokenTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteUserTokenWithHTTPInfo(
            userToken: "test-user-1"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/usertokens/test-user-1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// pushEvents0
    func testPushEventsTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .pushEventsWithHTTPInfo(
                insightsEvents: InsightsEvents(
                    events: [
                        EventsItems
                            .clickedObjectIDsAfterSearch(
                                ClickedObjectIDsAfterSearch(
                                    eventName: "Product Clicked",
                                    eventType: ClickEvent.click,
                                    index: "products",
                                    objectIDs: [
                                        "9780545139700",
                                        "9780439784542",
                                    ],
                                    positions: [
                                        7,
                                        6,
                                    ],
                                    queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                                    userToken: "user-123456",
                                    authenticatedUserToken: "user-123456",
                                    timestamp: Int64(1_641_290_601_962)
                                )
                            ),
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"events\":[{\"eventType\":\"click\",\"eventName\":\"Product Clicked\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"positions\":[7,6]}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// Many events type
    func testPushEventsTest1() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(
            insightsEvents: InsightsEvents(
                events: [
                    EventsItems.convertedObjectIDsAfterSearch(
                        ConvertedObjectIDsAfterSearch(
                            eventName: "Product Purchased",
                            eventType: ConversionEvent.conversion,
                            index: "products",
                            objectIDs: [
                                "9780545139700",
                                "9780439784542",
                            ],
                            queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                            userToken: "user-123456",
                            authenticatedUserToken: "user-123456",
                            timestamp: Int64(1_641_290_601_962)
                        )
                    ),
                    EventsItems.viewedObjectIDs(
                        ViewedObjectIDs(
                            eventName: "Product Detail Page Viewed",
                            eventType: ViewEvent.view,
                            index: "products",
                            objectIDs: [
                                "9780545139700",
                                "9780439784542",
                            ],
                            userToken: "user-123456",
                            authenticatedUserToken: "user-123456",
                            timestamp: Int64(1_641_290_601_962)
                        )
                    ),
                ]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"},{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// ConvertedObjectIDsAfterSearch
    func testPushEventsTest2() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .pushEventsWithHTTPInfo(
                insightsEvents: InsightsEvents(
                    events: [
                        EventsItems
                            .convertedObjectIDsAfterSearch(
                                ConvertedObjectIDsAfterSearch(
                                    eventName: "Product Purchased",
                                    eventType: ConversionEvent.conversion,
                                    index: "products",
                                    objectIDs: [
                                        "9780545139700",
                                        "9780439784542",
                                    ],
                                    queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                                    userToken: "user-123456",
                                    authenticatedUserToken: "user-123456",
                                    timestamp: Int64(1_641_290_601_962)
                                )
                            ),
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// ViewedObjectIDs
    func testPushEventsTest3() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .pushEventsWithHTTPInfo(
                insightsEvents: InsightsEvents(
                    events: [EventsItems.viewedObjectIDs(
                        ViewedObjectIDs(
                            eventName: "Product Detail Page Viewed",
                            eventType: ViewEvent.view,
                            index: "products",
                            objectIDs: [
                                "9780545139700",
                                "9780439784542",
                            ],
                            userToken: "user-123456",
                            authenticatedUserToken: "user-123456",
                            timestamp: Int64(1_641_290_601_962)
                        )
                    )]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"events\":[{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// AddedToCartObjectIDs
    func testPushEventsTest4() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(
            appID: InsightsClientRequestsTests.APPLICATION_ID,
            apiKey: InsightsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .pushEventsWithHTTPInfo(
                insightsEvents: InsightsEvents(
                    events: [
                        EventsItems
                            .addedToCartObjectIDsAfterSearch(
                                AddedToCartObjectIDsAfterSearch(
                                    eventName: "Product Added To Cart",
                                    eventType: ConversionEvent.conversion,
                                    eventSubtype: AddToCartEvent.addToCart,
                                    index: "products",
                                    queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                                    objectIDs: [
                                        "9780545139700",
                                        "9780439784542",
                                    ],
                                    userToken: "user-123456",
                                    authenticatedUserToken: "user-123456",
                                    currency: "USD",
                                    objectData: [
                                        ObjectDataAfterSearch(
                                            price: Price.double(
                                                19.99
                                            ),
                                            quantity: 10,
                                            discount: Discount.double(
                                                2.5
                                            )
                                        ),
                                        ObjectDataAfterSearch(
                                            price: Price.string(
                                                "8$"
                                            ),
                                            quantity: 7,
                                            discount: Discount.string(
                                                "30%"
                                            )
                                        ),
                                    ],
                                    timestamp: Int64(1_641_290_601_962)
                                )
                            ),
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"events\":[{\"eventType\":\"conversion\",\"eventSubtype\":\"addToCart\",\"eventName\":\"Product Added To Cart\",\"index\":\"products\",\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"objectData\":[{\"price\":19.99,\"quantity\":10,\"discount\":2.5},{\"price\":\"8$\",\"quantity\":7,\"discount\":\"30%\"}],\"currency\":\"USD\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }
}

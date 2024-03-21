import XCTest

import Utils

@testable import Core
@testable import Recommend

final class RecommendClientRequestsTests: XCTestCase {
    static let APPLICATION_ID = "my_application_id"
    static let API_KEY = "my_api_key"

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with all parameters
    func testCustomDeleteTest1() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/test/all")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow get method for a custom path with all parameters
    func testCustomGetTest1() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/test/all")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-header-1": "spaces are left alone"],

            queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
        )

        let response = try await client.customGetWithHTTPInfo(
            path: "test/all",
            parameters: ["query": AnyCodable("to be overriden")],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/test/all")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow post method for a custom path with all parameters
    func testCustomPostTest1() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/all")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["query": "myQueryParameter"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["query2": "myQueryParameter"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-algolia-api-key": "myApiKey"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-algolia-api-key": "myApiKey"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["isItWorking": true]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": 2]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": ["b and c", "d"]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": [true, true, false]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": [1, 2]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/requestOptions")
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
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow put method for a custom path with all parameters
    func testCustomPutTest1() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// deleteRecommendRule0
    func testDeleteRecommendRuleTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteRecommendRuleWithHTTPInfo(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/related-products/recommend/rules/objectID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getRecommendRule0
    func testGetRecommendRuleTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.getRecommendRuleWithHTTPInfo(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/related-products/recommend/rules/objectID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getRecommendStatus0
    func testGetRecommendStatusTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.getRecommendStatusWithHTTPInfo(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            taskID: Int64(12345)
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/related-products/task/12345")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get recommendations for recommend model with minimal parameters
    func testGetRecommendationsTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .recommendationsQuery(RecommendationsQuery(
                            indexName: "indexName",
                            threshold: 42,
                            model: RecommendationModels.relatedProducts,
                            objectID: "objectID"
                        )),
                ])
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get recommendations for recommend model with all parameters
    func testGetRecommendationsTest1() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .recommendationsQuery(RecommendationsQuery(
                            indexName: "indexName",
                            threshold: 42,
                            maxRecommendations: 10,
                            model: RecommendationModels.relatedProducts,
                            objectID: "objectID",
                            queryParameters: RecommendSearchParamsObject(
                                query: "myQuery",
                                facetFilters: RecommendFacetFilters
                                    .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("query")])
                            ),
                            fallbackParameters: RecommendSearchParamsObject(
                                query: "myQuery",
                                facetFilters: RecommendFacetFilters
                                    .arrayOfRecommendMixedSearchFilters([
                                        RecommendMixedSearchFilters
                                            .string("fallback"),
                                    ])
                            )
                        )),
                ])
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get recommendations for trending model with minimal parameters
    func testGetRecommendationsTest2() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .trendingItemsQuery(TrendingItemsQuery(
                            indexName: "indexName",
                            threshold: 42,
                            model: TrendingItemsModel.trendingItems
                        )),
                ])
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get recommendations for trending model with all parameters
    func testGetRecommendationsTest3() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .trendingItemsQuery(TrendingItemsQuery(
                            indexName: "indexName",
                            threshold: 42,
                            maxRecommendations: 10,
                            facetName: "myFacetName",
                            facetValue: "myFacetValue",
                            model: TrendingItemsModel.trendingItems,
                            queryParameters: RecommendSearchParamsObject(
                                query: "myQuery",
                                facetFilters: RecommendFacetFilters
                                    .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("query")])
                            ),
                            fallbackParameters: RecommendSearchParamsObject(
                                query: "myQuery",
                                facetFilters: RecommendFacetFilters
                                    .arrayOfRecommendMixedSearchFilters([
                                        RecommendMixedSearchFilters
                                            .string("fallback"),
                                    ])
                            )
                        )),
                ])
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get multiple recommendations with minimal parameters
    func testGetRecommendationsTest4() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest.recommendationsQuery(RecommendationsQuery(
                    indexName: "indexName1",
                    threshold: 21,
                    model: RecommendationModels.relatedProducts,
                    objectID: "objectID1"
                )),
                RecommendationsRequest.recommendationsQuery(RecommendationsQuery(
                    indexName: "indexName2",
                    threshold: 21,
                    model: RecommendationModels.relatedProducts,
                    objectID: "objectID2"
                )),
            ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get multiple recommendations with all parameters
    func testGetRecommendationsTest5() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest.recommendationsQuery(RecommendationsQuery(
                    indexName: "indexName1",
                    threshold: 21,
                    maxRecommendations: 10,
                    model: RecommendationModels.relatedProducts,
                    objectID: "objectID1",
                    queryParameters: RecommendSearchParamsObject(
                        query: "myQuery",
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("query1")])
                    ),
                    fallbackParameters: RecommendSearchParamsObject(
                        query: "myQuery",
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("fallback1")])
                    )
                )),
                RecommendationsRequest.recommendationsQuery(RecommendationsQuery(
                    indexName: "indexName2",
                    threshold: 21,
                    maxRecommendations: 10,
                    model: RecommendationModels.relatedProducts,
                    objectID: "objectID2",
                    queryParameters: RecommendSearchParamsObject(
                        query: "myQuery",
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("query2")])
                    ),
                    fallbackParameters: RecommendSearchParamsObject(
                        query: "myQuery",
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendMixedSearchFilters([RecommendMixedSearchFilters.string("fallback2")])
                    )
                )),
            ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get frequently bought together recommendations
    func testGetRecommendationsTest6() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .recommendationsQuery(RecommendationsQuery(
                            indexName: "indexName1",
                            threshold: 42,
                            model: RecommendationModels.boughtTogether,
                            objectID: "objectID1"
                        )),
                ])
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/recommendations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchRecommendRules0
    func testSearchRecommendRulesTest0() async throws {
        let configuration = try RecommendClientConfiguration(
            appID: RecommendClientRequestsTests.APPLICATION_ID,
            apiKey: RecommendClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = RecommendClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchRecommendRulesWithHTTPInfo(
            indexName: "indexName",
            model: RecommendModels.relatedProducts
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/related-products/recommend/rules/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }
}

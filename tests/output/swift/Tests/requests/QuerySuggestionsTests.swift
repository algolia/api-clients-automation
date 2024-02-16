import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import DotEnv
import Utils

@testable import Core
@testable import QuerySuggestions

final class QuerySuggestionsClientRequestsTests: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var e2eClient: QuerySuggestionsClient?

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

        self.e2eClient = try? QuerySuggestionsClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY, region: .us)
    }

    /// createConfig0
    func testCreateConfigTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .createConfigWithHTTPInfo(
                querySuggestionsConfigurationWithIndex: QuerySuggestionsConfigurationWithIndex(
                    indexName: "theIndexName",
                    sourceIndices: [
                        SourceIndex(
                            indexName: "testIndex",
                            facets: [
                                Facet(
                                    attribute: "test"
                                ),
                            ],
                            generate: [
                                [
                                    "facetA",
                                    "facetB",
                                ],
                                [
                                    "facetC",
                                ],
                            ]
                        ),
                    ],
                    languages: Languages.arrayOfString(
                        [
                            "french",
                        ]
                    ),
                    exclude: [
                        "test",
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"indexName\":\"theIndexName\",\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attribute\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/configs")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

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

    /// deleteConfig0
    func testDeleteConfigTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteConfigWithHTTPInfo(
            indexName: "theIndexName"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/configs/theIndexName")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getAllConfigs0
    func testGetAllConfigsTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAllConfigsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/configs")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// Retrieve QS config e2e
    func testGetConfigTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConfigWithHTTPInfo(
            indexName: "cts_e2e_browse_query_suggestions"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/configs/cts_e2e_browse_query_suggestions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = QuerySuggestionsClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.getConfigWithHTTPInfo(
            indexName: "cts_e2e_browse_query_suggestions"
        )
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"allowSpecialCharacters\":true,\"enablePersonalization\":false,\"exclude\":[\"^cocaines$\"],\"indexName\":\"cts_e2e_browse_query_suggestions\",\"languages\":[],\"sourceIndices\":[{\"facets\":[{\"amount\":1,\"attribute\":\"title\"}],\"generate\":[[\"year\"]],\"indexName\":\"cts_e2e_browse\",\"minHits\":5,\"minLetters\":4,\"replicas\":false}]}"
                    .data(using: .utf8)
            )

        try XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// getConfigStatus0
    func testGetConfigStatusTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConfigStatusWithHTTPInfo(
            indexName: "theIndexName"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/configs/theIndexName/status")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getLogFile0
    func testGetLogFileTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getLogFileWithHTTPInfo(
            indexName: "theIndexName"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/logs/theIndexName")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateConfig0
    func testUpdateConfigTest0() async throws {
        let configuration: QuerySuggestions.Configuration = try QuerySuggestions.Configuration(
            appID: QuerySuggestionsClientRequestsTests.APPLICATION_ID,
            apiKey: QuerySuggestionsClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = QuerySuggestionsClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateConfigWithHTTPInfo(
            indexName: "theIndexName",
            querySuggestionsConfiguration: QuerySuggestionsConfiguration(
                sourceIndices: [
                    SourceIndex(
                        indexName: "testIndex",
                        facets: [
                            Facet(
                                attribute: "test"
                            ),
                        ],
                        generate: [
                            [
                                "facetA",
                                "facetB",
                            ],
                            [
                                "facetC",
                            ],
                        ]
                    ),
                ],
                languages: Languages.arrayOfString(
                    [
                        "french",
                    ]
                ),
                exclude: [
                    "test",
                ]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"sourceIndices\":[{\"indexName\":\"testIndex\",\"facets\":[{\"attribute\":\"test\"}],\"generate\":[[\"facetA\",\"facetB\"],[\"facetC\"]]}],\"languages\":[\"french\"],\"exclude\":[\"test\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/configs/theIndexName")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }
}

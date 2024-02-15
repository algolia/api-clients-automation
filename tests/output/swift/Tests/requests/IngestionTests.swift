import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Utils

@testable import Core
@testable import Ingestion

// MARK: - IngestionClientRequestsTests

final class IngestionClientRequestsTests: XCTestCase {
    static let APPLICATION_ID = "my_application_id"
    static let API_KEY = "my_api_key"

    /// createAuthenticationOAuth
    func testCreateAuthenticationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createAuthenticationWithHTTPInfo(
            authenticationCreate: AuthenticationCreate(
                type: AuthenticationType.oauth,
                name: "authName",
                input: AuthInput.authOAuth(
                    AuthOAuth(
                        url: "http://test.oauth",
                        clientId: "myID",
                        clientSecret: "mySecret"
                    )
                )
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"type\":\"oauth\",\"name\":\"authName\",\"input\":{\"url\":\"http://test.oauth\",\"client_id\":\"myID\",\"client_secret\":\"mySecret\"}}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/authentications")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createAuthenticationAlgolia
    func testCreateAuthenticationTest1() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createAuthenticationWithHTTPInfo(
            authenticationCreate: AuthenticationCreate(
                type: AuthenticationType.algolia,
                name: "authName",
                input: AuthInput.authAlgolia(
                    AuthAlgolia(
                        appID: "myappID",
                        apiKey: "randomApiKey"
                    )
                )
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"type\":\"algolia\",\"name\":\"authName\",\"input\":{\"appID\":\"myappID\",\"apiKey\":\"randomApiKey\"}}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/authentications")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createDestination
    func testCreateDestinationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createDestinationWithHTTPInfo(
            destinationCreate: DestinationCreate(
                type: DestinationType.search,
                name: "destinationName",
                input: DestinationInput.destinationIndexPrefix(
                    DestinationIndexPrefix(
                        indexPrefix: "prefix_"
                    )
                ),
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"type\":\"search\",\"name\":\"destinationName\",\"input\":{\"indexPrefix\":\"prefix_\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/destinations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createSource
    func testCreateSourceTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createSourceWithHTTPInfo(
            sourceCreate: SourceCreate(
                type: SourceType.commercetools,
                name: "sourceName",
                input: SourceInput.sourceCommercetools(
                    SourceCommercetools(
                        storeKeys: [
                            "myStore",
                        ],
                        locales: [
                            "de",
                        ],
                        url: "http://commercetools.com",
                        projectKey: "keyID"
                    )
                ),
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"type\":\"commercetools\",\"name\":\"sourceName\",\"input\":{\"storeKeys\":[\"myStore\"],\"locales\":[\"de\"],\"url\":\"http://commercetools.com\",\"projectKey\":\"keyID\"},\"authenticationID\":\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/sources")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createTaskOnDemand
    func testCreateTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createTaskWithHTTPInfo(
            taskCreate: TaskCreate(
                sourceID: "search",
                destinationID: "destinationName",
                trigger: TaskCreateTrigger.onDemandTriggerInput(
                    OnDemandTriggerInput(
                        type: OnDemandTriggerType.onDemand
                    )
                ),
                action: ActionType.replace
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/tasks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createTaskSchedule
    func testCreateTaskTest1() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createTaskWithHTTPInfo(
            taskCreate: TaskCreate(
                sourceID: "search",
                destinationID: "destinationName",
                trigger: TaskCreateTrigger.scheduleTriggerInput(
                    ScheduleTriggerInput(
                        type: ScheduleTriggerType.schedule,
                        cron: "* * * * *"
                    )
                ),
                action: ActionType.replace
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"schedule\",\"cron\":\"* * * * *\"},\"action\":\"replace\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/tasks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// createTaskSubscription
    func testCreateTaskTest2() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.createTaskWithHTTPInfo(
            taskCreate: TaskCreate(
                sourceID: "search",
                destinationID: "destinationName",
                trigger: TaskCreateTrigger.onDemandTriggerInput(
                    OnDemandTriggerInput(
                        type: OnDemandTriggerType.onDemand
                    )
                ),
                action: ActionType.replace
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"sourceID\":\"search\",\"destinationID\":\"destinationName\",\"trigger\":{\"type\":\"onDemand\"},\"action\":\"replace\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/tasks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

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

    /// deleteAuthentication
    func testDeleteAuthenticationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .deleteAuthenticationWithHTTPInfo(
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteDestination
    func testDeleteDestinationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .deleteDestinationWithHTTPInfo(
                destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteSource
    func testDeleteSourceTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteSourceWithHTTPInfo(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteTask
    func testDeleteTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// disableTask
    func testDisableTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.disableTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// enableTask
    func testEnableTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.enableTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/enable")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getAuthentication
    func testGetAuthenticationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getAuthenticationWithHTTPInfo(
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getAuthentications
    func testGetAuthenticationsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAuthenticationsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/authentications")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getAuthentications with query params
    func testGetAuthenticationsTest1() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAuthenticationsWithHTTPInfo(
            itemsPerPage: 10,
            page: 5,
            type: [
                AuthenticationType.basic,
                AuthenticationType.algolia,
            ],
            platform: [PlatformWithNone.platformNone(
                PlatformNone.`none`
            )],
            sort: AuthenticationSortKeys.createdAt,
            order: OrderKeys.desc
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/authentications")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"itemsPerPage\":\"10\",\"page\":\"5\",\"type\":\"basic%2Calgolia\",\"platform\":\"none\",\"sort\":\"createdAt\",\"order\":\"desc\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// getDestination
    func testGetDestinationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getDestinationWithHTTPInfo(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getDestinations
    func testGetDestinationsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getDestinationsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/destinations")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getDockerSourceStreams
    func testGetDockerSourceStreamsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getDockerSourceStreamsWithHTTPInfo(
                sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getEvent
    func testGetEventTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getEventWithHTTPInfo(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            eventID: "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(
            echoResponse.path,
            "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c"
        )
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getEvents
    func testGetEventsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getEventsWithHTTPInfo(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getRun
    func testGetRunTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getRunWithHTTPInfo(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getRuns
    func testGetRunsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getRunsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/runs")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getSource
    func testGetSourceTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSourceWithHTTPInfo(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getSources
    func testGetSourcesTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSourcesWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/sources")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getTask
    func testGetTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getTasks
    func testGetTasksTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTasksWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/tasks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// runTask
    func testRunTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.runTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchAuthentications
    func testSearchAuthenticationsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .searchAuthenticationsWithHTTPInfo(
                authenticationSearch: AuthenticationSearch(
                    authenticationIDs: [
                        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                        "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"authenticationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/authentications/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchDestinations
    func testSearchDestinationsTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .searchDestinationsWithHTTPInfo(
                destinationSearch: DestinationSearch(
                    destinationIDs: [
                        "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                        "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                    ]
                )
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"destinationIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/destinations/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchSources
    func testSearchSourcesTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSourcesWithHTTPInfo(
            sourceSearch: SourceSearch(
                sourceIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"sourceIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/sources/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchTasks
    func testSearchTasksTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchTasksWithHTTPInfo(
            taskSearch: TaskSearch(
                taskIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"taskIDs\":[\"6c02aeb1-775e-418e-870b-1faccd4b2c0f\",\"947ac9c4-7e58-4c87-b1e7-14a68e99699a\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/tasks/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// triggerDockerSourceDiscover
    func testTriggerDockerSourceDiscoverTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .triggerDockerSourceDiscoverWithHTTPInfo(
                sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateAuthentication
    func testUpdateAuthenticationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateAuthenticationWithHTTPInfo(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            authenticationUpdate: AuthenticationUpdate(
                name: "newName"
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"name\":\"newName\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.patch)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateDestination
    func testUpdateDestinationTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateDestinationWithHTTPInfo(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            destinationUpdate: DestinationUpdate(
                name: "newName"
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"name\":\"newName\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.patch)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateSource
    func testUpdateSourceTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateSourceWithHTTPInfo(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(
                name: "newName"
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"name\":\"newName\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.patch)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateTask
    func testUpdateTaskTest0() async throws {
        let configuration: Ingestion.Configuration = try Ingestion.Configuration(
            appID: IngestionClientRequestsTests.APPLICATION_ID,
            apiKey: IngestionClientRequestsTests.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = IngestionClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateTaskWithHTTPInfo(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdate(
                enabled: false
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"enabled\":false}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        XCTAssertEqual(echoResponse.method, HTTPMethod.patch)

        XCTAssertNil(echoResponse.queryParameters)
    }
}

import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Utils

@testable import Analytics
@testable import Core

final class AnalyticsClientRequestsTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /**
     allow del method for a custom path with minimal parameters
     */
    func testCustomDeleteTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "/test/minimal",
                                                                 requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow del method for a custom path with all parameters
     */
    func testCustomDeleteTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "/test/all",
                                                                 parameters: ["query": AnyCodable("parameters")],
                                                                 requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     allow get method for a custom path with minimal parameters
     */
    func testCustomGetTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "/test/minimal",
                                                              requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow get method for a custom path with all parameters
     */
    func testCustomGetTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "/test/all",
                                                              parameters: ["query": AnyCodable("parameters with space")],
                                                              requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters%20with%20space\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     allow post method for a custom path with minimal parameters
     */
    func testCustomPostTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/minimal",
                                                               requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow post method for a custom path with all parameters
     */
    func testCustomPostTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/all",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["body": "parameters"],
                                                               requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions can override default query parameters
     */
    func testCustomPostTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query": "myQueryParameter",

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"myQueryParameter\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions merges query parameters with default ones
     */
    func testCustomPostTest3() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query2": "myQueryParameter",

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions can override default headers
     */
    func testCustomPostTest4() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)

        let comparableHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let comparableHeadersMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in comparableHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /**
     requestOptions merges headers with default ones
     */
    func testCustomPostTest5() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)

        let comparableHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let comparableHeadersMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in comparableHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /**
     requestOptions queryParameters accepts booleans
     */
    func testCustomPostTest6() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "isItWorking": true,

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"isItWorking\":\"true\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts integers
     */
    func testCustomPostTest7() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": 2,

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"2\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts list of string
     */
    func testCustomPostTest8() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": ["c",
                            "d",
                ],

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"c%2Cd\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts list of booleans
     */
    func testCustomPostTest9() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [true,
                            true,
                            false,
                ],

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts list of integers
     */
    func testCustomPostTest10() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [1,
                            2,
                ],

            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions",
                                                               parameters: ["query": AnyCodable("parameters")],
                                                               body: ["facet": "filters"],
                                                               requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     allow put method for a custom path with minimal parameters
     */
    func testCustomPutTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/minimal",
                                                              requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow put method for a custom path with all parameters
     */
    func testCustomPutTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/all",
                                                              parameters: ["query": AnyCodable("parameters")],
                                                              body: ["body": "parameters"],
                                                              requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getAverageClickPosition with minimal parameters
     */
    func testGetAverageClickPositionTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAverageClickPositionWithHTTPInfo(index: "index",
                                                                            requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/averageClickPosition")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getAverageClickPosition with all parameters
     */
    func testGetAverageClickPositionTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getAverageClickPositionWithHTTPInfo(index: "index",
                                                                            startDate: "1999-09-19",
                                                                            endDate: "2001-01-01",
                                                                            tags: "tag",
                                                                            requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/averageClickPosition")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getClickPositions with minimal parameters
     */
    func testGetClickPositionsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickPositionsWithHTTPInfo(index: "index",
                                                                      requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/positions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getClickPositions with all parameters
     */
    func testGetClickPositionsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickPositionsWithHTTPInfo(index: "index",
                                                                      startDate: "1999-09-19",
                                                                      endDate: "2001-01-01",
                                                                      tags: "tag",
                                                                      requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/positions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getClickThroughRate with minimal parameters
     */
    func testGetClickThroughRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickThroughRateWithHTTPInfo(index: "index",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/clickThroughRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getClickThroughRate with all parameters
     */
    func testGetClickThroughRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getClickThroughRateWithHTTPInfo(index: "index",
                                                                        startDate: "1999-09-19",
                                                                        endDate: "2001-01-01",
                                                                        tags: "tag",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/clicks/clickThroughRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getConversationRate with minimal parameters
     */
    func testGetConversationRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConversationRateWithHTTPInfo(index: "index",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/conversions/conversionRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getConversationRate with all parameters
     */
    func testGetConversationRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getConversationRateWithHTTPInfo(index: "index",
                                                                        startDate: "1999-09-19",
                                                                        endDate: "2001-01-01",
                                                                        tags: "tag",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/conversions/conversionRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getNoClickRate with minimal parameters
     */
    func testGetNoClickRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoClickRateWithHTTPInfo(index: "index",
                                                                   requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClickRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getNoClickRate with all parameters
     */
    func testGetNoClickRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoClickRateWithHTTPInfo(index: "index",
                                                                   startDate: "1999-09-19",
                                                                   endDate: "2001-01-01",
                                                                   tags: "tag",
                                                                   requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClickRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getNoResultsRate with minimal parameters
     */
    func testGetNoResultsRateTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoResultsRateWithHTTPInfo(index: "index",
                                                                     requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResultRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getNoResultsRate with all parameters
     */
    func testGetNoResultsRateTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getNoResultsRateWithHTTPInfo(index: "index",
                                                                     startDate: "1999-09-19",
                                                                     endDate: "2001-01-01",
                                                                     tags: "tag",
                                                                     requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResultRate")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesCount with minimal parameters
     */
    func testGetSearchesCountTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesCountWithHTTPInfo(index: "index",
                                                                     requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesCount with all parameters
     */
    func testGetSearchesCountTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesCountWithHTTPInfo(index: "index",
                                                                     startDate: "1999-09-19",
                                                                     endDate: "2001-01-01",
                                                                     tags: "tag",
                                                                     requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesNoClicks with minimal parameters
     */
    func testGetSearchesNoClicksTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoClicksWithHTTPInfo(index: "index",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClicks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesNoClicks with all parameters
     */
    func testGetSearchesNoClicksTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoClicksWithHTTPInfo(index: "index",
                                                                        startDate: "1999-09-19",
                                                                        endDate: "2001-01-01",
                                                                        limit: 21,
                                                                        offset: 42,
                                                                        tags: "tag",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noClicks")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesNoResults with minimal parameters
     */
    func testGetSearchesNoResultsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoResultsWithHTTPInfo(index: "index",
                                                                         requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getSearchesNoResults with all parameters
     */
    func testGetSearchesNoResultsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSearchesNoResultsWithHTTPInfo(index: "index",
                                                                         startDate: "1999-09-19",
                                                                         endDate: "2001-01-01",
                                                                         limit: 21,
                                                                         offset: 42,
                                                                         tags: "tag",
                                                                         requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getStatus with minimal parameters
     */
    func testGetStatusTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getStatusWithHTTPInfo(index: "index",
                                                              requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/status")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopCountries with minimal parameters
     */
    func testGetTopCountriesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopCountriesWithHTTPInfo(index: "index",
                                                                    requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/countries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopCountries with all parameters
     */
    func testGetTopCountriesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopCountriesWithHTTPInfo(index: "index",
                                                                    startDate: "1999-09-19",
                                                                    endDate: "2001-01-01",
                                                                    limit: 21,
                                                                    offset: 42,
                                                                    tags: "tag",
                                                                    requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/countries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterAttributes with minimal parameters
     */
    func testGetTopFilterAttributesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterAttributesWithHTTPInfo(index: "index",
                                                                           requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterAttributes with all parameters
     */
    func testGetTopFilterAttributesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterAttributesWithHTTPInfo(index: "index",
                                                                           search: "mySearch",
                                                                           startDate: "1999-09-19",
                                                                           endDate: "2001-01-01",
                                                                           limit: 21,
                                                                           offset: 42,
                                                                           tags: "tag",
                                                                           requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterForAttribute with minimal parameters
     */
    func testGetTopFilterForAttributeTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(attribute: "myAttribute",
                                                                             index: "index",
                                                                             requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterForAttribute with minimal parameters and multiple attributes
     */
    func testGetTopFilterForAttributeTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(attribute: "myAttribute1,myAttribute2",
                                                                             index: "index",
                                                                             requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute1%2CmyAttribute2")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterForAttribute with all parameters
     */
    func testGetTopFilterForAttributeTest2() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(attribute: "myAttribute",
                                                                             index: "index",
                                                                             search: "mySearch",
                                                                             startDate: "1999-09-19",
                                                                             endDate: "2001-01-01",
                                                                             limit: 21,
                                                                             offset: 42,
                                                                             tags: "tag",
                                                                             requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFilterForAttribute with all parameters and multiple attributes
     */
    func testGetTopFilterForAttributeTest3() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFilterForAttributeWithHTTPInfo(attribute: "myAttribute1,myAttribute2",
                                                                             index: "index",
                                                                             search: "mySearch",
                                                                             startDate: "1999-09-19",
                                                                             endDate: "2001-01-01",
                                                                             limit: 21,
                                                                             offset: 42,
                                                                             tags: "tag",
                                                                             requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/myAttribute1%2CmyAttribute2")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFiltersNoResults with minimal parameters
     */
    func testGetTopFiltersNoResultsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFiltersNoResultsWithHTTPInfo(index: "index",
                                                                           requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopFiltersNoResults with all parameters
     */
    func testGetTopFiltersNoResultsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopFiltersNoResultsWithHTTPInfo(index: "index",
                                                                           search: "mySearch",
                                                                           startDate: "1999-09-19",
                                                                           endDate: "2001-01-01",
                                                                           limit: 21,
                                                                           offset: 42,
                                                                           tags: "tag",
                                                                           requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/filters/noResults")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"search\":\"mySearch\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopHits with minimal parameters
     */
    func testGetTopHitsTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopHitsWithHTTPInfo(index: "index",
                                                               requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/hits")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopHits with all parameters
     */
    func testGetTopHitsTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopHitsWithHTTPInfo(index: "index",
                                                               search: "mySearch",
                                                               clickAnalytics: true,
                                                               startDate: "1999-09-19",
                                                               endDate: "2001-01-01",
                                                               limit: 21,
                                                               offset: 42,
                                                               tags: "tag",
                                                               requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/hits")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"search\":\"mySearch\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopSearches with minimal parameters
     */
    func testGetTopSearchesTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopSearchesWithHTTPInfo(index: "index",
                                                                   requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getTopSearches with all parameters
     */
    func testGetTopSearchesTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopSearchesWithHTTPInfo(index: "index",
                                                                   clickAnalytics: true,
                                                                   startDate: "1999-09-19",
                                                                   endDate: "2001-01-01",
                                                                   orderBy: OrderBy.searchCount,
                                                                   direction: Direction.asc,
                                                                   limit: 21,
                                                                   offset: 42,
                                                                   tags: "tag",
                                                                   requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/searches")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"clickAnalytics\":\"true\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"orderBy\":\"searchCount\",\"direction\":\"asc\",\"limit\":\"21\",\"offset\":\"42\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getUsersCount with minimal parameters
     */
    func testGetUsersCountTest0() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUsersCountWithHTTPInfo(index: "index",
                                                                  requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/users/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     get getUsersCount with all parameters
     */
    func testGetUsersCountTest1() async throws {
        let configuration: Analytics.Configuration = try Analytics.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AnalyticsClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUsersCountWithHTTPInfo(index: "index",
                                                                  startDate: "1999-09-19",
                                                                  endDate: "2001-01-01",
                                                                  tags: "tag",
                                                                  requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/users/count")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"index\":\"index\",\"startDate\":\"1999-09-19\",\"endDate\":\"2001-01-01\",\"tags\":\"tag\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }
}

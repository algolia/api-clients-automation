import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Utils

@testable import Core
@testable import Personalization

final class PersonalizationClientRequestsTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /**
     allow del method for a custom path with minimal parameters
     */
    func testCustomDeleteTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

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
     delete deleteUserProfile
     */
    func testDeleteUserProfileTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteUserProfileWithHTTPInfo(userToken: "UserToken",
                                                                      requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/profiles/UserToken")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     get getPersonalizationStrategy
     */
    func testGetPersonalizationStrategyTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.getPersonalizationStrategyWithHTTPInfo(requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/strategies/personalization")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     get getUserTokenProfile
     */
    func testGetUserTokenProfileTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUserTokenProfileWithHTTPInfo(userToken: "UserToken",
                                                                        requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/profiles/personalization/UserToken")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     set setPersonalizationStrategy
     */
    func testSetPersonalizationStrategyTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.setPersonalizationStrategyWithHTTPInfo(personalizationStrategyParams: PersonalizationStrategyParams(eventScoring: [EventScoring(score: 42,
                                                                                                                                                                        eventName: "Algolia",
                                                                                                                                                                        eventType: "Event")],
                                                                                                                                            facetScoring: [FacetScoring(score: 42,
                                                                                                                                                                        facetName: "Event")],
                                                                                                                                            personalizationImpact: 42),
                                                                               requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"eventScoring\":[{\"score\":42,\"eventName\":\"Algolia\",\"eventType\":\"Event\"}],\"facetScoring\":[{\"score\":42,\"facetName\":\"Event\"}],\"personalizationImpact\":42}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/strategies/personalization")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }
}

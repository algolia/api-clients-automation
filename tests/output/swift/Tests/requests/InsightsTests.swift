import SwiftyJSON
import XCTest
#if canImport(AnyCodable)
    import AnyCodable
#endif

@testable import Core
@testable import Insights

final class InsightsClientRequestsTests: XCTestCase {
    typealias StringMapObject = [String: String?]

    let APPLICATION_ID = ""
    let API_KEY = ""

    /**
     allow del method for a custom path with minimal parameters
     */
    func testCustomDeleteTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], requestOptions: nil)
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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     allow post method for a custom path with minimal parameters
     */
    func testCustomPostTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow post method for a custom path with all parameters
     */
    func testCustomPostTest1() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], body: ["body": "parameters"], requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"body\":\"parameters\"}"
        )

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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query": "myQueryParameter",
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query2": "myQueryParameter",
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
            XCTAssertEqual(echoResponseHeaders[header.key], header.value)
        }
    }

    /**
     requestOptions merges headers with default ones
     */
    func testCustomPostTest5() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
            XCTAssertEqual(echoResponseHeaders[header.key], header.value)
        }
    }

    /**
     requestOptions queryParameters accepts booleans
     */
    func testCustomPostTest6() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "isItWorking": true,
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": 2,
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

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
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": ["c", "d"],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"c,d\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts list of booleans
     */
    func testCustomPostTest9() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [true, true, false],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     requestOptions queryParameters accepts list of integers
     */
    func testCustomPostTest10() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [1, 2],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"facet\":\"filters\"}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\",\"myParam\":\"1,2\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     allow put method for a custom path with minimal parameters
     */
    func testCustomPutTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow put method for a custom path with all parameters
     */
    func testCustomPutTest1() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], body: ["body": "parameters"], requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"body\":\"parameters\"}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let comparableQueryItems = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     deleteUserToken0
     */
    func testDeleteUserTokenTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteUserTokenWithHTTPInfo(userToken: "test-user-1", requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/usertokens/test-user-1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     pushEvents0
     */
    func testPushEventsTest0() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [EventsItems.clickedObjectIDsAfterSearch(ClickedObjectIDsAfterSearch(eventName: "Product Clicked", eventType: ClickEvent.click, index: "products", objectIDs: ["9780545139700", "9780439784542"], positions: [7, 6], queryID: "43b15df305339e827f0ac0bdc5ebcaa7", userToken: "user-123456", authenticatedUserToken: "user-123456", timestamp: Int64(1_641_290_601_962)))]), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"events\":[{\"eventType\":\"click\",\"eventName\":\"Product Clicked\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"positions\":[7,6]}]}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     Many events type
     */
    func testPushEventsTest1() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [EventsItems.convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch(eventName: "Product Purchased", eventType: ConversionEvent.conversion, index: "products", objectIDs: ["9780545139700", "9780439784542"], queryID: "43b15df305339e827f0ac0bdc5ebcaa7", userToken: "user-123456", authenticatedUserToken: "user-123456", timestamp: Int64(1_641_290_601_962))), EventsItems.viewedObjectIDs(ViewedObjectIDs(eventName: "Product Detail Page Viewed", eventType: ViewEvent.view, index: "products", objectIDs: ["9780545139700", "9780439784542"], userToken: "user-123456", authenticatedUserToken: "user-123456", timestamp: Int64(1_641_290_601_962)))]), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"},{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     ConvertedObjectIDsAfterSearch
     */
    func testPushEventsTest2() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [EventsItems.convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch(eventName: "Product Purchased", eventType: ConversionEvent.conversion, index: "products", objectIDs: ["9780545139700", "9780439784542"], queryID: "43b15df305339e827f0ac0bdc5ebcaa7", userToken: "user-123456", authenticatedUserToken: "user-123456", timestamp: Int64(1_641_290_601_962)))]), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"events\":[{\"eventType\":\"conversion\",\"eventName\":\"Product Purchased\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\"}]}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     ViewedObjectIDs
     */
    func testPushEventsTest3() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [EventsItems.viewedObjectIDs(ViewedObjectIDs(eventName: "Product Detail Page Viewed", eventType: ViewEvent.view, index: "products", objectIDs: ["9780545139700", "9780439784542"], userToken: "user-123456", authenticatedUserToken: "user-123456", timestamp: Int64(1_641_290_601_962)))]), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"events\":[{\"eventType\":\"view\",\"eventName\":\"Product Detail Page Viewed\",\"index\":\"products\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"]}]}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     AddedToCartObjectIDs
     */
    func testPushEventsTest4() async throws {
        let configuration: Insights.Configuration = try Insights.Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = InsightsClient(configuration: configuration, transporter: transporter)

        let response = try await client.pushEventsWithHTTPInfo(insightsEvents: InsightsEvents(events: [EventsItems.addedToCartObjectIDsAfterSearch(AddedToCartObjectIDsAfterSearch(eventName: "Product Added To Cart", eventType: ConversionEvent.conversion, eventSubtype: AddToCartEvent.addToCart, index: "products", queryID: "43b15df305339e827f0ac0bdc5ebcaa7", objectIDs: ["9780545139700", "9780439784542"], userToken: "user-123456", authenticatedUserToken: "user-123456", currency: "USD", objectData: [ObjectDataAfterSearch(price: Price.double(19.99), quantity: 10, discount: Discount.double(2.5)), ObjectDataAfterSearch(price: Price.string("8$"), quantity: 7, discount: Discount.string("30%"))], timestamp: Int64(1_641_290_601_962)))]), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try JSON(data: echoResponseBodyData, options: .fragmentsAllowed)

        let comparableJSON = JSON(parseJSON:
            "{\"events\":[{\"eventType\":\"conversion\",\"eventSubtype\":\"addToCart\",\"eventName\":\"Product Added To Cart\",\"index\":\"products\",\"queryID\":\"43b15df305339e827f0ac0bdc5ebcaa7\",\"userToken\":\"user-123456\",\"authenticatedUserToken\":\"user-123456\",\"timestamp\":1641290601962,\"objectIDs\":[\"9780545139700\",\"9780439784542\"],\"objectData\":[{\"price\":19.99,\"quantity\":10,\"discount\":2.5},{\"price\":\"8$\",\"quantity\":7,\"discount\":\"30%\"}],\"currency\":\"USD\"}]}"
        )

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/1/events")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }
}

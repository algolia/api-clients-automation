import XCTest

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Utils

@testable import Abtesting
@testable import Core

final class AbtestingClientRequestsTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /**
     addABTests with minimal parameters
     */
    func testAddABTestsTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.addABTestsWithHTTPInfo(addABTestsRequest: AddABTestsRequest(name: "myABTest", variants: [AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_1", trafficPercentage: 30)), AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_2", trafficPercentage: 50))], endAt: "2022-12-31T00:00:00.000Z"), requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"endAt\":\"2022-12-31T00:00:00.000Z\",\"name\":\"myABTest\",\"variants\":[{\"index\":\"AB_TEST_1\",\"trafficPercentage\":30},{\"index\":\"AB_TEST_2\",\"trafficPercentage\":50}]}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, comparableJSON)

        XCTAssertEqual(echoResponse.path, "/2/abtests")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     allow del method for a custom path with minimal parameters
     */
    func testCustomDeleteTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], body: ["body": "parameters"], requestOptions: nil)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query": "myQueryParameter",
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "query2": "myQueryParameter",
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: [
                "x-algolia-api-key": "myApiKey",
            ]
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "isItWorking": true,
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": 2,
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": ["c", "d"],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [true, true, false],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryItems: APIHelper.mapValuesToQueryItems([
                "myParam": [1, 2],
            ])
        )

        let response = try await client.customPostWithHTTPInfo(path: "/test/requestOptions", parameters: ["query": AnyCodable("parameters")], body: ["facet": "filters"], requestOptions: requestOptions)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let comparableData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)

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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/minimal", requestOptions: nil)
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
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/all", parameters: ["query": AnyCodable("parameters")], body: ["body": "parameters"], requestOptions: nil)
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
     deleteABTest
     */
    func testDeleteABTestTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteABTestWithHTTPInfo(id: 42, requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/abtests/42")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     getABTest
     */
    func testGetABTestTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.getABTestWithHTTPInfo(id: 42, requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/abtests/42")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     listABTests with minimal parameters
     */
    func testListABTestsTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.listABTestsWithHTTPInfo(requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/abtests")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryItems)
    }

    /**
     listABTests with parameters
     */
    func testListABTestsTest1() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.listABTestsWithHTTPInfo(offset: 42, limit: 21, indexPrefix: "foo", indexSuffix: "bar", requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/2/abtests")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let comparableQueryItems = try XCTUnwrap("{\"offset\":\"42\",\"limit\":\"21\",\"indexPrefix\":\"foo\",\"indexSuffix\":\"bar\"}".data(using: .utf8))
        let comparableQueryItemsMap = try CodableHelper.jsonDecoder.decode(StringMapObject.self, from: comparableQueryItems)

        XCTAssertEqual(echoResponse.queryItems, comparableQueryItemsMap)
    }

    /**
     stopABTest
     */
    func testStopABTestTest0() async throws {
        let configuration: Abtesting.Configuration = try Abtesting.Configuration(appId: APPLICATION_ID, apiKey: API_KEY, region: Region.us)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = AbtestingClient(configuration: configuration, transporter: transporter)

        let response = try await client.stopABTestWithHTTPInfo(id: 42, requestOptions: nil)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/2/abtests/42/stop")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryItems)
    }
}

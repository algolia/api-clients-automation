import XCTest

@testable import Core
@testable import Abtesting

let APPLICATION_ID = ""
let API_KEY = ""

final class AlgoliaSearchClientTests: XCTestCase {
    func testListABTests() async throws {
        let statusCode: HTTPStatusСode = 200
        let configuration: Abtesting.Configuration = Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: nil)
        let transporter: Transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder(statusCode: statusCode))
        let client: AbtestingClient = AbtestingClient(configuration: configuration, transporter: transporter)
        
        let response = try await client.listABTestsWithHTTPInfo()
        
        let bodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: bodyData)
        
        XCTAssertEqual(echoResponse.path, "/2/abtests")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)
        XCTAssertNil(echoResponse.originalBodyData)
        
    }

    func testAddABTests() async throws {
        let statusCode: HTTPStatusСode = 200
        let configuration = Configuration(applicationID: APPLICATION_ID, apiKey: API_KEY, region: nil)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder(statusCode: statusCode))
        let client = AbtestingClient(configuration: configuration, transporter: transporter)
        
        let addABTestsRequest = AddABTestsRequest(
            name: "myABTest",
            variants: [
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_1", trafficPercentage: 30)),
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_2", trafficPercentage: 50))
            ],
            endAt: "2022-12-31T00:00:00.000Z"
        )
        let response = try await client.addABTestsWithHTTPInfo(addABTestsRequest: addABTestsRequest)
        
        let bodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: bodyData)
        
        let comparableData = try XCTUnwrap("{\"endAt\":\"2022-12-31T00:00:00.000Z\",\"name\":\"myABTest\",\"variants\":[{\"index\":\"AB_TEST_1\",\"trafficPercentage\":30},{\"index\":\"AB_TEST_2\",\"trafficPercentage\":50}]}".data(using: .utf8))
        let comparableObject = try CodableHelper.jsonDecoder.decode(AddABTestsRequest.self, from: comparableData)
        
        let echoResponseBody = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseObject = try CodableHelper.jsonDecoder.decode(AddABTestsRequest.self, from: echoResponseBody)
        
        XCTAssertEqual(echoResponse.path, "/2/abtests")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)
        XCTAssertEqual(echoResponseObject, comparableObject)
        
    }
}

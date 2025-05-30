// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Composition
@testable import Core

final class CompositionClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct read host
    func testApiTest0() async throws {
        let configuration = try CompositionClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = CompositionClient(configuration: configuration, transporter: transporter)
        let response: Response<CompositionSearchResponse<CompositionHit>> = try await client.searchWithHTTPInfo(
            compositionID: "test-composition-id",
            requestBody: CompositionRequestBody()
        )

        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: XCTUnwrap(response.bodyData))

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }

    /// calls api with correct write host
    func testApiTest1() async throws {
        let configuration = try CompositionClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = CompositionClient(configuration: configuration, transporter: transporter)
        let response: Response<CompositionSearchResponse<CompositionHit>> = try await client.searchWithHTTPInfo(
            compositionID: "test-composition-id",
            requestBody: CompositionRequestBody()
        )

        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: XCTUnwrap(response.bodyData))

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }
}

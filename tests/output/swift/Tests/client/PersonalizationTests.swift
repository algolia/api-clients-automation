import XCTest

import AnyCodable
import Utils

@testable import Core
@testable import Personalization

final class PersonalizationClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(
            appID: self.APPLICATION_ID,
            apiKey: self.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Personalization (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        let rule = StringRule(pattern: pattern)
        let userAgent = try XCTUnwrap(echoResponse.headers?["User-Agent"])
        guard let userAgent else {
            XCTFail("Expected user-agent header")
            return
        }

        XCTAssertNoThrow(
            try Validator.validate(userAgent, against: rule),
            "Expected " + userAgent + " to match the following regex: " + pattern
        )
    }

    /// calls api with default read timeouts
    func testCommonApiTest1() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(
            appID: self.APPLICATION_ID,
            apiKey: self.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest2() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(
            appID: self.APPLICATION_ID,
            apiKey: self.API_KEY,
            region: Region.us
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test"
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// throws when region is not given
    func testParametersTest0() async throws {
        do {
            let configuration: Personalization.Configuration = try Personalization.Configuration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = PersonalizationClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` is required and must be one of the following: eu, us")
        }
    }

    /// throws when incorrect region is given
    func testParametersTest1() async throws {
        do {
            let configuration: Personalization.Configuration = try Personalization.Configuration(
                appID: "my-app-id",
                apiKey: "my-api-key",
                region: Region(rawValue: "not_a_region")
            )
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = PersonalizationClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`region` is required and must be one of the following: eu, us")
        }
    }

    /// does not throw when region is given
    func testParametersTest2() async throws {
        let configuration: Personalization.Configuration = try Personalization.Configuration(
            appID: "my-app-id",
            apiKey: "my-api-key",
            region: Region(rawValue: "us")
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = PersonalizationClient(configuration: configuration, transporter: transporter)
    }
}

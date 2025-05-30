// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import DotEnv
import Utils

@testable import Core
@testable import Recommend

final class RecommendClientRequestsTestsE2E: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var client: RecommendClient?

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

        self.client = try? RecommendClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY)
    }

    /// get recommendations with e2e to check oneOf model
    func testGetRecommendationsTest1() async throws {
        guard let client = RecommendClientRequestsTestsE2E.client else {
            XCTFail("E2E client is not initialized")
            return
        }

        let response = try await client
            .getRecommendationsWithHTTPInfo(
                getRecommendationsParams: GetRecommendationsParams(requests: [
                    RecommendationsRequest
                        .relatedQuery(RelatedQuery(
                            indexName: "cts_e2e_browse",
                            threshold: 20.0,
                            maxRecommendations: 2,
                            model: RelatedModel.relatedProducts,
                            objectID: "Æon Flux"
                        )),
                ])
            )
        try XCTLenientAssertEqual(
            received: XCTUnwrap(response.body),
            expected: "{\"results\":[{\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"index\":\"cts_e2e_browse\",\"page\":0,\"nbHits\":2,\"nbPages\":1,\"hitsPerPage\":2,\"hits\":[{\"objectID\":\"The Transformers: The Movie\",\"_highlightResult\":{\"genres\":[{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Animated\"},{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Action\"},{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Science Fiction\"}],\"href\":{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"The_Transformers:_The_Movie\"}},\"_score\":100.0,\"cast\":[\"Judd Nelson\",\"Leonard Nimoy\",\"Robert Stack\",\"Orson Welles\",\"Michael Bell\",\"Eric Idle\",\"Chris Latta\",\"Peter Cullen\",\"Frank Welker\",\"Neil Ross\",\"Paul Eiding\"],\"extract\":\"The Transformers: The Movie is a 1986 animated science fiction action film based on the Transformers television series. It was released in North America on August 8, 1986, and in the United Kingdom on December 12, 1986. It was co-produced and directed by Nelson Shin, who also produced the television series. The screenplay was written by Ron Friedman, who created Bionic Six a year later.\",\"title\":\"The Transformers: The Movie\",\"year\":1986},{\"objectID\":\"Treasure Planet\",\"_score\":90.56,\"title\":\"Treasure Planet\",\"year\":2002}]}]}"
        )

        XCTAssertEqual(response.statusCode, 200)
    }
}

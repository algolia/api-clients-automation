// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Core
@testable import Search

final class SearchClientClientBenchmark: XCTestCase {
    /// benchmark the search method
    func testBenchmarkTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(string: "http://localhost:6682")!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        for i in 1 ... 1000 {
            let response: Response<SearchResponses<Hit>> = try await client
                .searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
                    SearchQuery
                        .searchForHits(SearchForHits(
                            query: "iphone 15 pro max 512gb",
                            hitsPerPage: 50,
                            indexName: "cts_e2e_benchmark_search_swift"
                        )),
                ]))
        }
    }
}

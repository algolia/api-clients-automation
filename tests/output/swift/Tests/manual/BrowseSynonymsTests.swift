//
//  BrowseSynonymsTests.swift
//  AlgoliaSearchClientTests
//
//  Regression guard for the `browseSynonyms` pagination contract (Jira CR-11727).
//
//  The Java `browseSynonyms` helper had a bug where the incremented page was never
//  written back to the request params, so it kept re-fetching page 0 forever
//  (infinite loop / OOM). Swift's implementation is already correct; this test
//  mocks the HTTP transport (no network) and asserts that the helper:
//    - requests page 0 (full page) then page 1 (partial page), then stops,
//    - aggregates every hit from both pages (1000 + 3 == 1003),
//    - never fetches the same page twice (1003 distinct objectIDs).
//

import Foundation
#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif
import XCTest

import Utils

@testable import AlgoliaCore
@testable import AlgoliaSearch

private struct BrowseSynonymsMockError: Error {
    let message: String
}

/// Accumulates the hits handed to the `browseSynonyms` aggregator closure.
///
/// A reference type is used so the escaping aggregator mutates shared state
/// without capturing a mutable local `var`.
private final class HitCollector {
    private(set) var hits: [SynonymHit] = []

    func add(_ newHits: [SynonymHit]) {
        self.hits.append(contentsOf: newHits)
    }
}

/// A mock `RequestBuilder` standing in for the real HTTP transport.
///
/// For every `/1/indexes/{indexName}/synonyms/search` request it reads the `page`
/// from the request body, records it, and returns:
///   - page 0     -> a FULL page of 1000 hits (`page0-hit0`...`page0-hit999`),
///   - page >= 1  -> a PARTIAL page of 3 hits (`page1-hit0`...`page1-hit2`).
///
/// A partial page (fewer than `hitsPerPage == 1000` hits) is exactly the
/// condition `browseSynonyms` uses to stop paginating.
private final class BrowseSynonymsMockRequestBuilder: RequestBuilder {
    private(set) var requestedPages: [Int] = []

    private let fullPageSize = 1000
    private let partialPageSize = 3
    // Convert a "stuck on page 0" pagination regression into a clean failure
    // instead of an infinite loop that would hang the test runner.
    private let maxRequests = 100

    init() {}

    func execute<T: Decodable>(urlRequest: URLRequest, timeout _: TimeInterval) async throws -> Response<T> {
        let page = Self.readPage(from: urlRequest.httpBody)
        self.requestedPages.append(page)

        guard self.requestedPages.count <= self.maxRequests else {
            throw BrowseSynonymsMockError(
                message: "browseSynonyms issued \(self.requestedPages.count) requests; pagination is likely " +
                    "stuck re-fetching the same page (pages so far: \(self.requestedPages))."
            )
        }

        let hitsCount = page == 0 ? self.fullPageSize : self.partialPageSize
        let responseData = Self.makeSynonymsResponseData(page: page, hitsCount: hitsCount)

        guard let url = urlRequest.url,
              let httpResponse = HTTPURLResponse(url: url, statusCode: 200, httpVersion: nil, headerFields: nil)
        else {
            throw BrowseSynonymsMockError(message: "Unable to build a mock HTTPURLResponse")
        }

        switch CodableHelper.decode(T.self, from: responseData) {
        case let .success(body):
            return Response(response: httpResponse, body: body, bodyData: responseData)
        case let .failure(error):
            throw BrowseSynonymsMockError(message: "Unable to decode mock synonyms response: \(error)")
        }
    }

    private static func readPage(from body: Data?) -> Int {
        guard let body,
              let object = try? JSONSerialization.jsonObject(with: body),
              let json = object as? [String: Any],
              let page = json["page"] as? Int
        else {
            return 0
        }

        return page
    }

    private static func makeSynonymsResponseData(page: Int, hitsCount: Int) -> Data {
        let hits = (0 ..< hitsCount)
            .map { "{\"objectID\":\"page\(page)-hit\($0)\",\"type\":\"synonym\"}" }
            .joined(separator: ",")

        return Data("{\"hits\":[\(hits)],\"nbHits\":1003}".utf8)
    }
}

final class BrowseSynonymsManualTests: XCTestCase {
    func testBrowseSynonymsPaginatesUntilPartialPage() async throws {
        let configuration = try SearchClientConfiguration(appID: "my-app-id", apiKey: "my-api-key")
        let requestBuilder = BrowseSynonymsMockRequestBuilder()
        let transporter = Transporter(configuration: configuration, requestBuilder: requestBuilder)
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let collector = HitCollector()

        try await client.browseSynonyms(
            indexName: "my-index",
            searchSynonymsParams: SearchSynonymsParams(),
            aggregator: { response in
                collector.add(response.hits)
            }
        )

        // The helper must request page 0 (full), then page 1 (partial), then stop.
        XCTAssertEqual(requestBuilder.requestedPages, [0, 1])

        // Every hit from both pages must be aggregated: 1000 + 3 == 1003.
        XCTAssertEqual(collector.hits.count, 1003)

        // No page may be fetched twice, so every aggregated objectID is distinct.
        let distinctObjectIDs = Set(collector.hits.map(\.objectID))
        XCTAssertEqual(distinctObjectIDs.count, 1003)
    }
}

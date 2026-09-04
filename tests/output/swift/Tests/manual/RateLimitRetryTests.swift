//
//  RateLimitRetryTests.swift
//

import XCTest

#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif

@testable import AlgoliaCore
@testable import AlgoliaSearch

private final class RateLimitRequestBuilder: RequestBuilder {
    var statuses: [Int]
    var retryAfter: String?
    private(set) var urls: [URL] = []
    var jsonBody: String = "{\"message\":\"ok\"}"

    init(statuses: [Int], retryAfter: String? = nil) {
        self.statuses = statuses
        self.retryAfter = retryAfter
    }

    func execute<T: Decodable>(urlRequest: URLRequest, timeout _: TimeInterval) async throws -> Response<T> {
        guard let url = urlRequest.url else {
            throw AlgoliaError.requestError(GenericError(description: "missing URL"))
        }
        self.urls.append(url)

        let status = self.statuses.isEmpty ? 200 : self.statuses.removeFirst()
        var headerFields: [String: String] = [:]
        if let retryAfter = self.retryAfter {
            headerFields["Retry-After"] = retryAfter
        }
        guard let httpResponse = HTTPURLResponse(
            url: url,
            statusCode: status,
            httpVersion: nil,
            headerFields: headerFields
        ) else {
            throw AlgoliaError.requestError(GenericError(description: "unable to mock HTTPURLResponse"))
        }

        if status == 429 {
            let data = Data("{\"message\":\"Too many requests\"}".utf8)
            throw AlgoliaError.httpError(HTTPError(response: httpResponse, data: data)!)
        }

        let json = self.jsonBody
        let body = try CodableHelper.jsonDecoder.decode(T.self, from: Data(json.utf8))
        return Response(response: httpResponse, body: body, bodyData: Data(json.utf8))
    }
}

final class RateLimitRetryTests: XCTestCase {
    func testParseRetryAfter() {
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: ["Retry-After": "2"]), 2_000_000_000)
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: nil), 1_000_000_000)
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: [:]), 1_000_000_000)
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: ["Retry-After": "0"]), 1_000_000_000)
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: ["Retry-After": ""]), 1_000_000_000)
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: ["Retry-After": "120abc"]), 1_000_000_000)
        XCTAssertEqual(
            RateLimitRetry.waitNanoseconds(from: ["Retry-After": "Wed, 21 Oct 2015 07:28:00 GMT"]),
            1_000_000_000
        )
        XCTAssertEqual(RateLimitRetry.waitNanoseconds(from: ["retry-after": "3"]), 3_000_000_000)
    }

    func testWaitsRetryAfterOnSameHost() async throws {
        let builder = RateLimitRequestBuilder(statuses: [429, 200], retryAfter: "2")
        var waits: [UInt64] = []
        let client = try self.makeClient(builder: builder) { nanos in
            waits.append(nanos)
        }

        _ = try await client.customGet(path: "1/test")

        XCTAssertEqual(builder.urls.count, 2)
        XCTAssertEqual(Set(builder.urls.map(\.host)), Set(builder.urls.prefix(1).map(\.host)))
        XCTAssertEqual(waits, [2_000_000_000])
        XCTAssertFalse(builder.urls.contains { $0.host == "host-b.example" })
    }

    func testMissingRetryAfterWaitsOneSecond() async throws {
        let builder = RateLimitRequestBuilder(statuses: [429, 200])
        var waits: [UInt64] = []
        let client = try self.makeClient(builder: builder, extraHost: false) { nanos in
            waits.append(nanos)
        }

        _ = try await client.customGet(path: "1/test")
        XCTAssertEqual(waits, [1_000_000_000])
        XCTAssertEqual(builder.urls.count, 2)
    }

    func testMaxRateLimitRetriesZeroFailsImmediately() async throws {
        let builder = RateLimitRequestBuilder(statuses: [429], retryAfter: "1")
        let client = try self.makeClient(builder: builder, extraHost: false, maxRetries: 0) { _ in
            XCTFail("should not wait")
        }

        do {
            _ = try await client.customGet(path: "1/test")
            XCTFail("expected 429")
        } catch {
            XCTAssertTrue(RateLimitRetry.isRateLimited(error))
        }
        XCTAssertEqual(builder.urls.count, 1)
    }

    func testExhaustsMaxRateLimitRetries() async throws {
        let builder = RateLimitRequestBuilder(statuses: [429, 429, 429, 429], retryAfter: "1")
        let client = try self.makeClient(builder: builder, extraHost: false) { _ in }

        do {
            _ = try await client.customGet(path: "1/test")
            XCTFail("expected 429")
        } catch {
            XCTAssertTrue(RateLimitRetry.isRateLimited(error))
        }
        XCTAssertEqual(builder.urls.count, 4)
    }

    private func makeClient(
        builder: RateLimitRequestBuilder,
        extraHost: Bool = true,
        maxRetries: Int = RateLimitRetry.defaultMaxRetries,
        sleep: @escaping (UInt64) async throws -> Void
    ) throws -> SearchClient {
        var hosts = [RetryableHost(url: URL(string: "http://host-a.example")!)]
        if extraHost {
            hosts.append(RetryableHost(url: URL(string: "http://host-b.example")!))
        }
        let configuration = try SearchClientConfiguration(
            appID: "appID",
            apiKey: "apiKey",
            hosts: hosts,
            maxRateLimitRetries: maxRetries
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: builder)
        transporter.sleep = sleep
        return SearchClient(configuration: configuration, transporter: transporter)
    }
}

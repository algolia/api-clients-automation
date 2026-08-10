//
//  RequestIdTests.swift
//  AlgoliaSearchClientTests
//
//  Created by Algolia on 10/08/2026.
//

import XCTest

#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif

@testable import AlgoliaCore
@testable import AlgoliaIngestion
@testable import AlgoliaSearch

/// Records the Request-ID header of every request it serves.
private final class RequestIDRecordingRequestBuilder: RequestBuilder {
    private(set) var requestIDs: [String?] = []
    var failuresBeforeSuccess = 0
    var jsonForPath: (String) -> String = { _ in "{}" }

    func execute<T: Decodable>(urlRequest: URLRequest, timeout _: TimeInterval) async throws -> Response<T> {
        // Scan the headers case-insensitively: on corelibs-foundation the
        // value(forHTTPHeaderField:) lookup is not reliably case-insensitive.
        self.requestIDs.append(
            urlRequest.allHTTPHeaderFields?.first {
                $0.key.caseInsensitiveCompare("Request-ID") == .orderedSame
            }?.value
        )

        guard let url = urlRequest.url else {
            throw AlgoliaError.requestError(GenericError(description: "missing URL"))
        }

        if self.failuresBeforeSuccess > 0 {
            self.failuresBeforeSuccess -= 1
            throw AlgoliaError.httpError(HTTPError(statusCode: 500, message: nil))
        }

        let json = self.jsonForPath(url.path)
        let body = try CodableHelper.jsonDecoder.decode(T.self, from: Data(json.utf8))

        guard let httpResponse = HTTPURLResponse(url: url, statusCode: 200, httpVersion: nil, headerFields: nil)
        else {
            throw AlgoliaError.requestError(GenericError(description: "unable to mock HTTPURLResponse"))
        }

        return Response(response: httpResponse, body: body, bodyData: Data(json.utf8))
    }
}

final class RequestIdTests: XCTestCase {
    private let requestIDPattern = "^[0-9A-Za-z]{11}$"

    private func makeSearchClient(
        recorder: RequestIDRecordingRequestBuilder,
        hostCount: Int = 1,
        defaultHeaders: [String: String]? = nil
    ) throws -> SearchClient {
        let hosts = (0 ..< hostCount).map { _ in
            RetryableHost(url: URL(string: "http://localhost:9999")!)
        }
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            defaultHeaders: defaultHeaders,
            hosts: hosts
        )

        return SearchClient(
            configuration: configuration,
            transporter: Transporter(configuration: configuration, requestBuilder: recorder)
        )
    }

    private func assertWellFormed(_ id: String?, file: StaticString = #filePath, line: UInt = #line) throws {
        let id = try XCTUnwrap(id, file: file, line: line)
        XCTAssertNotNil(id.range(of: self.requestIDPattern, options: .regularExpression), file: file, line: line)
    }

    func testGenerateFormatAndUniqueness() throws {
        var seen = Set<String>()
        for _ in 0 ..< 100 {
            let id = RequestID.generate()
            try self.assertWellFormed(id)
            seen.insert(id)
        }

        XCTAssertGreaterThan(seen.count, 90, "IDs are expected to be essentially unique")
    }

    func testHasRequestIDIsCaseInsensitive() {
        XCTAssertFalse(RequestID.hasRequestID(in: nil))
        XCTAssertFalse(RequestID.hasRequestID(in: ["x-forwarded-for": "1"]))
        XCTAssertTrue(RequestID.hasRequestID(in: ["request-id": "a"]))
        XCTAssertTrue(RequestID.hasRequestID(in: ["ReQuEsT-iD": "a"]))
        XCTAssertTrue(RequestID.hasRequestID(in: ["REQUEST-ID": "a"]))
    }

    func testMintsFreshRequestIDPerCall() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        let client = try makeSearchClient(recorder: recorder)

        _ = try await client.customGet(path: "1/test")
        _ = try await client.customGet(path: "1/test")

        XCTAssertEqual(recorder.requestIDs.count, 2)
        try self.assertWellFormed(recorder.requestIDs[0])
        try self.assertWellFormed(recorder.requestIDs[1])
        XCTAssertNotEqual(recorder.requestIDs[0], recorder.requestIDs[1])
    }

    func testReusesRequestIDAcrossRetries() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        recorder.failuresBeforeSuccess = 2
        let client = try makeSearchClient(recorder: recorder, hostCount: 3)

        _ = try await client.customGet(path: "1/test")

        XCTAssertEqual(recorder.requestIDs.count, 3)
        try self.assertWellFormed(recorder.requestIDs[0])
        XCTAssertEqual(recorder.requestIDs[0], recorder.requestIDs[1])
        XCTAssertEqual(recorder.requestIDs[0], recorder.requestIDs[2])
    }

    func testCallerSuppliedRequestIDWins() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        let client = try makeSearchClient(recorder: recorder)

        _ = try await client.customGet(
            path: "1/test",
            requestOptions: RequestOptions(headers: ["ReQuEsT-iD": "CallerOwnedId"])
        )

        XCTAssertEqual(recorder.requestIDs, ["CallerOwnedId"])
    }

    func testDefaultHeadersRequestIDWins() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        let client = try makeSearchClient(recorder: recorder, defaultHeaders: ["REQUEST-ID": "DefaultOwned"])

        _ = try await client.customGet(path: "1/test")

        XCTAssertEqual(recorder.requestIDs, ["DefaultOwned"])
    }

    func testIngestionNeverMints() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        let configuration = try IngestionClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            region: .us
        )
        let client = IngestionClient(
            configuration: configuration,
            transporter: Transporter(configuration: configuration, requestBuilder: recorder)
        )

        _ = try await client.customGet(path: "1/test")

        XCTAssertEqual(recorder.requestIDs, [nil])
    }

    func testHelperSharesOneRequestID() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        recorder.jsonForPath = { path in
            path.contains("/batch")
                ? "{\"taskID\":42,\"objectIDs\":[\"1\"]}"
                : "{\"status\":\"published\"}"
        }
        let client = try makeSearchClient(recorder: recorder)

        // batchSize 1 over two objects: 2 batch calls + 2 task polls.
        _ = try await client.saveObjects(
            indexName: "indexName",
            objects: [["objectID": "1"], ["objectID": "2"]],
            waitForTasks: true,
            batchSize: 1
        )

        XCTAssertEqual(recorder.requestIDs.count, 4)
        try self.assertWellFormed(recorder.requestIDs[0])
        for id in recorder.requestIDs {
            XCTAssertEqual(id, recorder.requestIDs[0])
        }

        // A second helper invocation mints a fresh ID.
        _ = try await client.saveObjects(indexName: "indexName", objects: [["objectID": "3"]])

        XCTAssertEqual(recorder.requestIDs.count, 5)
        try self.assertWellFormed(recorder.requestIDs[4])
        XCTAssertNotEqual(recorder.requestIDs[0], recorder.requestIDs[4])
    }

    func testHelperKeepsCallerRequestID() async throws {
        let recorder = RequestIDRecordingRequestBuilder()
        recorder.jsonForPath = { _ in "{\"taskID\":42,\"objectIDs\":[\"1\"]}" }
        let client = try makeSearchClient(recorder: recorder)

        _ = try await client.saveObjects(
            indexName: "indexName",
            objects: [["objectID": "1"]],
            requestOptions: RequestOptions(headers: ["Request-ID": "HelperCaller"])
        )

        XCTAssertEqual(recorder.requestIDs, ["HelperCaller"])
    }

    func testHTTPErrorCarriesCorrelationID() throws {
        let response = try XCTUnwrap(HTTPURLResponse(
            url: XCTUnwrap(URL(string: "https://example.org/1/test")),
            statusCode: 400,
            httpVersion: nil,
            headerFields: [
                "cOrReLaTiOn-Id": "CorrTest123",
                // The unrelated edge header must never be surfaced instead.
                "X-Algolia-RequestID": "EdgePopValue",
            ]
        ))

        let error = try XCTUnwrap(HTTPError(response: response, data: Data("{\"message\":\"boom\"}".utf8)))
        XCTAssertEqual(error.correlationId, "CorrTest123")
        XCTAssertTrue(error.description.hasSuffix("(Correlation-ID: CorrTest123)"))
    }

    func testHTTPErrorWithoutCorrelationIDIsUnchanged() throws {
        let response = try XCTUnwrap(HTTPURLResponse(
            url: XCTUnwrap(URL(string: "https://example.org/1/test")),
            statusCode: 400,
            httpVersion: nil,
            headerFields: ["X-Algolia-RequestID": "EdgePopValue"]
        ))

        let error = try XCTUnwrap(HTTPError(response: response, data: nil))
        XCTAssertNil(error.correlationId)
        XCTAssertEqual(error.description, "Status code: 400 Message: No message")
    }
}

//
//  Waiters.swift
//
//
//  Created by Algolia on 20/02/2024.
//

import Foundation
#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif

import XCTest
@testable import Core
@testable import Search
@testable import Utils

class WaiterTests: XCTestCase {
    func testWaitForTaskSuccess() async throws {
        let indexName = "yourIndexName"

        let client = try MockSearchClient<GetTaskResponse>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .published),
        ])

        let response = try await client.setSettings(indexName: indexName, indexSettings: IndexSettings())

        let result = try await client.waitForTask(
            with: response.taskID,
            in: indexName,
            maxRetries: 3
        )

        XCTAssertEqual(result.status, .published)
    }

    func testWaitForTaskFailure() async throws {
        let maxRetries = 4
        let indexName = "yourIndexName"

        let client = try MockSearchClient<GetTaskResponse>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .notPublished),
            GetTaskResponse(status: .published),
        ])

        let response = try await client.setSettings(indexName: indexName, indexSettings: IndexSettings())

        do {
            try await client.waitForTask(
                with: response.taskID,
                in: indexName,
                maxRetries: maxRetries
            )

            XCTFail("Expected an error but didn't receive one.")
        } catch {
            XCTAssertTrue(error is AlgoliaError)
            XCTAssertEqual(
                error.localizedDescription,
                "The maximum number of retries exceeded. (\(maxRetries)/\(maxRetries))"
            )
        }
    }

    func testWaitForApiKeyAddSuccess() async throws {
        let apiKeyACLs: [Acl] = [.search]

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 404,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: nil,
                bodyData: nil
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 201,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
        ])

        let response = try await client.addApiKey(
            apiKey: ApiKey(acl: apiKeyACLs)
        )

        let result = try await client.waitForApiKey(
            with: response.key,
            operation: .add,
            maxRetries: 3
        )

        XCTAssertNotNil(result)

        let apiKey = try XCTUnwrap(result)
        XCTAssertEqual(apiKey.acl, apiKeyACLs)
    }

    func testWaitForApiKeyAddFailure() async throws {
        let maxRetries = 1
        let apiKeyACLs: [Acl] = [.search]

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 404,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: nil,
                bodyData: nil
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 201,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
        ])

        let response = try await client.addApiKey(
            apiKey: ApiKey(acl: apiKeyACLs)
        )

        do {
            try await client.waitForApiKey(
                with: response.key,
                operation: .add,
                maxRetries: maxRetries
            )

            XCTFail("Expected an error but didn't receive one.")
        } catch {
            XCTAssertTrue(error is AlgoliaError)
            XCTAssertEqual(
                error.localizedDescription,
                "The maximum number of retries exceeded. (\(maxRetries)/\(maxRetries))"
            )
        }
    }

    func testWaitForApiKeyDeleteSuccess() async throws {
        let apiKey = "api-key-to-delete"

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 404,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: nil,
                bodyData: nil
            ),
        ])

        _ = try await client.deleteApiKey(key: apiKey)

        let result = try await client.waitForApiKey(
            with: apiKey,
            operation: .delete,
            maxRetries: 4
        )

        XCTAssertNil(result)
    }

    func testWaitForApiKeyDeleteFailure() async throws {
        let maxRetries = 2
        let apiKey = "api-key-to-delete"

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 404,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: nil,
                bodyData: nil
            ),
        ])

        _ = try await client.deleteApiKey(key: apiKey)

        do {
            try await client.waitForApiKey(
                with: apiKey,
                operation: .delete,
                maxRetries: maxRetries
            )

            XCTFail("Expected an error but didn't receive one.")
        } catch {
            XCTAssertTrue(error is AlgoliaError)
            XCTAssertEqual(
                error.localizedDescription,
                "The maximum number of retries exceeded. (\(maxRetries)/\(maxRetries))"
            )
        }
    }

    func testWaitForApiKeyUpdateSuccess() async throws {
        let apiKey = "api-key-to-update"
        let newACLs: [Acl] = [.addObject, .search]
        let apiKeyBody = ApiKey(acl: newACLs)

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search, .addObject]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\",\"addObject\"]}".data(using: .utf8)
            ),
        ])

        let response = try await client.updateApiKey(key: apiKey, apiKey: apiKeyBody)

        let result = try await client.waitForApiKey(
            with: response.key,
            operation: .update,
            apiKey: apiKeyBody,
            maxRetries: 3
        )

        XCTAssertNotNil(result)

        let receivedAPIKey = try XCTUnwrap(result)
        XCTAssertEqual(
            receivedAPIKey.acl.sorted { $0.rawValue > $1.rawValue },
            newACLs.sorted { $0.rawValue > $1.rawValue }
        )
    }

    func testWaitForApiKeyUpdateFailureWait() async throws {
        let maxRetries = 2
        let apiKey = "api-key-to-update"
        let newACLs: [Acl] = [.addObject, .search]
        let apiKeyBody = ApiKey(acl: newACLs)

        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\"]}".data(using: .utf8)
            ),
            Response(
                response: HTTPURLResponse(
                    url: URL(string: "https://algolia.com/")!,
                    statusCode: 200,
                    httpVersion: nil,
                    headerFields: nil
                )!,
                body: GetApiKeyResponse(createdAt: 1_708_423_800, acl: [.search, .addObject]),
                bodyData: "{\"createdAt\":1708423800,\"acl\":[\"search\",\"addObject\"]}".data(using: .utf8)
            ),
        ])

        let response = try await client.updateApiKey(key: apiKey, apiKey: apiKeyBody)

        do {
            try await client.waitForApiKey(
                with: response.key,
                operation: .update,
                apiKey: apiKeyBody,
                maxRetries: maxRetries
            )

            XCTFail("Expected an error but didn't receive one.")
        } catch {
            XCTAssertTrue(error is AlgoliaError)
            XCTAssertEqual(
                error.localizedDescription,
                "The maximum number of retries exceeded. (\(maxRetries)/\(maxRetries))"
            )
        }
    }

    func testWaitForApiKeyUpdateFailureNilKey() async throws {
        let client = try MockSearchClient<Response<GetApiKeyResponse>>(appID: "test-app-id", apiKey: "test-api-key")

        do {
            try await client.waitForApiKey(
                with: "api-key-to-update",
                operation: .update,
                maxRetries: 3
            )

            XCTFail("Expected an error but didn't receive one.")
        } catch {
            XCTAssertTrue(error is AlgoliaError)
            XCTAssertEqual(
                error.localizedDescription,
                AlgoliaError.runtimeError("Missing API key optimistic value").localizedDescription
            )
        }
    }
}

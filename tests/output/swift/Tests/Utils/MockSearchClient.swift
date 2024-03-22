//
//  MockSearchClient.swift
//
//
//  Created by Algolia on 21/02/2024.
//

import Foundation
#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif
@testable import Core
@testable import Search

public class MockSearchClient<T>: SearchClient {
    var loop = 0
    var responses: [T] = []

    public func setResponses(_ elements: [T]) {
        self.responses = elements
    }

    override public func setSettings(
        indexName _: String,
        indexSettings _: IndexSettings,
        forwardToReplicas _: Bool? = nil,
        requestOptions _: RequestOptions? = nil
    ) async throws -> UpdatedAtResponse {
        UpdatedAtResponse(
            taskID: 12345,
            updatedAt: "2024-02-20T10:10:00Z"
        )
    }

    override public func addApiKey(
        apiKey _: ApiKey,
        requestOptions _: RequestOptions? = nil
    ) async throws -> AddApiKeyResponse {
        AddApiKeyResponse(
            key: "created-api-key",
            createdAt: "2024-02-20T10:10:00Z"
        )
    }

    override public func deleteApiKey(
        key _: String,
        requestOptions _: RequestOptions? = nil
    ) async throws -> DeleteApiKeyResponse {
        DeleteApiKeyResponse(deletedAt: "2024-02-20T10:10:00Z")
    }

    override public func updateApiKey(
        key: String,
        apiKey _: ApiKey,
        requestOptions _: RequestOptions? = nil
    ) async throws -> UpdateApiKeyResponse {
        UpdateApiKeyResponse(key: key, updatedAt: "2024-02-20T10:10:00Z")
    }

    override public func getTask(
        indexName _: String,
        taskID _: Int64,
        requestOptions _: RequestOptions? = nil
    ) async throws -> GetTaskResponse {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! GetTaskResponse
    }

    override public func getApiKeyWithHTTPInfo(
        key _: String,
        requestOptions _: RequestOptions? = nil
    ) async throws -> Response<GetApiKeyResponse> {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! Response<GetApiKeyResponse>
    }

    override public func browse<U: Codable>(
        indexName _: String,
        browseParams _: BrowseParams? = nil,
        requestOptions _: RequestOptions? = nil
    ) async throws -> BrowseResponse<U> {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! BrowseResponse<U>
    }

    override public func searchRules(
        indexName _: String,
        searchRulesParams _: SearchRulesParams? = nil,
        requestOptions _: RequestOptions? = nil
    ) async throws -> SearchRulesResponse {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! SearchRulesResponse
    }

    override public func searchSynonyms(
        indexName _: String,
        searchSynonymsParams _: SearchSynonymsParams? = nil,
        requestOptions _: RequestOptions? = nil
    ) async throws -> SearchSynonymsResponse {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! SearchSynonymsResponse
    }

    override public func search<U: Codable>(
        searchMethodParams _: SearchMethodParams,
        requestOptions _: RequestOptions? = nil
    ) async throws -> SearchResponses<U> {
        defer {
            loop += 1
        }
        return self.responses[self.loop] as! SearchResponses<U>
    }
}

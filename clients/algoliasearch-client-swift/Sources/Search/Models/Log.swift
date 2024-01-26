// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

public struct Log: Codable, JSONEncodable, Hashable {
    /** Timestamp in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. */
    public var timestamp: String
    /** HTTP method of the performed request. */
    public var method: String
    /** HTTP response code. */
    public var answerCode: String
    /** Request body. Truncated after 1,000 characters. */
    public var queryBody: String
    /** Answer body. Truncated after 1,000 characters. */
    public var answer: String
    /** Request URL. */
    public var url: String
    /** IP address of the client that performed the request. */
    public var ip: String
    /** Request headers (API key is obfuscated). */
    public var queryHeaders: String
    /** SHA1 signature of the log entry. */
    public var sha1: String
    /** Number of API calls. */
    public var nbApiCalls: String
    /** Processing time for the query. Doesn't include network time. */
    public var processingTimeMs: String
    /** Index targeted by the query. */
    public var index: String?
    /** Query parameters sent with the request. */
    public var queryParams: String?
    /** Number of hits returned for the query. */
    public var queryNbHits: String?
    /** Performed queries for the given request. */
    public var innerQueries: [LogQuery]?

    public init(timestamp: String, method: String, answerCode: String, queryBody: String, answer: String, url: String, ip: String, queryHeaders: String, sha1: String, nbApiCalls: String, processingTimeMs: String, index: String? = nil, queryParams: String? = nil, queryNbHits: String? = nil, innerQueries: [LogQuery]? = nil) {
        self.timestamp = timestamp
        self.method = method
        self.answerCode = answerCode
        self.queryBody = queryBody
        self.answer = answer
        self.url = url
        self.ip = ip
        self.queryHeaders = queryHeaders
        self.sha1 = sha1
        self.nbApiCalls = nbApiCalls
        self.processingTimeMs = processingTimeMs
        self.index = index
        self.queryParams = queryParams
        self.queryNbHits = queryNbHits
        self.innerQueries = innerQueries
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case timestamp
        case method
        case answerCode = "answer_code"
        case queryBody = "query_body"
        case answer
        case url
        case ip
        case queryHeaders = "query_headers"
        case sha1
        case nbApiCalls = "nb_api_calls"
        case processingTimeMs = "processing_time_ms"
        case index
        case queryParams = "query_params"
        case queryNbHits = "query_nb_hits"
        case innerQueries = "inner_queries"
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(timestamp, forKey: .timestamp)
        try container.encode(method, forKey: .method)
        try container.encode(answerCode, forKey: .answerCode)
        try container.encode(queryBody, forKey: .queryBody)
        try container.encode(answer, forKey: .answer)
        try container.encode(url, forKey: .url)
        try container.encode(ip, forKey: .ip)
        try container.encode(queryHeaders, forKey: .queryHeaders)
        try container.encode(sha1, forKey: .sha1)
        try container.encode(nbApiCalls, forKey: .nbApiCalls)
        try container.encode(processingTimeMs, forKey: .processingTimeMs)
        try container.encodeIfPresent(index, forKey: .index)
        try container.encodeIfPresent(queryParams, forKey: .queryParams)
        try container.encodeIfPresent(queryNbHits, forKey: .queryNbHits)
        try container.encodeIfPresent(innerQueries, forKey: .innerQueries)
    }
}

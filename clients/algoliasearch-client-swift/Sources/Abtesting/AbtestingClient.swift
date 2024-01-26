// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

typealias Client = AbtestingClient

open class AbtestingClient {
    private var configuration: Configuration
    private var transporter: Transporter

    var applicationID: String {
        configuration.applicationID
    }

    public init(configuration: Configuration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: Configuration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(applicationID: String, apiKey: String, region: Region?) throws {
        try self.init(configuration: Configuration(applicationID: applicationID, apiKey: apiKey, region: region))
    }

    /**
     Create an A/B test.

     - parameter addABTestsRequest: (body)
     - returns: ABTestResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func addABTests(addABTestsRequest: AddABTestsRequest, requestOptions: RequestOptions? = nil) async throws -> ABTestResponse {
        let response: Response<ABTestResponse> = try await addABTestsWithHTTPInfo(addABTestsRequest: addABTestsRequest, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Create an A/B test.

     Creates an A/B test.
     - parameter addABTestsRequest: (body)
     - returns: RequestBuilder<ABTestResponse>
     */

    open func addABTestsWithHTTPInfo(addABTestsRequest: AddABTestsRequest, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<ABTestResponse> {
        let resourcePath = "/2/abtests"
        let body = addABTestsRequest
        let queryItems: [URLQueryItem]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "POST",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: AnyCodable
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customDelete(path: String, parameters: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customDeleteWithHTTPInfo(path: path, parameters: parameters, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customDeleteWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{path}", with: pathPostEscape, options: .literal, range: nil)
        let body: AnyCodable? = nil
        let queryItems = APIHelper.mapValuesToQueryItems(parameters)

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "DELETE",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: AnyCodable
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customGet(path: String, parameters: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customGetWithHTTPInfo(path: path, parameters: parameters, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customGetWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{path}", with: pathPostEscape, options: .literal, range: nil)
        let body: AnyCodable? = nil
        let queryItems = APIHelper.mapValuesToQueryItems(parameters)

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: AnyCodable
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPost(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customPostWithHTTPInfo(path: path, parameters: parameters, body: body, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customPostWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{path}", with: pathPostEscape, options: .literal, range: nil)
        let body = body
        let queryItems = APIHelper.mapValuesToQueryItems(parameters)

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "POST",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: AnyCodable
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPut(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customPutWithHTTPInfo(path: path, parameters: parameters, body: body, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customPutWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{path}", with: pathPostEscape, options: .literal, range: nil)
        let body = body
        let queryItems = APIHelper.mapValuesToQueryItems(parameters)

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "PUT",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Delete an A/B test.

     - parameter id: (path) Unique A/B test ID.
     - returns: ABTestResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteABTest(id: Int, requestOptions: RequestOptions? = nil) async throws -> ABTestResponse {
        let response: Response<ABTestResponse> = try await deleteABTestWithHTTPInfo(id: id, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Delete an A/B test.

     Delete an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     - parameter id: (path) Unique A/B test ID.
     - returns: RequestBuilder<ABTestResponse>
     */

    open func deleteABTestWithHTTPInfo(id: Int, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<ABTestResponse> {
        var resourcePath = "/2/abtests/{id}"
        let idPreEscape = "\(APIHelper.mapValueToPathItem(id))"
        let idPostEscape = idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{id}", with: idPostEscape, options: .literal, range: nil)
        let body: AnyCodable? = nil
        let queryItems: [URLQueryItem]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "DELETE",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Get A/B test details.

     - parameter id: (path) Unique A/B test ID.
     - returns: ABTest
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getABTest(id: Int, requestOptions: RequestOptions? = nil) async throws -> ABTest {
        let response: Response<ABTest> = try await getABTestWithHTTPInfo(id: id, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Get A/B test details.

     Get specific details for an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     - parameter id: (path) Unique A/B test ID.
     - returns: RequestBuilder<ABTest>
     */

    open func getABTestWithHTTPInfo(id: Int, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<ABTest> {
        var resourcePath = "/2/abtests/{id}"
        let idPreEscape = "\(APIHelper.mapValueToPathItem(id))"
        let idPostEscape = idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{id}", with: idPostEscape, options: .literal, range: nil)
        let body: AnyCodable? = nil
        let queryItems: [URLQueryItem]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     List all A/B tests.

     - parameter offset: (query) Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     - parameter limit: (query) Number of records to return (page size). (optional, default to 10)
     - parameter indexPrefix: (query) Only return A/B tests for indices starting with this prefix. (optional)
     - parameter indexSuffix: (query) Only return A/B tests for indices ending with this suffix. (optional)
     - returns: ListABTestsResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func listABTests(offset: Int? = nil, limit: Int? = nil, indexPrefix: String? = nil, indexSuffix: String? = nil, requestOptions: RequestOptions? = nil) async throws -> ListABTestsResponse {
        let response: Response<ListABTestsResponse> = try await listABTestsWithHTTPInfo(offset: offset, limit: limit, indexPrefix: indexPrefix, indexSuffix: indexSuffix, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     List all A/B tests.

     List all A/B tests.
     - parameter offset: (query) Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)
     - parameter limit: (query) Number of records to return (page size). (optional, default to 10)
     - parameter indexPrefix: (query) Only return A/B tests for indices starting with this prefix. (optional)
     - parameter indexSuffix: (query) Only return A/B tests for indices ending with this suffix. (optional)
     - returns: RequestBuilder<ListABTestsResponse>
     */

    open func listABTestsWithHTTPInfo(offset: Int? = nil, limit: Int? = nil, indexPrefix: String? = nil, indexSuffix: String? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<ListABTestsResponse> {
        let resourcePath = "/2/abtests"
        let body: AnyCodable? = nil
        let queryItems = APIHelper.mapValuesToQueryItems([
            "offset": offset?.encodeToJSON(),
            "limit": limit?.encodeToJSON(),
            "indexPrefix": indexPrefix?.encodeToJSON(),
            "indexSuffix": indexSuffix?.encodeToJSON(),
        ])

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }

    /**
     Stop an A/B test.

     - parameter id: (path) Unique A/B test ID.
     - returns: ABTestResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func stopABTest(id: Int, requestOptions: RequestOptions? = nil) async throws -> ABTestResponse {
        let response: Response<ABTestResponse> = try await stopABTestWithHTTPInfo(id: id, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Stop an A/B test.

     If stopped, the test is over and can't be restarted. There is now only one index, receiving 100% of all search requests. The data gathered for stopped A/B tests is retained. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     - parameter id: (path) Unique A/B test ID.
     - returns: RequestBuilder<ABTestResponse>
     */

    open func stopABTestWithHTTPInfo(id: Int, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<ABTestResponse> {
        var resourcePath = "/2/abtests/{id}/stop"
        let idPreEscape = "\(APIHelper.mapValueToPathItem(id))"
        let idPostEscape = idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{id}", with: idPostEscape, options: .literal, range: nil)
        let body: AnyCodable? = nil
        let queryItems: [URLQueryItem]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await transporter.send(
            method: "POST",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
        )
    }
}

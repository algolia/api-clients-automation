// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

typealias Client = InsightsClient

open class InsightsClient {
    private var configuration: Configuration
    private var transporter: Transporter

    var appId: String {
        configuration.appId
    }

    public init(configuration: Configuration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: Configuration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(appId: String, apiKey: String, region: Region?) throws {
        try self.init(configuration: Configuration(appId: appId, apiKey: apiKey, region: region))
    }

    /**
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
     This method allow you to send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customDeleteWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customDelete")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = path
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
     This method allow you to send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customGetWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customGet")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = path
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
     This method allow you to send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customPostWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPost")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = path
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
     This method allow you to send requests to the Algolia REST API.

     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

    open func customPutWithHTTPInfo(path: String, parameters: [String: AnyCodable]? = nil, body: [String: AnyCodable]? = nil, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPut")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        let pathPostEscape = path
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
     - parameter userToken: (path) The user token for which to delete all associated events.
     - returns: Void
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteUserToken(userToken: String, requestOptions: RequestOptions? = nil) async throws {
        try await deleteUserTokenWithHTTPInfo(userToken: userToken, requestOptions: requestOptions)
    }

    /**
     Delete all events related to a certain user token from events metrics and analytics. To delete a personalization user profile, see [Delete a user profile](https://www.algolia.com/doc/rest-api/personalization/#delete-a-user-profile).

     - responseHeaders: [x-ratelimit-limit(Int), x-ratelimit-remaining(Int), x-ratelimit-reset(Int)]
     - parameter userToken: (path) The user token for which to delete all associated events.
     - returns: RequestBuilder<Void>
     */
    @discardableResult
    open func deleteUserTokenWithHTTPInfo(userToken: String, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<AnyCodable> {
        guard !userToken.isEmpty else {
            throw AlgoliaError.invalidArgument("userToken", "deleteUserToken")
        }

        var resourcePath = "/1/usertokens/{userToken}"
        let userTokenPreEscape = "\(APIHelper.mapValueToPathItem(userToken))"
        let userTokenPostEscape = userTokenPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{userToken}", with: userTokenPostEscape, options: .literal, range: nil)
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
     - parameter insightsEvents: (body)
     - returns: EventsResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func pushEvents(insightsEvents: InsightsEvents, requestOptions: RequestOptions? = nil) async throws -> EventsResponse {
        let response: Response<EventsResponse> = try await pushEventsWithHTTPInfo(insightsEvents: insightsEvents, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.

     - parameter insightsEvents: (body)
     - returns: RequestBuilder<EventsResponse>
     */

    open func pushEventsWithHTTPInfo(insightsEvents: InsightsEvents, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<EventsResponse> {
        let resourcePath = "/1/events"
        let body = insightsEvents
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

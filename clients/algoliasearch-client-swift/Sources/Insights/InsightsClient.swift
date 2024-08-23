// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

open class InsightsClient {
    private var configuration: InsightsClientConfiguration
    private var transporter: Transporter

    var appID: String {
        self.configuration.appID
    }

    public init(configuration: InsightsClientConfiguration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: InsightsClientConfiguration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(appID: String, apiKey: String, region: Region?) throws {
        try self.init(configuration: InsightsClientConfiguration(appID: appID, apiKey: apiKey, region: region))
    }

    /// - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customDelete(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customDeleteWithHTTPInfo(
            path: path,
            parameters: parameters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // This method allow you to send requests to the Algolia REST API.
    //
    //
    // - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customDeleteWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customDelete")
        }

        var resourcePath = "/{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters: [String: AnyCodable]? = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "DELETE",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customGet(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customGetWithHTTPInfo(
            path: path,
            parameters: parameters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // This method allow you to send requests to the Algolia REST API.
    //
    //
    // - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customGetWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customGet")
        }

        var resourcePath = "/{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters: [String: AnyCodable]? = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - parameter body: (body) Parameters to send with the custom request. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPost(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: Codable? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customPostWithHTTPInfo(
            path: path,
            parameters: parameters,
            body: body,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // This method allow you to send requests to the Algolia REST API.
    //
    //
    // - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    //
    // - parameter body: (body) Parameters to send with the custom request. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customPostWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: Codable? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPost")
        }

        var resourcePath = "/{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body = body
        let queryParameters: [String: AnyCodable]? = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - parameter body: (body) Parameters to send with the custom request. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPut(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: Codable? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> AnyCodable {
        let response: Response<AnyCodable> = try await customPutWithHTTPInfo(
            path: path,
            parameters: parameters,
            body: body,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // This method allow you to send requests to the Algolia REST API.
    //
    //
    // - parameter path: (path) Path of the endpoint, anything after \"/1\" must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    //
    // - parameter body: (body) Parameters to send with the custom request. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customPutWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: Codable? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPut")
        }

        var resourcePath = "/{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body = body
        let queryParameters: [String: AnyCodable]? = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "PUT",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter userToken: (path) User token for which to delete all associated events.
    /// - returns: Void
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteUserToken(userToken: String, requestOptions: RequestOptions? = nil) async throws {
        try await self.deleteUserTokenWithHTTPInfo(userToken: userToken, requestOptions: requestOptions)
    }

    /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is
    /// asynchronous, and processed within 48 hours. To delete a personalization user profile, see [Delete a user
    /// profile](/specs/personalization#tag/profiles/operation/deleteUserProfile).
    ///
    ///
    /// - parameter userToken: (path) User token for which to delete all associated events.
    /// - returns: RequestBuilder<Void>
    @discardableResult
    open func deleteUserTokenWithHTTPInfo(
        userToken: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !userToken.isEmpty else {
            throw AlgoliaError.invalidArgument("userToken", "deleteUserToken")
        }

        var resourcePath = "/1/usertokens/{userToken}"
        let userTokenPreEscape = "\(APIHelper.mapValueToPathItem(userToken))"
        let userTokenPostEscape = userTokenPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{userToken}",
            with: userTokenPostEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "DELETE",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter insightsEvents: (body)
    /// - returns: EventsResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func pushEvents(
        insightsEvents: InsightsEvents,
        requestOptions: RequestOptions? = nil
    ) async throws -> EventsResponse {
        let response: Response<EventsResponse> = try await pushEventsWithHTTPInfo(
            insightsEvents: insightsEvents,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the
    // request body must be smaller than 2&nbsp;MB.
    //
    //
    // - parameter insightsEvents: (body)
    // - returns: RequestBuilder<EventsResponse>

    open func pushEventsWithHTTPInfo(
        insightsEvents: InsightsEvents,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<EventsResponse> {
        let resourcePath = "/1/events"
        let body = insightsEvents
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }
}

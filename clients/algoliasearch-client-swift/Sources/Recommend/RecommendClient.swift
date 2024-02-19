// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import AnyCodable
import Core
import Foundation

typealias Client = RecommendClient

open class RecommendClient {
    private var configuration: Configuration
    private var transporter: Transporter

    var appID: String {
        self.configuration.appID
    }

    public init(configuration: Configuration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: Configuration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(appID: String, apiKey: String) throws {
        try self.init(configuration: Configuration(appID: appID, apiKey: apiKey))
    }

    /// - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
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
    // - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
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

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "DELETE",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
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
    // - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
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

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - parameter body: (body) Parameters to send with the custom request. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPost(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: [String: AnyCodable]? = nil,
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
    // - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    //
    // - parameter body: (body) Parameters to send with the custom request. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customPostWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: [String: AnyCodable]? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPost")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body = body
        let queryParameters = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
    /// - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    /// - parameter body: (body) Parameters to send with the custom request. (optional)
    /// - returns: AnyCodable
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func customPut(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: [String: AnyCodable]? = nil,
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
    // - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
    //
    // - parameter parameters: (query) Query parameters to apply to the current query. (optional)
    //
    // - parameter body: (body) Parameters to send with the custom request. (optional)
    // - returns: RequestBuilder<AnyCodable>

    open func customPutWithHTTPInfo(
        path: String,
        parameters: [String: AnyCodable]? = nil,
        body: [String: AnyCodable]? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<AnyCodable> {
        guard !path.isEmpty else {
            throw AlgoliaError.invalidArgument("path", "customPut")
        }

        var resourcePath = "/1{path}"
        let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
        resourcePath = resourcePath.replacingOccurrences(
            of: "{path}",
            with: pathPreEscape,
            options: .literal,
            range: nil
        )
        let body = body
        let queryParameters = parameters

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "PUT",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter indexName: (path) Index on which to perform the request.
    /// - parameter model: (path) [Recommend
    /// models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter objectID: (path) Unique record (object) identifier.
    /// - returns: DeletedAtResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteRecommendRule(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> DeletedAtResponse {
        let response: Response<DeletedAtResponse> = try await deleteRecommendRuleWithHTTPInfo(
            indexName: indexName,
            model: model,
            objectID: objectID,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Delete a [Recommend rule](https://www.algolia.com/doc/guides/algolia-recommend/how-to/rules/).
    // Required API Key ACLs:
    //  - editSettings
    //
    // - parameter indexName: (path) Index on which to perform the request.
    //
    // - parameter model: (path) [Recommend
    // models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter objectID: (path) Unique record (object) identifier.
    // - returns: RequestBuilder<DeletedAtResponse>

    open func deleteRecommendRuleWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<DeletedAtResponse> {
        guard !indexName.isEmpty else {
            throw AlgoliaError.invalidArgument("indexName", "deleteRecommendRule")
        }

        guard !objectID.isEmpty else {
            throw AlgoliaError.invalidArgument("objectID", "deleteRecommendRule")
        }

        var resourcePath = "/1/indexes/{indexName}/{model}/recommend/rules/{objectID}"
        let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
        let indexNamePostEscape = indexNamePreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{indexName}",
            with: indexNamePostEscape,
            options: .literal,
            range: nil
        )
        let modelPreEscape = "\(APIHelper.mapValueToPathItem(model))"
        let modelPostEscape = modelPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{model}",
            with: modelPostEscape,
            options: .literal,
            range: nil
        )
        let objectIDPreEscape = "\(APIHelper.mapValueToPathItem(objectID))"
        let objectIDPostEscape = objectIDPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{objectID}",
            with: objectIDPostEscape,
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

    /// - parameter indexName: (path) Index on which to perform the request.
    /// - parameter model: (path) [Recommend
    /// models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter objectID: (path) Unique record (object) identifier.
    /// - returns: RuleResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getRecommendRule(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> RuleResponse {
        let response: Response<RuleResponse> = try await getRecommendRuleWithHTTPInfo(
            indexName: indexName,
            model: model,
            objectID: objectID,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Return a [Recommend rule](https://www.algolia.com/doc/guides/algolia-recommend/how-to/rules/).
    // Required API Key ACLs:
    //  - settings
    //
    // - parameter indexName: (path) Index on which to perform the request.
    //
    // - parameter model: (path) [Recommend
    // models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter objectID: (path) Unique record (object) identifier.
    // - returns: RequestBuilder<RuleResponse>

    open func getRecommendRuleWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<RuleResponse> {
        guard !indexName.isEmpty else {
            throw AlgoliaError.invalidArgument("indexName", "getRecommendRule")
        }

        guard !objectID.isEmpty else {
            throw AlgoliaError.invalidArgument("objectID", "getRecommendRule")
        }

        var resourcePath = "/1/indexes/{indexName}/{model}/recommend/rules/{objectID}"
        let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
        let indexNamePostEscape = indexNamePreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{indexName}",
            with: indexNamePostEscape,
            options: .literal,
            range: nil
        )
        let modelPreEscape = "\(APIHelper.mapValueToPathItem(model))"
        let modelPostEscape = modelPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{model}",
            with: modelPostEscape,
            options: .literal,
            range: nil
        )
        let objectIDPreEscape = "\(APIHelper.mapValueToPathItem(objectID))"
        let objectIDPostEscape = objectIDPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{objectID}",
            with: objectIDPostEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter indexName: (path) Index on which to perform the request.
    /// - parameter model: (path) [Recommend
    /// models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter taskID: (path) Unique identifier of a task. Numeric value (up to 64bits).
    /// - returns: GetRecommendTaskResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getRecommendStatus(
        indexName: String,
        model: RecommendModels,
        taskID: Int64,
        requestOptions: RequestOptions? = nil
    ) async throws -> GetRecommendTaskResponse {
        let response: Response<GetRecommendTaskResponse> = try await getRecommendStatusWithHTTPInfo(
            indexName: indexName,
            model: model,
            taskID: taskID,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Some operations, such as deleting a Recommend rule, will respond with a `taskID` value. Use this value here to
    // check the status of that task.
    // Required API Key ACLs:
    //  - editSettings
    //
    // - parameter indexName: (path) Index on which to perform the request.
    //
    // - parameter model: (path) [Recommend
    // models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter taskID: (path) Unique identifier of a task. Numeric value (up to 64bits).
    // - returns: RequestBuilder<GetRecommendTaskResponse>

    open func getRecommendStatusWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        taskID: Int64,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<GetRecommendTaskResponse> {
        guard !indexName.isEmpty else {
            throw AlgoliaError.invalidArgument("indexName", "getRecommendStatus")
        }

        var resourcePath = "/1/indexes/{indexName}/{model}/task/{taskID}"
        let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
        let indexNamePostEscape = indexNamePreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{indexName}",
            with: indexNamePostEscape,
            options: .literal,
            range: nil
        )
        let modelPreEscape = "\(APIHelper.mapValueToPathItem(model))"
        let modelPostEscape = modelPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{model}",
            with: modelPostEscape,
            options: .literal,
            range: nil
        )
        let taskIDPreEscape = "\(APIHelper.mapValueToPathItem(taskID))"
        let taskIDPostEscape = taskIDPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{taskID}",
            with: taskIDPostEscape,
            options: .literal,
            range: nil
        )
        let body: AnyCodable? = nil
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "GET",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions
        )
    }

    /// - parameter getRecommendationsParams: (body)
    /// - returns: GetRecommendationsResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getRecommendations(
        getRecommendationsParams: GetRecommendationsParams,
        requestOptions: RequestOptions? = nil
    ) async throws -> GetRecommendationsResponse {
        let response: Response<GetRecommendationsResponse> = try await getRecommendationsWithHTTPInfo(
            getRecommendationsParams: getRecommendationsParams,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Returns results from either recommendation or trending models:    - **Recommendations** are provided by the
    // [Related
    // Products](https://www.algolia.com/doc/guides/algolia-recommend/overview/#related-products-and-related-content)
    // and
    // [Frequently Bought
    // Together](https://www.algolia.com/doc/guides/algolia-recommend/overview/#frequently-bought-together) models   -
    // **Trending** models are [Trending Items and Trending Facet
    // Values](https://www.algolia.com/doc/guides/algolia-recommend/overview/#trending-items-and-trending-facet-values).
    // Required API Key ACLs:
    //  - search
    //
    // - parameter getRecommendationsParams: (body)
    // - returns: RequestBuilder<GetRecommendationsResponse>

    open func getRecommendationsWithHTTPInfo(
        getRecommendationsParams: GetRecommendationsParams,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<GetRecommendationsResponse> {
        let resourcePath = "/1/indexes/*/recommendations"
        let body = getRecommendationsParams
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body,
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions,
            useReadTransporter: true
        )
    }

    /// - parameter indexName: (path) Index on which to perform the request.
    /// - parameter model: (path) [Recommend
    /// models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter searchRecommendRulesParams: (body)  (optional)
    /// - returns: SearchRecommendRulesResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func searchRecommendRules(
        indexName: String,
        model: RecommendModels,
        searchRecommendRulesParams: SearchRecommendRulesParams? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> SearchRecommendRulesResponse {
        let response: Response<SearchRecommendRulesResponse> = try await searchRecommendRulesWithHTTPInfo(
            indexName: indexName,
            model: model,
            searchRecommendRulesParams: searchRecommendRulesParams,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // List [Recommend rules](https://www.algolia.com/doc/guides/algolia-recommend/how-to/rules/).
    // Required API Key ACLs:
    //  - settings
    //
    // - parameter indexName: (path) Index on which to perform the request.
    //
    // - parameter model: (path) [Recommend
    // models](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter searchRecommendRulesParams: (body)  (optional)
    // - returns: RequestBuilder<SearchRecommendRulesResponse>

    open func searchRecommendRulesWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        searchRecommendRulesParams: SearchRecommendRulesParams? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<SearchRecommendRulesResponse> {
        guard !indexName.isEmpty else {
            throw AlgoliaError.invalidArgument("indexName", "searchRecommendRules")
        }

        var resourcePath = "/1/indexes/{indexName}/{model}/recommend/rules/search"
        let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
        let indexNamePostEscape = indexNamePreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{indexName}",
            with: indexNamePostEscape,
            options: .literal,
            range: nil
        )
        let modelPreEscape = "\(APIHelper.mapValueToPathItem(model))"
        let modelPostEscape = modelPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{model}",
            with: modelPostEscape,
            options: .literal,
            range: nil
        )
        let body = searchRecommendRulesParams
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(headers: headers, queryParameters: queryParameters) + userRequestOptions,
            useReadTransporter: true
        )
    }
}

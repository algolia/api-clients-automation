// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

open class RecommendClient {
    private var configuration: RecommendClientConfiguration
    private var transporter: Transporter

    var appID: String {
        self.configuration.appID
    }

    public init(configuration: RecommendClientConfiguration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: RecommendClientConfiguration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(appID: String, apiKey: String) throws {
        try self.init(configuration: RecommendClientConfiguration(appID: appID, apiKey: apiKey))
    }

    open func setClientApiKey(apiKey: String) {
        self.configuration.apiKey = apiKey
        self.transporter.setClientApiKey(apiKey: apiKey)
    }

    /// - parameter indexName: (path) Name of the index on which to perform the operation.
    /// - parameter model: (path) [Recommend
    /// model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter recommendRule: (body)  (optional)
    /// - returns: RecommendUpdatedAtResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func batchRecommendRules(
        indexName: String,
        model: RecommendModels,
        recommendRule: [RecommendRule]? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> RecommendUpdatedAtResponse {
        let response: Response<RecommendUpdatedAtResponse> = try await batchRecommendRulesWithHTTPInfo(
            indexName: indexName,
            model: model,
            recommendRule: recommendRule,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Create or update a batch of Recommend Rules  Each Recommend Rule is created or updated, depending on whether a
    // Recommend Rule with the same `objectID` already exists. You may also specify `true` for `clearExistingRules`, in
    // which case the batch will atomically replace all the existing Recommend Rules.  Recommend Rules are similar to
    // Search Rules, except that the conditions and consequences apply to a [source
    // item](/doc/guides/algolia-recommend/overview/#recommend-models) instead of a query. The main differences are the
    // following: - Conditions `pattern` and `anchoring` are unavailable. - Condition `filters` triggers if the source item matches the specified filters. - Condition `filters` accepts numeric filters. - Consequence `params` only covers filtering parameters. - Consequence `automaticFacetFilters` doesn't require a facet value placeholder (it tries to match the data source item's attributes instead).
    // Required API Key ACLs:
    //  - editSettings
    //
    // - parameter indexName: (path) Name of the index on which to perform the operation.
    //
    // - parameter model: (path) [Recommend
    // model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter recommendRule: (body)  (optional)
    // - returns: RequestBuilder<RecommendUpdatedAtResponse>

    open func batchRecommendRulesWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        recommendRule: [RecommendRule]? = nil,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<RecommendUpdatedAtResponse> {
        guard !indexName.isEmpty else {
            throw AlgoliaError.invalidArgument("indexName", "batchRecommendRules")
        }

        var resourcePath = "/1/indexes/{indexName}/{model}/recommend/rules/batch"
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
        let body = recommendRule
        let queryParameters: [String: Any?]? = nil

        let nillableHeaders: [String: Any?]? = nil

        let headers = APIHelper.rejectNilHeaders(nillableHeaders)

        return try await self.transporter.send(
            method: "POST",
            path: resourcePath,
            data: body ?? AnyCodable(),
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
        )
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

    // This method lets you send requests to the Algolia REST API.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
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

    // This method lets you send requests to the Algolia REST API.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
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

    // This method lets you send requests to the Algolia REST API.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
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

    // This method lets you send requests to the Algolia REST API.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
        )
    }

    /// - parameter indexName: (path) Name of the index on which to perform the operation.
    /// - parameter model: (path) [Recommend
    /// model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter objectID: (path) Unique record identifier.
    /// - returns: RecommendDeletedAtResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteRecommendRule(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> RecommendDeletedAtResponse {
        let response: Response<RecommendDeletedAtResponse> = try await deleteRecommendRuleWithHTTPInfo(
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

    // Deletes a Recommend rule from a recommendation scenario.
    // Required API Key ACLs:
    //  - editSettings
    //
    // - parameter indexName: (path) Name of the index on which to perform the operation.
    //
    // - parameter model: (path) [Recommend
    // model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter objectID: (path) Unique record identifier.
    // - returns: RequestBuilder<RecommendDeletedAtResponse>

    open func deleteRecommendRuleWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<RecommendDeletedAtResponse> {
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
        )
    }

    /// - parameter indexName: (path) Name of the index on which to perform the operation.
    /// - parameter model: (path) [Recommend
    /// model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter objectID: (path) Unique record identifier.
    /// - returns: RecommendRule
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getRecommendRule(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> RecommendRule {
        let response: Response<RecommendRule> = try await getRecommendRuleWithHTTPInfo(
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

    // Retrieves a Recommend rule that you previously created in the Algolia dashboard.
    // Required API Key ACLs:
    //  - settings
    //
    // - parameter indexName: (path) Name of the index on which to perform the operation.
    //
    // - parameter model: (path) [Recommend
    // model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter objectID: (path) Unique record identifier.
    // - returns: RequestBuilder<RecommendRule>

    open func getRecommendRuleWithHTTPInfo(
        indexName: String,
        model: RecommendModels,
        objectID: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<RecommendRule> {
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
        )
    }

    /// - parameter indexName: (path) Name of the index on which to perform the operation.
    /// - parameter model: (path) [Recommend
    /// model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    /// - parameter taskID: (path) Unique task identifier.
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

    // Checks the status of a given task.  Deleting a Recommend rule is asynchronous. When you delete a rule, a task is
    // created on a queue and completed depending on the load on the server. The API response includes a task ID that
    // you
    // can use to check the status.
    // Required API Key ACLs:
    //  - editSettings
    //
    // - parameter indexName: (path) Name of the index on which to perform the operation.
    //
    // - parameter model: (path) [Recommend
    // model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    //
    // - parameter taskID: (path) Unique task identifier.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
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

    // Retrieves recommendations from selected AI models.
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions,
            useReadTransporter: true
        )
    }

    /// - parameter indexName: (path) Name of the index on which to perform the operation.
    /// - parameter model: (path) [Recommend
    /// model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
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

    // Searches for Recommend rules.  Use an empty query to list all rules for this recommendation scenario.
    // Required API Key ACLs:
    //  - settings
    //
    // - parameter indexName: (path) Name of the index on which to perform the operation.
    //
    // - parameter model: (path) [Recommend
    // model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions,
            useReadTransporter: true
        )
    }
}

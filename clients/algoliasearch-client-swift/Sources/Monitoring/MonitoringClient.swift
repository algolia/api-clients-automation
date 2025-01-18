// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

open class MonitoringClient {
    private var configuration: MonitoringClientConfiguration
    private var transporter: Transporter

    var appID: String {
        self.configuration.appID
    }

    public init(configuration: MonitoringClientConfiguration, transporter: Transporter) {
        self.configuration = configuration
        self.transporter = transporter
    }

    public convenience init(configuration: MonitoringClientConfiguration) {
        self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
    }

    public convenience init(appID: String, apiKey: String) throws {
        try self.init(configuration: MonitoringClientConfiguration(appID: appID, apiKey: apiKey))
    }

    open func setClientApiKey(apiKey: String) {
        self.configuration.apiKey = apiKey
        self.transporter.setClientApiKey(apiKey: apiKey)
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
            requestOptions: RequestOptions(
                headers: headers,
                queryParameters: queryParameters
            ) + userRequestOptions
        )
    }

    /// - parameter clusters: (path) Subset of clusters, separated by commas.
    /// - returns: IncidentsResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getClusterIncidents(
        clusters: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> IncidentsResponse {
        let response: Response<IncidentsResponse> = try await getClusterIncidentsWithHTTPInfo(
            clusters: clusters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves known incidents for the selected clusters.
    //
    //
    // - parameter clusters: (path) Subset of clusters, separated by commas.
    // - returns: RequestBuilder<IncidentsResponse>

    open func getClusterIncidentsWithHTTPInfo(
        clusters: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<IncidentsResponse> {
        guard !clusters.isEmpty else {
            throw AlgoliaError.invalidArgument("clusters", "getClusterIncidents")
        }

        var resourcePath = "/1/incidents/{clusters}"
        let clustersPreEscape = "\(APIHelper.mapValueToPathItem(clusters))"
        let clustersPostEscape = clustersPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{clusters}",
            with: clustersPostEscape,
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

    /// - parameter clusters: (path) Subset of clusters, separated by commas.
    /// - returns: StatusResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getClusterStatus(clusters: String, requestOptions: RequestOptions? = nil) async throws -> StatusResponse {
        let response: Response<StatusResponse> = try await getClusterStatusWithHTTPInfo(
            clusters: clusters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves the status of selected clusters.
    //
    //
    // - parameter clusters: (path) Subset of clusters, separated by commas.
    // - returns: RequestBuilder<StatusResponse>

    open func getClusterStatusWithHTTPInfo(
        clusters: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<StatusResponse> {
        guard !clusters.isEmpty else {
            throw AlgoliaError.invalidArgument("clusters", "getClusterStatus")
        }

        var resourcePath = "/1/status/{clusters}"
        let clustersPreEscape = "\(APIHelper.mapValueToPathItem(clusters))"
        let clustersPostEscape = clustersPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{clusters}",
            with: clustersPostEscape,
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

    /// - returns: IncidentsResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getIncidents(requestOptions: RequestOptions? = nil) async throws -> IncidentsResponse {
        let response: Response<IncidentsResponse> = try await getIncidentsWithHTTPInfo(requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves known incidents for all clusters.
    //
    //     - returns: RequestBuilder<IncidentsResponse>

    open func getIncidentsWithHTTPInfo(requestOptions userRequestOptions: RequestOptions? = nil) async throws
    -> Response<IncidentsResponse> {
        let resourcePath = "/1/incidents"
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

    /// - parameter clusters: (path) Subset of clusters, separated by commas.
    /// - returns: IndexingTimeResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getIndexingTime(
        clusters: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> IndexingTimeResponse {
        let response: Response<IndexingTimeResponse> = try await getIndexingTimeWithHTTPInfo(
            clusters: clusters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves average times for indexing operations for selected clusters.
    //
    //
    // - parameter clusters: (path) Subset of clusters, separated by commas.
    // - returns: RequestBuilder<IndexingTimeResponse>

    open func getIndexingTimeWithHTTPInfo(
        clusters: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<IndexingTimeResponse> {
        guard !clusters.isEmpty else {
            throw AlgoliaError.invalidArgument("clusters", "getIndexingTime")
        }

        var resourcePath = "/1/indexing/{clusters}"
        let clustersPreEscape = "\(APIHelper.mapValueToPathItem(clusters))"
        let clustersPostEscape = clustersPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{clusters}",
            with: clustersPostEscape,
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

    /// - parameter clusters: (path) Subset of clusters, separated by commas.
    /// - returns: LatencyResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getLatency(clusters: String, requestOptions: RequestOptions? = nil) async throws -> LatencyResponse {
        let response: Response<LatencyResponse> = try await getLatencyWithHTTPInfo(
            clusters: clusters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves the average latency for search requests for selected clusters.
    //
    //
    // - parameter clusters: (path) Subset of clusters, separated by commas.
    // - returns: RequestBuilder<LatencyResponse>

    open func getLatencyWithHTTPInfo(
        clusters: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<LatencyResponse> {
        guard !clusters.isEmpty else {
            throw AlgoliaError.invalidArgument("clusters", "getLatency")
        }

        var resourcePath = "/1/latency/{clusters}"
        let clustersPreEscape = "\(APIHelper.mapValueToPathItem(clusters))"
        let clustersPostEscape = clustersPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{clusters}",
            with: clustersPostEscape,
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

    /// - parameter metric: (path) Metric to report.  For more information about the individual metrics, see the
    /// description of the API response. To include all metrics, use `*`.
    /// - parameter period: (path) Period over which to aggregate the metrics:  - `minute`. Aggregate the last minute. 1
    /// data point per 10 seconds. - `hour`. Aggregate the last hour. 1 data point per minute. - `day`. Aggregate the
    /// last
    /// day. 1 data point per 10 minutes. - `week`. Aggregate the last week. 1 data point per hour. - `month`. Aggregate
    /// the last month. 1 data point per day.
    /// - returns: InfrastructureResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getMetrics(
        metric: Metric,
        period: Period,
        requestOptions: RequestOptions? = nil
    ) async throws -> InfrastructureResponse {
        let response: Response<InfrastructureResponse> = try await getMetricsWithHTTPInfo(
            metric: metric,
            period: period,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves metrics related to your Algolia infrastructure, aggregated over a selected time window.  Access to this
    // API is available as part of the [Premium or Elevate plans](https://www.algolia.com/pricing). You must
    // authenticate
    // requests with the `x-algolia-application-id` and `x-algolia-api-key` headers (using the Monitoring API key).
    //
    //
    // - parameter metric: (path) Metric to report.  For more information about the individual metrics, see the
    // description of the API response. To include all metrics, use `*`.
    //
    // - parameter period: (path) Period over which to aggregate the metrics:  - `minute`. Aggregate the last minute. 1
    // data point per 10 seconds. - `hour`. Aggregate the last hour. 1 data point per minute. - `day`. Aggregate the
    // last
    // day. 1 data point per 10 minutes. - `week`. Aggregate the last week. 1 data point per hour. - `month`. Aggregate
    // the last month. 1 data point per day.
    // - returns: RequestBuilder<InfrastructureResponse>

    open func getMetricsWithHTTPInfo(
        metric: Metric,
        period: Period,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<InfrastructureResponse> {
        var resourcePath = "/1/infrastructure/{metric}/period/{period}"
        let metricPreEscape = "\(APIHelper.mapValueToPathItem(metric))"
        let metricPostEscape = metricPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{metric}",
            with: metricPostEscape,
            options: .literal,
            range: nil
        )
        let periodPreEscape = "\(APIHelper.mapValueToPathItem(period))"
        let periodPostEscape = periodPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{period}",
            with: periodPostEscape,
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

    /// - parameter clusters: (path) Subset of clusters, separated by commas.
    /// - returns: [String: [String: Bool]]
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getReachability(
        clusters: String,
        requestOptions: RequestOptions? = nil
    ) async throws -> [String: [String: Bool]] {
        let response: Response<[String: [String: Bool]]> = try await getReachabilityWithHTTPInfo(
            clusters: clusters,
            requestOptions: requestOptions
        )

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Test whether clusters are reachable or not.
    //
    //
    // - parameter clusters: (path) Subset of clusters, separated by commas.
    // - returns: RequestBuilder<[String: [String: Bool]]>

    open func getReachabilityWithHTTPInfo(
        clusters: String,
        requestOptions userRequestOptions: RequestOptions? = nil
    ) async throws -> Response<[String: [String: Bool]]> {
        guard !clusters.isEmpty else {
            throw AlgoliaError.invalidArgument("clusters", "getReachability")
        }

        var resourcePath = "/1/reachability/{clusters}/probes"
        let clustersPreEscape = "\(APIHelper.mapValueToPathItem(clusters))"
        let clustersPostEscape = clustersPreEscape
            .addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(
            of: "{clusters}",
            with: clustersPostEscape,
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

    /// - returns: InventoryResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getServers(requestOptions: RequestOptions? = nil) async throws -> InventoryResponse {
        let response: Response<InventoryResponse> = try await getServersWithHTTPInfo(requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves the servers that belong to clusters.  The response depends on whether you authenticate your API
    // request:  - With authentication, the response lists the servers assigned to your Algolia application's cluster.  - Without authentication, the response lists the servers for all Algolia clusters.
    //
    //     - returns: RequestBuilder<InventoryResponse>

    open func getServersWithHTTPInfo(requestOptions userRequestOptions: RequestOptions? = nil) async throws
    -> Response<InventoryResponse> {
        let resourcePath = "/1/inventory/servers"
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

    /// - returns: StatusResponse
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getStatus(requestOptions: RequestOptions? = nil) async throws -> StatusResponse {
        let response: Response<StatusResponse> = try await getStatusWithHTTPInfo(requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    // Retrieves the status of all Algolia clusters and instances.
    //
    //     - returns: RequestBuilder<StatusResponse>

    open func getStatusWithHTTPInfo(requestOptions userRequestOptions: RequestOptions? = nil) async throws
    -> Response<StatusResponse> {
        let resourcePath = "/1/status"
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
}

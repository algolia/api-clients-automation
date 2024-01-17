// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

typealias Client = QuerySuggestionsClient

open class QuerySuggestionsClient {

  private var configuration: Configuration
  private var transporter: Transporter

  var applicationID: String {
    self.configuration.applicationID
  }

  public init(configuration: Configuration, transporter: Transporter) {
    self.configuration = configuration
    self.transporter = transporter
  }

  public convenience init(configuration: Configuration) {
    self.init(configuration: configuration, transporter: Transporter(configuration: configuration))
  }

  public convenience init(applicationID: String, apiKey: String, region: Region) {
    self.init(
      configuration: Configuration(applicationID: applicationID, apiKey: apiKey, region: region))
  }

  /**
     Create a configuration.

     - parameter querySuggestionsConfigurationWithIndex: (body)
     - returns: BaseResponse
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func createConfig(
    querySuggestionsConfigurationWithIndex: QuerySuggestionsConfigurationWithIndex,
    requestOptions: RequestOptions? = nil
  ) async throws -> BaseResponse {
    return try await createConfigWithHTTPInfo(
      querySuggestionsConfigurationWithIndex: querySuggestionsConfigurationWithIndex,
      requestOptions: requestOptions
    ).body
  }

  /**
     Create a configuration.

     Create a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.
     - parameter querySuggestionsConfigurationWithIndex: (body)
     - returns: RequestBuilder<BaseResponse>
     */

  open func createConfigWithHTTPInfo(
    querySuggestionsConfigurationWithIndex: QuerySuggestionsConfigurationWithIndex,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<BaseResponse> {
    let path = "/1/configs"
    let body = querySuggestionsConfigurationWithIndex

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "POST",
      path: path,
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
  open func customDelete(
    path: String, parameters: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil
  ) async throws -> AnyCodable {
    return try await customDeleteWithHTTPInfo(
      path: path, parameters: parameters, requestOptions: requestOptions
    ).body
  }

  /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

  open func customDeleteWithHTTPInfo(
    path: String, parameters: [String: AnyCodable]? = nil,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<AnyCodable> {
    var path = "/1{path}"
    let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
    let pathPostEscape =
      pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{path}", with: pathPostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems = APIHelper.mapValuesToQueryItems([
      "parameters": (wrappedValue: parameters?.encodeToJSON(), isExplode: true)
    ])

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "DELETE",
      path: path,
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
  open func customGet(
    path: String, parameters: [String: AnyCodable]? = nil, requestOptions: RequestOptions? = nil
  ) async throws -> AnyCodable {
    return try await customGetWithHTTPInfo(
      path: path, parameters: parameters, requestOptions: requestOptions
    ).body
  }

  /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

  open func customGetWithHTTPInfo(
    path: String, parameters: [String: AnyCodable]? = nil,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<AnyCodable> {
    var path = "/1{path}"
    let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
    let pathPostEscape =
      pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{path}", with: pathPostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems = APIHelper.mapValuesToQueryItems([
      "parameters": (wrappedValue: parameters?.encodeToJSON(), isExplode: true)
    ])

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "GET",
      path: path,
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
  open func customPost(
    path: String, parameters: [String: AnyCodable]? = nil, body: Codable? = nil,
    requestOptions: RequestOptions? = nil
  ) async throws -> AnyCodable {
    return try await customPostWithHTTPInfo(
      path: path, parameters: parameters, body: body, requestOptions: requestOptions
    ).body
  }

  /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

  open func customPostWithHTTPInfo(
    path: String, parameters: [String: AnyCodable]? = nil, body: Codable? = nil,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<AnyCodable> {
    var path = "/1{path}"
    let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
    let pathPostEscape =
      pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{path}", with: pathPostEscape, options: .literal, range: nil)
    let body = body

    let queryItems = APIHelper.mapValuesToQueryItems([
      "parameters": (wrappedValue: parameters?.encodeToJSON(), isExplode: true)
    ])

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "POST",
      path: path,
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
  open func customPut(
    path: String, parameters: [String: AnyCodable]? = nil, body: Codable? = nil,
    requestOptions: RequestOptions? = nil
  ) async throws -> AnyCodable {
    return try await customPutWithHTTPInfo(
      path: path, parameters: parameters, body: body, requestOptions: requestOptions
    ).body
  }

  /**
     Send requests to the Algolia REST API.

     This method allow you to send requests to the Algolia REST API.
     - parameter path: (path) Path of the endpoint, anything after \&quot;/1\&quot; must be specified.
     - parameter parameters: (query) Query parameters to apply to the current query. (optional)
     - parameter body: (body) Parameters to send with the custom request. (optional)
     - returns: RequestBuilder<AnyCodable>
     */

  open func customPutWithHTTPInfo(
    path: String, parameters: [String: AnyCodable]? = nil, body: Codable? = nil,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<AnyCodable> {
    var path = "/1{path}"
    let pathPreEscape = "\(APIHelper.mapValueToPathItem(path))"
    let pathPostEscape =
      pathPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{path}", with: pathPostEscape, options: .literal, range: nil)
    let body = body

    let queryItems = APIHelper.mapValuesToQueryItems([
      "parameters": (wrappedValue: parameters?.encodeToJSON(), isExplode: true)
    ])

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "PUT",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     Delete a configuration.

     - parameter indexName: (path) Query Suggestions index name.
     - returns: BaseResponse
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func deleteConfig(indexName: String, requestOptions: RequestOptions? = nil) async throws
    -> BaseResponse
  {
    return try await deleteConfigWithHTTPInfo(indexName: indexName, requestOptions: requestOptions)
      .body
  }

  /**
     Delete a configuration.

     Delete a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. The Query Suggestions index itself is not deleted.
     - parameter indexName: (path) Query Suggestions index name.
     - returns: RequestBuilder<BaseResponse>
     */

  open func deleteConfigWithHTTPInfo(
    indexName: String, requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<BaseResponse> {
    var path = "/1/configs/{indexName}"
    let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
    let indexNamePostEscape =
      indexNamePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{indexName}", with: indexNamePostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "DELETE",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     List configurations.

     - returns: [QuerySuggestionsConfigurationResponse]
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func getAllConfigs(requestOptions: RequestOptions? = nil) async throws
    -> [QuerySuggestionsConfigurationResponse]
  {
    return try await getAllConfigsWithHTTPInfo(requestOptions: requestOptions).body
  }

  /**
     List configurations.

     List all Query Suggestions configurations of your Algolia application.
     - returns: RequestBuilder<[QuerySuggestionsConfigurationResponse]>
     */

  open func getAllConfigsWithHTTPInfo(requestOptions userRequestOptions: RequestOptions? = nil)
    async throws -> Response<[QuerySuggestionsConfigurationResponse]>
  {
    let path = "/1/configs"
    let body: AnyCodable? = nil

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "GET",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     Get a configuration.

     - parameter indexName: (path) Query Suggestions index name.
     - returns: QuerySuggestionsConfigurationResponse
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func getConfig(indexName: String, requestOptions: RequestOptions? = nil) async throws
    -> QuerySuggestionsConfigurationResponse
  {
    return try await getConfigWithHTTPInfo(indexName: indexName, requestOptions: requestOptions)
      .body
  }

  /**
     Get a configuration.

     Get a single Query Suggestions configuration.
     - parameter indexName: (path) Query Suggestions index name.
     - returns: RequestBuilder<QuerySuggestionsConfigurationResponse>
     */

  open func getConfigWithHTTPInfo(
    indexName: String, requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<QuerySuggestionsConfigurationResponse> {
    var path = "/1/configs/{indexName}"
    let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
    let indexNamePostEscape =
      indexNamePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{indexName}", with: indexNamePostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "GET",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     Get configuration status.

     - parameter indexName: (path) Query Suggestions index name.
     - returns: GetConfigStatus200Response
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func getConfigStatus(indexName: String, requestOptions: RequestOptions? = nil) async throws
    -> GetConfigStatus200Response
  {
    return try await getConfigStatusWithHTTPInfo(
      indexName: indexName, requestOptions: requestOptions
    ).body
  }

  /**
     Get configuration status.

     Report the status of a Query Suggestions index.
     - parameter indexName: (path) Query Suggestions index name.
     - returns: RequestBuilder<GetConfigStatus200Response>
     */

  open func getConfigStatusWithHTTPInfo(
    indexName: String, requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<GetConfigStatus200Response> {
    var path = "/1/configs/{indexName}/status"
    let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
    let indexNamePostEscape =
      indexNamePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{indexName}", with: indexNamePostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "GET",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     Get logs.

     - parameter indexName: (path) Query Suggestions index name.
     - returns: GetLogFile200Response
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func getLogFile(indexName: String, requestOptions: RequestOptions? = nil) async throws
    -> GetLogFile200Response
  {
    return try await getLogFileWithHTTPInfo(indexName: indexName, requestOptions: requestOptions)
      .body
  }

  /**
     Get logs.

     Get the logs for a single Query Suggestions index.
     - parameter indexName: (path) Query Suggestions index name.
     - returns: RequestBuilder<GetLogFile200Response>
     */

  open func getLogFileWithHTTPInfo(
    indexName: String, requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<GetLogFile200Response> {
    var path = "/1/logs/{indexName}"
    let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
    let indexNamePostEscape =
      indexNamePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{indexName}", with: indexNamePostEscape, options: .literal, range: nil)
    let body: AnyCodable? = nil

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "GET",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }

  /**
     Update a configuration.

     - parameter indexName: (path) Query Suggestions index name.
     - parameter querySuggestionsConfiguration: (body)
     - returns: BaseResponse
     */
  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  open func updateConfig(
    indexName: String, querySuggestionsConfiguration: QuerySuggestionsConfiguration,
    requestOptions: RequestOptions? = nil
  ) async throws -> BaseResponse {
    return try await updateConfigWithHTTPInfo(
      indexName: indexName, querySuggestionsConfiguration: querySuggestionsConfiguration,
      requestOptions: requestOptions
    ).body
  }

  /**
     Update a configuration.

     Update a QuerySuggestions configuration.
     - parameter indexName: (path) Query Suggestions index name.
     - parameter querySuggestionsConfiguration: (body)
     - returns: RequestBuilder<BaseResponse>
     */

  open func updateConfigWithHTTPInfo(
    indexName: String, querySuggestionsConfiguration: QuerySuggestionsConfiguration,
    requestOptions userRequestOptions: RequestOptions? = nil
  ) async throws -> Response<BaseResponse> {
    var path = "/1/configs/{indexName}"
    let indexNamePreEscape = "\(APIHelper.mapValueToPathItem(indexName))"
    let indexNamePostEscape =
      indexNamePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
    path = path.replacingOccurrences(
      of: "{indexName}", with: indexNamePostEscape, options: .literal, range: nil)
    let body = querySuggestionsConfiguration

    let queryItems: [URLQueryItem]? = nil

    let nillableHeaders: [String: Any?]? = [:]

    let headers = APIHelper.rejectNilHeaders(nillableHeaders)

    return try await self.transporter.send(
      method: "PUT",
      path: path,
      data: body,
      requestOptions: RequestOptions(headers: headers, queryItems: queryItems) + userRequestOptions
    )
  }
}

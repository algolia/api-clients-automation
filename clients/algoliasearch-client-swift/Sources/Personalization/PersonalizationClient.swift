// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

typealias Client = PersonalizationClient

open class PersonalizationClient {
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

    public convenience init(appId: String, apiKey: String, region: Region) throws {
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
     - parameter userToken: (path) userToken representing the user for which to fetch the Personalization profile.
     - returns: DeleteUserProfileResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func deleteUserProfile(userToken: String, requestOptions: RequestOptions? = nil) async throws -> DeleteUserProfileResponse {
        let response: Response<DeleteUserProfileResponse> = try await deleteUserProfileWithHTTPInfo(userToken: userToken, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Delete the user profile and all its associated data.  Returns, as part of the response, a date until which the data can safely be considered as deleted for the given user. This means if you send events for the given user before this date, they will be ignored. Any data received after the deletedUntil date will start building a new user profile.  It might take a couple hours for the deletion request to be fully processed.

     Required API Key ACLs:
       - recommendation

     - parameter userToken: (path) userToken representing the user for which to fetch the Personalization profile.
     - returns: RequestBuilder<DeleteUserProfileResponse>
     */

    open func deleteUserProfileWithHTTPInfo(userToken: String, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<DeleteUserProfileResponse> {
        guard !userToken.isEmpty else {
            throw AlgoliaError.invalidArgument("userToken", "deleteUserProfile")
        }

        var resourcePath = "/1/profiles/{userToken}"
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
     - returns: PersonalizationStrategyParams
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getPersonalizationStrategy(requestOptions: RequestOptions? = nil) async throws -> PersonalizationStrategyParams {
        let response: Response<PersonalizationStrategyParams> = try await getPersonalizationStrategyWithHTTPInfo(requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     The strategy contains information on the events and facets that impact user profiles and personalized search results.

     Required API Key ACLs:
       - recommendation

     - returns: RequestBuilder<PersonalizationStrategyParams>
     */

    open func getPersonalizationStrategyWithHTTPInfo(requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<PersonalizationStrategyParams> {
        let resourcePath = "/1/strategies/personalization"
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
     - parameter userToken: (path) userToken representing the user for which to fetch the Personalization profile.
     - returns: GetUserTokenResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func getUserTokenProfile(userToken: String, requestOptions: RequestOptions? = nil) async throws -> GetUserTokenResponse {
        let response: Response<GetUserTokenResponse> = try await getUserTokenProfileWithHTTPInfo(userToken: userToken, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     Get the user profile built from Personalization strategy.  The profile is structured by facet name used in the strategy. Each facet value is mapped to its score. Each score represents the user affinity for a specific facet value given the userToken past events and the Personalization strategy defined. Scores are bounded to 20. The last processed event timestamp is provided using the ISO 8601 format for debugging purposes.

     Required API Key ACLs:
       - recommendation

     - parameter userToken: (path) userToken representing the user for which to fetch the Personalization profile.
     - returns: RequestBuilder<GetUserTokenResponse>
     */

    open func getUserTokenProfileWithHTTPInfo(userToken: String, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<GetUserTokenResponse> {
        guard !userToken.isEmpty else {
            throw AlgoliaError.invalidArgument("userToken", "getUserTokenProfile")
        }

        var resourcePath = "/1/profiles/personalization/{userToken}"
        let userTokenPreEscape = "\(APIHelper.mapValueToPathItem(userToken))"
        let userTokenPostEscape = userTokenPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAlgoliaAllowed) ?? ""
        resourcePath = resourcePath.replacingOccurrences(of: "{userToken}", with: userTokenPostEscape, options: .literal, range: nil)
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
     - parameter personalizationStrategyParams: (body)
     - returns: SetPersonalizationStrategyResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open func setPersonalizationStrategy(personalizationStrategyParams: PersonalizationStrategyParams, requestOptions: RequestOptions? = nil) async throws -> SetPersonalizationStrategyResponse {
        let response: Response<SetPersonalizationStrategyResponse> = try await setPersonalizationStrategyWithHTTPInfo(personalizationStrategyParams: personalizationStrategyParams, requestOptions: requestOptions)

        guard let body = response.body else {
            throw AlgoliaError.missingData
        }

        return body
    }

    /**
     A strategy defines the events and facets that impact user profiles and personalized search results.

     Required API Key ACLs:
       - recommendation

     - parameter personalizationStrategyParams: (body)
     - returns: RequestBuilder<SetPersonalizationStrategyResponse>
     */

    open func setPersonalizationStrategyWithHTTPInfo(personalizationStrategyParams: PersonalizationStrategyParams, requestOptions userRequestOptions: RequestOptions? = nil) async throws -> Response<SetPersonalizationStrategyResponse> {
        let resourcePath = "/1/strategies/personalization"
        let body = personalizationStrategyParams
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

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct QuerySuggestionsClientConfiguration: BaseConfiguration, Credentials {
    private let authorizedRegions: [Region] = [
        Region.eu, Region.us,
    ]

    public let appID: String
    public var apiKey: String
    public var writeTimeout: TimeInterval
    public var readTimeout: TimeInterval
    public var logLevel: LogLevel
    public var defaultHeaders: [String: String]?
    public var hosts: [RetryableHost]
    public let compression: CompressionAlgorithm

    public init(
        appID: String,
        apiKey: String,
        region: Region,
        writeTimeout: TimeInterval = 30,
        readTimeout: TimeInterval = 5,
        logLevel: LogLevel = DefaultConfiguration.default.logLevel,
        defaultHeaders: [String: String]? = DefaultConfiguration.default.defaultHeaders,
        hosts: [RetryableHost]? = nil
    ) throws {
        guard !appID.isEmpty else {
            throw AlgoliaError.invalidCredentials("appId")
        }

        guard !apiKey.isEmpty else {
            throw AlgoliaError.invalidCredentials("apiKey")
        }

        self.appID = appID
        self.apiKey = apiKey
        self.writeTimeout = writeTimeout
        self.readTimeout = readTimeout
        self.logLevel = logLevel
        self.defaultHeaders = [
            "X-Algolia-Application-Id": appID,
            "X-Algolia-API-Key": apiKey,
            "Content-Type": "application/json",
        ].merging(defaultHeaders ?? [:]) { _, new in new }
        self.compression = .none

        UserAgentController.append(UserAgent(title: "QuerySuggestions", version: Version.current.description))

        guard let hosts else {
            guard self.authorizedRegions.contains(region) else {
                throw AlgoliaError.runtimeError(
                    "`region` is required and must be one of the following: \(self.authorizedRegions.map(\.rawValue).joined(separator: ", "))"
                )
            }

            guard let url = URL(
                string: "https://query-suggestions.{region}.algolia.com"
                    .replacingOccurrences(of: "{region}", with: region.rawValue)
            ) else {
                throw AlgoliaError.runtimeError("Malformed URL")
            }

            self.hosts = [
                .init(url: url),
            ]
            return
        }

        self.hosts = hosts
    }
}

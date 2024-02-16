// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation
#if canImport(AnyCodable)
    import AnyCodable
#endif

typealias SearchClientConfiguration = Configuration

public struct Configuration: Core.Configuration, Credentials {
    public let appID: String
    public let apiKey: String
    public var writeTimeout: TimeInterval
    public var readTimeout: TimeInterval
    public var logLevel: LogLevel
    public var defaultHeaders: [String: String]?
    public var hosts: [RetryableHost]

    public let batchSize: Int

    init(
        appID: String,
        apiKey: String,
        writeTimeout: TimeInterval = DefaultConfiguration.default.writeTimeout,
        readTimeout: TimeInterval = DefaultConfiguration.default.readTimeout,
        logLevel: LogLevel = DefaultConfiguration.default.logLevel,
        defaultHeaders: [String: String]? = DefaultConfiguration.default.defaultHeaders,
        hosts: [RetryableHost]? = nil,
        batchSize: Int = 1000
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
        self.batchSize = batchSize

        UserAgentController.append(UserAgent(title: "Search", version: Version.current.description))

        guard let hosts else {
            func buildHost(_ components: (suffix: String, callType: RetryableHost.CallTypeSupport)) throws
            -> RetryableHost {
                guard let url = URL(string: "https://\(appID)\(components.suffix)") else {
                    throw AlgoliaError.runtimeError("Malformed URL")
                }

                return RetryableHost(url: url, callType: components.callType)
            }

            let hosts = try [
                ("-dsn.algolia.net", .read),
                (".algolia.net", .write),
            ].map(buildHost)

            let commonHosts = try [
                ("-1.algolianet.com", .universal),
                ("-2.algolianet.com", .universal),
                ("-3.algolianet.com", .universal),
            ].map(buildHost).shuffled()

            self.hosts = hosts + commonHosts

            return
        }

        self.hosts = hosts
    }
}

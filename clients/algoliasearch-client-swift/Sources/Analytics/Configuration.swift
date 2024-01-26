// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

public struct Configuration: Core.Configuration, Credentials {

  private let authorizedRegions: [Region] = [
    Region.de, Region.us,
  ]

  public let applicationID: String
  public let apiKey: String
  public var writeTimeout: TimeInterval
  public var readTimeout: TimeInterval
  public var logLevel: LogLevel
  public var defaultHeaders: [String: String]?
  public var hosts: [RetryableHost]

  init(
    applicationID: String,
    apiKey: String,
    region: Region? = nil,
    writeTimeout: TimeInterval = DefaultConfiguration.default.writeTimeout,
    readTimeout: TimeInterval = DefaultConfiguration.default.readTimeout,
    logLevel: LogLevel = DefaultConfiguration.default.logLevel,
    defaultHeaders: [String: String]? = DefaultConfiguration.default.defaultHeaders
  ) throws {
    self.applicationID = applicationID
    self.apiKey = apiKey
    self.writeTimeout = writeTimeout
    self.readTimeout = readTimeout
    self.logLevel = logLevel
    self.defaultHeaders = [
      "X-Algolia-Application-Id": applicationID,
      "X-Algolia-API-Key": apiKey,
      "Content-Type": "application/json",
    ].merging(defaultHeaders ?? [:]) { (_, new) in new }

    guard region == nil || authorizedRegions.contains(region!) else {
      throw GenericError(
        description:
          "`region` must be one of the following: \(authorizedRegions.map { $0.rawValue }.joined(separator: ", "))"
      )
    }

    if let region = region {
      guard
        let url = URL(
          string: "https://analytics.{region}.algolia.com".replacingOccurrences(
            of: "{region}", with: region.rawValue))
      else {
        throw GenericError(description: "Malformed URL")
      }

      self.hosts = [
        .init(url: url)
      ]
    } else {
      guard let url = URL(string: "https://analytics.algolia.com") else {
        throw GenericError(description: "Malformed URL")
      }

      self.hosts = [
        .init(url: url)
      ]
    }

    UserAgentController.append(UserAgent(title: "Analytics", version: Version.current.description))
  }
}

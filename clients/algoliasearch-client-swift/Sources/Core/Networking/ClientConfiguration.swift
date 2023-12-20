//
//  ClientConfiguration.swift
//
//
//  Created by Thomas Raffray on 15/12/2023.
//

import Foundation

public protocol CommonClientConfiguration {

  /// The timeout for each request when performing write operations (POST, PUT ..).
  var writeTimeout: TimeInterval { get }

  /// The timeout for each request when performing read operations (GET).
  var readTimeout: TimeInterval { get }

  /// LogLevel to display in the console.
  var logLevel: LogLevel { get }

  /// List of hosts and back-up host used to perform a custom retry logic.
  var hosts: [RetryableHost]! { get set }

  /// Default headers that should be applied to every request.
  var defaultHeaders: [String: String]? { get }

  var batchSize: Int { get }

}

extension CommonClientConfiguration {

  func timeout(for callType: CallType) -> TimeInterval {
    switch callType {
    case .read:
      return readTimeout
    case .write:
      return writeTimeout
    }
  }

}

public struct DefaultConfiguration: CommonClientConfiguration {

  public static let `default`: CommonClientConfiguration = DefaultConfiguration()

  public let writeTimeout: TimeInterval = 30
  public let readTimeout: TimeInterval = 5
  public let logLevel: LogLevel = .info
  public let defaultHeaders: [String: String]? = [:]
  public let batchSize: Int = 1000
  public var hosts: [RetryableHost]! = []

}

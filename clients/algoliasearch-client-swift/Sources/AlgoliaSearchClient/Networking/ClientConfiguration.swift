//
//  ClientConfiguration.swift
//
//
//  Created by Thomas Raffray on 15/12/2023.
//

import Foundation

public protocol ClientConfiguration {

  /// The timeout for each request when performing write operations (POST, PUT ..).
  var writeTimeout: TimeInterval { get }

  /// The timeout for each request when performing read operations (GET).
  var readTimeout: TimeInterval { get }

  /// LogLevel to display in the console.
  var logLevel: LogLevel { get }

  /// List of hosts and back-up host used to perform a custom retry logic.
  var hosts: [RetryableHost] { get set }

  /// Default headers that should be applied to every request.
  var defaultHeaders: [String: String]? { get }

  var batchSize: Int { get }

}

extension ClientConfiguration {

  func timeout(for callType: CallType) -> TimeInterval {
    switch callType {
    case .read:
      return readTimeout
    case .write:
      return writeTimeout
    }
  }

}

struct DefaultConfiguration: ClientConfiguration {

  static let `default`: ClientConfiguration = DefaultConfiguration()

  let writeTimeout: TimeInterval = 30
  let readTimeout: TimeInterval = 5
  let logLevel: LogLevel = .info
  var hosts: [RetryableHost] = []
  let defaultHeaders: [String: String]? = [:]
  let batchSize: Int = 1000

}

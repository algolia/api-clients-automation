// APIs.swift
//
// Created by Algolia on 08/01/2024
//

import Foundation

#if canImport(FoundationNetworking)
  import FoundationNetworking
#endif
open class Transporter {
  public static var customHeaders: [String: String] = [:]
  public static var credential: URLCredential?
  public static var requestBuilderFactory: RequestBuilderFactory = URLSessionRequestBuilderFactory()
  public static var apiResponseQueue: DispatchQueue = .main

  var configuration: Configuration
  var retryStrategy: RetryStrategy

  public init(configuration: Configuration, retryStrategy: RetryStrategy? = nil) {
    self.configuration = configuration
    self.retryStrategy = retryStrategy ?? AlgoliaRetryStrategy(configuration: configuration)
  }
}

open class RequestBuilder<T> {
  var credential: URLCredential?
  var headers: [String: String]
  public let parameters: [String: Any]?
  public let method: String
  public let path: String
  public let queryItems: [URLQueryItem]?
  public let requestTask: RequestTask = RequestTask()
  public let requiresAuthentication: Bool
  public let hostIterator: HostIterator

  public let transporter: Transporter

  /// Optional block to obtain a reference to the request's progress instance when available.
  public var onProgressReady: ((Progress) -> Void)?

  required public init(
    method: String, path: String, queryItems: [URLQueryItem]?, parameters: [String: Any]?,
    headers: [String: String] = [:],
    requiresAuthentication: Bool, transporter: Transporter
  ) {
    self.method = method
    self.path = path
    self.queryItems = queryItems
    self.parameters = parameters
    self.headers = headers
    self.requiresAuthentication = requiresAuthentication
    self.transporter = transporter

    let httpMethod = HTTPMethod(rawValue: method)

    guard let httpMethod = httpMethod else {
      fatalError("Unknown HTTP method: '\(method)'")
    }

    self.hostIterator = transporter.retryStrategy.retryableHosts(for: httpMethod.toCallType())
  }

  open func addHeaders(_ aHeaders: [String: String]) {
    for (header, value) in aHeaders {
      headers[header] = value
    }
  }

  @discardableResult
  open func execute(
    _ apiResponseQueue: DispatchQueue = Transporter.apiResponseQueue,
    _ completion: @escaping (_ result: Swift.Result<Response<T>, ErrorResponse>) -> Void
  ) -> RequestTask {
    return requestTask
  }

  @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
  @discardableResult
  open func execute() async throws -> Response<T> {
    return try await withTaskCancellationHandler {
      try Task.checkCancellation()
      return try await withCheckedThrowingContinuation { continuation in
        guard !Task.isCancelled else {
          continuation.resume(throwing: CancellationError())
          return
        }

        self.execute { result in
          switch result {
          case let .success(response):
            continuation.resume(returning: response)
          case let .failure(error):
            continuation.resume(throwing: error)
          }
        }
      }
    } onCancel: {
      self.requestTask.cancel()
    }
  }

  public func addHeader(name: String, value: String) -> Self {
    if !value.isEmpty {
      headers[name] = value
    }
    return self
  }

  open func addCredential() -> Self {
    credential = Transporter.credential
    return self
  }
}

public protocol RequestBuilderFactory {
  func getNonDecodableBuilder<T>() -> RequestBuilder<T>.Type
  func getBuilder<T: Decodable>() -> RequestBuilder<T>.Type
}

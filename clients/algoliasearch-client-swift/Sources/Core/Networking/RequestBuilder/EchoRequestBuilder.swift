//
//  EchoRequestBuilder.swift
//
//
//  Created by Algolia on 12/01/2024.
//

import Foundation

public struct EchoResponse<T: Decodable>: Decodable {
  let statusCode: HTTPStatusСode
  let url: String
  let timeout: TimeInterval
  let data: T?
  let path: String
  let host: String
  let algoliaAgent: String
  let queryItems: [String: String?]?
}

final class EchoRequestBuilder: RequestBuilder {
  let statusCode: HTTPStatusСode

  public init() {
    self.statusCode = 200
  }

  public init(statusCode: HTTPStatusСode) {
    self.statusCode = statusCode
  }

  final func execute<T: Decodable>(urlRequest: URLRequest, timeout: TimeInterval) async throws
    -> Response<T>
  {

    let headers = urlRequest.allHTTPHeaderFields ?? [:]

    guard let url = urlRequest.url else {
      throw TransportError.requestError(
        AlgoliaError(errorMessage: "Unable to parse URL from request"))
    }

    guard let httpBody = urlRequest.httpBody else {
      throw TransportError.missingData
    }

    let typedBody: T = try CodableHelper.jsonDecoder.decode(T.self, from: httpBody)

    guard
      let mockHTTPURLResponse = HTTPURLResponse(
        url: url, statusCode: self.statusCode, httpVersion: nil, headerFields: headers)
    else {
      throw TransportError.requestError(
        AlgoliaError(errorMessage: "Unable to mock HTTPURLResponse from EchoTransporter"))
    }

    return Response(response: mockHTTPURLResponse, body: typedBody, bodyData: httpBody)
  }

  final func execute<T: Decodable>(urlRequest: URLRequest, timeout: TimeInterval) async throws
    -> EchoResponse<T>
  {
    let response: Response<T> = try await self.execute(urlRequest: urlRequest, timeout: timeout)

    guard let url = urlRequest.url else {
      throw AlgoliaError(errorMessage: "Malformed URL")
    }

    let headers = urlRequest.allHTTPHeaderFields ?? [:]

    return EchoResponse(
      statusCode: self.statusCode, url: url.absoluteString, timeout: timeout,
      data: response.body, path: url.path, host: url.host ?? "",
      algoliaAgent: headers["X-Algolia-Agent"] ?? "",
      queryItems: url.query?.propertyListFromStringsFileFormat()
    )
  }

}

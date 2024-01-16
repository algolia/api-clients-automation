//
//  RequestBuilder.swift
//
//
//  Created by Algolia on 16/01/2024.
//

import Foundation

public protocol RequestBuilder {
  init()

  func execute<T: Decodable>(urlRequest: URLRequest, timeout: TimeInterval) async throws
    -> Response<T>
}

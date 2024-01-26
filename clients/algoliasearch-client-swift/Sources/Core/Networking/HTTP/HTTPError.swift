//
//  HTTPError.swift
//
//
//  Created by Algolia on 02/03/2020.
//

import Foundation

#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif

public struct HTTPError: Error, CustomStringConvertible {
    public let statusCode: HTTPStatusСode
    public let message: ErrorMessage?

    public init?(response: HTTPURLResponse?, data: Data?) {
        guard let response = response, !response.statusCode.belongs(to: .success) else {
            return nil
        }

        let message = data.flatMap { try? JSONDecoder().decode(ErrorMessage.self, from: $0) }
        self.init(statusCode: response.statusCode, message: message)
    }

    public init(statusCode: HTTPStatusСode, message: ErrorMessage?) {
        self.statusCode = statusCode
        self.message = message
    }

    public var description: String {
        "Status code: \(statusCode) Message: \(message?.description ?? "No message")"
    }
}

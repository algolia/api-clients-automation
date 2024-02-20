//
//  Retry.swift
//
//
//  Created by Algolia on 19/02/2024.
//

import Foundation

public func retryUntil<T>(
    retry: () async throws -> T,
    until: (T) -> Bool,
    maxRetries: Int? = 50,
    initialDelay: TimeInterval? = 0.2,
    maxDelay: TimeInterval? = 5.0
) async throws -> T {
    var currentRetries = 0
    var currentDelay = initialDelay ?? 0.2

    let maxRetriesValue = maxRetries ?? 50
    let maxDelayValue = maxDelay ?? 5.0

    while currentRetries < maxRetriesValue {
        do {
            let result = try await retry()

            if until(result) {
                return result
            }

            try await Task.sleep(nanoseconds: UInt64(currentDelay) * 1_000_000_000)

            currentDelay *= 2
            currentDelay = min(currentDelay, maxDelayValue)

            currentRetries += 1
        } catch {
            throw error
        }
    }

    throw AlgoliaError.wait
}

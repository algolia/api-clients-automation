//
//  RateLimitRetry.swift
//

import Foundation

/// Shared 429 Retry-After wait helpers used by the transporter and generated
/// client configurations.
public enum RateLimitRetry {
    static let defaultWaitNanoseconds: UInt64 = 1_000_000_000
    public static let defaultMaxRetries = 3

    /// `Retry-After` as a wait in nanoseconds.
    /// Only a positive whole-number-of-seconds string is honored; anything else
    /// (missing, `0`, HTTP-date, junk) waits 1s.
    static func waitNanoseconds(from headers: [String: String]?) -> UInt64 {
        let raw = headers?.first {
            $0.key.caseInsensitiveCompare("Retry-After") == .orderedSame
        }?.value.trimmingCharacters(in: .whitespacesAndNewlines)

        guard let raw, !raw.isEmpty, raw.allSatisfy({ $0 >= "0" && $0 <= "9" }),
              let seconds = UInt64(raw), seconds > 0 else {
            return self.defaultWaitNanoseconds
        }

        let (nanos, overflow) = seconds.multipliedReportingOverflow(by: 1_000_000_000)
        return overflow ? UInt64.max : nanos
    }

    static func isRateLimited(_ error: Error) -> Bool {
        guard case let .httpError(httpError) as AlgoliaError = error else {
            return false
        }

        return httpError.statusCode == HTTPStatusСode.tooManyRequests
    }
}

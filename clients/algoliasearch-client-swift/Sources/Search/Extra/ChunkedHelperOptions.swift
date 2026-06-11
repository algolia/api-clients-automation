//
//  ChunkedHelperOptions.swift
//
//
//  Created by Algolia on 25/05/2026.
//

import Foundation

/// Options shared by the chunked helpers (`chunkedBatch`, `saveObjects`,
/// `deleteObjects`, `partialUpdateObjects`, `replaceAllObjects`, and their
/// `WithTransformation` variants).
///
/// Designed to grow: additional shared configuration (e.g. custom timeouts)
/// can be added here without ballooning each helper's signature.
public struct ChunkedHelperOptions {
    /// Default maximum number of retries used by every chunked helper and the
    /// `waitFor*` family when the caller does not provide a value.
    public static let defaultMaxRetries: Int = 100

    /// Maximum number of retries forwarded to every nested `waitForTask`
    /// call performed by the chunked helpers. When `nil`, the helpers fall
    /// back to ``defaultMaxRetries``.
    public let maxRetries: Int?

    public init(maxRetries: Int? = nil) {
        self.maxRetries = maxRetries
    }
}

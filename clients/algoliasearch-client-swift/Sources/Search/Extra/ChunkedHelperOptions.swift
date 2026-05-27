//
//  ChunkedHelperOptions.swift
//  AlgoliaSearchClient
//
//  Created by Algolia on 27/05/2026.
//

import Foundation

/// Options for tuning the behaviour of the chunked / long-polling search helpers
/// (`chunkedBatch`, `saveObjects`, `deleteObjects`, `partialUpdateObjects`,
/// `replaceAllObjects`). Designed to grow — single field today; future shared
/// helper configuration (e.g. `pollInterval`, `batchSize` defaults) can be added
/// without changing every helper signature.
public struct ChunkedHelperOptions {
    /// Maximum number of retries when polling for task completion. Defaults to 100.
    public var maxRetries: Int

    public init(maxRetries: Int = 100) {
        self.maxRetries = maxRetries
    }
}

//
//  IngestionChunkedPushExtension.swift
//
//
//  Created by Algolia on 26/05/2026.
//

#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
import AlgoliaIngestion
import Foundation

public extension IngestionClient {
    /// Helper: Chunks `objects` into batches of at most `batchSize` records and pushes each batch
    /// through the Transformation pipeline using the Push connector.
    ///
    /// - parameter indexName: The name of the destination index.
    /// - parameter objects: The records to push.
    /// - parameter action: The ingestion action to apply to each record. Defaults to `.addObject`.
    /// - parameter waitForTasks: When `true`, the helper waits for each push to finish before
    ///   sending the next batch.
    /// - parameter batchSize: The maximum number of records per batch.
    /// - parameter referenceIndexName: Optional reference index name used when targeting an index
    ///   without a push connector but reusing another index's transformation.
    /// - parameter requestOptions: The request options.
    /// - returns: an array of ``IngestionWatchResponse`` — one per pushed batch.
    @discardableResult
    func chunkedPush(
        indexName: String,
        objects: [some Encodable],
        action: IngestionAction = .addObject,
        waitForTasks: Bool = false,
        batchSize: Int = 1000,
        referenceIndexName: String? = nil,
        requestOptions: RequestOptions? = nil
    ) async throws -> [IngestionWatchResponse] {
        let batches = stride(from: 0, to: objects.count, by: batchSize).map {
            Array(objects[$0 ..< min($0 + batchSize, objects.count)])
        }

        var responses: [IngestionWatchResponse] = []
        for batch in batches {
            let records: [PushTaskRecords] = try batch.map { try Self.toPushTaskRecords($0) }
            let response = try await self.push(
                indexName: indexName,
                pushTaskPayload: PushTaskPayload(action: action, records: records),
                watch: waitForTasks,
                referenceIndexName: referenceIndexName,
                requestOptions: requestOptions
            )
            responses.append(response)
        }

        return responses
    }

    /// Encodes an arbitrary ``Encodable`` value as a ``PushTaskRecords`` instance.
    ///
    /// Each object must encode to a JSON object containing an `objectID` field — the Push API
    /// requires it to address records. Matches the Scala/PHP behaviour of failing fast when the
    /// key is missing.
    private static func toPushTaskRecords(_ value: some Encodable) throws -> PushTaskRecords {
        let data = try JSONEncoder().encode(value)
        guard let json = try JSONSerialization.jsonObject(with: data) as? [String: Any] else {
            throw AlgoliaError.runtimeError("Each object passed to `chunkedPush` must encode to a JSON object.")
        }

        guard let rawObjectID = json["objectID"] else {
            throw AlgoliaError.runtimeError("each object must have an `objectID` key in order to be indexed")
        }

        let objectID = "\(rawObjectID)"
        var record = PushTaskRecords(objectID: objectID)
        for (key, rawValue) in json where key != "objectID" {
            record[key] = AnyCodable(rawValue)
        }
        return record
    }
}

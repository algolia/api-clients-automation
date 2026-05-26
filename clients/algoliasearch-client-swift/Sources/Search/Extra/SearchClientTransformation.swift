//
//  SearchClientTransformation.swift
//
//
//  Created by Algolia on 26/05/2026.
//

#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
import AlgoliaIngestion
import Foundation

/// Storage for the per-client ingestion transporter used by the `*WithTransformation` helpers.
///
/// `SearchClient` is a generated `open class` whose stored properties cannot be extended from a
/// hand-written file. Instead we keep a class-level map keyed by the client's identity so the
/// helpers below can look up (and replace) the transporter on a per-instance basis without
/// modifying the generated source.
enum TransformationStorage {
    private static var clients: [ObjectIdentifier: IngestionClient] = [:]
    private static let queue = DispatchQueue(
        label: "com.algolia.search.transformation-storage",
        attributes: .concurrent
    )

    static func get(_ owner: AnyObject) -> IngestionClient? {
        var result: IngestionClient?
        self.queue.sync {
            result = self.clients[ObjectIdentifier(owner)]
        }
        return result
    }

    static func set(_ owner: AnyObject, _ client: IngestionClient?) {
        self.queue.sync(flags: .barrier) {
            if let client {
                self.clients[ObjectIdentifier(owner)] = client
            } else {
                self.clients.removeValue(forKey: ObjectIdentifier(owner))
            }
        }
    }
}

public extension SearchClient {
    /// The ingestion transporter that powers the `*WithTransformation` helpers, or `nil` when
    /// ``setTransformationOptions(_:)`` has not been called.
    var ingestionTransporter: IngestionClient? {
        TransformationStorage.get(self)
    }

    /// Builds a ``SearchClient`` with an eagerly-initialised ingestion transporter for the
    /// `*WithTransformation` helpers.
    ///
    /// The ingestion transporter is created using the Ingestion API defaults; only fields
    /// explicitly set on ``TransformationOptions/configuration`` override those defaults. The
    /// parent search client's configuration is never forwarded.
    ///
    /// - parameter appID: Algolia application identifier.
    /// - parameter apiKey: Algolia API key.
    /// - parameter transformationOptions: Options describing the ingestion transporter.
    /// - returns: a fully configured ``SearchClient`` whose ``ingestionTransporter`` is set.
    static func withTransformation(
        appID: String,
        apiKey: String,
        transformationOptions: TransformationOptions
    ) throws -> SearchClient {
        let client = try SearchClient(appID: appID, apiKey: apiKey)
        try client.setTransformationOptions(transformationOptions)
        return client
    }

    /// Sets (or replaces) the ingestion transporter used by the `*WithTransformation` helpers.
    ///
    /// Builds from the Ingestion API defaults; only fields the caller set on
    /// ``TransformationOptions/configuration`` override those defaults — the parent
    /// ``SearchClientConfiguration`` is never forwarded. If an ingestion transporter already
    /// exists for this client it is discarded and replaced.
    ///
    /// - parameter transformationOptions: Options describing the ingestion transporter.
    func setTransformationOptions(_ transformationOptions: TransformationOptions) throws {
        let ingestionConfiguration: IngestionClientConfiguration
        if let configuration = transformationOptions.configuration {
            ingestionConfiguration = configuration
        } else {
            ingestionConfiguration = try IngestionClientConfiguration(
                appID: self.configuration.appID,
                apiKey: self.configuration.apiKey,
                region: transformationOptions.region
            )
        }

        TransformationStorage.set(self, IngestionClient(configuration: ingestionConfiguration))
    }

    /// Helper: Saves objects to an Algolia index by leveraging the Transformation pipeline setup
    /// using the Push connector. Requires an ingestion transporter — provide one via
    /// ``withTransformation(appID:apiKey:transformationOptions:)`` at construction time or via
    /// ``setTransformationOptions(_:)``.
    ///
    /// - parameter indexName: The name of the index where to save the objects.
    /// - parameter objects: The new objects.
    /// - parameter waitForTasks: If the helper should wait for each push task to finish before
    ///   sending the next batch.
    /// - parameter batchSize: The maximum number of objects to include in a batch.
    /// - parameter requestOptions: The request options.
    /// - returns: an array of ``IngestionWatchResponse`` — one per ingested batch.
    @discardableResult
    func saveObjectsWithTransformation(
        indexName: String,
        objects: [some Encodable],
        waitForTasks: Bool = false,
        batchSize: Int = 1000,
        requestOptions: RequestOptions? = nil
    ) async throws -> [IngestionWatchResponse] {
        guard let ingestionTransporter = self.ingestionTransporter else {
            throw AlgoliaError.runtimeError(
                "`transformationOptions` must be set on `SearchClientConfiguration` before creating the client, or via `SearchClient.setTransformationOptions(...)` before calling this method. It defaults to the Ingestion API defaults. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion/"
            )
        }

        return try await ingestionTransporter.chunkedPush(
            indexName: indexName,
            objects: objects,
            action: .addObject,
            waitForTasks: waitForTasks,
            batchSize: batchSize,
            referenceIndexName: nil,
            requestOptions: requestOptions
        )
    }

    /// Helper: Partially updates objects in an Algolia index by leveraging the Transformation
    /// pipeline setup using the Push connector. Requires an ingestion transporter — provide one
    /// via ``withTransformation(appID:apiKey:transformationOptions:)`` or
    /// ``setTransformationOptions(_:)``.
    ///
    /// - parameter indexName: The name of the index to update.
    /// - parameter objects: The objects to update.
    /// - parameter createIfNotExists: When `true`, missing records are created.
    /// - parameter waitForTasks: If the helper should wait for each push task to finish.
    /// - parameter batchSize: The maximum number of objects per batch.
    /// - parameter requestOptions: The request options.
    /// - returns: an array of ``IngestionWatchResponse`` — one per ingested batch.
    @discardableResult
    func partialUpdateObjectsWithTransformation(
        indexName: String,
        objects: [some Encodable],
        createIfNotExists: Bool = false,
        waitForTasks: Bool = false,
        batchSize: Int = 1000,
        requestOptions: RequestOptions? = nil
    ) async throws -> [IngestionWatchResponse] {
        guard let ingestionTransporter = self.ingestionTransporter else {
            throw AlgoliaError.runtimeError(
                "`transformationOptions` must be set on `SearchClientConfiguration` before creating the client, or via `SearchClient.setTransformationOptions(...)` before calling this method. It defaults to the Ingestion API defaults. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion/"
            )
        }

        return try await ingestionTransporter.chunkedPush(
            indexName: indexName,
            objects: objects,
            action: createIfNotExists ? .partialUpdateObject : .partialUpdateObjectNoCreate,
            waitForTasks: waitForTasks,
            batchSize: batchSize,
            referenceIndexName: nil,
            requestOptions: requestOptions
        )
    }

    /// Helper: Replaces all records in an Algolia index by leveraging the Transformation pipeline
    /// setup using the Push connector. Requires an ingestion transporter — provide one via
    /// ``withTransformation(appID:apiKey:transformationOptions:)`` or
    /// ``setTransformationOptions(_:)``.
    ///
    /// - parameter indexName: The name of the index where to replace the objects.
    /// - parameter objects: The new objects.
    /// - parameter batchSize: The maximum number of objects per batch.
    /// - parameter scopes: The scopes to keep on the destination index.
    /// - parameter requestOptions: The request options.
    /// - returns: ``ReplaceAllObjectsWithTransformationResponse`` describing the copy/push/move steps.
    @discardableResult
    func replaceAllObjectsWithTransformation(
        indexName: String,
        objects: [some Encodable],
        batchSize: Int = 1000,
        scopes: [ScopeType] = [.settings, .rules, .synonyms],
        requestOptions: RequestOptions? = nil
    ) async throws -> ReplaceAllObjectsWithTransformationResponse {
        guard let ingestionTransporter = self.ingestionTransporter else {
            throw AlgoliaError.runtimeError(
                "`transformationOptions` must be set on `SearchClientConfiguration` before creating the client, or via `SearchClient.setTransformationOptions(...)` before calling this method. It defaults to the Ingestion API defaults. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion/"
            )
        }

        let tmpIndexName = "\(indexName)_tmp_\(Int.random(in: 1_000_000 ..< 10_000_000))"

        do {
            var copyOperationResponse = try await operationIndex(
                indexName: indexName,
                operationIndexParams: OperationIndexParams(
                    operation: .copy,
                    destination: tmpIndexName,
                    scope: scopes
                ),
                requestOptions: requestOptions
            )

            let watchResponses = try await ingestionTransporter.chunkedPush(
                indexName: tmpIndexName,
                objects: objects,
                action: .addObject,
                waitForTasks: true,
                batchSize: batchSize,
                referenceIndexName: indexName,
                requestOptions: requestOptions
            )

            try await self.waitForTask(indexName: tmpIndexName, taskID: copyOperationResponse.taskID)

            copyOperationResponse = try await operationIndex(
                indexName: indexName,
                operationIndexParams: OperationIndexParams(
                    operation: .copy,
                    destination: tmpIndexName,
                    scope: scopes
                ),
                requestOptions: requestOptions
            )
            try await self.waitForTask(indexName: tmpIndexName, taskID: copyOperationResponse.taskID)

            let moveOperationResponse = try await self.operationIndex(
                indexName: tmpIndexName,
                operationIndexParams: OperationIndexParams(
                    operation: .move,
                    destination: indexName
                ),
                requestOptions: requestOptions
            )
            try await self.waitForTask(indexName: tmpIndexName, taskID: moveOperationResponse.taskID)

            return ReplaceAllObjectsWithTransformationResponse(
                copyOperationResponse: copyOperationResponse,
                watchResponses: watchResponses.map(Self.toSearchWatchResponse),
                moveOperationResponse: moveOperationResponse
            )
        } catch {
            _ = try? await self.deleteIndex(indexName: tmpIndexName)

            throw error
        }
    }

    /// Converts an ``IngestionWatchResponse`` to its sibling ``SearchWatchResponse`` (the search
    /// API ships its own copy of the response type so search consumers don't have to import the
    /// ingestion module). The two structs are field-equivalent except for the `events` payload,
    /// which we drop because the search-side ``SearchEvent`` type is generated from a different
    /// schema.
    private static func toSearchWatchResponse(_ response: IngestionWatchResponse) -> SearchWatchResponse {
        SearchWatchResponse(
            runID: response.runID,
            eventID: response.eventID,
            data: response.data,
            events: nil,
            message: response.message,
            createdAt: response.createdAt
        )
    }
}

import 'dart:math';

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_ingestion/algolia_client_ingestion.dart'
    as ingestion;
import 'package:algolia_client_search/src/api/search_client.dart';
import 'package:algolia_client_search/src/extension/wait_task.dart';
import 'package:algolia_client_search/src/model/event.dart';
import 'package:algolia_client_search/src/model/event_status.dart';
import 'package:algolia_client_search/src/model/event_type.dart';
import 'package:algolia_client_search/src/model/operation_index_params.dart';
import 'package:algolia_client_search/src/model/operation_type.dart';
import 'package:algolia_client_search/src/model/replace_all_objects_with_transformation_response.dart';
import 'package:algolia_client_search/src/model/scope_type.dart';
import 'package:algolia_client_search/src/model/watch_response.dart';

extension Transformation on SearchClient {
  static const _notSetError =
      'transformationOptions must be set in the client config before calling this method.'
      ' It defaults to the Ingestion API defaults.'
      ' See https://www.algolia.com/doc/libraries/sdk/methods/ingestion';

  /// Chunks [objects] and pushes them through the Ingestion pipeline with [action].
  Future<List<WatchResponse>> chunkedPush({
    required String indexName,
    required Iterable<Map<String, dynamic>> objects,
    required ingestion.Action action,
    bool waitForTasks = false,
    int batchSize = 1000,
    String? referenceIndexName,
    ChunkedHelperOptions? chunkedOptions,
    RequestOptions? requestOptions,
  }) async {
    if (batchSize < 1) {
      throw ArgumentError('`batchSize` must be greater than 0');
    }
    final transporter = ingestionTransporter;
    if (transporter == null) throw StateError(_notSetError);

    final maxRetries = chunkedOptions?.maxRetries ?? defaultMaxRetries;
    final responses = <WatchResponse>[];
    final batch = <ingestion.PushTaskRecords>[];
    final pollInterval = (batchSize ~/ 10).clamp(1, batchSize);
    int polledUpTo = 0;

    final iter = objects.iterator;
    if (!iter.moveNext()) return responses;

    while (true) {
      batch.add(_toRecord(iter.current));
      final isLast = !iter.moveNext();

      if (batch.length == batchSize || isLast) {
        final raw = await transporter.push(
          indexName: indexName,
          pushTaskPayload: ingestion.PushTaskPayload(
              action: action, records: List.of(batch)),
          referenceIndexName: referenceIndexName,
          requestOptions: requestOptions,
        );
        responses.add(_convertWatchResponse(raw));
        batch.clear();

        if (waitForTasks && (responses.length % pollInterval == 0 || isLast)) {
          await _pollBatch(
            transporter: transporter,
            responses: responses,
            from: polledUpTo,
            to: responses.length,
            maxRetries: maxRetries,
            requestOptions: requestOptions,
          );
          polledUpTo = responses.length;
        }
      }

      if (isLast) break;
    }

    return responses;
  }

  /// Saves objects through the Ingestion pipeline. Requires [TransformationOptions] to be set.
  Future<List<WatchResponse>> saveObjectsWithTransformation({
    required String indexName,
    required Iterable<Map<String, dynamic>> objects,
    bool waitForTasks = false,
    int batchSize = 1000,
    ChunkedHelperOptions? chunkedOptions,
    RequestOptions? requestOptions,
  }) {
    return chunkedPush(
      indexName: indexName,
      objects: objects,
      action: ingestion.Action.addObject,
      waitForTasks: waitForTasks,
      batchSize: batchSize,
      chunkedOptions: chunkedOptions,
      requestOptions: requestOptions,
    );
  }

  /// Partially updates objects through the Ingestion pipeline. Requires [TransformationOptions] to be set.
  Future<List<WatchResponse>> partialUpdateObjectsWithTransformation({
    required String indexName,
    required Iterable<Map<String, dynamic>> objects,
    bool createIfNotExists = true,
    bool waitForTasks = false,
    int batchSize = 1000,
    ChunkedHelperOptions? chunkedOptions,
    RequestOptions? requestOptions,
  }) {
    return chunkedPush(
      indexName: indexName,
      objects: objects,
      action: createIfNotExists
          ? ingestion.Action.partialUpdateObject
          : ingestion.Action.partialUpdateObjectNoCreate,
      waitForTasks: waitForTasks,
      batchSize: batchSize,
      chunkedOptions: chunkedOptions,
      requestOptions: requestOptions,
    );
  }

  /// Replaces all objects in [indexName] via the Ingestion pipeline without downtime.
  /// Requires [TransformationOptions] to be set.
  Future<ReplaceAllObjectsWithTransformationResponse>
      replaceAllObjectsWithTransformation({
    required String indexName,
    required Iterable<Map<String, dynamic>> objects,
    int batchSize = 1000,
    List<ScopeType>? scopes,
    ChunkedHelperOptions? chunkedOptions,
    RequestOptions? requestOptions,
  }) async {
    if (ingestionTransporter == null) throw StateError(_notSetError);

    final effectiveChunkedOptions = chunkedOptions ??
        ChunkedHelperOptions(maxRetries: defaultReplaceAllObjectsMaxRetries);
    final effectiveMaxRetries = effectiveChunkedOptions.maxRetries;
    final effectiveScopes =
        scopes ?? [ScopeType.settings, ScopeType.rules, ScopeType.synonyms];
    final tmpIndex = '${indexName}_tmp_${Random().nextInt(900000) + 100000}';

    try {
      var copyResponse = await operationIndex(
        indexName: indexName,
        operationIndexParams: OperationIndexParams(
          operation: OperationType.copy,
          destination: tmpIndex,
          scope: effectiveScopes,
        ),
        requestOptions: requestOptions,
      );

      final watchResponses = await chunkedPush(
        indexName: tmpIndex,
        objects: objects,
        action: ingestion.Action.addObject,
        waitForTasks: true,
        batchSize: batchSize,
        chunkedOptions: effectiveChunkedOptions,
        referenceIndexName: indexName,
        requestOptions: requestOptions,
      );

      await waitTask(
        indexName: tmpIndex,
        taskID: copyResponse.taskID,
        params: WaitParams(maxRetries: effectiveMaxRetries),
        requestOptions: requestOptions,
      );

      copyResponse = await operationIndex(
        indexName: indexName,
        operationIndexParams: OperationIndexParams(
          operation: OperationType.copy,
          destination: tmpIndex,
          scope: effectiveScopes,
        ),
        requestOptions: requestOptions,
      );
      await waitTask(
        indexName: tmpIndex,
        taskID: copyResponse.taskID,
        params: WaitParams(maxRetries: effectiveMaxRetries),
        requestOptions: requestOptions,
      );

      final moveResponse = await operationIndex(
        indexName: tmpIndex,
        operationIndexParams: OperationIndexParams(
          operation: OperationType.move,
          destination: indexName,
        ),
        requestOptions: requestOptions,
      );
      await waitTask(
        indexName: tmpIndex,
        taskID: moveResponse.taskID,
        params: WaitParams(maxRetries: effectiveMaxRetries),
        requestOptions: requestOptions,
      );

      return ReplaceAllObjectsWithTransformationResponse(
        copyOperationResponse: copyResponse,
        watchResponses: watchResponses,
        moveOperationResponse: moveResponse,
      );
    } catch (_) {
      try {
        await deleteIndex(indexName: tmpIndex);
      } catch (_) {}
      rethrow;
    }
  }
}

Future<void> _pollBatch({
  required ingestion.IngestionClient transporter,
  required List<WatchResponse> responses,
  required int from,
  required int to,
  required int maxRetries,
  RequestOptions? requestOptions,
}) async {
  for (final resp in responses.sublist(from, to)) {
    final eventID = resp.eventID;
    if (eventID == null) continue;
    await _waitForEvent(
      transporter: transporter,
      runID: resp.runID,
      eventID: eventID,
      maxRetries: maxRetries,
      requestOptions: requestOptions,
    );
  }
}

/// Polls the Ingestion API for a single event until it becomes available,
/// retrying while `getEvent` returns a 404.
Future<void> _waitForEvent({
  required ingestion.IngestionClient transporter,
  required String runID,
  required String eventID,
  required int maxRetries,
  RequestOptions? requestOptions,
}) async {
  await waitUntil(
    retry: () async {
      try {
        return await transporter.getEvent(
          runID: runID,
          eventID: eventID,
          requestOptions: requestOptions,
        );
      } on AlgoliaApiException catch (e) {
        if (e.statusCode == 404) return null;
        rethrow;
      }
    },
    until: (event) => event != null,
    params: WaitParams(maxRetries: maxRetries),
  );
}

ingestion.PushTaskRecords _toRecord(Map<String, dynamic> obj) {
  final objectID = obj['objectID'];
  if (objectID == null || objectID is! String) {
    throw ArgumentError(
        'each object must have an `objectID` key in order to be indexed');
  }
  final rest = Map<String, dynamic>.from(obj)..remove('objectID');
  return ingestion.PushTaskRecords(
      objectID: objectID, additionalProperties: rest);
}

WatchResponse _convertWatchResponse(ingestion.WatchResponse r) {
  return WatchResponse(
    runID: r.runID,
    eventID: r.eventID,
    data: r.data,
    events: r.events
        ?.map((e) => Event(
              eventID: e.eventID,
              runID: e.runID,
              status: e.status != null
                  ? EventStatus.fromJson(e.status!.toJson())
                  : null,
              type: EventType.fromJson(e.type.toJson()),
              batchSize: e.batchSize,
              data: e.data,
              publishedAt: e.publishedAt,
            ))
        .toList(),
    message: r.message,
    createdAt: r.createdAt,
  );
}

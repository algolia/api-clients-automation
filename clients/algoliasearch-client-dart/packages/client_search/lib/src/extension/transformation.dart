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
    final transporter = ingestionTransporter;
    if (transporter == null) throw StateError(_notSetError);

    final raw = await transporter.chunkedPush(
      indexName: indexName,
      objects: objects,
      action: action,
      waitForTasks: waitForTasks,
      batchSize: batchSize,
      referenceIndexName: referenceIndexName,
      chunkedOptions: chunkedOptions,
      requestOptions: requestOptions,
    );
    return raw.map(_convertWatchResponse).toList();
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
    ChunkedHelperOptions? chunkedOptions,
    List<ScopeType>? scopes,
    RequestOptions? requestOptions,
  }) async {
    if (ingestionTransporter == null) throw StateError(_notSetError);

    final effectiveMaxRetries = chunkedOptions?.maxRetries ?? defaultMaxRetries;
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
        chunkedOptions: chunkedOptions,
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

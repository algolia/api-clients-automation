import 'package:algolia_client_core/algolia_client_core.dart';

import 'api/ingestion_client.dart';
import 'model/action.dart';
import 'model/push_task_payload.dart';
import 'model/push_task_records.dart';
import 'model/watch_response.dart';

extension IngestionClientExt on IngestionClient {
  /// Chunks [objects] and pushes them through the Ingestion pipeline with [action].
  Future<List<WatchResponse>> chunkedPush({
    required String indexName,
    required Iterable<Map<String, dynamic>> objects,
    required Action action,
    bool waitForTasks = false,
    int batchSize = 1000,
    String? referenceIndexName,
    ChunkedHelperOptions? chunkedOptions,
    RequestOptions? requestOptions,
  }) async {
    if (batchSize < 1) throw ArgumentError('`batchSize` must be greater than 0');
    final effectiveMaxRetries = chunkedOptions?.maxRetries ?? defaultMaxRetries;

    final responses = <WatchResponse>[];
    final batch = <PushTaskRecords>[];
    final pollInterval = (batchSize ~/ 10).clamp(1, batchSize);
    int polledUpTo = 0;

    final iter = objects.iterator;
    if (!iter.moveNext()) return responses;

    while (true) {
      batch.add(_toRecord(iter.current));
      final isLast = !iter.moveNext();

      if (batch.length == batchSize || isLast) {
        final response = await push(
          indexName: indexName,
          pushTaskPayload: PushTaskPayload(action: action, records: List.of(batch)),
          referenceIndexName: referenceIndexName,
          requestOptions: requestOptions,
        );
        responses.add(response);
        batch.clear();

        if (waitForTasks && (responses.length % pollInterval == 0 || isLast)) {
          await _pollBatch(
            transporter: this,
            responses: responses,
            from: polledUpTo,
            to: responses.length,
            maxRetries: effectiveMaxRetries,
            requestOptions: requestOptions,
          );
          polledUpTo = responses.length;
        }
      }

      if (isLast) break;
    }

    return responses;
  }
}

Future<void> _pollBatch({
  required IngestionClient transporter,
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

Future<void> _waitForEvent({
  required IngestionClient transporter,
  required String runID,
  required String eventID,
  required int maxRetries,
  RequestOptions? requestOptions,
}) async {
  for (var retries = 0; retries < maxRetries; retries++) {
    try {
      await transporter.getEvent(
        runID: runID,
        eventID: eventID,
        requestOptions: requestOptions,
      );
      return;
    } on AlgoliaApiException catch (e) {
      if (e.statusCode != 404) rethrow;
    }
    await Future<void>.delayed(
      Duration(milliseconds: (retries * 1500).clamp(0, 5000)),
    );
  }
  throw StateError(
    'The maximum number of retries exceeded. ($maxRetries/$maxRetries)',
  );
}

PushTaskRecords _toRecord(Map<String, dynamic> obj) {
  final objectID = obj['objectID'];
  if (objectID == null || objectID is! String) {
    throw ArgumentError('each object must have an `objectID` key in order to be indexed');
  }
  final rest = Map<String, dynamic>.from(obj)..remove('objectID');
  return PushTaskRecords(objectID: objectID, additionalProperties: rest);
}

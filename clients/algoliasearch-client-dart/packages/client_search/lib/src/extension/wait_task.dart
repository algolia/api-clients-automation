import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_search/src/api/search_client.dart';
import 'package:algolia_client_search/src/extension/retry.dart';
import 'package:algolia_client_search/src/model/api_key.dart';
import 'package:algolia_client_search/src/model/task_status.dart';

extension WaitTask on SearchClient {
  /// Wait for a [taskID] to complete before executing the next line of code, to synchronize index
  /// updates. All write operations in Algolia are asynchronous by design. It means that when you add
  /// or update an object to your index, our servers will reply to your request with a [taskID] as soon
  /// as they understood the write operation. The actual insert and indexing will be done after
  /// replying to your code. You can wait for a task to complete by using the [taskID] and this method.
  void waitTask({
    required String indexName,
    required int taskID,
    int maxRetries = 50,
    Duration? timeout,
    Duration initialDelay = const Duration(milliseconds: 200),
    Duration maxDelay = const Duration(seconds: 5),
    RequestOptions? requestOptions,
  }) async {
    await retryUntil(
      retry: () => getTask(
        indexName: indexName,
        taskID: taskID,
        requestOptions: requestOptions,
      ),
      until: (response) => response.status == TaskStatus.published,
      timeout: timeout,
      maxRetries: maxRetries,
      initialDelay: initialDelay,
      maxDelay: maxDelay,
    );
  }

  /// Wait on an API key update operation.
  void waitKeyUpdate({
    required String key,
    required ApiKey apiKey,
    int maxRetries = 50,
    Duration? timeout,
    Duration initialDelay = const Duration(milliseconds: 200),
    Duration maxDelay = const Duration(seconds: 5),
    RequestOptions? requestOptions,
  }) async {
    await retryUntil(
      retry: () => getApiKey(key: key, requestOptions: requestOptions),
      until: (response) =>
          apiKey ==
          ApiKey(
            acl: response.acl,
            description: response.description,
            indexes: response.indexes,
            maxHitsPerQuery: response.maxHitsPerQuery,
            maxQueriesPerIPPerHour: response.maxQueriesPerIPPerHour,
            queryParameters: response.queryParameters,
            referers: response.referers,
            validity: response.validity,
          ),
      timeout: timeout,
      maxRetries: maxRetries,
      initialDelay: initialDelay,
      maxDelay: maxDelay,
    );
  }

  ///  Wait on an API key creation operation.
  void waitKeyCreation({
    required String key,
    int maxRetries = 50,
    Duration? timeout,
    Duration initialDelay = const Duration(milliseconds: 200),
    Duration maxDelay = const Duration(seconds: 5),
    RequestOptions? requestOptions,
  }) async {
    await retryUntil(
      retry: () {
        try {
          return getApiKey(key: key, requestOptions: requestOptions);
        } on AlgoliaApiException catch (_) {
          return Future.value(null);
        }
      },
      until: (result) => result != null,
      timeout: timeout,
      maxRetries: maxRetries,
      initialDelay: initialDelay,
      maxDelay: maxDelay,
    );
  }

  /// Wait on a delete API ket operation.
  void waitKeyDeletion({
    required String key,
    int maxRetries = 50,
    Duration? timeout,
    Duration initialDelay = const Duration(milliseconds: 200),
    Duration maxDelay = const Duration(seconds: 5),
    RequestOptions? requestOptions,
  }) async {
    await retryUntil(
      retry: () {
        try {
          return getApiKey(key: key, requestOptions: requestOptions);
        } on AlgoliaApiException catch (e) {
          return Future.value(e);
        }
      },
      until: (result) =>
          result is AlgoliaApiException ? result.statusCode == 404 : false,
      timeout: timeout,
      maxRetries: maxRetries,
      initialDelay: initialDelay,
      maxDelay: maxDelay,
    );
  }
}

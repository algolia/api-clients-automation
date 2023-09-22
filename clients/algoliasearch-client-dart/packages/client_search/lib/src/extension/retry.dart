import 'package:algolia_client_core/algolia_client_core.dart';

/// Retries the given [retry] function until the [until] condition is satisfied or the maximum number
/// of [maxRetries] or [timeout] is reached.
Future<T> retryUntil<T>({
  required Future<T> Function() retry,
  required bool Function(T) until,
  required int maxRetries,
  required Duration? timeout,
  required Duration initialDelay,
  required Duration maxDelay,
}) async {
  Future<T> wait() async {
    var currentDelay = initialDelay;
    for (var i = 0; i < maxRetries; i++) {
      var result = await retry();
      if (until(result)) return result;
      await Future.delayed(currentDelay);
      var newDelay = currentDelay * 2;
      currentDelay = newDelay < maxDelay ? newDelay : maxDelay;
    }
    throw AlgoliaWaitException(
        "The maximum number of retries ($maxRetries) exceeded");
  }

  return timeout == null
      ? wait()
      : wait().timeout(
          timeout,
          onTimeout: () => throw Exception("Timeout of $timeout ms exceeded"),
        );
}

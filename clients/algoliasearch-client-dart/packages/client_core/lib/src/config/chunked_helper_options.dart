/// Default maximum number of retries for chunked helpers and wait operations.
const int defaultMaxRetries = 100;

/// Default maximum number of retries used by `replaceAllObjects`.
const int defaultReplaceAllObjectsMaxRetries = 800;

/// Optional configuration for chunked helpers that batch records and poll for task completion.
///
/// Designed to grow over time; future shared helper config (e.g. timeout) can be
/// added here without widening every helper's parameter list.
final class ChunkedHelperOptions {
  /// Maximum number of retries when polling for task completion.
  /// Defaults to [defaultMaxRetries].
  final int maxRetries;

  ChunkedHelperOptions({int? maxRetries})
      : maxRetries = maxRetries ?? defaultMaxRetries {
    if (this.maxRetries < 1) {
      throw ArgumentError('`maxRetries` must be greater than 0');
    }
  }
}

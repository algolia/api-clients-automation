package algoliasearch.extension

/** Optional configuration shared across chunked helpers that batch records and poll for task completion.
  *
  * Designed to grow over time; future shared helper config (e.g. batchSize, timeout) should be added here instead of
  * widening every helper's parameter list.
  *
  * @param maxRetries
  *   The maximum number of retries when polling for task completion. Defaults to
  *   [[ChunkedHelperOptions.DefaultMaxRetries]].
  */
case class ChunkedHelperOptions(
    maxRetries: Int = ChunkedHelperOptions.DefaultMaxRetries
)

object ChunkedHelperOptions {

  /** The default maximum number of retries for chunked helpers polling for task completion. */
  val DefaultMaxRetries: Int = 100

  /** The default maximum number of retries for `replaceAllObjects` polling for task completion. */
  val DefaultReplaceAllObjectsMaxRetries: Int = 800
}

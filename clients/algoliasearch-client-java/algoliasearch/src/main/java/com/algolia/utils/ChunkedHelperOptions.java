package com.algolia.utils;

/** Optional configuration for chunked helpers that batch records and poll for task completion. */
public class ChunkedHelperOptions {

  /** Default maximum number of retries used by {@code replaceAllObjects}. */
  public static final int DEFAULT_REPLACE_ALL_OBJECTS_MAX_RETRIES = 800;

  private int maxRetries = TaskUtils.DEFAULT_MAX_RETRIES;
  private int maxConcurrency = 1;

  /**
   * Returns the maximum number of retries for polling task completion.
   *
   * @return the maximum number of retries.
   */
  public int getMaxRetries() {
    return maxRetries;
  }

  /**
   * Sets the maximum number of retries for polling task completion.
   *
   * @param maxRetries must be greater than 0.
   * @return this instance for chaining.
   */
  public ChunkedHelperOptions setMaxRetries(int maxRetries) {
    if (maxRetries < 1) {
      throw new IllegalArgumentException("`maxRetries` must be greater than 0");
    }
    this.maxRetries = maxRetries;
    return this;
  }

  /**
   * Returns the maximum number of batch chunks in flight concurrently.
   *
   * @return the maximum concurrency.
   */
  public int getMaxConcurrency() {
    return maxConcurrency;
  }

  /**
   * Sets the maximum number of batch chunks in flight concurrently for the chunked batch helpers.
   * Defaults to 1 (sequential, exact v4 semantics).
   *
   * <p>Honored by {@code chunkedBatch} / {@code saveObjects} / {@code partialUpdateObjects} /
   * {@code deleteObjects} (both synchronous and {@code *Async} variants), and by {@code
   * replaceAllObjects}' batch phase (it passes the caller's chunked options through to {@code
   * chunkedBatch}). Ignored by {@code chunkedPush} and the {@code *WithTransformation} helpers.
   *
   * <p>With {@code maxConcurrency > 1}, cross-chunk ordering (including duplicate-objectID
   * last-write-wins across chunks in the same wave) is not guaranteed, and one failed chunk fails
   * the operation while sibling in-flight chunks still execute.
   *
   * @param maxConcurrency must be greater than 0; values less than 1 throw {@link
   *     IllegalArgumentException}.
   * @return this instance for chaining.
   */
  public ChunkedHelperOptions setMaxConcurrency(int maxConcurrency) {
    if (maxConcurrency < 1) {
      throw new IllegalArgumentException("`maxConcurrency` must be greater than 0");
    }
    this.maxConcurrency = maxConcurrency;
    return this;
  }
}

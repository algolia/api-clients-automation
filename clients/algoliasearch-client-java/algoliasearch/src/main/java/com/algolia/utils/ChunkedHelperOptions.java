package com.algolia.utils;

/** Optional configuration for chunked helpers that batch records and poll for task completion. */
public class ChunkedHelperOptions {

  private int maxRetries = TaskUtils.DEFAULT_MAX_RETRIES;

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
}

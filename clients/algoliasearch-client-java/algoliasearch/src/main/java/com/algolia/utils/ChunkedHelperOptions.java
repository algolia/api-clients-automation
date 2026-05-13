package com.algolia.utils;

/** Optional configuration for chunked helpers that batch records and poll for task completion. */
public class ChunkedHelperOptions {

  private int maxRetries = TaskUtils.DEFAULT_MAX_RETRIES;

  public int getMaxRetries() {
    return maxRetries;
  }

  public ChunkedHelperOptions setMaxRetries(int maxRetries) {
    this.maxRetries = maxRetries;
    return this;
  }
}

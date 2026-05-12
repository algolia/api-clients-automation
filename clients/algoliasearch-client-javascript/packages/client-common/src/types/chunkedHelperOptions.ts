/**
 * Shared configuration for chunked helpers that poll for task completion.
 * Designed to grow over time so future helper configs can be added without ballooning option types.
 */
export type ChunkedHelperOptions = {
  /**
   * The maximum number of retries when polling for task completion. 100 by default.
   */
  maxRetries?: number | undefined;
};

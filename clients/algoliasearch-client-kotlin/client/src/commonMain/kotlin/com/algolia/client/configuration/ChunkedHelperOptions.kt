package com.algolia.client.configuration

/**
 * Optional configuration for chunked helpers that batch records and poll for task completion.
 *
 * Designed to grow over time; future shared helper config (e.g. `timeout`, `batchSize` defaults)
 * should be added here instead of widening every helper's parameter list.
 *
 * @param maxRetries Maximum number of retries when polling for task completion. Defaults to 100.
 */
public data class ChunkedHelperOptions(
  public val maxRetries: Int = 100,
)

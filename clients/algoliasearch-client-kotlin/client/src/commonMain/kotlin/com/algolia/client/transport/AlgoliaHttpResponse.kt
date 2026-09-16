package com.algolia.client.transport

import io.ktor.util.*

/**
 * Holds the full HTTP response information of an executed request: status code, headers, raw body
 * and deserialized body.
 *
 * @param T The type of the deserialized response body.
 * @param statusCode The HTTP status code of the response.
 * @param headers The HTTP response headers.
 * @param body The raw response body, or `null` when the response has no content (e.g. HTTP 204).
 * @param data The deserialized response body, or `null` when the response has no content (e.g. HTTP
 *   204).
 */
public class AlgoliaHttpResponse<out T>(
  public val statusCode: Int,
  headers: Map<String, List<String>>,
  public val body: String?,
  public val data: T?,
) {
  /** The HTTP response headers. Key lookups are case-insensitive. */
  public val headers: Map<String, List<String>> =
    CaseInsensitiveMap<List<String>>().apply { putAll(headers) }
}

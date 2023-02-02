package com.algolia.client.transport

import kotlinx.serialization.json.JsonObject

/**
 * Represents options for configuring a request to an endpoint.
 *
 * @property writeTimeout The write timeout for the request in milliseconds.
 * @property readTimeout The read timeout for the request in milliseconds.
 * @property headers A mutable map of header names to their respective values to be sent with the request.
 * @property urlParameters A mutable map of URL parameter names to their respective values to be appended to the request URL.
 * @property body A JSON object representing the request body.
 */
public data class RequestOptions(
  public val writeTimeout: Long? = null,
  public val readTimeout: Long? = null,
  public val headers: Map<String, Any> = emptyMap(),
  public val urlParameters: Map<String, Any> = emptyMap(),
  public val body: JsonObject? = null,
)

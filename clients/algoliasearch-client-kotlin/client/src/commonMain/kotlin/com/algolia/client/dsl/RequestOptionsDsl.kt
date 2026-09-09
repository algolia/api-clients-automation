package com.algolia.client.dsl

import com.algolia.client.transport.RequestOptions
import kotlin.time.Duration
import kotlinx.serialization.json.JsonObject

/**
 * Builds a [RequestOptions] value with a Kotlin DSL.
 *
 * The resulting value is the existing immutable transport type. This builder does not change
 * [RequestOptions].
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class RequestOptionsDsl {
  /** The write timeout for the request. */
  public var writeTimeout: Duration? = null

  /** The read timeout for the request. */
  public var readTimeout: Duration? = null

  /** The connect timeout for the request. */
  public var connectTimeout: Duration? = null

  /** Headers to send with the request. */
  public var headers: Map<String, Any> = emptyMap()

  /** URL parameters to append to the request URL. */
  public var urlParameters: Map<String, Any> = emptyMap()

  /** A JSON object representing the request body. */
  public var body: JsonObject? = null

  internal fun build(): RequestOptions =
    RequestOptions(
      writeTimeout = writeTimeout,
      readTimeout = readTimeout,
      connectTimeout = connectTimeout,
      headers = headers,
      urlParameters = urlParameters,
      body = body,
    )
}

/** Constructs a [RequestOptions] value from the DSL block. */
@AlgoliaExperimentalDsl
public fun requestOptions(block: RequestOptionsDsl.() -> Unit): RequestOptions =
  RequestOptionsDsl().apply(block).build()

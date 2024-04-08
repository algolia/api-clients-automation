/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Log
 *
 * @param timestamp Date and time of the API request, in RFC 3339 format.
 * @param method HTTP method of the request.
 * @param answerCode HTTP status code of the response.
 * @param queryBody Request body.
 * @param answer Response body.
 * @param url URL of the API endpoint.
 * @param ip IP address of the client that performed the request.
 * @param queryHeaders Request headers (API keys are obfuscated).
 * @param sha1 SHA1 signature of the log entry.
 * @param nbApiCalls Number of API requests.
 * @param processingTimeMs Processing time for the query in milliseconds. This doesn't include latency due to the network.
 * @param index Index targeted by the query.
 * @param queryParams Query parameters sent with the request.
 * @param queryNbHits Number of search results (hits) returned for the query.
 * @param innerQueries Queries performed for the given request.
 */
@Serializable
public data class Log(

  /** Date and time of the API request, in RFC 3339 format. */
  @SerialName(value = "timestamp") val timestamp: String,

  /** HTTP method of the request. */
  @SerialName(value = "method") val method: String,

  /** HTTP status code of the response. */
  @SerialName(value = "answer_code") val answerCode: String,

  /** Request body. */
  @SerialName(value = "query_body") val queryBody: String,

  /** Response body. */
  @SerialName(value = "answer") val answer: String,

  /** URL of the API endpoint. */
  @SerialName(value = "url") val url: kotlin.String,

  /** IP address of the client that performed the request. */
  @SerialName(value = "ip") val ip: String,

  /** Request headers (API keys are obfuscated). */
  @SerialName(value = "query_headers") val queryHeaders: String,

  /** SHA1 signature of the log entry. */
  @SerialName(value = "sha1") val sha1: String,

  /** Number of API requests. */
  @SerialName(value = "nb_api_calls") val nbApiCalls: String,

  /** Processing time for the query in milliseconds. This doesn't include latency due to the network.  */
  @SerialName(value = "processing_time_ms") val processingTimeMs: String,

  /** Index targeted by the query. */
  @SerialName(value = "index") val index: String? = null,

  /** Query parameters sent with the request. */
  @SerialName(value = "query_params") val queryParams: String? = null,

  /** Number of search results (hits) returned for the query. */
  @SerialName(value = "query_nb_hits") val queryNbHits: String? = null,

  /** Queries performed for the given request. */
  @SerialName(value = "inner_queries") val innerQueries: List<LogQuery>? = null,
)

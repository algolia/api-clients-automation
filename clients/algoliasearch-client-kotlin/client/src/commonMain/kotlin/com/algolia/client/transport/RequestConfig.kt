package com.algolia.client.transport

import io.ktor.util.reflect.*

/** Defines a config object for a given request. */
public data class RequestConfig(
  val method: RequestMethod,
  val pathSegments: List<String>,
  val isRead: Boolean = false,
  val headers: Map<String, Any> = emptyMap(),
  val query: Map<String, Any> = emptyMap(),
  val body: RequestBody? = null,
)

/** Create a [RequestConfig] instance. * */
public inline fun <reified T> RequestConfig(
  method: RequestMethod,
  pathSegments: List<String>,
  isRead: Boolean = false,
  headers: Map<String, String> = emptyMap(),
  query: Map<String, Any> = emptyMap(),
  body: T?,
): RequestConfig =
  RequestConfig(
    method = method,
    pathSegments = pathSegments,
    isRead = isRead,
    headers = headers,
    query = query,
    body = body?.let { RequestBody(it, bodyType = typeInfo<T>()) },
  )

/** Represents a request body with it type. */
public data class RequestBody(
  val body: Any? = null,
  val bodyType: TypeInfo,
)

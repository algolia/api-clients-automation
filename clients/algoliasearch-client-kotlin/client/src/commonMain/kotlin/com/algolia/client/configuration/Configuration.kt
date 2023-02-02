package com.algolia.client.configuration

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.logging.*

/** Configuration used by a client. */
public interface Configuration {

  /** The timeout for each request when performing write operations (POST, PUT ..). */
  public val writeTimeout: Long

  /** The timeout for each request when performing read operations (GET). */
  public val readTimeout: Long

  /** [LogLevel] to display in the console. */
  public val logLevel: LogLevel

  /** List of hosts and back-up host used to perform a custom retry logic. */
  public val hosts: List<Host>

  /** An optional [HttpClientConfig<*>] used by Ktor for advanced HttpClient httpClientConfig. */
  public val httpClientConfig: ((HttpClientConfig<*>) -> Unit)?

  /** An optional [HttpClientEngine] to specify which HttpEngine should be used by Ktor. */
  public val engine: HttpClientEngine?

  /** The [HttpClient] used by Ktor to perform http request. */
  public val httpClient: HttpClient

  /** Default headers that should be applied to every request. */
  public val defaultHeaders: Map<String, String>?

  public val logger: Logger
}

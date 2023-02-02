package com.algolia.client.configuration

import com.algolia.client.transport.Requester
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.logging.*

/** Custom client configuration. */
public class ClientOptions(

  /** The timeout for each request when performing write operations. */
  public val writeTimeout: Long = 30000L,

  /** The timeout for each request when performing read operations. */
  public val readTimeout: Long = 30000L,

  /** [LogLevel] to display in the console. */
  public val logLevel: LogLevel = LogLevel.NONE,

  /** [Logger] to use for logs. */
  public val logger: Logger = Logger.DEFAULT,

  /** Custom list of hosts and back-up host used to perform a custom retry logic. */
  public val hosts: List<Host>? = null,

  /** Optional default headers that should be applied to every request. */
  public val defaultHeaders: Map<String, String>? = null,

  /** An optional [HttpClientEngine] to specify which HttpEngine should be used by Ktor. */
  public val engine: HttpClientEngine? = null,

  /** An optional [HttpClientConfig] used by Ktor for advanced HttpClient configuration. */
  public val httpClientConfig: ((HttpClientConfig<*>) -> Unit)? = null,

  /** Custom Http Requester. */
  public val requester: Requester? = null,

  /**  */
  public val algoliaAgentSegments: List<AgentSegment> = emptyList(),
)

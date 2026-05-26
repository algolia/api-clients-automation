package com.algolia.client.configuration

import kotlin.time.Duration

/**
 * Configuration options for the ingestion transporter used by the `*WithTransformation` helpers on
 * [com.algolia.client.api.SearchClient].
 *
 * When supplied via [ClientOptions.transformationOptions] or [SearchClient.setTransformationOptions], an
 * [com.algolia.client.api.IngestionClient] is eagerly built using Ingestion API defaults (25 s
 * connect/read/write timeouts, region-derived hosts, no compression). Only the fields explicitly set on
 * this object override those defaults; the parent search [ClientOptions] is never forwarded to the
 * ingestion transporter.
 *
 * @param region Algolia region for the Ingestion API (e.g. `"us"` or `"eu"`). Required.
 * @param connectTimeout Optional connect timeout for the ingestion transporter.
 * @param readTimeout Optional read timeout for the ingestion transporter.
 * @param writeTimeout Optional write timeout for the ingestion transporter.
 * @param hosts Optional custom list of hosts for the ingestion transporter.
 * @param defaultHeaders Optional default headers applied to every ingestion request.
 */
public data class TransformationOptions(
  public val region: String,
  public val connectTimeout: Duration? = null,
  public val readTimeout: Duration? = null,
  public val writeTimeout: Duration? = null,
  public val hosts: List<Host>? = null,
  public val defaultHeaders: Map<String, String>? = null,
) {
  init {
    require(region.isNotBlank()) {
      "`region` is required in `transformationOptions`. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
    }
  }
}

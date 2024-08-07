/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceShopify
 *
 * @param shopURL URL of the Shopify store.
 * @param featureFlags Feature flags for the Shopify source.
 */
@Serializable
public data class SourceShopify(

  /** URL of the Shopify store. */
  @SerialName(value = "shopURL") val shopURL: String,

  /** Feature flags for the Shopify source. */
  @SerialName(value = "featureFlags") val featureFlags: JsonObject? = null,
) : SourceInput

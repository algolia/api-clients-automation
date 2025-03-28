/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Widgets returned from any rules that are applied to the current search.
 *
 * @param banners Banners defined in the Merchandising Studio for a given search.
 */
@Serializable
public data class Widgets(

  /** Banners defined in the Merchandising Studio for a given search. */
  @SerialName(value = "banners") val banners: List<Banner>? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * TrendingItems
 *
 * @param facetName Facet attribute. To be used in combination with `facetValue`. If specified, only recommendations matching the facet filter will be returned.
 * @param facetValue Facet value. To be used in combination with `facetName`. If specified, only recommendations matching the facet filter will be returned.
 * @param model
 * @param fallbackParameters
 */
@Serializable
public data class TrendingItems(

  /** Facet attribute. To be used in combination with `facetValue`. If specified, only recommendations matching the facet filter will be returned.  */
  @SerialName(value = "facetName") val facetName: String,

  /** Facet value. To be used in combination with `facetName`. If specified, only recommendations matching the facet filter will be returned.  */
  @SerialName(value = "facetValue") val facetValue: String,

  @SerialName(value = "model") val model: TrendingItemsModel,

  @SerialName(value = "fallbackParameters") val fallbackParameters: SearchParamsObject? = null,
)

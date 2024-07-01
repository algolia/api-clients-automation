/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Extra data that can be used in the search UI.  You can use this to control aspects of your search UI, such as, the order of facet names and values without changing your frontend code.
 *
 * @param facetOrdering
 * @param redirect
 */
@Serializable
public data class RenderingContent(

  @SerialName(value = "facetOrdering") val facetOrdering: FacetOrdering? = null,

  @SerialName(value = "redirect") val redirect: RedirectURL? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

/**
 * - `default`: perform a search query - `facet` [searches for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
 */
@Serializable
public enum class SearchTypeDefault(public val value: kotlin.String) {

  @SerialName(value = "default")
  Default("default");

  override fun toString(): kotlin.String = value
}

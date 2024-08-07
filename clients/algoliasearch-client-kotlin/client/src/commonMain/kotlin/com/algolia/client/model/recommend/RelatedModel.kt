/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*

/**
 * Related products or similar content model.  This model recommends items that are similar to the item with the ID `objectID`. Similarity is determined from the user interactions and attributes.
 */
@Serializable
public enum class RelatedModel(public val value: kotlin.String) {

  @SerialName(value = "related-products")
  RelatedProducts("related-products");

  override fun toString(): kotlin.String = value
}

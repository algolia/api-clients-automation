/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.insights

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * ObjectDataAfterSearch
 *
 * @param queryID Unique identifier for a search query, used to track purchase events with multiple records that originate from different searches.
 * @param price
 * @param quantity Quantity of a product that has been purchased or added to the cart. The total purchase value is the sum of `quantity` multiplied with the `price` for each purchased item.
 * @param discount
 */
@Serializable
public data class ObjectDataAfterSearch(

  /** Unique identifier for a search query, used to track purchase events with multiple records that originate from different searches. */
  @SerialName(value = "queryID") val queryID: String? = null,

  @SerialName(value = "price") val price: Price? = null,

  /** Quantity of a product that has been purchased or added to the cart. The total purchase value is the sum of `quantity` multiplied with the `price` for each purchased item.  */
  @SerialName(value = "quantity") val quantity: Int? = null,

  @SerialName(value = "discount") val discount: Discount? = null,
)

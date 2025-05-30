/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceUpdateCommercetools
 *
 * @param storeKeys
 * @param locales Locales for your commercetools stores.
 * @param url
 * @param fallbackIsInStockValue Whether a fallback value is stored in the Algolia record if there's no inventory information about the product.
 * @param productQueryPredicate Predicate to filter out specific products when indexing. For more information, see [Query Predicate](https://docs.commercetools.com/api/predicates/query).
 * @param customFields
 */
@Serializable
public data class SourceUpdateCommercetools(

  @SerialName(value = "storeKeys") val storeKeys: List<String>? = null,

  /** Locales for your commercetools stores. */
  @SerialName(value = "locales") val locales: List<String>? = null,

  @SerialName(value = "url") val url: String? = null,

  /** Whether a fallback value is stored in the Algolia record if there's no inventory information about the product.  */
  @SerialName(value = "fallbackIsInStockValue") val fallbackIsInStockValue: Boolean? = null,

  /** Predicate to filter out specific products when indexing. For more information, see [Query Predicate](https://docs.commercetools.com/api/predicates/query).  */
  @SerialName(value = "productQueryPredicate") val productQueryPredicate: String? = null,

  @SerialName(value = "customFields") val customFields: CommercetoolsCustomFields? = null,
) : SourceUpdateInput

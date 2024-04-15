/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceUpdateShopify
 *
 * @param collectionIDIndexing Whether to index collection IDs.   If your store has `has_collection_search_page` set to true, collection IDs will be indexed even if `collectionIDIndexing` is false.
 * @param increaseProductCollectionLimit Whether to increase the number of indexed collections per product. If true, Algolia indexes 200 collections per product. If false, 100 collections per product are indexed.
 * @param defaultPriceRatioAsOne Whether to set the default price ratio to 1 if no sale price is present.  The price ratio is determined by the ratio: `sale_price` / `regular_price`. If no sale price is present, the price ratio would be 0. If `defaultPriceRatioAsOne` is true, the price ratio is indexed as 1 instead.
 * @param excludeOOSVariantsForPriceAtTRS Whether to exclude out-of-stock variants when determining the `max_variant_price` and `min_variant_price` attributes.
 * @param includeVariantsInventory Whether to include an inventory with every variant for every product record.
 * @param hasCollectionSearchPage Whether to include collection IDs and handles in the product records.
 * @param productNamedTags Whether to convert tags on products to named tags.  To learn more, see [Named tags](https://www.algolia.com/doc/integration/shopify/sending-and-managing-data/named-tags).
 */
@Serializable
public data class SourceUpdateShopify(

  /** Whether to index collection IDs.   If your store has `has_collection_search_page` set to true, collection IDs will be indexed even if `collectionIDIndexing` is false.   */
  @SerialName(value = "collectionIDIndexing") val collectionIDIndexing: Boolean? = null,

  /** Whether to increase the number of indexed collections per product. If true, Algolia indexes 200 collections per product. If false, 100 collections per product are indexed.  */
  @SerialName(value = "increaseProductCollectionLimit") val increaseProductCollectionLimit: Boolean? = null,

  /** Whether to set the default price ratio to 1 if no sale price is present.  The price ratio is determined by the ratio: `sale_price` / `regular_price`. If no sale price is present, the price ratio would be 0. If `defaultPriceRatioAsOne` is true, the price ratio is indexed as 1 instead.  */
  @SerialName(value = "defaultPriceRatioAsOne") val defaultPriceRatioAsOne: Boolean? = null,

  /** Whether to exclude out-of-stock variants when determining the `max_variant_price` and `min_variant_price` attributes.  */
  @SerialName(value = "excludeOOSVariantsForPriceAtTRS") val excludeOOSVariantsForPriceAtTRS: Boolean? = null,

  /** Whether to include an inventory with every variant for every product record.  */
  @SerialName(value = "includeVariantsInventory") val includeVariantsInventory: Boolean? = null,

  /** Whether to include collection IDs and handles in the product records.  */
  @SerialName(value = "hasCollectionSearchPage") val hasCollectionSearchPage: Boolean? = null,

  /** Whether to convert tags on products to named tags.  To learn more, see [Named tags](https://www.algolia.com/doc/integration/shopify/sending-and-managing-data/named-tags).  */
  @SerialName(value = "productNamedTags") val productNamedTags: Boolean? = null,
) : SourceUpdateInput

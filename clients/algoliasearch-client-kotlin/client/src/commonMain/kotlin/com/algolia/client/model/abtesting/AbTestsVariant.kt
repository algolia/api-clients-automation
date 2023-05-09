/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.abtesting

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * AbTestsVariant
 *
 * @param index The index performing the A/B test.
 * @param trafficPercentage The traffic percentage for the A/B test.
 * @param description The A/B test description.
 */
@Serializable
public data class AbTestsVariant(

  /** The index performing the A/B test. */
  @SerialName(value = "index") val index: String,

  /** The traffic percentage for the A/B test. */
  @SerialName(value = "trafficPercentage") val trafficPercentage: Int,

  /** The A/B test description. */
  @SerialName(value = "description") val description: String? = null,
) : AddABTestsVariant

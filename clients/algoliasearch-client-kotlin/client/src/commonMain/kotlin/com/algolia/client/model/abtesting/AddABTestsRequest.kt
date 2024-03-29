/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.abtesting

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * AddABTestsRequest
 *
 * @param name A/B test name.
 * @param variants A/B test variants.
 * @param endAt End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
 */
@Serializable
public data class AddABTestsRequest(

  /** A/B test name. */
  @SerialName(value = "name") val name: String,

  /** A/B test variants. */
  @SerialName(value = "variants") val variants: List<AddABTestsVariant>,

  /** End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. */
  @SerialName(value = "endAt") val endAt: String,
)

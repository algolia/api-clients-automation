/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * AroundPrecisionFromValueInner
 *
 * @param from
 * @param `value`
 */
@Serializable
public data class AroundPrecisionFromValueInner(

  @SerialName(value = "from") val from: Int? = null,

  @SerialName(value = "value") val `value`: Int? = null,
)

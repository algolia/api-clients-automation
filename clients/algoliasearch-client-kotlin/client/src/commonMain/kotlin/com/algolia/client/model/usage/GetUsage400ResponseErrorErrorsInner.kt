/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.usage

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetUsage400ResponseErrorErrorsInner
 *
 * @param message
 * @param code
 * @param line
 * @param position
 */
@Serializable
public data class GetUsage400ResponseErrorErrorsInner(

  @SerialName(value = "message") val message: String,

  @SerialName(value = "code") val code: String? = null,

  @SerialName(value = "line") val line: Int? = null,

  @SerialName(value = "position") val position: Int? = null,
)

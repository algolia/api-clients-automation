/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.usage

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetUsage400Response
 *
 * @param error
 */
@Serializable
public data class GetUsage400Response(

  @SerialName(value = "error") val error: GetUsage400ResponseError,
)

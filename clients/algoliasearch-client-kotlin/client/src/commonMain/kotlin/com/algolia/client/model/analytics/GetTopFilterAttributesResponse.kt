/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetTopFilterAttributesResponse
 *
 * @param attributes A list of attributes with their count.
 */
@Serializable
public data class GetTopFilterAttributesResponse(

  /** A list of attributes with their count. */
  @SerialName(value = "attributes") val attributes: List<GetTopFilterAttribute>,
)

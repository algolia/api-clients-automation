/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetClickPositionsResponse
 *
 * @param positions Click positions.
 */
@Serializable
public data class GetClickPositionsResponse(

  /** Click positions. */
  @SerialName(value = "positions") val positions: List<ClickPosition>,
)

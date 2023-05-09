/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * RemoveUserIdResponse
 *
 * @param deletedAt Date of deletion (ISO-8601 format).
 */
@Serializable
public data class RemoveUserIdResponse(

  /** Date of deletion (ISO-8601 format). */
  @SerialName(value = "deletedAt") val deletedAt: String,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * AddApiKeyResponse
 *
 * @param key API key.
 * @param createdAt Date and time when the object was created, in RFC 3339 format.
 */
@Serializable
public data class AddApiKeyResponse(

  /** API key. */
  @SerialName(value = "key") val key: String,

  /** Date and time when the object was created, in RFC 3339 format. */
  @SerialName(value = "createdAt") val createdAt: String,
)

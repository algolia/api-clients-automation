/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * The payload when creating a destination.
 *
 * @param type
 * @param name An human readable name describing the object.
 * @param input
 * @param authenticationID The authentication UUID.
 */
@Serializable
public data class DestinationCreate(

  @SerialName(value = "type") val type: DestinationType,

  /** An human readable name describing the object. */
  @SerialName(value = "name") val name: String,

  @SerialName(value = "input") val input: DestinationInput,

  /** The authentication UUID. */
  @SerialName(value = "authenticationID") val authenticationID: String? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceUpdate
 *
 * @param name
 * @param input
 * @param authenticationID The authentication UUID.
 */
@Serializable
public data class SourceUpdate(

  @SerialName(value = "name") val name: String? = null,

  @SerialName(value = "input") val input: SourceUpdateInput? = null,

  /** The authentication UUID. */
  @SerialName(value = "authenticationID") val authenticationID: String? = null,
)

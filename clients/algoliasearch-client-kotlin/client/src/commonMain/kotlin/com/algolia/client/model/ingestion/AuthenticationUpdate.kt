/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Payload to partially update an Authentication.
 *
 * @param type
 * @param name An human readable name describing the object.
 * @param platform
 * @param input
 */
@Serializable
public data class AuthenticationUpdate(

  @SerialName(value = "type") val type: AuthenticationType? = null,

  /** An human readable name describing the object. */
  @SerialName(value = "name") val name: String? = null,

  @SerialName(value = "platform") val platform: Platform? = null,

  @SerialName(value = "input") val input: AuthInputPartial? = null,
)

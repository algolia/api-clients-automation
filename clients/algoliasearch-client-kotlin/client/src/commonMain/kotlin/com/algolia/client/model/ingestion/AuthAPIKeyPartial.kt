/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Authentication input used for token credentials.
 *
 * @param key
 */
@Serializable
public data class AuthAPIKeyPartial(

  @SerialName(value = "key") val key: String? = null,
) : AuthInputPartial

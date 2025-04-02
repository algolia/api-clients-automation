/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Transformation
 *
 * @param transformationID Universally unique identifier (UUID) of a transformation.
 * @param code The source code of the transformation.
 * @param name The uniquely identified name of your transformation.
 * @param createdAt Date of creation in RFC 3339 format.
 * @param authenticationIDs The authentications associated with the current transformation.
 * @param description A descriptive name for your transformation of what it does.
 * @param owner Owner of the resource.
 * @param updatedAt Date of last update in RFC 3339 format.
 */
@Serializable
public data class Transformation(

  /** Universally unique identifier (UUID) of a transformation. */
  @SerialName(value = "transformationID") val transformationID: String,

  /** The source code of the transformation. */
  @SerialName(value = "code") val code: String,

  /** The uniquely identified name of your transformation. */
  @SerialName(value = "name") val name: String,

  /** Date of creation in RFC 3339 format. */
  @SerialName(value = "createdAt") val createdAt: String,

  /** The authentications associated with the current transformation. */
  @SerialName(value = "authenticationIDs") val authenticationIDs: List<String>? = null,

  /** A descriptive name for your transformation of what it does. */
  @SerialName(value = "description") val description: String? = null,

  /** Owner of the resource. */
  @SerialName(value = "owner") val owner: String? = null,

  /** Date of last update in RFC 3339 format. */
  @SerialName(value = "updatedAt") val updatedAt: String? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Transformation
 *
 * @param transformationID Universally unique identifier (UUID) of a transformation.
 * @param code It is deprecated. Use the `input` field with proper `type` instead to specify the transformation code.
 * @param name The uniquely identified name of your transformation.
 * @param createdAt Date of creation in RFC 3339 format.
 * @param updatedAt Date of last update in RFC 3339 format.
 * @param authenticationIDs The authentications associated with the current transformation.
 * @param type
 * @param input
 * @param description A descriptive name for your transformation of what it does.
 * @param owner Owner of the resource.
 */
@Serializable
public data class Transformation(

  /** Universally unique identifier (UUID) of a transformation. */
  @SerialName(value = "transformationID") val transformationID: String,

  /** It is deprecated. Use the `input` field with proper `type` instead to specify the transformation code. */
  @Deprecated(message = "This property is deprecated.")
  @SerialName(value = "code") val code: String,

  /** The uniquely identified name of your transformation. */
  @SerialName(value = "name") val name: String,

  /** Date of creation in RFC 3339 format. */
  @SerialName(value = "createdAt") val createdAt: String,

  /** Date of last update in RFC 3339 format. */
  @SerialName(value = "updatedAt") val updatedAt: String,

  /** The authentications associated with the current transformation. */
  @SerialName(value = "authenticationIDs") val authenticationIDs: List<String>? = null,

  @SerialName(value = "type") val type: TransformationType? = null,

  @SerialName(value = "input") val input: TransformationInput? = null,

  /** A descriptive name for your transformation of what it does. */
  @SerialName(value = "description") val description: String? = null,

  /** Owner of the resource. */
  @SerialName(value = "owner") val owner: String? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceDocker
 *
 * @param image Name of the connector.
 * @param configuration Configuration of the spec.
 */
@Serializable
public data class SourceDocker(

  /** Name of the connector. */
  @SerialName(value = "image") val image: String,

  /** Configuration of the spec. */
  @SerialName(value = "configuration") val configuration: JsonObject,
) : SourceInput

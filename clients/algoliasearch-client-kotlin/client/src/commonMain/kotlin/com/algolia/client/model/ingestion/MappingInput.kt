/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Transformations to apply to the source, serialized as a JSON string.
 *
 * @param format
 * @param actions
 */
@Serializable
public data class MappingInput(

  @SerialName(value = "format") val format: MappingFormatSchema,

  @SerialName(value = "actions") val actions: List<MappingKitAction>,
)

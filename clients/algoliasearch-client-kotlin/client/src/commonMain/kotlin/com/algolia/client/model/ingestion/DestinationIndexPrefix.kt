/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * DestinationIndexPrefix
 *
 * @param indexPrefix The prefix of the final index name.
 */
@Serializable
public data class DestinationIndexPrefix(

  /** The prefix of the final index name. */
  @SerialName(value = "indexPrefix") val indexPrefix: String,
) : DestinationInput

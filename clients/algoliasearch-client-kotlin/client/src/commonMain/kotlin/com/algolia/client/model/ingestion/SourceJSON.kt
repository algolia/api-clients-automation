/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceJSON
 *
 * @param url URL of the file.
 * @param uniqueIDColumn Name of a column that contains a unique ID which will be used as `objectID` in Algolia.
 * @param method
 */
@Serializable
public data class SourceJSON(

  /** URL of the file. */
  @SerialName(value = "url") val url: String,

  /** Name of a column that contains a unique ID which will be used as `objectID` in Algolia. */
  @SerialName(value = "uniqueIDColumn") val uniqueIDColumn: String? = null,

  @SerialName(value = "method") val method: MethodType? = null,
) : SourceInput, SourceUpdateInput

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Record to promote.
 *
 * @param objectID Unique record identifier.
 * @param position Position in the search results where you want to show the promoted records.
 */
@Serializable
public data class PromoteObjectID(

  /** Unique record identifier. */
  @SerialName(value = "objectID") val objectID: String,

  /** Position in the search results where you want to show the promoted records. */
  @SerialName(value = "position") val position: Int,
) : Promote

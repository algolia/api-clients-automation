/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.monitoring

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * IncidentsInner
 *
 * @param t Timestamp, measured in milliseconds since the Unix epoch.
 * @param v
 */
@Serializable
public data class IncidentsInner(

  /** Timestamp, measured in milliseconds since the Unix epoch. */
  @SerialName(value = "t") val t: Long? = null,

  @SerialName(value = "v") val v: Incident? = null,
)

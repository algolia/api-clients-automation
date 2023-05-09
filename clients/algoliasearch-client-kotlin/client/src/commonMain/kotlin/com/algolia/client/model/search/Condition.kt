/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Condition
 *
 * @param pattern Query pattern syntax.
 * @param anchoring
 * @param alternatives Whether the pattern matches on plurals, synonyms, and typos.
 * @param context Rule context format: [A-Za-z0-9_-]+).
 */
@Serializable
public data class Condition(

  /** Query pattern syntax. */
  @SerialName(value = "pattern") val pattern: String? = null,

  @SerialName(value = "anchoring") val anchoring: Anchoring? = null,

  /** Whether the pattern matches on plurals, synonyms, and typos. */
  @SerialName(value = "alternatives") val alternatives: Boolean? = null,

  /** Rule context format: [A-Za-z0-9_-]+). */
  @SerialName(value = "context") val context: String? = null,
)

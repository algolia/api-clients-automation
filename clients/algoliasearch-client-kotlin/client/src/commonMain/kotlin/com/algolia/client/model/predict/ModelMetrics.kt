/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.predict

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * ModelMetrics
 *
 * @param precision
 * @param recall
 * @param mrr
 * @param coverage
 * @param f1Score
 * @param updatedAt Date of last update (ISO-8601 format).
 */
@Serializable
public data class ModelMetrics(

  @SerialName(value = "precision") val precision: Double? = null,

  @SerialName(value = "recall") val recall: Double? = null,

  @SerialName(value = "mrr") val mrr: Double? = null,

  @SerialName(value = "coverage") val coverage: Double? = null,

  @SerialName(value = "f1_score") val f1Score: Double? = null,

  /** Date of last update (ISO-8601 format). */
  @SerialName(value = "updatedAt") val updatedAt: String? = null,
)

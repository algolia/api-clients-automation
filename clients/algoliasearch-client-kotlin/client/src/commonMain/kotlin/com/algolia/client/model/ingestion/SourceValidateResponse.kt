/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SourceValidateResponse
 *
 * @param message a message describing the outcome of a validate run.
 * @param runID Universally unique identifier (UUID) of a task run.
 * @param `data` depending on the source type, the validation returns sampling data of your source (JSON, CSV, BigQuery).
 * @param events in case of error, observability events will be added to the response, if any.
 */
@Serializable
public data class SourceValidateResponse(

  /** a message describing the outcome of a validate run. */
  @SerialName(value = "message") val message: String,

  /** Universally unique identifier (UUID) of a task run. */
  @SerialName(value = "runID") val runID: String? = null,

  /** depending on the source type, the validation returns sampling data of your source (JSON, CSV, BigQuery). */
  @SerialName(value = "data") val `data`: List<JsonObject>? = null,

  /** in case of error, observability events will be added to the response, if any. */
  @SerialName(value = "events") val events: List<Event>? = null,
)

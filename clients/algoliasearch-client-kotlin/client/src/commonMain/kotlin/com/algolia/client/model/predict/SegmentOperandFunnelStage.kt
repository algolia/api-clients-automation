/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.predict

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Operand for funnel stage model predictions.
 *
 * @param name
 * @param filters
 */
@Serializable
public data class SegmentOperandFunnelStage(

  @SerialName(value = "name") val name: String,

  @SerialName(value = "filters") val filters: List<SegmentFunnelStageFilter>,
) : SegmentParentConditionOperands, SegmentChildConditionOperands

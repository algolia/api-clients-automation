/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * The trigger information of a task of type `onDemand`.
 *
 * @param type
 */
@Serializable
public data class OnDemandTriggerInput(

  @SerialName(value = "type") val type: OnDemandTriggerType,
) : TaskCreateTrigger

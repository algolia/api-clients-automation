/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Describes how a destination object should be resolved by means of applying a set of directives.
 *
 * @param enabled Whether this action has any effect.
 * @param trigger Condition which must be satisfied to apply the action. If this evaluates to false, the action is not applied, and the process attempts to apply the next action, if any.
 * @param fieldDirectives
 * @param id ID to uniquely identify this action.
 */
@Serializable
public data class MappingKitAction(

  /** Whether this action has any effect. */
  @SerialName(value = "enabled") val enabled: Boolean,

  /** Condition which must be satisfied to apply the action. If this evaluates to false, the action is not applied, and the process attempts to apply the next action, if any. */
  @SerialName(value = "trigger") val trigger: String,

  @SerialName(value = "fieldDirectives") val fieldDirectives: List<MappingFieldDirective>,

  /** ID to uniquely identify this action. */
  @SerialName(value = "id") val id: String? = null,
)
